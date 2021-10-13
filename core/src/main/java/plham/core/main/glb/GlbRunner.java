package plham.core.main.glb;

import static apgas.Constructs.*;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

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
import handist.collections.dist.TeamedPlaceGroup;
import handist.collections.function.SerializableBiConsumer;
import handist.collections.glb.DistFuture;
import handist.collections.glb.lifeline.Lifeline;
import handist.collections.util.SavedLog;

import static handist.collections.glb.GlobalLoadBalancer.underGLB;
import apgas.Place;
import apgas.util.PlaceLocalObject;
import cassia.util.JSON.Value;
import cassia.util.random.RandomPermutation;
import plham.core.Agent;
import plham.core.Event;
import plham.core.Market;
import plham.core.Market.AgentUpdate;
import plham.core.Market.MarketUpdate;
import plham.core.SimulationOutput.SimulationStage;
import plham.core.Order;
import plham.core.OutputCollector;
import plham.core.SimulationOutput;
import plham.core.main.Config;
import plham.core.main.Simulator;
import plham.core.main.Simulator.Session;
import plham.core.main.SimulatorFactory;
import plham.core.util.AgentAllocManager;
import plham.core.util.Random;

public class GlbRunner extends PlaceLocalObject {

    /**
     * This class is used for compatibility with sequential version of Market. As the markets assumes agents in the same
     * place, this class gather the information and pack them into DistMultiMap.
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
     * Class in charge of collecting the distributed entries during the various phases during which
     * an user defined output is made.  
     * @author Patrick Finnerty
     * @see GlbRunner#makeSimulationOutput(SimulationStage)
     * @see GlbRunner#makeSessionOutput(Session, SimulationStage)
     * @see GlbRunner#makeWithPrintOutput(Session, SimulationStage)
     */
    private class DistributedOutputCollector implements OutputCollector, Serializable {
        private static final long serialVersionUID = 5777744274622700033L;
        private final DistMap<String, List<String>> map;

        /**
         * Constructor
         * @param dmap underlying distributed map used to collect and relocated logged entries during the simulation
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
            List<String> toReturn = map.get(key);
            map.delete(key);
            return toReturn;
        }

        /**
         * Relocates all logged entries onto the master of the simulation so that the
         * {@link SimulationOutput#postProcess(OutputCollector, SimulationStage)} can
         * be called with all the needed information.
         */
        public void transferLogsToMaster() {
            map.team().gather(master);
        }
    }

    /**
     * Allocation manager in charge of deciding where the agents are initially created
     * and recording their presence in the relevant collection
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
        private GlbAllocManager(TeamedPlaceGroup pg, Place master, DistCol<Agent> allAgentsCol, DistChunkedList<Agent> shortAgents, DistChunkedList<Agent> longAgents) {
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
            LongRange floor = myRanges.floor(targetRange);
            if (floor != null && floor.isOverlapped(targetRange)) {
                return floor;
            }
            LongRange ceil = myRanges.ceiling(targetRange);
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
                        Chunk<Agent> chunk = new Chunk<>(range);
                        arbitrageurs.add(chunk);
                        allAgents.add(chunk);
                        //                        System.err.println("# HFT CHUNK ADDED: " + chunk.getRange());
                        return chunk;
                    } else {
                        return RangedListView.emptyView();
                    }
                } else {
                    if (factory.judgeHFTorNot(name)) {
                        return RangedListView.emptyView();
                    } else {
                        String classType = config.getOrElse("schedule", defaultScheduleType).toString();

                        // boolean longType = classType.equals("longTerm");
                        LongRange myrange = getAssignedRange(range);
                        if (myrange == null) {
                            return RangedListView.emptyView();
                        }
                        Chunk<Agent> chunk = new Chunk<>(myrange);
                        allAgents.add(chunk);
                        if (classType.startsWith("short")) {
                            sAgents.add(chunk);
                            //                            System.err.println("# SHORT-TERM CHUNK ADDED " + here() + ": " + chunk.getRange());
                        } else if (classType.startsWith("long")) {
                            lAgents.add(chunk);
                            //                            System.err.println("# LONG-TERM CHUNK ADDED " + here() + ": " + chunk.getRange());
                        } else {
                            throw new IllegalArgumentException("Unknown schedule option:" + classType);
                        }
                        return chunk;
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException("put chunk duplicated!" + here());
            }
        }

        public boolean hasLong() {
            return longRanges != null && !longRanges.isEmpty();
        }

        @Override
        public void registerRange(Value config, LongRange range, String name, SimulatorFactory factory) {
            String classType = config.getOrElse("schedule", defaultScheduleType).toString();
            if (factory.judgeHFTorNot(name)) {
                if (arbRanges == null)
                    arbRanges = new ArrayList<>();
                arbRanges.add(range);
                // System.err.println("ARB:" + range);
            } else if (classType.startsWith("short")) { // Resolve long/short using className
                if (shortRanges == null)
                    shortRanges = new ArrayList<>();
                shortRanges.add(range);
                // System.err.println("short:" + range);
            } else if (classType.startsWith("long")) {
                if (longRanges == null)
                    longRanges = new ArrayList<>();
                longRanges.add(range);
                // System.err.println("long:" + range);
            } else {
                throw new IllegalArgumentException("Unknown schedule option:" + classType);
            }
        }

        @Override
        public void scanDone() {
            // Determine how agents are distributed on worker places.
            if (myRanges == null)
                myRanges = new TreeSet<>();
            if (isMaster) {
                for (LongRange r : arbRanges) {
                    myRanges.add(r);
                }
            } else {
                int numWorkers = placeGroup.size() - 1;
                splitAndGetMine(shortRanges, numWorkers);
                splitAndGetMine(longRanges, numWorkers);
            }
        }

        @Override
        public void setTotalCount(long size) {
            sim.numAgents = size;
        }

        public void splitAndGetMine(List<LongRange> ranges, int numWorkers) {
            if (ranges == null)
                return;
            if (ranges.isEmpty())
                return;
            List<List<LongRange>> split = LongRange.splitList(numWorkers, ranges);
            List<LongRange> mine = split.get(placeGroup.rank() - 1);
            for (LongRange r : mine)
                if (r.size() > 0)
                    myRanges.add(r);
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
            int result = Long.compare(priority, o.priority);
            if (result == 0)
                Long.compare(agentid, o.agentid);
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
     * @param seed the seed used to launch the simulation
     * @param simulationOutput the output to be extracted from the simulation
     * @param f the factory used to initialize members of the computation
     * @param pg place group on which the simulation will be run
     * @return runner instance ready to launch the computation
     */
    @SuppressWarnings("unchecked")
    public static GlbRunner initializeRunner(long seed, SimulationOutput simulationOutput, SimulatorFactory f, TeamedPlaceGroup pg) {
        Place root = here(); // Root is going to be the place where high-frequency agents are located

        // We create every distributed collections first
        DistMultiMap<Long, AgentUpdate> contractedOrdersCol = new DistMultiMap<>(pg);
        DistCol<Agent> allAgentsCol = new DistCol<>(pg);
        DistCol<Agent> lAgentsCol = new DistCol<>(pg);
        DistCol<Agent> sAgentsCol = new DistCol<>(pg);
        DistLog log = new DistLog(pg);

        String lifelineName = System.getProperty(Config.LIFELINE_CLASS, Config.LIFELINE_CLASS_DEFAULT);
        Class<? extends Lifeline> lifelineClass = null;
        try {
            lifelineClass = (Class<? extends Lifeline>) Class.forName(lifelineName);
        } catch (Exception e) {
            System.err.println("Could not find class " + lifelineName);
            e.printStackTrace();
            System.err.println("Using " + Config.LIFELINE_CLASS_DEFAULT + " instead");
            try {
                lifelineClass = (Class<? extends Lifeline>) Class.forName(Config.LIFELINE_CLASS_DEFAULT);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }
        lAgentsCol.GLB.setLifeline(lifelineClass);
        sAgentsCol.GLB.setLifeline(lifelineClass);
        DistBag<List<Order>> lOrdersCol = new DistBag<>(pg);
        DistBag<List<Order>> sOrdersCol = new DistBag<>(pg);
        DistMap<String, List<String>> outputCollectorMap = new DistMap<>(pg);

        // Creating a simulator in anticipation to initialize distributed array of markets
        // The factory instance `f` should not be used any further, a proper instance will be present
        // in each GlbRunner
        Simulator simulator = f.makeNewSimulation(seed, true, false, new GlbAllocManager(pg, root, allAgentsCol, sAgentsCol, lAgentsCol));
        CachableArray<Market> marketsCol = CachableArray.make(pg, simulator.markets);

        final Value config = f.CONFIG;

        // Then we create the "GlbRunner" on every place with all the
        // distributed collections given as parameter. 
        // We also initialize the various Agents on each place as
        // necessary. 
        GlbRunner toReturn = PlaceLocalObject.make(pg.places(), () -> {
            GlbRunner localRunner = new GlbRunner(root, pg, simulationOutput, config, seed, 
                    contractedOrdersCol, allAgentsCol, lAgentsCol, sAgentsCol, 
                    lOrdersCol, sOrdersCol, marketsCol, outputCollectorMap, log);

            // Create all agents
            localRunner.createAllAgents();
            // Re-split the allocated chunks for better parallelism with
            // the existing GLB infrastructure
            teamed_splitAgentsToParallelismLevel(localRunner.sAgents);
            teamed_splitAgentsToParallelismLevel(localRunner.lAgents);

            allAgentsCol.updateDist();

            return localRunner;
        });

        // Modifications specific to master     
        allAgentsCol.setProxyGenerator((index) -> {
            return new AgentUpdateProxy(index, contractedOrdersCol);
        });

        return toReturn;
    }

    /**
     * Main method. 
     * Launches a simulation on the entire world. 
     * @param args output class producing output, JSON simulation configuration, seed 
     */
    public static void main(String[] args) {
        // Argument checking
        if (args.length < 3) {
            System.err.println("Program arguments for GlbRunner:");
            System.err.println("\tOutput class (defines the outputs to extract from the simulation");
            System.err.println("\tJSON configuration file");
            System.err.println("\tseed");
            System.err.println("\t[JSON warmup] Configuration for warmup (optional)");
            return;
        }

        // Argument parsing
        String outputClassName = args[0];
        String JsonConfigurationFile = args[1];
        String seedArg = args[2];

        SimulationOutput simulationOutput = null;

        try {
            Class<?> outputClass = Class.forName(outputClassName);
            simulationOutput = (SimulationOutput) outputClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            System.err.println("Could not create an instance of outputClassName");
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            System.err.println("Could not find class " + outputClassName);
            System.err.println("Check you classpath and for any typo");
            e.printStackTrace();
            return;
        }

        SimulatorFactory factory;
        try {
            factory = new SimulatorFactory(JsonConfigurationFile);
        } catch (Exception e) {
            System.err.println("Problem encountered when attemting to open file " + JsonConfigurationFile);
            e.printStackTrace();
            return;
        }

        long seed;
        try {
            seed = Long.parseLong(seedArg);
        } catch (NumberFormatException e) {
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
                SimulatorFactory warmupFactory = new SimulatorFactory(warmupFile);
                GlbRunner.initializeRunner(100, new SimulationOutput(), warmupFactory, TeamedPlaceGroup.getWorld()).run();
                warmupTime = System.nanoTime() - warmupTime;
                System.err.println("# Warmup completed in (s) " + (warmupTime / 1e9));
            } catch (Exception e) {
                System.err.println("Error during warmup");
                e.printStackTrace();
            }
        }

        // Create the simulator
        long TIME_INIT = System.nanoTime();
        GlbRunner runnerOnWorld = GlbRunner.initializeRunner(seed, simulationOutput, factory, TeamedPlaceGroup.getWorld());
        TIME_INIT = System.nanoTime() - TIME_INIT;        
        System.err.println("# INIT TIME (s) " + TIME_INIT/1e9);

        // Run simulation
        long simulationStart = System.nanoTime();
        runnerOnWorld.run();
        long simulationStop = System.nanoTime();
        System.err.println("# EXECUTION TIME (s) " + (simulationStop - simulationStart)/1e+9);

        // Post simulation, write the logged data to a file if specified
        if (System.getProperties().containsKey(Config.SAVE_LOG_TO_FILE)) {
            String fileName = System.getProperty(Config.SAVE_LOG_TO_FILE);
            System.err.println("# Saving distributed log to " + fileName);
            try {
                new SavedLog(runnerOnWorld.logger).saveToFile(new File(fileName));
            } catch (Exception e) {
                System.err.println("# Problem encountered while saving distributed log to file");
                e.printStackTrace();
            }
        }
    }

    /**
     * Sub-routine used to further split the chunks so that there are enough chunks for each thread 
     * to receive some work when the GLB program starts. 
     * The distribution of the agent collection is updated in a teamed activity at the end of this 
     * procedure.
     * <p>
     * <em>Implementation notes:</em> Currently every chunk present on the host is further divided
     * into the same number of smaller chunks, regardless of the respective sizes of each chunk present
     * in the collection. This means that in cases where there are chunks of different sizes, the sizes
     * of the chunks when this operation has completed will vary.
     */
    private static void teamed_splitAgentsToParallelismLevel(DistCol<Agent> agents) {
        Collection<LongRange> initialRanges = agents.getAllRanges();
        int rangeCount = initialRanges.size();
        if (rangeCount == 0) {
            // Not possible to increase number of chunks if no elements contained locally
            // Update distribution in case of remote changes and return
            agents.updateDist();
            return;
        }
        final int workerThreadCount = Runtime.getRuntime().availableProcessors();
        int dividingFactor = 1;
        while (rangeCount * dividingFactor < workerThreadCount) {
            dividingFactor ++;
        }

        if (dividingFactor >= 1) {
            // Else, divide each chunk into `dividingFactor` parts
            for (LongRange range : initialRanges) {
                List<LongRange> splitRanges = range.split(dividingFactor);
                splitRanges.removeIf(lr -> lr.from==lr.to); // Exclude empty ranges from splitRanges
                for (LongRange split : splitRanges) {
                    agents.splitChunks(split);
                }
            }
        }
        agents.updateDist();
    }
    /**************************************************************************
     * Members related to the simulation participants                         *
     *************************************************************************/
    /** Distributed collection used to distribute the updates to the agents that have been involved in a trade */
    final DistMultiMap<Long, AgentUpdate> contractedOrders;
    /** Factory object in charge of initializing the objects taking part in the simulation */ 
    transient SimulatorFactory factory;
    /** 
     * Orders located on the master, used to keep orders between iterations and sessions.
     * This member is kept {@code null} on processes other than root. 
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

    /** Class specifying the outputs to make during the simulation*/
    final transient SimulationOutput output;
    /**************************************************************************
     * Members related to runtime                                             *
     *************************************************************************/
    /** Flag used to toggle the performance tracking parts of the runner */
    public boolean _PROFILE = false;
    /** Local handle of the distributed logging system */
    final DistLog logger;
    /** Group of processes on which the simulation is running */
    final transient TeamedPlaceGroup placeGroup;
    /** "Root" of the simulation, where high-frequency traders are located and orders processed */
    final transient Place master;
    //    /** Level of parallelism available / to use on the local host */
    //    private final int PARALLELISM;
    /** Seed used to run the simulation */
    final long seed;
    /** Initial allocation of agents over the hosts, not initialized as part of the constructor */
    final private GlbAllocManager agentAllocationManager;
    /** Output collector */
    final DistributedOutputCollector collector;
    /**
     * Indicates if the process running is the "master" of the simulation, i.e. the place
     * containing the high-frequency traders and where all orders are processed.  
     */ 
    final boolean isMaster;

    /** Simulator providing local access methods to other objects on local host*/
    transient Simulator sim;

    private GlbRunner(Place r, TeamedPlaceGroup pg, SimulationOutput simulationOutput, Value config, long s, DistMultiMap<Long, AgentUpdate> contractedOrdersCol, 
            DistCol<Agent> allAgentsCol, DistCol<Agent> lAgentsCol, DistCol<Agent> sAgentsCol, 
            DistBag<List<Order>> lOrdersCol, DistBag<List<Order>> sOrdersCol, 
            CachableArray<Market> marketsCol, DistMap<String, List<String>> outputCollectorMap, DistLog log) throws Exception {
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

        //        PARALLELISM = Runtime.getRuntime().availableProcessors();

        factory = new SimulatorFactory(config);
        agentAllocationManager = new GlbAllocManager(pg, master, allAgentsCol, sAgentsCol, lAgentsCol);
        sim = factory.makeNewSimulation(seed, true, false, agentAllocationManager);
        agentAllocationManager.sim = sim;

        // Switch the collections contained in Simulator for the distributed versions
        sim.markets = marketsCol;
        sim.agents = allAgentsCol;

        // Set the Simulator member of each market
        for (Market m : marketsCol) {
            m.env = sim;
        }
    }

    /**
     * Method used to add orders received from remote agents into the processing
     * machine located on the "master" of the simulation 
     * @param orders the bag of orders newly received
     */
    private void addOrders(Bag<List<Order>> orders) {
        keptOrders.addBag(orders);
        orders.clear();
    }

    private void createAllAgents() {
        Value agentConfigList = factory.CONFIG.get("simulation").get("agents");
        factory.createAllAgents(agentConfigList, agentAllocationManager);
    }

    /**
     * Routine used to update the long-term and/or short-term agents held locally which have
     * made a trade. The information that a trade was made is contained in the 
     * {@link #contractedOrders} member, with the index at which the updates are stored 
     * corresponding to the agent to which the update needs to be delivered.
     */
    private void executeRemoteAgentUpdate() {
        contractedOrders.parallelForEach((idx, updates) -> {
            // Retrieve the Agent from either sAgents or lAgents
            Agent a = allAgents.get(idx);

            // Execute all the updates for this Agent one by one
            for (AgentUpdate u : updates) {
                a.executeUpdate(u);
            }
        });
    }

    /**
     * Calls for the update of all short-term agents on this local host
     */
    private void executeShortTermAgentUpdate() {
        contractedOrders.parallelForEach((idx, updates) -> {
            // Retrieve the Agent from either sAgents or lAgents
            Agent a = sAgents.get(idx);

            // Execute all the updates for this Agent one by one
            for (AgentUpdate u : updates) {
                a.executeUpdate(u);
            }
        });
    }

    private void handleOrders(Session session) {
        long beginTime = System.nanoTime();
        List<List<Order>> allOrders = new ArrayList<>();
        //        List<Market> markets = markets;

        Random random = sim.getRandom();
        Random tmpRandom = new Random(System.nanoTime());
        if (sim.hifreqAgents == null) {
            sim.hifreqAgents = new ChunkedList<>();
        }
        RandomPermutation<Agent> randomArbs = new RandomPermutation<>(random.split(), sim.hifreqAgents);
        Collection<List<Order>> randomOrders = myShuffle(random.split());

        for (List<Order> someOrders : randomOrders) {
            // This handles one order-list submitted by an agent per loop.
            // TODO: If needed, one-market one-order handling ?
            for (Order order : someOrders) {
                Market m = markets.get(((int) order.marketId));
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
            for (Agent agent : randomArbs) {
                if (k >= session.maxHighFreqOrders) {
                    break;
                }
                List<Order> orders = agent.submitOrders(markets);
                if (session.withPrint) {
                    output.orderSubmissionOutput(collector, SimulationStage.WITH_PRINT_DURING_SESSION, agent, orders,
                            markets);
                }

                if (!orders.isEmpty())
                    allOrders.add(orders);

                if (orders.size() > 0) {
                    for (Order order : orders) {
                        Market m = markets.get((int) order.marketId);
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

        long endTime = System.nanoTime();
        if (_PROFILE) {
            System.err.println("# handle orders took " + (endTime - beginTime));
        }
    }

    private void iterateMarketUpdatesNoPipeline(Session session) {
        if (!session.withOrderPlacement) {
            throw new RuntimeException("Was about to start a session without order placement, this should not happen");
        }

        marketSetup(session.withOrderExecution);

        for (long id = 0; id < session.iterationSteps; id ++) {
            // final long idc = id; // final for use inside lambda expression
            iterSetup();

            placeGroup.broadcastFlat(()->{
                markets.<MarketUpdate>broadcast(MarketUpdate::pack, MarketUpdate::unpack);
            });

            // Submit short-term agent orders
            sAgents.GLB.toBag((Agent agent,Consumer<List<Order>> orderCollector)->{
                List<Order> orders = agent.submitOrders(markets);
                if (session.withPrint) {
                    output.orderSubmissionOutput(collector, SimulationStage.WITH_PRINT_DURING_SESSION, agent, orders, markets);
                }
                if (orders != null && !orders.isEmpty()) {
                    orderCollector.accept(orders);
                }
            }, sOrders).result(); // blocking call 


            placeGroup.broadcastFlat(()->{
                try {
                    sOrders.TEAM.gather(master);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("[GlbRunner] relocating contracted orders of long-term agents failed", e);
                }

                // Update distribution of sAgents after the GLB part completed
                sAgents.updateDist();

                if (isMaster) {
                    addOrders(sOrders);
                    handleOrders(session);
                    updateMarketMisc(session);
                }

                if (session.withPrint) {
                    makeWithPrintOutput(session, SimulationStage.WITH_PRINT_DURING_SESSION);
                }

                if (isMaster) postStepMarketUpdate();

                for (Market market: markets) {
                    market.updateTime();
                }   

                try {
                    contractedOrders.relocate(sAgents.getDistributionLong()); // not allAgents, as only sAgents are used in this schedule
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("Problem encountered when transmitting contracted orders to remote agents", e);
                }

                executeShortTermAgentUpdate();
            });
        }
        if (isMaster && session.withPrint) {
            makeWithPrintOutput(session, SimulationStage.WITH_PRINT_END_SESSION);
        }

    }

    private void iterateMarketUpdatesPipeline(Session session) {
        if (!session.withOrderExecution) {
            throw new RuntimeException("Was about to start a session without order placement, this should not happen");
        }

        marketSetup(session.withOrderExecution);
        iterSetup();

        /** 
         * Action performed by sAgents and lAgents under GLB. 
         * Kept as final variable to reduce code size
         */
        final SerializableBiConsumer<Agent, Consumer<List<Order>>> orderSubmissionAction = (agent, orderCollector)->{
            List<Order> orders = agent.submitOrders(markets);
            if (session.withPrint) {
                output.orderSubmissionOutput(collector, SimulationStage.WITH_PRINT_DURING_SESSION, agent, orders, markets);
            }
            if (orders != null && !orders.isEmpty()) {
                orderCollector.accept(orders);
            }
        };

        // Broadcast the updated state of the market on every host
        placeGroup.broadcastFlat(()->{
            markets.<Market.MarketUpdate>broadcast(MarketUpdate::pack, MarketUpdate::unpack);
        });
        // Run every iteration required by the session
        for (long id = 0; id < session.iterationSteps; id++) {
            final long idc = id; // Final long for use in closures 
            System.err.println("Iteration " + idc + " starting");

            // PART 1: Compute short-term agents orders,
            //         Relocate long-term orders to Place 0 (if not 1st iteration)
            sOrders.clear(); // Prepare bag to receive the orders from short-term agents

            DistFuture<DistBag<List<Order>>> sAgentFuture = sAgents.GLB.toBag(orderSubmissionAction, sOrders);
            //GlobalLoadBalancer.start(); // Launch the GLB computations asynchronously
            sAgentFuture.result();
            //            System.err.println("Iteration " + idc + " part 1 short-term orders computed");
            // In parallel, proceed with a number of relocations
            if (idc > 0) {
                placeGroup.broadcastFlat(()->{
                    // If not the 1st iteration of the session ...

                    // ... relocate contracted orders for update  ...
                    try {
                        contractedOrders.relocate(allAgents.getDistributionLong());
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException("[GlbRunner] relocating contracted orders of long-term agents failed", e);
                    }

                    // ... and gather the lOrders produced in Part 2 on Place 0
                    lOrders.TEAM.gather(master);
                    if (isMaster) {
                        addOrders(lOrders);
                    }
                });
                //                System.err.println("Iteration " + idc + " part 1 contracts and processing done");
            }

            // Block until short-term orders complete execution
            // sAgentFuture.result(); 

            // Execute the contracted orders' update
            placeGroup.broadcastFlat(()-> executeRemoteAgentUpdate());

            //            System.err.println("Iteration " + idc + " part 1 updates completed");

            // Part 2: Compute long-term agents orders,
            //  Overlapping:
            //         Relocate short-term orders to Place 0
            //         Handle the orders
            DistFuture<DistBag<List<Order>>> lAgentFuture = lAgents.GLB.toBag(orderSubmissionAction, lOrders);
            //GlobalLoadBalancer.start();
            lAgentFuture.result();

            placeGroup.broadcastFlat(()->{
                try {
                    sOrders.TEAM.gather(master);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("[GlbRunner] relocation contracted orders of short-term agents", e);
                }

                if (isMaster) {
                    //                    System.err.println("Iteration " + idc + " part 2 sOrders relocation complete");
                    addOrders(sOrders);
                    handleOrders(session);
                    if (idc + 1 < session.iterationSteps) {
                        // Misc. updates to perform
                        updateMarketMisc(session);
                    }
                    //                    System.err.println("Iteration " + idc + " part 2 orders handled");
                }
            });

            //            lAgentFuture.result(); // Block until operation complete
            //            System.err.println("Iteration " + idc + " part 2 lOrders computed");


            // Output during session (except if last iteration of the session)
            if (idc + 1 < session.iterationSteps && session.withPrint) {
                placeGroup.broadcastFlat(()->makeWithPrintOutput(session, SimulationStage.WITH_PRINT_DURING_SESSION));
            }

            postStepMarketUpdate();
            if (idc + 1 < session.iterationSteps) {
                for (Market m : markets) {
                    m.updateTime();
                }
                iterSetup();
            }
            //            System.err.println("Iteration " + idc + " part 2 lOrders Computed");

            placeGroup.broadcastFlat(()-> markets.<Market.MarketUpdate>broadcast(MarketUpdate::pack, MarketUpdate::unpack)); // FIXME necessary?

        } // End of the for loop over session iteration

        // Part 1 bis
        // Extra block to handle the long-term orders generated in part 2 of the last iteration of the for loop
        { 
            placeGroup.broadcastFlat(()-> {
                lOrders.TEAM.gather(master);
                if (isMaster) {
                    addOrders(lOrders);
                    handleOrders(session);
                    updateMarketMisc(session);
                }
                try {
                    contractedOrders.relocate(allAgents.getDistributionLong());
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("[GlbRunner] relocating contracted orders failed" ,e);
                }


                executeRemoteAgentUpdate(); // FIXME
                if (session.withPrint) {
                    makeWithPrintOutput(session, SimulationStage.WITH_PRINT_DURING_SESSION);
                }
                if (isMaster) {
                    postStepMarketUpdate();
                }


                //                if (isMaster) {
                //                    if (session.withPrint) {
                //                        makeWithPrintOutput(session, SimulationStage.WITH_PRINT_DURING_SESSION);
                //                    }
                //                    postStepMarketUpdate();
                //                } else {
                //                    // TODO 27th September 2021 
                //                    // Should the output call be made BEFORE or AFTER the agents receive their 
                //                    // update? Left as "AFTER" for now, might be revisited later.
                //                    // This does not matter if the the SimulationOutput#agentOutput method is 
                //                    // not overridden. 
                //                    executeRemoteAgentUpdate();
                //                    if (session.withPrint) {
                //                        makeWithPrintOutput(session, SimulationStage.WITH_PRINT_DURING_SESSION);
                //                    }
                //                }
            });
        } // end of Part 1 bis extra block

        // Last output of the session if "withPrint" set
        if (session.withPrint) {
            placeGroup.broadcastFlat(()-> makeWithPrintOutput(session, SimulationStage.WITH_PRINT_END_SESSION));
        }
    }

    /**
     * Setup routine run on master before the first iteration of a session
     */
    private void iterSetup() {
        sim.updateFundamentals(sim.fundamentals);
        for (Market m : markets) {
            m.triggerBeforeSimulationStepEvents();
        }
    }

    /** 
     * Sub-routine called at the beginning and end of a session to make outputs for a simulation
     * @param s the session about to start or which has completed
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

        if (isMaster) output.postProcess(collector, stage);
        collector.clear();
    }

    /**
     * Helper method called on each place at the beginning and the end of the simulation
     * @param stage current stage of the simulation (either {@link SimulationStage#BEGIN_SIMULATION} or {@link SimulationStage#END_SIMULATION}).
     */
    private void makeSimulationOutput(SimulationStage stage) {
        if (isMaster) {          
            outputMarket(stage); 
        }
        outputAgent(stage);

        collector.transferLogsToMaster();

        if (isMaster) output.postProcess(collector, stage);
        // Remove all collected entries before next output
        collector.clear();
    }

    /**
     * Sub-routine called when the "withPrint" option is set to true for a session
     * @param s the session in progress
     * @param stage the stage in the simulation, either {@link SimulationStage#WITH_PRINT_DURING_SESSION}
     *        or {@link SimulationStage#WITH_PRINT_END_SESSION}.
     */
    private void makeWithPrintOutput(Session s, SimulationStage stage) {
        if (isMaster) {
            output.sessionOutput(collector, stage, s);
            outputMarket(stage);
        }
        outputAgent(stage);
        outputEvent(stage);

        collector.transferLogsToMaster();

        if (isMaster) output.postProcess(collector, stage);
        collector.clear();
    }

    /**
     * Initialization routine run at the beginning of a session on the master
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
     * @param random the object used to provide pseudo-random numbers
     * @return re-ordered collection of orders
     */
    private Collection<List<Order>> myShuffle(Random random) {
        TreeMap<Ox, List<Order>> sorted = new TreeMap<>();
        for (List<Order> orderSet : keptOrders) {
            if (orderSet.isEmpty())
                continue;
            long agentId = orderSet.get(0).agentId;
            long priority = random.getNthLong(agentId);
            sorted.put(new Ox(priority, agentId, orderSet), orderSet);
        }
        keptOrders.clear();
        return sorted.values();
    }

    /**
     * Helper method which collects the output of every Agent with the specified stage
     * @param stage the current simulation stage
     */
    private void outputAgent(SimulationStage stage) {
        for (Agent a : sAgents) {
            output.agentOutput(collector, stage, a);
        }
        for (Agent a : lAgents) {
            output.agentOutput(collector, stage, a);
        }
        for (Agent a : sim.hifreqAgents) {
            output.agentOutput(collector, stage, a);
        }
    }

    /**
     * Helper method which collects the output of every event in the current session
     * @param stage the current simulation stage
     */
    private void outputEvent(SimulationStage stage) {
        // There are sessions which do not contain any event, 
        // in which case we return immediately
        if (sim.sessionEvents == null) return;

        for (Event e : sim.sessionEvents) {
            output.eventOutput(collector, stage, e);
        }
    }

    /**
     * Helper method which collects the output of every market with the specified stage
     * @param stage the current simulation stage
     */
    private void outputMarket(SimulationStage stage) {
        for (Market m : markets) {
            output.marketOutput(collector, stage, m);
        }
    }

    /**
     * Sub-routine called at the end of an iteration
     */
    private void postStepMarketUpdate() {
        for (Market market : markets) {
            market.triggerAfterSimulationStepEvents();
            market.updateOrderBooks();
        }
    }

    public void run() {
        // First, determine which schedule needs to be used based on the presence
        // of long-term agents in the simulation
        final boolean usePipeline = agentAllocationManager.hasLong() || Boolean.parseBoolean(System.getProperty(Config.FORCE_PIPELINE_SCHEDULE, "false"));

        placeGroup.broadcastFlat(()->{
            makeSimulationOutput(SimulationStage.BEGIN_SIMULATION);
        });
        for (Session session : sim.sessions) {
            sim.sessionEvents = factory.createEventsForASession(session, sim);
            placeGroup.broadcastFlat(()->{    
                makeSessionOutput(session, SimulationStage.BEGIN_SESSION);
            });
            // placeGroup.barrier(); // This barrier was used when timing the simulator
            if (usePipeline) {
                underGLB(logger, ()->iterateMarketUpdatesPipeline(session));
            } else {
                underGLB(logger, ()->iterateMarketUpdatesNoPipeline(session));
            }
            placeGroup.broadcastFlat(()->{
                makeSessionOutput(session, SimulationStage.END_SESSION);
            });
        }
        placeGroup.broadcastFlat(()->{
            makeSimulationOutput(SimulationStage.END_SIMULATION);
        });
    }

    /**
     * Sub-routine called after processing orders
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
