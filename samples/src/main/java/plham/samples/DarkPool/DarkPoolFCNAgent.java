package plham.samples.DarkPool;

import java.util.ArrayList;
import java.util.List;

import cassia.util.JSON;
import cassia.util.JSON.Value;
import plham.core.Agent;
import plham.core.Market;
import plham.core.Order;
import plham.core.agent.FCNAgent;
import plham.core.main.SimulatorFactory;
import plham.core.model.AgentInitializer;
import plham.core.util.JSONRandom;
import plham.core.util.Random;
import plham.core.util.RandomHelper;

public class DarkPoolFCNAgent extends FCNAgent {

    private static final long serialVersionUID = -522177499921561753L;

    public static void register(SimulatorFactory sim) {
        String className = "DarkPoolFCNAgent";
        sim.addAgentInitializer(className, new AgentInitializer() {
            /**
             *
             */
            private static final long serialVersionUID = 2733235254373383829L;

            @Override
            public Agent initialize(long id, String name, Random random, Value json) {
                return new DarkPoolFCNAgent(id, name, random).setup(json, sim);
            }
        });

    }

    public double darkPoolChance;

    public DarkPoolFCNAgent(long id, String name, Random random) {
        super(id, name, random);
    }

    @Override
    public DarkPoolFCNAgent setup(JSON.Value json, SimulatorFactory sim) {
        super.setup(json, sim);
        darkPoolChance = new JSONRandom(getRandom()).nextRandom(json.get("darkPoolChance"));
        return this;
    }

    @Override
    public List<Order> submitOrders(Market market) {
        List<Order> orders = new ArrayList<>();
        if (!this.isMarketAccessible(market)) {
            return orders;
        }
        if (!(market instanceof DarkPoolMarket)) {
            return orders;
        }

        RandomHelper random = new RandomHelper(getRandom());
        DarkPoolMarket dark = (DarkPoolMarket) market;
        Market lit = dark.getLitMarket();

        orders.addAll(super.submitOrders(lit));

        for (Order order : orders) {
            if (!isFinite(dark.getMidPrice()) && random.nextBoolean(darkPoolChance)) {
                order.marketId = dark.id; // Change it from Lit to DarkPool
                order.setPrice(Order.NO_PRICE);
            }
        }
        return orders;
    }
}
