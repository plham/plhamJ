package plham.samples.MarketShare;

import java.util.ArrayList;
import java.util.List;

import cassia.util.JSON;
import cassia.util.JSON.Value;
import plham.core.Agent;
import plham.core.HighFrequencyAgent;
import plham.core.Market;
import plham.core.Order;
import plham.core.main.SimulatorFactory;
import plham.core.model.AgentInitializer;
import plham.core.util.JSONRandom;
import plham.core.util.Random;

public class MarketMakerAgent extends HighFrequencyAgent {
    private static final long serialVersionUID = 6851558918913913633L;

    public static boolean isFinite(double d) {
        Double x = Double.valueOf(d);
        return !x.isNaN() && !x.isInfinite();
    }

    public static void register(SimulatorFactory sim) {
        String className = "MarketMakerAgent";
        sim.addAgentInitializer(className, new AgentInitializer() {
            /**
             *
             */
            private static final long serialVersionUID = -8912027028646476053L;

            @Override
            public Agent initialize(long id, String name, Random random, Value json) {
                return new MarketMakerAgent(id, name, random).setup(json, sim);
            }
        });
    }

    public double netInterestSpread;

    public long orderTimeLength;

    public long targetMarketId;

    public MarketMakerAgent(long id, String name, Random random) {
        super(id, name, random);
    }

    public double getBasePrice(List<Market> markets) {
        double maxBuy = Double.NEGATIVE_INFINITY;
        for (Market market : markets) {
            if (isMarketAccessible(market)) {
                maxBuy = Math.max(maxBuy, market.getBestBuyPrice());
            }
        }
        double minSell = Double.POSITIVE_INFINITY;
        for (Market market : markets) {
            if (isMarketAccessible(market)) {
                minSell = Math.min(minSell, market.getBestSellPrice());
            }
        }
        return (maxBuy + minSell) / 2.0;
    }

    @Override
    public MarketMakerAgent setup(JSON.Value json, SimulatorFactory sim) {
        super.setup(json, sim);
        Market targetMarket = sim.getSimulatorInConstruction().getMarketByName(json.get("targetMarket"));
        JSONRandom random = new JSONRandom(getRandom());
        targetMarketId = targetMarket.id;
        netInterestSpread = random.nextRandom(json.get("netInterestSpread"));
        orderTimeLength = Double.valueOf(random.nextRandom(json.getOrElse("orderTimeLength", "2"))).longValue();
        return this;
    }

    @Override
    public List<Order> submitOrders(List<Market> markets) {
        List<Order> orders = new ArrayList<>();

        Market target = markets.get((int) targetMarketId);

        double basePrice = getBasePrice(markets);
        if (!isFinite(basePrice)) {
            basePrice = target.getPrice(); // Use this instead.
        }

        double priceMargin = target.getFundamentalPrice() * netInterestSpread * 0.5;
        long orderVolume = 1;
        orders.add(new Order(Order.KIND_BUY_LIMIT_ORDER, this, target, basePrice - priceMargin, orderVolume,
                orderTimeLength));
        orders.add(new Order(Order.KIND_SELL_LIMIT_ORDER, this, target, basePrice + priceMargin, orderVolume,
                orderTimeLength));

        return orders;
    }

}
