package plham;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import plham.util.Random;
import cassia.util.JSON;
import plham.OrderBook.RemoveAllWhere;
import plham.main.Simulator;
import plham.model.ComparatorHighersFirst;
import plham.model.ComparatorLowersFirst;
import plham.model.MarketsInitializer;
import plham.util.Itayose;
import plham.util.JSONRandom;
import x10.lang.LongRange;

/**
 * The base class for markets. A continuous double auction mechanism is
 * implemented.
 *
 * <p>
 * <ul>
 * <li>Override <code>handleOrders(List[Order])</code> and
 * <code>handleOrder(Order)</code> to implement a matching mechanism.
 * <li>The price of every order will be rounded in increments of a tick size (in
 * <code>handleOrder(Order)</code>).
 * <li>Market orders never be added onto the orderbooks (in the current
 * implementation).
 * <li>Do not call <code>handleOrders(List[Order])</code> family in
 * <code>Agent#submitOrders(List[Market])</code>.
 * <li>Do not access to the fields as much as possible; Use the corresponding
 * methods if exist.
 * </ul>
 * 
 * <p>
 * On events, it currently supports four places to register.
 * <p>
 * <ul>
 * <li>beforeSimulationStep: Called once before a simulation step (once each
 * step)
 * <li>afterSimulationStep: Called once after a simulation step (once each step)
 * <li>beforeOrderHandling: Called every before handling an order (once per
 * order)
 * <li>afterOrderHandling: Called every after handling an order (once per order)
 * </ul>
 */
public class Market implements Serializable {
	private static final long serialVersionUID = -5679918172876739712L;
	/*
	public val id:Long;
	public val name:String;
	private val random:Random;
	public var _isRunning:Boolean;
	public var buyOrderBook:OrderBook;
	public var sellOrderBook:OrderBook;
	public var outstandingShares:Long;
	public var time:Time;
	public transient var env:Env;
	public var tickSize:Double; // E.g. 0.0001;  "tickSize <= 0.0" means no tick size.
	public val NO_TICKSIZE = -1.0;

	//// Historical data (public) ////
	public var marketPrices:ArrayList[Double];
	public var fundamentalPrices:ArrayList[Double];
	public var fundamentalVolatility:Double;

	//// Historical data (hidden) ////
	public transient var lastExecutedPrices:List[Double];
	public transient var sumExecutedVolumes:List[Long];
	public transient var buyOrdersCounts:List[Long];
	public transient var sellOrdersCounts:List[Long];
	public transient var executedOrdersCounts:List[Long];

	public transient var executionLogs:List[List[ExecutionLog]] = new ArrayList[List[ExecutionLog]]();
	*/

	public long id;
	public String name;
	private Random random;
	public boolean _isRunning;
	public OrderBook buyOrderBook;
	public OrderBook sellOrderBook;
	public long outstandingShares;

	public Time time;
	public transient Env env;
	public double tickSize;
	public double NO_TICKSIZE = -1.0;

	// // Historical data (public) ////
	public List<Double> marketPrices;
	public List<Double> fundamentalPrices;
	public double fundamentalVolatility;

	// // Historical data (hidden) ////
	public transient List<Double> lastExecutedPrices;
	public transient List<Long> sumExecutedVolumes;
	public transient List<Long> buyOrdersCounts;
	public transient List<Long> sellOrdersCounts;
	public transient List<Long> executedOrdersCounts;

	public transient List<List<ExecutionLog>> executionLogs = new ArrayList<List<ExecutionLog>>();

	/*
	public def getRandom():Random = this.random;
	 */
	public Random getRandom() {
		return this.random;
	}

	/*
	public static ROUND_UPPER = (price:Double, tickSize:Double) => (Math.ceil(price / tickSize)) * tickSize;
	public static ROUND_LOWER = (price:Double, tickSize:Double) => (Math.floor(price / tickSize)) * tickSize;
	 */
	public static double roundUpper(double price, double tickSize) {
		return (Math.ceil(price / tickSize)) * tickSize;
	}

	public static double roundLower(double price, double tickSize) {
		return (Math.floor(price / tickSize)) * tickSize;
	}

	/*
	public static class ExecutionLog {
		
		public var isSellMajor:Boolean;
		public var time:Long;
		public var buyAgentId:Long;
		public var sellAgentId:Long;
		public var exchangePrice:Double;
		public var exchangeVolume:Long;
	}
	*/
	public static class ExecutionLog {
		public boolean isSellMajor;
		public long time;
		public long buyAgentId;
		public long sellAgentId;
		public double exchangePrice;
		public long exchangeVolume;
	}

	/*
	public def this(id:Long, name:String, random:Random) {
		this.id = id;
		this.name = name;
		this.random = random;
		this._isRunning = true;
		this.buyOrderBook = new OrderBook(OrderBook.HIGHERS_FIRST);
		this.sellOrderBook = new OrderBook(OrderBook.LOWERS_FIRST);
		this.outstandingShares = 1;

		this.time = new Time(0);
	//		this.tick = 0;
		this.buyOrderBook.setTime(this.time);  // Share the clock.
		this.sellOrderBook.setTime(this.time); // Share the clock.
		this.env = null;
		this.tickSize = NO_TICKSIZE;

		this.marketPrices = new ArrayList[Double]();
		this.fundamentalPrices = new ArrayList[Double]();

		this.lastExecutedPrices = new ArrayList[Double]();
		this.sumExecutedVolumes = new ArrayList[Long]();
		this.buyOrdersCounts = new ArrayList[Long]();
		this.sellOrdersCounts = new ArrayList[Long]();
		this.executedOrdersCounts = new ArrayList[Long]();
		this.fundamentalVolatility = 0.0;
	}
	 */
	public Market(long id, String name, Random random) {
		this.id = id;
		this.name = name;
		this.random = random;
		this._isRunning = true;
		this.buyOrderBook = new OrderBook(new ComparatorHighersFirst());
		this.sellOrderBook = new OrderBook(new ComparatorLowersFirst());
		this.outstandingShares = 1;

		this.time = new Time(0);
		this.buyOrderBook.setTime(this.time); // Share the clock.
		this.sellOrderBook.setTime(this.time); // Share the clock.
		this.env = null;
		this.tickSize = NO_TICKSIZE;

		this.marketPrices = new ArrayList<Double>();
		this.fundamentalPrices = new ArrayList<Double>();

		this.lastExecutedPrices = new ArrayList<Double>();
		this.sumExecutedVolumes = new ArrayList<Long>();
		this.buyOrdersCounts = new ArrayList<Long>();
		this.sellOrdersCounts = new ArrayList<Long>();
		this.executedOrdersCounts = new ArrayList<Long>();
		this.fundamentalVolatility = 0.0;
	}

	public static Market create(long id, String name, Random random) {
		return new Market(id, name, random);
	}

	/*
	public def this(id:Long) {
		this(id, "default", new Random());
	}
	public def this() {
		this(-1, "default", new Random());
	}
	*/

	/*
	public def setup(json:JSON.Value, sim:Simulator):Market {
		val jsonrandom = new JSONRandom(getRandom());
		setTickSize(jsonrandom.nextRandom(json("tickSize", "-1.0"))); // " tick-size <= 0.0 means no tick size.
		setInitialMarketPrice(jsonrandom.nextRandom(json("marketPrice")));
		setInitialFundamentalPrice(jsonrandom.nextRandom(json("marketPrice")));
		setFundamentalVolatility(jsonrandom.nextRandom(json("fundamentalVolatility", "0.0")));
		setOutstandingShares(jsonrandom.nextRandom(json("outstandingShares")) as Long);
		return this;
	}
	*/
	public Market setup(JSON.Value json/*, Simulator sim */) {
		JSONRandom jsonRandom = new JSONRandom(getRandom());
		if (json.get("tickSize") == null) { // " tick-size <= 0.0 means no
											// tick size.
			setTickSize(-1.0);
		} else {
			setTickSize(jsonRandom.nextRandom(json.get("tickSize")));
		}
		setInitialMarketPrice(jsonRandom.nextRandom(json.get("marketPrice")));
		setInitialFundamentalPrice(jsonRandom.nextRandom(json
				.get("marketPrice")));
		setFundamentalVolatility(jsonRandom.nextRandom(json.getOrElse(
				"fundamentalVolatility", "0.0")));
		setOutstandingShares(new Double(jsonRandom.nextRandom(json
				.get("outstandingShares"))).longValue());		return this;
	}

	@SuppressWarnings("unused")
	public Market setup(JSON.Value json, Simulator sim) {
		return setup(json);
	}

	/*
	public static def register(sim:Simulator):void {
		val className = "Market";
		sim.addMarketsInitializer(className, (id:Long, name:String, random:Random, json:JSON.Value) => {
			val numMarkets = json.has("numMarkets") ? json("numMarkets").toLong() : 1;
			val markets = new ArrayList[Market](numMarkets) as List[Market];
			markets.add(new Market(id, name, random).setup(json, sim));
			sim.GLOBAL(markets(0).name) = markets as Any; // assuming 'numMarkets' is always set to 1.
			//TODO TKhack
			val r = new ArrayList[LongRange](); r.add(id..id);
			sim.marketName2Ranges(name)=r;
			return markets;
		});
	}
	*/
	public static void register(Simulator sim) {
		String className = "Market";
		MarketsInitializer initializers = new MarketsInitializer() {
			private static final long serialVersionUID = 2739579036719738032L;

			public List<Market> initialize(long id, String name, Random random,
					JSON.Value json) {
				long numMarkets = json.has("numMarkets") ? json.get(
						"numMarkets").toLong() : 1;
				List<Market> markets = new ArrayList<Market>((int) numMarkets);
				Market market = Market.create(id, name, random)
						.setup(json);
				markets.add(market);

				sim.GLOBAL.put(markets.get(0).name, markets);
				List<LongRange> r = new ArrayList<LongRange>();
				r.add(new LongRange(id, id));
				sim.marketName2Ranges.put(name, r);
				return markets;
			}

		};
		sim.marketInitializers.put(className, initializers);
	}

	/*
	public def handleOrders(orders:Container[Order]) {
		for (order in orders) {
			if (order.marketId == this.id) {
				this.handleOrder(order);
			}
		}
	}
	*/
	public void handleOrders(List<Order> orders) {
		for (Order order : orders) {
			if (order.marketId == this.id) {
				this.handleOrder(order);
			}
		}
	}

	/*
	public def handleOrder(order:Order) {
		assert order.marketId == this.id;
		val t = this.getTime();
		if (order.getPrice() < 0.0) {
			return;
		}
		if (order.getVolume() <= 0) {
			return;
		}

		this.roundPrice(order); // Do in the agent's place

		if (order.isCancel()) {
			if (order.isBuyOrder()) {
				this.cancelBuyOrder(order);
			}
			if (order.isSellOrder()) {
				this.cancelSellOrder(order);
			}
			return;
		}
		if (order.isBuyOrder()) {
			this.handleBuyOrder(order);
			this.buyOrdersCounts(t) += 1;
		}
		if (order.isSellOrder()) {
			this.handleSellOrder(order);
			this.sellOrdersCounts(t) += 1;
		}
	}
	*/
	public void handleOrder(Order order) {
		assert order.marketId == this.id;
		long t = this.getTime();
		if (order.getPrice() < 0.0) {
			return;
		}
		if (order.getVolume() <= 0) {
			return;
		}

		this.roundPrice(order); // Do in the agent's place

		if (order.isCancel()) {
			if (order.isBuyOrder()) {
				this.cancelBuyOrder(order);
			}
			if (order.isSellOrder()) {
				this.cancelSellOrder(order);
			}
			return;
		}
		if (order.isBuyOrder()) {
			this.handleBuyOrder(order);
			this.buyOrdersCounts.set((int) t, buyOrdersCounts.get((int) t) + 1);
		}
		if (order.isSellOrder()) {
			this.handleSellOrder(order);
			this.sellOrdersCounts.set((int) t,
					sellOrdersCounts.get((int) t) + 1);
		}
	}

	/*
	protected def cancelBuyOrder(order:Order) {
		assert order.isBuyOrder();
		this.buyOrderBook.cancel(order);
	}
	*/
	protected void cancelBuyOrder(Order order) {
		assert order.isBuyOrder();
		this.buyOrderBook.cancel(order);
	}

	/*
	protected def cancelSellOrder(order:Order) {
		assert order.isSellOrder();
		this.sellOrderBook.cancel(order);
	}
	*/
	protected void cancelSellOrder(Order order) {
		assert order.isSellOrder();
		this.sellOrderBook.cancel(order);
	}

	/*
	protected def handleBuyOrder(order:Order) {
		assert order.isBuyOrder();
		if (order.isLimitOrder()) {
			this.handleBuyLimitOrder(order);
		}
		if (order.isMarketOrder()) {
			this.handleBuyMarketOrder(order);
		}
	}
	*/
	protected void handleBuyOrder(Order order) {
		assert order.isBuyOrder();
		if (order.isLimitOrder()) {
			this.handleBuyLimitOrder(order);
		}
		if (order.isMarketOrder()) {
			this.handleBuyMarketOrder(order);
		}
	}

	/*
	protected def handleSellOrder(order:Order) {
		assert order.isSellOrder();
		if (order.isLimitOrder()) {
			this.handleSellLimitOrder(order);
		}
		if (order.isMarketOrder()) {
			this.handleSellMarketOrder(order);
		}
	}
	*/
	protected void handleSellOrder(Order order) {
		assert order.isSellOrder();
		if (order.isLimitOrder()) {
			this.handleSellLimitOrder(order);
		}
		if (order.isMarketOrder()) {
			this.handleSellMarketOrder(order);
		}
	}

	/*
	protected def handleBuyLimitOrder(buyOrder:Order) {
		assert buyOrder.isBuyOrder() && buyOrder.isLimitOrder();
		val t = this.getTime();
		if (this.isRunning()) {
			while (buyOrder.getVolume() > 0) {
				if (this.sellOrderBook.size() == 0) {
					break;
				}
				val sellOrder = this.sellOrderBook.getBestOrder();
				if (buyOrder.getPrice() >= sellOrder.getPrice()) {
					this.executeBuyOrders(buyOrder, sellOrder);
				} else {
					break;
				}
				if (sellOrder.getVolume() <= 0) {
					this.sellOrderBook.remove(sellOrder);
				}
			}
		}
		if (buyOrder.getVolume() > 0) {
			this.buyOrderBook.add(buyOrder);
		}
	}
	*/
	protected void handleBuyLimitOrder(Order buyOrder) {
		assert buyOrder.isBuyOrder() && buyOrder.isLimitOrder();
		// long t = this.getTime();
		if (this.isRunning()) {
			while (buyOrder.getVolume() > 0) {
				if (this.sellOrderBook.size() == 0) {
					break;
				}
				Order sellOrder = this.sellOrderBook.getBestOrder();
				if (buyOrder.getPrice() >= sellOrder.getPrice()) {
					this.executeBuyOrders(buyOrder, sellOrder);
				} else {
					break;
				}
				if (sellOrder.getVolume() <= 0) {
					this.sellOrderBook.remove(sellOrder);
				}
			}
		}
		if (buyOrder.getVolume() > 0) {
			this.buyOrderBook.add(buyOrder);
		}
	}

	/*
	protected def handleSellLimitOrder(sellOrder:Order) {
		assert sellOrder.isSellOrder() && sellOrder.isLimitOrder();
		val t = this.getTime();
		if (this.isRunning()) {
			while (sellOrder.getVolume() > 0) {
				if (this.buyOrderBook.size() == 0) {
					break;
				}
				val buyOrder = this.buyOrderBook.getBestOrder();
				if (buyOrder.getPrice() >= sellOrder.getPrice()) {
					this.executeSellOrders(sellOrder, buyOrder);
				} else {
					break;
				}
				if (buyOrder.getVolume() <= 0) {
					this.buyOrderBook.remove(buyOrder);
				}
			}
		}
		if (sellOrder.getVolume() > 0) {
			this.sellOrderBook.add(sellOrder);
		}
	}
	*/
	protected void handleSellLimitOrder(Order sellOrder) {
		assert sellOrder.isSellOrder() && sellOrder.isLimitOrder();
		// long t = this.getTime();
		if (this.isRunning()) {
			while (sellOrder.getVolume() > 0) {
				if (this.buyOrderBook.size() == 0) {
					break;
				}
				Order buyOrder = this.buyOrderBook.getBestOrder();
				if (buyOrder.getPrice() >= sellOrder.getPrice()) {
					this.executeSellOrders(sellOrder, buyOrder);
				} else {
					break;
				}
				if (buyOrder.getVolume() <= 0) {
					this.buyOrderBook.remove(buyOrder);
				}
			}
		}
		if (sellOrder.getVolume() > 0) {
			this.sellOrderBook.add(sellOrder);
		}
	}

	/*
	protected def handleBuyMarketOrder(buyOrder:Order) {
		assert buyOrder.isBuyOrder() && buyOrder.isMarketOrder();
		val t = this.getTime();
		if (this.isRunning()) {
			while (buyOrder.getVolume() > 0) {
				if (this.sellOrderBook.size() == 0) {
					break;
				}
				val sellOrder = this.sellOrderBook.getBestOrder();
				//if (buyOrder.getPrice() >= sellOrder.getPrice()) {
					this.executeBuyOrders(buyOrder, sellOrder);
				//} else {
				//	break;
				//}
				if (sellOrder.getVolume() <= 0) {
					this.sellOrderBook.remove(sellOrder);
				}
			}
		}
		//if (buyOrder.getVolume() > 0) {
		//	this.buyOrderBook.add(buyOrder);
		//}
	}
	*/
	protected void handleBuyMarketOrder(Order buyOrder) {
		assert buyOrder.isBuyOrder() && buyOrder.isMarketOrder();
		// long t = this.getTime();
		if (this.isRunning()) {
			while (buyOrder.getVolume() > 0) {
				if (this.sellOrderBook.size() == 0) {
					break;
				}
				Order sellOrder = this.sellOrderBook.getBestOrder();
				this.executeBuyOrders(buyOrder, sellOrder);
				if (sellOrder.getVolume() <= 0) {
					this.sellOrderBook.remove(sellOrder);
				}
			}
		}
	}

	/*
	protected def handleSellMarketOrder(sellOrder:Order) {
		assert sellOrder.isSellOrder() && sellOrder.isMarketOrder();
		val t = this.getTime();
		if (this.isRunning()) {
			while (sellOrder.getVolume() > 0) {
				if (this.buyOrderBook.size() == 0) {
					break;
				}
				val buyOrder = this.buyOrderBook.getBestOrder();
				//if (buyOrder.getPrice() >= sellOrder.getPrice()) {
					this.executeSellOrders(sellOrder, buyOrder);
				//} else {
				//	break;
				//}
				if (buyOrder.getVolume() <= 0) {
					this.buyOrderBook.remove(buyOrder);
				}
			}
		}
		//if (sellOrder.getVolume() > 0) {
		//	this.sellOrderBook.add(sellOrder);
		//}
	}
	*/
	protected void handleSellMarketOrder(Order sellOrder) {
		assert sellOrder.isSellOrder() && sellOrder.isMarketOrder();
		// long t = this.getTime();
		if (this.isRunning()) {
			while (sellOrder.getVolume() > 0) {
				if (this.buyOrderBook.size() == 0) {
					break;
				}
				Order buyOrder = this.buyOrderBook.getBestOrder();
				this.executeSellOrders(sellOrder, buyOrder);
				if (buyOrder.getVolume() <= 0) {
					this.buyOrderBook.remove(buyOrder);
				}
			}
		}
	}

	/*
	public def updateOrderBooks() {
	    val isExpired = (order:Order) => order.isExpired(this);
		val isNoVolume = (order:Order) => order.getVolume() <= 0;
		this.buyOrderBook.removeAllWhere((order:Order) => isExpired(order) || isNoVolume(order));
		this.sellOrderBook.removeAllWhere((order:Order) => isExpired(order) || isNoVolume(order));
	}
	*/
	public void updateOrderBooks() {
		final Market m = this;
		RemoveAllWhere p = new RemoveAllWhere() {
			public boolean check(Order order) {
				return order.isExpired(m) || order.getVolume() <= 0;
			}
		};
		this.buyOrderBook.removeAllWhere(p);
		this.sellOrderBook.removeAllWhere(p);
	}

	/*
	public def itayoseOrderBooks() {
		Itayose.itayose(this);
		this.updateOrderBooks();
	}
	*/
	public void itayoseOrderBooks() {
		Itayose.itayose(this);
		this.updateOrderBooks();
	}

	/*
	public def isRunning():Boolean = this._isRunning;
	*/
	public boolean isRunning() {
		return this._isRunning;
	}

	/*
	@NonEscaping
	public final def setRunning(isRunning:Boolean) = this._isRunning = isRunning;
	*/
	public void setRunning(boolean isRunning) {
		this._isRunning = isRunning;
	}

	/*
	public def getTickSize() = this.tickSize;
	*/
	public double getTickSize() {
		return this.tickSize;
	}

	/*
	@NonEscaping
	public final def setTickSize(tickSize:Double) = this.tickSize = tickSize;
	*/
	public final void setTickSize(double tickSize) {
		this.tickSize = tickSize;
	}

	/*
	public def roundPrice(order:Order):Order {
		if (this.tickSize <= 0.0) {
			return order;
		}
		if (order.getPrice() == Order.NO_PRICE) {
			return order;
		}
		if (order.isBuyOrder()) {
			order.setPrice(this.roundBuyPrice(order.getPrice()));
		}
		if (order.isSellOrder()) {
			order.setPrice(this.roundSellPrice(order.getPrice()));
		}
		return order;
	}
	*/
	public Order roundPrice(Order order) {
		if (this.tickSize <= 0.0) {
			return order;
		}
		if (order.getPrice() == Order.NO_PRICE) {
			return order;
		}
		if (order.isBuyOrder()) {
			order.setPrice(this.roundBuyPrice(order.getPrice()));
		}
		if (order.isSellOrder()) {
			order.setPrice(this.roundSellPrice(order.getPrice()));
		}
		return order;
	}

	/*
	public def roundBuyPrice(price:Double):Double = ROUND_LOWER(price, this.tickSize);
	*/
	public double roundBuyPrice(double price) {
		return roundLower(price, this.tickSize);
	}

	/*
	public def roundSellPrice(price:Double):Double = ROUND_UPPER(price, this.tickSize);
	*/
	public double roundSellPrice(double price) {
		return roundUpper(price, this.tickSize);
	}

	/*
	public def getNextMarketPrice():Double {
		val lastPrice = this.marketPrices.getLast();
		var price:Double = lastPrice;
		if (this.isRunning()) {
			if (this.executedOrdersCounts.getLast() > 0) {
				price = this.lastExecutedPrices.getLast();
			} else if (this.buyOrderBook.size() > 0 && this.sellOrderBook.size() > 0) {
				price = this.getMidPrice();
			}
		}
		return price;
	}
	*/
	public double getNextMarketPrice() {
		double lastPrice = this.marketPrices.get(marketPrices.size() - 1);
		double price = lastPrice;
		if (this.isRunning()) {
			if (this.executedOrdersCounts.get(executedOrdersCounts.size() - 1) > 0) {
				price = this.lastExecutedPrices
						.get(lastExecutedPrices.size() - 1);
			} else if (this.buyOrderBook.size() > 0
					&& this.sellOrderBook.size() > 0) {
				price = this.getMidPrice();
			}
		}
		return price;
	}

	/*
	public def tickUpdateMarketPrice() {
		val t = this.getTime();
		val price = this.getNextMarketPrice();
		this.marketPrices(t) = price;
		//this.updateOrderBooks();
	}
	*/
	public void tickUpdateMarketPrice() {
		long t = this.getTime();
		double price = this.getNextMarketPrice();
		this.marketPrices.set((int) t, price);
	}

	/*
	public def updateMarketPrice() {
		val price = this.getNextMarketPrice();
		this.updateMarketPrice(price);
	}
	*/
	public void updateMarketPrice() {
		double price = this.getNextMarketPrice();
		this.updateMarketPrice(price);
	}

	/*
	public def updateMarketPrice(price:Double) {
		assert !price.isNaN() : "!price.isNaN()";
		assert price >= 0.0 : "price >= 0.0";
		this.marketPrices.add(price);
		// FIXME: The below should not come here.
		this.buyOrdersCounts.add(0);
		this.sellOrdersCounts.add(0);
		this.executedOrdersCounts.add(0);
		this.lastExecutedPrices.add(Double.NaN);
		this.sumExecutedVolumes.add(0);
		this.executionLogs.add(new ArrayList[ExecutionLog]());
		this.agentUpdates.add(new ArrayList[AgentUpdate]());
	}
	*/
	public void updateMarketPrice(Double price) {
		assert !price.isNaN() : "!price.isNaN()";
		assert price >= 0.0 : "price >= 0.0";
		this.marketPrices.add(price);
		// FIXME: The below should not come here.
		this.buyOrdersCounts.add(0L);
		this.sellOrdersCounts.add(0L);
		this.executedOrdersCounts.add(0L);
		this.lastExecutedPrices.add(Double.NaN);
		this.sumExecutedVolumes.add(0L);
		this.executionLogs.add(new ArrayList<ExecutionLog>());
		this.agentUpdates.add(new ArrayList<AgentUpdate>());
	}

	/*
	public def updateFundamentalPrice(price:Double) {
		assert !price.isNaN() : "!price.isNaN()";
		assert price >= 0.0 : "price >= 0.0";
		this.fundamentalPrices.add(price);
	}
	*/
	public void updateFundamentalPrice(Double price) {
		assert !price.isNaN() : "!price.isNaN()";
		assert price >= 0.0 : "price >= 0.0";
		this.fundamentalPrices.add(price);
	}

	/*
	public def getNextFundamentalPrice() {
		assert this.getTime() == this.fundamentalPrices.size() - 1;
		return this.fundamentalPrices.getLast();
	}
	*/
	public double getNextFundamentalPrice() {
		assert this.getTime() == this.fundamentalPrices.size() - 1;
		return this.fundamentalPrices.get(fundamentalPrices.size() - 1);
	}

	/*
	public final def getInitialMarketPrice():Double {
		if (this.marketPrices.size() == 0) throw new NoSuchElementException();
		return this.marketPrices(0);
	}
	*/
	public final double getInitialMarketPrice() {
		if (this.marketPrices.size() == 0)
			throw new NoSuchElementException();
		return this.marketPrices.get(0);
	}

	/*
	public final def getFundamentalVolatility():Double = this.fundamentalVolatility;
	*/
	public final double getFundamentalVolatility() {
		return this.fundamentalVolatility;
	}

	/*
	@NonEscaping
	public final def setFundamentalVolatility(v:Double) {
		this.fundamentalVolatility = v;
	}
	*/
	public final void setFundamentalVolatility(double v) {
		this.fundamentalVolatility = v;
	}

	/*
	@NonEscaping
	public final def setInitialMarketPrice(price:Double) {
		assert this.marketPrices.size() == 0;
		this.marketPrices.add(price); // t = 0
		this.fundamentalPrices.add(price); // t = 0
		// FIXME: The below should not come here.
		this.buyOrdersCounts.add(0);
		this.sellOrdersCounts.add(0);
		this.executedOrdersCounts.add(0);
		this.lastExecutedPrices.add(Double.NaN);
		this.sumExecutedVolumes.add(0);
		this.executionLogs.add(new ArrayList[ExecutionLog]());
		this.agentUpdates.add(new ArrayList[AgentUpdate]());
	}
	*/
	public final void setInitialMarketPrice(double price) {
		assert this.marketPrices.size() == 0;
		this.marketPrices.add(price); // t = 0
		this.fundamentalPrices.add(price); // t = 0
		// FIXME: The below should not come here.
		this.buyOrdersCounts.add(0L);
		this.sellOrdersCounts.add(0L);
		this.executedOrdersCounts.add(0L);
		this.lastExecutedPrices.add(Double.NaN);
		this.sumExecutedVolumes.add(0L);
		this.executionLogs.add(new ArrayList<ExecutionLog>());
		this.agentUpdates.add(new ArrayList<AgentUpdate>());
	}

	/*
	public final def getInitialFundamentalPrice():Double {
		if (this.fundamentalPrices.size() == 0) throw new NoSuchElementException();
		return this.fundamentalPrices(0);
	}
	*/
	public final double getInitialFundamentalPrice() {
		if (this.fundamentalPrices.size() == 0) {
			throw new NoSuchElementException();
		}
		return this.fundamentalPrices.get(0);
	}

	/*
	@NonEscaping
	public final def setInitialFundamentalPrice(price:Double) {
		this.fundamentalPrices(0) = price;
	}
	*/
	public final void setInitialFundamentalPrice(double price) {
		this.fundamentalPrices.set(0, price);
	}

	/*
	public def getPrice() = this.getMarketPrice();
	*/
	public double getPrice() {
		return this.getMarketPrice();
	}

	/*
	public def getPrice(t:Long) = this.getMarketPrice(t);
	*/
	public double getPrice(long t) {
		return this.getMarketPrice(t);
	}

	/*
	public def getMarketPrice() = this.marketPrices(this.getTime()); //this.marketPrices.getLast();
	*/
	public double getMarketPrice() {
		return this.marketPrices.get((int) this.getTime());
	}

	/*
	public def getMarketPrice(t:Long) = this.marketPrices(t);
	*/
	public double getMarketPrice(long t) {
		return this.marketPrices.get((int) t);
	}

	/*
	public def getFundamentalPrice() = this.fundamentalPrices(this.getTime()); //this.fundamentalPrices.getLast();
	*/
	public double getFundamentalPrice() {
		return this.fundamentalPrices.get((int) this.getTime());
	}

	/*
	public def getFundamentalPrice(t:Long) = this.fundamentalPrices(t);
	*/
	public double getFundamentalPrice(long t) {
		return this.fundamentalPrices.get((int) t);
	}

	/*
	public def getBuyOrderBook() = this.buyOrderBook;
	*/
	public OrderBook getBuyOrderBook() {
		return this.buyOrderBook;
	}

	/*
	public def getSellOrderBook() = this.sellOrderBook;
	*/
	public OrderBook getSellOrderBook() {
		return this.sellOrderBook;
	}

	/*
	public def getBestBuyPrice() = this.buyOrderBook.getBestPrice();
	*/
	public double getBestBuyPrice() {
		return this.buyOrderBook.getBestPrice();
	}

	/*
	public def getBestSellPrice() = this.sellOrderBook.getBestPrice();
	*/
	public double getBestSellPrice() {
		return this.sellOrderBook.getBestPrice();
	}

	/*
	public def getMidPrice() = (this.getBestBuyPrice() + this.getBestSellPrice()) / 2.0;
	*/
	public double getMidPrice() {
		return (this.getBestBuyPrice() + this.getBestSellPrice()) / 2.0;
	}

	/*
	public def getOutstandingShares():Long = this.outstandingShares;
	*/
	public long getOutstandingShares() {
		return this.outstandingShares;
	}

	/*
	@NonEscaping
	public final def setOutstandingShares(outstandingShares:Long) = this.outstandingShares = outstandingShares;
	*/
	public void setOutstandingShares(long outstandingShares) {
		this.outstandingShares = outstandingShares;
	}

	/*
	public def getTime() = this.time.t;
	*/
	public long getTime() {
		return this.time.t;
	}

	/*
	public def setTime(time:Long) = this.time.t = time;
	*/
	public void setTime(long time) {
		this.time.t = time;
	}

	/*
	public def updateTime() = this.time.t++; // Call this explicitly!
	*/
	public void updateTime() {
		this.time.t++; // Call this explicitly!
	}

	/*
	public def check() {
		val t = this.getTime();
		assert this.marketPrices.size() - 1 == t;
		assert this.fundamentalPrices.size() - 1 == t;
		assert this.lastExecutedPrices.size() - 1 == t;
		assert this.sumExecutedVolumes.size() - 1 == t;
		assert this.buyOrdersCounts.size() - 1 == t;
		assert this.sellOrdersCounts.size() - 1 == t;
		assert this.executedOrdersCounts.size() - 1 == t;
		assert this.executionLogs.size() - 1 == t;
		assert this.agentUpdates.size() - 1 == t;
		Console.OUT.println("#MARKET CHECK PASSED");
	}
	*/
	public void check() {
		long t = this.getTime();
		assert this.marketPrices.size() - 1 == t;
		assert this.fundamentalPrices.size() - 1 == t;
		assert this.lastExecutedPrices.size() - 1 == t;
		assert this.sumExecutedVolumes.size() - 1 == t;
		assert this.buyOrdersCounts.size() - 1 == t;
		assert this.sellOrdersCounts.size() - 1 == t;
		assert this.executedOrdersCounts.size() - 1 == t;
		assert this.executionLogs.size() - 1 == t;
		assert this.agentUpdates.size() - 1 == t;
		System.out.println("#MARKET CHECK PASSED");
	}

	/*
	protected def executeBuyOrders(buyOrder:Order, sellOrder:Order) {
		this.executeOrders(sellOrder.getPrice(), buyOrder, sellOrder, true); // If a buy order, use the best sell price.
	}
	*/
	protected void executeBuyOrders(Order buyOrder, Order sellOrder) {
		this.executeOrders(sellOrder.getPrice(), buyOrder, sellOrder, true);
	}

	/*
	protected def executeSellOrders(sellOrder:Order, buyOrder:Order) {
		this.executeOrders(buyOrder.getPrice(), buyOrder, sellOrder, false); // If a sell order, use the best buy price.
	}
	*/
	protected void executeSellOrders(Order sellOrder, Order buyOrder) {
		this.executeOrders(buyOrder.getPrice(), buyOrder, sellOrder, false);
	}

	/*
	protected def executeOrders(price:Double, buyOrder:Order, sellOrder:Order, isSellMajor:Boolean) {
		assert buyOrder.marketId == this.id;
		assert sellOrder.marketId == this.id;

		val exchangePrice = price;
		val exchangeVolume = Math.min(buyOrder.getVolume(), sellOrder.getVolume());
		assert exchangePrice >= 0.0 : ["Market#executeOrders(), " + (isSellMajor ? "sell major" : "buy major") + ": exchangePrice >= 0.0 but ", exchangePrice];
		assert exchangeVolume >= 0  : ["Market#executeOrders(), " + (isSellMajor ? "sell major" : "buy major") + ": exchangeVolume >= 0  but ", exchangeVolume];

		val cashAmountDelta = exchangePrice * exchangeVolume;
		val assetVolumeDelta = exchangeVolume;

		val t = this.getTime();

		val buyUpdate = new AgentUpdate();
		buyUpdate.agentId = buyOrder.agentId;
		buyUpdate.marketId = buyOrder.marketId;
		buyUpdate.orderId = buyOrder.orderId;
		buyUpdate.price = exchangePrice;
		buyUpdate.cashAmountDelta = -cashAmountDelta;   // A buyer pays cash
		buyUpdate.assetVolumeDelta = +assetVolumeDelta; // and gets stocks
		this.handleAgentUpdate(buyUpdate);

		val sellUpdate = new AgentUpdate();
		sellUpdate.agentId = sellOrder.agentId;
		sellUpdate.marketId = sellOrder.marketId;
		sellUpdate.orderId = sellOrder.orderId;
		sellUpdate.price = exchangePrice;
		sellUpdate.cashAmountDelta = +cashAmountDelta;   // A seller gets cash
		sellUpdate.assetVolumeDelta = -assetVolumeDelta; // and gives stocks
		this.handleAgentUpdate(sellUpdate);

		val EXECUTION_LOG = false;
		if (EXECUTION_LOG) {
			val log = new ExecutionLog();
			log.isSellMajor = isSellMajor;
			log.time = t;
			log.buyAgentId = buyOrder.agentId;
			log.sellAgentId = sellOrder.agentId;
			log.exchangePrice = exchangePrice;
			log.exchangeVolume = exchangeVolume;
			this.executionLogs(t).add(log);
		}

		buyOrder.updateVolume(-exchangeVolume);
		sellOrder.updateVolume(-exchangeVolume);

		this.executedOrdersCounts(t) += 1;
		this.lastExecutedPrices(t) = exchangePrice;
		this.sumExecutedVolumes(t) = sumExecutedVolumes(t) + exchangeVolume;

		val DEBUG = false;
		if (DEBUG) {
			Console.OUT.println("exchangePrice: " + exchangePrice);
			Console.OUT.println("exchangeVolume: " + exchangeVolume);
			Console.OUT.println("buyOrder.getVolume(): " + buyOrder.getVolume());
			Console.OUT.println("sellOrder.getVolume(): " + sellOrder.getVolume());
		}
	}
	*/
	protected void executeOrders(double price, Order buyOrder, Order sellOrder,
			boolean isSellMajor) {
		assert buyOrder.marketId == this.id;
		assert sellOrder.marketId == this.id;

		double exchangePrice = price;
		long exchangeVolume = Math.min(buyOrder.getVolume(),
				sellOrder.getVolume());
		assert exchangePrice >= 0.0;
		assert exchangeVolume >= 0;

		double cashAmountDelta = exchangePrice * exchangeVolume;
		long assetVolumeDelta = exchangeVolume;

		long t = this.getTime();

		AgentUpdate buyUpdate = new AgentUpdate();
		buyUpdate.agentId = buyOrder.agentId;
		buyUpdate.marketId = buyOrder.marketId;
		buyUpdate.orderId = buyOrder.orderId;
		buyUpdate.price = exchangePrice;
		buyUpdate.cashAmountDelta = -cashAmountDelta; // A buyer pays cash
		buyUpdate.assetVolumeDelta = +assetVolumeDelta; // and gets stocks
		this.handleAgentUpdate(buyUpdate);

		AgentUpdate sellUpdate = new AgentUpdate();
		sellUpdate.agentId = sellOrder.agentId;
		sellUpdate.marketId = sellOrder.marketId;
		sellUpdate.orderId = sellOrder.orderId;
		sellUpdate.price = exchangePrice;
		sellUpdate.cashAmountDelta = +cashAmountDelta; // A seller gets cash
		sellUpdate.assetVolumeDelta = -assetVolumeDelta; // and gives stocks
		this.handleAgentUpdate(sellUpdate);

		boolean EXECUTION_LOG = false;
		if (EXECUTION_LOG) {
			ExecutionLog log = new ExecutionLog();
			log.isSellMajor = isSellMajor;
			log.time = t;
			log.buyAgentId = buyOrder.agentId;
			log.sellAgentId = sellOrder.agentId;
			log.exchangePrice = exchangePrice;
			log.exchangeVolume = exchangeVolume;
			this.executionLogs.get((int) t).add(log);
		}

		buyOrder.updateVolume(-exchangeVolume);
		sellOrder.updateVolume(-exchangeVolume);

		this.executedOrdersCounts.set((int) t,
				this.executedOrdersCounts.get((int) t) + 1);
		this.lastExecutedPrices.set((int) t, exchangePrice);
		this.sumExecutedVolumes.set((int) t, sumExecutedVolumes.get((int) t)
				+ exchangeVolume);

		boolean DEBUG = false;
		if (DEBUG) {
			// do nothing
		}
	}

	/*
	public def getTradeVolume():Long = getTradeVolume(this.getTime());
	*/
	public long getTradeVolume() {
		return getTradeVolume(this.getTime());
	}

	/*
	public def getTradeVolume(t:Long):Long = this.sumExecutedVolumes(t);
	*/
	public long getTradeVolume(long t) {
		return this.sumExecutedVolumes.get((int) t);
	}

	/*
	public def setTradeVolume(t:Long, tradeVolume:Long):Long = this.sumExecutedVolumes(t) = tradeVolume;
	*/
	public void setTradeVolume(long t, long tradeVolume) {
		this.sumExecutedVolumes.set((int) t, tradeVolume);
	}

	/*
	public static class AgentUpdate {
		public var agentId:Long;
		public var marketId:Long;
		public var orderId:Long;
		public var price:Double;
		public var cashAmountDelta:Double;
		public var assetVolumeDelta:Long;

		public def isBuySide():Boolean = this.assetVolumeDelta > 0;
		public def isSellSide():Boolean = this.assetVolumeDelta < 0;
	}
	*/
	public static class AgentUpdate {
		public long agentId;
		public long marketId;
		public long orderId;
		public double price;
		public double cashAmountDelta;
		public long assetVolumeDelta;

		public boolean isBuySide() {
			return this.assetVolumeDelta > 0;
		}

		public boolean isSellSide() {
			return this.assetVolumeDelta < 0;
		}
	}

	/*
	public transient var agentUpdates:List[List[AgentUpdate]] = new ArrayList[List[AgentUpdate]]();
	*/
	public transient List<List<AgentUpdate>> agentUpdates = new ArrayList<List<AgentUpdate>>();

	/*
	public def handleAgentUpdate(update:AgentUpdate) {
		val t = this.getTime();
		try {
		    this.executeAgentUpdate(this.env.agents, update); // Process
		} catch (e:IndexOutOfBoundsException) {
		    this.agentUpdates(t).add(update); // Keep
		}
	}
	*/
	public void handleAgentUpdate(AgentUpdate update) {
		long t = this.getTime();
		try {
			this.executeAgentUpdate(this.env.agents, update); // Process
		} catch (IndexOutOfBoundsException e) {
			this.agentUpdates.get((int) t).add(update); // Keep
		}
	}

	/*
	public def executeAgentUpdate(agents:Indexed[Agent], update:AgentUpdate) {
		val id = update.agentId;
		val agent = agents(id);
		if (agent != null) {
		    agent.executeUpdate(update);
		}
	}
	*/
	@SuppressWarnings({ "static-method", "hiding" })
	public void executeAgentUpdate(List<Agent> agents, AgentUpdate update) {
		long id = update.agentId;
		Agent agent = agents.get((int) id);
		if (agent != null) {
			agent.executeUpdate(update);
		}
	}

	/*
	public static interface MarketEvent extends Event {
		public def update(market:Market):void;
	}
	*/
	public static interface MarketEvent extends Event {
		public void update(Market market);
	}

	/*
	public static interface OrderEvent extends Event {
		public def update(market:Market, order:Order):void;
	}
	*/
	public static interface OrderEvent extends Event {
		public void update(Market market, Order order);
	}

	/*
	public var beforeOrderHandlingEvents:List[OrderEvent] = new ArrayList[OrderEvent]();
	*/
	public List<OrderEvent> beforeOrderHandlingEvents = new ArrayList<OrderEvent>();

	/*
	public var afterOrderHandlingEvents:List[OrderEvent] = new ArrayList[OrderEvent]();
	*/
	public List<OrderEvent> afterOrderHandlingEvents = new ArrayList<OrderEvent>();

	/*
	public var beforeSimulationStepEvents:List[MarketEvent] = new ArrayList[MarketEvent]();
	*/
	public List<MarketEvent> beforeSimulationStepEvents = new ArrayList<MarketEvent>();

	/*
	public var afterSimulationStepEvents:List[MarketEvent] = new ArrayList[MarketEvent]();
	*/
	public List<MarketEvent> afterSimulationStepEvents = new ArrayList<MarketEvent>();

	/*
	public def addBeforeOrderHandlingEvent(e:OrderEvent) = this.beforeOrderHandlingEvents.add(e);
	*/
	public void addBeforeOrderHandlingEvent(OrderEvent e) {
		this.beforeOrderHandlingEvents.add(e);
	}

	/*
	public def addAfterOrderHandlingEvent(e:OrderEvent) = this.afterOrderHandlingEvents.add(e);
	*/
	public void addAfterOrderHandlingEvent(OrderEvent e) {
		this.afterOrderHandlingEvents.add(e);
	}

	/*
	public def addBeforeSimulationStepEvent(e:MarketEvent) = this.beforeSimulationStepEvents.add(e);
	*/
	public void addBeforeSimulationStepEvent(MarketEvent e) {
		this.beforeSimulationStepEvents.add(e);
	}

	/*
	public def addAfterSimulationStepEvent(e:MarketEvent) = this.afterSimulationStepEvents.add(e);
	*/
	public void addAfterSimulationStepEvent(MarketEvent e) {
		this.afterSimulationStepEvents.add(e);
	}

	/*
	public def triggerBeforeOrderHandlingEvents(order:Order) {
		for (e in this.beforeOrderHandlingEvents) {
			e.update(this, order);
		}
	}
	*/
	public void triggerBeforeOrderHandlingEvents(Order order) {
		for (OrderEvent e : this.beforeOrderHandlingEvents) {
			e.update(this, order);
		}
	}

	/*
	public def triggerAfterOrderHandlingEvents(order:Order) {
		for (e in this.afterOrderHandlingEvents) {
			e.update(this, order);
		}
	}
	*/
	public void triggerAfterOrderHandlingEvents(Order order) {
		for (OrderEvent e : this.afterOrderHandlingEvents) {
			e.update(this, order);
		}
	}

	/*
	public def triggerBeforeSimulationStepEvents() {
		for (e in this.beforeSimulationStepEvents) {
			e.update(this);
		}
	}
	*/
	public void triggerBeforeSimulationStepEvents() {
		for (MarketEvent e : this.beforeSimulationStepEvents) {
			e.update(this);
		}
	}

	/*
	public void triggerAfterSimulationStepEvents() {
		for (e in this.afterSimulationStepEvents) {
			e.update(this);
		}
	}
	*/

	public void triggerAfterSimulationStepEvents() {
		for (MarketEvent e : this.afterSimulationStepEvents) {
			e.update(this);
		}
	}

}
