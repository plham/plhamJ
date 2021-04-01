package plham.core;

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
	public static final long KIND_BUY_LIMIT_ORDER = 3L;

	public static final long KIND_BUY_MARKET_ORDER = 1L;
	public static final long KIND_SELL_LIMIT_ORDER = 4L;
	public static final long KIND_SELL_MARKET_ORDER = 2L;
	public static double NO_PRICE = Double.MAX_VALUE;

	private static final long serialVersionUID = -2789404032919261695L;

	public long agentId;
	public long kind;
	public long marketId;
	public long orderId;
	public double price;
	public long timeLength;
	public long timePlaced;
	public long volume;

	public Order(long kind, Agent agent, Market market, double price, long volume, long timeLength) {
		this(kind, agent.id, market.id, price, volume, timeLength, market.getTime(), agent.nextOrderId());
	}

	public Order(long kind, long agentId, long marketId, double price, long volume, long timeLength, long timePlaced) {
		this(kind, agentId, marketId, price, volume, timeLength, timePlaced, 0);
	}

	public Order(long kind, long agentId, long marketId, double price, long volume, long timeLength, long timePlaced,
			long orderId) {
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

	public Order(Order other) {
		kind = other.kind;
		agentId = other.agentId;
		marketId = other.marketId;
		price = other.price;
		volume = other.volume;
		timeLength = other.timeLength;
		timePlaced = other.timePlaced;
		orderId = other.orderId;
	}

	public String getKindName() {
		if (kind == KIND_BUY_MARKET_ORDER) {
			return "BUY_MARKET_ORDER";
		}
		if (kind == KIND_SELL_MARKET_ORDER) {
			return "SELL_MARKET_ORDER";
		}
		if (kind == KIND_BUY_LIMIT_ORDER) {
			return "BUY_LIMIT_ORDER";
		}
		if (kind == KIND_SELL_LIMIT_ORDER) {
			return "SELL_LIMIT_ORDER";
		}
		return "UNKNOWN_KIND";
	}

	public double getPrice() {
		return price;
	}

	public long getVolume() {
		return volume;
	}

	public Boolean isBuyOrder() {
		return kind == Order.KIND_BUY_MARKET_ORDER || kind == Order.KIND_BUY_LIMIT_ORDER;
	}

	public Boolean isCancel() {
		return this instanceof Cancel;
	}

	public Boolean isExpired(long t) {
		return timePlaced + timeLength < t;
	}

	public Boolean isExpired(Market market) {
		assert marketId == market.id;
		return this.isExpired(market.getTime());
	}

	public Boolean isLimitOrder() {
		return kind == Order.KIND_BUY_LIMIT_ORDER || kind == Order.KIND_SELL_LIMIT_ORDER;
	}

	public Boolean isMarketOrder() {
		return kind == Order.KIND_BUY_MARKET_ORDER || kind == Order.KIND_SELL_MARKET_ORDER;
	}

	public Boolean isSellOrder() {
		return kind == Order.KIND_SELL_MARKET_ORDER || kind == Order.KIND_SELL_LIMIT_ORDER;
	}

	public double setPrice(double price) {
		return this.price = price;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return getKindName() + " " + getKindName() + " agent:" + agentId + " market:" + marketId + " " + price + " "
				+ volume + " " + timeLength + " " + timePlaced + " id:" + orderId;
	}

	public void updateVolume(long delta) {
		volume += delta;
		assert volume >= 0;
	}
}
