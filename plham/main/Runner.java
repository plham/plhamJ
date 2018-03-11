package plham.main;

/**
 * A base class for execution models. See {@link plham.main.Simulator} for
 * simulation models. This class is basically for system developers.
 */
@x10.runtime.impl.java.X10Generated
abstract public class Runner<$B> extends x10.core.Ref implements
		x10.serialization.X10JavaSerializable {
	public static final x10.rtt.RuntimeType<Runner> $RTT = x10.rtt.NamedType
			.<Runner> make("plham.main.Runner", Runner.class, 1);

	public x10.rtt.RuntimeType<?> $getRTT() {
		return $RTT;
	}

	public x10.rtt.Type<?> $getParam(int i) {
		if (i == 0)
			return $B;
		return null;
	}

	public static <$B> x10.serialization.X10JavaSerializable $_deserialize_body(
			plham.main.Runner<$B> $_obj,
			x10.serialization.X10JavaDeserializer $deserializer)
			throws java.io.IOException {
		if (x10.runtime.impl.java.Runtime.TRACE_SER) {
			x10.runtime.impl.java.Runtime
					.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
							+ Runner.class + " calling");
		}
		$_obj.$B = (x10.rtt.Type) $deserializer.readObject();
		$_obj._PROFILE = $deserializer.readBoolean();
		$_obj.sim = $deserializer.readObject();
		return $_obj;
	}

	public static x10.serialization.X10JavaSerializable $_deserializer(
			x10.serialization.X10JavaDeserializer $deserializer)
			throws java.io.IOException {
		return null;
	}

	public void $_serialize(x10.serialization.X10JavaSerializer $serializer)
			throws java.io.IOException {
		$serializer.write(this.$B);
		$serializer.write(this._PROFILE);
		$serializer.write(this.sim);

	}

	// constructor just for allocation
	public Runner(final java.lang.System[] $dummy, final x10.rtt.Type $B) {
		plham.main.Runner.$initParams(this, $B);

	}

	private x10.rtt.Type $B;

	// initializer of type parameters
	public static void $initParams(final Runner $this, final x10.rtt.Type $B) {
		$this.$B = $B;

	}

	// synthetic type for parameter mangling
	public static final class __0plham$main$Runner$$B {
	}

	// #line 39 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
	public $B sim;

	// #line 41 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
	public boolean _PROFILE;

	// #line 43 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
	final public static boolean useTeam = true;

	// #line 45 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
	private static double HIFREQ_SUBMIT_RATE = 0.0;

	// #line 47 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"

	// constructor for non-virtual call
	final public plham.main.Runner<$B> plham$main$Runner$$init$S(final $B sim,
			__0plham$main$Runner$$B $dummy) {
		{

			// #line 47 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"

			// #line 37 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			this.__fieldInitializers_plham_main_Runner();

			// #line 48 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			this.sim = ((sim));

			// #line 49 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			plham.agent.FCNAgent
					.register(((((plham.main.Simulator) sim))));

			// #line 50 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			samples.ShockTransfer.ArbitrageAgent
					.register(((((plham.main.Simulator) sim))));

			// #line 51 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			plham.Market
					.register(((((plham.main.Simulator) sim))));

			// #line 52 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			plham.IndexMarket
					.register(((((plham.main.Simulator) sim))));

			// #line 53 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			plham.event.FundamentalPriceShock
					.register(((((plham.main.Simulator) sim))));

			// #line 54 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			plham.event.OrderMistakeShock
					.register(((((plham.main.Simulator) sim))));

			// #line 55 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			plham.event.TradingHaltRule
					.register(((((plham.main.Simulator) sim))));

			// #line 56 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			plham.event.PriceLimitRule
					.register(((((plham.main.Simulator) sim))));
		}
		return this;
	}

	// #line 59 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
	public plham.Env env() {

		// #line 59 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final $B t$26889 = ((this.sim));

		// #line 59 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		return ((plham.Env) t$26889);
	}

	// #line 61 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
	public x10.util.List handleOrders__0$1x10$util$List$1plham$Order$2$2(
			final x10.util.List localOrders, final long MAX_HIFREQ_ORDERS) {

		// #line 62 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final plham.Env env = this.env();

		// #line 63 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long beginTime = x10.lang.System.nanoTime$O();

		// #line 64 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.ArrayList allOrders = ((new x10.util.ArrayList<x10.util.List<plham.Order>>(
				(java.lang.System[]) null, x10.rtt.ParameterizedType.make(
						x10.util.List.$RTT, plham.Order.$RTT))
				.x10$util$ArrayList$$init$S()));

		// #line 65 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.List markets = ((env.markets));

		// #line 67 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final $B t$26890 = ((this.sim));

		// #line 67 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.Random random = ((plham.main.Simulator) x10.rtt.Types
				.conversion(plham.main.Simulator.$RTT, t$26890)).getRandom();

		// #line 68 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long t$26891 = x10.lang.System.nanoTime$O();

		// #line 68 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.Random tmpRandom = ((new x10.util.Random(
				(java.lang.System[]) null).x10$util$Random$$init$S(t$26891)));

		// #line 69 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.List agents = ((env.hifreqAgents));

		// #line 70 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final cassia.util.random.RandomPermutation randomAgents = ((new cassia.util.random.RandomPermutation<plham.Agent>(
				(java.lang.System[]) null, plham.Agent.$RTT)
				.cassia$util$random$RandomPermutation$$init$S(
						((random)),
						((agents)),
						(cassia.util.random.RandomPermutation.__1$1cassia$util$random$RandomPermutation$$T$2) null)));

		// #line 71 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final cassia.util.random.RandomPermutation randomOrders = ((new cassia.util.random.RandomPermutation<x10.util.List<plham.Order>>(
				(java.lang.System[]) null, x10.rtt.ParameterizedType.make(
						x10.util.List.$RTT, plham.Order.$RTT))
				.cassia$util$random$RandomPermutation$$init$S(
						((random)),
						((localOrders)),
						(cassia.util.random.RandomPermutation.__1$1cassia$util$random$RandomPermutation$$T$2) null)));

		// #line 73 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		((cassia.util.random.RandomPermutation<x10.util.List<plham.Order>>) randomOrders)
				.shuffle();

		// #line 74 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.lang.Iterator someOrders$27097 = (((cassia.util.random.RandomPermutation<x10.util.List<plham.Order>>) randomOrders)
				.iterator());

		// #line 74 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		for (; true;) {

			// #line 74 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final boolean t$27098 = ((x10.lang.Iterator<x10.util.List<plham.Order>>) someOrders$27097)
					.hasNext$O();

			// #line 74 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (!(t$27098)) {

				// #line 74 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				break;
			}

			// #line 74 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			L$27099: {

				// #line 74 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final x10.util.List someOrders$27100 = ((((x10.lang.Iterator<x10.util.List<plham.Order>>) someOrders$27097)
						.next$G()));
				// #line 77 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final x10.util.ListIterator order$27093 = (((x10.util.List<plham.Order>) someOrders$27100)
						.iterator());
				// #line 77 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				for (; true;) {

					// #line 77
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					final boolean t$27094 = ((x10.util.ListIterator<plham.Order>) order$27093)
							.hasNext$O();

					// #line 77
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					if (!(t$27094)) {

						// #line 77
						// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
						break;
					}

					// #line 77
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					final plham.Order order$27073 = ((((x10.util.ListIterator<plham.Order>) order$27093)
							.next$G()));

					// #line 78
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					final x10.util.List t$27074 = ((env.markets));

					// #line 78
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					final long t$27075 = order$27073.marketId;

					// #line 78
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					final plham.Market m$27076 = ((x10.util.Indexed<plham.Market>) t$27074)
							.$apply$G((t$27075));

					// #line 79
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					m$27076.triggerBeforeOrderHandlingEvents(((order$27073)));

					// #line 80
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					m$27076.handleOrder(((order$27073)));

					// #line 81
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					m$27076.triggerAfterOrderHandlingEvents(((order$27073)));

					// #line 82
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					m$27076.tickUpdateMarketPrice();
				}
				// #line 85 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final double t$27101 = plham.main.Runner
						.get$HIFREQ_SUBMIT_RATE();
				// #line 85 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final double t$27102 = tmpRandom.nextDouble$O();
				// #line 85 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final boolean t$27103 = ((t$27101) < (((t$27102))));
				// #line 85 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				if (t$27103) {

					// #line 86
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					break L$27099;
				}
				// #line 89 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				long k$27104 = 0L;
				// #line 90 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				((cassia.util.random.RandomPermutation<plham.Agent>) randomAgents)
						.shuffle();
				// #line 91 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final x10.lang.Iterator agent$27095 = (((cassia.util.random.RandomPermutation<plham.Agent>) randomAgents)
						.iterator());
				// #line 91 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				for (; true;) {

					// #line 91
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					final boolean t$27096 = ((x10.lang.Iterator<plham.Agent>) agent$27095)
							.hasNext$O();

					// #line 91
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					if (!(t$27096)) {

						// #line 91
						// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
						break;
					}

					// #line 91
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					final plham.Agent agent$27083 = ((((x10.lang.Iterator<plham.Agent>) agent$27095)
							.next$G()));

					// #line 92
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					final long t$27084 = k$27104;

					// #line 92
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					final boolean t$27085 = ((t$27084) >= (((MAX_HIFREQ_ORDERS))));

					// #line 92
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					if (t$27085) {

						// #line 93
						// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
						break;
					}

					// #line 95
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					final x10.util.List orders$27086 = agent$27083
							.submitOrders(((markets)));

					// #line 96
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					final boolean t$27087 = ((x10.util.Container<plham.Order>) orders$27086)
							.isEmpty$O();

					// #line 96
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					final boolean t$27088 = !(t$27087);

					// #line 96
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					if (t$27088) {

						// #line 96
						// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
						((x10.util.ArrayList<x10.util.List<plham.Order>>) allOrders)
								.add__0x10$util$ArrayList$$T$O(((orders$27086)));
					}

					// #line 98
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					final long t$27089 = ((x10.util.Container<plham.Order>) orders$27086)
							.size$O();

					// #line 98
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					final boolean t$27090 = ((t$27089) > (((0L))));

					// #line 98
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					if (t$27090) {

						// #line 99
						// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
						final x10.util.ListIterator order$27081 = (((x10.util.List<plham.Order>) orders$27086)
								.iterator());

						// #line 99
						// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
						for (; true;) {

							// #line 99
							// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
							final boolean t$27082 = ((x10.util.ListIterator<plham.Order>) order$27081)
									.hasNext$O();

							// #line 99
							// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
							if (!(t$27082)) {

								// #line 99
								// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
								break;
							}

							// #line 99
							// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
							final plham.Order order$27077 = ((((x10.util.ListIterator<plham.Order>) order$27081)
									.next$G()));

							// #line 100
							// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
							final x10.util.List t$27078 = ((env.markets));

							// #line 100
							// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
							final long t$27079 = order$27077.marketId;

							// #line 100
							// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
							final plham.Market m$27080 = ((x10.util.Indexed<plham.Market>) t$27078)
									.$apply$G((t$27079));

							// #line 101
							// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
							m$27080.triggerBeforeOrderHandlingEvents(((order$27077)));

							// #line 102
							// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
							m$27080.handleOrder(((order$27077)));

							// #line 103
							// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
							m$27080.triggerAfterOrderHandlingEvents(((order$27077)));

							// #line 104
							// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
							m$27080.tickUpdateMarketPrice();
						}

						// #line 106
						// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
						final long t$27091 = k$27104;

						// #line 106
						// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
						final long t$27092 = ((t$27091) + (((1L))));

						// #line 106
						// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
						k$27104 = t$27092;
					}
				}
			}
		}

		// #line 111 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long endTime = x10.lang.System.nanoTime$O();

		// #line 112 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final boolean t$26929 = this._PROFILE;

		// #line 112 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		if (t$26929) {

			// #line 113 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final x10.io.Printer t$26919 = ((x10.io.Console
					.get$OUT()));

			// #line 113 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long t$26915 = ((endTime) - (((beginTime))));

			// #line 113 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final double t$26916 = ((((t$26915))));

			// #line 113 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final double t$26917 = ((t$26916) / (((1.0E9))));

			// #line 113 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final java.lang.String t$26918 = (("#PROFILE ORDER-EXEC TOTAL ") + ((x10.core.Double
					.$box(t$26917))));

			// #line 113 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final java.lang.String t$26920 = ((t$26918) + (" sec"));

			// #line 113 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			t$26919.println(((t$26920)));

			// #line 114 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final x10.io.Printer t$26924 = ((x10.io.Console
					.get$OUT()));

			// #line 114 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final java.lang.String t$26921 = (("#PROFILE MAX-HIFREQ-ORDERS ") + ((x10.core.Long
					.$box(MAX_HIFREQ_ORDERS))));

			// #line 114 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final java.lang.String t$26922 = ((t$26921) + (" x "));

			// #line 114 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long t$26923 = ((x10.util.Container<x10.util.List<plham.Order>>) localOrders)
					.size$O();

			// #line 114 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final java.lang.String t$26925 = ((t$26922) + ((x10.core.Long
					.$box(t$26923))));

			// #line 114 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			t$26924.println(((t$26925)));

			// #line 115 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final x10.io.Printer t$26927 = ((x10.io.Console
					.get$OUT()));

			// #line 115 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long t$26926 = ((x10.util.ArrayList<x10.util.List<plham.Order>>) allOrders)
					.size$O();

			// #line 115 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final java.lang.String t$26928 = (("#PROFILE NUM-HIFREQ-ORDERS ") + ((x10.core.Long
					.$box(t$26926))));

			// #line 115 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			t$26927.println(((t$26928)));
		}

		// #line 117 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		return allOrders;
	}

	// #line 120 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
	public void syncCheck__0$1plham$Market$2(final x10.util.List markets) {

		// #line 121 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final plham.Env env = this.env();

		// #line 122 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long N_PLACES = (x10.x10rt.X10RT.numPlaces());

		// #line 123 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.ListIterator m$27117 = (((x10.util.List<plham.Market>) markets)
				.iterator());

		// #line 123 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		for (; true;) {

			// #line 123 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final boolean t$27118 = ((x10.util.ListIterator<plham.Market>) m$27117)
					.hasNext$O();

			// #line 123 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (!(t$27118)) {

				// #line 123 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				break;
			}

			// #line 123 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final plham.Market m$27105 = ((((x10.util.ListIterator<plham.Market>) m$27117)
					.next$G()));

			// #line 124 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long id$27106 = m$27105.id;

			// #line 125 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final x10.util.List t$27107 = ((env.markets));

			// #line 125 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final plham.Market t$27108 = ((x10.util.Indexed<plham.Market>) t$27107)
					.$apply$G((id$27106));

			// #line 125 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final double price$27109 = t$27108.getPrice$O();

			// #line 126 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final x10.util.List t$27110 = ((env.markets));

			// #line 126 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final plham.Market t$27111 = ((x10.util.Indexed<plham.Market>) t$27110)
					.$apply$G((id$27106));

			// #line 126 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final x10.util.ArrayList t$27112 = ((t$27111.marketPrices));

			// #line 126 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long size$27113 = ((x10.util.ArrayList<x10.core.Double>) t$27112)
					.size$O();

			// #line 127 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final x10.util.List t$27114 = ((env.markets));

			// #line 127 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final plham.Market t$27115 = ((x10.util.Indexed<plham.Market>) t$27114)
					.$apply$G((id$27106));

			// #line 127 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long time$27116 = t$27115.getTime$O();
		}

		// #line 129 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.io.Printer t$26939 = ((x10.io.Console
				.get$OUT()));

		// #line 129 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		t$26939.println((("#SyncCheck: OK")));
	}

	// #line 132 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
	abstract public void updateMarkets(final long maxNormalOrders,
			final long maxHifreqOrders, final boolean diffPass);

	// #line 135 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
	public void iterateMarketUpdates(final java.lang.String sessionName,
			final long iterationSteps, final boolean withOrderPlacement,
			final boolean withOrderExecution, final boolean withPrint,
			final boolean forDummyTimeseries, final long maxNormalOrders,
			final long maxHifreqOrders, final plham.Fundamentals fundamentals) {

		// #line 140 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final plham.Env env = this.env();

		// #line 141 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.List markets = ((env.markets));

		// #line 142 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.ListIterator market$27142 = (((x10.util.List<plham.Market>) markets)
				.iterator());

		// #line 142 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		for (; true;) {

			// #line 142 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final boolean t$27143 = ((x10.util.ListIterator<plham.Market>) market$27142)
					.hasNext$O();

			// #line 142 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (!(t$27143)) {

				// #line 142 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				break;
			}

			// #line 142 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final plham.Market market$27119 = ((((x10.util.ListIterator<plham.Market>) market$27142)
					.next$G()));

			// #line 143 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			market$27119.setRunning$O((withOrderExecution));
		}

		// #line 145 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.ListIterator market$27144 = (((x10.util.List<plham.Market>) markets)
				.iterator());

		// #line 145 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		for (; true;) {

			// #line 145 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final boolean t$27145 = ((x10.util.ListIterator<plham.Market>) market$27144)
					.hasNext$O();

			// #line 145 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (!(t$27145)) {

				// #line 145 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				break;
			}

			// #line 145 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final plham.Market market$27120 = ((((x10.util.ListIterator<plham.Market>) market$27144)
					.next$G()));

			// #line 147 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			market$27120.itayoseOrderBooks();
		}

		// #line 149 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.ListIterator market$27146 = (((x10.util.List<plham.Market>) markets)
				.iterator());

		// #line 149 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		for (; true;) {

			// #line 149 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final boolean t$27147 = ((x10.util.ListIterator<plham.Market>) market$27146)
					.hasNext$O();

			// #line 149 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (!(t$27147)) {

				// #line 149 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				break;
			}

			// #line 149 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final plham.Market market$27121 = ((((x10.util.ListIterator<plham.Market>) market$27146)
					.next$G()));

			// #line 150 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			market$27121.check();
		}

		// #line 153 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long i$26850min$27148 = 1L;

		// #line 153 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long i$26850max$27149 = iterationSteps;

		// #line 153 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		long i$27139 = i$26850min$27148;

		// #line 153 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		for (; true;) {

			// #line 153 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long t$27140 = i$27139;

			// #line 153 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final boolean t$27141 = ((t$27140) <= (((i$26850max$27149))));

			// #line 153 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (!(t$27141)) {

				// #line 153 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				break;
			}

			// #line 153 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long t$27136 = i$27139;

			// #line 154 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final $B t$27131 = ((this.sim));

			// #line 154 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			((plham.main.Simulator) x10.rtt.Types.conversion(
					plham.main.Simulator.$RTT, t$27131))
					.updateFundamentals(((fundamentals)));

			// #line 155 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final x10.util.ListIterator market$27125 = (((x10.util.List<plham.Market>) markets)
					.iterator());

			// #line 155 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			for (; true;) {

				// #line 155 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final boolean t$27126 = ((x10.util.ListIterator<plham.Market>) market$27125)
						.hasNext$O();

				// #line 155 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				if (!(t$27126)) {

					// #line 155
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					break;
				}

				// #line 155 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final plham.Market market$27122 = ((((x10.util.ListIterator<plham.Market>) market$27125)
						.next$G()));

				// #line 156 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				market$27122.triggerBeforeSimulationStepEvents();
			}

			// #line 159 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (withOrderPlacement) {

				// #line 160 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final boolean t$27132 = ((t$27136) > (((0L))));

				// #line 160 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				this.updateMarkets((maxNormalOrders),
						(maxHifreqOrders), (t$27132));
			}

			// #line 163 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (forDummyTimeseries) {

				// #line 164 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final $B t$27133 = ((this.sim));

				// #line 164 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				((plham.main.Simulator) x10.rtt.Types.conversion(
						plham.main.Simulator.$RTT, t$27133))
						.updateMarketsUsingFundamentalPrice__0$1plham$Market$2(
								((markets)),
								((fundamentals)));
			} else {

				// #line 166 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final $B t$27134 = ((this.sim));

				// #line 166 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				((plham.main.Simulator) x10.rtt.Types.conversion(
						plham.main.Simulator.$RTT, t$27134))
						.updateMarketsUsingMarketPrice__0$1plham$Market$2(
								((markets)),
								((fundamentals)));
			}

			// #line 169 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (withPrint) {

				// #line 170 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final $B t$27135 = ((this.sim));

				// #line 170 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				((plham.main.Simulator) x10.rtt.Types.conversion(
						plham.main.Simulator.$RTT, t$27135))
						.print(((sessionName)));
			}

			// #line 173 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final x10.util.ListIterator market$27127 = (((x10.util.List<plham.Market>) markets)
					.iterator());

			// #line 173 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			for (; true;) {

				// #line 173 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final boolean t$27128 = ((x10.util.ListIterator<plham.Market>) market$27127)
						.hasNext$O();

				// #line 173 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				if (!(t$27128)) {

					// #line 173
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					break;
				}

				// #line 173 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final plham.Market market$27123 = ((plham.Market) (((x10.util.ListIterator<plham.Market>) market$27127)
						.next$G()));

				// #line 174 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				market$27123.triggerAfterSimulationStepEvents();
			}

			// #line 177 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final x10.util.ListIterator market$27129 = ((x10.util.ListIterator<plham.Market>) ((x10.util.List<plham.Market>) markets)
					.iterator());

			// #line 177 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			for (; true;) {

				// #line 177 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final boolean t$27130 = ((x10.util.ListIterator<plham.Market>) market$27129)
						.hasNext$O();

				// #line 177 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				if (!(t$27130)) {

					// #line 177
					// "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
					break;
				}

				// #line 177 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final plham.Market market$27124 = ((plham.Market) (((x10.util.ListIterator<plham.Market>) market$27129)
						.next$G()));

				// #line 178 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				market$27124.updateTime$O();

				// #line 179 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				market$27124.updateOrderBooks();
			}

			// #line 153 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long t$27137 = i$27139;

			// #line 153 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long t$27138 = ((t$27137) + (((long) (1L))));

			// #line 153 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			i$27139 = t$27138;
		}

		// #line 183 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		if (withPrint) {

			// #line 184 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final $B t$26962 = (($B) (this.sim));

			// #line 184 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			((plham.main.Simulator) x10.rtt.Types.conversion(
					plham.main.Simulator.$RTT, t$26962))
					.endprint(((java.lang.String) (sessionName)),
							(long) (iterationSteps));
		}
	}

	// #line 188 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
	public void setupEnv__0$1plham$Market$2__1$1plham$Agent$2(
			final x10.util.List markets, final x10.util.List agents) {

		// #line 189 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final plham.Env env = this.env();

		// #line 190 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.ArrayList normalAgents = ((x10.util.ArrayList) (new x10.util.ArrayList<plham.Agent>(
				(java.lang.System[]) null, plham.Agent.$RTT)
				.x10$util$ArrayList$$init$S()));

		// #line 191 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.ArrayList hifreqAgents = ((x10.util.ArrayList) (new x10.util.ArrayList<plham.Agent>(
				(java.lang.System[]) null, plham.Agent.$RTT)
				.x10$util$ArrayList$$init$S()));

		// #line 192 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.ListIterator a$27153 = ((x10.util.ListIterator<plham.Agent>) ((x10.util.List<plham.Agent>) agents)
				.iterator());

		// #line 192 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		for (; true;) {

			// #line 192 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final boolean t$27154 = ((x10.util.ListIterator<plham.Agent>) a$27153)
					.hasNext$O();

			// #line 192 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (!(t$27154)) {

				// #line 192 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				break;
			}

			// #line 192 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final plham.Agent a$27150 = ((plham.Agent) (((x10.util.ListIterator<plham.Agent>) a$27153)
					.next$G()));

			// #line 193 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final boolean t$27151 = plham.HighFrequencyAgent.$RTT
					.isInstance(a$27150);

			// #line 193 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (t$27151) {

				// #line 194 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				((x10.util.ArrayList<plham.Agent>) hifreqAgents)
						.add__0x10$util$ArrayList$$T$O(((plham.Agent) (a$27150)));
			} else {

				// #line 196 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				((x10.util.ArrayList<plham.Agent>) normalAgents)
						.add__0x10$util$ArrayList$$T$O(((plham.Agent) (a$27150)));
			}
		}

		// #line 200 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.ListIterator m$27155 = ((x10.util.ListIterator<plham.Market>) ((x10.util.List<plham.Market>) markets)
				.iterator());

		// #line 200 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		for (; true;) {

			// #line 200 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final boolean t$27156 = ((x10.util.ListIterator<plham.Market>) m$27155)
					.hasNext$O();

			// #line 200 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (!(t$27156)) {

				// #line 200 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				break;
			}

			// #line 200 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final plham.Market m$27152 = ((plham.Market) (((x10.util.ListIterator<plham.Market>) m$27155)
					.next$G()));

			// #line 200 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			m$27152.env = ((plham.Env) (env));
		}

		// #line 201 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		env.markets = ((x10.util.List) (markets));

		// #line 202 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		env.agents = ((x10.util.List) (agents));

		// #line 203 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		env.normalAgents = ((x10.util.List) (normalAgents));

		// #line 204 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		env.hifreqAgents = ((x10.util.List) (hifreqAgents));
	}

	// #line 206 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
	public void run(final x10.core.Rail args) {

		// #line 207 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long t$26968 = ((x10.core.Rail<java.lang.String>) args).size;

		// #line 207 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final boolean t$26970 = ((t$26968) < (((long) (1L))));

		// #line 207 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		if (t$26970) {

			// #line 208 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final java.lang.RuntimeException t$26969 = ((java.lang.RuntimeException) (new java.lang.RuntimeException(
					"Usage: ./a.out config.json [SEED]")));

			// #line 208 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			throw t$26969;
		}

		// #line 211 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long seed;

		// #line 212 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long t$26971 = ((x10.core.Rail<java.lang.String>) args).size;

		// #line 212 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final boolean t$26978 = ((t$26971) > (((long) (1L))));

		// #line 212 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		if (t$26978) {

			// #line 213 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final java.lang.String t$26972 = ((java.lang.String[]) args.value)[(int) 1L];

			// #line 213 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long t$26973 = java.lang.Long.parseLong(t$26972);

			// #line 213 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			seed = t$26973;
		} else {

			// #line 215 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final x10.util.Random t$26975 = ((x10.util.Random) (new x10.util.Random(
					(java.lang.System[]) null).x10$util$Random$$init$S()));

			// #line 215 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long t$26974 = java.lang.Long.MAX_VALUE;

			// #line 215 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long t$26976 = ((t$26974) / (((long) (2L))));

			// #line 215 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long t$26977 = t$26975.nextLong$O((long) (t$26976));

			// #line 215 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			seed = t$26977;
		}

		// #line 218 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.io.Printer t$26980 = ((x10.io.Printer) (x10.io.Console
				.get$OUT()));

		// #line 218 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final java.lang.String t$26979 = plham.Env
				.getenvOrElse(((java.lang.String) ("X10_NPLACES")),
						((java.lang.String) ("")));

		// #line 218 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final java.lang.String t$26981 = (("# X10_NPLACES  ") + (t$26979));

		// #line 218 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		t$26980.println(((java.lang.Object) (t$26981)));

		// #line 219 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.io.Printer t$26983 = ((x10.io.Printer) (x10.io.Console
				.get$OUT()));

		// #line 219 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final java.lang.String t$26982 = plham.Env.getenvOrElse(
				((java.lang.String) ("X10_NTHREADS")),
				((java.lang.String) ("")));

		// #line 219 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final java.lang.String t$26984 = (("# X10_NTHREADS ") + (t$26982));

		// #line 219 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		t$26983.println(((java.lang.Object) (t$26984)));

		// #line 221 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long TIME_THE_BEGINNING = x10.lang.System.nanoTime$O();

		// #line 223 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.HashMap GLOBAL = ((x10.util.HashMap) (new x10.util.HashMap<java.lang.String, java.lang.Object>(
				(java.lang.System[]) null, x10.rtt.Types.STRING,
				x10.rtt.Types.ANY).x10$util$HashMap$$init$S()));

		// #line 224 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final $B t$26985 = (($B) (this.sim));

		// #line 224 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		((plham.main.Simulator) t$26985).GLOBAL = ((x10.util.Map) (GLOBAL));

		// #line 225 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final java.lang.String t$26986 = ((java.lang.String[]) args.value)[(int) 0L];

		// #line 225 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.io.File t$26987 = ((x10.io.File) (new x10.io.File(
				(java.lang.System[]) null).x10$io$File$$init$S(t$26986)));

		// #line 225 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final cassia.util.JSON.Value CONFIG = ((cassia.util.JSON.Value) (plham.util.JSON
				.parse(((x10.io.File) (t$26987)))));

		// #line 226 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final $B t$26988 = (($B) (this.sim));

		// #line 226 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		((plham.main.Simulator) t$26988).CONFIG = ((cassia.util.JSON.Value) (CONFIG));

		// #line 227 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		plham.util.JSON.extendDeeply(((cassia.util.JSON.Value) (CONFIG)),
				((cassia.util.JSON.Value) (CONFIG)));

		// #line 229 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.Random RANDOM = ((x10.util.Random) (new x10.util.Random(
				(java.lang.System[]) null)
				.x10$util$Random$$init$S(((long) (seed)))));

		// #line 230 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final $B t$26989 = (($B) (this.sim));

		// #line 230 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		((plham.main.Simulator) t$26989).RANDOM = ((x10.util.Random) (RANDOM));

		// #line 231 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.io.Printer t$26990 = ((x10.io.Printer) (x10.io.Console
				.get$OUT()));

		// #line 231 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final java.lang.String t$26991 = (("# Random.seed ") + ((x10.core.Long
				.$box(seed))));

		// #line 231 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		t$26990.println(((java.lang.Object) (t$26991)));

		// #line 235 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final $B t$26993 = (($B) (this.sim));

		// #line 235 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final cassia.util.JSON.Value t$26992 = ((cassia.util.JSON.Value) CONFIG)
				.<java.lang.String> get(x10.rtt.Types.STRING,
						((java.lang.String) ("simulation")));

		// #line 235 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final cassia.util.JSON.Value t$26994 = ((cassia.util.JSON.Value) t$26992)
				.<java.lang.String> get(x10.rtt.Types.STRING,
						((java.lang.String) ("markets")));

		// #line 235 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.List markets = ((plham.main.Simulator) x10.rtt.Types
				.conversion(plham.main.Simulator.$RTT, t$26993))
				.createAllMarkets(((cassia.util.JSON.Value) (t$26994)));

		// #line 237 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.ArrayList mrange = ((x10.util.ArrayList) (new x10.util.ArrayList<x10.lang.LongRange>(
				(java.lang.System[]) null, x10.lang.LongRange.$RTT)
				.x10$util$ArrayList$$init$S()));

		// #line 237 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long t$26995 = ((x10.util.Container<plham.Market>) markets)
				.size$O();

		// #line 237 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long t$26996 = ((t$26995) - (((long) (1L))));

		// #line 237 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.lang.LongRange t$26997 = ((x10.lang.LongRange) (new x10.lang.LongRange(
				(java.lang.System[]) null).x10$lang$LongRange$$init$S(
				((long) (0L)), ((long) (t$26996)))));

		// #line 237 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		((x10.util.ArrayList<x10.lang.LongRange>) mrange)
				.add__0x10$util$ArrayList$$T$O(((x10.lang.LongRange) (t$26997)));

		// #line 238 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final $B t$26998 = (($B) (this.sim));

		// #line 238 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.Map t$26999 = ((x10.util.Map) (((plham.main.Simulator) t$26998).marketName2Ranges));

		// #line 238 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		((x10.util.Map<java.lang.String, x10.util.List<x10.lang.LongRange>>) t$26999)
				.$set(((java.lang.String) ("markets")), x10.rtt.Types.STRING,
						((x10.util.List) (mrange)), x10.rtt.ParameterizedType
								.make(x10.util.List.$RTT,
										x10.lang.LongRange.$RTT));

		// #line 240 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.io.Printer t$27001 = ((x10.io.Printer) (x10.io.Console
				.get$OUT()));

		// #line 240 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long t$27000 = ((x10.util.Container<plham.Market>) markets)
				.size$O();

		// #line 240 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final java.lang.String t$27002 = (("# #(markets) ") + ((x10.core.Long
				.$box(t$27000))));

		// #line 240 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		t$27001.println(((java.lang.Object) (t$27002)));

		// #line 243 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final plham.util.CentricAllocManager dm = ((plham.util.CentricAllocManager) (new plham.util.CentricAllocManager<plham.Agent>(
				(java.lang.System[]) null, plham.Agent.$RTT)
				.plham$util$CentricAllocManager$$init$S()));

		// #line 244 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final $B t$27004 = (($B) (this.sim));

		// #line 244 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final cassia.util.JSON.Value t$27003 = ((cassia.util.JSON.Value) CONFIG)
				.<java.lang.String> get(x10.rtt.Types.STRING,
						((java.lang.String) ("simulation")));

		// #line 244 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final cassia.util.JSON.Value t$27005 = ((cassia.util.JSON.Value) t$27003)
				.<java.lang.String> get(x10.rtt.Types.STRING,
						((java.lang.String) ("agents")));

		// #line 244 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		((plham.main.Simulator) x10.rtt.Types.conversion(
				plham.main.Simulator.$RTT, t$27004))
				.createAllAgents__1$1plham$Agent$2(
						((cassia.util.JSON.Value) (t$27005)),
						((plham.util.DistAllocManager) (dm)));

		// #line 245 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.List t$27006 = ((x10.util.List) (((x10.util.List<plham.Agent>) ((plham.util.CentricAllocManager<plham.Agent>) dm)
				.getBody())));

		// #line 245 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		((x10.util.HashMap<java.lang.String, java.lang.Object>) GLOBAL)
				.$set__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(
						((java.lang.String) ("agents")),
						((java.lang.Object) (t$27006)));

		// #line 249 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final $B t$27008 = (($B) (this.sim));

		// #line 249 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final cassia.util.JSON.Value t$27007 = ((cassia.util.JSON.Value) CONFIG)
				.<java.lang.String> get(x10.rtt.Types.STRING,
						((java.lang.String) ("simulation")));

		// #line 249 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final cassia.util.JSON.Value t$27009 = ((cassia.util.JSON.Value) t$27007)
				.<java.lang.String> $apply__0cassia$util$JSON$Value$$T(
						x10.rtt.Types.STRING,
						((java.lang.String) ("fundamentalCorrelations")),
						((java.lang.String) ("{}")));

		// #line 249 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final plham.Fundamentals fundamentals = ((plham.main.Simulator) x10.rtt.Types
				.conversion(plham.main.Simulator.$RTT, t$27008))
				.createFundamentals__0$1plham$Market$2(
						((x10.util.List) (markets)),
						((cassia.util.JSON.Value) (t$27009)));

		// #line 251 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final java.lang.Object t$27010 = ((java.lang.Object) fundamentals);

		// #line 251 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		((x10.util.HashMap<java.lang.String, java.lang.Object>) GLOBAL)
				.$set__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(
						((java.lang.String) ("fundamentals")),
						((java.lang.Object) (t$27010)));

		// #line 255 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.util.List t$27011 = ((x10.util.List) (((x10.util.List<plham.Agent>) ((plham.util.CentricAllocManager<plham.Agent>) dm)
				.getBody())));

		// #line 255 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		this.setupEnv__0$1plham$Market$2__1$1plham$Agent$2(
				((x10.util.List) (markets)), ((x10.util.List) (t$27011)));

		// #line 262 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final $B t$27012 = (($B) (this.sim));

		// #line 262 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		((plham.main.Simulator) x10.rtt.Types.conversion(
				plham.main.Simulator.$RTT, t$27012)).beginSimulation();

		// #line 264 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final cassia.util.JSON.Value t$27013 = ((cassia.util.JSON.Value) CONFIG)
				.<java.lang.String> get(x10.rtt.Types.STRING,
						((java.lang.String) ("simulation")));

		// #line 264 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final cassia.util.JSON.Value sessions = ((cassia.util.JSON.Value) t$27013)
				.<java.lang.String> get(x10.rtt.Types.STRING,
						((java.lang.String) ("sessions")));

		// #line 265 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long i$26872min$27220 = 0L;

		// #line 265 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long t$27221 = sessions.size$O();

		// #line 265 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long i$26872max$27222 = ((t$27221) - (((long) (1L))));

		// #line 265 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		long i$27217 = i$26872min$27220;

		// #line 265 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		for (; true;) {

			// #line 265 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long t$27218 = i$27217;

			// #line 265 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final boolean t$27219 = ((t$27218) <= (((long) (i$26872max$27222))));

			// #line 265 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (!(t$27219)) {

				// #line 265 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				break;
			}

			// #line 265 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long i$27214 = i$27217;

			// #line 267 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final x10.io.Printer t$27157 = ((x10.io.Printer) (x10.io.Console
					.get$OUT()));

			// #line 267 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final java.lang.String t$27158 = (("------------Session ") + ((x10.core.Long
					.$box(i$27214))));

			// #line 267 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final java.lang.String t$27159 = ((t$27158) + (" Start@"));

			// #line 267 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final java.lang.String t$27160 = ((t$27159) + (x10.x10rt.X10RT
					.here()));

			// #line 267 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			t$27157.println(((java.lang.Object) (t$27160)));

			// #line 268 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final cassia.util.JSON.Value json$27161 = ((cassia.util.JSON.Value) sessions)
					.<x10.core.Long> get(x10.rtt.Types.LONG,
							x10.core.Long.$box(i$27214));

			// #line 269 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final cassia.util.JSON.Value t$27162 = ((cassia.util.JSON.Value) json$27161)
					.<java.lang.String> get(x10.rtt.Types.STRING,
							((java.lang.String) ("sessionName")));

			// #line 269 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final java.lang.String sessionName$27163 = t$27162.toString();

			// #line 270 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long iterationSteps$27164;

			// #line 271 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final boolean t$27165 = ((cassia.util.JSON.Value) json$27161)
					.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(
							x10.rtt.Types.STRING,
							((java.lang.String) ("iterationSteps")));

			// #line 271 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (t$27165) {

				// #line 272 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final cassia.util.JSON.Value t$27166 = ((cassia.util.JSON.Value) json$27161)
						.<java.lang.String> get(x10.rtt.Types.STRING,
								((java.lang.String) ("iterationSteps")));

				// #line 272 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final long t$27167 = t$27166.toLong$O();

				// #line 272 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				iterationSteps$27164 = t$27167;
			} else {

				// #line 274 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final cassia.util.JSON.Value t$27168 = ((cassia.util.JSON.Value) json$27161)
						.<java.lang.String> get(x10.rtt.Types.STRING,
								((java.lang.String) ("iterationDays")));

				// #line 274 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final long t$27169 = t$27168.toLong$O();

				// #line 274 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final cassia.util.JSON.Value t$27170 = ((cassia.util.JSON.Value) CONFIG)
						.<java.lang.String> get(x10.rtt.Types.STRING,
								((java.lang.String) ("numStepsOneDay")));

				// #line 274 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final long t$27171 = t$27170.toLong$O();

				// #line 274 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final long t$27172 = ((t$27169) * (((long) (t$27171))));

				// #line 274 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				iterationSteps$27164 = t$27172;
			}

			// #line 277 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final cassia.util.JSON.Value t$27173 = ((cassia.util.JSON.Value) json$27161)
					.<java.lang.String> get(x10.rtt.Types.STRING,
							((java.lang.String) ("withOrderPlacement")));

			// #line 277 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final boolean withOrderPlacement$27174 = t$27173.toBoolean$O();

			// #line 278 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final cassia.util.JSON.Value t$27175 = ((cassia.util.JSON.Value) json$27161)
					.<java.lang.String> get(x10.rtt.Types.STRING,
							((java.lang.String) ("withOrderExecution")));

			// #line 278 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final boolean withOrderExecution$27176 = t$27175.toBoolean$O();

			// #line 279 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final cassia.util.JSON.Value t$27177 = ((cassia.util.JSON.Value) json$27161)
					.<java.lang.String> $apply__0cassia$util$JSON$Value$$T(
							x10.rtt.Types.STRING,
							((java.lang.String) ("withPrint")),
							((java.lang.String) ("true")));

			// #line 279 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final boolean withPrint$27178 = t$27177.toBoolean$O();

			// #line 280 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			boolean t$27179 = !(withOrderPlacement$27174);

			// #line 280 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (t$27179) {

				// #line 280 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				t$27179 = !(withOrderExecution$27176);
			}

			// #line 280 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			boolean forDummyTimeseries$27180 = t$27179;

			// #line 281 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final boolean t$27181 = ((cassia.util.JSON.Value) json$27161)
					.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(
							x10.rtt.Types.STRING,
							((java.lang.String) ("forDummyTimeseries")));

			// #line 281 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (t$27181) {

				// #line 282 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final cassia.util.JSON.Value t$27182 = ((cassia.util.JSON.Value) json$27161)
						.<java.lang.String> get(x10.rtt.Types.STRING,
								((java.lang.String) ("forDummyTimeseries")));

				// #line 282 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final boolean t$27183 = t$27182.toBoolean$O();

				// #line 282 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				forDummyTimeseries$27180 = t$27183;
			}

			// #line 284 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long t$27184 = ((x10.util.Container<plham.Market>) markets)
					.size$O();

			// #line 284 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final java.lang.String t$27185 = java.lang.Long.toString(t$27184);

			// #line 284 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final cassia.util.JSON.Value t$27186 = ((cassia.util.JSON.Value) json$27161)
					.<java.lang.String> $apply__0cassia$util$JSON$Value$$T(
							x10.rtt.Types.STRING,
							((java.lang.String) ("maxNormalOrders")),
							((java.lang.String) (t$27185)));

			// #line 284 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long maxNormalOrders$27187 = t$27186.toLong$O();

			// #line 285 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final cassia.util.JSON.Value t$27188 = ((cassia.util.JSON.Value) json$27161)
					.<java.lang.String> $apply__0cassia$util$JSON$Value$$T(
							x10.rtt.Types.STRING,
							((java.lang.String) ("maxHifreqOrders")),
							((java.lang.String) ("0")));

			// #line 285 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long maxHifreqOrders$27189 = t$27188.toLong$O();

			// #line 287 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (true) {

				// #line 288 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final x10.io.Printer t$27190 = ((x10.io.Printer) (x10.io.Console
						.get$OUT()));

				// #line 288 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final java.lang.String t$27191 = (("# SESSION: ") + (sessionName$27163));

				// #line 288 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				t$27190.println(((java.lang.Object) (t$27191)));

				// #line 289 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final x10.io.Printer t$27192 = ((x10.io.Printer) (x10.io.Console
						.get$OUT()));

				// #line 289 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final java.lang.String t$27193 = (("# iterationSteps: ") + ((x10.core.Long
						.$box(iterationSteps$27164))));

				// #line 289 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				t$27192.println(((java.lang.Object) (t$27193)));

				// #line 290 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final x10.io.Printer t$27194 = ((x10.io.Printer) (x10.io.Console
						.get$OUT()));

				// #line 290 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final java.lang.String t$27195 = (("# withOrderPlacement: ") + ((x10.core.Boolean
						.$box(withOrderPlacement$27174))));

				// #line 290 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				t$27194.println(((java.lang.Object) (t$27195)));

				// #line 291 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final x10.io.Printer t$27196 = ((x10.io.Printer) (x10.io.Console
						.get$OUT()));

				// #line 291 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final java.lang.String t$27197 = (("# withOrderExecution: ") + ((x10.core.Boolean
						.$box(withOrderExecution$27176))));

				// #line 291 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				t$27196.println(((java.lang.Object) (t$27197)));

				// #line 292 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final x10.io.Printer t$27198 = ((x10.io.Printer) (x10.io.Console
						.get$OUT()));

				// #line 292 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final java.lang.String t$27199 = (("# withPrint: ") + ((x10.core.Boolean
						.$box(withPrint$27178))));

				// #line 292 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				t$27198.println(((java.lang.Object) (t$27199)));

				// #line 293 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final x10.io.Printer t$27200 = ((x10.io.Printer) (x10.io.Console
						.get$OUT()));

				// #line 293 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final boolean t$27201 = forDummyTimeseries$27180;

				// #line 293 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final java.lang.String t$27202 = (("# forDummyTimeseries: ") + ((x10.core.Boolean
						.$box(t$27201))));

				// #line 293 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				t$27200.println(((java.lang.Object) (t$27202)));

				// #line 294 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final x10.io.Printer t$27203 = ((x10.io.Printer) (x10.io.Console
						.get$OUT()));

				// #line 294 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final java.lang.String t$27204 = (("# maxNormalOrders: ") + ((x10.core.Long
						.$box(maxNormalOrders$27187))));

				// #line 294 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				t$27203.println(((java.lang.Object) (t$27204)));

				// #line 295 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final x10.io.Printer t$27205 = ((x10.io.Printer) (x10.io.Console
						.get$OUT()));

				// #line 295 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final java.lang.String t$27206 = (("# maxHifreqOrders: ") + ((x10.core.Long
						.$box(maxHifreqOrders$27189))));

				// #line 295 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				t$27205.println(((java.lang.Object) (t$27206)));
			}

			// #line 298 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			((x10.util.HashMap<java.lang.String, java.lang.Object>) GLOBAL)
					.$set__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(
							((java.lang.String) ("events")),
							((java.lang.Object) (null)));

			// #line 299 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final boolean t$27207 = ((cassia.util.JSON.Value) json$27161)
					.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(
							x10.rtt.Types.STRING,
							((java.lang.String) ("events")));

			// #line 299 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			if (t$27207) {

				// #line 300 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final $B t$27208 = (($B) (this.sim));

				// #line 300 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final cassia.util.JSON.Value t$27209 = ((cassia.util.JSON.Value) json$27161)
						.<java.lang.String> get(x10.rtt.Types.STRING,
								((java.lang.String) ("events")));

				// #line 300 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				final x10.util.List events$27210 = ((plham.main.Simulator) x10.rtt.Types
						.conversion(plham.main.Simulator.$RTT, t$27208))
						.createAllEvents(((cassia.util.JSON.Value) (t$27209)));

				// #line 301 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
				((x10.util.HashMap<java.lang.String, java.lang.Object>) GLOBAL)
						.$set__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(
								((java.lang.String) ("events")),
								((java.lang.Object) (events$27210)));
			}

			// #line 304 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final $B t$27211 = (($B) (this.sim));

			// #line 304 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			((plham.main.Simulator) x10.rtt.Types.conversion(
					plham.main.Simulator.$RTT, t$27211))
					.beginSession(((java.lang.String) (sessionName$27163)));

			// #line 308 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final boolean t$27212 = forDummyTimeseries$27180;

			// #line 306 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			this.iterateMarketUpdates(((java.lang.String) (sessionName$27163)),
					(long) (iterationSteps$27164),
					(boolean) (withOrderPlacement$27174),
					(boolean) (withOrderExecution$27176),
					(boolean) (withPrint$27178), (boolean) (t$27212),
					(long) (maxNormalOrders$27187),
					(long) (maxHifreqOrders$27189),
					((plham.Fundamentals) (fundamentals)));

			// #line 312 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final $B t$27213 = (($B) (this.sim));

			// #line 312 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			((plham.main.Simulator) x10.rtt.Types.conversion(
					plham.main.Simulator.$RTT, t$27213))
					.endSession(((java.lang.String) (sessionName$27163)));

			// #line 265 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long t$27215 = i$27217;

			// #line 265 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			final long t$27216 = ((t$27215) + (((long) (1L))));

			// #line 265 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
			i$27217 = t$27216;
		}

		// #line 315 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final $B t$27067 = (($B) (this.sim));

		// #line 315 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		((plham.main.Simulator) x10.rtt.Types.conversion(
				plham.main.Simulator.$RTT, t$27067)).endSimulation();

		// #line 317 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long TIME_THE_END = x10.lang.System.nanoTime$O();

		// #line 318 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final x10.io.Printer t$27071 = ((x10.io.Printer) (x10.io.Console
				.get$OUT()));

		// #line 318 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final long t$27068 = ((TIME_THE_END) - (((long) (TIME_THE_BEGINNING))));

		// #line 318 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final double t$27069 = ((double) (long) (((long) (t$27068))));

		// #line 318 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final double t$27070 = ((t$27069) / (((double) (1.0E9))));

		// #line 318 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		final java.lang.String t$27072 = (("# TIME ") + ((x10.core.Double
				.$box(t$27070))));

		// #line 318 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		t$27071.println(((java.lang.Object) (t$27072)));
	}

	// #line 37 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
	final public plham.main.Runner plham$main$Runner$$this$plham$main$Runner() {

		// #line 37 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		return plham.main.Runner.this;
	}

	// #line 37 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
	final public void __fieldInitializers_plham_main_Runner() {

		// #line 37 "/home/dsl/workspace/plhamK/plham/main/Runner.x10"
		((plham.main.Runner<$B>) this)._PROFILE = false;
	}

	final private static x10.core.concurrent.AtomicInteger initStatus$HIFREQ_SUBMIT_RATE = new x10.core.concurrent.AtomicInteger(
			x10.runtime.impl.java.InitDispatcher.UNINITIALIZED);
	private static x10.lang.ExceptionInInitializer exception$HIFREQ_SUBMIT_RATE;

	public static boolean get$useTeam() {
		return plham.main.Runner.useTeam;
	}

	public static double get$HIFREQ_SUBMIT_RATE() {
		if (((int) plham.main.Runner.initStatus$HIFREQ_SUBMIT_RATE.get()) == ((int) x10.runtime.impl.java.InitDispatcher.INITIALIZED)) {
			return plham.main.Runner.HIFREQ_SUBMIT_RATE;
		}
		if (((int) plham.main.Runner.initStatus$HIFREQ_SUBMIT_RATE.get()) == ((int) x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
			if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
				x10.runtime.impl.java.InitDispatcher
						.printStaticInitMessage(((java.lang.String) ("Rethrowing ExceptionInInitializer for field: plham.main.Runner.HIFREQ_SUBMIT_RATE")));
			}
			throw plham.main.Runner.exception$HIFREQ_SUBMIT_RATE;
		}
		if (plham.main.Runner.initStatus$HIFREQ_SUBMIT_RATE.compareAndSet(
				(int) (x10.runtime.impl.java.InitDispatcher.UNINITIALIZED),
				(int) (x10.runtime.impl.java.InitDispatcher.INITIALIZING))) {
			try {
				{
					plham.main.Runner.HIFREQ_SUBMIT_RATE = ((x10.lang.System
							.getenv(((java.lang.String) ("HIFREQ_SUBMIT_RATE")))) != (null)) ? java.lang.Double
							.parseDouble(x10.lang.System
									.getenv(((java.lang.String) ("HIFREQ_SUBMIT_RATE"))))
							: 1.0;
				}
			} catch (java.lang.Throwable exc$27223) {
				plham.main.Runner.exception$HIFREQ_SUBMIT_RATE = new x10.lang.ExceptionInInitializer(
						exc$27223);
				plham.main.Runner.initStatus$HIFREQ_SUBMIT_RATE
						.set((int) (x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED));
				x10.runtime.impl.java.InitDispatcher.lockInitialized();
				x10.runtime.impl.java.InitDispatcher.notifyInitialized();
				throw plham.main.Runner.exception$HIFREQ_SUBMIT_RATE;
			}
			if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
				x10.runtime.impl.java.InitDispatcher
						.printStaticInitMessage(((java.lang.String) ("Doing static initialization for field: plham.main.Runner.HIFREQ_SUBMIT_RATE")));
			}
			plham.main.Runner.initStatus$HIFREQ_SUBMIT_RATE
					.set((int) (x10.runtime.impl.java.InitDispatcher.INITIALIZED));
			x10.runtime.impl.java.InitDispatcher.lockInitialized();
			x10.runtime.impl.java.InitDispatcher.notifyInitialized();
		} else {
			if (plham.main.Runner.initStatus$HIFREQ_SUBMIT_RATE.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
				x10.runtime.impl.java.InitDispatcher.lockInitialized();
				while (plham.main.Runner.initStatus$HIFREQ_SUBMIT_RATE.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
					x10.runtime.impl.java.InitDispatcher.awaitInitialized();
				}
				x10.runtime.impl.java.InitDispatcher.unlockInitialized();
				if (((int) plham.main.Runner.initStatus$HIFREQ_SUBMIT_RATE
						.get()) == ((int) x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
					if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
						x10.runtime.impl.java.InitDispatcher
								.printStaticInitMessage(((java.lang.String) ("Rethrowing ExceptionInInitializer for field: plham.main.Runner.HIFREQ_SUBMIT_RATE")));
					}
					throw plham.main.Runner.exception$HIFREQ_SUBMIT_RATE;
				}
			}
		}
		return plham.main.Runner.HIFREQ_SUBMIT_RATE;
	}
}
