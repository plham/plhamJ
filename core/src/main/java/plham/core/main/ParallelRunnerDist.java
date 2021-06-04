package plham.core.main;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import apgas.Place;
import apgas.util.PlaceLocalObject;
import cassia.util.JSON;
import cassia.util.JSON.Value;
import cassia.util.random.RandomPermutation;
import handist.collections.*;
import handist.collections.dist.CachableArray;
import handist.collections.dist.DistBag;
import handist.collections.dist.DistCol;
import handist.collections.dist.DistMultiMap;
import handist.collections.dist.TeamedPlaceGroup;
import plham.core.*;
import plham.core.Market.AgentUpdate;
import plham.core.util.AllocManager;
import plham.core.util.Random;
import plham.core.main.Simulator.Session;
import plham.core.main.ParallelRunnerMT.Step;
import plham.core.SimulationOutput.SimulationStage;

import static apgas.Constructs.finish;
import static apgas.Constructs.here;
import static plham.core.main.ParallelRunnerMT.DEFAULT_THREAD_COUNT;
import static plham.core.main.ParallelRunnerMT.PARALLEL_RUNNER_THREAD_PROPERTY;

/**
 * ParallelRunnerDist is a simple runner for distributed environments.
 * The instance is first created in the master node (place) and then sent to
 * worker nodes.
 * This class is {@code Serializable} but not {@code PlaceLocalHandle} or
 * {@code DistributedCollection}, so when the instance is transported to
 * other places, the copy of the instance is transferred to the destination place.
 *
 *
 *
 */

public final class ParallelRunnerDist extends Runner {
    public static class DistOutputCollector implements OutputCollector {
        public ConcurrentHashMap<String, List<Object>> map = new ConcurrentHashMap<>();
        @Override
        public void print(String message) {
            System.out.println(here().toString() +":"+message);
        }

        @Override
        public Map<String, List<Object>> getLogs() {
            return map;
        }

        @Override
        public void log(String topic, Object o) {
            List<Object> listOfTopic = map.computeIfAbsent(topic, k -> {return new ArrayList<>();});
            listOfTopic.add(o);
        }
        public void clear(){
            map.clear();
        };
    }

    /**
     * This class is used for compatibility with sequential version of Market.
     * As the markets assumes agents in the same place, this class gather the
     * information and pack them into DistMultiMap.
     *
     */
    static class AgentUpdateProxy extends Agent.Proxy {
        /**
         *
         */
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

    /*
     * TODO var agentDistribution: Rail[Place];
     */

    /**
     * This class is used to summarizes the handles to distributed collections that
     * manages the simulation status.
     * In the sequential or MT version, {@code Simulator} plays the role to manages agents or markets.
     * However, the agents and markets are now managed by distributed collections, so this class manages
     * the distributed collections instead.
     * Maybe it will be used to save/restore/duplicate the simulation.
     *
     */
    static class BranchHandle extends PlaceLocalObject { // TODO TK no need for PLO?
        // TODO short/long-term agents for Fujishima's scheduling.
        DistCol<Agent> allAgents;
        DistMultiMap<Long, Market.AgentUpdate> contractedOrders;
        CachableArray<Market> markets;

        DistBag<List<Order>> orders;
        TeamedPlaceGroup placeGroup;
        ParallelRunnerDist runner;
        SimulatorFactory factory;

        // TODO orders
        public BranchHandle(TeamedPlaceGroup placeGroup,
                CachableArray<Market> markets, DistCol<Agent> allAgents, DistBag<List<Order>> orders,
                DistMultiMap<Long, AgentUpdate> contractedOrders) {
            this.placeGroup = placeGroup;
            this.markets = markets;
            this.allAgents = allAgents;
            this.orders = orders;
            this.contractedOrders = contractedOrders;
        }

        public boolean isMaster() {
            return placeGroup.rank() == 0;
        }
    }

    /**
     * This represents a diff information of Markets.
     * CachableArray broadcasts the diff from master to workers.
     */
    static public class MarketInfo {
        static MarketInfo pack(Market m) {
            return new MarketInfo(m._isRunning, m.getLastMarketPrice(), m.getLastFundamentalPrice(), m.getTime());
        }

        static void unpack(Market m, MarketInfo mi) {
            m._isRunning = mi._isRunning;
            // TODO (int)
            m.marketPrices.set((int) mi.time, mi.marketPrice);
            m.fundamentalPrices.set((int) mi.time, mi.fundamentalPrice);
            m.setTime(mi.time);
        }

        boolean _isRunning;
        double fundamentalPrice;

        double marketPrice;

        long time;

        public MarketInfo(boolean _isRunning, double marketPrice, double fundamentalPrice, long time) {
            this._isRunning = _isRunning;
            this.marketPrice = marketPrice;
            this.fundamentalPrice = fundamentalPrice;
            this.time = time;
        }
    }

    /**
     *
     */
    private static final long serialVersionUID = -8584132179986832924L;

    /**
     * Utility method which checks how many threads this runner should run with
     *
     * @return the level of parallelism desired
     */
    private static int initializeNThreads() {
        //        String NTHREADS_ENV = System.getenv("NTHREADS");
        //        if (NTHREADS_ENV != null) {
        //            try {
        //                return Integer.parseInt(NTHREADS_ENV);
        //            } catch (RuntimeException e) {
        //                System.err.println("[Env: NTHREADS] " + NTHREADS_ENV + " is not integer (parse error).");
        //            }
        //        } else {
        return Integer.parseInt(System.getProperty(PARALLEL_RUNNER_THREAD_PROPERTY, DEFAULT_THREAD_COUNT));
    }
    // TODO TK range for arbitragers.
    transient ArrayList<LongRange> arbRanges = new ArrayList<>();

    /**
     * The distributed simulation data, which consist of constant data, a list of distributed collections.
     *
     */
    BranchHandle bh;
    // TODO TK String->place?
    private final String here;

    transient TreeSet<LongRange> myRanges = new TreeSet<>();

    int NPLACES;

    int NTHREADS;

    transient ArrayList<LongRange> ordRanges = new ArrayList<>();
    // TODO duplicated with MT (if RunnerDist extends RunnerMT)
    transient private ExecutorService pool;
    long TIME_THE_BEGINNING;

    public ParallelRunnerDist(SimulationOutput sim, SimulatorFactory factory) {
        this(sim, factory, initializeNThreads());
    }

    public ParallelRunnerDist(SimulationOutput simulation, SimulatorFactory factory, int nthreads) {
        super(simulation, factory);
        NTHREADS = nthreads;
        here = here().toString();
    }

    private OutputCollector out;
    public void setLogger(OutputCollector out) {
        this.out = out;
    }

    /**
     * DistRunner calcuarates the distribution of agents and then
     * requests factory for agent/markets creation.
     */
    void createAllAgents(JSON.Value list) {
        // TODO
        // val randoms = new RandomSequenceBySplit(sim.getRandom());
        sim.hifreqAgents = new ArrayList<>();
        assert (factory.CONFIG != null);
        AllocManager<Agent> dm = new AllocManager<Agent>() {
            @Override
            public RangedList<Agent> getRangedList(JSON.Value config, LongRange range) {
                // TODO JSON.value
                JSON.Value className = config.get("class");
                JSON.Value classType = config.get("schedule");
                try {
                    if (bh.isMaster()) {
                        if (classType.equals("arbitrager")) {
                            debug(here + " rangeForArbitrage = " + range);
                            debug(here + " type " + sim.agents);
                            Chunk<Agent> chunk = new Chunk<>(range);
                            bh.allAgents.add(chunk);
                            return chunk;
                        } else {
                            return RangedListView.<Agent>emptyView();
                        }
                    } else {
                        if (classType.equals("arbitrager")) {
                            return RangedListView.<Agent>emptyView();
                        } else {
                            // boolean longType = classType.equals("longTerm");
                            LongRange myrange = getAssignedRange(range);
                            if (myrange == null) {
                                return RangedListView.<Agent>emptyView();
                            }
                            Chunk<Agent> chunk = new Chunk<>(myrange);
                            bh.allAgents.add(chunk);
                            /*
                             * if(longType) longTermAgents.putChunk(chunk); else shortTermAgents.putChunk(chunk);
                             * debug("place:"+here+" alloc "+myrange+ " @" + (longType?"long":"short"));
                             */
                            return chunk;
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException("put chunk duplicated!");
                }
            }

            @Override
            public void registerRange(Value config, LongRange range) {
                registerConfigAndRange(config, range);
            }

            @Override
            public void scanDone() {
                separateAgentRanges();
            }

            @Override
            public void setTotalCount(long size) {
                sim.numAgents = size;
            }

            @Override
            public boolean use2scan() {
                return true;
            }
        };
        factory.createAllAgents(list, dm /* , sim */);
    }

    private void debug(Object o) {
        System.err.println(o);
    }

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

    public void iterateMarketUpdates(OutputCollector output, Session s, Fundamentals fundamentals) {
        bh.placeGroup.barrier();
        iterateMarketUpdatesPara(output, s, fundamentals);
    }

    public void iterateMarketUpdatesPara(OutputCollector out, Session s, Fundamentals fundamentals) {
        // TODO master check
        boolean isMaster = true;
        if (isMaster) {
            marketSetup(sim.markets, s.withOrderExecution);
        }

        long epoch = System.currentTimeMillis();
        for (long id = 0; id < s.iterationSteps; id++) {
            assert s.withOrderPlacement;

            // System.out.println("------------IterateLoop " + id + " @"+here);
            Step step = new Step(id, epoch);
            long begin = System.nanoTime();
            if (isMaster)
                iterSetup(fundamentals);
            if (s.withOrderPlacement) {
                updateMarketsInBatch(id, step, s.maxHighFreqOrders, s, output);
            }
            if (isMaster) {
                long t0 = System.nanoTime();
                if (s.forDummyTimeseries) {
                    sim.updateMarketsUsingFundamentalPrice(sim.markets, fundamentals);
                } else {
                    sim.updateMarketsUsingMarketPrice(sim.markets, fundamentals);
                }
                long t1 = System.nanoTime();
                if (s.withPrint) {
                    output.print(out, s, sim.markets, sim.agents, sim.sessionEvents);
                    output.postProcess(out, SimulationStage.WITH_PRINT_DURING_SESSION);
                    out.clear();
                }
                long t2 = System.nanoTime();
                for (Market market : sim.markets) {
                    market.triggerAfterSimulationStepEvents();
                }
                long t3 = System.nanoTime();
                for (Market market : sim.markets) {
                    market.updateTime();
                    market.updateOrderBooks();
                }
                long t4 = System.nanoTime();
                long end = System.nanoTime();
                //                System.out.println("CYCLE upMarket: " + ((t1 - t0) * 1e-9));
                //                System.out.println("CYCLE print: " + ((t2 - t1) * 1e-9));
                //                System.out.println("CYCLE triEvent: " + ((t3 - t2) * 1e-9));
                //                System.out.println("CYCLE upTime: " + ((t4 - t3) * 1e-9));
                //                System.out.println("CYCLE all" + ((end - begin) * 1e-9));

            }
        }
        if (isMaster && s.withPrint) {
            output.endprint(out, s, sim.markets, sim.agents, sim.sessionEvents, s.iterationSteps);
            output.postProcess(out, SimulationStage.WITH_PRINT_END_SESSION);
            out.clear();
        }
    }
    // TODO TK master only
    void iterSetup(Fundamentals fundamentals) {
        sim.updateFundamentals(fundamentals);
        for (Market market : sim.markets) {
            market.triggerBeforeSimulationStepEvents(); // Assuming the markets in dependency order.
        }
    }

    void marketSetup(List<Market> markets, boolean withOrderExecution) {
        markets.forEach((Market market) -> {
            market.setRunning(withOrderExecution);
        });
        markets.forEach((Market market) -> {
            market.itayoseOrderBooks();
        });
        markets.forEach((Market market) -> {
            market.check();
        });
    }

    public void processAgentUpdate() {
        // TODO
        // maybe contracted.forEach() become faster
        bh.allAgents.forEach(/* pool, NTHREADS, */ (long index, Agent agent) -> {
            Collection<AgentUpdate> cs = bh.contractedOrders.get(index);
            if (cs == null)
                return;
            cs.forEach((AgentUpdate c) -> {
                agent.executeUpdate(c);
            });
        });

        bh.contractedOrders.clear();
    }

    void registerConfigAndRange(JSON.Value config, LongRange range) {
        // JSON.Value className = config.get("class");
        JSON.Value classType = config.get("schedule");
        if (classType.equals("arbitrager"))
            arbRanges.add(range);
        // TODO long/short using className
        else
            ordRanges.add(range);
    }

    // TODO
    @Override
    public void run(final long seed) {
        try {
            long TIME_INIT = System.nanoTime();
            final TeamedPlaceGroup pg = TeamedPlaceGroup.getWorld();
            System.out.println("PG:" + pg);
            if (pg.rank() != 0) {
                System.err.println("NOT master" + bh.placeGroup);
                return;
            }
            // TODO serializable or not?
            sim = factory.makeNewSimulation(seed);
            System.out.println("step0a:" + pg);
            // Setup Dist Collections

            final DistCol<Agent> dAgents = new DistCol<>();
            System.out.println("step0b:" + pg);
            final DistBag<List<Order>> dOrders = new DistBag<>();
            System.out.println("step0c:" + pg);
            finish(()-> {
                pg.broadcastFlat(() -> {
                    System.out.println("step0c1:" + pg);
                });
            ;});
            System.out.println("step0c2:" + pg);
            final CachableArray<Market> dMarkets = CachableArray.make(pg, sim.markets);
            System.out.println("step0c3:" + pg);
            DistMultiMap<Long, Market.AgentUpdate> dContractedOrders = new DistMultiMap<>(pg);
            System.out.println("step0d:" + pg);
            final Place caller = here();
            final JSON.Value conf = factory.CONFIG;
            final ParallelRunnerDist runner = this;
            System.out.println("step0e:" + pg);
            this.bh = PlaceLocalObject.make(pg.places(), () -> {
                System.out.println("BH setup:" + here()+ ":"+conf);
                //BranchHandle result = new BranchHandle(pg, runner, runner.factory, dMarkets, dAgents, dOrders, dContractedOrders);
                BranchHandle result = new BranchHandle(pg, dMarkets, dAgents, dOrders, dContractedOrders);
                if(!here().equals(caller)) {
                    runner.factory = result.factory = new SimulatorFactory(conf);
                    result.runner = runner;
                    runner.sim = runner.factory.makeNewSimulation(seed);
                }
                dMarkets.forEach((Market m) -> { // TODO
                  //  m.env = runner.sim;
                });
                return result;
            });
            bh.runner = runner;
            bh.factory= factory;

            pg.broadcastFlat(() -> {
                System.out.println("start running:" + here());
                bh.runner.parallelRun(bh, seed);
            });
            long TIME_THE_END = System.nanoTime();
            System.out.println("# INITIALIZATION TIME " + ((TIME_THE_BEGINNING - TIME_INIT) / 1e+9));
            System.out.println("# EXECUTION TIME " + ((TIME_THE_END - TIME_THE_BEGINNING) / 1e+9));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void parallelRun(BranchHandle bh, long seed) { // TODO ??
        Simulator sim = bh.runner.sim;
        this.pool = Executors.newFixedThreadPool(this.NTHREADS);
// TODO
//		JSON.Value CONFIG = sim.CONFIG;
//		Map<String, Object> GLOBAL = sim.GLOBAL;
// TODO
//		// ////// AGENTS INSTANTIATION ////////
//		createAllAgents(CONFIG.get("simulation").get("agents"));
//		bh.allAgents.setProxyGenerator((Long index)->{
//			return new AgentUpdateProxy(index, bh.contractedOrders);
//		});
// TODO
//		// ////// MULTIVARIATE GEOMETRIC BROWNIAN ////////
//		Fundamentals fundamentals = sim.createFundamentals(bh.markets,
//				sim.CONFIG.get("simulation").getOrElse("fundamentalCorrelations", "{}"));
//		sim.updateFundamentals(fundamentals);
//		GLOBAL.put("fundamentals", fundamentals);
//		// ////// MAIN SIMULATION PROCEDURE ////////

// TODO
        OutputCollector out = this.out;
// TODO
//      from new MT
//      AllocManager.Centric<Agent> dm = new AllocManager.Centric<Agent>();
//      b    h.allAgents = new ChunkedList<>();
//      bh.allAgents.add(sim.dm.getChunk());

        long TIME_THE_BEGINNING = System.nanoTime();

        // TODO dist runner should prepare routines instead of default beginSimulation
        // output.beginSimulation(out, bh.markets, bh.allAgents);
        // TODO
        // output.postProcess(out, SimulationStage.BEGIN_SIMULATION, out.map);
        // out.clear();

        System.out.println("start session:"+here());
        for (Session session : sim.sessions) {
            System.out.println("start session:"+here());
            session.print();
            // TODO master only??
            sim.sessionEvents = factory.createEventsForASession(session, sim);
            // TODO
            // output.beginSession(out, session, sim.markets, sim.agents, sim.sessionEvents);
            //output.postProcess(out, SimulationStage.BEGIN_SESSION, out.map);
            //out.clear();
            iterateMarketUpdates(out, session, sim.fundamentals);
            // TODO
            // output.endSession(out, session, sim.markets, sim.agents, sim.sessionEvents);
            //output.postProcess(out, SimulationStage.END_SESSION, out.map);
            //out.clear();
        }
        // TODO
        // output.endSimulation(out, sim.markets, sim.agents);
        //output.postProcess(out, SimulationStage.END_SIMULATION, out.map);
        //out.clear();
//////
        pool.shutdown();

    }

    void separateAgentRanges() {
        if (bh.isMaster()) {
            for (LongRange r : arbRanges)
                myRanges.add(r);
        } else {
            int numWorkers = bh.placeGroup.size() - 1;
            List<List<LongRange>> split = LongRange.splitList(numWorkers, ordRanges);
            List<LongRange> mine = split.get(bh.placeGroup.rank() - 1);
            for (LongRange r : mine)
                if (r.size() > 0)
                    myRanges.add(r);
        }
    }

    public void setupEnv() {
        // TODO
        // setupMarkets(markets);
        // setupAgents(agents);

    }

    void submitOrders(long iterStep, Bag<List<Order>> bag,
                      Session s, SimulationOutput output) {
        // TODO
        List<Market> markets = sim.markets;
        try {
            bh.allAgents.forEach(/* TODO pool, NTHREADS,*/
                    (Agent a, Consumer<? super List<Order>> receiver) -> {
                List<Order> orders = a.submitOrders(markets);
                if (s.withPrint)
                    output.orderSubmissionOutput(out, SimulationStage.WITH_PRINT_DURING_SESSION, a, orders, markets);
                if (!orders.isEmpty()) {
                    receiver.accept(orders);
                }
            }, bag);
        } catch(Exception e) {
            e.printStackTrace(System.out);
            System.out.println("-----cause of errors--------------");
            e.getCause().printStackTrace(System.out);
        }
    }

    void updateAgents(ParallelRunnerMT.Step step) {
        // no need for remote propagation of contractedorders
        for (Market m : sim.markets) {
            List<List<AgentUpdate>> updatesHistory = m.agentUpdates;
            assert updatesHistory.get(updatesHistory.size() - 1).isEmpty();
        }
    }




    public void updateMarketsInBatch(long id, Step step, long maxHifreqOrders,
                                     Session s, SimulationOutput output) {
        try {
            // TODO comm time
            Bag<List<Order>> bag = bh.orders;
            bh.markets.<MarketInfo>broadcast(MarketInfo::pack, MarketInfo::unpack);
            bh.orders.clear();
            long t0 = System.nanoTime();
            submitOrders(id, bag, s, output);
            long t1 = System.nanoTime();
            //System.out.println("CYCLE submitOrders: " + ((t1 - t0) * 1e-9));

            bh.orders.GLOBAL.gather(bh.placeGroup.get(0));

            // handleOrders(bag.convertToList(), maxHifreqOrders); // FIXME
            long t2 = System.nanoTime();
            // System.out.println("CYCLE handleOrders: " + ((t2 - t1) * 1e-9));
            updateAgents(step);

            bh.contractedOrders.relocate(bh.allAgents.getDistributionLong());

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("[ParallelRunnerDist] updateMarketBatch MPI exception");
        }
    }
    // tmporal impl, maybe we should apply this randomize during Bag gathering
    static class Ox implements Comparable<ParallelRunnerMT.Ox> {
        long priority;

        public Ox(long priority, long agentid, List<Order> orders) {
            this.priority = priority;
            this.agentid = agentid;
            this.orders = orders;
        }

        long agentid;
        List<Order> orders;

        @Override
        public int compareTo(ParallelRunnerMT.Ox o) {
            int result = Long.compare(priority, o.priority);
            if(result==0) Long.compare(agentid, o.agentid);
            return result;
        }
        @Override
        public String toString() {
            return " " + agentid;
        }
    }

    private Collection<List<Order>> myShuffle(Random random, List<List<Order>> orders) {
        TreeMap<ParallelRunnerMT.Ox, List<Order>> sorted = new TreeMap<>();
        for(List<Order> orderSet: orders) {
            if (orderSet.isEmpty()) continue;
            long agentId = orderSet.get(0).agentId;
            long priority = random.getNthLong(agentId);
            sorted.put(new ParallelRunnerMT.Ox(priority, agentId, orderSet), orderSet);
        }
        out.log("# simRandom@myShuffle", sorted.keySet().toString());
        return sorted.values();
    }
    /**
     * COPIED FROM SEQUENTIAL RUNNER
     * @param localOrders
     * @param MAX_HIFREQ_ORDERS
     * @return
     */
    public List<List<Order>> handleOrders(List<List<Order>> localOrders, long MAX_HIFREQ_ORDERS) {
        long beginTime = System.nanoTime();
        List<List<Order>> allOrders = new ArrayList<>();
        List<Market> markets = sim.markets;
//        StringBuffer buf0 = new StringBuffer();
//        for (List<Order> someOrders : localOrders) {
//            buf0.append(" "+someOrders.get(0).agentId);
//        }
//        out.log("localOrders", buf0.toString());

        Random random = sim.getRandom();
        Random tmpRandom = new Random(System.nanoTime());
        List<Agent> agents = sim.hifreqAgents;
        RandomPermutation<Agent> randomAgents = new RandomPermutation<>(random, agents);
        //RandomPermutation<List<Order>> randomOrders = new RandomPermutation<>(random, localOrders);
        //randomOrders.shuffle();
// TODO
        Collection<List<Order>> randomOrders = myShuffle(random, localOrders);

        //out.log("simRandom@handleOrders", random.toString());

//        StringBuffer buf = new StringBuffer();
//        for (List<Order> someOrders : randomOrders) {
//            buf.append(" "+someOrders.get(0).agentId);
//        }
//        out.log("handleOrdersAgent", buf.toString());
        for (List<Order> someOrders : randomOrders) {
            // This handles one order-list submitted by an agent per loop.
            // TODO: If needed, one-market one-order handling.
            for (Order order : someOrders) {
                Market m = sim.markets.get(((int) order.marketId));
                m.triggerBeforeOrderHandlingEvents(order);
                m.handleOrder(order); // NOTE: DO it now.
                m.triggerAfterOrderHandlingEvents(order);
                m.tickUpdateMarketPrice();
            }

            if (HIFREQ_SUBMIT_RATE < tmpRandom.nextDouble()) {
                continue;
            }

            long k = 0;
            randomAgents.shuffle();
            for (Agent agent : randomAgents) {
                if (k >= MAX_HIFREQ_ORDERS) {
                    break;
                }
                List<Order> orders = agent.submitOrders(markets);
                if (!orders.isEmpty())
                    allOrders.add(orders);

                if (orders.size() > 0) {
                    for (Order order : orders) {
                        Market m = sim.markets.get((int) order.marketId);
                        m.triggerBeforeOrderHandlingEvents(order);
                        m.handleOrder(order);
                        m.triggerAfterOrderHandlingEvents(order);
                        m.tickUpdateMarketPrice();
                    }
                    k++;
                }
            }
        }

        long endTime = System.nanoTime();
        if (_PROFILE) {
            System.err.println("# handle orders took " + (endTime - beginTime));
        }
        return allOrders;
    }
    
    /**
     * Launches a simulation with the specified output, JSON configuration, and seed using the
     * distributed runner.
     * Arguments are:
     * <ol>
     * <li>Output class (defines the outputs to extract from the simulation)
     * <li>JSON configuration file
     * <li>seed
     * @param args program arguments
     */
    public static void main(String [] args) {
        if (args.length < 3) {
            System.err.println("Program arguments for ParallelRunnerMT:");
            System.err.println("\tOutput class (defines the outputs to extract from the simulation)");
            System.err.println("\tJSON configuration file");
            System.err.println("\tseed");
            System.err.println("\tparallelism level (optional)");
        }

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
        
        ParallelRunnerDist runner; 
        
        try {
            if (3 < args.length) {
                runner = new ParallelRunnerDist(simulationOutput, factory, Integer.parseInt(args[3]));
            } else {
                runner = new ParallelRunnerDist(simulationOutput, factory);
            }
        } catch (NumberFormatException e) {
            System.err.println("Failed to parse the parallelism level to use for the ParallelRunnerMT");
            e.printStackTrace();
            return;
        }
        
        runner.run(seed);
    }

}
