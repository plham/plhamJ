package plham.core.event;

import cassia.util.JSON;
import plham.core.Event;
import plham.core.Market;
import plham.core.Market.OrderEvent;
import plham.core.Order;
import plham.core.main.SimulatorFactory;
import plham.core.model.EventInitializer;
import plham.core.util.Random;

public class PriceLimitRule implements OrderEvent {
    private static final long serialVersionUID = -6123579735261509979L;

    public static void register(SimulatorFactory sim) {
        String className = "PriceLimitRule";
        sim.addEventInitializer(className, new EventInitializer() {
            private static final long serialVersionUID = -7933070846074121349L;

            @Override
            public Event initialize(long id, Random random, String name, JSON.Value json) {
                return new PriceLimitRule(id, name, random).setup(json, sim);
            }
        });
    }

    public long activationCount;
    public long id;
    public String name;
    public Random random;
    public long referenceMarketId;
    public double referencePrice;

    public double triggerChangeRate;

    public PriceLimitRule(long id, String name, Random random) {
        this.id = id;
        this.name = name;
        this.random = random;
        activationCount = 0;
    }

    public Double getLimitedPrice(Order order, Market market) {
        assert referenceMarketId == market.id;
        double orderPrice = order.getPrice();
        double priceChange = orderPrice - referencePrice;
        double thresholdChange = referencePrice * triggerChangeRate;
        if (Math.abs(priceChange) >= Math.abs(thresholdChange)) {
            double maxPrice = referencePrice * (1 + triggerChangeRate);
            double minPrice = referencePrice * (1 - triggerChangeRate);
            double limitedPrice = Math.min(Math.max(orderPrice, minPrice), maxPrice);
            return limitedPrice;
        }
        return orderPrice;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public PriceLimitRule setup(JSON.Value json, SimulatorFactory sim) {
        Market referenceMarket = sim.getSimulatorInConstruction().getMarketByName(json.get("referenceMarket"));
        referenceMarketId = referenceMarket.id;
        referencePrice = referenceMarket.getPrice();
        triggerChangeRate = json.get("triggerChangeRate").toDouble();
        referenceMarket.addBeforeOrderHandlingEvent(this);
        return this;
    }

    @Override
    public void update(Market market, Order order) {
        assert referenceMarketId == market.id;
        if (market.isRunning()) {
            // Mizuta etal (2014)'s implementation.
            double oldPrice = order.getPrice();
            double newPrice = getLimitedPrice(order, market);
            order.setPrice(newPrice);
            if (newPrice != oldPrice) {
                activationCount++;
            }
        }
    }
}
