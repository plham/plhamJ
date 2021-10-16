package plham.core.agent;

import java.util.ArrayList;
import java.util.List;

import cassia.util.JSON;
import plham.core.Agent;
import plham.core.Market;
import plham.core.Order;
import plham.core.main.SimulatorFactory;
import plham.core.model.AgentInitializer;
import plham.core.util.JSONRandom;
import plham.core.util.Random;
import plham.core.util.RandomHelper;

/**
 * An order decision mechanism proposed in Chiarella & Iori (2004). It employs two simple margin-based random tradings.
 *
 * Given an expected future price <it>p</it>, submit an order of price
 * <ul>
 * <li><code>"fixed"</code> : <it>p</it> (1 &pm; <it>k</it>) where 0 \u2266 <it>k</it> \u2266 1
 * <li><code>"normal"</code> : <it>p</it> + N(0, <it>k</it>) where <it>k</it> > 0
 * </ul>
 */

public class FCNAgent extends plham.core.Agent {
    public static long MARGIN_FIXED = 0; // "FixedMargin";

    public static long MARGIN_NORMAL = 1; // "NormalMargin";
    private static final long serialVersionUID = 3210976154184567934L;

    public static boolean isFinite(Double x) {
        return !x.isNaN() && !x.isInfinite();
    }

    public static void register(SimulatorFactory sim) {
        String className = "FCNAgent";
        sim.addAgentInitializer(className, new AgentInitializer() {
            /** Serial Version UID */
            private static final long serialVersionUID = -2286430372167712705L;

            @Override
            public Agent initialize(long id, String name, Random random, JSON.Value json) {
                return new FCNAgent(id, name, random).setup(json, sim);
            }
        });
    }

    public double chartWeight;
    public double fundamentalWeight;
    public boolean isChartFollowing = false;
    public long marginType;

    public long meanReversionTime;
    public double noiseScale;
    public double noiseWeight;

    public double orderMargin;

    public long timeWindowSize;

    public FCNAgent(long id, String name, Random random) {
        super(id, name, random);
    }

    @Override
    public FCNAgent setup(JSON.Value json, SimulatorFactory sim) {
        JSONRandom jsonRandom = new JSONRandom(random);
        super.setup(json, sim); // first, setup this agent as plham.Agent.
                                // and then, setup as plham.agent.FCNAgent;
        fundamentalWeight = jsonRandom.nextRandom(json.get("fundamentalWeight"));
        chartWeight = jsonRandom.nextRandom(json.get("chartWeight"));
        noiseWeight = jsonRandom.nextRandom(json.get("noiseWeight"));
        isChartFollowing = (jsonRandom.nextDouble() < 1.0); // 100%
        noiseScale = jsonRandom.nextRandom(json.get("noiseScale"));
        timeWindowSize = (long) jsonRandom.nextRandom(json.get("timeWindowSize"));
        orderMargin = jsonRandom.nextRandom(json.get("orderMargin"));

        if ("fixed".equals(json.getOrElse("marginType", "fixed").toString())) {
            marginType = FCNAgent.MARGIN_FIXED;
        } else {
            marginType = FCNAgent.MARGIN_NORMAL;
        }
        if (json.has("meanReversionTime")) {
            meanReversionTime = (long) jsonRandom.nextRandom(json.get("meanReversionTime"));
        } else {
            meanReversionTime = timeWindowSize;
        }
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

    /*
     * public String submitOrdersInfo(Market market) { StringBuffer buf = new StringBuffer(); buf.append("M:"+market.id
     * + ":"+market.getClass()); if (!this.isMarketAccessible(market)) { return "!isAccessible"; }
     * buf.append(", Rand:"+random.toString()); double fundamentalScale = 1.0 / Math.max(meanReversionTime, 1);
     * buf.append(", fundS:"+fundamentalScale); buf.append(", fundP:"+market.getFundamentalPrice()); double
     * fundamentalLogReturn = fundamentalScale * Math.log(market.getFundamentalPrice() / market.getPrice());
     * buf.append(", fundR:"+fundamentalLogReturn); double chartScale = 1.0 / Math.max(timeWindowSize, 1);
     * buf.append(", chartS:"+chartScale); buf.append(", price:" + market.getPrice()); return buf.toString(); }
     */
    public List<Order> submitOrders(Market market) {
        List<Order> orders = new ArrayList<>();
        if (!this.isMarketAccessible(market)) {
            return orders;
        }

        RandomHelper helper = new RandomHelper(random);

        long t = market.getTime();

        long timeWindowSize = Math.min(t, this.timeWindowSize);
        assert timeWindowSize >= 0 : "timeWindowSize >= 0";

        assert fundamentalWeight >= 0.0 : "fundamentalWeight >= 0.0";
        assert chartWeight >= 0.0 : "chartWeight >= 0.0";
        assert noiseWeight >= 0.0 : "noiseWeight >= 0.0";

        double fundamentalScale = 1.0 / Math.max(meanReversionTime, 1);
        double fundamentalLogReturn = fundamentalScale * Math.log(market.getFundamentalPrice() / market.getPrice());
        assert isFinite(fundamentalLogReturn) : "isFinite(fundamentalLogReturn)";

        double chartScale = 1.0 / Math.max(timeWindowSize, 1);
        double chartMeanLogReturn = chartScale * Math.log(market.getPrice() / market.getPrice(t - timeWindowSize));
        assert isFinite(chartMeanLogReturn) : "isFinite(chartMeanLogReturn)";

        double noiseLogReturn = 0.0 + noiseScale * helper.nextGaussian();
        assert isFinite(noiseLogReturn) : "isFinite(noiseLogReturn)";

        double expectedLogReturn = (1.0 / (fundamentalWeight + chartWeight + noiseWeight))
                * (fundamentalWeight * fundamentalLogReturn
                        + chartWeight * chartMeanLogReturn * (isChartFollowing ? +1 : -1)
                        + noiseWeight * noiseLogReturn);
        assert isFinite(expectedLogReturn) : "isFinite(expectedLogReturn)";

        double expectedFuturePrice = market.getPrice() * Math.exp(expectedLogReturn * timeWindowSize);
        assert isFinite(expectedFuturePrice) : "isFinite(expectedFuturePrice)";

        if (marginType == MARGIN_FIXED) {
            assert 0.0 <= orderMargin && orderMargin <= 1.0;

            double orderPrice = 0.0;
            long orderVolume = 1;

            if (expectedFuturePrice > market.getPrice()) {
                orderPrice = expectedFuturePrice * (1 - orderMargin);
                orders.add(
                        new Order(Order.KIND_BUY_LIMIT_ORDER, this, market, orderPrice, orderVolume, timeWindowSize));
            }
            if (expectedFuturePrice < market.getPrice()) {
                orderPrice = expectedFuturePrice * (1 + orderMargin);
                orders.add(
                        new Order(Order.KIND_SELL_LIMIT_ORDER, this, market, orderPrice, orderVolume, timeWindowSize));
            }
            assert orderPrice >= 0.0 : "orderPrice >= 0.0 " + orderPrice;
            assert orderVolume >= 0 : "orderVolume >= 0 " + orderVolume;
        }
        if (marginType == MARGIN_NORMAL) {
            assert orderMargin >= 0.0;

            double orderPrice = expectedFuturePrice + helper.nextGaussian() * orderMargin;
            long orderVolume = 1;
            assert orderPrice >= 0.0 : "orderPrice >= 0.0" + orderPrice;
            assert orderVolume >= 0 : "orderVolume >= 0" + orderVolume;

            if (expectedFuturePrice > orderPrice) {
                orders.add(
                        new Order(Order.KIND_BUY_LIMIT_ORDER, this, market, orderPrice, orderVolume, timeWindowSize));
            }
            if (expectedFuturePrice < orderPrice) {
                orders.add(
                        new Order(Order.KIND_SELL_LIMIT_ORDER, this, market, orderPrice, orderVolume, timeWindowSize));
            }
        }
        return orders;
    }

    @Override
    public String toString() {
        return "Agent:" + id + "[rnd:" + random + ",cw:" + chartWeight + ",fw:" + fundamentalWeight + ",following:"
                + isChartFollowing + ", mtype: " + marginType + ", mrt:" + meanReversionTime + ", ns:" + noiseScale
                + ", nw:" + noiseWeight + ", om:" + orderMargin + ", tws:" + timeWindowSize + ", cash:" + cashAmount
                + "]";
    }
}
