package plham.main;

import java.io.Serializable;

/**
 * A Runner class for sequential execution.
 */
@SuppressWarnings("unused")
public class SequentialRunner<T> extends Runner implements Serializable {
	/*
	public def this(sim:B) {
		super(sim);
	}
	
	public def updateMarkets(maxNormalOrders:Long, maxHifreqOrders:Long, diffPass:Boolean) { 
		val orders = collectOrders(maxNormalOrders);
		handleOrders(orders, maxHifreqOrders);
	}
	
	public def collectOrders(MAX_NORMAL_ORDERS:Long):List[List[Order]] {
		val env = this.env();
		val markets = env.markets;
		val agents = env.normalAgents;
		
		val beginTime = System.nanoTime();
		val allOrders = new ArrayList[List[Order]]();

		val random = sim.getRandom();
		val randomAgents = new RandomPermutation[Agent](random, agents);

		var k:Long = 0;
		randomAgents.shuffle();
		for (agent in randomAgents) {
			if (k >= MAX_NORMAL_ORDERS) {
				break;
			}
			val orders = agent.submitOrders(markets);
			if (orders.size() > 0) {
				allOrders.add(orders);
				k++;
			}
		}
		val endTime = System.nanoTime();
		if (_PROFILE) {
			Console.OUT.println("#PROFILE ORDER-MAKE TOTAL " + ((endTime - beginTime) / 1e+9) + " sec");
			Console.OUT.println("#PROFILE MAX-NORMAL-ORDERS " + MAX_NORMAL_ORDERS);
			Console.OUT.println("#PROFILE NUM-NORMAL-ORDERS " + allOrders.size());
		}
		return allOrders;
	}
	 */
	public static final x10.rtt.RuntimeType<SequentialRunner> $RTT = x10.rtt.NamedType
			.<SequentialRunner> make("plham.main.SequentialRunner",
					SequentialRunner.class, 1,
					new x10.rtt.Type[] { x10.rtt.ParameterizedType.make(
							plham.main.Runner.$RTT,
							x10.rtt.UnresolvedType.PARAM(0)) });

	public x10.rtt.RuntimeType<?> $getRTT() {
		return $RTT;
	}

	public x10.rtt.Type<?> $getParam(int i) {
		if (i == 0)
			return $B;
		return null;
	}

	private Object writeReplace() throws java.io.ObjectStreamException {
		return new x10.serialization.SerializationProxy(this);
	}

	public static <$B> x10.serialization.X10JavaSerializable $_deserialize_body(
			plham.main.SequentialRunner<$B> $_obj,
			x10.serialization.X10JavaDeserializer $deserializer)
			throws java.io.IOException {
		if (x10.runtime.impl.java.Runtime.TRACE_SER) {
			x10.runtime.impl.java.Runtime
					.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
							+ SequentialRunner.class + " calling");
		}
		plham.main.Runner.$_deserialize_body($_obj, $deserializer);
		$_obj.$B = (x10.rtt.Type) $deserializer.readObject();
		return $_obj;
	}

	public static x10.serialization.X10JavaSerializable $_deserializer(
			x10.serialization.X10JavaDeserializer $deserializer)
			throws java.io.IOException {
		plham.main.SequentialRunner $_obj = new plham.main.SequentialRunner(
				(java.lang.System[]) null, (x10.rtt.Type) null);
		$deserializer.record_reference($_obj);
		return $_deserialize_body($_obj, $deserializer);
	}

	public void $_serialize(x10.serialization.X10JavaSerializer $serializer)
			throws java.io.IOException {
		super.$_serialize($serializer);
		$serializer.write(this.$B);

	}

	// constructor just for allocation
	public SequentialRunner(final java.lang.System[] $dummy,
			final x10.rtt.Type $B) {
		super($dummy, $B);
		plham.main.SequentialRunner.$initParams(this, $B);

	}

	private x10.rtt.Type $B;

	// initializer of type parameters
	public static void $initParams(final SequentialRunner $this,
			final x10.rtt.Type $B) {
		$this.$B = $B;

	}

	// synthetic type for parameter mangling
	public static final class sequentialRunner {
	}

	// #line 18 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
	// creation method for java code (1-phase java constructor)
	public SequentialRunner(final x10.rtt.Type $B, final $B sim,
			sequentialRunner $dummy) {
		this((java.lang.System[]) null, $B);
		init(sim, (plham.main.SequentialRunner.sequentialRunner) null);
	}

	// constructor for non-virtual call
	final public plham.main.SequentialRunner<$B> init(final $B sim,
			sequentialRunner $dummy) {
		{

			// #line 19
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			/* super. */plham$main$Runner$$init$S(((sim)),
					(plham.main.Runner.__0plham$main$Runner$$B) null);

			// #line 18
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"

			// #line 16
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			this.__fieldInitializers_plham_main_SequentialRunner();
		}
		return this;
	}

	// #line 22 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
	public void updateMarkets(final long maxNormalOrders,
			final long maxHifreqOrders, final boolean diffPass) {

		// #line 23 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		final x10.util.List orders = this.collectOrders((maxNormalOrders));

		// #line 24 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		this.handleOrders__0$1x10$util$List$1plham$Order$2$2(((orders)),
				(maxHifreqOrders));
	}

	// #line 27 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
	public x10.util.List collectOrders(final long MAX_NORMAL_ORDERS) {

		// #line 28 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		final plham.Env env = this.env();

		// #line 29 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		final x10.util.List markets = ((env.markets));

		// #line 30 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		final x10.util.List agents = ((env.normalAgents));

		// #line 32 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		final long beginTime = x10.lang.System.nanoTime$O();

		// #line 33 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		final x10.util.ArrayList allOrders = ((new x10.util.ArrayList<x10.util.List<plham.Order>>(
				(java.lang.System[]) null, x10.rtt.ParameterizedType.make(
						x10.util.List.$RTT, plham.Order.$RTT))
				.x10$util$ArrayList$$init$S()));

		// #line 35 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		final $B t$21788 = ((this.sim));

		// #line 35 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		final x10.util.Random random = ((plham.main.Simulator) x10.rtt.Types
				.conversion(plham.main.Simulator.$RTT, t$21788)).getRandom();

		// #line 36 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		final cassia.util.random.RandomPermutation randomAgents = ((new cassia.util.random.RandomPermutation<plham.Agent>(
				(java.lang.System[]) null, plham.Agent.$RTT)
				.cassia$util$random$RandomPermutation$$init$S(
						((random)),
						((agents)),
						(cassia.util.random.RandomPermutation.__1$1cassia$util$random$RandomPermutation$$T$2) null)));

		// #line 38 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		long k = 0L;

		// #line 39 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		((cassia.util.random.RandomPermutation<plham.Agent>) randomAgents)
				.shuffle();

		// #line 40 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		final x10.lang.Iterator agent$21817 = (((cassia.util.random.RandomPermutation<plham.Agent>) randomAgents)
				.iterator());

		// #line 40 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		for (; true;) {

			// #line 40
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final boolean t$21818 = ((x10.lang.Iterator<plham.Agent>) agent$21817)
					.hasNext$O();

			// #line 40
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			if (!(t$21818)) {

				// #line 40
				// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
				break;
			}

			// #line 40
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final plham.Agent agent$21809 = ((((x10.lang.Iterator<plham.Agent>) agent$21817)
					.next$G()));

			// #line 41
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final long t$21810 = k;

			// #line 41
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final boolean t$21811 = ((t$21810) >= (((MAX_NORMAL_ORDERS))));

			// #line 41
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			if (t$21811) {

				// #line 42
				// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
				break;
			}

			// #line 44
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final x10.util.List orders$21812 = agent$21809
					.submitOrders(((markets)));

			// #line 45
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final long t$21813 = ((x10.util.Container<plham.Order>) orders$21812)
					.size$O();

			// #line 45
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final boolean t$21814 = ((t$21813) > (((0L))));

			// #line 45
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			if (t$21814) {

				// #line 46
				// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
				((x10.util.ArrayList<x10.util.List<plham.Order>>) allOrders)
						.add__0x10$util$ArrayList$$T$O(((orders$21812)));

				// #line 47
				// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
				final long t$21815 = k;

				// #line 47
				// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
				final long t$21816 = ((t$21815) + (((1L))));

				// #line 47
				// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
				k = t$21816;
			}
		}

		// #line 50 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		final long endTime = x10.lang.System.nanoTime$O();

		// #line 51 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		final boolean t$21808 = this._PROFILE;

		// #line 51 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		if (t$21808) {

			// #line 52
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final x10.io.Printer t$21801 = ((x10.io.Console.get$OUT()));

			// #line 52
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final long t$21797 = ((endTime) - (((beginTime))));

			// #line 52
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final double t$21798 = ((((t$21797))));

			// #line 52
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final double t$21799 = ((t$21798) / (((1.0E9))));

			// #line 52
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final java.lang.String t$21800 = (("#PROFILE ORDER-MAKE TOTAL ") + ((x10.core.Double
					.$box(t$21799))));

			// #line 52
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final java.lang.String t$21802 = ((t$21800) + (" sec"));

			// #line 52
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			t$21801.println(((t$21802)));

			// #line 53
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final x10.io.Printer t$21803 = ((x10.io.Console.get$OUT()));

			// #line 53
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final java.lang.String t$21804 = (("#PROFILE MAX-NORMAL-ORDERS ") + ((x10.core.Long
					.$box(MAX_NORMAL_ORDERS))));

			// #line 53
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			t$21803.println(((t$21804)));

			// #line 54
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final x10.io.Printer t$21806 = ((x10.io.Console.get$OUT()));

			// #line 54
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final long t$21805 = ((x10.util.ArrayList<x10.util.List<plham.Order>>) allOrders)
					.size$O();

			// #line 54
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			final java.lang.String t$21807 = (("#PROFILE NUM-NORMAL-ORDERS ") + ((x10.core.Long
					.$box(t$21805))));

			// #line 54
			// "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
			t$21806.println(((t$21807)));
		}

		// #line 56 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		return allOrders;
	}

	// #line 16 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
	final public plham.main.SequentialRunner plham$main$SequentialRunner$$this$plham$main$SequentialRunner() {

		// #line 16 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
		return plham.main.SequentialRunner.this;
	}

	// #line 16 "/home/dsl/workspace/plhamK/plham/main/SequentialRunner.x10"
	final public void __fieldInitializers_plham_main_SequentialRunner() {

	}
}
