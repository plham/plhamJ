package plham.core.main;

import java.io.Serializable;
import java.util.*;
import java.util.function.BiConsumer;

import cassia.util.random.RandomPermutation;
import plham.core.Agent;
import plham.core.Fundamentals;
import plham.core.Market;
import plham.core.Order;
import plham.core.OutputCollector;
import plham.core.SimulationOutput;
import plham.core.SimulationOutput.SimulationStage;
import plham.core.main.Simulator.Session;
import plham.core.util.Random;

/**
 * A Runner class for sequential execution.
 */
public class SequentialRunner extends Runner implements Serializable {
    
    /**
     * Basic {@link OutputCollector} implementation for the sequential runner.
     * As there are no management of remote objects and no risk of concurrent outptuts, direct printing to {@link System#out}as part of method {@link #print(String)} is acceptable. 
     * @author Patrick Finnerty
     *
     */
    public static class SequentialOutput implements OutputCollector {

        HashMap<String, List<String>> map = new HashMap<>();
        
        @Override
        public void print(String message) {
            System.out.println(message);
        }

        @Override
        public void clear() {
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

        @Override
        public void log(String topic, Object o) {
            List<String> listOfTopic = map.computeIfAbsent(topic, k -> {return new ArrayList<>();});
            listOfTopic.add(o.toString());
        }
        
    }
    
    
    private static final long serialVersionUID = -4747415797682000153L;

    public SequentialRunner(SimulatorFactory sim, SimulationOutput output) {
        super(output, sim);
    }

    public List<List<Order>> collectOrders(long MAX_NORMAL_ORDERS,
                                           Session s, OutputCollector out) {
        Simulator env = super.sim;
        List<Market> markets = env.markets;
        Iterable<Agent> agents = env.normalAgents;

        long beginTime = System.nanoTime();
        List<List<Order>> allOrders = new ArrayList<>();

        Random random = sim.getRandom();
        RandomPermutation<Agent> randomAgents = new RandomPermutation<>(random, agents);

        long k = 0;
        randomAgents.shuffle();
        for (Agent agent : randomAgents) {
            if (k >= MAX_NORMAL_ORDERS) {
                break;
            }
            List<Order> orders = agent.submitOrders(markets);
            if(s.withPrint)
                output.orderSubmissionOutput(out, SimulationStage.WITH_PRINT_DURING_SESSION, agent, orders, markets);
            if (orders.size() > 0) {
                allOrders.add(orders);
                k++;
            }
        }
        long endTime = System.nanoTime();
        if (_PROFILE) {
            System.out.println("#PROFILE ORDER-MAKE TOTAL " + ((endTime - beginTime) / 1e+9) + " sec");
            System.out.println("#PROFILE MAX-NORMAL-ORDERS " + MAX_NORMAL_ORDERS);
            System.out.println("#PROFILE NUM-NORMAL-ORDERS " + allOrders.size());
        }
        return allOrders;
    }

    public List<List<Order>> handleOrders(List<List<Order>> localOrders, long MAX_HIFREQ_ORDERS) {
        long beginTime = System.nanoTime();
        List<List<Order>> allOrders = new ArrayList<>();
        List<Market> markets = sim.markets;

        Random random = sim.getRandom();
        Random tmpRandom = new Random(System.nanoTime());
        Iterable<Agent> agents = sim.hifreqAgents;
        RandomPermutation<Agent> randomAgents = new RandomPermutation<>(random, agents);
        RandomPermutation<List<Order>> randomOrders = new RandomPermutation<>(random, localOrders);

        randomOrders.shuffle();
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

    @SuppressWarnings("deprecation")
    public void iterateMarketUpdates(SequentialOutput out, Session s, Fundamentals fundamentals) {
        List<Market> markets = sim.markets;
        for (Market market : markets) {
            market.setRunning(s.withOrderExecution);
        }
        for (Market market : markets) {
            market.itayoseOrderBooks();
            System.out.println("# Itayose exchangePrice " + market.lastExecutedPrices.get((int) market.getTime()));
        }
        for (Market market : markets) {
            market.check();
        }
        // System.out.println("#hoge1-2SessionName:"+sessionName+",itestep:"+iterationSteps+",withplacement:"+withOrderPlacement);
        for (long t = 1; t <= s.iterationSteps; t++) {
            sim.updateFundamentals(fundamentals);
            for (Market market : markets) {
                market.triggerBeforeSimulationStepEvents(); // Assuming the
                                                            // markets in
                                                            // dependency order.
            }
            // System.out.println("#hoge1-3:t="+t);
            if (s.withOrderPlacement) {
                updateMarkets(s.maxNormalOrders, s.maxHighFreqOrders, s, out);
            }
            // System.out.println("#hoge1-4");
            if (s.forDummyTimeseries) {
                sim.updateMarketsUsingFundamentalPrice(markets, fundamentals);
            } else {
                sim.updateMarketsUsingMarketPrice(markets, fundamentals);
            }
            // System.out.println("#hoge1-5");
            if (s.withPrint) {
                output.print(out, s, sim.markets, sim.agents, sim.sessionEvents);
                output.postProcess(out, SimulationStage.WITH_PRINT_DURING_SESSION);
                out.map.clear();
            }
            // System.out.println("#hoge1-6");
            for (Market market : markets) {
                market.triggerAfterSimulationStepEvents();
            }
            // System.out.println("#hoge1-7");
            for (Market market : markets) {
                market.updateTime();
                market.updateOrderBooks();
            }
            // System.out.println("#hoge1-8");
        }
        if (s.withPrint) {
            output.endprint(out, s, sim.markets, sim.agents, sim.sessionEvents, s.iterationSteps);
            output.postProcess(out, SimulationStage.WITH_PRINT_END_SESSION);
            out.map.clear();
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void run(long seed) {
        long TIME_INIT = System.nanoTime();
        SequentialOutput out = new SequentialOutput();

        sim = factory.makeNewSimulation(seed);

        long TIME_THE_BEGINNING = System.nanoTime();

        output.beginSimulation(out, sim.markets, sim.agents);
        output.postProcess(out, SimulationStage.BEGIN_SIMULATION);
        out.map.clear();

        for (Session session : sim.sessions) {
            session.print();
//			sim.GLOBAL.put("events", factory.createEventsForASession(session, sim));
            sim.sessionEvents = factory.createEventsForASession(session, sim);
            output.beginSession(out, session, sim.markets, sim.agents, sim.sessionEvents);
            output.postProcess(out, SimulationStage.BEGIN_SESSION);
            out.map.clear();
//			iterateMarketUpdates(session, (Fundamentals) sim.GLOBAL.get("fundamentals"));
            iterateMarketUpdates(out, session, sim.fundamentals);
            output.endSession(out, session, sim.markets, sim.agents, sim.sessionEvents);
            output.postProcess(out, SimulationStage.END_SESSION);
            out.map.clear();
        }
        output.endSimulation(out, sim.markets, sim.agents);
        output.postProcess(out, SimulationStage.END_SIMULATION);
        out.map.clear();

        long TIME_THE_END = System.nanoTime();
        System.out.println("# INITIALIZATION TIME " + ((TIME_THE_BEGINNING - TIME_INIT) / 1e+9));
        System.out.println("# EXECUTION TIME " + ((TIME_THE_END - TIME_THE_BEGINNING) / 1e+9));
    }

    public List<List<Order>> updateMarkets(long maxNormalOrders, long maxHifreqOrders,
                                           Session s, OutputCollector out) {
        List<List<Order>> orders = collectOrders(maxNormalOrders, s, out);
        return handleOrders(orders, maxHifreqOrders);
    }
}
