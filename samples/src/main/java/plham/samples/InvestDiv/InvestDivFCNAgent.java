package plham.samples.InvestDiv;

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

/** The regulation for investment diversification. */
public class InvestDivFCNAgent extends FCNAgent {
    private static final long serialVersionUID = 289665027568836431L;

    public static void register(SimulatorFactory sim) {
        String className = "InvestDivFCNAgent";
        sim.addAgentInitializer(className, new AgentInitializer() {
            /**
             *
             */
            private static final long serialVersionUID = 3222079872422198744L;

            @Override
            public Agent initialize(long id, String name, Random random, Value json) {
                return new InvestDivFCNAgent(id, name, random).setup(json, sim);
            }
        });
    }

    public double diversityRatio;

    public double leverageRatio;

    public InvestDivFCNAgent(long id, String name, Random random) {
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

    public double getAssetValue(Market market) {
        return market.getPrice() * getAssetVolume(market);
    }

    @Override
    public InvestDivFCNAgent setup(JSON.Value json, SimulatorFactory sim) {
        super.setup(json, sim);
        leverageRatio = json.get("leverageRatio").toDouble();
        diversityRatio = json.get("diversityRatio").toDouble();
        return this;
    }

    @Override
    public List<Order> submitOrders(List<Market> markets) {
        double leverageRatio = 1.0;
        List<Market> m = filterMarkets(markets);
        double nav = getCashAmount(); // netAssetValue
        double tavAbs = 0.0; // totalAssetValueAbs
        for (Market market : m) {
            double av = getAssetValue(market);
            nav += av;
            tavAbs += Math.abs(av);
        }

        List<Order> orders = new ArrayList<>();

        if (tavAbs > leverageRatio * nav) {
            return orders;
        }

        List<Order> temp = super.submitOrders(m);
        for (Order order : temp) {
            long id = order.marketId;
            Market market = markets.get((int) id);
            assert market.id == id;

            double avAbs = Math.abs(getAssetValue(market));
            if (avAbs <= diversityRatio * nav) {
                orders.add(order);
            } else {
                long timeLength = 10; // No effect (any value > 0 okay)
                double orderPrice = Order.NO_PRICE;
                long orderVolume = 1; // No optimization
                if (getAssetVolume(market) < 0) {
                    orders.add(
                            new Order(Order.KIND_BUY_MARKET_ORDER, this, market, orderPrice, orderVolume, timeLength));
                }
                if (getAssetVolume(market) > 0) {
                    orders.add(
                            new Order(Order.KIND_SELL_MARKET_ORDER, this, market, orderPrice, orderVolume, timeLength));
                }
            }
        }
        return orders;
    }
}
