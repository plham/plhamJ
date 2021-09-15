package plham.core.main;

import static apgas.Constructs.async;
import static apgas.Constructs.finish;
import static apgas.Constructs.here;
import static plham.core.main.ParallelRunnerMT.DEFAULT_THREAD_COUNT;
import static plham.core.main.ParallelRunnerMT.PARALLEL_RUNNER_THREAD_PROPERTY;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

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
import handist.collections.dist.DistLog.LogItem;
import handist.collections.dist.DistLog.LogKey;
import handist.collections.dist.DistMultiMap;
import handist.collections.dist.TeamedPlaceGroup;
import plham.core.Agent;
import plham.core.Event;
import plham.core.Fundamentals;
import plham.core.Market;
import plham.core.Market.AgentUpdate;
import plham.core.Order;
import plham.core.OutputCollector;
import plham.core.SimulationOutput;
import plham.core.SimulationOutput.SimulationStage;
import plham.core.main.ParallelRunnerMT.Step;
import plham.core.main.Simulator.Session;
import plham.core.util.AgentAllocManager;
import plham.core.util.Random;

/**
 * ParallelRunnerDist is a simple runner for distributed environments. The instance is first created in the master node
 * (place) and then sent to worker nodes. This class is {@code Serializable} but not {@code PlaceLocalHandle} or
 * {@code DistributedCollection}, so when the instance is transported to other places, the copy of the instance is
 * transferred to the destination place.
 *
 *
 *
 */

public final class ParallelRunnerDist extends Runner {

    /**
     * This class is used for compatibility with sequential version of Market. As the markets assumes agents in the same
     * place, this class gather the information and pack them into DistMultiMap.
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

    /**
     * This class is used to summarizes the handles to distributed collections that manages the simulation status. In
     * the sequential or MT version, {@code Simulator} plays the role to manages agents or markets. However, the agents
     * and markets are now managed by distributed collections, so this class manages the distributed collections
     * instead. Maybe it will be used to save/restore/duplicate the simulation.
     *
     */
    static class BranchHandle extends PlaceLocalObject { // TODO TK no need for PLO?
        // TODO short/long-term agents for Fujishima's scheduling.
        DistCol<Agent> allAgents;
        DistMultiMap<Long, AgentUpdate> contractedOrders;
        SimulatorFactory factory;
        DistChunkedList<Agent> lAgents;
        DistBag<List<Order>> lOrders;

        CachableArray<Market> markets;
        TeamedPlaceGroup placeGroup;
        ParallelRunnerDist runner;
        DistChunkedList<Agent> sAgents;
        DistBag<List<Order>> sOrders;

        public BranchHandle(TeamedPlaceGroup placeGroup, CachableArray<Market> markets, DistCol<Agent> allAgents,
                DistChunkedList<Agent> sAgents, DistChunkedList<Agent> lAgents, DistBag<List<Order>> sOrders,
                DistBag<List<Order>> lOrders, DistMultiMap<Long, AgentUpdate> contractedOrders) {
            this.placeGroup = placeGroup;
            this.markets = markets;
            this.allAgents = allAgents;
            this.sAgents = sAgents;
            this.lAgents = lAgents;
            this.sOrders = sOrders;
            this.lOrders = lOrders;
            this.contractedOrders = contractedOrders;
        }

        public boolean isMaster() {
            return placeGroup.rank() == 0;
        }
    }

    public static class DefaultOutputCollector implements OutputCollector, Serializable {
        private static final long serialVersionUID = 5777744274622700033L;
        transient public ConcurrentHashMap<String, List<String>> map = new ConcurrentHashMap<>();

        @Override
        public void clear() {
            if (map == null)
                map = new ConcurrentHashMap<>();
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
            if (map == null)
                map = new ConcurrentHashMap<>();
            List<String> listOfTopic = map.computeIfAbsent(topic, k -> {
                return new ArrayList<>();
            });
            listOfTopic.add(o.toString());
        }

        @Override
        public void print(String message) {
            // System.out.println(here().toString() +":"+message);
            System.out.println(message);
        }

        @Override
        public List<String> removeLog(String key) {
            return map.remove(key);
        }

    }

    class DistAllocManager extends AgentAllocManager {
        ChunkedList<Agent> arbitrageurs = new ChunkedList<>();
        ArrayList<LongRange> arbRanges = new ArrayList<>();
        public String defaultScheduleType = "\"short\"";
        ArrayList<LongRange> longRanges = new ArrayList<>();
        // public String defaultScheduleType = "\"long\"";
        TreeSet<LongRange> myRanges = new TreeSet<>();
        ArrayList<LongRange> shortRanges = new ArrayList<>();

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
            return bh.allAgents;
        }

        @Override
        public RangedList<Agent> getRangedList(Value config, LongRange range, String name, SimulatorFactory factory) {
            // TODO JSON.value
            // String className = config.get("class").toString();
            try {
                if (bh.isMaster()) {
                    // TODO
                    if (factory.judgeHFTorNot(name)) {
                        Chunk<Agent> chunk = new Chunk<>(range);
                        arbitrageurs.add(chunk);
                        bh.allAgents.add(chunk);
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
                        bh.allAgents.add(chunk);
                        if (classType.startsWith("short")) {
                            bh.sAgents.add(chunk);
                        } else if (classType.startsWith("long")) {
                            bh.lAgents.add(chunk);
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
                // TODO
                if (arbRanges == null)
                    arbRanges = new ArrayList<>();
                arbRanges.add(range);
                // System.out.println("ARB:" + range);
                // TODO long/short using className
            } else if (classType.startsWith("short")) {
                if (shortRanges == null)
                    shortRanges = new ArrayList<>();
                shortRanges.add(range);
                // System.out.println("short:" + range);
            } else if (classType.startsWith("long")) {
                if (longRanges == null)
                    longRanges = new ArrayList<>();
                longRanges.add(range);
                // System.out.println("long:" + range);
            } else {
                throw new IllegalArgumentException("Unknown schedule option:" + classType);
            }
        }

        @Override
        public void scanDone() {
            // determine how agents are distributed on worker places.
            if (myRanges == null)
                myRanges = new TreeSet<>();
            if (bh.isMaster()) {
                for (LongRange r : arbRanges) {
                    myRanges.add(r);
                }
            } else {
                int numWorkers = bh.placeGroup.size() - 1;
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
            List<LongRange> mine = split.get(bh.placeGroup.rank() - 1);
            for (LongRange r : mine)
                if (r.size() > 0)
                    myRanges.add(r);
        }

        @Override
        public boolean use2scan() {
            return true;
        }
    }

    public static class DistOutputCollector implements OutputCollector, Serializable {
        private static final long serialVersionUID = -5608362301183888334L;

        public static List<String> getMsgs(Collection<LogItem> vals) {
            if (vals == null)
                return null;
            List<String> results = new ArrayList<>(vals.size());
            for (LogItem item : vals)
                results.add(item.msg);
            return results;
        }

        DistLog dlog;

        public DistOutputCollector(TeamedPlaceGroup pg) {
            this(pg, 0);
        }

        public DistOutputCollector(TeamedPlaceGroup pg, long phase) {
            dlog = new DistLog(pg, phase);
        }

        @Override
        public void clear() {
            /* dlog.setPhase(dlog.getPhase()+1); */
        }

        @Override
        public void forEach(BiConsumer<String, List<String>> func) {
            dlog.getDistMultiMap().forEach((LogKey key, Collection<LogItem> vals) -> {
                // if(key.place == here() && key.phase == dlog.getPhase()) {
                List<String> msgs = new ArrayList<>(vals.size());
                for (LogItem v : vals)
                    msgs.add(v.msg);
                func.accept(key.tag, msgs);
                // }
            });
        }

        public DistLog getDistLog() {
            return dlog;
        }

        @Override
        public List<String> getLog(String key) {
            return getMsgs(dlog.getLog(key));
        }

        @Override
        public void log(long phase, String topic, Object o) {
            dlog.put(phase, topic, o.toString(), null);
        }

        @Override
        public void log(String topic, Object o) {
            dlog.put(topic, o.toString(), null);
        }

        @Override
        public void print(String message) {
            System.out.println(message + "::" + here());
            // dlog.put("_MSG_", message, null);
        }

        public void printAll(PrintStream out) {
            dlog.printAll(out);
        }

        @Override
        public List<String> removeLog(String key) {
            return getMsgs(dlog.removeLog(key));
        }
    }

    // tmporal impl, maybe we should apply this randomize during Bag gathering
    static class Ox implements Comparable<ParallelRunnerMT.Ox> {
        long agentid;

        List<Order> orders;

        long priority;

        public Ox(long priority, long agentid, List<Order> orders) {
            this.priority = priority;
            this.agentid = agentid;
            this.orders = orders;
        }

        @Override
        public int compareTo(ParallelRunnerMT.Ox o) {
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
        // String NTHREADS_ENV = System.getenv("NTHREADS");
        // if (NTHREADS_ENV != null) {
        // try {
        // return Integer.parseInt(NTHREADS_ENV);
        // } catch (RuntimeException e) {
        // System.err.println("[Env: NTHREADS] " + NTHREADS_ENV + " is not integer (parse error).");
        // }
        // } else {
        return Integer.parseInt(System.getProperty(PARALLEL_RUNNER_THREAD_PROPERTY, DEFAULT_THREAD_COUNT));
    }

    // int NPLACES;

    /**
     * Launches a simulation with the specified output, JSON configuration, and seed using the distributed runner.
     * Arguments are:
     * <ol>
     * <li>Output class (defines the outputs to extract from the simulation)
     * <li>JSON configuration file
     * <li>seed
     *
     * @param args program arguments
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Program arguments for ParallelRunnerDist:");
            System.err.println("\tOutput class (defines the outputs to extract from the simulation)");
            System.err.println("\tJSON configuration file");
            System.err.println("\tseed");
            System.err.println("\tuse pipeline?");
            System.err.println("\tparallelism level (optional)");
        }

        String outputClassName = args[0];
        String JsonConfigurationFile = args[1];
        String seedArg = args[2];
        String pipelineArg = args[3];

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
        
        boolean withPipeline;
        try {
            withPipeline = Boolean.parseBoolean(pipelineArg);
        } catch (Exception e) {
            System.err.println("Problem encountered when attempting to obtain pipeline configuration");
            e.printStackTrace();
            return;
        }

        ParallelRunnerDist runner;

        try {
            if (4 < args.length) {
                runner = new ParallelRunnerDist(simulationOutput, factory, Integer.parseInt(args[4]));
            } else {
                runner = new ParallelRunnerDist(simulationOutput, factory);
            }
        } catch (NumberFormatException e) {
            System.err.println("Failed to parse the parallelism level to use for the ParallelRunnerDist");
            e.printStackTrace();
            return;
        }

        runner.run(seed, withPipeline);
    }

    transient DistAllocManager _am;

    /**
     * The distributed simulation data, which consist of constant data, a list of distributed collections.
     *
     */
    BranchHandle bh;

    Bag<List<Order>> keptOrders = new Bag<>();

    int NTHREADS;
    private OutputCollector out = new DefaultOutputCollector();
    boolean pipeline;
    // TODO duplicated with MT (if RunnerDist extends RunnerMT)
    // transient private ExecutorService pool;
    long TIME_THE_BEGINNING;

    public ParallelRunnerDist(SimulationOutput sim, SimulatorFactory factory) {
        this(sim, factory, initializeNThreads());
    }

    // private void debug(Object o) {
    // System.err.println(o);
    // }

    public ParallelRunnerDist(SimulationOutput simulation, SimulatorFactory factory, int nthreads) {
        super(simulation, factory);
        NTHREADS = nthreads;
    }

    private void addOrders(Bag<List<Order>> orders) {
        keptOrders.addBag(orders);
        orders.clear();
    }

    private void agentOutput(SimulationOutput output, OutputCollector collector, SimulationStage stage,
            ChunkedList<Agent> agents) {
        for (Agent a : agents)
            output.agentOutput(collector, stage, a);
    }

    /*
     * This method is private and unused. Should we remove it?
     */
    @SuppressWarnings("unused")
    private void checkMarketTradeVolume0(String tag, List<Market> markets, long t) {
        for (Market m : markets) {
            try {
                if (t - 3 < m.getTime() && m.getTime() < t + 3) {
                    System.out.println(
                            tag + ":" + bh.isMaster() + ":" + m.id + ":" + m.getTime() + ":" + m.getTradeVolume(t));
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(tag + ":" + bh.isMaster() + ":" + m.id + ":" + m.getTime() + ":OUT");
            }
        }
    }

    /**
     * DistRunner calculates the distribution of agents and then requests factory for agent/markets creation.
     */
    void createAllAgents() {
        Value list = factory.CONFIG.get("simulation").get("agents");
        factory.createAllAgents(list, sim.dm);
    }

    private void eventOutput(SimulationOutput output, OutputCollector collector, SimulationStage stage,
            List<Event> events) {
        if (events == null)
            return;
        for (Event e : events)
            output.eventOutput(collector, stage, e);
    }

    public void executeRemoteAgentUpdate() {
        // {
        // StringBuffer buf = new StringBuffer();
        // bh.contractedOrders.forEach((Long index, Collection<AgentUpdate> vals) -> {
        // buf.append(" "+index);
        // });
        // out.print(" received "+buf.toString());
        // StringBuffer buf2 = new StringBuffer();
        // bh.allNormalAgents.forEachChunk((RangedList<Agent> c)->{
        // buf2.append(" "+c.getRange());
        // });
        // out.print(" agents "+ buf2.toString());
        // StringBuffer buf3 = new StringBuffer();
        // LongRangeDistribution dist = bh.allNormalAgents.getRangedDistributionLong();
        // dist.getHashMap().forEach((LongRange range, Place p)->{
        // buf3.append(" "+range+"->"+p );
        // });
        // out.print(" dist "+ buf3.toString());
        // }
        // maybe contracted.forEach() become faster
        bh.allAgents.parallelForEach(/* pool, */ NTHREADS, (long index, Agent agent) -> {
            Collection<AgentUpdate> cs = bh.contractedOrders.get(index);
            if (cs == null)
                return;
            cs.forEach((AgentUpdate c) -> {
                agent.executeUpdate(c);
            });
        });

        bh.contractedOrders.clear();
    }

    private DistAllocManager getAllocManager() {
        if (_am == null)
            _am = new DistAllocManager();
        return _am;
    }

    /**
     * COPIED FROM SEQUENTIAL RUNNER
     *
     * @param MAX_HIFREQ_ORDERS
     * @return
     */
    public List<List<Order>> handleOrders(/* DistBag<List<Order>> localOrders, */ long MAX_HIFREQ_ORDERS, Session s) {
        long beginTime = System.nanoTime();
        List<List<Order>> allOrders = new ArrayList<>();
        List<Market> markets = bh.markets;
        // StringBuffer buf0 = new StringBuffer();
        // for (List<Order> someOrders : localOrders) {
        // buf0.append(" "+someOrders.get(0).agentId);
        // }
        // out.log("localOrders", buf0.toString());

        Random random = sim.getRandom();
        Random tmpRandom = new Random(System.nanoTime());
        if (sim.hifreqAgents == null) {
            sim.hifreqAgents = new ChunkedList<>();
        }
        RandomPermutation<Agent> randomArbs = new RandomPermutation<>(random.split(), sim.hifreqAgents);
        // TODO
        Collection<List<Order>> randomOrders = myShuffle(random.split());

        for (List<Order> someOrders : randomOrders) {
            // This handles one order-list submitted by an agent per loop.
            // TODO: If needed, one-market one-order handling.
            for (Order order : someOrders) {
                Market m = bh.markets.get(((int) order.marketId));
                m.triggerBeforeOrderHandlingEvents(order);
                m.handleOrder(order); // NOTE: DO it now.
                m.triggerAfterOrderHandlingEvents(order);
                m.tickUpdateMarketPrice();
            }

            if (HIFREQ_SUBMIT_RATE < tmpRandom.nextDouble()) {
                continue;
            }

            long k = 0;
            randomArbs.shuffle();
            for (Agent agent : randomArbs) {
                if (k >= MAX_HIFREQ_ORDERS) {
                    break;
                }
                List<Order> orders = agent.submitOrders(markets);
                if (s.withPrint) {
                    output.orderSubmissionOutput(out, SimulationStage.WITH_PRINT_DURING_SESSION, agent, orders,
                            markets);
                }

                if (!orders.isEmpty())
                    allOrders.add(orders);

                if (orders.size() > 0) {
                    for (Order order : orders) {
                        Market m = bh.markets.get((int) order.marketId);
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
        return allOrders;
    }

    public void iterateMarketUpdates(OutputCollector output, Session s, Fundamentals fundamentals) {
        bh.placeGroup.barrier();
        if (pipeline) {
            iterateMarketUpdatesParaPipeline(output, s, fundamentals);
        } else {
            iterateMarketUpdatesPara0(output, s, fundamentals);
        }
    }

    public void iterateMarketUpdatesPara0(OutputCollector out, Session s, Fundamentals fundamentals) {
        if (!s.withOrderPlacement)
            throw new RuntimeException("should not occur");
        boolean isMaster = bh.isMaster();
        if (isMaster) {
            marketSetup(bh.markets, s.withOrderExecution);
        }
        for (long id = 0; id < s.iterationSteps; id++) {
            long epoch = System.currentTimeMillis();
            // checkMarketTradeVolume("B1", bh.markets);
            if (isMaster)
                iterSetup(fundamentals);
            bh.markets.<Market.MarketUpdate>broadcast(Market.MarketUpdate::pack, Market.MarketUpdate::unpack);
            // checkMarketTradeVolume("A1", bh.markets);
            final long idc = id;
            assert s.withOrderPlacement;

            Step step = new Step(id, epoch);
            // long begin = System.nanoTime();
            bh.sOrders.clear();
            // long t0 = System.nanoTime();
            submitOrders(idc, NTHREADS, bh.sAgents, bh.sOrders, s, output);
            // long t1 = System.nanoTime();

            // System.out.println("CYCLE submitOrders: " + ((t1 - t0) * 1e-9));
            try {
                bh.sOrders.TEAM.gather(bh.placeGroup.get(0));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("[ParallelRunnerDist] updateMarketBatch MPI exception");
            }
            if (bh.isMaster()) {
                addOrders(bh.sOrders);
                handleOrders(s.maxHighFreqOrders, s); // FIXME
                // TODO
                // checkMarketTradeVolume("B2", bh.markets);
                updateMarketMisc(s, fundamentals);
                // checkMarketTradeVolume("B3", bh.markets);
            }
            // long t2 = System.nanoTime();
            // System.out.println("CYCLE handleOrders: " + ((t2 - t1) * 1e-9));
            for (Market market : bh.markets)
                market.updateTime();
            if (isMaster) {
                updateAgents(step);
            }
            // checkMarketTradeVolume("B4", bh.markets);
            try {
                bh.contractedOrders.relocate(bh.allAgents.getDistributionLong());
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("[ParallelRunnerDist] updateMarketBatch MPI exception");
            }
            // checkMarketTradeVolume("B5", bh.markets);
            if (!isMaster)
                executeRemoteAgentUpdate();
        }
        if (isMaster && s.withPrint) {
            outputPrint(isMaster, output, out, s, SimulationStage.WITH_PRINT_END_SESSION, bh.markets, bh.allAgents,
                    sim.sessionEvents);
        }
    }

    public void iterateMarketUpdatesParaPipeline(OutputCollector out, Session s, Fundamentals fundamentals) {
        // TODO master check
        if (!s.withOrderPlacement)
            throw new RuntimeException("should not occur");
        boolean isMaster = bh.isMaster();
        if (isMaster) {
            marketSetup(bh.markets, s.withOrderExecution);
        }

        long epoch = System.currentTimeMillis();
        if (isMaster)
            iterSetup(fundamentals);
        bh.markets.<Market.MarketUpdate>broadcast(Market.MarketUpdate::pack, Market.MarketUpdate::unpack);

        for (long id = 0; id < s.iterationSteps; id++) {
            final long idc = id;
            assert s.withOrderPlacement;
            // Step pstep = new Step(id - 1, epoch);
            Step step = new Step(id, epoch);
            // long begin = System.nanoTime();
            // TODO comm time
            bh.sOrders.clear();
            // long t0 = System.nanoTime();
            finish(() -> {
                async(() -> {
                    submitOrders(idc, NTHREADS, bh.sAgents, bh.sOrders, s, output);
                });
                // long t1 = System.nanoTime();
                if (idc > 0) {
                    try {
                        bh.contractedOrders.relocate(bh.allAgents.getDistributionLong());
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException("[ParallelRunnerDist] updateMarketBatch MPI exception");
                    }
                    bh.lOrders.TEAM.gather(bh.placeGroup.get(0));
                    if (isMaster)
                        addOrders(bh.lOrders);
                }
            });
            if (!isMaster)
                executeRemoteAgentUpdate();
            finish(() -> {
                if (!isMaster) {
                    async(() -> {
                        submitOrders(idc, NTHREADS, bh.lAgents, bh.lOrders, s, output);
                    });
                }
                try {
                    bh.sOrders.TEAM.gather(bh.placeGroup.get(0));
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("[ParallelRunnerDist] updateMarketBatch MPI exception");
                }
                if (bh.isMaster()) {
                    addOrders(bh.sOrders);
                    handleOrders(s.maxHighFreqOrders, s);
                    if (idc + 1 < s.iterationSteps)
                        updateMarketMisc(s, fundamentals);
                }
                // long t2 = System.nanoTime();
                // System.out.println("CYCLE handleOrders: " + ((t2 - t1) * 1e-9));
            });
            if (isMaster && idc + 1 < s.iterationSteps) {
                for (Market market : bh.markets)
                    market.updateTime();
                if (isMaster) {
                    updateAgents(step); // TODO...
                    iterSetup(fundamentals);
                }
            }
            bh.markets.<Market.MarketUpdate>broadcast(Market.MarketUpdate::pack, Market.MarketUpdate::unpack);
        }

        { //
            bh.lOrders.TEAM.gather(bh.placeGroup.get(0));
            if (isMaster) {
                addOrders(bh.lOrders);
                handleOrders(s.maxHighFreqOrders, s);
                updateMarketMisc(s, fundamentals);
                updateAgents(new Step(s.iterationSteps - 1, epoch));
            }
            try {
                bh.contractedOrders.relocate(bh.allAgents.getDistributionLong());
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("[ParallelRunnerDist] updateMarketBatch MPI exception");
            }
            if (!isMaster)
                executeRemoteAgentUpdate();
        }
        if (isMaster && s.withPrint) {
            outputPrint(isMaster, output, out, s, SimulationStage.WITH_PRINT_END_SESSION, bh.markets, bh.allAgents,
                    sim.sessionEvents);
        }
    }

    // TODO TK master only
    void iterSetup(Fundamentals fundamentals) {
        sim.updateFundamentals(fundamentals);
        for (Market market : bh.markets) {
            market.triggerBeforeSimulationStepEvents(); // Assuming the markets in dependency order.
        }
    }

    private void marketOutput(SimulationOutput output, OutputCollector collector, SimulationStage stage,
            List<Market> markets) {
        for (Market m : markets)
            output.marketOutput(collector, stage, m);
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

    private Collection<List<Order>> myShuffle(Random random) {
        // int bsize = keptOrders.size();
        TreeMap<ParallelRunnerMT.Ox, List<Order>> sorted = new TreeMap<>();
        for (List<Order> orderSet : keptOrders) {
            if (orderSet.isEmpty())
                continue;
            long agentId = orderSet.get(0).agentId;
            long priority = random.getNthLong(agentId);
            sorted.put(new ParallelRunnerMT.Ox(priority, agentId, orderSet), orderSet);
        }
        // out.log("# simRandom@myShuffle", "" + keptOrders.size() +":"+ random + ":"+ sorted.keySet().toString());
        keptOrders.clear();
        return sorted.values();
    }

    private void outputPrint(boolean isMaster, SimulationOutput output, OutputCollector collector, Session s,
            SimulationStage stage, CachableArray<Market> markets, DistCol<Agent> agents, List<Event> sessionEvents) {
        if (isMaster)
            output.sessionOutput(collector, stage, s);
        if (isMaster)
            marketOutput(output, collector, stage, markets);
        agentOutput(output, collector, stage, agents);
        eventOutput(output, collector, stage, sessionEvents);
        output.postProcess(out, stage);
        out.clear();
    }

    private void outputSession(boolean isMaster, SimulationOutput output, OutputCollector collector, Session session,
            SimulationStage stage, List<Market> markets, DistCol<Agent> agents, List<Event> sessionEvents) {
        if (isMaster)
            output.sessionOutput(collector, stage, session);
        if (isMaster)
            marketOutput(output, collector, stage, markets);
        agentOutput(output, collector, stage, agents);
        eventOutput(output, collector, stage, sessionEvents);
        output.postProcess(out, stage);
        out.clear();
    }

    private void outputSimulation(boolean isMaster, SimulationOutput output, OutputCollector collector,
            SimulationStage stage, CachableArray<Market> markets, DistCol<Agent> agents) {
        if (isMaster)
            marketOutput(output, collector, stage, markets);
        agentOutput(output, collector, stage, agents);
        out.clear();
    }

    private void parallelRun() { // TODO ??
        try {
            Simulator sim = bh.runner.sim;
            // this.pool = Executors.newFixedThreadPool(this.NTHREADS);

            // TODO
            bh.allAgents.setProxyGenerator((Long index) -> {
                return new AgentUpdateProxy(index, bh.contractedOrders);
            });
            OutputCollector out = this.out;
            boolean isMaster = bh.isMaster();
            // long TIME_THE_BEGINNING = System.nanoTime();

            outputSimulation(isMaster, output, out, SimulationStage.BEGIN_SIMULATION, bh.markets, bh.allAgents);

            for (Session session : sim.sessions) {
//                session.print();
                // TODO master only??
                if (isMaster) {
                    sim.sessionEvents = factory.createEventsForASession(session, sim);                    
                }
                outputSession(isMaster, output, out, session, SimulationStage.BEGIN_SESSION, bh.markets, bh.allAgents,
                        sim.sessionEvents);
                iterateMarketUpdates(out, session, sim.fundamentals);
                outputSession(isMaster, output, out, session, SimulationStage.END_SESSION, bh.markets, bh.allAgents,
                        sim.sessionEvents);
            }

            outputSimulation(isMaster, output, out, SimulationStage.END_SIMULATION, bh.markets, bh.allAgents);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        // pool.shutdown();

    }

    // TODO
    @Override
    public void run(final long seed) {
        run(seed, false);
    }

    public void run(final long seed, boolean pipeline) {
        this.pipeline = pipeline;
        try {
            long TIME_INIT = System.nanoTime();
            final TeamedPlaceGroup pg = TeamedPlaceGroup.getWorld();
            out.print("# " + pg);
            if (pg.rank() != 0) {
                System.err.println("NOT master" + bh.placeGroup);
                return;
            }
            // TODO serializable or not?
            sim = factory.makeNewSimulation(seed, true, false, getAllocManager());
            // Setup Dist Collections

            final DistCol<Agent> dAgents = new DistCol<>();
            final DistChunkedList<Agent> sAgents = new DistCol<>();
            final DistChunkedList<Agent> lAgents = new DistCol<>();
            // final DistChunkedList<Agent> arbitrageurs = new DistCol<>(); // FIXME UNUSED!! Either arbitrageurs have a
            // specific "schedule" or this should disappear
            final DistBag<List<Order>> sOrders = new DistBag<>();
            final DistBag<List<Order>> lOrders = new DistBag<>();
            final CachableArray<Market> dMarkets = CachableArray.make(pg, sim.markets);
            sim.markets = dMarkets;
            sim.agents = dAgents;
            final Map<String, List<LongRange>> marketName2Ranges = sim.marketName2Ranges;
            DistMultiMap<Long, Market.AgentUpdate> dContractedOrders = new DistMultiMap<>(pg);
            final Place caller = here();
            final Value conf = factory.CONFIG;
            final ParallelRunnerDist that = this;
            final BranchHandle bh = PlaceLocalObject.make(pg.places(), () -> {
                // out.print("BH setup:" + here()+ ":"+conf);
                // BranchHandle result = new BranchHandle(pg, runner, runner.factory, dMarkets, dAgents, dOrders,
                // dContractedOrders);
                BranchHandle result = new BranchHandle(pg, dMarkets, dAgents, sAgents, lAgents, sOrders, lOrders,
                        dContractedOrders);
                if (!here().equals(caller)) {
                    that.factory = result.factory = new SimulatorFactory(conf);
                    result.runner = that;
                    that.sim = that.factory.makeNewSimulation(seed, true, false, that.getAllocManager());
                    that.sim.marketName2Ranges = marketName2Ranges; // TODO (hack)
                    that.sim.agents = dAgents;
                    dMarkets.forEach((Market m) -> { // TODO
                        m.env = that.sim;
                    });
                }
                return result;
            });
            this.bh = bh;
            bh.runner = this;
            bh.factory = factory;

            pg.broadcastFlat(() -> {
//                bh.runner.out.print("# start running");
                bh.runner.bh = bh;
                bh.runner.createAllAgents();
                bh.runner.sim.markets = bh.markets;
                if (!bh.runner.pipeline && bh.runner.getAllocManager().hasLong()) {
                    return;
                }
                bh.allAgents.updateDist();
                bh.runner.TIME_THE_BEGINNING = System.nanoTime();
                bh.runner.parallelRun();
            });
            if (!bh.runner.pipeline && bh.runner.getAllocManager().hasLong()) {
                throw new IllegalArgumentException("Please set pipeline=true if there are long-term agents");
            }
            long TIME_THE_END = System.nanoTime();
            out.print("# INITIALIZATION TIME " + ((TIME_THE_BEGINNING - TIME_INIT) / 1e+9));
            out.print("# EXECUTION TIME " + ((TIME_THE_END - TIME_THE_BEGINNING) / 1e+9));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLogger(OutputCollector out) {
        this.out = out;
    }

    public void setupEnv() {
        // TODO
        // setupMarkets(markets);
        // setupAgents(agents);

    }

    void submitOrders(long iterStep, int parallelism, ChunkedList<Agent> agents, Bag<List<Order>> bag, Session s,
            SimulationOutput output) {
        // out.print("submitOrdersX:" + bh.allAgents.size());
        // TODO
        List<Market> markets = bh.markets;
        try {
            agents.parallelForEach(/* pool, */ NTHREADS, (Agent a, Consumer<? super List<Order>> receiver) -> {
                List<Order> orders = a.submitOrders(markets);
                if (s.withPrint)
                    output.orderSubmissionOutput(out, SimulationStage.WITH_PRINT_DURING_SESSION, a, orders, markets);
                if (!orders.isEmpty()) {
                    receiver.accept(orders);
                }
            }, bag);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            if (e.getCause() != null) {
                System.out.println("-----cause of errors--------------");
                e.getCause().printStackTrace(System.out);
            }
            throw e;
        }

    }

    void updateAgents(Step step) {
        // no need for remote propagation of contractedorders
        for (Market m : bh.markets) {
            assert m.hasNoAgentUpdamtes();
        }
    }

    void updateMarketMisc(Session s, Fundamentals fundamentals) {
        // long t0 = System.nanoTime();
        if (s.forDummyTimeseries) {
            sim.updateMarketsUsingFundamentalPrice(bh.markets, fundamentals);
        } else {
            sim.updateMarketsUsingMarketPrice(bh.markets, fundamentals);
        }
        // long t1 = System.nanoTime();
        if (s.withPrint) {
            outputPrint(true, output, out, s, SimulationStage.WITH_PRINT_DURING_SESSION, bh.markets, bh.allAgents,
                    sim.sessionEvents);
        }
        // long t2 = System.nanoTime();
        for (Market market : bh.markets) {
            market.triggerAfterSimulationStepEvents();
        }
        // long t3 = System.nanoTime();
        for (Market market : bh.markets) {
            market.updateOrderBooks();
        }
        // long t4 = System.nanoTime();
        // long end = System.nanoTime();
        // System.out.println("CYCLE upMarket: " + ((t1 - t0) * 1e-9));
        // System.out.println("CYCLE print: " + ((t2 - t1) * 1e-9));
        // System.out.println("CYCLE triEvent: " + ((t3 - t2) * 1e-9));
        // System.out.println("CYCLE upTime: " + ((t4 - t3) * 1e-9));
        // System.out.println("CYCLE all" + ((end - begin) * 1e-9));
    }

}
