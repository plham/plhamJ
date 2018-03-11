package samples.ShockTransfer;

@x10.runtime.impl.java.X10Generated
public class ArbitrageAgent extends plham.HighFrequencyAgent implements
		x10.serialization.X10JavaSerializable {
	public static final x10.rtt.RuntimeType<ArbitrageAgent> $RTT = x10.rtt.NamedType
			.<ArbitrageAgent> make("samples.ShockTransfer.ArbitrageAgent",
					ArbitrageAgent.class,
					new x10.rtt.Type[] { plham.HighFrequencyAgent.$RTT });

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
			samples.ShockTransfer.ArbitrageAgent $_obj,
			x10.serialization.X10JavaDeserializer $deserializer)
			throws java.io.IOException {
		if (x10.runtime.impl.java.Runtime.TRACE_SER) {
			x10.runtime.impl.java.Runtime
					.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
							+ ArbitrageAgent.class + " calling");
		}
		plham.HighFrequencyAgent.$_deserialize_body($_obj, $deserializer);
		$_obj.orderThresholdPrice = $deserializer.readDouble();
		$_obj.orderTimeLength = $deserializer.readLong();
		$_obj.orderVolume = $deserializer.readLong();
		return $_obj;
	}

	public static x10.serialization.X10JavaSerializable $_deserializer(
			x10.serialization.X10JavaDeserializer $deserializer)
			throws java.io.IOException {
		samples.ShockTransfer.ArbitrageAgent $_obj = new samples.ShockTransfer.ArbitrageAgent(
				(java.lang.System[]) null);
		$deserializer.record_reference($_obj);
		return $_deserialize_body($_obj, $deserializer);
	}

	public void $_serialize(x10.serialization.X10JavaSerializer $serializer)
			throws java.io.IOException {
		super.$_serialize($serializer);
		$serializer.write(this.orderThresholdPrice);
		$serializer.write(this.orderTimeLength);
		$serializer.write(this.orderVolume);

	}

	// constructor just for allocation
	public ArbitrageAgent(final java.lang.System[] $dummy) {
		super($dummy);

	}

	// #line 18
	// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
	/** The volume of orders to each spot market. */
	public long orderVolume;

	// #line 20
	// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
	/** Submit orders if the price gap is more than this threshold. */
	public double orderThresholdPrice;

	// #line 22
	// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
	/** As HFT, the time length of orders should be very short (&lt;= 2). */
	public long orderTimeLength;

	// #line 24
	// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
	// creation method for java code (1-phase java constructor)
	public ArbitrageAgent(final long id, final java.lang.String name,
			final x10.util.Random random) {
		this((java.lang.System[]) null);
		samples$ShockTransfer$ArbitrageAgent$$init$S(id, name, random);
	}

	// constructor for non-virtual call
	final public samples.ShockTransfer.ArbitrageAgent samples$ShockTransfer$ArbitrageAgent$$init$S(
			final long id, final java.lang.String name,
			final x10.util.Random random) {
		{

			// #line 25
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			/* super. */plham$HighFrequencyAgent$$init$S(((id)),
					((name)), ((random)));

			// #line 24
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"

			// #line 15
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			this.__fieldInitializers_samples_ShockTransfer_ArbitrageAgent();

			// #line 26
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			this.orderVolume = 1L;

			// #line 27
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			this.orderThresholdPrice = 0.0;

			// #line 28
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			this.orderTimeLength = 2L;
		}
		return this;
	}

	// #line 30
	// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
	// creation method for java code (1-phase java constructor)
	public ArbitrageAgent() {
		this((java.lang.System[]) null);
		samples$ShockTransfer$ArbitrageAgent$$init$S();
	}

	// constructor for non-virtual call
	final public samples.ShockTransfer.ArbitrageAgent samples$ShockTransfer$ArbitrageAgent$$init$S() {
		{

			// #line 31
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final x10.util.Random t$34230 = ((new x10.util.Random(
					(java.lang.System[]) null).x10$util$Random$$init$S()));

			// #line 31
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			/* this. */samples$ShockTransfer$ArbitrageAgent$$init$S(
					((-1L)), (("default")),
					((t$34230)));
		}
		return this;
	}

	// #line 34
	// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
	public x10.util.List submitOrders(final x10.util.List markets) {

		// #line 35
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final x10.util.ArrayList orders = ((new x10.util.ArrayList<plham.Order>(
				(java.lang.System[]) null, plham.Order.$RTT)
				.x10$util$ArrayList$$init$S()));

		// #line 36
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final x10.util.ListIterator market$34315 = (((x10.util.List<plham.Market>) markets)
				.iterator());

		// #line 36
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		for (; true;) {

			// #line 36
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final boolean t$34316 = ((x10.util.ListIterator<plham.Market>) market$34315)
					.hasNext$O();

			// #line 36
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			if (!(t$34316)) {

				// #line 36
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				break;
			}

			// #line 36
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final plham.Market market$34312 = ((((x10.util.ListIterator<plham.Market>) market$34315)
					.next$G()));

			// #line 37
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final boolean t$34313 = this
					.isMarketAccessible(((market$34312)));

			// #line 37
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			if (t$34313) {

				// #line 38
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final x10.util.List t$34314 = this
						.submitOrders(((market$34312)));

				// #line 38
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				((x10.util.AbstractCollection<plham.Order>) orders)
						.addAll__0$1x10$util$AbstractCollection$$T$2$O(((t$34314)));
			}
		}

		// #line 41
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		return orders;
	}

	// #line 44
	// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
	public x10.util.List submitOrders(final plham.Market market) {

		// #line 45
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final x10.util.ArrayList orders = ((new x10.util.ArrayList<plham.Order>(
				(java.lang.System[]) null, plham.Order.$RTT)
				.x10$util$ArrayList$$init$S()));

		// #line 46
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final boolean t$34235 = plham.IndexMarket.$RTT.isInstance(market);

		// #line 46
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final boolean t$34236 = !(t$34235);

		// #line 46
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		if (t$34236) {

			// #line 47
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			return orders;
		}

		// #line 49
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final boolean t$34237 = this
				.isMarketAccessible(((market)));

		// #line 49
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final boolean t$34238 = !(t$34237);

		// #line 49
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		if (t$34238) {

			// #line 50
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			return orders;
		}

		// #line 53
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final plham.IndexMarket index = ((x10.rtt.Types
				.<plham.IndexMarket> cast(market, plham.IndexMarket.$RTT)));

		// #line 54
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final x10.util.List spots = index.getMarkets();

		// #line 55
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final boolean t$34239 = index.isRunning$O();

		// #line 55
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		boolean t$34241 = !(t$34239);

		// #line 55
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		if (!(t$34241)) {

			// #line 55
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final boolean t$34240 = index.isAllMarketsRunning$O();

			// #line 55
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			t$34241 = !(t$34240);
		}

		// #line 55
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final boolean t$34242 = t$34241;

		// #line 55
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		if (t$34242) {

			// #line 56
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			return orders;
		}

		// #line 59
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final double marketIndex = index.getIndex$O();

		// #line 60
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final double marketPrice = index.getPrice$O();

		// #line 62
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		boolean t$34245 = ((marketPrice) < (((marketIndex))));

		// #line 62
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		if (t$34245) {

			// #line 62
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final double t$34243 = ((marketIndex) - (((marketPrice))));

			// #line 62
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final double t$34244 = this.orderThresholdPrice;

			// #line 62
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			t$34245 = ((t$34243) > (((t$34244))));
		}

		// #line 62
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final boolean t$34257 = t$34245;

		// #line 62
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		if (t$34257) {

			// #line 63
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final long n = this.orderVolume;

			// #line 64
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final long t$34246 = ((x10.util.Container<plham.Market>) spots)
					.size$O();

			// #line 64
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final long N = ((t$34246) * (((n))));

			// #line 66
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final plham.Order.Kind t$34247 = ((plham.Order
					.get$KIND_BUY_LIMIT_ORDER()));

			// #line 66
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final double t$34248 = index.getPrice$O();

			// #line 66
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final long t$34249 = this.orderTimeLength;

			// #line 66
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final plham.Order t$34250 = ((new plham.Order(
					(java.lang.System[]) null).plham$Order$$init$S(
					((t$34247)), ((this)),
					((index)), t$34248, ((N)), t$34249)));

			// #line 66
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			((x10.util.ArrayList<plham.Order>) orders)
					.add__0x10$util$ArrayList$$T$O(((t$34250)));

			// #line 67
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final x10.util.ListIterator m$34322 = (((x10.util.List<plham.Market>) spots)
					.iterator());

			// #line 67
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			for (; true;) {

				// #line 67
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final boolean t$34323 = ((x10.util.ListIterator<plham.Market>) m$34322)
						.hasNext$O();

				// #line 67
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				if (!(t$34323)) {

					// #line 67
					// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
					break;
				}

				// #line 67
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final plham.Market m$34317 = ((((x10.util.ListIterator<plham.Market>) m$34322)
						.next$G()));

				// #line 68
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final plham.Order.Kind t$34318 = ((plham.Order
						.get$KIND_SELL_LIMIT_ORDER()));

				// #line 68
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final double t$34319 = m$34317.getPrice$O();

				// #line 68
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final long t$34320 = this.orderTimeLength;

				// #line 68
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final plham.Order t$34321 = ((new plham.Order(
						(java.lang.System[]) null).plham$Order$$init$S(
						((t$34318)), ((this)),
						((m$34317)), t$34319, ((n)),
						t$34320)));

				// #line 68
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				((x10.util.ArrayList<plham.Order>) orders)
						.add__0x10$util$ArrayList$$T$O(((t$34321)));
			}
		}

		// #line 71
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		boolean t$34260 = ((marketPrice) > (((marketIndex))));

		// #line 71
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		if (t$34260) {

			// #line 71
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final double t$34258 = ((marketPrice) - (((marketIndex))));

			// #line 71
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final double t$34259 = this.orderThresholdPrice;

			// #line 71
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			t$34260 = ((t$34258) > (((t$34259))));
		}

		// #line 71
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final boolean t$34272 = t$34260;

		// #line 71
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		if (t$34272) {

			// #line 72
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final long n = this.orderVolume;

			// #line 73
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final long t$34261 = ((x10.util.Container<plham.Market>) spots)
					.size$O();

			// #line 73
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final long N = ((t$34261) * (((n))));

			// #line 75
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final plham.Order.Kind t$34262 = ((plham.Order
					.get$KIND_SELL_LIMIT_ORDER()));

			// #line 75
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final double t$34263 = index.getPrice$O();

			// #line 75
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final long t$34264 = this.orderTimeLength;

			// #line 75
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final plham.Order t$34265 = ((new plham.Order(
					(java.lang.System[]) null).plham$Order$$init$S(
					((t$34262)), ((this)),
					((index)), t$34263, ((N)), t$34264)));

			// #line 75
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			((x10.util.ArrayList<plham.Order>) orders)
					.add__0x10$util$ArrayList$$T$O(((t$34265)));

			// #line 76
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final x10.util.ListIterator m$34329 = (((x10.util.List<plham.Market>) spots)
					.iterator());

			// #line 76
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			for (; true;) {

				// #line 76
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final boolean t$34330 = ((x10.util.ListIterator<plham.Market>) m$34329)
						.hasNext$O();

				// #line 76
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				if (!(t$34330)) {

					// #line 76
					// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
					break;
				}

				// #line 76
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final plham.Market m$34324 = ((((x10.util.ListIterator<plham.Market>) m$34329)
						.next$G()));

				// #line 77
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final plham.Order.Kind t$34325 = ((plham.Order
						.get$KIND_BUY_LIMIT_ORDER()));

				// #line 77
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final double t$34326 = m$34324.getPrice$O();

				// #line 77
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final long t$34327 = this.orderTimeLength;

				// #line 77
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final plham.Order t$34328 = ((new plham.Order(
						(java.lang.System[]) null).plham$Order$$init$S(
						((t$34325)), ((this)),
						((m$34324)), t$34326, ((n)),
						t$34327)));

				// #line 77
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				((x10.util.ArrayList<plham.Order>) orders)
						.add__0x10$util$ArrayList$$T$O(((t$34328)));
			}
		}

		// #line 80
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		return orders;
	}

	// #line 83
	// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
	public samples.ShockTransfer.ArbitrageAgent setupArbitrageAgent(
			final cassia.util.JSON.Value json, final plham.main.Simulator sim) {

		// #line 84
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final x10.util.Random t$34273 = this.getRandom();

		// #line 84
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final plham.util.JSONRandom random = ((new plham.util.JSONRandom(
				(java.lang.System[]) null)
				.plham$util$JSONRandom$$init$S(t$34273)));

		// #line 85
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final cassia.util.JSON.Value t$34274 = json
				.<java.lang.String> get(x10.rtt.Types.STRING,
						(("orderVolume")));

		// #line 85
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final long t$34275 = t$34274.toLong$O();

		// #line 85
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		this.orderVolume = t$34275;

		// #line 86
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final cassia.util.JSON.Value t$34276 = json
				.<java.lang.String> get(x10.rtt.Types.STRING,
						(("orderThresholdPrice")));

		// #line 86
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final double t$34277 = t$34276.toDouble$O();

		// #line 86
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		this.orderThresholdPrice = t$34277;

		// #line 88
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		assert (json.<java.lang.String> get(
				x10.rtt.Types.STRING, (("markets")))
				.size$O()) == (1L) : "ArbitrageAgents suppose only one IndexMarket";

		// #line 89
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		assert plham.IndexMarket.$RTT
				.isInstance(sim
						.getMarketByName(((json
								.<java.lang.String> get(x10.rtt.Types.STRING,
										(("markets")))
								.<x10.core.Long> get(x10.rtt.Types.LONG,
										x10.core.Long.$box(0L)))))) : "ArbitrageAgents suppose only one IndexMarket";

		// #line 90
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final cassia.util.JSON.Value t$34278 = json
				.<java.lang.String> get(x10.rtt.Types.STRING,
						(("markets")));

		// #line 90
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final cassia.util.JSON.Value t$34279 = t$34278
				.<x10.core.Long> get(x10.rtt.Types.LONG, x10.core.Long.$box(0L));

		// #line 90
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final plham.Market t$34280 = sim
				.getMarketByName(((t$34279)));

		// #line 90
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final plham.IndexMarket market = x10.rtt.Types
				.<plham.IndexMarket> cast(t$34280, plham.IndexMarket.$RTT);

		// #line 91
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		this.setMarketAccessible$O(((market)));

		// #line 92
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final x10.util.List t$34336 = market.getComponents();

		// #line 92
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final x10.util.ListIterator id$34337 = (((x10.util.List<x10.core.Long>) t$34336)
				.iterator());

		// #line 92
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		for (; true;) {

			// #line 92
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final boolean t$34338 = ((x10.util.ListIterator<x10.core.Long>) id$34337)
					.hasNext$O();

			// #line 92
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			if (!(t$34338)) {

				// #line 92
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				break;
			}

			// #line 92
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final long id$34331 = x10.core.Long
					.$unbox(((x10.util.ListIterator<x10.core.Long>) id$34337)
							.next$G());

			// #line 93
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			this.setMarketAccessible$O((id$34331));
		}

		// #line 96
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final cassia.util.JSON.Value t$34284 = json
				.<java.lang.String> get(x10.rtt.Types.STRING,
						(("assetVolume")));

		// #line 96
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final double t$34285 = random
				.nextRandom$O(((t$34284)));

		// #line 96
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final long t$34286 = ((long) (((t$34285))));

		// #line 96
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		this.setAssetVolume$O(((market)), (t$34286));

		// #line 97
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final x10.util.List t$34339 = market.getComponents();

		// #line 97
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final x10.util.ListIterator id$34340 = (((x10.util.List<x10.core.Long>) t$34339)
				.iterator());

		// #line 97
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		for (; true;) {

			// #line 97
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final boolean t$34341 = ((x10.util.ListIterator<x10.core.Long>) id$34340)
					.hasNext$O();

			// #line 97
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			if (!(t$34341)) {

				// #line 97
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				break;
			}

			// #line 97
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final long id$34332 = x10.core.Long
					.$unbox(((x10.util.ListIterator<x10.core.Long>) id$34340)
							.next$G());

			// #line 98
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final cassia.util.JSON.Value t$34333 = json
					.<java.lang.String> get(x10.rtt.Types.STRING,
							(("assetVolume")));

			// #line 98
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final double t$34334 = random
					.nextRandom$O(((t$34333)));

			// #line 98
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final long t$34335 = ((long) (((t$34334))));

			// #line 98
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			this.setAssetVolume((id$34332), (t$34335));
		}

		// #line 100
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final cassia.util.JSON.Value t$34293 = json
				.<java.lang.String> get(x10.rtt.Types.STRING,
						(("cashAmount")));

		// #line 100
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final double t$34294 = random
				.nextRandom$O(((t$34293)));

		// #line 100
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		this.setCashAmount((t$34294));

		// #line 101
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		return this;
	}

	// #line 104
	// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
	public static void register(final plham.main.Simulator sim) {

		// #line 105
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final java.lang.String className = (("ArbitrageAgent"));

		// #line 106
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final x10.core.fun.VoidFun_0_5 t$34309 = ((new samples.ShockTransfer.ArbitrageAgent.$Closure$28(
				sim)));

		// #line 106
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		sim.addAgentsInitializer__1$1x10$lang$String$3x10$util$Indexed$1x10$util$Random$2$3x10$lang$LongRange$3cassia$util$JSON$Value$3x10$lang$Settable$1x10$lang$Long$3plham$Agent$2$2(
				((className)),
				((t$34309)));
	}

	// #line 114
	// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
	public static samples.ShockTransfer.ArbitrageAgent createArbitrageAgent(
			final long id, final java.lang.String name,
			final x10.util.Random random, final cassia.util.JSON.Value json,
			final plham.main.Simulator sim) {

		// #line 115
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final samples.ShockTransfer.ArbitrageAgent t$34310 = ((new samples.ShockTransfer.ArbitrageAgent(
				(java.lang.System[]) null)
				.samples$ShockTransfer$ArbitrageAgent$$init$S(((id)),
						((name)),
						((random)))));

		// #line 115
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		final samples.ShockTransfer.ArbitrageAgent t$34311 = ((t$34310
				.setupArbitrageAgent(((json)),
						((sim)))));

		// #line 115
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		return t$34311;
	}

	// #line 15
	// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
	final public samples.ShockTransfer.ArbitrageAgent samples$ShockTransfer$ArbitrageAgent$$this$samples$ShockTransfer$ArbitrageAgent() {

		// #line 15
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		return samples.ShockTransfer.ArbitrageAgent.this;
	}

	// #line 15
	// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
	final public void __fieldInitializers_samples_ShockTransfer_ArbitrageAgent() {

		// #line 15
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		this.orderVolume = 0L;

		// #line 15
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		this.orderThresholdPrice = 0.0;

		// #line 15
		// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
		this.orderTimeLength = 0L;
	}

	@x10.runtime.impl.java.X10Generated
	final public static class $Closure$28 extends x10.core.Ref implements
			x10.core.fun.VoidFun_0_5, x10.serialization.X10JavaSerializable {
		public static final x10.rtt.RuntimeType<$Closure$28> $RTT = x10.rtt.StaticVoidFunType
				.<$Closure$28> make(
						$Closure$28.class,
						new x10.rtt.Type[] { x10.rtt.ParameterizedType.make(
								x10.core.fun.VoidFun_0_5.$RTT,
								x10.rtt.Types.STRING, x10.rtt.ParameterizedType
										.make(x10.util.Indexed.$RTT,
												x10.util.Random.$RTT),
								x10.lang.LongRange.$RTT,
								cassia.util.JSON.Value.$RTT,
								x10.rtt.ParameterizedType.make(
										x10.lang.Settable.$RTT,
										x10.rtt.Types.LONG, plham.Agent.$RTT)) });

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
				samples.ShockTransfer.ArbitrageAgent.$Closure$28 $_obj,
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			if (x10.runtime.impl.java.Runtime.TRACE_SER) {
				x10.runtime.impl.java.Runtime
						.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
								+ $Closure$28.class + " calling");
			}
			$_obj.sim = $deserializer.readObject();
			return $_obj;
		}

		public static x10.serialization.X10JavaSerializable $_deserializer(
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			samples.ShockTransfer.ArbitrageAgent.$Closure$28 $_obj = new samples.ShockTransfer.ArbitrageAgent.$Closure$28(
					(java.lang.System[]) null);
			$deserializer.record_reference($_obj);
			return $_deserialize_body($_obj, $deserializer);
		}

		public void $_serialize(x10.serialization.X10JavaSerializer $serializer)
				throws java.io.IOException {
			$serializer.write(this.sim);

		}

		// constructor just for allocation
		public $Closure$28(final java.lang.System[] $dummy) {

		}

		// dispatcher for method abstract public
		// (Z1,Z2,Z3,Z4,Z5)=>void.operator()(a1:Z1, a2:Z2, a3:Z3, a4:Z4,
		// a5:Z5):void
		public java.lang.Object $apply(final java.lang.Object a1,
				final x10.rtt.Type t1, final java.lang.Object a2,
				final x10.rtt.Type t2, final java.lang.Object a3,
				final x10.rtt.Type t3, final java.lang.Object a4,
				final x10.rtt.Type t4, final java.lang.Object a5,
				final x10.rtt.Type t5) {
			$apply__1$1x10$util$Random$2__4$1x10$lang$Long$3plham$Agent$2(
					(java.lang.String) a1, (x10.util.Indexed) a2,
					(x10.lang.LongRange) a3, (cassia.util.JSON.Value) a4,
					(x10.lang.Settable) a5);
			return null;

		}

		// dispatcher for method abstract public
		// (Z1,Z2,Z3,Z4,Z5)=>void.operator()(a1:Z1, a2:Z2, a3:Z3, a4:Z4,
		// a5:Z5):void
		public void $apply$V(final java.lang.Object a1, final x10.rtt.Type t1,
				final java.lang.Object a2, final x10.rtt.Type t2,
				final java.lang.Object a3, final x10.rtt.Type t3,
				final java.lang.Object a4, final x10.rtt.Type t4,
				final java.lang.Object a5, final x10.rtt.Type t5) {
			$apply__1$1x10$util$Random$2__4$1x10$lang$Long$3plham$Agent$2(
					(java.lang.String) a1, (x10.util.Indexed) a2,
					(x10.lang.LongRange) a3, (cassia.util.JSON.Value) a4,
					(x10.lang.Settable) a5);

		}

		public void $apply__1$1x10$util$Random$2__4$1x10$lang$Long$3plham$Agent$2(
				final java.lang.String name, final x10.util.Indexed randoms,
				final x10.lang.LongRange range,
				final cassia.util.JSON.Value json,
				final x10.lang.Settable container) {

			// #line 107
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final x10.lang.LongRange i$34212domain$34350 = ((range));

			// #line 107
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final long i$34212min$34351 = i$34212domain$34350.min;

			// #line 107
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final long i$34212max$34352 = i$34212domain$34350.max;

			// #line 107
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			long i$34347 = i$34212min$34351;

			// #line 107
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			for (; true;) {

				// #line 107
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final long t$34348 = i$34347;

				// #line 107
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final boolean t$34349 = ((t$34348) <= (((i$34212max$34352))));

				// #line 107
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				if (!(t$34349)) {

					// #line 107
					// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
					break;
				}

				// #line 107
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final long i$34344 = i$34347;

				// #line 108
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final x10.util.Random t$34342 = ((x10.util.Indexed<x10.util.Random>) randoms)
						.$apply$G((i$34344));

				// #line 108
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final samples.ShockTransfer.ArbitrageAgent t$34343 = samples.ShockTransfer.ArbitrageAgent
						.createArbitrageAgent((i$34344),
								((name)),
								((t$34342)),
								((json)),
								((this.sim)));

				// #line 108
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				((x10.lang.Settable<x10.core.Long, plham.Agent>) container)
						.$set(x10.core.Long.$box(i$34344), x10.rtt.Types.LONG,
								((t$34343)), plham.Agent.$RTT);

				// #line 107
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final long t$34345 = i$34347;

				// #line 107
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				final long t$34346 = ((t$34345) + (((1L))));

				// #line 107
				// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
				i$34347 = t$34346;
			}

			// #line 110
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final x10.io.Printer t$34307 = ((x10.io.Console
					.get$OUT()));

			// #line 110
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final cassia.util.JSON.Value t$34302 = json
					.<java.lang.String> get(x10.rtt.Types.STRING,
							(("class")));

			// #line 110
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final java.lang.String t$34303 = t$34302.toString();

			// #line 110
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final java.lang.String t$34304 = (("# ") + (t$34303));

			// #line 110
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final java.lang.String t$34305 = ((t$34304) + (" : "));

			// #line 110
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final java.lang.String t$34306 = plham.util.JSON
					.dump(((json)));

			// #line 110
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			final java.lang.String t$34308 = ((t$34305) + (t$34306));

			// #line 110
			// "/home/dsl/workspace/plhamK/samples/ShockTransfer/ArbitrageAgent.x10"
			t$34307.println(((t$34308)));
		}

		public plham.main.Simulator sim;

		public $Closure$28(final plham.main.Simulator sim) {
			{
				this.sim = ((sim));
			}
		}

	}

}
