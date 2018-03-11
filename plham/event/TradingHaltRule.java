package plham.event;

/**
 * A trading halt is a market regulation that suspends the trading of some
 * assets. The current implementation sets
 * <code>Market#isRunning() = false</code> when the price changed beyond the
 * prespecified threshold range.
 */

public class TradingHaltRule extends x10.core.Ref implements
		plham.Market.MarketEvent, plham.Market.OrderEvent,
		x10.serialization.X10JavaSerializable {
	public static final x10.rtt.RuntimeType<TradingHaltRule> $RTT = x10.rtt.NamedType
			.<TradingHaltRule> make("plham.event.TradingHaltRule",
					TradingHaltRule.class, new x10.rtt.Type[] {
							plham.Market.MarketEvent.$RTT,
							plham.Market.OrderEvent.$RTT });

	public x10.rtt.RuntimeType<?> $getRTT() {
		return $RTT;
	}

	public x10.rtt.Type<?> $getParam(int i) {
		return null;
	}

	private Object writeReplace() throws java.io.ObjectStreamException {
		return new x10.serialization.SerializationProxy(this);
	}

	public static x10.serialization.X10JavaSerializable $_deserialize_body(
			plham.event.TradingHaltRule $_obj,
			x10.serialization.X10JavaDeserializer $deserializer)
			throws java.io.IOException {
		if (x10.runtime.impl.java.Runtime.TRACE_SER) {
			x10.runtime.impl.java.Runtime
					.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
							+ TradingHaltRule.class + " calling");
		}
		$_obj.activationCount = $deserializer.readLong();
		$_obj.haltingTimeLength = $deserializer.readLong();
		$_obj.haltingTimeStarted = $deserializer.readLong();
		$_obj.id = $deserializer.readLong();
		$_obj.name = $deserializer.readObject();
		$_obj.random = $deserializer.readObject();
		$_obj.referenceMarketId = $deserializer.readLong();
		$_obj.referencePrice = $deserializer.readDouble();
		$_obj.targetMarketIds = $deserializer.readObject();
		$_obj.triggerChangeRate = $deserializer.readDouble();
		return $_obj;
	}

	public static x10.serialization.X10JavaSerializable $_deserializer(
			x10.serialization.X10JavaDeserializer $deserializer)
			throws java.io.IOException {
		plham.event.TradingHaltRule $_obj = new plham.event.TradingHaltRule(
				(java.lang.System[]) null);
		$deserializer.record_reference($_obj);
		return $_deserialize_body($_obj, $deserializer);
	}

	public void $_serialize(x10.serialization.X10JavaSerializer $serializer)
			throws java.io.IOException {
		$serializer.write(this.activationCount);
		$serializer.write(this.haltingTimeLength);
		$serializer.write(this.haltingTimeStarted);
		$serializer.write(this.id);
		$serializer.write(this.name);
		$serializer.write(this.random);
		$serializer.write(this.referenceMarketId);
		$serializer.write(this.referencePrice);
		$serializer.write(this.targetMarketIds);
		$serializer.write(this.triggerChangeRate);

	}

	// constructor just for allocation
	public TradingHaltRule(final java.lang.System[] $dummy) {

	}

	// #line 17 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	public long id;

	// #line 18 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	public java.lang.String name;

	// #line 19 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	public x10.util.Random random;

	// #line 20 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	public long referenceMarketId;

	// #line 21 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	public double referencePrice;

	// #line 22 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	public double triggerChangeRate;

	// #line 23 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	public long haltingTimeLength;

	// #line 24 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	public long haltingTimeStarted;

	// #line 25 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	public long activationCount;

	// #line 26 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	public x10.util.Set<x10.core.Long> targetMarketIds;

	// #line 28 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	// creation method for java code (1-phase java constructor)
	public TradingHaltRule(final long id, final java.lang.String name,
			final x10.util.Random random) {
		this((java.lang.System[]) null);
		plham$event$TradingHaltRule$$init$S(id, name, random);
	}

	// constructor for non-virtual call
	final public plham.event.TradingHaltRule plham$event$TradingHaltRule$$init$S(
			final long id, final java.lang.String name,
			final x10.util.Random random) {
		{

			// #line 28
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"

			// #line 15
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			this.__fieldInitializers_plham_event_TradingHaltRule();

			// #line 33
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			this.id = id;

			// #line 34
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			this.name = ((name));

			// #line 35
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			this.random = ((random));

			// #line 36
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final long t$21303 = java.lang.Long.MIN_VALUE;

			// #line 36
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			this.haltingTimeStarted = t$21303;

			// #line 37
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			this.activationCount = 0L;

			// #line 38
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final x10.util.HashSet t$21304 = ((new x10.util.HashSet<x10.core.Long>(
					(java.lang.System[]) null, x10.rtt.Types.LONG)
					.x10$util$HashSet$$init$S()));

			// #line 38
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			this.targetMarketIds = ((t$21304));
		}
		return this;
	}

	// #line 44 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	/**
	 * (The order will be ignored.)
	 */
	public void update(final plham.Market market, final plham.Order order) {

		// #line 45 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		this.update(((market)));
	}

	// #line 48 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	public void update(final plham.Market market) {

		// #line 49 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		assert (this.referenceMarketId) == (market.id);

		// #line 50 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final plham.Market referenceMarket = ((market));

		// #line 51 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final plham.Env env = ((market.env));

		// #line 52 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final long t = referenceMarket.getTime$O();

		// #line 53 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final boolean t$21331 = referenceMarket.isRunning$O();

		// #line 53 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		if (t$21331) {

			// #line 54
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final double t$21305 = this.referencePrice;

			// #line 54
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final double t$21306 = referenceMarket.getPrice$O();

			// #line 54
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final double priceChange = ((t$21305) - (((t$21306))));

			// #line 55
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final double t$21307 = this.referencePrice;

			// #line 55
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final double t$21308 = this.triggerChangeRate;

			// #line 55
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final double t$21311 = ((t$21307) * (((t$21308))));

			// #line 55
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final long t$21309 = this.activationCount;

			// #line 55
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final long t$21310 = ((t$21309) + (((1L))));

			// #line 55
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final double t$21312 = ((((t$21310))));

			// #line 55
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final double thresholdChange = ((t$21311) * (((t$21312))));

			// #line 56
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final double t$21313 = java.lang.Math.abs(((priceChange)));

			// #line 56
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final double t$21314 = java.lang.Math
					.abs(((thresholdChange)));

			// #line 56
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final boolean t$21321 = ((t$21313) >= (((t$21314))));

			// #line 56
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			if (t$21321) {

				// #line 61
				// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
				referenceMarket.setRunning$O((false));

				// #line 62
				// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
				final x10.util.Set t$21352 = ((this.targetMarketIds));

				// #line 62
				// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
				final x10.lang.Iterator i$21353 = (((x10.lang.Iterable<x10.core.Long>) t$21352)
						.iterator());

				// #line 62
				// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
				for (; true;) {

					// #line 62
					// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
					final boolean t$21354 = ((x10.lang.Iterator<x10.core.Long>) i$21353)
							.hasNext$O();

					// #line 62
					// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
					if (!(t$21354)) {

						// #line 62
						// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
						break;
					}

					// #line 62
					// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
					final long i$21349 = x10.core.Long
							.$unbox(((x10.lang.Iterator<x10.core.Long>) i$21353)
									.next$G());

					// #line 63
					// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
					final x10.util.List t$21350 = ((env.markets));

					// #line 63
					// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
					final plham.Market target$21351 = ((x10.util.Indexed<plham.Market>) t$21350)
							.$apply$G((i$21349));

					// #line 64
					// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
					target$21351.setRunning$O((false));
				}

				// #line 66
				// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
				this.haltingTimeStarted = t;

				// #line 67
				// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
				final long t$21319 = this.activationCount;

				// #line 67
				// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
				final long t$21320 = ((t$21319) + (((1L))));

				// #line 67
				// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
				this.activationCount = t$21320;
			}
		} else {

			// #line 70
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final long t$21322 = this.haltingTimeStarted;

			// #line 70
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final long t$21323 = this.haltingTimeLength;

			// #line 70
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final long t$21324 = ((t$21322) + (((t$21323))));

			// #line 70
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final boolean t$21330 = ((t) > (((t$21324))));

			// #line 70
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			if (t$21330) {

				// #line 71
				// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
				referenceMarket.setRunning$O((true));

				// #line 72
				// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
				final x10.util.Set t$21358 = ((this.targetMarketIds));

				// #line 72
				// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
				final x10.lang.Iterator i$21359 = (((x10.lang.Iterable<x10.core.Long>) t$21358)
						.iterator());

				// #line 72
				// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
				for (; true;) {

					// #line 72
					// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
					final boolean t$21360 = ((x10.lang.Iterator<x10.core.Long>) i$21359)
							.hasNext$O();

					// #line 72
					// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
					if (!(t$21360)) {

						// #line 72
						// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
						break;
					}

					// #line 72
					// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
					final long i$21355 = x10.core.Long
							.$unbox(((x10.lang.Iterator<x10.core.Long>) i$21359)
									.next$G());

					// #line 73
					// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
					final x10.util.List t$21356 = ((env.markets));

					// #line 73
					// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
					final plham.Market target$21357 = ((x10.util.Indexed<plham.Market>) t$21356)
							.$apply$G((i$21355));

					// #line 75
					// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
					target$21357.itayoseOrderBooks();

					// #line 76
					// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
					target$21357.setRunning$O((true));
				}

				// #line 78
				// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
				final long t$21329 = java.lang.Long.MIN_VALUE;

				// #line 78
				// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
				this.haltingTimeStarted = t$21329;
			}
		}
	}

	// #line 83 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	public void setReferencePrice(final double referencePrice) {

		// #line 84 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		this.referencePrice = referencePrice;
	}

	// #line 87 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	public void addTargetMarket(final plham.Market market) {

		// #line 88 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final x10.util.Set t$21332 = ((this.targetMarketIds));

		// #line 88 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final long t$21333 = market.id;

		// #line 88 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		((x10.util.Collection<x10.core.Long>) t$21332).add$Z(
				x10.core.Long.$box(t$21333), x10.rtt.Types.LONG);
	}

	// #line 91 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	public void addTargetMarkets__0$1plham$Market$2(final x10.util.List markets) {

		// #line 92 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final x10.util.ListIterator market$21302 = (((x10.util.List<plham.Market>) markets)
				.iterator());

		// #line 92 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		for (; true;) {

			// #line 92
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final boolean t$21337 = ((x10.util.ListIterator<plham.Market>) market$21302)
					.hasNext$O();

			// #line 92
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			if (!(t$21337)) {

				// #line 92
				// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
				break;
			}

			// #line 92
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final plham.Market market$21361 = ((((x10.util.ListIterator<plham.Market>) market$21302)
					.next$G()));

			// #line 93
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final x10.util.Set t$21362 = ((this.targetMarketIds));

			// #line 93
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final long t$21363 = market$21361.id;

			// #line 93
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			((x10.util.Collection<x10.core.Long>) t$21362).add$Z(
					x10.core.Long.$box(t$21363), x10.rtt.Types.LONG);
		}
	}

	// #line 97 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	public static void register(final plham.main.Simulator sim) {

		// #line 98 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final java.lang.String name = (("TradingHaltRule"));

		// #line 99 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final x10.core.fun.Fun_0_4 t$21340 = ((new plham.event.TradingHaltRule.$Closure$8(
				sim)));

		// #line 99 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		sim.addEventInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Event$2(
				((name)), ((t$21340)));
	}

	// #line 104 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	public plham.event.TradingHaltRule setup(final cassia.util.JSON.Value json,
			final plham.main.Simulator sim) {

		// #line 105
		// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final cassia.util.JSON.Value t$21341 = json
				.<java.lang.String> get(x10.rtt.Types.STRING,
						(("referenceMarket")));

		// #line 105
		// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final plham.Market market = sim
				.getMarketByName(((t$21341)));

		// #line 106
		// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final long t$21342 = market.id;

		// #line 106
		// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		this.referenceMarketId = t$21342;

		// #line 107
		// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final double t$21343 = market.getPrice$O();

		// #line 107
		// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		this.referencePrice = t$21343;

		// #line 108
		// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final cassia.util.JSON.Value t$21344 = json
				.<java.lang.String> get(x10.rtt.Types.STRING,
						(("triggerChangeRate")));

		// #line 108
		// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final double t$21345 = t$21344.toDouble$O();

		// #line 108
		// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		this.triggerChangeRate = t$21345;

		// #line 109
		// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final cassia.util.JSON.Value t$21346 = json
				.<java.lang.String> get(x10.rtt.Types.STRING,
						(("haltingTimeLength")));

		// #line 109
		// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final long t$21347 = t$21346.toLong$O();

		// #line 109
		// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		this.haltingTimeLength = t$21347;

		// #line 110
		// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final cassia.util.JSON.Value t$21348 = json
				.<java.lang.String> get(x10.rtt.Types.STRING,
						(("targetMarkets")));

		// #line 110
		// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		final x10.util.List targetMarkets = sim
				.getMarketsByName(((t$21348)));

		// #line 111
		// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		this.addTargetMarkets__0$1plham$Market$2(((targetMarkets)));

		// #line 112
		// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		market.addAfterOrderHandlingEvent$O(((this)));

		// #line 113
		// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		return this;
	}

	// #line 15 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	final public plham.event.TradingHaltRule plham$event$TradingHaltRule$$this$plham$event$TradingHaltRule() {

		// #line 15 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		return plham.event.TradingHaltRule.this;
	}

	// #line 15 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
	final public void __fieldInitializers_plham_event_TradingHaltRule() {

		// #line 15 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		this.referenceMarketId = 0L;

		// #line 15 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		this.referencePrice = 0.0;

		// #line 15 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		this.triggerChangeRate = 0.0;

		// #line 15 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		this.haltingTimeLength = 0L;

		// #line 15 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		this.haltingTimeStarted = 0L;

		// #line 15 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		this.activationCount = 0L;

		// #line 15 "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
		this.targetMarketIds = null;
	}

	final public static class $Closure$8 extends x10.core.Ref implements
			x10.core.fun.Fun_0_4, x10.serialization.X10JavaSerializable {
		public static final x10.rtt.RuntimeType<$Closure$8> $RTT = x10.rtt.StaticFunType
				.<$Closure$8> make($Closure$8.class,
						new x10.rtt.Type[] { x10.rtt.ParameterizedType.make(
								x10.core.fun.Fun_0_4.$RTT, x10.rtt.Types.LONG,
								x10.rtt.Types.STRING, x10.util.Random.$RTT,
								cassia.util.JSON.Value.$RTT,
								plham.event.TradingHaltRule.$RTT) });

		public x10.rtt.RuntimeType<?> $getRTT() {
			return $RTT;
		}

		public x10.rtt.Type<?> $getParam(int i) {
			return null;
		}

		private Object writeReplace() throws java.io.ObjectStreamException {
			return new x10.serialization.SerializationProxy(this);
		}

		public static x10.serialization.X10JavaSerializable $_deserialize_body(
				plham.event.TradingHaltRule.$Closure$8 $_obj,
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			if (x10.runtime.impl.java.Runtime.TRACE_SER) {
				x10.runtime.impl.java.Runtime
						.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
								+ $Closure$8.class + " calling");
			}
			$_obj.sim = $deserializer.readObject();
			return $_obj;
		}

		public static x10.serialization.X10JavaSerializable $_deserializer(
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			plham.event.TradingHaltRule.$Closure$8 $_obj = new plham.event.TradingHaltRule.$Closure$8(
					(java.lang.System[]) null);
			$deserializer.record_reference($_obj);
			return $_deserialize_body($_obj, $deserializer);
		}

		public void $_serialize(x10.serialization.X10JavaSerializer $serializer)
				throws java.io.IOException {
			$serializer.write(this.sim);

		}

		// constructor just for allocation
		public $Closure$8(final java.lang.System[] $dummy) {

		}

		// dispatcher for method abstract public
		// (Z1,Z2,Z3,Z4)=>U.operator()(a1:Z1, a2:Z2, a3:Z3, a4:Z4):U
		public java.lang.Object $apply(final java.lang.Object a1,
				final x10.rtt.Type t1, final java.lang.Object a2,
				final x10.rtt.Type t2, final java.lang.Object a3,
				final x10.rtt.Type t3, final java.lang.Object a4,
				final x10.rtt.Type t4) {
			return $apply(x10.core.Long.$unbox(a1), (java.lang.String) a2,
					(x10.util.Random) a3, (cassia.util.JSON.Value) a4);

		}

		public plham.event.TradingHaltRule $apply(final long id,
				final java.lang.String name, final x10.util.Random random,
				final cassia.util.JSON.Value json) {

			// #line 100
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final plham.event.TradingHaltRule t$21338 = ((new plham.event.TradingHaltRule(
					(java.lang.System[]) null)
					.plham$event$TradingHaltRule$$init$S(((id)),
							((name)),
							((random)))));

			// #line 100
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			final plham.event.TradingHaltRule t$21339 = t$21338.setup(
					((json)),
					((this.sim)));

			// #line 100
			// "/home/dsl/workspace/plhamK/plham/event/TradingHaltRule.x10"
			return t$21339;
		}

		public plham.main.Simulator sim;

		public $Closure$8(final plham.main.Simulator sim) {
			{
				this.sim = ((sim));
			}
		}

	}

}
