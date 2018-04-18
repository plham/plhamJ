package samples.MarketShare;

import java.util.ArrayList;
import java.util.List;

import cassia.util.JSON;
import cassia.util.JSON.Value;
import plham.Agent;
import plham.HighFrequencyAgent;
import plham.Market;
import plham.Order;
import plham.main.Simulator;
import plham.model.AgentInitializer;
import plham.util.JSONRandom;
import plham.util.Random;

public class MarketMakerAgent extends HighFrequencyAgent {
	private static final long serialVersionUID = 6851558918913913633L;
	/*
	public var targetMarketId:Long;
	public var netInterestSpread:Double;
	public var orderTimeLength:Long;
	*/
	public long targetMarketId;
	public double netInterestSpread;
	public long orderTimeLength;

	/*
	public def this(id:Long, name:String, random:Random) = super(id, name, random);
	*/

	public MarketMakerAgent(long id, String name, Random random) {
		super(id, name, random);
	}

	/*
	public def setup(json:JSON.Value, sim:Simulator):MarketMakerAgent {
		super.setup(json, sim);
		val targetMarket = sim.getMarketByName(json("targetMarket"));
		val random = new JSONRandom(this.getRandom());
		this.targetMarketId = targetMarket.id;
		this.netInterestSpread = random.nextRandom(json("netInterestSpread"));
		this.orderTimeLength = random.nextRandom(json("orderTimeLength", "2")) as Long;
		return this;
	}
	*/
	@Override
	@SuppressWarnings("hiding")
	public MarketMakerAgent setup(JSON.Value json, Simulator sim) {
		super.setup(json, sim);
		Market targetMarket = sim.getMarketByName(json.get("targetMarket"));
		JSONRandom random = new JSONRandom(this.getRandom());
		this.targetMarketId = targetMarket.id;
		this.netInterestSpread = random.nextRandom(json
				.get("netInterestSpread"));
		this.orderTimeLength = new Double(random.nextRandom(json.getOrElse(
				"orderTimeLength", "2"))).longValue();
		return this;
	}

	/*
	public static def register(sim:Simulator):void {
		val className = "MarketMakerAgent";
		sim.addAgentInitializer(className,
			(
				id:Long,
				name:String, 
				random:Random,
				json:JSON.Value
			) => {
				return new MarketMakerAgent(id, name, random).setup(json, sim);
			}
		);
	}
	*/
	public static void register(Simulator sim) {
		String className = "MarketMakerAgent";
		sim.addAgentInitializer(className, new AgentInitializer() {
			public Agent initialize(long id, String name, Random random,
					Value json) {
				return new MarketMakerAgent(id, name, random).setup(json, sim);
			}
		});
	}

	/*
	public def submitOrders(markets:List[Market]):List[Order] {
		val orders = new ArrayList[Order]();

		val target = markets(this.targetMarketId);

		var basePrice:Double = getBasePrice(markets);
		if (!isFinite(basePrice)) {
			basePrice = target.getPrice(); // Use this instead.
		}

		val priceMargin = target.getFundamentalPrice() * this.netInterestSpread * 0.5;
		val orderVolume = 1;
		orders.add(new Order(Order.KIND_BUY_LIMIT_ORDER, this, target, basePrice - priceMargin, orderVolume, this.orderTimeLength));
		orders.add(new Order(Order.KIND_SELL_LIMIT_ORDER, this, target, basePrice + priceMargin, orderVolume, this.orderTimeLength));

		return orders;
	}
	*/
	@Override
	public List<Order> submitOrders(List<Market> markets) {
		List<Order> orders = new ArrayList<Order>();

		Market target = markets.get((int) this.targetMarketId);

		double basePrice = getBasePrice(markets);
		if (!isFinite(basePrice)) {
			basePrice = target.getPrice(); // Use this instead.
		}

		double priceMargin = target.getFundamentalPrice()
				* this.netInterestSpread * 0.5;
		long orderVolume = 1;
		orders.add(new Order(Order.KIND_BUY_LIMIT_ORDER, this, target,
				basePrice - priceMargin, orderVolume, this.orderTimeLength));
		orders.add(new Order(Order.KIND_SELL_LIMIT_ORDER, this, target,
				basePrice + priceMargin, orderVolume, this.orderTimeLength));

		return orders;
	}

	/*
	// The simple market maker strategy.
	public def getBasePrice(markets:List[Market]):Double {
		var maxBuy:Double = Double.NEGATIVE_INFINITY;
		for (market in markets) {
			if (isMarketAccessible(market)) {
				maxBuy = Math.max(maxBuy, market.getBestBuyPrice());
			}
		}
		var minSell:Double = Double.POSITIVE_INFINITY;
		for (market in markets) {
			if (isMarketAccessible(market)) {
				minSell = Math.min(minSell, market.getBestSellPrice());
			}
		}
		return (maxBuy + minSell) / 2.0;
	}
	*/
	public double getBasePrice(List<Market> markets) {
		double maxBuy = Double.NEGATIVE_INFINITY;
		for (Market market : markets) {
			if (isMarketAccessible(market)) {
				maxBuy = Math.max(maxBuy, market.getBestBuyPrice());
			}
		}
		double minSell = Double.POSITIVE_INFINITY;
		for (Market market : markets) {
			if (isMarketAccessible(market)) {
				minSell = Math.min(minSell, market.getBestSellPrice());
			}
		}
		return (maxBuy + minSell) / 2.0;
	}

	/*
	public static def isFinite(x:Double) {
		return !x.isNaN() && !x.isInfinite();
	}
	*/
	public static boolean isFinite(double d) {
		Double x = Double.valueOf(d);
		return !x.isNaN() && !x.isInfinite();
	}

}
