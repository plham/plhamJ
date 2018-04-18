package plham.agent;

import java.util.ArrayList;
import java.util.List;
import plham.util.Random;

import cassia.util.JSON;
import plham.Agent;
import plham.Market;
import plham.Order;
import plham.main.Simulator;
import plham.model.AgentInitializer;
import plham.util.JSONRandom;
import plham.util.RandomHelper;

/**
 * An order decision mechanism proposed in Chiarella & Iori (2004). It employs
 * two simple margin-based random tradings.
 * 
 * Given an expected future price <it>p</it>, submit an order of price
 * <ul>
 * <li> <code>"fixed"</code> : <it>p</it> (1 &pm; <it>k</it>) where 0 \u2266
 * <it>k</it> \u2266 1
 * <li> <code>"normal"</code> : <it>p</it> + N(0, <it>k</it>) where <it>k</it> >
 * 0
 * </ul>
 */

public class FCNAgent extends plham.Agent {
	private static final long serialVersionUID = 3210976154184567934L;

	/*
	public var fundamentalWeight:Double;
	public var chartWeight:Double;
	public var noiseWeight:Double;
	public var noiseScale:Double;
	public var timeWindowSize:Long;
	public var orderMargin:Double;
	public var isChartFollowing:Boolean = false;
	public var meanReversionTime:Long;

	public static MARGIN_FIXED = 0; //"FixedMargin";
	public static MARGIN_NORMAL = 1; //"NormalMargin";
	public var marginType:Long;
	*/
	public double fundamentalWeight;
	public double chartWeight;
	public double noiseWeight;
	public double noiseScale;
	public long timeWindowSize;
	public double orderMargin;
	public boolean isChartFollowing = false;
	public long meanReversionTime;

	public static long MARGIN_FIXED = 0; // "FixedMargin";
	public static long MARGIN_NORMAL = 1; // "NormalMargin";
	public long marginType;

	/*
	public def this(id:Long, name:String, random:Random) = super(id, name, random);
	*/
	public FCNAgent(long id, String name, Random random) {
		super(id, name, random);
	}

	/*
	public static def register(sim:Simulator):void {
		val className = "FCNAgent";
		sim.addAgentInitializer(className,
			(
				id:Long,
				name:String, 
				random:Random,
				json:JSON.Value
			) => {
				return new FCNAgent(id, name, random).setup(json, sim);
			}
		);
	}
	*/
	public static void register(Simulator sim) {
		String className = "FCNAgent";
		sim.addAgentInitializer(className, new AgentInitializer() {
			public Agent initialize(long id, String name, Random random,
					JSON.Value json) {
				return new FCNAgent(id, name, random).setup(json, sim);
			}
		});
	}

	/*
	public def setup(json:JSON.Value, sim:Simulator):FCNAgent {
		val jsonrandom = new JSONRandom(getRandom());
		super.setup(json, sim); // first, setup this agent as plham.Agent. and then, setup as plham.agent.FCNAgent;
		val MARGIN_TYPES = JSON.parse(
			"{'fixed': " + FCNAgent.MARGIN_FIXED + "," +
			"'normal': " + FCNAgent.MARGIN_NORMAL +
		"}");
		this.fundamentalWeight = jsonrandom.nextRandom(json("fundamentalWeight"));
		this.chartWeight = jsonrandom.nextRandom(json("chartWeight"));
		this.noiseWeight = jsonrandom.nextRandom(json("noiseWeight"));
		this.isChartFollowing = (jsonrandom.nextDouble() < 1.0); // 100%
		this.noiseScale = jsonrandom.nextRandom(json("noiseScale"));
		this.timeWindowSize = jsonrandom.nextRandom(json("timeWindowSize")) as Long;
		this.orderMargin = jsonrandom.nextRandom(json("orderMargin"));
		this.marginType = MARGIN_TYPES(json("marginType", "fixed")).toLong();
		if(json.has("meanReversionTime")){
			this.meanReversionTime = jsonrandom.nextRandom(json("meanReversionTime")) as Long;
		}else{
			this.meanReversionTime = this.timeWindowSize;
		}
		return this;
	}
	*/
	@Override
	public FCNAgent setup(JSON.Value json, Simulator sim) {
		JSONRandom jsonRandom = new JSONRandom(random);
		super.setup(json, sim); // first, setup this agent as plham.Agent.
								// and then, setup as plham.agent.FCNAgent;
		/*
		val MARGIN_TYPES = JSON.parse(
			"{'fixed': " + FCNAgent.MARGIN_FIXED + "," +
			"'normal': " + FCNAgent.MARGIN_NORMAL +
		"}");
		*/
		this.fundamentalWeight = jsonRandom.nextRandom(json
				.get("fundamentalWeight"));
		this.chartWeight = jsonRandom.nextRandom(json.get("chartWeight"));
		this.noiseWeight = jsonRandom.nextRandom(json.get("noiseWeight"));
		this.isChartFollowing = (jsonRandom.nextDouble() < 1.0); // 100%
		this.noiseScale = jsonRandom.nextRandom(json.get("noiseScale"));
		this.timeWindowSize = (long) jsonRandom.nextRandom(json
				.get("timeWindowSize"));
		this.orderMargin = jsonRandom.nextRandom(json.get("orderMargin"));

		if ("fixed".equals(json.getOrElse("marginType", "fixed").toString())) {
			this.marginType = FCNAgent.MARGIN_FIXED;
		} else {
			this.marginType = FCNAgent.MARGIN_NORMAL;
		}
		if (json.has("meanReversionTime")) {
			this.meanReversionTime = (long) jsonRandom.nextRandom(json
					.get("meanReversionTime"));
		} else {
			this.meanReversionTime = this.timeWindowSize;
		}
		return this;
	}

	/*
	public static def isFinite(x:Double) {
		return !x.isNaN() && !x.isInfinite();
	}
	*/
	public static boolean isFinite(Double x) {
		return !x.isNaN() && !x.isInfinite();
	}

	/*
	public def submitOrders(markets:List[Market]):List[Order] {
		val orders = new ArrayList[Order]();
		for (market in markets) {
			if (this.isMarketAccessible(market)) {
				orders.addAll(this.submitOrders(market));
			}
		}
		return orders;
	}
	*/

	@Override
	public List<Order> submitOrders(List<Market> markets) {
		List<Order> orders = new ArrayList<Order>();
		for (Market market : markets) {
			if (this.isMarketAccessible(market)) {
				orders.addAll(this.submitOrders(market));
			}
		}
		return orders;
	}

	/*
	public def submitOrders(market:Market):List[Order] {
		val orders = new ArrayList[Order]();
		if (!this.isMarketAccessible(market)) {
			return orders;
		}

		val random = new RandomHelper(getRandom());

		val fcRatio = (1.0 + this.fundamentalWeight) / (1.0 + this.chartWeight);

		val t = market.getTime();

		val timeWindowSize = Math.min(t, this.timeWindowSize);
		assert timeWindowSize >= 0 : "timeWindowSize >= 0";

		assert this.fundamentalWeight >= 0.0 : "fundamentalWeight >= 0.0";
		assert this.chartWeight >= 0.0 : "chartWeight >= 0.0";
		assert this.noiseWeight >= 0.0 : "noiseWeight >= 0.0";
		
		val fundamentalScale = 1.0 / Math.max(meanReversionTime, 1);
		val fundamentalLogReturn = fundamentalScale * Math.log(market.getFundamentalPrice(t) / market.getPrice(t));
		assert isFinite(fundamentalLogReturn) : "isFinite(fundamentalLogReturn)";

		val chartScale = 1.0 / Math.max(timeWindowSize, 1);
		val chartMeanLogReturn = chartScale * Math.log(market.getPrice(t) / market.getPrice(t - timeWindowSize));
		assert isFinite(chartMeanLogReturn) : "isFinite(chartMeanLogReturn)";

		val noiseLogReturn = 0.0 + this.noiseScale * random.nextGaussian();
		assert isFinite(noiseLogReturn) : "isFinite(noiseLogReturn)";
		
		val expectedLogReturn = (1.0 / (this.fundamentalWeight + this.chartWeight + this.noiseWeight))
				* (this.fundamentalWeight * fundamentalLogReturn
					+ this.chartWeight * chartMeanLogReturn * (this.isChartFollowing ? +1 : -1)
					+ this.noiseWeight * noiseLogReturn);
		assert isFinite(expectedLogReturn) : "isFinite(expectedLogReturn)";
		
		val expectedFuturePrice = market.getPrice(t) * Math.exp(expectedLogReturn * timeWindowSize);
		assert isFinite(expectedFuturePrice) : "isFinite(expectedFuturePrice)";

		if (this.marginType == MARGIN_FIXED) {
			assert 0.0 <= this.orderMargin && this.orderMargin <= 1.0;

			var orderPrice:Double = 0.0;
			var orderVolume:Long = 1;

			if (expectedFuturePrice > market.getPrice(t)) {
				orderPrice = expectedFuturePrice * (1 - this.orderMargin);
				orders.add(new Order(Order.KIND_BUY_LIMIT_ORDER, this, market, orderPrice, orderVolume, timeWindowSize));
			}
			if (expectedFuturePrice < market.getPrice(t)) {
				orderPrice = expectedFuturePrice * (1 + this.orderMargin);
				orders.add(new Order(Order.KIND_SELL_LIMIT_ORDER, this, market, orderPrice, orderVolume, timeWindowSize));
			}
			assert orderPrice >= 0.0 : ["orderPrice >= 0.0", orderPrice];
			assert orderVolume >= 0 : ["orderVolume >= 0", orderVolume];
		}
		if (this.marginType == MARGIN_NORMAL) {
			assert this.orderMargin >= 0.0;

			var orderPrice:Double = expectedFuturePrice + random.nextGaussian() * this.orderMargin;
			var orderVolume:Long = 1;
			assert orderPrice >= 0.0 : ["orderPrice >= 0.0", orderPrice];
			assert orderVolume >= 0 : ["orderVolume >= 0", orderVolume];

			if (expectedFuturePrice > orderPrice) {
				orders.add(new Order(Order.KIND_BUY_LIMIT_ORDER, this, market, orderPrice, orderVolume, timeWindowSize));
			}
			if (expectedFuturePrice < orderPrice) {
				orders.add(new Order(Order.KIND_SELL_LIMIT_ORDER, this, market, orderPrice, orderVolume, timeWindowSize));
			}
		}
		return orders;
	}
	 */
	@SuppressWarnings("hiding")
	public List<Order> submitOrders(Market market) {
		List<Order> orders = new ArrayList<Order>();
		if (!this.isMarketAccessible(market)) {
			return orders;
		}

		RandomHelper helper = new RandomHelper(random);

		/*
		double fcRatio = (1.0 + this.fundamentalWeight)
				/ (1.0 + this.chartWeight);
		*/
		long t = market.getTime();

		long timeWindowSize = Math.min(t, this.timeWindowSize);
		assert timeWindowSize >= 0 : "timeWindowSize >= 0";

		assert this.fundamentalWeight >= 0.0 : "fundamentalWeight >= 0.0";
		assert this.chartWeight >= 0.0 : "chartWeight >= 0.0";
		assert this.noiseWeight >= 0.0 : "noiseWeight >= 0.0";

		double fundamentalScale = 1.0 / Math.max(meanReversionTime, 1);
		double fundamentalLogReturn = fundamentalScale
				* Math.log(market.getFundamentalPrice(t) / market.getPrice(t));
		assert isFinite(fundamentalLogReturn) : "isFinite(fundamentalLogReturn)";

		double chartScale = 1.0 / Math.max(timeWindowSize, 1);
		double chartMeanLogReturn = chartScale
				* Math.log(market.getPrice(t)
						/ market.getPrice(t - timeWindowSize));
		assert isFinite(chartMeanLogReturn) : "isFinite(chartMeanLogReturn)";

		double noiseLogReturn = 0.0 + this.noiseScale * helper.nextGaussian();
		assert isFinite(noiseLogReturn) : "isFinite(noiseLogReturn)";

		double expectedLogReturn = (1.0 / (this.fundamentalWeight
				+ this.chartWeight + this.noiseWeight))
				* (this.fundamentalWeight * fundamentalLogReturn
						+ this.chartWeight * chartMeanLogReturn
						* (this.isChartFollowing ? +1 : -1) + this.noiseWeight
						* noiseLogReturn);
		assert isFinite(expectedLogReturn) : "isFinite(expectedLogReturn)";

		double expectedFuturePrice = market.getPrice(t)
				* Math.exp(expectedLogReturn * timeWindowSize);
		assert isFinite(expectedFuturePrice) : "isFinite(expectedFuturePrice)";

		if (this.marginType == MARGIN_FIXED) {
			assert 0.0 <= this.orderMargin && this.orderMargin <= 1.0;

			double orderPrice = 0.0;
			long orderVolume = 1;

			if (expectedFuturePrice > market.getPrice(t)) {
				orderPrice = expectedFuturePrice * (1 - this.orderMargin);
				orders.add(new Order(Order.KIND_BUY_LIMIT_ORDER, this, market,
						orderPrice, orderVolume, timeWindowSize));
			}
			if (expectedFuturePrice < market.getPrice(t)) {
				orderPrice = expectedFuturePrice * (1 + this.orderMargin);
				orders.add(new Order(Order.KIND_SELL_LIMIT_ORDER, this, market,
						orderPrice, orderVolume, timeWindowSize));
			}
			assert orderPrice >= 0.0 : "orderPrice >= 0.0 " + orderPrice;
			assert orderVolume >= 0 : "orderVolume >= 0 " + orderVolume;
		}
		if (this.marginType == MARGIN_NORMAL) {
			assert this.orderMargin >= 0.0;

			double orderPrice = expectedFuturePrice + helper.nextGaussian()
					* this.orderMargin;
			long orderVolume = 1;
			assert orderPrice >= 0.0 : "orderPrice >= 0.0" + orderPrice;
			assert orderVolume >= 0 : "orderVolume >= 0" + orderVolume;

			if (expectedFuturePrice > orderPrice) {
				orders.add(new Order(Order.KIND_BUY_LIMIT_ORDER, this, market,
						orderPrice, orderVolume, timeWindowSize));
			}
			if (expectedFuturePrice < orderPrice) {
				orders.add(new Order(Order.KIND_SELL_LIMIT_ORDER, this, market,
						orderPrice, orderVolume, timeWindowSize));
			}
		}
		return orders;
	}
}
