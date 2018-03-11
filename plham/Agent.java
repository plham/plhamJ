package plham;

import java.io.IOException;
import java.io.ObjectStreamException;

import plham.Market.AgentUpdate;
import plham.main.Simulator;
import plham.util.JSONRandom;
import cassia.util.JSON;
import x10.core.Long;
import x10.core.Ref;
import x10.serialization.SerializationProxy;
import x10.serialization.X10JavaDeserializer;
import x10.serialization.X10JavaSerializable;
import x10.serialization.X10JavaSerializer;
import x10.rtt.NamedType;
import x10.rtt.RuntimeType;
import x10.rtt.Type;
import x10.runtime.impl.java.Runtime;
import x10.util.HashMap;
import x10.util.List;
import x10.util.ListIterator;
import x10.util.Map;
import x10.util.Random;
import x10.util.Set;

/**
 * The base class for agents.
 * 
 * <p>
 * <ul>
 * <li>Override <code>submitOrders(List[Market])</code> to implement a trading
 * strategy.
 * <li>Only overriding <code>submitOrders(Market)</code> would not work
 * expectedly.
 * <li>Do not call <code>Market#handleOrders(List[Order])</code> in
 * <code>submitOrders(List[Market])</code> family.
 * <li>Call <code>setMarketAccessible(Market)</code> to tell the agent to enter
 * that market.
 * <li>Without calling <code>setMarketAccessible(Market)</code>,
 * <code>getAssetVolume(Market)</code> will raise an error.
 * <li>Use <code>getRandom()</code> and do NOT make <code>new Random()</code>.
 * </ul>
 */

@SuppressWarnings("serial")
abstract public class Agent extends Ref {
	@SuppressWarnings({ "hiding", "unchecked" })
	public static final RuntimeType<Agent> $RTT = NamedType.<Agent> make(
			"plham.Agent", Agent.class);

	public RuntimeType<?> $getRTT() {
		return $RTT;
	}

	public Type<?> $getParam(int i) {
		return null;
	}

	public static X10JavaSerializable $_deserialize_body(plham.Agent $_obj,
			X10JavaDeserializer $deserializer) throws java.io.IOException {
		if (Runtime.TRACE_SER) {
			Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
					+ Agent.class + " calling");
		}
		$_obj.assetsVolumes = $deserializer.readObject();
		$_obj.cashAmount = $deserializer.readDouble();
		$_obj.id = $deserializer.readLong();
		$_obj.name = $deserializer.readObject();
		$_obj.random = $deserializer.readObject();
		return $_obj;
	}

	@SuppressWarnings("unused")
	public static X10JavaSerializable $_deserializer(
			X10JavaDeserializer $deserializer) throws IOException {
		return null;
	}

	public void $_serialize(x10.serialization.X10JavaSerializer $serializer)
			throws java.io.IOException {
		$serializer.write(this.assetsVolumes);
		$serializer.write(this.cashAmount);
		$serializer.write(this.id);
		$serializer.write(this.name);
		$serializer.write(this.random);

	}

	// constructor just for allocation
	@SuppressWarnings("unused")
	public Agent(final System[] $dummy) {
		// do nothing
	}

	/** The id of this agent assigned by the system (DON'T CHANGE IT). */
	public long id;

	/** The JSON object name (DON'T CHANGE IT). */
	public String name;

	/** The RNG given by the system (DON'T CHANGE IT). */
	public Random random;

	/** @return An instance of Random (derived from the root). */
	public Random getRandom() {
		return this.random;
	}

	/** The amount of cash. */
	public double cashAmount;

	/** A mapping from markets (id) to the volumes of the assets. */
	public Map<x10.core.Long, x10.core.Long> assetsVolumes;

	/** Only used for proxy agent **/
	// constructor for non-virtual call
	@SuppressWarnings("hiding")
	final public plham.Agent init(final long id) {
		this.fieldInitializersPlhamAgent();
		this.id = id;
		this.name = null;
		this.random = null;
		this.cashAmount = 0.0;
		this.assetsVolumes = null;

		return this;
	}

	@SuppressWarnings("unused")
	public static class Proxy extends plham.Agent implements
			X10JavaSerializable {
		@SuppressWarnings({ "unchecked", "hiding" })
		public static final RuntimeType<Proxy> $RTT = NamedType.<Proxy> make(
				"plham.Agent.Proxy", Proxy.class,
				new Type[] { plham.Agent.$RTT });

		@Override
		public RuntimeType<?> $getRTT() {
			return $RTT;
		}

		@Override
		public Type<?> $getParam(int i) {
			return null;
		}

		private Object writeReplace() throws ObjectStreamException {
			return new SerializationProxy(this);
		}

		public static X10JavaSerializable $_deserialize_body(Proxy $_obj,
				X10JavaDeserializer $deserializer) throws IOException {
			if (Runtime.TRACE_SER) {
				Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
						+ Proxy.class + " calling");
			}
			plham.Agent.$_deserialize_body($_obj, $deserializer);
			return $_obj;
		}

		public static X10JavaSerializable $_deserializer(
				X10JavaDeserializer $deserializer) throws IOException {
			Proxy $_obj = new Proxy((System[]) null);
			$deserializer.record_reference($_obj);
			return $_deserialize_body($_obj, $deserializer);
		}

		@Override
		public void $_serialize(X10JavaSerializer $serializer)
				throws IOException {
			super.$_serialize($serializer);

		}

		// constructor just for allocation
		public Proxy(final System[] $dummy) {
			super($dummy);

		}

		// creation method for java code (1-phase java constructor)
		public Proxy(final long id) {
			this(null);
			initAgentProxy(id);
		}

		// constructor for non-virtual call
		@SuppressWarnings("hiding")
		final public Proxy initAgentProxy(final long id) {
			init(id);
			this.fieldInitializersPlhamAgentProxy();
			return this;
		}

		@Override
		@SuppressWarnings("rawtypes")
		public List<Order> submitOrders(final List markets) {
			throw new Error("should not called");
		}

		final public Proxy getAgentProxy() {
			return plham.Agent.Proxy.this;
		}

		final public void fieldInitializersPlhamAgentProxy() {
			// do nothing
		}
	}

	// constructor for non-virtual call
	@SuppressWarnings({ "unchecked", "hiding" })
	final public plham.Agent initAgent(final long id, final String name,
			final Random random) {
		this.fieldInitializersPlhamAgent();
		this.id = id;
		this.name = name;
		this.random = random;
		this.cashAmount = 0.0;
		this.assetsVolumes = new HashMap<x10.core.Long, x10.core.Long>(null,
				x10.rtt.Types.LONG, x10.rtt.Types.LONG)
				.x10$util$HashMap$$init$S();
		return this;
	}

	@SuppressWarnings("unchecked")
	public Agent setup(final JSON.Value json, final Simulator sim) {
		final JSONRandom jsonRandom = new JSONRandom((java.lang.System[]) null)
				.plham$util$JSONRandom$$init$S(getRandom());
		this.assetsVolumes = new HashMap<x10.core.Long, x10.core.Long>(null,
				x10.rtt.Types.LONG, x10.rtt.Types.LONG)
				.x10$util$HashMap$$init$S();
		this.cashAmount = jsonRandom.nextRandom$O(json.get(
				x10.rtt.Types.STRING, "cashAmount"));
		List<Market> markets = sim.getMarketsByName(json.get(
				x10.rtt.Types.STRING, "markets"));

		ListIterator<Market> iterator = markets.iterator();
		while (iterator.hasNext$O()) {
			Market market = iterator.next$G();
			this.assetsVolumes.$set(market.id, x10.rtt.Types.LONG,
					(long) jsonRandom.nextRandom$O(json.get(
							x10.rtt.Types.STRING, "assetVolume")),
					x10.rtt.Types.LONG);
		}
		return this;
	}

	/**
	 * Submit orders to the markets. This method will be invoked by the system.
	 * 
	 * @param markets
	 *            a list of all markets (but some may not be up-to-date).
	 * @return a list of orders.
	 */
	abstract public List<Order> submitOrders(final List<Market> markets);

	@SuppressWarnings("hiding")
	public boolean isMarketAccessible(final long id) {
		return this.assetsVolumes.containsKey$Z(x10.core.Long.$box(id),
				x10.rtt.Types.LONG);
	}

	public boolean isMarketAccessible(final plham.Market market) {
		return this.isMarketAccessible(market.id);
	}

	public long setMarketAccessible$O(final long id) {
		return Long.$unbox(this.assetsVolumes.$set(Long.$box(id),
				x10.rtt.Types.LONG, Long.$box(0L), x10.rtt.Types.LONG));
	}

	public long setMarketAccessible$O(final plham.Market market) {
		return this.setMarketAccessible$O(market.id);
	}

	public double getCashAmount() {
		return this.cashAmount;
	}

	public double setCashAmount(final double cashAmount) {
		this.cashAmount = cashAmount;
		return this.cashAmount;
	}

	public double updateCashAmount(final double delta) {
		this.cashAmount = this.cashAmount + delta;
		return this.cashAmount;
	}

	public void executeUpdate(final AgentUpdate update) {
		this.updateCashAmount(update.cashAmountDelta);
		this.updateAssetVolume(update.marketId, update.assetVolumeDelta);
		this.orderExecuted(update.marketId, update.orderId, update.price,
				update.cashAmountDelta, update.assetVolumeDelta);
	}

	@SuppressWarnings("hiding")
	public long getAssetVolume(final long id) {
		assert this.isMarketAccessible(id);
		return x10.core.Long.$unbox(this.assetsVolumes.$apply(
				x10.core.Long.$box(id), x10.rtt.Types.LONG));
	}

	// #line 107 "/home/dsl/workspace/plhamK/plham/Agent.x10"
	public long setAssetVolume(final long id, final long assetVolume) {
		assert this.isMarketAccessible(id);
		return x10.core.Long.$unbox(this.assetsVolumes.$set(
				x10.core.Long.$box(id), x10.rtt.Types.LONG,
				x10.core.Long.$box(assetVolume), x10.rtt.Types.LONG));
	}

	/**
	 * @throws Exception
	 *             if <code>isMarketAccessible(market)</code> is false.
	 */
	public long getAssetVolume(final plham.Market market) {
		return getAssetVolume(market.id);
	}

	/**
	 * @throws Exception
	 *             if <code>isMarketAccessible(market)</code> is false.
	 */
	public long setAssetVolume$O(final plham.Market market,
			final long assetVolume) {
		return this.setAssetVolume(market.id, assetVolume);
	}

	/**
	 * @throws Exception
	 *             if <code>isMarketAccessible(market)</code> is false.
	 */
	@SuppressWarnings("hiding")
	public long updateAssetVolume(final long id, final long delta) {
		return x10.core.Long.$unbox(this.assetsVolumes.$set(x10.core.Long
				.$box(id), x10.rtt.Types.LONG, x10.core.Long
				.$box((x10.core.Long.$unbox(this.assetsVolumes.$apply(
						x10.core.Long.$box(id), x10.rtt.Types.LONG)) + delta)),
				x10.rtt.Types.LONG));
	}

	public long updateAssetVolume(final plham.Market market, final long delta) {
		return this.updateAssetVolume(market.id, delta);
	}

	/**
	 * Callback when one's order is executed at the market.
	 * 
	 * @param orderId
	 *            (0 if unspecified)
	 * @param market
	 * @param price
	 *            the price at which the order is executed
	 * @param cashAmountDelta
	 *            how much changed
	 * @param assetVolumeDelta
	 *            how much changed
	 */
	@SuppressWarnings("unused")
	public void orderExecuted(final long marketId, final long orderId,
			final double price, final double cashAmountDelta,
			final long assetVolumeDelta) {
		// do nothing

	}

	/**
	 * Get the next order id. This is called in the constructor of
	 * {@link plham.Order}. To enable automated order numbering, override this
	 * method and return unique integers.
	 * 
	 * @return always 0 by default
	 * @see plham.OrderBook
	 */
	@SuppressWarnings("static-method")
	public long nextOrderId() {
		return 0L;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		return x10.rtt.Types.typeName(this)
				+ ((x10.runtime.impl.java.ArrayUtils
						.<Object> makeRailFromJavaArray(
								x10.rtt.Types.ANY,
								new Object[] {
										this.id,
										this.cashAmount,
										((Set<x10.core.Long>) this.assetsVolumes
												.keySet()) })));
	}

	final public plham.Agent getAgent() {
		return plham.Agent.this;
	}

	final public void fieldInitializersPlhamAgent() {
		this.cashAmount = 0.0;
		this.assetsVolumes = null;
	}
}
