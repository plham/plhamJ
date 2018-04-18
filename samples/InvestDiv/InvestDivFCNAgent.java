package samples.InvestDiv;

import java.util.ArrayList;
import java.util.List;

import cassia.util.JSON;
import cassia.util.JSON.Value;
import plham.Agent;
import plham.Market;
import plham.Order;
import plham.agent.FCNAgent;
import plham.main.Simulator;
import plham.model.AgentInitializer;
import plham.util.Random;

/** The regulation for investment diversification. */
public class InvestDivFCNAgent extends FCNAgent {
	private static final long serialVersionUID = 289665027568836431L;

	/*
	public var leverageRatio:Double;
	public var diversityRatio:Double;
	*/
	public double leverageRatio;
	public double diversityRatio;

	/*
	public def this(id:Long, name:String, random:Random) = super(id, name, random);
	*/
	public InvestDivFCNAgent(long id, String name, Random random) {
		super(id, name, random);
	}

	/*
	public def setup(json:JSON.Value, sim:Simulator):InvestDivFCNAgent {
		super.setup(json, sim);
		this.leverageRatio = json("leverageRatio").toDouble();
		this.diversityRatio = json("diversityRatio").toDouble();
		return this;
	}
	*/
	@Override
	public InvestDivFCNAgent setup(JSON.Value json, Simulator sim) {
		super.setup(json, sim);
		this.leverageRatio = json.get("leverageRatio").toDouble();
		this.diversityRatio = json.get("diversityRatio").toDouble();
		return this;
	}

	/*
	public static def register(sim:Simulator) {
		val className = "InvestDivFCNAgent";
		sim.addAgentInitializer(className,
			(
				id:Long,
				name:String, 
				random:Random,
				json:JSON.Value
			) => {
				return new InvestDivFCNAgent(id, name, random).setup(json, sim);
			}
		);
	}
	*/
	public static void register(Simulator sim) {
		String className = "InvestDivFCNAgent";
		sim.addAgentInitializer(className, new AgentInitializer() {
			public Agent initialize(long id, String name, Random random,
					Value json) {
				return new InvestDivFCNAgent(id, name, random).setup(json,
						sim);
			}
		});
	}

	/*
	public def filterMarkets(markets:Indexed[Market]):List[Market] {
		val a = new ArrayList[Market]();
		for (market in markets) {
			if (this.isMarketAccessible(market)) {
				a.add(market);
			}
		}
		return a;
	}
	*/
	public List<Market> filterMarkets(List<Market> markets) {
		List<Market> a = new ArrayList<Market>();
		for (Market market : markets) {
			if (this.isMarketAccessible(market)) {
				a.add(market);
			}
		}
		return a;
	}

	/*
	public def getAssetValue(market:Market):Double {
		return market.getPrice() * getAssetVolume(market);
	}
	*/
	public double getAssetValue(Market market) {
		return market.getPrice() * getAssetVolume(market);
	}

	/*
	public def submitOrders(markets:Indexed[Market]):List[Order] {
		val leverageRatio = 1.0;
		val m = filterMarkets(markets);
		var nav:Double = getCashAmount(); // netAssetValue
		var tavAbs:Double = 0.0; // totalAssetValueAbs
		for (market in m) {
			val av = getAssetValue(market);
			nav += av;
			tavAbs += Math.abs(av);
		}

		val orders = new ArrayList[Order]();

		if (tavAbs > leverageRatio * nav) {
			return orders;
		}

		val temp = super.submitOrders(m);
		for (order in temp) {
			val id = order.marketId;
			val market = markets(id);
			assert market.id == id;

			val avAbs = Math.abs(getAssetValue(market));
			if (avAbs <= diversityRatio * nav) {
				orders.add(order);
			} else {
				val timeLength = 10; // No effect (any value > 0 okay)
				val orderPrice = Order.NO_PRICE;
				val orderVolume = 1; // No optimization
				if (getAssetVolume(market) < 0) {
					orders.add(new Order(Order.KIND_BUY_MARKET_ORDER, this, market, orderPrice, orderVolume, timeLength));
				}
				if (getAssetVolume(market) > 0) {
					orders.add(new Order(Order.KIND_SELL_MARKET_ORDER, this, market, orderPrice, orderVolume, timeLength));
				}
			}
		}
		return orders;
	}
	*/
	@Override
	@SuppressWarnings("hiding")
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

		List<Order> orders = new ArrayList<Order>();

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
					orders.add(new Order(Order.KIND_BUY_MARKET_ORDER, this,
							market, orderPrice, orderVolume, timeLength));
				}
				if (getAssetVolume(market) > 0) {
					orders.add(new Order(Order.KIND_SELL_MARKET_ORDER, this,
							market, orderPrice, orderVolume, timeLength));
				}
			}
		}
		return orders;
	}
}
