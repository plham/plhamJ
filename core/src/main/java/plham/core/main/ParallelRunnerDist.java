package plham.core.main;

import static apgas.Constructs.*;
import static plham.core.main.log.LogConstants.*;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
import handist.collections.dist.DistBag;
import handist.collections.dist.DistChunkedList;
import handist.collections.dist.DistCol;
import handist.collections.dist.DistLog;
import handist.collections.dist.DistMap;
import handist.collections.dist.DistMultiMap;
import handist.collections.dist.LongRangeDistribution;
import handist.collections.dist.TeamedPlaceGroup;
import handist.collections.util.SavedLog;
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

public class ParallelRunnerDist extends PlaceLocalObject {

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
     * @see ParallelRunnerDist#makeSimulationOutput(SimulationStage)
     * @see ParallelRunnerDist#makeSessionOutput(Session, SimulationStage)
     * @see ParallelRunnerDist#makeWithPrintOutput(Session, SimulationStage)
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

    /** Serial Version UID */
    private static final long serialVersionUID = -5954081821861048344L;

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
    public static ParallelRunnerDist initializeRunner(long seed, SimulationOutput simulationOutput, SimulatorFactory f,
            TeamedPlaceGroup pg) {
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
        // markets
        // The factory instance `f` should not be used any further, a proper instance
        // will be present
        // in each GlbRunner
        final Simulator simulator = f.makeNewSimulation(seed, true, false,
                new GlbAllocManager(pg, root, allAgentsCol, sAgentsCol, lAgentsCol));
        final CachableArray<Market> marketsCol = CachableArray.make(pg, simulator.markets);

        final Value config = f.CONFIG;

        // Then we create the "GlbRunner" on every place with all the
        // distributed collections given as parameter.
        // We also initialize the various Agents on each place as
        // necessary.
        final ParallelRunnerDist toReturn = PlaceLocalObject.make(pg.places(), () -> {
            final ParallelRunnerDist localRunner = new ParallelRunnerDist(root, pg, simulationOutput, config, seed,
                    contractedOrdersCol, allAgentsCol, lAgentsCol, sAgentsCol, lOrdersCol, sOrdersCol, marketsCol,
                    outputCollectorMap, log);

            // Create all agents
            localRunner.createAllAgents();
            allAgentsCol.updateDist();
            localRunner.allAgentsDistribution = allAgentsCol.getDistribution();
            localRunner.sAgents.registerDistribution(localRunner.allAgentsDistribution);
            localRunner.lAgents.registerDistribution(localRunner.allAgentsDistribution);

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
                ParallelRunnerDist
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
        final ParallelRunnerDist runnerOnWorld = ParallelRunnerDist.initializeRunner(seed, simulationOutput, factory,
                TeamedPlaceGroup.getWorld());
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
     * Distribution of agents across Places
     */
    private LongRangeDistribution allAgentsDistribution;
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

    private ParallelRunnerDist(Place r, TeamedPlaceGroup pg, SimulationOutput simulationOutput, Value config, long s,
            DistMultiMap<Long, AgentUpdate> contractedOrdersCol, DistCol<Agent> allAgentsCol, DistCol<Agent> lAgentsCol,
            DistCol<Agent> sAgentsCol, DistBag<List<Order>> lOrdersCol, DistBag<List<Order>> sOrdersCol,
            CachableArray<Market> marketsCol, DistMap<String, List<String>> outputCollectorMap, DistLog log)
            throws Exception {
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
     * Routine used to update the long-term and/or short-term agents held locally
     * which have made a trade. The information that a trade was made is contained
     * in the {@link #contractedOrders} member, with the index at which the updates
     * are stored corresponding to the agent to which the update needs to be
     * delivered.
     */
    private void executeRemoteAgentUpdate() {
        contractedOrders.parallelForEach((idx, updates) -> {
            // Retrieve the Agent from either sAgents or lAgents
            final Agent a = allAgents.get(idx);

            // Execute all the updates for this Agent one by one
            for (final AgentUpdate u : updates) {
                a.executeUpdate(u);
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
            if (isMaster) {
                logger.put(LOG_ITERATION_START, session.sessionName + ":" + id, "" + iterationStamp);
                iterSetup();
            }
            // final long idc = id; // final for use inside lambda expression

            markets.<MarketUpdate>broadcast(MarketUpdate::pack, MarketUpdate::unpack);

            // Submit short-term agent orders and gather them on root
            if (isMaster) {
                logger.put(LOG_SAGENTSUBMISSION_START, session.sessionName + ":" + id, "" + System.nanoTime());
            }
            sOrders.clear();
            submitOrders(id, sAgents, sOrders, session);
            try {
                sOrders.TEAM.gather(master);
            } catch (final Exception e) {
                e.printStackTrace();
                throw new RuntimeException("[GlbRunner] relocating contracted orders of long-term agents failed", e);
            }

            if (isMaster) {
                logger.put(LOG_SAGENTSUBMISSION_STOP, session.sessionName + ":" + id, "" + System.nanoTime());
                logger.put(LOG_PROCESSORDERS_START, session.sessionName + ":" + id, "" + System.nanoTime());
                addOrders(sOrders);
                handleOrders(session);
                logger.put(LOG_PROCESSORDERS_STOP, session.sessionName + ":" + id, "" + System.nanoTime());
                updateMarketMisc(session);
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
                contractedOrders.relocate(allAgentsDistribution);
            } catch (final Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Problem encountered when transmitting contracted orders to remote agents",
                        e);
            }

            if (!isMaster) {
                executeRemoteAgentUpdate();
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
                        contractedOrders.relocate(allAgentsDistribution);
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
                contractedOrders.relocate(allAgentsDistribution);
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
