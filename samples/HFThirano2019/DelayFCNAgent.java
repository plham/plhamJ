package samples.HFThirano2019;

import cassia.util.JSON;
import plham.Agent;
import plham.agent.FCNAgent;
import plham.Market;
import plham.Order;
import plham.main.Simulator;
import plham.model.AgentInitializer;
import plham.util.JSONRandom;
import plham.util.Random;
import plham.util.RandomHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import plham.Cancel;
import java.util.stream.Collectors;

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

public class DelayFCNAgent extends FCNAgent {
	private static final long serialVersionUID = 3210976154184567934L;

	public long orderId = 1;

	@Override
	public long nextOrderId() {
		return orderId++;
	}

	public int informationDelay=0;
	public List<Order> current_order = new ArrayList<Order>();

	public DelayFCNAgent(long id, String name, Random random) {
		super(id, name, random);
	}

	public static void register(Simulator sim) {
		String className = "DelayFCNAgent";
		sim.addAgentInitializer(className, new AgentInitializer() {
			public Agent initialize(long id, String name, Random random,
					JSON.Value json) {
				return new DelayFCNAgent(id, name, random).setup(json, sim);
			}
		});
	}

	@Override
	public DelayFCNAgent setup(JSON.Value json, Simulator sim) {
		super.setup(json, sim);
		JSONRandom jsonRandom = new JSONRandom(random);
		this.informationDelay = (int) jsonRandom.nextRandom(json.get("informationDelay"));
		return this;
	}

	@Override
	public void orderExecuted(long marketId, long orderId, double price,
							  double cashAmountDelta, long assetVolumeDelta) {
		for (Order oneOrder : this.current_order){
			if (oneOrder.orderId == orderId){
				this.current_order.remove(oneOrder);
				break;
			}
		}
	}

	public List<Order> submitOrders(Market market) {
		List<Order> orders = new ArrayList<Order>();
		List<Order> cancelOrders = new ArrayList<Order>();
		if (!this.isMarketAccessible(market)) {
			return orders;
		}

		RandomHelper helper = new RandomHelper(random);

		/*
		double fcRatio = (1.0 + this.fundamentalWeight)
				/ (1.0 + this.chartWeight);
		*/
		long t = market.getTime();

		if (t % this.informationDelay != this.id % this.informationDelay){
			return orders;
		}

		/*****************************/
		t = Math.max(0, t - this.informationDelay);

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


		int a_num = 0;
		int b_num = 0;
		for (Order oneOrder: this.current_order){
			if (oneOrder.kind == Order.KIND_BUY_LIMIT_ORDER){
				// buyの場合
				if (oneOrder.price > expectedFuturePrice){
					cancelOrders.add(new Cancel(oneOrder));
				}else{
					a_num += 1;
				}
			}else{
				// sellの場合
				if (oneOrder.price < expectedFuturePrice){
					cancelOrders.add(new Cancel(oneOrder));
				}else{
					b_num += 1;
				}
			}
		}

		this.current_order.removeAll(cancelOrders);

		int max_a_num = 0;
		int max_b_num = 0;

		List<Order> removeList = new ArrayList<Order>();
		int remove_a_num = this.current_order.stream().filter(one -> one.kind == Order.KIND_BUY_LIMIT_ORDER)
				.collect(Collectors.toList()).size() - max_a_num;
		int remove_b_num = this.current_order.stream().filter(one -> one.kind == Order.KIND_SELL_LIMIT_ORDER)
				.collect(Collectors.toList()).size() - max_b_num;
		remove_a_num = Math.max(0, remove_a_num);
		remove_b_num = Math.max(0, remove_b_num);
		List<Order> remove_a_orders = this.current_order.stream().filter(one -> one.kind == Order.KIND_BUY_LIMIT_ORDER)
				.collect(Collectors.toList()).subList(0, remove_a_num);
		List<Order> remove_b_orders = this.current_order.stream().filter(one -> one.kind == Order.KIND_SELL_LIMIT_ORDER)
				.collect(Collectors.toList()).subList(0, remove_b_num);

		this.current_order.removeAll(remove_a_orders);
		this.current_order.removeAll(remove_b_orders);
		for (Order one : remove_a_orders){
			cancelOrders.add(new Cancel(one));
		}
		for (Order one : remove_b_orders){
			cancelOrders.add(new Cancel(one));
		}

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

		this.current_order.addAll(orders);

		orders.addAll(cancelOrders);
		//System.out.println(this.current_order.size());
		//System.out.println(orders);
		/*System.out.println(cancelOrders);
		System.out.println(remove_a_orders);
		System.out.println(remove_b_orders);*/

		return orders;
	}
}
