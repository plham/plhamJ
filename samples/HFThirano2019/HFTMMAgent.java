package samples.HFThirano2019;

import cassia.util.JSON;
import cassia.util.random.Gaussian;
import plham.Agent;
import plham.Cancel;
import plham.Market;
import plham.Order;
import plham.agent.FCNAgent;
import plham.main.Simulator;
import plham.model.AgentInitializer;
import plham.util.JSONRandom;
import plham.util.Random;
import plham.util.RandomHelper;

import java.util.ArrayList;
import java.util.List;

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

public class HFTMMAgent extends FCNAgent {
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
	public double riskTime;
	public double riskHedgeLevel;
	public List<Order> current_orders = new ArrayList<Order>();

	public long orderId = 1;

	@Override
	public long nextOrderId() {
		return orderId++;
	}
	/*
	public def this(id:Long, name:String, random:Random) = super(id, name, random);
	*/
	public HFTMMAgent(long id, String name, Random random) {
		super(id, name, random);
	}

	public static void register(Simulator sim) {
		String className = "HFTMMAgent";
		sim.addAgentInitializer(className, new AgentInitializer() {
			public Agent initialize(long id, String name, Random random,
									JSON.Value json) {
				return new HFTMMAgent(id, name, random).setup(json, sim);
			}
		});
	}

	@Override
	public HFTMMAgent setup(JSON.Value json, Simulator sim) {
		JSONRandom jsonRandom = new JSONRandom(random);
		super.setup(json, sim); // first, setup this agent as plham.Agent.

		this.fundamentalWeight = jsonRandom.nextRandom(json
				.get("fundamentalWeight"));
		this.chartWeight = jsonRandom.nextRandom(json.get("chartWeight"));
		this.noiseWeight = jsonRandom.nextRandom(json.get("noiseWeight"));
		this.isChartFollowing = (jsonRandom.nextDouble() < 1.0); // 100%
		this.noiseScale = jsonRandom.nextRandom(json.get("noiseScale"));
		this.timeWindowSize = (long) jsonRandom.nextRandom(json
				.get("timeWindowSize"));
		this.orderMargin = jsonRandom.nextRandom(json.get("orderMargin"));

		if (json.has("meanReversionTime")) {
			this.meanReversionTime = (long) jsonRandom.nextRandom(json
					.get("meanReversionTime"));
		} else {
			this.meanReversionTime = this.timeWindowSize;
		}

		this.riskTime = jsonRandom.nextRandom(json.get("riskTime"));
		this.riskHedgeLevel = jsonRandom.nextRandom(json.get("riskHedgeLevel"));

		return this;
	}

	public static boolean isFinite(Double x) {
		return !x.isNaN() && !x.isInfinite();
	}

	@Override
	public void orderExecuted(long marketId, long orderId, double price,
							  double cashAmountDelta, long assetVolumeDelta) {
		for (Order oneOrder : this.current_orders){
			if (oneOrder.orderId == orderId){
				this.current_orders.remove(oneOrder);
				break;
			}
		}
	}

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

	@SuppressWarnings("hiding")
	public List<Order> submitOrders(Market market) {


		List<Order> orders = new ArrayList<Order>();
		List<Order> cancelOrders = new ArrayList<Order>();
		double gamma = this.riskHedgeLevel;
		double sigma = getVolatility(market);
		double delta_t = this.riskTime;
		double s = market.getFundamentalPrice() ;//+ Gaussian.gaussDenseValue(0,0,2);
		//double s = getFuturPrice(market);
		double alpha = this.getBookStrength(market);
		double q = this.getAssetVolume(market);

		double hat_s = s - gamma * Math.pow(sigma, 2) * delta_t * q;
		double delta = gamma * Math.pow(sigma, 2) * delta_t + 2.0 / gamma * Math.log(1 + gamma / alpha);
		double p_b = hat_s + delta * 0.5;
		double p_a = hat_s - delta * 0.5;
		double tick = market.getTickSize();
		double p_b_order = p_b - (p_b % tick) + (p_b % tick == 0 ? 0 : 1);
		double p_a_order = p_a - (p_a % tick);

		/*System.out.println(">>>>>>>>>>>>>>>>");
		System.out.println(String.format("ID: %s", this.id));
		System.out.println(String.format("time: %s", market.getTime()));
		System.out.println(String.format("hat_s: %s", hat_s));
		System.out.println(String.format("delta: %s",delta));
		System.out.println(String.format("delta1: %s",gamma * Math.pow(sigma, 2) * delta_t));
		System.out.println(String.format("delta2: %s",2.0 / gamma * Math.log(1 + gamma / alpha)));
		System.out.println(String.format("gamma: %s",gamma));
		System.out.println(String.format("sigma: %s",sigma));
		System.out.println(String.format("delta_t: %s",delta_t));
		System.out.println(String.format("q: %s",q));
		System.out.println(String.format("p_a: %s",p_a));
		System.out.println(String.format("p_b: %s",p_b));
		//System.out.println(String.format("p_a_o: %s",p_a_order));
		//System.out.println(String.format("p_b_o: %s",p_b_order));*/

		long t = market.getTime();
		if (t <= 100){
			return orders;
		}

		int a_num = 0;
		int b_num = 0;
		for (Order oneOrder : this.current_orders){
			if (oneOrder.kind == Order.KIND_BUY_LIMIT_ORDER){
				// buyの場合
				if (oneOrder.price > p_a){
					cancelOrders.add(new Cancel(oneOrder));
				}else if (oneOrder.price == p_a_order){
					a_num += oneOrder.volume;
				}

			}else{
				// sellの場合
				if (oneOrder.price < p_b){
					cancelOrders.add(new Cancel(oneOrder));
				}else if (oneOrder.price == p_b_order){
					b_num += oneOrder.volume;
				}
			}
		}

		int volumeOnece = 1;
		int totalVolume = 10;



		if (a_num < totalVolume) {
			orders.add(new Order(Order.KIND_BUY_LIMIT_ORDER, this, market,
					p_a_order, volumeOnece, timeWindowSize));
		}
		if (b_num < totalVolume) {
			orders.add(new Order(Order.KIND_SELL_LIMIT_ORDER, this, market,
					p_b_order, volumeOnece, timeWindowSize));
		}

		this.current_orders.removeAll(cancelOrders);
		this.current_orders.addAll(orders);
		/*
		if (cancelOrders.size() > 0){
			System.out.println(">>>>>>>>>>>>>>>");
			System.out.println(cancelOrders);
		}*/

		orders.addAll(cancelOrders);
		return orders;
	}

	public double getBookStrength(Market market){
		return 1.5;
	}

	public double getVolatility(Market market){
		long t = market.getTime();
		long timeWindowSize = Math.min(t, this.timeWindowSize);
		//timeWindowSize = t;
		assert timeWindowSize >= 0 : "timeWindowSize >= 0";

		long t1 = t - timeWindowSize;
		List<Double> delta_list = new ArrayList<>();
		for (int i=0; i < timeWindowSize - 1; i++){
			delta_list.add(market.getPrice(t1 + i + 1) - market.getPrice(t1 + i));
			//delta_list.add(market.getFundamentalPrice(t1 + i + 1) - market.getFundamentalPrice(t1 + i));
		}

		if( timeWindowSize == 0 ){
			return 0.0;
		}
		//System.out.println(delta_list);

		Double mean = 0.0;
		for(int i =0; i < delta_list.size(); i++){
			mean += delta_list.get(i);
		}
		mean /= timeWindowSize;
		//System.out.println(mean);
		Double var = 0.0;
		for(int i = 0; i < delta_list.size(); i++){
			var += Math.pow((delta_list.get(i) - mean),2);
		}
		var /= timeWindowSize;
		//System.out.println(var);
		return Math.sqrt(var);
	}

	public double getFuturPrice(Market market){
		List<Order> orders = new ArrayList<Order>();
		assert  !this.isMarketAccessible(market): "Market is not accessible.";

		RandomHelper helper = new RandomHelper(random);

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

		return expectedFuturePrice;
	}
}
