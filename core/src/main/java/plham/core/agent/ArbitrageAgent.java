package plham.core.agent;

import java.util.ArrayList;
import java.util.List;

import cassia.util.JSON;
import cassia.util.JSON.Value;
import handist.collections.LongRange;
import handist.collections.RangedList;
import plham.core.Agent;
import plham.core.HighFrequencyAgent;
import plham.core.IndexMarket;
import plham.core.Market;
import plham.core.Order;
import plham.core.main.SimulatorFactory;
import plham.core.model.AgentsInitializer;
import plham.core.util.JSONRandom;
import plham.core.util.Random;

public class ArbitrageAgent extends HighFrequencyAgent {
    private static final long serialVersionUID = -7905166019557169688L;

    public static ArbitrageAgent createArbitrageAgent(long id, String name, Random random, JSON.Value json,
            SimulatorFactory sim) {
        return new ArbitrageAgent(id, name, random).setup(json, sim);
    }

    public static void register(SimulatorFactory sim) {
        String className = "ArbitrageAgent";
        sim.addAgentsInitializer(className, new AgentsInitializer() {
            private static final long serialVersionUID = 5236188032328962062L;

            @Override
            public void initialize(String name, RangedList<Random> randoms, LongRange range, Value json,
                    RangedList<Agent> agents) {
                for (long i = range.from; i < range.to; i++) {
                    agents.set(i, createArbitrageAgent(i, name, randoms.get(i), json, sim));
                }
                System.out.println("# " + json.get("class").toString() + " : " + JSON.dump(json));
            }
        });
    }

    public double orderThresholdPrice;

    public long orderTimeLength;

    public long orderVolume;

    public ArbitrageAgent() {
        super(-1, "default", new Random());
    }

    public ArbitrageAgent(long id, String name, Random random) {
        super(id, name, random);
    }

   /*
    public static long orderId = 0;
    public long nextOrderId() {
        return orderId;
    }
    */

    @Override
    public ArbitrageAgent setup(JSON.Value json, SimulatorFactory sim) {
        JSONRandom random = new JSONRandom(getRandom());
        orderVolume = json.get("orderVolume").toLong();
        orderThresholdPrice = json.get("orderThresholdPrice").toDouble();

        assert json.get("markets").size() == 1 : "ArbitrageAgents suppose only one IndexMarket";
        assert sim.getSimulatorInConstruction().getMarketByName(
                json.get("markets").get(0)) instanceof IndexMarket : "ArbitrageAgents suppose only one IndexMarket";
        IndexMarket market = (IndexMarket) sim.getSimulatorInConstruction().getMarketByName(json.get("markets").get(0));
        this.setMarketAccessible(market);
        for (long id : market.getComponents()) {
            this.setMarketAccessible(id);
        }

        this.setAssetVolume(market, Double.valueOf(random.nextRandom(json.get("assetVolume"))).longValue());
        for (long id : market.getComponents()) {
            this.setAssetVolume(id, Double.valueOf(random.nextRandom(json.get("assetVolume"))).longValue());
        }
        setCashAmount(random.nextRandom(json.get("cashAmount")));
        return this;
    }

    @Override
    public List<Order> submitOrders(List<Market> markets) {
        List<Order> orders = new ArrayList<>();
        for (Market market : markets) {
            if (this.isMarketAccessible(market)) {
                orders.addAll(this.submitOrders(market));
            }
        }
        return orders;
    }

    public List<Order> submitOrders(Market market) {
        List<Order> orders = new ArrayList<>();
        if (!(market instanceof IndexMarket)) {
            return orders;
        }
        if (!this.isMarketAccessible(market)) {
            return orders;
        }

        IndexMarket index = (IndexMarket) market;
        List<Market> spots = index.getMarkets();
        if (!index.isRunning() || !index.isAllMarketsRunning()) {
            return orders; // Stop thinking.
        }

        double marketIndex = index.getIndex();
        double marketPrice = index.getPrice();

        if (marketPrice < marketIndex && marketIndex - marketPrice > orderThresholdPrice) {
            long n = orderVolume;
            long N = spots.size() * n;

            orders.add(new Order(Order.KIND_BUY_LIMIT_ORDER, this, index, index.getPrice(), N, orderTimeLength));
            for (Market m : spots) {
                orders.add(new Order(Order.KIND_SELL_LIMIT_ORDER, this, m, m.getPrice(), n, orderTimeLength));
            }
        }
        if (marketPrice > marketIndex && marketPrice - marketIndex > orderThresholdPrice) {
            long n = orderVolume;
            long N = spots.size() * n;

            orders.add(new Order(Order.KIND_SELL_LIMIT_ORDER, this, index, index.getPrice(), N, orderTimeLength));
            for (Market m : spots) {
                orders.add(new Order(Order.KIND_BUY_LIMIT_ORDER, this, m, m.getPrice(), n, orderTimeLength));
            }
        }
        return orders;
    }

}
