package plham.samples.MarketShare;

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
import plham.core.util.Random;
import plham.core.util.Statistics;

public class MarketShareFCNAgent extends FCNAgent {
    private static final long serialVersionUID = -8791648119282933905L;

    public static void register(SimulatorFactory sim) {
        String className = "MarketShareFCNAgent";
        sim.addAgentInitializer(className, new AgentInitializer() {
            /**
             *
             */
            private static final long serialVersionUID = 5023462296348181251L;

            @Override
            public Agent initialize(long id, String name, Random random, Value json) {
                return new MarketShareFCNAgent(id, name, random).setup(json, sim);
            }
        });
    }

    public MarketShareFCNAgent(long id, String name, Random random) {
        super(id, name, random);
    }

    public List<Market> filterMarkets(List<Market> markets) {
        List<Market> a = new ArrayList<>();
        for (Market market : markets) {
            if (this.isMarketAccessible(market)) {
                a.add(market);
            }
        }
        return a;
    }

    public long getSumTradeVolume(Market market) {
        long t = market.getTime();
        long timeWindowSize = Math.min(t, this.timeWindowSize);
        long volume = 0;
        for (long d = 1; d <= timeWindowSize; d++) {
            volume += market.getTradeVolume(t - d);
        }
        return volume;
    }

    @Override
    public MarketShareFCNAgent setup(JSON.Value json, SimulatorFactory sim) {
        return (MarketShareFCNAgent) super.setup(json, sim);
    }

    @Override
    public List<Order> submitOrders(List<Market> original) {
        List<Market> markets = filterMarkets(original);
        List<Double> weights = new ArrayList<>();
        for (Market m : markets) {
            weights.add(Double.valueOf(getSumTradeVolume(m)));
        }
        long k = Statistics.roulette(getRandom(), weights);
        return super.submitOrders(markets.get((int) k));
    }
}
