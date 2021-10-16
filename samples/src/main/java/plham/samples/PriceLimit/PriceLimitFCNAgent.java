package plham.samples.PriceLimit;

import java.util.List;

import cassia.util.JSON;
import cassia.util.JSON.Value;
import plham.core.Agent;
import plham.core.Market;
import plham.core.Order;
import plham.core.agent.FCNAgent;
import plham.core.event.PriceLimitRule;
import plham.core.main.SimulatorFactory;
import plham.core.model.AgentInitializer;
import plham.core.util.Random;

public class PriceLimitFCNAgent extends FCNAgent {
    private static final long serialVersionUID = -422099265741636519L;

    public static void register(SimulatorFactory sim) {
        String className = "PriceLimitFCNAgent";
        sim.addAgentInitializer(className, new AgentInitializer() {
            /**
             *
             */
            private static final long serialVersionUID = -1244542071744927510L;

            @Override
            public Agent initialize(long id, String name, Random random, Value json) {
                return new PriceLimitFCNAgent(id, name, random).setup(json, sim);
            }
        });
    }

    public PriceLimitRule priceLimit;

    public PriceLimitFCNAgent(long id, String name, Random random) {
        super(id, name, random);
    }

    @Override
    public PriceLimitFCNAgent setup(JSON.Value json, SimulatorFactory sim) {
        super.setup(json, sim);
        priceLimit = (PriceLimitRule) sim.createEvents(sim.CONFIG.get(json.get("priceLimit"))).get(0);
        return this;
    }

    @Override
    public List<Order> submitOrders(Market market) {
        List<Order> orders = super.submitOrders(market);
        if (orders.size() == 0) {
            return orders;
        }

        for (Order order : orders) {
            double oldPrice = order.getPrice();
            double newPrice = priceLimit.getLimitedPrice(order, market);
            if (newPrice != oldPrice) {
                order.setPrice(newPrice); // Adjust the price.
                // You may need replanning.
            }
        }
        return orders;
    }
}
