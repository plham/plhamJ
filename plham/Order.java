package plham;

import java.io.Serializable;

/**
 * A data structure for orders.
 * 
 * <p>
 * Specify
 * <ul>
 * <li>Type (kind): {buy, sell} x {limit, market}
 * <li>Price
 * <li>Volume
 * <li>Expiry time (relative)
 * </ul>
 */

public class Order implements Serializable {
	private static final long serialVersionUID = -2789404032919261695L;

	/*
	static struct Kind(id:long) {}
	public static KIND_BUY_MARKET_ORDER = Kind(1);
	public static KIND_SELL_MARKET_ORDER = Kind(2);
	public static KIND_BUY_LIMIT_ORDER = Kind(3);
	public static KIND_SELL_LIMIT_ORDER = Kind(4);

	public static NO_PRICE = double.MAX_VALUE;
	
	public var kind:Kind;
	public var agentId:long;
	public var marketId:long;
	public var price:double;
	public var volume:long;
	public var timeLength:long;
	public var timePlaced:long;
	public var orderId:long;
	*/
	public static final long KIND_BUY_MARKET_ORDER = 1L;
	public static final long KIND_SELL_MARKET_ORDER = 2L;
	public static final long KIND_BUY_LIMIT_ORDER = 3L;
	public static final long KIND_SELL_LIMIT_ORDER = 4L;

	public static double NO_PRICE = Double.MAX_VALUE;

	public long kind;
	public long agentId;
	public long marketId;
	public double price;
	public long volume;
	public long timeLength;
	public long timePlaced;
	public long orderId;

	/*
	public def this(kind:Kind, agentId:long, marketId:long, price:double, volume:long, timeLength:long, timePlaced:long, orderId:long) {
		assert price >= 0.0 : "price >= 0.0";
		assert volume >= 0 : "volume >= 0";
		this.kind = kind;
		this.agentId = agentId;
		this.marketId = marketId;
		this.price = price;
		this.volume = volume;
		this.timeLength = timeLength;
		this.timePlaced = timePlaced;
		this.orderId = orderId;
	}
	*/
	public Order(long kind, long agentId, long marketId, double price,
			long volume, long timeLength, long timePlaced, long orderId) {
		assert volume >= 0 : "volume >= 0";
		this.kind = kind;
		this.agentId = agentId;
		this.marketId = marketId;
		this.volume = volume;
		this.timeLength = timeLength;
		this.timePlaced = timePlaced;
		this.orderId = orderId;
		if (this.kind == KIND_BUY_MARKET_ORDER || this.kind == KIND_SELL_MARKET_ORDER) {
			this.price = Double.NaN;
		} else {
			assert price >= 0.0 : "price >= 0.0";
			this.price = price;
		}
	}

	/*
	public def this(kind:Kind, agentId:long, marketId:long, price:double, volume:long, timeLength:long, timePlaced:long) {
		this(kind, agentId, marketId, price, volume, timeLength, timePlaced, 0);
	}
	*/

	public Order(long kind, long agentId, long marketId, double price,
			long volume, long timeLength, long timePlaced) {
		this(kind, agentId, marketId, price, volume, timeLength, timePlaced, 0);
	}

	/*
	public def this(kind:Kind, agent:Agent, market:Market, price:double, volume:long, timeLength:long) {
		this(kind, agent.id, market.id, price, volume, timeLength, market.getTime(), agent.nextOrderId());
	}
	*/
	public Order(long kind, Agent agent, Market market, double price,
			long volume, long timeLength) {
		this(kind, agent.id, market.id, price, volume, timeLength, market
				.getTime(), agent.nextOrderId());
	}

	/*
	public def this(other:Order) {
		this.kind = other.kind;
		this.agentId = other.agentId;
		this.marketId = other.marketId;
		this.price = other.price;
		this.volume = other.volume;
		this.timeLength = other.timeLength;
		this.timePlaced = other.timePlaced;
		this.orderId = other.orderId;
	}
	*/
	public Order(Order other) {
		this.kind = other.kind;
		this.agentId = other.agentId;
		this.marketId = other.marketId;
		this.price = other.price;
		this.volume = other.volume;
		this.timeLength = other.timeLength;
		this.timePlaced = other.timePlaced;
		this.orderId = other.orderId;
	}

	/*
	public def getPrice():double = this.price;
	*/
	public double getPrice() {
		return this.price;
	}

	/*
	public def setPrice(price:double):double = this.price = price;
	*/
	public double setPrice(double price) {
		return this.price = price;
	}

	/*
	public def getVolume():long = this.volume;
	*/
	public long getVolume() {
		return this.volume;
	}

	/*
	public def setVolume(volume:long):long = this.volume = volume;
	*/
	public void setVolume(long volume) {
		this.volume = volume;
	}

	/*
	public def updateVolume(delta:long) {
		this.volume += delta;
		assert this.volume >= 0;
	}
	*/
	public void updateVolume(long delta) {
		this.volume += delta;
		assert this.volume >= 0;
	}

	/*
	public def isBuyOrder():Boolean {
		return this.kind == Order.KIND_BUY_MARKET_ORDER || this.kind == Order.KIND_BUY_LIMIT_ORDER;
	}
	*/

	public Boolean isBuyOrder() {
		return this.kind == Order.KIND_BUY_MARKET_ORDER
				|| this.kind == Order.KIND_BUY_LIMIT_ORDER;
	}

	/*
	public def isSellOrder():Boolean {
		return this.kind == Order.KIND_SELL_MARKET_ORDER || this.kind == Order.KIND_SELL_LIMIT_ORDER;
	}
	*/

	public Boolean isSellOrder() {
		return this.kind == Order.KIND_SELL_MARKET_ORDER
				|| this.kind == Order.KIND_SELL_LIMIT_ORDER;
	}

	/*
	public def isLimitOrder():Boolean {
		return this.kind == Order.KIND_BUY_LIMIT_ORDER || this.kind == Order.KIND_SELL_LIMIT_ORDER;
	}
	*/

	public Boolean isLimitOrder() {
		return this.kind == Order.KIND_BUY_LIMIT_ORDER
				|| this.kind == Order.KIND_SELL_LIMIT_ORDER;
	}

	/*
	public def isMarketOrder():Boolean {
		return this.kind == Order.KIND_BUY_MARKET_ORDER || this.kind == Order.KIND_SELL_MARKET_ORDER;
	}
	*/

	public Boolean isMarketOrder() {
		return this.kind == Order.KIND_BUY_MARKET_ORDER
				|| this.kind == Order.KIND_SELL_MARKET_ORDER;
	}

	/*
	public def isCancel():Boolean = this instanceof Cancel;
	*/

	public Boolean isCancel() {
		return this instanceof Cancel;
	}

	/*
	public def isExpired(market:Market):Boolean {
		assert this.marketId == market.id;
		return this.isExpired(market.getTime());
	}
	*/

	public Boolean isExpired(Market market) {
		assert this.marketId == market.id;
		return this.isExpired(market.getTime());
	}

	/*
	public def isExpired(t:long):Boolean {
		return this.timePlaced + this.timeLength < t;
	}
	*/

	public Boolean isExpired(long t) {
		return this.timePlaced + this.timeLength < t;
	}

	/*
	public def toString():String {
		return this.typeName() + [this.getKindName(), "agent:" + this.agentId, "market:" + this.marketId, this.price, this.volume, this.timeLength, this.timePlaced, "id:" + this.orderId];
	}
	*/
	/*
	public def getKindName():String {
		if (this.kind == KIND_BUY_MARKET_ORDER) {
			return "BUY_MARKET_ORDER";
		}
		if (this.kind == KIND_SELL_MARKET_ORDER) {
			return "SELL_MARKET_ORDER";
		}
		if (this.kind == KIND_BUY_LIMIT_ORDER) {
			return "BUY_LIMIT_ORDER";
		}
		if (this.kind == KIND_SELL_LIMIT_ORDER) {
			return "SELL_LIMIT_ORDER";
		}
		return "UNKNOWN_KIND";
	}
	*/

	public String getKindName() {
		if (this.kind == KIND_BUY_MARKET_ORDER) {
			return "BUY_MARKET_ORDER";
		}
		if (this.kind == KIND_SELL_MARKET_ORDER) {
			return "SELL_MARKET_ORDER";
		}
		if (this.kind == KIND_BUY_LIMIT_ORDER) {
			return "BUY_LIMIT_ORDER";
		}
		if (this.kind == KIND_SELL_LIMIT_ORDER) {
			return "SELL_LIMIT_ORDER";
		}
		return "UNKNOWN_KIND";
	}
}
