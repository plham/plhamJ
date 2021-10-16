package plham.core.event;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cassia.util.JSON;
import plham.core.Event;
import plham.core.Market;
import plham.core.Market.MarketEvent;
import plham.core.Market.OrderEvent;
import plham.core.Order;
import plham.core.main.Simulator;
import plham.core.main.SimulatorFactory;
import plham.core.model.EventInitializer;
import plham.core.util.Random;

/**
 * A trading halt is a market regulation that suspends the trading of some assets. The current implementation sets
 * <code>Market#isRunning() = false</code> when the price changed beyond the prespecified threshold range.
 */

public class TradingHaltRule implements MarketEvent, OrderEvent {
    private static final long serialVersionUID = 7954530038790226915L;

    public static void register(SimulatorFactory sim) {
        String className = "TradingHaltRule";
        sim.addEventInitializer(className, new EventInitializer() {
            private static final long serialVersionUID = -4077307430140468053L;

            @Override
            public Event initialize(long id, Random random, String name, JSON.Value json) {
                return new TradingHaltRule(id, name, random).setup(json, sim);
            }
        });
    }

    public long activationCount;
    public long haltingTimeLength;
    public long haltingTimeStarted;
    public long id;
    public String name;
    public Random random;
    public long referenceMarketId;
    public Double referencePrice;
    public Set<Long> targetMarketIds; // Use referenceMarket.id ?

    public Double triggerChangeRate;

    public TradingHaltRule(Long id, String name, Random random) {
        this.id = id;
        this.name = name;
        this.random = random;
        haltingTimeStarted = Long.MIN_VALUE;
        activationCount = 0;
        targetMarketIds = new HashSet<>();
    }

    public void addTargetMarket(Market market) {
        targetMarketIds.add(market.id);
    }

    public void addTargetMarkets(List<Market> markets) {
        for (Market market : markets) {
            targetMarketIds.add(market.id);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public void setReferencePrice(Double referencePrice) {
        this.referencePrice = referencePrice;
    }

    @Override
    public TradingHaltRule setup(JSON.Value json, SimulatorFactory sim) {
        Simulator s = sim.getSimulatorInConstruction();
        Market market = s.getMarketByName(json.get("referenceMarket"));
        referenceMarketId = market.id;
        referencePrice = market.getPrice();
        triggerChangeRate = json.get("triggerChangeRate").toDouble();
        haltingTimeLength = json.get("haltingTimeLength").toLong();
        List<Market> targetMarkets = s.getMarketsByName(json.get("targetMarkets"));
        addTargetMarkets(targetMarkets);
        market.addAfterOrderHandlingEvent(this);
        return this;
    }

    @Override
    public void update(Market market) {
        assert referenceMarketId == market.id;
        Market referenceMarket = market;
        Simulator env = market.env;
        long t = referenceMarket.getTime();
        if (referenceMarket.isRunning()) {
            double priceChange = referencePrice - referenceMarket.getPrice();
            double thresholdChange = referencePrice * triggerChangeRate * (activationCount + 1);
            if (Math.abs(priceChange) >= Math.abs(thresholdChange)) {
                referenceMarket.setRunning(false);
                for (long i : targetMarketIds) {
                    Market target = env.markets.get((int) i);
                    target.setRunning(false);
                }
                haltingTimeStarted = t;
                activationCount++;
            }
        } else {
            if (t > haltingTimeStarted + haltingTimeLength) {
                referenceMarket.setRunning(true);
                for (long i : targetMarketIds) {
                    Market target = env.markets.get((int) i);
                    target.itayoseOrderBooks();
                    target.setRunning(true);
                }
                haltingTimeStarted = Long.MIN_VALUE;
            }
        }
    }

    @Override
    public void update(Market market, Order order) {
        this.update(market);
    }

}
