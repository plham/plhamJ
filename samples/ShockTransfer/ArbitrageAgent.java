package samples.ShockTransfer;

import java.util.ArrayList;
import java.util.List;

import cassia.util.JSON;
import cassia.util.JSON.Value;
import plham.Agent;
import plham.HighFrequencyAgent;
import plham.IndexMarket;
import plham.Market;
import plham.Order;
import plham.main.Simulator;
import plham.model.AgentsInitializer;
import plham.util.JSONRandom;
import plham.util.Random;
import x10.lang.LongRange;

public class ArbitrageAgent extends HighFrequencyAgent {
	private static final long serialVersionUID = -7905166019557169688L;

	/*
	public var orderVolume:Long;
	public var orderThresholdPrice:Double;
	public var orderTimeLength:Long;
	*/
	public long orderVolume;
	public double orderThresholdPrice;
	public long orderTimeLength;

	/*
	public def this(id:Long, name:String, random:Random) {
		super(id, name, random);
		this.orderVolume = 1;
		this.orderThresholdPrice = 0.0;
		this.orderTimeLength = 2; // An order's lifetime; no rationale.
	}
	*/
	public ArbitrageAgent(long id, String name, Random random) {
		super(id, name, random);
	}

	/*
	public def this() {
		this(-1, "default", new Random());
	}
	*/
	public ArbitrageAgent() {
		super(-1, "default", new Random());
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
		if (!(market instanceof IndexMarket)) {
			return orders;
		}
		if (!this.isMarketAccessible(market)) {
			return orders;
		}

		val index = market as IndexMarket;
		val spots = index.getMarkets();
		if (!index.isRunning() || !index.isAllMarketsRunning()) {
			return orders; // Stop thinking.
		}

		val marketIndex = index.getIndex();
		val marketPrice = index.getPrice();

		if (marketPrice < marketIndex && marketIndex - marketPrice > this.orderThresholdPrice) {
			val n = this.orderVolume;
			val N = spots.size() * n;

			orders.add(new Order(Order.KIND_BUY_LIMIT_ORDER, this, index, index.getPrice(), N, this.orderTimeLength));
			for (m in spots) {
				orders.add(new Order(Order.KIND_SELL_LIMIT_ORDER, this, m, m.getPrice(), n, this.orderTimeLength));
			}
		}
		if (marketPrice > marketIndex && marketPrice - marketIndex > this.orderThresholdPrice) {
			val n = this.orderVolume;
			val N = spots.size() * n;

			orders.add(new Order(Order.KIND_SELL_LIMIT_ORDER, this, index, index.getPrice(), N, this.orderTimeLength));
			for (m in spots) {
				orders.add(new Order(Order.KIND_BUY_LIMIT_ORDER, this, m, m.getPrice(), n, this.orderTimeLength));
			}
		}
		return orders;
	}
	*/
	public List<Order> submitOrders(Market market) {
		List<Order> orders = new ArrayList<Order>();
		if (!(market instanceof IndexMarket)) {
			return orders;
		}
		if (!this.isMarketAccessible(market)) {
			return orders;
		}

		IndexMarket index = (IndexMarket) market;
		List<Market> spots = index.getMarkets();
		if (!index.isRunning() || !index.isAllMarketsRunning()) {
			return orders; // Stop thinking.
		}

		double marketIndex = index.getIndex();
		double marketPrice = index.getPrice();

		if (marketPrice < marketIndex
				&& marketIndex - marketPrice > this.orderThresholdPrice) {
			long n = this.orderVolume;
			long N = spots.size() * n;

			orders.add(new Order(Order.KIND_BUY_LIMIT_ORDER, this, index, index
					.getPrice(), N, this.orderTimeLength));
			for (Market m : spots) {
				orders.add(new Order(Order.KIND_SELL_LIMIT_ORDER, this, m, m
						.getPrice(), n, this.orderTimeLength));
			}
		}
		if (marketPrice > marketIndex
				&& marketPrice - marketIndex > this.orderThresholdPrice) {
			long n = this.orderVolume;
			long N = spots.size() * n;

			orders.add(new Order(Order.KIND_SELL_LIMIT_ORDER, this, index,
					index.getPrice(), N, this.orderTimeLength));
			for (Market m : spots) {
				orders.add(new Order(Order.KIND_BUY_LIMIT_ORDER, this, m, m
						.getPrice(), n, this.orderTimeLength));
			}
		}
		return orders;
	}

	/*
		public def setupArbitrageAgent(json:JSON.Value, sim:Simulator) {
			val random = new JSONRandom(getRandom());
			this.orderVolume = json("orderVolume").toLong();
			this.orderThresholdPrice = json("orderThresholdPrice").toDouble();
	
			assert json("markets").size() == 1 : "ArbitrageAgents suppose only one IndexMarket";
			assert sim.getMarketByName(json("markets")(0)) instanceof IndexMarket : "ArbitrageAgents suppose only one IndexMarket";
			val market = sim.getMarketByName(json("markets")(0)) as IndexMarket;
			this.setMarketAccessible(market);
			for (id in market.getComponents()) {
			this.setMarketAccessible(id);
			}
	
			this.setAssetVolume(market, random.nextRandom(json("assetVolume")) as Long);
			for (id in market.getComponents()) {
			this.setAssetVolume(id, random.nextRandom(json("assetVolume")) as Long);
			}
			this.setCashAmount(random.nextRandom(json("cashAmount")));
			return this;
		}
	*/
	@SuppressWarnings("hiding")
	public ArbitrageAgent setupArbitrageAgent(JSON.Value json, Simulator sim) {
		JSONRandom random = new JSONRandom(getRandom());
		this.orderVolume = json.get("orderVolume").toLong();
		this.orderThresholdPrice = json.get("orderThresholdPrice").toDouble();

		assert json.get("markets").size() == 1 : "ArbitrageAgents suppose only one IndexMarket";
		assert sim.getMarketByName(json.get("markets").get(0)) instanceof IndexMarket : "ArbitrageAgents suppose only one IndexMarket";
		IndexMarket market = (IndexMarket) sim.getMarketByName(json.get(
				"markets").get(0));
		this.setMarketAccessible(market);
		for (long id : market.getComponents()) {
			this.setMarketAccessible(id);
		}

		this.setAssetVolume(market,
				Double.valueOf(random.nextRandom(json.get("assetVolume")))
						.longValue());
		for (long id : market.getComponents()) {
			this.setAssetVolume(id,
					Double.valueOf(random.nextRandom(json.get("assetVolume")))
							.longValue());
		}
		this.setCashAmount(random.nextRandom(json.get("cashAmount")));
		return this;
	}

	/*
	public static def register(sim:Simulator):void {
		val className = "ArbitrageAgent";
		sim.addAgentsInitializer(className, (name:String, randoms:Indexed[Random], range:LongRange, json:JSON.Value, container:Settable[Long, Agent]) => {
			for (i in range) {
				container(i) = createArbitrageAgent(i, name, randoms(i), json, sim);
			}
			Console.OUT.println("# " + json("class").toString() + " : " + JSON.dump(json));
		});
	}
	*/
	public static void register(Simulator sim) {
		String className = "ArbitrageAgent";
		sim.addAgentsInitializer(className, new AgentsInitializer() {
			private static final long serialVersionUID = 5236188032328962062L;

			public void initialize(String name, List<Random> randoms,
					LongRange range, Value json, List<Agent> agents) {
				for (long i = range.min; i <= range.max; i++) {
					agents.set(
							(int) i,
							createArbitrageAgent(i, name, randoms.get((int) i),
									json, sim));
				}
				System.out.println("# " + json.get("class").toString() + " : "
						+ JSON.dump(json));
			}
		});
	}

	/*
	public static def createArbitrageAgent(id:Long, name:String, random:Random, json:JSON.Value, sim:Simulator):ArbitrageAgent {
		return new ArbitrageAgent(id, name, random).setupArbitrageAgent(json, sim);
	}
	*/
	public static ArbitrageAgent createArbitrageAgent(long id, String name,
			Random random, JSON.Value json, Simulator sim) {
		return new ArbitrageAgent(id, name, random).setupArbitrageAgent(json,
				sim);
	}

}
