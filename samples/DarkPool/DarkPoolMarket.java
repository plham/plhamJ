package samples.DarkPool;

import java.util.List;

import cassia.util.JSON;
import cassia.util.JSON.Value;
import plham.Market;
import plham.Order;
import plham.main.Simulator;
import plham.model.MarketInitializer;
import plham.util.Random;

public class DarkPoolMarket extends Market {
	private static final long serialVersionUID = 5830290220586815964L;

	/*
	public def this(id:Long, name:String, random:Random) = super(id, name, random);
	*/
	public DarkPoolMarket(long id, String name, Random random) {
		super(id, name, random);
	}

	/*
	public def setup(json:JSON.Value, sim:Simulator):DarkPoolMarket {
		assert json("markets").size() == 1;
		super.setup(json, sim);
		val lit = sim.getMarketByName(json("markets")(0));
		this.setLitMarket(lit);
		return this;
	}
	*/
	@Override
	public DarkPoolMarket setup(JSON.Value json, Simulator sim) {
		assert json.get("markets").size() == 1;
		super.setup(json, sim);
		Market lit = sim.getMarketByName(json.get("markets").asList().get(0));
		this.setLitMarket(lit);
		return this;
	}

	/*
	public static def register(sim:Simulator):void {
		val className = "DarkPoolMarket";
		sim.addMarketInitializer(className, (id:Long, name:String, random:Random, json:JSON.Value) => {
			return new DarkPoolMarket(id, name, random).setup(json, sim);
		});
	}
	*/
	public static void register(Simulator sim) {
		String className = "DarkPoolMarket";
		sim.addMarketInitializer(className, new MarketInitializer() {
			public Market initialize(long id, String name, Random random,
					Value json) {
				return new DarkPoolMarket(id, name, random).setup(json,
						sim);
			}
		});
	}

	/*
	public var litMarketId:Long;
	*/
	public long litMarketId;

	/*
	public def handleOrders(orders:List[Order]) {
		if (isRunning()) { // Accept only if market is open.
			super.handleOrders(orders);
		}
	}
	*/
	@Override
	public void handleOrders(List<Order> orders) {
		if (isRunning()) { // Accept only if market is open.
			super.handleOrders(orders);
		}
	}

	/*
	public def handleOrder(order:Order) {
		if (isRunning()) { // Accept only if market is open.
			super.handleOrder(order);
		}
	}
	*/
	@Override
	public void handleOrder(Order order) {
		if (isRunning()) { // Accept only if market is open.
			super.handleOrder(order);
		}
	}

	/*
	protected def executeBuyOrders(buyOrder:Order, sellOrder:Order) {
		assert buyOrder.getPrice() == Order.NO_PRICE : "The price must be Order.NO_PRICE"; // Check it now (easy impl)
		assert sellOrder.getPrice() == Order.NO_PRICE : "The price must be Order.NO_PRICE";
		executeOrders(roundSellPrice(getLitMidPrice()), buyOrder, sellOrder, true); // Always use the mid price.
	}
	*/
	@Override
	protected void executeBuyOrders(Order buyOrder, Order sellOrder) {
		assert buyOrder.getPrice() == Order.NO_PRICE : "The price must be Order.NO_PRICE"; // Check
																							// it
																							// now
																							// (easy
																							// impl)
		assert sellOrder.getPrice() == Order.NO_PRICE : "The price must be Order.NO_PRICE";
		executeOrders(roundSellPrice(getLitMidPrice()), buyOrder, sellOrder,
				true); // Always use the mid price.
	}

	/*
	protected def executeSellOrders(sellOrder:Order, buyOrder:Order) {
		assert buyOrder.getPrice() == Order.NO_PRICE : "The price must be Order.NO_PRICE"; // Check it now (easy impl)
		assert sellOrder.getPrice() == Order.NO_PRICE : "The price must be Order.NO_PRICE";
		executeOrders(roundBuyPrice(getLitMidPrice()), buyOrder, sellOrder, false); // Always use the mid price.
	}
	*/
	@Override
	protected void executeSellOrders(Order sellOrder, Order buyOrder) {
		assert buyOrder.getPrice() == Order.NO_PRICE : "The price must be Order.NO_PRICE"; // Check
																							// it
																							// now
																							// (easy
																							// impl)
		assert sellOrder.getPrice() == Order.NO_PRICE : "The price must be Order.NO_PRICE";
		executeOrders(roundBuyPrice(getLitMidPrice()), buyOrder, sellOrder,
				false); // Always use the mid price.
	}

	/*
	public def getLitMarket():Market = this.env.markets(this.litMarketId);
	*/

	public Market getLitMarket() {
		return this.env.markets.get((int) this.litMarketId);
	}

	/*
	public def setLitMarket(market:Market):Long = this.litMarketId = market.id;
	*/
	public void setLitMarket(Market market) {
		this.litMarketId = market.id;
	}

	/*
	public def getLitMidPrice():Double {
		val lit = getLitMarket();
		var litPrice:Double = lit.getMidPrice();
		if (litPrice.isNaN()) { // If the lit's orderbooks are empty.
			litPrice = getLitMarket().getPrice();
		}
		return litPrice;
	}
	 */
	public double getLitMidPrice() {
		Market lit = getLitMarket();
		double litPrice = lit.getMidPrice();
		if (Double.valueOf(litPrice).isNaN()) { // If the lit's orderbooks are
												// empty.
			litPrice = getLitMarket().getPrice();
		}
		return litPrice;
	}

}
