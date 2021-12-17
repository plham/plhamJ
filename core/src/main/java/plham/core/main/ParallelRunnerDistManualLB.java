package plham.core.main;

import static apgas.Constructs.*;
import static plham.core.main.log.LogConstants.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiConsumer;

import apgas.Place;
import apgas.util.PlaceLocalObject;
import cassia.util.JSON.Value;
import cassia.util.random.RandomPermutation;
import handist.collections.Bag;
import handist.collections.Chunk;
import handist.collections.ChunkedList;
import handist.collections.LongRange;
import handist.collections.RangedList;
import handist.collections.RangedListView;
import handist.collections.dist.CachableArray;
import handist.collections.dist.CollectiveMoveManager;
import handist.collections.dist.DistBag;
import handist.collections.dist.DistChunkedList;
import handist.collections.dist.DistCol;
import handist.collections.dist.DistLog;
import handist.collections.dist.DistMap;
import handist.collections.dist.DistMultiMap;
import handist.collections.dist.LongRangeDistribution;
import handist.collections.dist.TeamedPlaceGroup;
import handist.collections.util.SavedLog;
import mpi.MPI;
import plham.core.Agent;
import plham.core.Event;
import plham.core.Market;
import plham.core.Market.AgentUpdate;
import plham.core.Market.MarketUpdate;
import plham.core.Order;
import plham.core.OutputCollector;
import plham.core.SimulationOutput;
import plham.core.SimulationOutput.SimulationStage;
import plham.core.main.Simulator.Session;
import plham.core.util.AgentAllocManager;
import plham.core.util.Random;

/**
 * This class is a variation of {@link ParallelRunnerDist} which performs some
 * manual load balancing of agents across places [1..n].
 * <p>
 * This manual adjustment is done every "n" iterations, the value of "n" being
 * set through property {@value #LOAD_BALANCE_PERIOD_DEFAULT}.
 *
 * @author Patrick Finnerty
 *
 */
public class ParallelRunnerDistManualLB extends PlaceLocalObject {

    /**
     * This class is used for compatibility with sequential version of Market. As
     * the markets assumes agents in the same place, this class gather the
     * information and pack them into DistMultiMap.
     *
     */
    static class AgentUpdateProxy extends Agent.Proxy {
        /** Serial Version UID */
        private static final long serialVersionUID = -206816526099531233L;
        DistMultiMap<Long, Market.AgentUpdate> cOrders;

        AgentUpdateProxy(long id, DistMultiMap<Long, Market.AgentUpdate> cOrders) {
            super(id);
            this.cOrders = cOrders;
        }

        @Override
        public void executeUpdate(Market.AgentUpdate update) {
            cOrders.put1(update.agentId, update);
        }
    }

    /**
     * Class in charge of collecting the distributed entries during the various
     * phases during which an user defined output is made.
     *
     * @author Patrick Finnerty
     * @see ParallelRunnerDistManualLB#makeSimulationOutput(SimulationStage)
     * @see ParallelRunnerDistManualLB#makeSessionOutput(Session, SimulationStage)
     * @see ParallelRunnerDistManualLB#makeWithPrintOutput(Session, SimulationStage)
     */
    private class DistributedOutputCollector implements OutputCollector, Serializable {
        private static final long serialVersionUID = 5777744274622700033L;
        private final DistMap<String, List<String>> map;

        /**
         * Constructor
         *
         * @param dmap underlying distributed map used to collect and relocated logged
         *             entries during the simulation
         */
        public DistributedOutputCollector(DistMap<String, List<String>> dmap) {
            map = dmap;
        }

        @Override
        public void clear() {
            map.clear();
        }

        @Override
        public void forEach(BiConsumer<String, List<String>> func) {
            map.forEach(func);
        }

        @Override
        public List<String> getLog(String key) {
            return map.get(key);
        }

        @Override
        public void log(String topic, Object o) {
            List<String> values;
            if (!map.containsKey(topic)) {
                values = new ArrayList<>();
                map.put(topic, values);
            } else {
                values = map.get(topic);
            }
            values.add(o.toString());
        }

        @Override
        public void print(String message) {
            // System.out.println(here().toString() +":"+message);
            System.out.println(message);
        }

        @Override
        public List<String> removeLog(String key) {
            final List<String> toReturn = map.get(key);
            map.delete(key);
            return toReturn;
        }

        /**
         * Relocates all logged entries onto the master of the simulation so that the
         * {@link SimulationOutput#postProcess(OutputCollector, SimulationStage)} can be
         * called with all the needed information.
         */
        public void transferLogsToMaster() {
            map.team().gather(master);
        }
    }

    /**
     * Allocation manager in charge of deciding where the agents are initially
     * created and recording their presence in the relevant collection
     */
    static class GlbAllocManager extends AgentAllocManager {
        ChunkedList<Agent> arbitrageurs = new ChunkedList<>();
        ArrayList<LongRange> arbRanges = new ArrayList<>();
        public String defaultScheduleType = "\"short\"";
        /** indicates is this process is the master of the simulation */
        transient final boolean isMaster;

        ArrayList<LongRange> longRanges = new ArrayList<>();

        // public String defaultScheduleType = "\"long\"";
        TreeSet<LongRange> myRanges = new TreeSet<>();
        /** Group of places on which the simulation is computed */
        transient final TeamedPlaceGroup placeGroup;
        /** All agents contained in this collection */
        transient final DistCol<Agent> allAgents;
        /** short-term and long-term agents */
        transient final DistChunkedList<Agent> sAgents, lAgents;
        ArrayList<LongRange> shortRanges = new ArrayList<>();
        /** Reference to local simulator member, to be set manually */
        transient Simulator sim;

        private GlbAllocManager(TeamedPlaceGroup pg, Place master, DistCol<Agent> allAgentsCol,
                DistChunkedList<Agent> shortAgents, DistChunkedList<Agent> longAgents) {
            super();
            placeGroup = pg;
            isMaster = here() == master;

            allAgents = allAgentsCol;
            sAgents = shortAgents;
            lAgents = longAgents;
        }

        @Override
        public void finalSetup(Simulator sim) {
            sim.hifreqAgents = arbitrageurs;
        }

        // return the assigned range for the worker (place)
        LongRange getAssignedRange(LongRange targetRange) {
            final LongRange floor = myRanges.floor(targetRange);
            if (floor != null && floor.isOverlapped(targetRange)) {
                return floor;
            }
            final LongRange ceil = myRanges.ceiling(targetRange);
            if (ceil != null && ceil.isOverlapped(targetRange)) {
                return ceil;
            }
            return null;
        }

        @Override
        public Iterable<Agent> getContainer() {
            return allAgents;
        }

        @Override
        public RangedList<Agent> getRangedList(Value config, LongRange range, String name, SimulatorFactory factory) {
            try {
                if (isMaster) {
                    if (factory.judgeHFTorNot(name)) {
                        final Chunk<Agent> chunk = new Chunk<>(range);
                        arbitrageurs.add(chunk);
                        allAgents.add(chunk);
                        return chunk;
                    } else {
                        return RangedListView.emptyView();
                    }
                } else {
                    if (factory.judgeHFTorNot(name)) {
                        return RangedListView.emptyView();
                    } else {
                        final String classType = config.getOrElse("schedule", defaultScheduleType).toString();

                        // boolean longType = classType.equals("longTerm");
                        final LongRange myrange = getAssignedRange(range);
                        if (myrange == null) {
                            return RangedListView.emptyView();
                        }
                        final Chunk<Agent> chunk = new Chunk<>(myrange);
                        allAgents.add(chunk);
                        if (classType.startsWith("short")) {
                            sAgents.add(chunk);
                        } else if (classType.startsWith("long")) {
                            lAgents.add(chunk);
                        } else {
                            throw new IllegalArgumentException("Unknown schedule option:" + classType);
                        }
                        return chunk;
                    }
                }
            } catch (final Exception e) {
                throw new RuntimeException("put chunk duplicated!" + here());
            }
        }

        public boolean hasLong() {
            return longRanges != null && !longRanges.isEmpty();
        }

        @Override
        public void registerRange(Value config, LongRange range, String name, SimulatorFactory factory) {
            final String classType = config.getOrElse("schedule", defaultScheduleType).toString();
            if (factory.judgeHFTorNot(name)) {
                if (arbRanges == null) {
                    arbRanges = new ArrayList<>();
                }
                arbRanges.add(range);
                // System.err.println("ARB:" + range);
            } else if (classType.startsWith("short")) { // Resolve long/short using className
                if (shortRanges == null) {
                    shortRanges = new ArrayList<>();
                }
                shortRanges.add(range);
                // System.err.println("short:" + range);
            } else if (classType.startsWith("long")) {
                if (longRanges == null) {
                    longRanges = new ArrayList<>();
                }
                longRanges.add(range);
                // System.err.println("long:" + range);
            } else {
                throw new IllegalArgumentException("Unknown schedule option:" + classType);
            }
        }

        @Override
        public void scanDone() {
            // Determine how agents are distributed on worker places.
            if (myRanges == null) {
                myRanges = new TreeSet<>();
            }
            if (isMaster) {
                for (final LongRange r : arbRanges) {
                    myRanges.add(r);
                }
            } else {
                final int numWorkers = placeGroup.size() - 1;
                splitAndGetMine(shortRanges, numWorkers);
                splitAndGetMine(longRanges, numWorkers);
            }
        }

        @Override
        public void setTotalCount(long size) {
            sim.numAgents = size;
        }

        public void splitAndGetMine(List<LongRange> ranges, int numWorkers) {
            if (ranges == null) {
                return;
            }
            if (ranges.isEmpty()) {
                return;
            }
            final List<List<LongRange>> split = LongRange.splitList(numWorkers, ranges);
            final List<LongRange> mine = split.get(placeGroup.rank() - 1);
            for (final LongRange r : mine) {
                if (r.size() > 0) {
                    myRanges.add(r);
                }
            }
        }

        @Override
        public boolean use2scan() {
            return true;
        }
    }

    /**
     * Randomized order used to sort the Orders received on master
     */
    static class Ox implements Comparable<Ox> {
        long agentid;

        List<Order> orders;

        long priority;

        public Ox(long priority, long agentid, List<Order> orders) {
            this.priority = priority;
            this.agentid = agentid;
            this.orders = orders;
        }

        @Override
        public int compareTo(Ox o) {
            final int result = Long.compare(priority, o.priority);
            if (result == 0) {
                Long.compare(agentid, o.agentid);
            }
            return result;
        }

        @Override
        public String toString() {
            return " " + agentid;
        }
    }

    /**
     * Property to set to activate manual load balancing every "n" round. Setting
     * the property to 0 or any negative value deactivates any load balancing. If
     * the property is not set when calling the program, the default value
     * {@value #LOAD_BALANCE_PERIOD_DEFAULT} is used.
     */
    public static final String LOAD_BALANCE_PERIOD = "plham_runner_dist.lbperiod";

    /**
     * Default value for {@value #LOAD_BALANCE_PERIOD}, disables any load balancing
     */
    public static final String LOAD_BALANCE_PERIOD_DEFAULT = "0";

    /**
     * Property used to define the CSV file to which the evolution of the
     * distribution of agents over time will be saved. If it is left undefined or no
     * load balance is made, then no information is dumped.
     */
    public static final String LOAD_BALANCE_DUMPFILE = "plham_runner_dist.lbdump";

    /** Serial Version UID */
    private static final long serialVersionUID = -5954081821861048344L;

    /**
     * Property to activate debugging traces related to the load balance strategy.
     * Is set to {@code false} by default.
     */
    public static final String LOAD_BALANCE_DEBUGTRACES = "plham_runner_dist.lbdebugtraces";

    /**
     * Property used to define the load balance strategy to use by this runner.
     * Possible values that can be set by the user through option
     * <em>-Dplham_runner_dist.lbstrategy=opt</em> are:
     * <ul>
     * <li>{@value #LOAD_BALANCE_STRATEGY_NONE} (default) does not perform any agent
     * relocation
     * <li>{@value #LOAD_BALANCE_STRATEGY_LEVELEXTREMES} takes work from the most
     * loaded host and relocates it to the least loaded host
     * </ul>
     */
    public static final String LOAD_BALANCE_STRATEGY = "plham_runner_dist.lbstrategy";

    /**
     * Possible option for property {@link #LOAD_BALANCE_STRATEGY}
     * <p>
     * Consists in unloading the most-loaded unto the least-loaded host
     */
    public static final String LOAD_BALANCE_STRATEGY_LEVELEXTREMES = "levelextremes";

    /**
     * Possible option and default value for property {@link #LOAD_BALANCE_STRATEGY}
     * <p>
     * Does not perform any load balance or agent relocation
     */
    public static final String LOAD_BALANCE_STRATEGY_NONE = "none";

    /**
     * Default value for property {@link #LOAD_BALANCE_STRATEGY}
     */
    private static final String LOAD_BALANCE_STRATEGY_DEFAULT = LOAD_BALANCE_STRATEGY_NONE;
    /**
     * Minimum number of agents to relocate for the relocation to actually take
     * place.
     */
    private static final double MINIMUM_AGENTS_RELOCATED = 10;

    /**
     * Dummy load balancing strategy used to test the validity of the
     * implementation.
     * <p>
     * This implementation consists in every host sending the agents it holds to the
     * "h+1" host (last host sending to host 1). This is not a real load balance
     * strategy and is meant to be used as a test.
     */
    public static final String LOAD_BALANCE_STRATEGY_ROTATION = "rotation";

    /**
     * Factory method to prepare a simulation
     *
     * @param seed             the seed used to launch the simulation
     * @param simulationOutput the output to be extracted from the simulation
     * @param f                the factory used to initialize members of the
     *                         computation
     * @param pg               place group on which the simulation will be run
     * @return runner instance ready to launch the computation
     */
    public static ParallelRunnerDistManualLB initializeRunner(long seed, SimulationOutput simulationOutput,
            SimulatorFactory f, TeamedPlaceGroup pg) {
        final Place root = here(); // Root is going to be the place where high-frequency agents are located

        // We create every distributed collections first
        final DistMultiMap<Long, AgentUpdate> contractedOrdersCol = new DistMultiMap<>(pg);
        final DistCol<Agent> allAgentsCol = new DistCol<>(pg);
        final DistCol<Agent> lAgentsCol = new DistCol<>(pg);
        final DistCol<Agent> sAgentsCol = new DistCol<>(pg);
        final DistBag<List<Order>> lOrdersCol = new DistBag<>(pg);
        final DistBag<List<Order>> sOrdersCol = new DistBag<>(pg);
        final DistMap<String, List<String>> outputCollectorMap = new DistMap<>(pg);
        final DistLog log = new DistLog(pg);

        // Creating a simulator in anticipation to initialize distributed array of
        // markets.
        // The factory instance `f` should not be used any further, a proper instance
        // will be present in each GlbRunner.
        final Simulator simulator = f.makeNewSimulation(seed, true, false,
                new GlbAllocManager(pg, root, allAgentsCol, sAgentsCol, lAgentsCol));
        final CachableArray<Market> marketsCol = CachableArray.make(pg, simulator.markets);

        final Value config = f.CONFIG;

        // Then we create the "GlbRunner" on every place with all the distributed
        // collections given as parameter.
        // We also initialize the various Agents on each place as necessary.
        final ParallelRunnerDistManualLB toReturn = PlaceLocalObject.make(pg.places(), () -> {
            final ParallelRunnerDistManualLB localRunner = new ParallelRunnerDistManualLB(root, pg, simulationOutput,
                    config, seed, contractedOrdersCol, allAgentsCol, lAgentsCol, sAgentsCol, lOrdersCol, sOrdersCol,
                    marketsCol, outputCollectorMap, log);

            // Create all agents
            localRunner.createAllAgents();
            allAgentsCol.updateDist();
            sAgentsCol.updateDist();
            lAgentsCol.updateDist();

            // Update members needed for evolving distribution
            sAgentsCol.getSizeDistribution(localRunner.nbShortTermAgentsPerRank);

            return localRunner;
        });

        // Modifications specific to master
        allAgentsCol.setProxyGenerator((index) -> {
            return new AgentUpdateProxy(index, contractedOrdersCol);
        });

        return toReturn;
    }

    /**
     * Main method. Launches a simulation on the entire world.
     *
     * @param args output class producing output, JSON simulation configuration,
     *             seed
     */
    public static void main(String[] args) {
        // Argument checking
        if (args.length < 3) {
            System.err.println("Program arguments for distributed runner:");
            System.err.println("\tOutput class (defines the outputs to extract from the simulation");
            System.err.println("\tJSON configuration file");
            System.err.println("\tseed");
            System.err.println("\tConfiguration for warmup (optional)");
            return;
        }

        // Argument parsing
        final String outputClassName = args[0];
        final String JsonConfigurationFile = args[1];
        final String seedArg = args[2];

        SimulationOutput simulationOutput = null;

        try {
            final Class<?> outputClass = Class.forName(outputClassName);
            simulationOutput = (SimulationOutput) outputClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            System.err.println("Could not create an instance of outputClassName");
            e.printStackTrace();
            return;
        } catch (final ClassNotFoundException e) {
            System.err.println("Could not find class " + outputClassName);
            System.err.println("Check you classpath and for any typo");
            e.printStackTrace();
            return;
        }

        SimulatorFactory factory;
        try {
            factory = new SimulatorFactory(JsonConfigurationFile);
        } catch (final Exception e) {
            System.err.println("Problem encountered when attemting to open file " + JsonConfigurationFile);
            e.printStackTrace();
            return;
        }

        long seed;
        try {
            seed = Long.parseLong(seedArg);
        } catch (final NumberFormatException e) {
            System.err.println("Could not parse the seed " + seedArg);
            e.printStackTrace();
            return;
        }

        // Optional Warmup
        if (args.length > 3) {
            final String warmupFile = args[3];
            try {
                System.err.println("# Launching Warmup " + warmupFile);
                long warmupTime = System.nanoTime();
                final SimulatorFactory warmupFactory = new SimulatorFactory(warmupFile);
                ParallelRunnerDistManualLB
                        .initializeRunner(100, new SimulationOutput(), warmupFactory, TeamedPlaceGroup.getWorld())
                        .run();
                warmupTime = System.nanoTime() - warmupTime;
                System.err.println("# Warmup completed in " + (warmupTime / 1e9));
            } catch (final Exception e) {
                System.err.println("Error during warmup");
                e.printStackTrace();
            }
        }

        // Create the simulator
        long TIME_INIT = System.nanoTime();
        final ParallelRunnerDistManualLB runnerOnWorld = ParallelRunnerDistManualLB.initializeRunner(seed,
                simulationOutput, factory, TeamedPlaceGroup.getWorld());
        TIME_INIT = System.nanoTime() - TIME_INIT;
        System.err.println("# INITIALIZATION TIME " + (TIME_INIT / 1e9));

        // Run simulation
        final long simulationStart = System.nanoTime();
        runnerOnWorld.run();
        final long simulationStop = System.nanoTime();
        System.err.println("# EXECUTION TIME " + (simulationStop - simulationStart) / 1e+9);

        // Post simulation, write the logged data to a file if specified
        if (System.getProperties().containsKey(Config.SAVE_LOG_TO_FILE)) {
            final String fileName = System.getProperty(Config.SAVE_LOG_TO_FILE);
            System.err.println("# Saving distributed log to " + fileName);
            try {
                new SavedLog(runnerOnWorld.logger).saveToFile(new File(fileName));
            } catch (final Exception e) {
                System.err.println("# Problem encountered while saving distributed log to file");
                e.printStackTrace();
            }
        }
    }

    /**************************************************************************
     * Members related to the simulation participants *
     *************************************************************************/
    /**
     * Distributed collection used to distribute the updates to the agents that have
     * been involved in a trade
     */
    final DistMultiMap<Long, AgentUpdate> contractedOrders;
    /**
     * Factory object in charge of initializing the objects taking part in the
     * simulation
     */
    transient SimulatorFactory factory;
    /**
     * Orders located on the master, used to keep orders between iterations and
     * sessions. This member is kept {@code null} on processes other than root.
     */
    transient final Bag<List<Order>> keptOrders;
    /** Collection containing all the agents participating in the simulation */
    final DistCol<Agent> allAgents;
    /** Short-term agents */
    final DistCol<Agent> sAgents;
    /** Long-term agents */
    final DistCol<Agent> lAgents;
    /** Orders placed by short-term agents */
    final DistBag<List<Order>> sOrders;
    /** Orders placed by long-term agents */
    final DistBag<List<Order>> lOrders;
    /** Markets available to traders during the simulation */
    final CachableArray<Market> markets;
    /** Class specifying the outputs to make during the simulation */
    final transient SimulationOutput output;

    /**************************************************************************
     * Members related to runtime *
     *************************************************************************/
    /** Flag used to toggle the performance tracking parts of the runner */
    public boolean _PROFILE = false;
    /** Group of processes on which the simulation is running */
    final transient TeamedPlaceGroup placeGroup;
    /**
     * "Root" of the simulation, where high-frequency traders are located and orders
     * processed
     */
    final transient Place master;
    /** Level of parallelism available / to use on the local host */
    private final int PARALLELISM;
    /**
     * Logger into which the events that occur during the simulation are recorded
     */
    final DistLog logger;
    /** Seed used to run the simulation */
    final long seed;
    /**
     * Initial allocation of agents over the hosts, not initialized as part of the
     * constructor
     */
    final private GlbAllocManager agentAllocationManager;
    /** Output collector */
    final DistributedOutputCollector collector;
    /**
     * Indicates if the process running is the "master" of the simulation, i.e. the
     * place containing the high-frequency traders and where all orders are
     * processed.
     */
    final boolean isMaster;
    /** Simulator providing local access methods to other objects on local host */
    transient Simulator sim;

    /**************************************************************************
     * Members related to the load balancing of agents across hosts
     *************************************************************************/
    /** Flag which indicates if traces should be made about load-balancing events */
    private final boolean lbTraces;
    /** Period after which a manual round of load balancing should be done */
    private final int loadBalancePeriod;
    /** File to which the evolution of the agent distribution are dumped */
    private transient File dumpFile;
    /** PrintStream to which changes in agent distribution are printed. */
    private transient PrintStream dumpStream;
    /** True on master if the evolution of the distribution needs to be dumped */
    private transient boolean withDump;
    /**
     * Counter of elapsed iteration since the last manual load balanced. When this
     * counter reached {@link #loadBalancePeriod}, it is reset to 0 and a round of
     * manual load balance is performed.
     */
    int elapsedIteration = 0;
    /**
     * Accumulated order computation time for each place [0..n] over the last
     * {@link #elapsedIteration} iteration. The decision of performing load balance,
     * and host much, is based on the values contained in this array after the
     * individual value of each host [1..n] has been gathered with an MPI call.
     * <p>
     * The first index (i.e. computation time of orders on Place0) corresponds to
     * the time needed to handle the orders rather than the time needed to process
     * short-term agents.
     */
    private final long orderComputationTime[];
    /**
     * Stamp used as the reference for measuring the elapsed time since the start of
     * the computation in the dumps related to LB. Only relevant on "master"
     */
    private long simulationStartStamp = 0l;
    /** Time stamp on master of the last time load balance was performed */
    private long stampOfPreviousLB = 0l;
    /** Number of SAgent located on each host */
    private final long[] nbShortTermAgentsPerRank;
    /**
     * Distribution of sAgents over places.
     * <p>
     * This member is updated as necessary when the distribution of short-term
     * agents changes.
     */
    private final LongRangeDistribution agentDistribution;

    /**
     * Load balance strategy to use by the runner
     * <p>
     * For now the strategy cannot be changed during execution but this limitation
     * could be lifted quite easily.
     */
    public final String lbStrategy;

    private long elapsedSinceStart;

    private long elapsedSincePrevLB;

    private long elapsedForCurrentLB;

    /**
     * Constructor (private)
     *
     * @param r                   "root" place on which orders are handled
     * @param pg                  place group on which the computation it taking
     *                            place
     * @param simulationOutput    the user-supplied class which produces the outputs
     *                            of the simulation
     * @param config              configuration object representing the JSON
     *                            configuration file of the simulation
     * @param s                   seed of the simulation
     * @param contractedOrdersCol collection used to transmit the updates to agents
     *                            when orders are fulfilled
     * @param allAgentsCol        collection containing all short-term and long-term
     *                            agents
     * @param lAgentsCol          collection containing the long-term agents
     * @param sAgentsCol          collection containing the short-term agents
     * @param lOrdersCol          collection used to collect the orders from
     *                            long-term agents
     * @param sOrdersCol          collection used to collect the orders from
     *                            short-term agents
     * @param marketsCol          collection used to share the state of the markets
     *                            to agents located on various places
     * @param outputCollectorMap  map used to collect the simulation output produced
     *                            on each host and
     * @param log                 logger for internal events of the distributed
     *                            runner
     * @throws Exception if thrown while initializing the local branch of
     */
    private ParallelRunnerDistManualLB(Place r, TeamedPlaceGroup pg, SimulationOutput simulationOutput, Value config,
            long s, DistMultiMap<Long, AgentUpdate> contractedOrdersCol, DistCol<Agent> allAgentsCol,
            DistCol<Agent> lAgentsCol, DistCol<Agent> sAgentsCol, DistBag<List<Order>> lOrdersCol,
            DistBag<List<Order>> sOrdersCol, CachableArray<Market> marketsCol,
            DistMap<String, List<String>> outputCollectorMap, DistLog log) throws Exception {
        contractedOrders = contractedOrdersCol;
        allAgents = allAgentsCol;
        lAgents = lAgentsCol;
        sAgents = sAgentsCol;
        lOrders = lOrdersCol;
        sOrders = sOrdersCol;
        output = simulationOutput;
        master = r;
        markets = marketsCol;
        placeGroup = pg;
        seed = s;
        logger = log;
        nbShortTermAgentsPerRank = new long[placeGroup.size()];

        collector = new DistributedOutputCollector(outputCollectorMap);
        isMaster = here() == master;
        if (isMaster) {
            keptOrders = new Bag<>();
        } else {
            keptOrders = null;
        }

        PARALLELISM = Runtime.getRuntime().availableProcessors()
                * Integer.parseInt(System.getProperty(Config.PARALLELISM_FACTOR, Config.PARALLELISM_FACTOR_DEFAULT));

        factory = new SimulatorFactory(config);
        agentAllocationManager = new GlbAllocManager(pg, master, allAgentsCol, sAgentsCol, lAgentsCol);
        sim = factory.makeNewSimulation(seed, true, false, agentAllocationManager);
        agentAllocationManager.sim = sim;

        // Switch the collections contained in Simulator for the distributed versions
        sim.markets = marketsCol;
        sim.agents = allAgentsCol;

        // Set the Simulator member of each market
        for (final Market m : marketsCol) {
            m.env = sim;
        }

        // Initialize load-balance-related settings and members
        agentDistribution = new LongRangeDistribution();
        sAgents.registerDistribution(agentDistribution);
        lAgents.registerDistribution(agentDistribution);
        lbTraces = Boolean.parseBoolean(System.getProperty(LOAD_BALANCE_DEBUGTRACES, "false"));
        lbStrategy = System.getProperty(LOAD_BALANCE_STRATEGY, LOAD_BALANCE_STRATEGY_DEFAULT);
        orderComputationTime = new long[placeGroup.size()];
        final int lbPeriod = Integer.parseInt(System.getProperty(LOAD_BALANCE_PERIOD, LOAD_BALANCE_PERIOD_DEFAULT));
        if (lbPeriod <= 0) {
            loadBalancePeriod = Integer.MAX_VALUE;
            withDump = false;
        } else {
            loadBalancePeriod = lbPeriod;
            if (isMaster && System.getProperties().containsKey(LOAD_BALANCE_DUMPFILE)) {
                // Initialize file and outstream to dump distribution evolution for master
                withDump = true; // withDump is only true on "master"
                final String fileName = System.getProperty(LOAD_BALANCE_DUMPFILE);
                dumpFile = new File(fileName);
                dumpStream = new PrintStream(dumpFile);
            } else {
                withDump = false;
            }
        }
    }

    /**
     * Method used to add orders received from remote agents into the processing
     * machine located on the "master" of the simulation
     *
     * @param orders the bag of orders newly received
     */
    private void addOrders(Bag<List<Order>> orders) {
        keptOrders.addBag(orders);
        orders.clear();
    }

    private void createAllAgents() {
        final Value agentConfigList = factory.CONFIG.get("simulation").get("agents");
        factory.createAllAgents(agentConfigList, agentAllocationManager);
    }

    /**
     * Sub-routine used to check the consistency of {@link #agentDistribution} with
     * the contents of the local sAgent and lAgent
     */
    @SuppressWarnings("unused")
    private void debug_checkDistributionConsistency() {
        final Place here = here();
        for (final LongRange lr : sAgents.ranges()) {
            final Place supposedLocation = agentDistribution.location(lr);
            if (supposedLocation != here) {
                System.err.println("Range " + lr + " is on " + here + " but dist says " + supposedLocation);
            }
        }
    }

    private void dumpLoadBalanceStatus(String iterationLabel, final long elapsedSinceStart,
            final long elapsedSincePrevLB, final long elapsedForCurrentLB, final long accumulatedOrderHandling) {
        // For now print the elapsed time for sanity check.
        dumpStream.print(iterationLabel + " ; " + elapsedSinceStart / 1e9 + "; " + elapsedSincePrevLB / 1e9 + "; "
                + elapsedForCurrentLB / 1e9 + "; " + accumulatedOrderHandling / 1e9);
        for (int i = 0; i < orderComputationTime.length; i++) {
            // This first rank actually prints the order handling while LB was taking place
            dumpStream.print("; " + orderComputationTime[i] / 1e9);
        }
        for (int i = 1; i < nbShortTermAgentsPerRank.length; i++) {
            final long sAgentCount = nbShortTermAgentsPerRank[i];
            dumpStream.print("; " + sAgentCount);
        }
        dumpStream.println();
    }

    /**
     * Routine used to update the long-term and/or short-term agents held locally
     * which have made a trade. The information that a trade was made is contained
     * in the {@link #contractedOrders} member, with the index at which the updates
     * are stored corresponding to the agent to which the update needs to be
     * delivered.
     */
    private void executeRemoteAgentUpdate() {
        contractedOrders.parallelForEach((idx, updates) -> {
            // Retrieve the Agent from either sAgents or lAgents
//            final Agent a = allAgents.get(idx);
            try {

                final Agent a = sAgents.get(idx); // FIXME will fail for pipelined schedules,
                                                  // need to select sAgents / lAgents

                // Execute all the updates for this Agent one by one
                for (final AgentUpdate u : updates) {
                    a.executeUpdate(u);
                }
            } catch (final IndexOutOfBoundsException e) {
//                System.err.println(
//                        "Agent:" + idx + " not found on " + here() + ". Dist says " + agentDistribution.place(idx));
            }
        });
    }

    private void handleOrders(Session session) {
        final long beginTime = System.nanoTime();
        final List<List<Order>> allOrders = new ArrayList<>();
        // List<Market> markets = markets;

        final Random random = sim.getRandom();
        final Random tmpRandom = new Random(System.nanoTime());
        if (sim.hifreqAgents == null) {
            sim.hifreqAgents = new ChunkedList<>();
        }
        final RandomPermutation<Agent> randomArbs = new RandomPermutation<>(random.split(), sim.hifreqAgents);
        final Collection<List<Order>> randomOrders = myShuffle(random.split());

        for (final List<Order> someOrders : randomOrders) {
            // This handles one order-list submitted by an agent per loop.
            // TODO: If needed, one-market one-order handling ?
            for (final Order order : someOrders) {
                final Market m = markets.get(((int) order.marketId));
                m.triggerBeforeOrderHandlingEvents(order);
                m.handleOrder(order);
                m.triggerAfterOrderHandlingEvents(order);
                m.tickUpdateMarketPrice();
            }

            if (session.highFreqSubmissionRate < tmpRandom.nextDouble()) {
                continue;
            }

            long k = 0;
            randomArbs.shuffle();
            for (final Agent agent : randomArbs) {
                if (k >= session.maxHighFreqOrders) {
                    break;
                }
                final List<Order> orders = agent.submitOrders(markets);
                if (session.withPrint) {
                    output.orderSubmissionOutput(collector, SimulationStage.WITH_PRINT_DURING_SESSION, agent, orders,
                            markets);
                }

                if (!orders.isEmpty()) {
                    allOrders.add(orders);
                }

                if (orders.size() > 0) {
                    for (final Order order : orders) {
                        final Market m = markets.get((int) order.marketId);
                        m.triggerBeforeOrderHandlingEvents(order);
                        m.handleOrder(order);
                        m.triggerAfterOrderHandlingEvents(order);
                        m.tickUpdateMarketPrice();
                    }
                    k++;
                }
            }
        }
        randomOrders.clear();

        final long endTime = System.nanoTime();
        if (_PROFILE) {
            System.err.println("# handle orders took " + (endTime - beginTime));
        }
    }

    private void iterateMarketUpdatesNoPipeline(Session session) {
        if (!session.withOrderPlacement) {
            throw new RuntimeException("Was about to start a session without order placement, this should not happen");
        }

        if (isMaster) {
            logger.put(LOG_SESSION_START, session.sessionName, "" + System.nanoTime());
            marketSetup(session.withOrderExecution);
        }

        final long iterationStamp = System.nanoTime();
        for (long id = 0; id < session.iterationSteps; id++) {
            final long fid = id;
            if (isMaster) {
                logger.put(LOG_ITERATION_START, session.sessionName + ":" + id, "" + iterationStamp);
                iterSetup();
            }

            markets.<MarketUpdate>broadcast(MarketUpdate::pack, MarketUpdate::unpack);

            // Submit short-term agent orders and gather them on root
            if (isMaster) {
                logger.put(LOG_SAGENTSUBMISSION_START, session.sessionName + ":" + id, "" + System.nanoTime());
            }
            sOrders.clear();

            // Make the order submission and measure the elapsed time
            if (!isMaster) {
                long orderComputation = System.nanoTime();
                submitOrders(id, sAgents, sOrders, session);
                orderComputation = System.nanoTime() - orderComputation;
                orderComputationTime[placeGroup.rank()] += orderComputation;
            }
            elapsedIteration++; // Increment iteration elapsed counter

            try {
                sOrders.TEAM.gather(master);
            } catch (final Exception e) {
                e.printStackTrace();
                throw new RuntimeException("[GlbRunner] relocating contracted orders of long-term agents failed", e);
            }

            // This is a local finish on all hosts.
            // There is some synchronization between all hosts when elapsedIteration ==
            // loadBalancePeriod
            // In other cases, this is an empty finish
            final long accumulatedOrderHandlingTime = orderComputationTime[0];
            final long handleOrderTime = finish(() -> {
                if (elapsedIteration == loadBalancePeriod) {
                    async(() -> performLoadBalance());
                }
                long orderHandlingTime = 0l; // Will return 0 except on "master"
                if (isMaster) {
                    final long stamp = System.nanoTime();
                    logger.put(LOG_SAGENTSUBMISSION_STOP, session.sessionName + ":" + fid, "" + System.nanoTime());
                    logger.put(LOG_PROCESSORDERS_START, session.sessionName + ":" + fid, "" + System.nanoTime());
                    addOrders(sOrders);
                    handleOrders(session);
                    logger.put(LOG_PROCESSORDERS_STOP, session.sessionName + ":" + fid, "" + System.nanoTime());
                    updateMarketMisc(session);
                    orderHandlingTime = System.nanoTime() - stamp;
                }
                return orderHandlingTime;
            });
            orderComputationTime[0] += handleOrderTime;

            if (isMaster && withDump) {
                // Increment the order handling computation time
                if (elapsedIteration == 0) {
                    dumpLoadBalanceStatus(session.sessionName + "_" + fid, elapsedSinceStart, elapsedSincePrevLB,
                            elapsedForCurrentLB, accumulatedOrderHandlingTime);
                }
            }

            if (session.withPrint) {
                makeWithPrintOutput(session, SimulationStage.WITH_PRINT_DURING_SESSION);
            }

            if (isMaster) {
                postStepMarketUpdate();
            }

            for (final Market market : markets) {
                market.updateTime();
            }

            try {
//                contractedOrders.relocate(allAgents.getDistributionLong()); // Not that trivial due to potential agent relocation.

                contractedOrders.relocate(agentDistribution);
            } catch (final Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Problem encountered when transmitting contracted orders to remote agents",
                        e);
            }

            if (!isMaster) {
                try {
                    executeRemoteAgentUpdate();
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            } else {
                logger.put(LOG_ITERATION_STOP, session.sessionName + ":" + id, "" + System.nanoTime());
            }
        }

        if (session.withPrint) {
            makeWithPrintOutput(session, SimulationStage.WITH_PRINT_END_SESSION);
        }
        if (isMaster) {
            logger.put(LOG_SESSION_STOP, session.sessionName, "" + System.nanoTime());
        }
    }

    private void iterateMarketUpdatesPipeline(Session session) {
        if (!session.withOrderExecution) {
            throw new RuntimeException("Was about to start a session without order placement, this should not happen");
        }

        if (isMaster) {
            marketSetup(session.withOrderExecution);
            iterSetup();
        }
        // Broadcast the updated state of the market on every host
        markets.<Market.MarketUpdate>broadcast(MarketUpdate::pack, MarketUpdate::unpack);

        // Run every iteration required by the session
        for (long id = 0; id < session.iterationSteps; id++) {
            final long idc = id; // Final long for use in closures

            // PART 1: Compute short-term agents orders,
            // Relocate long-term orders to Place 0 (if not 1st iteration)
            sOrders.clear(); // Prepare bag to receive the orders from short-term agents
            finish(() -> {
                async(() -> submitOrders(idc, sAgents, sOrders, session));

                // If not the 1st iteration of the session ...
                if (idc > 0) {
                    // ... relocate contracted orders for update ...
                    try {
                        contractedOrders.relocate(agentDistribution);
                    } catch (final Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException(
                                "[GlbRunner] relocating contracted orders of long-term agents failed", e);
                    }

                    // ... and gather the lOrders produced in Part 2 on Place 0
                    lOrders.TEAM.gather(master);
                    if (isMaster) {
                        addOrders(lOrders);
                    }
                }
            });

            // If not on master, execute the contracted orders' update
            if (!isMaster) {
                executeRemoteAgentUpdate();
            }

            // Part 2: Compute long-term agents orders,
            // Relocate short-term orders to Place 0
            finish(() -> {
                if (!isMaster) {
                    async(() -> submitOrders(idc, lAgents, lOrders, session));
                }

                try {
                    sOrders.TEAM.gather(master);
                } catch (final Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("[GlbRunner] relocation contracted orders of short-term agents", e);
                }

                if (isMaster) {
                    addOrders(sOrders);
                    handleOrders(session);
                    if (idc + 1 < session.iterationSteps) {
                        // Misc. updates to perform
                        updateMarketMisc(session);
                    }
                }
            }); // long-term agents have placed their orders in the lOrders distributed bag

            // Output during session (except if last iteration of the session)
            if (idc + 1 < session.iterationSteps && session.withPrint) {
                makeWithPrintOutput(session, SimulationStage.WITH_PRINT_DURING_SESSION);
            }

            if (isMaster) {
                postStepMarketUpdate();
                if (idc + 1 < session.iterationSteps) {
                    for (final Market m : markets) {
                        m.updateTime();
                    }
                    iterSetup();
                }
            }
            markets.<Market.MarketUpdate>broadcast(MarketUpdate::pack, MarketUpdate::unpack);
        } // End of the for loop over session iteration

        // Part 1 bis
        // Extra block to handle the long-term orders generated in part 2 of the last
        // iteration of the for loop
        {
            lOrders.TEAM.gather(master);
            if (isMaster) {
                addOrders(lOrders);
                handleOrders(session);
                updateMarketMisc(session);
            }

            try {
                contractedOrders.relocate(agentDistribution);
            } catch (final Exception e) {
                e.printStackTrace();
                throw new RuntimeException("[GlbRunner] relocating contracted orders failed", e);
            }
            if (isMaster) {
                if (session.withPrint) {
                    makeWithPrintOutput(session, SimulationStage.WITH_PRINT_DURING_SESSION);
                }
                postStepMarketUpdate();
            } else {
                // TODO 27th September 2021
                // Should the output call be made BEFORE or AFTER the agents receive their
                // update? Left as "AFTER" for now, might be revisited later.
                // This does not matter if the the SimulationOutput#agentOutput method is
                // not overridden.
                executeRemoteAgentUpdate();
                if (session.withPrint) {
                    makeWithPrintOutput(session, SimulationStage.WITH_PRINT_DURING_SESSION);
                }
            }
        } // end of Part 1 bis extra block

        // Last output of the session if "withPrint" set
        if (session.withPrint) {
            makeWithPrintOutput(session, SimulationStage.WITH_PRINT_END_SESSION);
        }
    }

    /**
     * Setup routine run on master before the first iteration of a session
     */
    private void iterSetup() {
        sim.updateFundamentals(sim.fundamentals);
        for (final Market m : markets) {
            m.triggerBeforeSimulationStepEvents();
        }
    }

    /**
     * Load-balance strategy consisting of offloading the most busy host onto the
     * faster one. This is the implementation of load-balance strategy
     * {@link #LOAD_BALANCE_STRATEGY_LEVELEXTREMES}.
     *
     * @param currentDistribution    distribution of sAgent over ranks
     * @param elapsedComputationTime accumulated computation time on each rank
     */
    private void lb_offloadOverloadedWorker(long[] currentDistribution, long[] elapsedComputationTime) {
        final int myRank = placeGroup.rank();
        // Find the most loaded & least loaded ranks
        int overloadedRank = -1;
        int underloadedRank = -1;
        long overloadedComputationTime = Long.MIN_VALUE;
        long underloadedComputationTime = Long.MAX_VALUE;
        // Start from 1 to exclude master host
        for (int i = 1; i < elapsedComputationTime.length; i++) {
            if (overloadedComputationTime < elapsedComputationTime[i]) {
                overloadedComputationTime = elapsedComputationTime[i];
                overloadedRank = i;
            }
            if (elapsedComputationTime[i] < underloadedComputationTime) {
                underloadedComputationTime = elapsedComputationTime[i];
                underloadedRank = i;
            }
        }

        // Compute the number of agents to relocate to resolve the load unbalance
        final long timeDiff = overloadedComputationTime - underloadedComputationTime;
        final double overRatio = overloadedComputationTime / currentDistribution[overloadedRank];
        final double underRatio = underloadedComputationTime / currentDistribution[underloadedRank];

        final long agentsToRelocate = (long) (timeDiff / (overRatio + underRatio));

        if (MINIMUM_AGENTS_RELOCATED < agentsToRelocate) {
            final CollectiveMoveManager mm = new CollectiveMoveManager(placeGroup);

            // Only the overloaded rank makes relocation by this strategy
            if (myRank == overloadedRank) {
                // Relocate some work to underloaded host
                long relocatedAgents = 0l;
                final Iterator<LongRange> ranges = sAgents.ranges().iterator();
                while (relocatedAgents < agentsToRelocate && ranges.hasNext()) {
                    final LongRange range = ranges.next();
                    // If the range contains enough to close the gap, split only the necessary part
                    final long leftToRelocate = agentsToRelocate - relocatedAgents;
                    if (leftToRelocate <= range.size()) {
                        final LongRange takenAway = new LongRange(range.from, range.from + leftToRelocate);
                        sAgents.moveRangeAtSync(takenAway, placeGroup.get(underloadedRank), mm);
                        relocatedAgents += takenAway.size();
                    } else {
                        // Add the entire range
                        sAgents.moveRangeAtSync(range, placeGroup.get(underloadedRank), mm);
                        relocatedAgents += range.size();
                    }
                }
            }

            // Perform the transfer
            try {
                mm.sync();
            } catch (final Exception e) {
                System.err.println("Problem while relocating some sAgents");
                e.printStackTrace();
            }

            // Update the distribution information
            sAgents.updateDist();
            Arrays.fill(nbShortTermAgentsPerRank, 0l);
            sAgents.getSizeDistribution(nbShortTermAgentsPerRank);
        }
    }

    /**
     * Dummy sAgent relocation strategy used for tests
     */
    private void lb_rotateShortTermAgents() {
        // Determine the destination
        final int localRank = placeGroup.rank();
        final int destRank = localRank + 1 >= placeGroup.size() ? 1 : localRank + 1;
        final Place destination = placeGroup.get(destRank);

        // Register all ranges for relocation
        final CollectiveMoveManager mm = new CollectiveMoveManager(placeGroup);
        for (final LongRange lr : sAgents.ranges()) {
            sAgents.moveRangeAtSync(lr, destination, mm);
            if (lbTraces) {
                System.err.println("Moving " + lr + " from rank" + localRank + " to rank" + destRank);
            }
        }

        // Perform the relocation
        try {
            mm.sync();
        } catch (final Exception e) {
            System.err.println("Problem while relocating some sAgents");
            e.printStackTrace();
        }

        // Update the distribution information
        sAgents.updateDist();
//        agentDistribution = sAgents.getDistribution(); // TODO REMOVE THIS LINE WHICH SHOULD BE REDUNDANT
        Arrays.fill(nbShortTermAgentsPerRank, 0l);
        sAgents.getSizeDistribution(nbShortTermAgentsPerRank);
    }

    /**
     * Sub-routine called at the beginning and end of a session to make outputs for
     * a simulation
     *
     * @param s     the session about to start or which has completed
     * @param stage the stage in the simulation
     */
    private void makeSessionOutput(Session s, SimulationStage stage) {
        if (isMaster) {
            output.sessionOutput(collector, stage, s);
            outputEvent(stage);
            outputMarket(stage);
        }
        outputAgent(stage);

        collector.transferLogsToMaster();

        if (isMaster) {
            output.postProcess(collector, stage);
        }
        collector.clear();
    }

    /**
     * Helper method called on each place at the beginning and the end of the
     * simulation
     *
     * @param stage current stage of the simulation (either
     *              {@link SimulationStage#BEGIN_SIMULATION} or
     *              {@link SimulationStage#END_SIMULATION}).
     */
    private void makeSimulationOutput(SimulationStage stage) {
        if (isMaster) {
            outputMarket(stage);
        }
        outputAgent(stage);

        collector.transferLogsToMaster();

        if (isMaster) {
            output.postProcess(collector, stage);
        }
        // Remove all collected entries before next output
        collector.clear();
    }

    /**
     * Sub-routine called when the "withPrint" option is set to true for a session
     *
     * @param s     the session in progress
     * @param stage the stage in the simulation, either
     *              {@link SimulationStage#WITH_PRINT_DURING_SESSION} or
     *              {@link SimulationStage#WITH_PRINT_END_SESSION}.
     */
    private void makeWithPrintOutput(Session s, SimulationStage stage) {
        if (isMaster) {
            output.sessionOutput(collector, stage, s);
            outputMarket(stage);
        }
        outputAgent(stage);
        outputEvent(stage);

        collector.transferLogsToMaster();

        if (isMaster) {
            output.postProcess(collector, stage);
        }
        collector.clear();
    }

    /**
     * Initialization routine run at the beginning of a session on the master
     *
     * @param withOrderExecution value defined by the session considered
     */
    private void marketSetup(boolean withOrderExecution) {
        // TODO 27th September 2021
        // Should we make this a parallel loop?
        // Usually there are few markets in a simulation so it may not be necessary.
        markets.forEach((Market market) -> {
            market.setRunning(withOrderExecution);
            market.itayoseOrderBooks();
            market.check();
        });
    }

    /**
     * Re-ordering of orders
     *
     * @param random the object used to provide pseudo-random numbers
     * @return re-ordered collection of orders
     */
    private Collection<List<Order>> myShuffle(Random random) {
        final TreeMap<Ox, List<Order>> sorted = new TreeMap<>();
        for (final List<Order> orderSet : keptOrders) {
            if (orderSet.isEmpty()) {
                continue;
            }
            final long agentId = orderSet.get(0).agentId;
            final long priority = random.getNthLong(agentId);
            sorted.put(new Ox(priority, agentId, orderSet), orderSet);
        }
        keptOrders.clear();
        return sorted.values();
    }

    /**
     * Helper method which collects the output of every Agent with the specified
     * stage
     *
     * @param stage the current simulation stage
     */
    private void outputAgent(SimulationStage stage) {
        for (final Agent a : sAgents) {
            output.agentOutput(collector, stage, a);
        }
        for (final Agent a : lAgents) {
            output.agentOutput(collector, stage, a);
        }
        for (final Agent a : sim.hifreqAgents) {
            output.agentOutput(collector, stage, a);
        }
    }

    /**
     * Helper method which collects the output of every event in the current session
     *
     * @param stage the current simulation stage
     */
    private void outputEvent(SimulationStage stage) {
        // There are sessions which do not contain any event,
        // in which case we return immediately
        if (sim.sessionEvents == null) {
            return;
        }

        for (final Event e : sim.sessionEvents) {
            output.eventOutput(collector, stage, e);
        }
    }

    /**
     * Helper method which collects the output of every market with the specified
     * stage
     *
     * @param stage the current simulation stage
     */
    private void outputMarket(SimulationStage stage) {
        for (final Market m : markets) {
            output.marketOutput(collector, stage, m);
        }
    }

    /**
     * Assembles information from various hosts and performs some load balancing on
     * the sAgent distributed collection if deemed necessary.
     */
    @SuppressWarnings("deprecation")
    private void performLoadBalance() {
        final long stampStartLB = System.nanoTime();

        // Share the elapsed computation time between hosts
        placeGroup.comm.Allgather(orderComputationTime, placeGroup.rank(), 1, MPI.LONG, orderComputationTime, 0, 1,
                MPI.LONG);

        // Perform the load balancing depending on the strategy configured.
        switch (lbStrategy) {
        case LOAD_BALANCE_STRATEGY_LEVELEXTREMES:
            lb_offloadOverloadedWorker(nbShortTermAgentsPerRank, orderComputationTime);
            break;
        case LOAD_BALANCE_STRATEGY_ROTATION:
            lb_rotateShortTermAgents();
            break;
        case LOAD_BALANCE_STRATEGY_NONE:
        default:
            // Do Nothing
        }

        final long stampEndLB = System.nanoTime();
        // Prepare for dumps of the computation times / state of the new distribution
        if (isMaster && withDump) {
            // Compute the elapsed time for the output to be performed later
            elapsedSinceStart = stampStartLB - simulationStartStamp;
            elapsedSincePrevLB = stampStartLB - stampOfPreviousLB;
            elapsedForCurrentLB = stampEndLB - stampStartLB;
        }
        // Set the various variable for the next interval
        elapsedIteration = 0;
        orderComputationTime[placeGroup.rank()] = 0l;
        stampOfPreviousLB = stampEndLB;

//        debug_checkDistributionConsistency();
    }

    /**
     * Sub-routine called at the end of an iteration
     */
    private void postStepMarketUpdate() {
        for (final Market market : markets) {
            market.triggerAfterSimulationStepEvents();
            market.updateOrderBooks();
        }
    }

    public void run() {
        // First, determine which schedule needs to be used based on the presence
        // of long-term agents in the simulation
        final boolean usePipeline = agentAllocationManager.hasLong()
                || Boolean.parseBoolean(System.getProperty(Config.FORCE_PIPELINE_SCHEDULE, "false"));

        // If dumping of distribution was activated, erase and re-prepare file
        if (withDump) {
            try {
                dumpFile.delete(); // erase any previous version (file created due to warmup / previous execution)
                dumpStream = new PrintStream(dumpFile);
                dumpStream.print(
                        "Iteration; Elsd simul start; Elsd prev LB; Elsp in LB; Sum handleOrder; last handleOrder");
                for (final Place p : placeGroup.places()) {
                    final int rank = placeGroup.rank(p);
                    if (rank != 0) {
                        dumpStream.print("; Order Compute Time r" + rank);
                    }
                }
                for (final Place p : placeGroup.places()) {
                    final int rank = placeGroup.rank(p);
                    if (rank != 0) {
                        dumpStream.print("; sAgent Count r" + rank);
                    }
                }
                dumpStream.println();
            } catch (final FileNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }
        simulationStartStamp = stampOfPreviousLB = System.nanoTime();

        placeGroup.broadcastFlat(() -> {
            makeSimulationOutput(SimulationStage.BEGIN_SIMULATION);

            for (final Session session : sim.sessions) {
                if (isMaster) {
                    sim.sessionEvents = factory.createEventsForASession(session, sim);
                }
                makeSessionOutput(session, SimulationStage.BEGIN_SESSION);

                // placeGroup.barrier(); // This barrier was used when timing the simulator
                if (usePipeline) {
                    iterateMarketUpdatesPipeline(session);
                } else {
                    iterateMarketUpdatesNoPipeline(session);
                }

                makeSessionOutput(session, SimulationStage.END_SESSION);
            }

            makeSimulationOutput(SimulationStage.END_SIMULATION);
        });

        // If dumping of distribution was activated, close the dedicated file.
        if (withDump) {
            dumpStream.close();
        }
    }

    /**
     * Sub-routine used to compute the orders of the specified agents (long-term or
     * short-term) and place them in the specified bag
     *
     * @param iteration the iteration number being computed
     * @param agents    the collection of agents whose orders are being computed
     * @param orderBag  the bag into which the orders are gathered as they are being
     *                  generated
     * @param session   the session in progress
     */
    private void submitOrders(long iteration, DistCol<Agent> agents, DistBag<List<Order>> orderBag, Session session) {
        try {
            agents.parallelForEach(PARALLELISM, (agent, orderCollector) -> {
                final List<Order> orders = agent.submitOrders(markets);
                if (session.withPrint) {
                    output.orderSubmissionOutput(collector, SimulationStage.WITH_PRINT_DURING_SESSION, agent, orders,
                            markets);
                }
                if (orders != null && !orders.isEmpty()) {
                    orderCollector.accept(orders);
                }
            }, orderBag);
        } catch (final Exception e) {
            e.printStackTrace(System.err);
            if (e.getCause() != null) {
                System.err.println("---------- cause of errors -----------");
                e.getCause().printStackTrace(System.err);
            }
            throw e;
        }
    }

    /**
     * Sub-routine called after processing orders
     *
     * @param session the current session.
     */
    private void updateMarketMisc(Session session) {
        if (session.forDummyTimeseries) {
            sim.updateMarketsUsingFundamentalPrice(markets, sim.fundamentals);
        } else {
            sim.updateMarketsUsingMarketPrice(markets, sim.fundamentals);
        }
    }
}
