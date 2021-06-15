package plham.core.main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.*;

import apgas.util.GlobalID;
import cassia.util.JSON;
import cassia.util.random.*;

import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import handist.collections.*;
import handist.collections.dist.util.ObjectInput;
import handist.collections.dist.util.ObjectOutput;
import plham.core.*;
import plham.core.Market.AgentUpdate;
import plham.core.SimulationOutput.SimulationStage;
import plham.core.main.Simulator.Session;
import plham.core.util.AgentAllocManager;
import plham.core.util.Random;

import static apgas.Constructs.*;

@SuppressWarnings("unused")
public final class ParallelRunnerMT extends Runner {

    /**
     * Temporary implementation for the multithreaded output collector. Support for parallel collection of program output is coming.
     * @author Patrick Finnerty
     *
     */
    public static class ParallelOutputCollector implements OutputCollector {
        protected ConcurrentHashMap<String, List<String>> map = new ConcurrentHashMap<>();
        @Override
        public void print(String message) {
            System.out.println(message);
        }
        @Override
        public void log(String topic, Object o) {
            List<String> listOfTopic = map.computeIfAbsent(topic, k -> {return Collections.synchronizedList(new ArrayList<>()); });
            listOfTopic.add(o.toString());
        }
        public void clear(){
            map.clear();
        }

        @Override
        public List<String> getLog(String key) {
            return map.get(key);
        }

        @Override
        public List<String> removeLog(String key) {
            return map.remove(key);
        }

        @Override
        public void forEach(BiConsumer<String, List<String>> func) {
            map.forEach(func);
        }

    }

    public static class ParallelOutputLogger extends ParallelOutputCollector {
        @Override
        public void clear() {
            /* do nothing */
        }
    }
    public static class ParallelOutputChecker extends ParallelOutputCollector {
        ConcurrentHashMap<String,  List<String>> arch = new ConcurrentHashMap<>();
        public ParallelOutputChecker(ParallelOutputLogger base) {
            this(base.map);
        }
        public ParallelOutputChecker(ConcurrentHashMap<String, List<String>> arch) {
            try {
                this.arch = arch;
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
        };
        public void diffFound(String key, Object o1, List<String> o2) {
            System.err.println("OutputChecker found different entry for key: " + key + ". new entry:" + o1 + ", prev entries:" + o2);
        }
        @Override
        public void log(String topic, Object o0) {
            String o = o0.toString();
            try {
                super.log(topic, o);
                List<String> listOfTopic = arch.get(topic);
                if (listOfTopic == null) {
                    diffFound(topic, o, null);
                    return;
                }
                boolean flag = listOfTopic.remove(o);
                if (!flag) diffFound(topic, o, listOfTopic);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
        @Override
        public void clear() {
        }

        public boolean checkRemains() {
            boolean flag = true;
            for (String key : arch.keySet()) {
                List<String> objs = arch.get(key);
                if (!objs.isEmpty()) { flag= false; diffFound(key, null, objs);}
            }
            return flag;
        }
    }
    public class LongShortCentric extends AgentAllocManager {
        public String defaultScheduleType = "\"short\"";
        //public String defaultScheduleType = "\"long\"";
        private Chunk<Agent> list;
        public ChunkedList<Agent> all=new ChunkedList<>();
        public ChunkedList<Agent> normal=new ChunkedList<>();

        /*
         * public def getBody() { return body; }
         */
        public Iterable<Agent> getContainer() { return list; }
        public List<Agent> getList() { return list.toList(); }
        public Chunk<Agent> getChunk() { return list; }


        @Override
        public RangedList<Agent> getRangedList(JSON.Value config, LongRange range, String name, SimulatorFactory simulatorFactory) {
            // arbitragers will be picked up in final phase.
            String classType = config.getOrElse("schedule", defaultScheduleType).toString();
            RangedList<Agent> result = list.subList(range);
            all.add(result);
            if(simulatorFactory.judgeHFTorNot(name)) {
                arbitragers.add(result);
            } else if(classType.startsWith("short")) {
                shortTs.add(result);
                normal.add(result);
            } else if(classType.startsWith("long")) {
                longTs.add(result);
                normal.add(result);
            } else throw new IllegalArgumentException("Unknown agent type: "+ classType);
            return result;
        }
        @Override
        public void registerRange(JSON.Value config, LongRange range, String name, SimulatorFactory simulatorFactory) { }
        @Override
        public void scanDone() { }
        @Override
        public void setTotalCount(long size) {
            this.list = new Chunk<>(new LongRange(0, size));
        }
        @Override
        public boolean use2scan() { return false; }
        @Override
        public void finalSetup(Simulator sim) {
            sim.agents = all;
            sim.hifreqAgents = arbitragers;
            sim.normalAgents = normal;
        }

    }


    static class Step {
        long epoch;
        long id;
        StringBuilder sb = new StringBuilder();

        public Step(long id, long epoch) {
            this.id = id;
            this.epoch = epoch;
        }

        void log(String message) {
            long stamp = System.currentTimeMillis() - epoch;
            synchronized (this) {
                sb.append(this + " " + message + " " + stamp + "\n");
            }
        }

        void message() {
            System.err.print(sb);
        }

        @Override
        public String toString() {
            return "#" + /* here() + " " + */ id;
        }
    }

    private static final long serialVersionUID = -8642146572725786897L;

    public static final String PARALLEL_RUNNER_THREAD_PROPERTY = "parallelrunnerthreads";
    public static final String DEFAULT_THREAD_COUNT = "1";

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
    private OutputCollector out;
    ChunkedList<Agent> shortTs = new ChunkedList<>();
    ChunkedList<Agent> longTs = new ChunkedList<>();
    ChunkedList<Agent> arbitragers = new ChunkedList<>();
    boolean pipeline = false;
    List<Market> marketsForArbs = null;

    static <T> T serializeClone(T obj) {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutput output = new ObjectOutput(buf);
        output.writeObject(obj);
        output.close();
        ObjectInput input = new ObjectInput(new ByteArrayInputStream(buf.toByteArray()));
        return (T)input.readObject();
    }

    int NTHREADS;
    //private ExecutorService pool;

    public ParallelRunnerMT(SimulationOutput sim, SimulatorFactory factory) {
        this(sim, factory, initializeNThreads());
    }

    public ParallelRunnerMT(SimulationOutput sim, SimulatorFactory factory, int nthreads) {
        super(sim, factory);
        NTHREADS = nthreads;
        // pool = Executors.newFixedThreadPool(nthreads);
        out = new ParallelOutputCollector();
        System.err.println(ParallelRunnerMT.class.getName() + " running with " + NTHREADS + " threads");
    }
    public void setLogger(OutputCollector out) {
        this.out = out;
    }

    private void debug(Object o) {
        System.err.println(o);
    }

    public void iterateMarketUpdates(OutputCollector out, Session s, Fundamentals fundamentals) {
        // TODO
        if(!s.withOrderPlacement) System.out.println("------------should not occur!-");
        marketSetup(pipeline? marketsForArbs:sim.markets, s.withOrderExecution);
        long epoch = System.currentTimeMillis();
        Bag<List<Order>> pbag = null;
        for (long id = 0; id < s.iterationSteps; id++) {
            assert s.withOrderPlacement;

            // System.out.println("------------IterateLoop " + id + " @"+here);
            Step step = new Step(id, epoch);
            long begin = System.nanoTime();
            iterSetup(fundamentals);
            marketSync();
            if(pipeline) {
                final long id0 = id;
                Bag<List<Order>> bag = (pbag == null) ? new Bag<>() : pbag;
                // updateMarketsInBatch(id, step, s.maxHighFreqOrders, s, output);
                final Bag<List<Order>> lbag = new Bag<>();
                long t0 = System.nanoTime();
                submitOrders(id, NTHREADS, shortTs, bag, s, output);
                long t1 = System.nanoTime();
                final int lsplit = Math.max((NTHREADS - 1) * 3, 1);
                finish(() -> {
                    async(()->{ submitOrders(id0, lsplit, longTs, lbag, s, output); });
                    handleOrders(bag.convertToList(), marketsForArbs, s.maxHighFreqOrders);
                    if (id0 + 1 < s.iterationSteps) {
                        updateMarketMisc(s, fundamentals);
                    }
                });
                if (id + 1 < s.iterationSteps) {
                    for (Market market : marketsForArbs) {
                        market.updateTime();
                    }
                    marketSync();
                    updateAgents(step);
                }
                pbag = lbag;
                long t2 = System.nanoTime();
            } else {
                // updateMarketsInBatch(id, step, s.maxHighFreqOrders, s, output);
                Bag<List<Order>> bag = new Bag<>();
                long t0 = System.nanoTime();
                submitOrders(id, NTHREADS, shortTs, bag, s, output);
                long t1 = System.nanoTime();
                handleOrders(bag.convertToList(), sim.markets, s.maxHighFreqOrders);
                long t2 = System.nanoTime();
                updateAgents(step);
                updateMarketMisc(s, fundamentals);
                for (Market market : sim.markets) {
                    market.updateTime();
                }
            }
            //                System.out.println("CYCLE upMarket: " + ((t1 - t0) * 1e-9));
            //                System.out.println("CYCLE print: " + ((t2 - t1) * 1e-9));
            //                System.out.println("CYCLE triEvent: " + ((t3 - t2) * 1e-9));
            //                System.out.println("CYCLE upTime: " + ((t4 - t3) * 1e-9));
            //                System.out.println("CYCLE all" + ((end - begin) * 1e-9));
        }
        if(pipeline) {
            handleOrders(pbag.convertToList(), marketsForArbs, s.maxHighFreqOrders);
            updateMarketMisc(s, fundamentals);
            for (Market market : sim.markets) {
                market.updateTime();
            }
            marketSync();
            updateAgents(new Step(s.iterationSteps - 1, epoch));
        }
        if (s.withPrint) {
            output.endprint(out, s, sim.markets, sim.agents, sim.sessionEvents, s.iterationSteps);
            output.postProcess(out, SimulationStage.WITH_PRINT_END_SESSION);
            out.clear();
        }
    }
    public void updateMarketMisc(Session s, Fundamentals fundamentals) {
        List<Market> activeM = pipeline? marketsForArbs: sim.markets;
        long t0 = System.nanoTime();
        if (s.forDummyTimeseries) {
            sim.updateMarketsUsingFundamentalPrice(activeM, fundamentals);
        } else {
            sim.updateMarketsUsingMarketPrice(activeM, fundamentals);
        }
        long t1 = System.nanoTime();
        if (s.withPrint) {
            output.print(out, s, activeM, sim.agents, sim.sessionEvents);
            output.postProcess(out, SimulationStage.WITH_PRINT_DURING_SESSION);
            out.clear();
        }
        long t2 = System.nanoTime();
        for (Market market : activeM) {
            market.triggerAfterSimulationStepEvents();
        }
        long t3 = System.nanoTime();
        for (Market market : activeM) {
            market.updateOrderBooks();
        }
        long t4 = System.nanoTime();
        long end = System.nanoTime();
    }
    private void marketSync() {
        if (pipeline) {
            for (int i = 0; i < marketsForArbs.size(); i++) {
                ParallelRunnerDist.MarketInfo minfo =
                        ParallelRunnerDist.MarketInfo.pack(marketsForArbs.get(i));
                ParallelRunnerDist.MarketInfo.unpack(sim.markets.get(i), minfo);
            }
        }
    }
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
    @Override
    public void run(long seed) {
        run(seed, false);
    }

    @SuppressWarnings("deprecation")
    public void run(long seed, boolean pipeline) {
        long TIME_INIT = System.nanoTime();
        OutputCollector out = this.out;

        LongShortCentric dm = new LongShortCentric();
        sim = factory.makeNewSimulation(seed, true, true, dm);

        long TIME_THE_BEGINNING = System.nanoTime();
        if(pipeline) {
            this.pipeline = pipeline;
            marketsForArbs = sim.markets;
            sim.markets = serializeClone(sim.markets);
        } else {
            if(longTs.size()!=0) throw new IllegalArgumentException("Please set pipeline=true if there are long-term agents");
        }

        output.beginSimulation(out, sim.markets, sim.agents);
        output.postProcess(out, SimulationStage.BEGIN_SIMULATION);
        out.clear();


        for (Session session : sim.sessions) {
            session.print();
            sim.sessionEvents = factory.createEventsForASession(session, sim);
            output.beginSession(out, session, sim.markets, sim.agents, sim.sessionEvents);
            output.postProcess(out, SimulationStage.BEGIN_SESSION);
            out.clear();
            iterateMarketUpdates(out, session, sim.fundamentals);
            output.endSession(out, session, sim.markets, sim.agents, sim.sessionEvents);
            output.postProcess(out, SimulationStage.END_SESSION);
            out.clear();
        }
        output.endSimulation(out, sim.markets, sim.agents);
        output.postProcess(out, SimulationStage.END_SIMULATION);
        out.clear();

        long TIME_THE_END = System.nanoTime();
        System.out.println("# INITIALIZATION TIME " + ((TIME_THE_BEGINNING - TIME_INIT) / 1e+9));
        System.out.println("# EXECUTION TIME " + ((TIME_THE_END - TIME_THE_BEGINNING) / 1e+9));
        // pool.shutdown();
    }

    @SuppressWarnings("deprecation")
    void submitOrders(long iterStep, int parallelism, ChunkedList<Agent> agents, Bag<List<Order>> bag,
                      Session s, SimulationOutput output) {
        final List<Market> markets = sim.markets;
        try {
            agents.parallelForEach(parallelism,
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

    void updateAgents(Step step) {
        for (Market m : sim.markets) {
            List<List<AgentUpdate>> updatesHistory = m.agentUpdates;
            assert updatesHistory.get(updatesHistory.size() - 1).isEmpty();
        }
    }

    // tmporal impl, maybe we should apply this randomize during Bag gathering
    static class Ox implements Comparable<Ox> {
        long priority;

        public Ox(long priority, long agentid, List<Order> orders) {
            this.priority = priority;
            this.agentid = agentid;
            this.orders = orders;
        }

        long agentid;
        List<Order> orders;

        @Override
        public int compareTo(Ox o) {
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
        TreeMap<Ox, List<Order>> sorted = new TreeMap<>();
        for(List<Order> orderSet: orders) {
            if (orderSet.isEmpty()) continue;
            long agentId = orderSet.get(0).agentId;
            long priority = random.getNthLong(agentId);
            sorted.put(new Ox(priority, agentId, orderSet), orderSet);
        }
        out.log("# simRandom@myShuffle", "" + orders.size() + ":"+random + ":"+ sorted.keySet().toString());
        return sorted.values();
    }



    /**
     * COPIED FROM SEQUENTIAL RUNNER
     * @param localOrders
     * @param MAX_HIFREQ_ORDERS
     * @return
     */
    public List<List<Order>> handleOrders(List<List<Order>> localOrders, List<Market> markets,
                                          long MAX_HIFREQ_ORDERS) {
        long beginTime = System.nanoTime();
        List<List<Order>> allOrders = new ArrayList<>();
//        StringBuffer buf0 = new StringBuffer();
//        for (List<Order> someOrders : localOrders) {
//            buf0.append(" "+someOrders.get(0).agentId);
//        }
//        out.log("localOrders", buf0.toString());

        Random random = sim.getRandom();
        Random tmpRandom = new Random(System.nanoTime());
        Iterable<Agent> agents = arbitragers;
        RandomPermutation<Agent> randomAgents = new RandomPermutation<>(random.split(), agents);
        //RandomPermutation<List<Order>> randomOrders = new RandomPermutation<>(random, localOrders);
        //randomOrders.shuffle();

        Collection<List<Order>> randomOrders = myShuffle(random.split(), localOrders);

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
                Market m = markets.get(((int) order.marketId));
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

        long endTime = System.nanoTime();
        if (_PROFILE) {
            System.err.println("# handle orders took " + (endTime - beginTime));
        }
        return allOrders;
    }

    /**
     * Launches a simulation with the specified output, JSON configuration, and seed using the multithreaded
     * runner.
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
        
        ParallelRunnerMT runner; 
        
        try {
            if (3 < args.length) {
                runner = new ParallelRunnerMT(simulationOutput, factory, Integer.parseInt(args[3]));
            } else {
                runner = new ParallelRunnerMT(simulationOutput, factory);
            }
        } catch (NumberFormatException e) {
            System.err.println("Failed to parse the parallelism level to use for the ParallelRunnerMT");
            e.printStackTrace();
            return;
        }
        
        runner.run(seed);
    }
}
