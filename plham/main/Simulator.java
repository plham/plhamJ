package plham.main;

import plham.Agent;
import plham.Market;

/**
 * A base class for simulation models. See {@link plham.main.Runner} for
 * execution models. See the subclass {@link plham.Main} for the core methods.
 */
@x10.runtime.impl.java.X10Generated
abstract public class Simulator extends plham.Env implements
		x10.serialization.X10JavaSerializable {
	public static final x10.rtt.RuntimeType<Simulator> $RTT = x10.rtt.NamedType
			.<Simulator> make("plham.main.Simulator", Simulator.class,
					new x10.rtt.Type[] { plham.Env.$RTT });

	public x10.rtt.RuntimeType<?> $getRTT() {
		return $RTT;
	}

	public x10.rtt.Type<?> $getParam(int i) {
		return null;
	}

	public static x10.serialization.X10JavaSerializable $_deserialize_body(
			plham.main.Simulator $_obj,
			x10.serialization.X10JavaDeserializer $deserializer)
			throws java.io.IOException {
		if (x10.runtime.impl.java.Runtime.TRACE_SER) {
			x10.runtime.impl.java.Runtime
					.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
							+ Simulator.class + " calling");
		}
		plham.Env.$_deserialize_body($_obj, $deserializer);
		$_obj.CONFIG = $deserializer.readObject();
		$_obj.GLOBAL = $deserializer.readObject();
		$_obj.RANDOM = $deserializer.readObject();
		$_obj.agentGenerators = $deserializer.readObject();
		$_obj.agentInitializers = $deserializer.readObject();
		$_obj.eventGenerators = $deserializer.readObject();
		$_obj.eventInitializers = $deserializer.readObject();
		$_obj.marketGenerators = $deserializer.readObject();
		$_obj.marketInitializers = $deserializer.readObject();
		$_obj.marketName2Ranges = $deserializer.readObject();
		return $_obj;
	}

	public static x10.serialization.X10JavaSerializable $_deserializer(
			x10.serialization.X10JavaDeserializer $deserializer)
			throws java.io.IOException {
		return null;
	}

	public void $_serialize(x10.serialization.X10JavaSerializer $serializer)
			throws java.io.IOException {
		super.$_serialize($serializer);
		$serializer.write(this.CONFIG);
		$serializer.write(this.GLOBAL);
		$serializer.write(this.RANDOM);
		$serializer.write(this.agentGenerators);
		$serializer.write(this.agentInitializers);
		$serializer.write(this.eventGenerators);
		$serializer.write(this.eventInitializers);
		$serializer.write(this.marketGenerators);
		$serializer.write(this.marketInitializers);
		$serializer.write(this.marketName2Ranges);

	}

	// constructor just for allocation
	public Simulator(final java.lang.System[] $dummy) {
		super($dummy);

	}

	// #line 32 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/**
	 * It stores the return values of <code>createMarkets()</code>,
	 * <code>createAgents()</code>, and <code>createEvents()</code>.
	 */
	public x10.util.Map<java.lang.String, java.lang.Object> GLOBAL;

	// #line 33 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.Map<java.lang.String, x10.util.List<x10.lang.LongRange>> marketName2Ranges;

	// #line 35 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/** The JSON config file. */
	public cassia.util.JSON.Value CONFIG;

	// #line 37 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/** The root of all instances of Random. */
	public x10.util.Random RANDOM;

	// #line 39 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.HashMap<java.lang.String, x10.core.fun.VoidFun_0_5<java.lang.String, x10.util.Indexed<x10.util.Random>, x10.lang.LongRange, cassia.util.JSON.Value, x10.lang.Settable<x10.core.Long, plham.Agent>>> agentInitializers;

	// #line 40 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_1<cassia.util.JSON.Value, x10.util.List<cassia.util.JSON.Value>>> agentGenerators;

	// #line 41 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_4<x10.core.Long, java.lang.String, x10.util.Random, cassia.util.JSON.Value, x10.util.List<plham.Market>>> marketInitializers;

	// #line 42 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_1<cassia.util.JSON.Value, x10.util.List<cassia.util.JSON.Value>>> marketGenerators;

	// #line 43 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_4<x10.core.Long, java.lang.String, x10.util.Random, cassia.util.JSON.Value, plham.Event>> eventInitializers;

	// #line 44 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_1<cassia.util.JSON.Value, x10.util.List<cassia.util.JSON.Value>>> eventGenerators;

	/**
	 * The type of functions which create and initialize agents.
	 * Agent-initializers must take (name:String, randoms:Indexed[Random],
	 * range:LongRange, config:JSON.Value, container:Settable[Long, Agent]). For
	 * each 'id' in a given 'range', initializers must create an agent and
	 * initialize it using 'name', 'randoms(id)', 'config', then set the agent
	 * on 'container(id)'.
	 * 
	 * @param name
	 *            A name of agents the initializer creates and initializes. All
	 *            the agents which initializers create and initialize at a time
	 *            have the same name.
	 * @param randoms
	 *            Pseudo random number generators for each agents. A agent whose
	 *            id is k must use randoms(k).
	 * @param range
	 *            Range of ids which the initializer creates.
	 * @param config
	 *            A config for agents.
	 * @param container
	 *            A container of agents. Initialized agents are set to it. An
	 *            agent whose id is k is set to container(k).
	 */

	/**
	 * The type of functions which generate agents' config(json value) from json
	 * value.
	 */

	// #line 71 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"

	// constructor for non-virtual call
	final public plham.main.Simulator plham$main$Simulator$$init$S() {
		{

			// #line 71 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			/* super. */init();

			// #line 71 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"

			// #line 29 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			this.__fieldInitializers_plham_main_Simulator();

			// #line 72 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.HashMap t$23829 = ((new x10.util.HashMap<java.lang.String, x10.core.fun.VoidFun_0_5<java.lang.String, x10.util.Indexed<x10.util.Random>, x10.lang.LongRange, cassia.util.JSON.Value, x10.lang.Settable<x10.core.Long, plham.Agent>>>(
					(java.lang.System[]) null, x10.rtt.Types.STRING,
					x10.rtt.ParameterizedType.make(
							x10.core.fun.VoidFun_0_5.$RTT,
							x10.rtt.Types.STRING, x10.rtt.ParameterizedType
									.make(x10.util.Indexed.$RTT,
											x10.util.Random.$RTT),
							x10.lang.LongRange.$RTT,
							cassia.util.JSON.Value.$RTT,
							x10.rtt.ParameterizedType.make(
									x10.lang.Settable.$RTT, x10.rtt.Types.LONG,
									plham.Agent.$RTT)))
					.x10$util$HashMap$$init$S()));

			// #line 72 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			this.agentInitializers = ((t$23829));

			// #line 73 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.HashMap t$23830 = ((new x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_1<cassia.util.JSON.Value, x10.util.List<cassia.util.JSON.Value>>>(
					(java.lang.System[]) null, x10.rtt.Types.STRING,
					x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT,
							cassia.util.JSON.Value.$RTT,
							x10.rtt.ParameterizedType.make(x10.util.List.$RTT,
									cassia.util.JSON.Value.$RTT)))
					.x10$util$HashMap$$init$S()));

			// #line 73 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			this.agentGenerators = ((t$23830));

			// #line 74 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.HashMap t$23831 = ((new x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_4<x10.core.Long, java.lang.String, x10.util.Random, cassia.util.JSON.Value, x10.util.List<plham.Market>>>(
					(java.lang.System[]) null, x10.rtt.Types.STRING,
					x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_4.$RTT,
							x10.rtt.Types.LONG, x10.rtt.Types.STRING,
							x10.util.Random.$RTT, cassia.util.JSON.Value.$RTT,
							x10.rtt.ParameterizedType.make(x10.util.List.$RTT,
									plham.Market.$RTT)))
					.x10$util$HashMap$$init$S()));

			// #line 74 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			this.marketInitializers = ((t$23831));

			// #line 75 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.HashMap t$23832 = ((new x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_1<cassia.util.JSON.Value, x10.util.List<cassia.util.JSON.Value>>>(
					(java.lang.System[]) null, x10.rtt.Types.STRING,
					x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT,
							cassia.util.JSON.Value.$RTT,
							x10.rtt.ParameterizedType.make(x10.util.List.$RTT,
									cassia.util.JSON.Value.$RTT)))
					.x10$util$HashMap$$init$S()));

			// #line 75 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			this.marketGenerators = ((t$23832));

			// #line 76 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.HashMap t$23833 = ((new x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_4<x10.core.Long, java.lang.String, x10.util.Random, cassia.util.JSON.Value, plham.Event>>(
					(java.lang.System[]) null, x10.rtt.Types.STRING,
					x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_4.$RTT,
							x10.rtt.Types.LONG, x10.rtt.Types.STRING,
							x10.util.Random.$RTT, cassia.util.JSON.Value.$RTT,
							plham.Event.$RTT)).x10$util$HashMap$$init$S()));

			// #line 76 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			this.eventInitializers = ((t$23833));

			// #line 77 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.HashMap t$23834 = ((new x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_1<cassia.util.JSON.Value, x10.util.List<cassia.util.JSON.Value>>>(
					(java.lang.System[]) null, x10.rtt.Types.STRING,
					x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT,
							cassia.util.JSON.Value.$RTT,
							x10.rtt.ParameterizedType.make(x10.util.List.$RTT,
									cassia.util.JSON.Value.$RTT)))
					.x10$util$HashMap$$init$S()));

			// #line 77 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			this.eventGenerators = ((t$23834));
		}
		return this;
	}

	// #line 93 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/**
	 * Adds AgentsInitailizer that initializes all agents specified in a
	 * json-config element. For example, if the json-config file is ...
	 * "SomeAgentsForMarket-X": { "class": "SomeAgent", "numAgents": 100, ... }
	 * ... , then AgentsInitializer must initialize all the 100 agents. If you
	 * want to initialize the 100 agents in a same way, you can use
	 * Simulator#addAgentInitializer.
	 */
	public void addAgentsInitializer__1$1x10$lang$String$3x10$util$Indexed$1x10$util$Random$2$3x10$lang$LongRange$3cassia$util$JSON$Value$3x10$lang$Settable$1x10$lang$Long$3plham$Agent$2$2(
			final java.lang.String name,
			final x10.core.fun.VoidFun_0_5 initializer) {

		// #line 94 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.HashMap t$23835 = ((this.agentInitializers));

		// #line 94 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		((x10.util.HashMap<java.lang.String, x10.core.fun.VoidFun_0_5<java.lang.String, x10.util.Indexed<x10.util.Random>, x10.lang.LongRange, cassia.util.JSON.Value, x10.lang.Settable<x10.core.Long, plham.Agent>>>) t$23835)
				.put__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(
						((name)),
						((initializer)));
	}

	// #line 100 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/**
	 * Adds one agent initializer to the simulator. This method creates
	 * AgentsInitializer from specified AgentInitializer, and adds it.
	 */
	public void addAgentInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Agent$2(
			final java.lang.String name, final x10.core.fun.Fun_0_4 initializer) {

		// #line 101 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.HashMap t$23843 = ((this.agentInitializers));

		// #line 101 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.core.fun.VoidFun_0_5 t$23844 = ((new plham.main.Simulator.$Closure$10(
				initializer,
				(plham.main.Simulator.$Closure$10.__0$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Agent$2) null)));

		// #line 101 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		((x10.util.HashMap<java.lang.String, x10.core.fun.VoidFun_0_5<java.lang.String, x10.util.Indexed<x10.util.Random>, x10.lang.LongRange, cassia.util.JSON.Value, x10.lang.Settable<x10.core.Long, plham.Agent>>>) t$23843)
				.put__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(
						((name)),
						((t$23844)));
	}

	// #line 108 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public void addAgentGenerator__1$1cassia$util$JSON$Value$3x10$util$List$1cassia$util$JSON$Value$2$2(
			final java.lang.String name, final x10.core.fun.Fun_0_1 generator) {

		// #line 109 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.HashMap t$23845 = ((this.agentGenerators));

		// #line 109 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		((x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_1<cassia.util.JSON.Value, x10.util.List<cassia.util.JSON.Value>>>) t$23845)
				.put__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(
						((name)),
						((generator)));
	}

	// #line 112 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public void addMarketInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Market$2(
			final java.lang.String name, final x10.core.fun.Fun_0_4 initializer) {

		// #line 113 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.core.fun.Fun_0_4 t$23855 = ((new plham.main.Simulator.$Closure$11(
				this,
				initializer,
				(plham.main.Simulator.$Closure$11.__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Market$2) null)));

		// #line 113 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		this.addMarketsInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3x10$util$List$1plham$Market$2$2(
				((name)), ((t$23855)));
	}

	// #line 122 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public void addMarketsInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3x10$util$List$1plham$Market$2$2(
			final java.lang.String name, final x10.core.fun.Fun_0_4 initializer) {

		// #line 123 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.HashMap t$23856 = ((this.marketInitializers));

		// #line 123 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		((x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_4<x10.core.Long, java.lang.String, x10.util.Random, cassia.util.JSON.Value, x10.util.List<plham.Market>>>) t$23856)
				.put__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(
						((name)),
						((initializer)));
	}

	// #line 126 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public void addMarketGenerator__1$1cassia$util$JSON$Value$3x10$util$List$1cassia$util$JSON$Value$2$2(
			final java.lang.String name, final x10.core.fun.Fun_0_1 generator) {

		// #line 127 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.HashMap t$23857 = ((this.marketGenerators));

		// #line 127 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		((x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_1<cassia.util.JSON.Value, x10.util.List<cassia.util.JSON.Value>>>) t$23857)
				.put__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(
						((name)),
						((generator)));
	}

	// #line 130 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.core.fun.Fun_0_4 addEventInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Event$2(
			final java.lang.String name, final x10.core.fun.Fun_0_4 initializer) {

		// #line 130 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.HashMap t$23858 = ((this.eventInitializers));

		// #line 130 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.core.fun.Fun_0_4 t$23859 = ((x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_4<x10.core.Long, java.lang.String, x10.util.Random, cassia.util.JSON.Value, plham.Event>>) t$23858)
				.put__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(
						((name)),
						((initializer)));

		// #line 130 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$23859;
	}

	// #line 131 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.core.fun.Fun_0_1 addEventGenerator__1$1cassia$util$JSON$Value$3x10$util$List$1cassia$util$JSON$Value$2$2(
			final java.lang.String name, final x10.core.fun.Fun_0_1 generator) {

		// #line 131 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.HashMap t$23860 = ((this.eventGenerators));

		// #line 131 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.core.fun.Fun_0_1 t$23861 = ((x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_1<cassia.util.JSON.Value, x10.util.List<cassia.util.JSON.Value>>>) t$23860)
				.put__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(
						((name)),
						((generator)));

		// #line 131 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$23861;
	}

	// #line 137 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/**
	 * Get the root of all instances of Random (allowed to call only at the
	 * place 0).
	 * 
	 * @return the root
	 */
	public x10.util.Random getRandom() {

		// #line 139 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.Random t$23862 = ((this.RANDOM));

		// #line 139 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$23862;
	}

	// #line 142 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	abstract public void beginSimulation();

	// #line 144 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	abstract public void endSimulation();

	// #line 146 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	abstract public void beginSession(final java.lang.String sessionName);

	// #line 148 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	abstract public void endSession(final java.lang.String sessionName);

	// #line 150 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	abstract public void print(final java.lang.String sessionName);

	// #line 152 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	abstract public void endprint(final java.lang.String sessionName,
			final long iterationSteps);

	// #line 161 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/**
	 * For the item grouping technology based on the idea of <q>keyword chain</q>
	 * in JSON.
	 * 
	 * @param json
	 * @param className
	 *            a dummy class name, e.g., "AgentGroup"
	 * @param keyword
	 *            a name for keyword chain, e.g., "agents"
	 * @return a list of items
	 */
	public <$T> x10.util.List createItemGroup(final x10.rtt.Type $T,
			final cassia.util.JSON.Value json,
			final java.lang.String className, final java.lang.String keyword) {

		// #line 162 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.ArrayList items = ((new x10.util.ArrayList<$T>(
				(java.lang.System[]) null, $T).x10$util$ArrayList$$init$S()));

		// #line 164 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final cassia.util.JSON.Value t$23863 = json
				.<java.lang.String> get(x10.rtt.Types.STRING,
						(("class")));

		// #line 164 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final boolean t$23874 = t$23863
				.equals(((className)));

		// #line 164 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		if (t$23874) {

			// #line 165 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final cassia.util.JSON.Value list = json
					.<java.lang.String> get(x10.rtt.Types.STRING,
							((keyword)));

			// #line 166 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$23524min$24234 = 0L;

			// #line 166 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24235 = list.size$O();

			// #line 166 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$23524max$24236 = ((t$24235) - (((1L))));

			// #line 166 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			long i$24231 = i$23524min$24234;

			// #line 166 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			for (; true;) {

				// #line 166
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24232 = i$24231;

				// #line 166
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final boolean t$24233 = ((t$24232) <= (((i$23524max$24236))));

				// #line 166
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				if (!(t$24233)) {

					// #line 166
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					break;
				}

				// #line 166
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long i$24228 = i$24231;

				// #line 167
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value t$24223 = list
						.<x10.core.Long> get(x10.rtt.Types.LONG,
								x10.core.Long.$box(i$24228));

				// #line 167
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final java.lang.String name$24224 = t$24223.toString();

				// #line 168
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.util.Map t$24225 = ((this.GLOBAL));

				// #line 168
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final java.lang.Object t$24226 = (((x10.util.Map<java.lang.String, java.lang.Object>) t$24225)
						.$apply(((name$24224)),
								x10.rtt.Types.STRING));

				// #line 168
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.util.List t$24227 = x10.rtt.Types
						.<x10.util.List<$T>> cast(t$24226,
								x10.rtt.ParameterizedType.make(
										x10.util.List.$RTT, $T));

				// #line 168
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				((x10.util.AbstractCollection<$T>) items)
						.addAll__0$1x10$util$AbstractCollection$$T$2$O(((t$24227)));

				// #line 166
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24229 = i$24231;

				// #line 166
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24230 = ((t$24229) + (((1L))));

				// #line 166
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				i$24231 = t$24230;
			}
		}

		// #line 171 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return items;
	}

	// #line 174 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	private <$T> x10.util.ArrayList fromRail__0$1plham$main$Simulator$$T$2(
			final x10.rtt.Type $T, final x10.core.Rail xs) {

		// #line 175 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long t$23875 = ((x10.core.Rail<$T>) xs).size;

		// #line 175 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.ArrayList ret = ((new x10.util.ArrayList<$T>(
				(java.lang.System[]) null, $T)
				.x10$util$ArrayList$$init$S(((t$23875)))));

		// #line 176 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.core.Rail rail$24244 = ((xs));

		// #line 176 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23542min$24245 = 0L;

		// #line 176 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23542max$24246 = ((x10.core.Rail<$T>) rail$24244).size;

		// #line 176 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		long i$24241 = i$23542min$24245;

		// #line 176 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 176 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24242 = i$24241;

			// #line 176 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24243 = ((t$24242) < (((i$23542max$24246))));

			// #line 176 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24243)) {

				// #line 176
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 176 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$24238 = i$24241;

			// #line 177 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final $T t$24237 = ((((x10.core.Rail<$T>) xs)
					.$apply$G((i$24238))));

			// #line 177 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			((x10.util.ArrayList<$T>) ret).$set__1x10$util$ArrayList$$T$G(
					(i$24238), ((t$24237)));

			// #line 176 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24239 = i$24241;

			// #line 176 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24240 = ((t$24239) + (((1L))));

			// #line 176 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			i$24241 = t$24240;
		}

		// #line 179 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return ret;
	}

	public static <$T> x10.util.ArrayList fromRail$P__0$1plham$main$Simulator$$T$2(
			final x10.rtt.Type $T, final x10.core.Rail<$T> xs,
			final plham.main.Simulator Simulator) {
		return Simulator
				.<$T> fromRail__0$1plham$main$Simulator$$T$2($T,
						((x10.core.Rail) (xs)));
	}

	// #line 182 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.List createAllMarkets(final cassia.util.JSON.Value list) {

		// #line 183 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.ArrayList allMarkets = ((new x10.util.ArrayList<plham.Market>(
				(java.lang.System[]) null, plham.Market.$RTT)
				.x10$util$ArrayList$$init$S()));

		// #line 184 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final java.lang.String t$23882 = (("requires"));

		// #line 184 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.core.Rail t$23883 = ((x10.runtime.impl.java.ArrayUtils
				.<java.lang.String> makeRailFromJavaArray(x10.rtt.Types.STRING,
						new java.lang.String[] { t$23882 })));

		// #line 184 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.ArrayList keywords = this
				.<java.lang.String> fromRail__0$1plham$main$Simulator$$T$2(
						x10.rtt.Types.STRING, ((t$23883)));

		// #line 185 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final cassia.util.JSON.Value t$23884 = ((this.CONFIG));

		// #line 185 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List sorted = plham.util.JSONUtils
				.getDependencySortedList__2$1x10$lang$String$2(
						((t$23884)),
						((list)),
						((keywords)));

		// #line 187 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		this.markets = ((allMarkets));

		// #line 188 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.HashMap t$23885 = ((new x10.util.HashMap<java.lang.String, x10.util.List<x10.lang.LongRange>>(
				(java.lang.System[]) null, x10.rtt.Types.STRING,
				x10.rtt.ParameterizedType.make(x10.util.List.$RTT,
						x10.lang.LongRange.$RTT)).x10$util$HashMap$$init$S()));

		// #line 188 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		this.marketName2Ranges = ((t$23885));

		// #line 190 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23563min$24305 = 0L;

		// #line 190 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long t$24306 = ((x10.util.Container<java.lang.String>) sorted)
				.size$O();

		// #line 190 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23563max$24307 = ((t$24306) - (((1L))));

		// #line 190 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		long i$24302 = i$23563min$24305;

		// #line 190 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 190 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24303 = i$24302;

			// #line 190 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24304 = ((t$24303) <= (((i$23563max$24307))));

			// #line 190 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24304)) {

				// #line 190
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 190 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$24299 = i$24302;

			// #line 191 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$24259 = ((x10.util.Indexed<java.lang.String>) sorted)
					.$apply$G((i$24299));

			// #line 191 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String name$24260 = (t$24259).toString();

			// #line 192 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.List markets$24261;

			// #line 193 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final cassia.util.JSON.Value t$24262 = ((this.CONFIG));

			// #line 193 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final cassia.util.JSON.Value config$24263 = t$24262
					.<java.lang.String> get(x10.rtt.Types.STRING,
							((name$24260)));

			// #line 194 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final cassia.util.JSON.Value t$24264 = config$24263
					.<java.lang.String> get(x10.rtt.Types.STRING,
							(("class")));

			// #line 194 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String className$24265 = t$24264.toString();

			// #line 196 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final cassia.util.JSON.Value t$24266 = config$24263
					.<java.lang.String> get(x10.rtt.Types.STRING,
							(("class")));

			// #line 196 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24267 = t$24266
					.equals((("MarketGroup")));

			// #line 196 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (t$24267) {

				// #line 197
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.util.Map t$24268 = ((this.marketName2Ranges));

				// #line 197
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.util.List t$24269 = this
						.<x10.lang.LongRange> createItemGroup(
								x10.lang.LongRange.$RTT,
								((config$24263)),
								(("MarketGroup")),
								(("markets")));

				// #line 197
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				((x10.util.Map<java.lang.String, x10.util.List<x10.lang.LongRange>>) t$24268)
						.$set(((name$24260)),
								x10.rtt.Types.STRING,
								((t$24269)),
								x10.rtt.ParameterizedType.make(
										x10.util.List.$RTT,
										x10.lang.LongRange.$RTT));
			} else {

				// #line 198
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.util.HashMap t$24270 = ((this.marketGenerators));

				// #line 198
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final boolean t$24271 = ((x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_1<cassia.util.JSON.Value, x10.util.List<cassia.util.JSON.Value>>>) t$24270)
						.containsKey__0x10$util$HashMap$$K$O(((className$24265)));

				// #line 198
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				if (t$24271) {

					// #line 199
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final long before$24272 = ((x10.util.ArrayList<plham.Market>) allMarkets)
							.size$O();

					// #line 200
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final x10.util.HashMap t$24273 = ((x10.util.HashMap) (this.marketGenerators));

					// #line 200
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final x10.core.fun.Fun_0_1 generator$24274 = ((x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_1<cassia.util.JSON.Value, x10.util.List<cassia.util.JSON.Value>>>) t$24273)
							.$apply__0x10$util$HashMap$$K$G(((java.lang.String) (className$24265)));

					// #line 201
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final x10.util.ArrayList t$24275 = ((x10.util.ArrayList) (new x10.util.ArrayList<plham.Market>(
							(java.lang.System[]) null, plham.Market.$RTT)
							.x10$util$ArrayList$$init$S()));

					// #line 201
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					markets$24261 = ((x10.util.List) (t$24275));

					// #line 202
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final x10.util.List t$24256 = ((x10.util.List<cassia.util.JSON.Value>) ((x10.core.fun.Fun_0_1<cassia.util.JSON.Value, x10.util.List<cassia.util.JSON.Value>>) generator$24274)
							.$apply(config$24263, cassia.util.JSON.Value.$RTT));

					// #line 202
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final x10.util.ListIterator configGenerated$24257 = ((x10.util.ListIterator<cassia.util.JSON.Value>) ((x10.util.List<cassia.util.JSON.Value>) t$24256)
							.iterator());

					// #line 202
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					for (; true;) {

						// #line 202
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final boolean t$24258 = ((x10.util.ListIterator<cassia.util.JSON.Value>) configGenerated$24257)
								.hasNext$O();

						// #line 202
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						if (!(t$24258)) {

							// #line 202
							// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
							break;
						}

						// #line 202
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final cassia.util.JSON.Value configGenerated$24247 = ((cassia.util.JSON.Value) (((x10.util.ListIterator<cassia.util.JSON.Value>) configGenerated$24257)
								.next$G()));

						// #line 203
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final long t$24248 = ((x10.util.ArrayList<plham.Market>) allMarkets)
								.size$O();

						// #line 203
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final long t$24249 = ((x10.util.Container<plham.Market>) markets$24261)
								.size$O();

						// #line 203
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final long id$24250 = ((t$24248) + (((long) (t$24249))));

						// #line 204
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final cassia.util.JSON.Value t$24251 = ((cassia.util.JSON.Value) configGenerated$24247)
								.<java.lang.String> get(x10.rtt.Types.STRING,
										((java.lang.String) ("name")));

						// #line 204
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final java.lang.String marketName$24252 = t$24251
								.toString();

						// #line 205
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final x10.util.Random t$24253 = this.getRandom();

						// #line 205
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final x10.util.Random t$24254 = ((x10.util.Random) (t$24253
								.split()));

						// #line 205
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final x10.util.List t$24255 = this
								.createMarkets(
										(long) (id$24250),
										((java.lang.String) (marketName$24252)),
										((x10.util.Random) (t$24254)),
										((cassia.util.JSON.Value) (configGenerated$24247)));

						// #line 205
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						((x10.util.Collection<plham.Market>) markets$24261)
								.addAll$Z(((x10.util.Container) (t$24255)),
										x10.rtt.ParameterizedType.make(
												x10.util.Container.$RTT,
												plham.Market.$RTT));
					}

					// #line 207
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					((x10.util.AbstractCollection<plham.Market>) allMarkets)
							.addAll__0$1x10$util$AbstractCollection$$T$2$O(((x10.util.Container) (markets$24261)));

					// #line 208
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final long after$24276 = ((x10.util.ArrayList<plham.Market>) allMarkets)
							.size$O();

					// #line 209
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final boolean t$24277 = ((long) before$24272) != ((long) after$24276);

					// #line 209
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					if (t$24277) {

						// #line 210
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final x10.util.Map t$24278 = ((x10.util.Map) (this.marketName2Ranges));

						// #line 210
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final x10.util.ArrayList t$24279 = ((x10.util.ArrayList) (new x10.util.ArrayList<x10.lang.LongRange>(
								(java.lang.System[]) null,
								x10.lang.LongRange.$RTT)
								.x10$util$ArrayList$$init$S()));

						// #line 210
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						((x10.util.Map<java.lang.String, x10.util.List<x10.lang.LongRange>>) t$24278)
								.$set(((java.lang.String) (name$24260)),
										x10.rtt.Types.STRING,
										((x10.util.List) (t$24279)),
										x10.rtt.ParameterizedType.make(
												x10.util.List.$RTT,
												x10.lang.LongRange.$RTT));

						// #line 211
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final x10.util.Map t$24280 = ((x10.util.Map) (this.marketName2Ranges));

						// #line 211
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final x10.util.List t$24281 = ((x10.util.List<x10.lang.LongRange>) ((x10.util.Map<java.lang.String, x10.util.List<x10.lang.LongRange>>) t$24280)
								.$apply(((java.lang.String) (name$24260)),
										x10.rtt.Types.STRING));

						// #line 211
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final long t$24282 = ((after$24276) - (((long) (1L))));

						// #line 211
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final x10.lang.LongRange t$24283 = ((x10.lang.LongRange) (new x10.lang.LongRange(
								(java.lang.System[]) null)
								.x10$lang$LongRange$$init$S(
										((long) (before$24272)),
										((long) (t$24282)))));

						// #line 211
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						((x10.util.Collection<x10.lang.LongRange>) t$24281)
								.add$Z(((x10.lang.LongRange) (t$24283)),
										x10.lang.LongRange.$RTT);
					}
				} else {

					// #line 214
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final long before$24284 = ((x10.util.ArrayList<plham.Market>) allMarkets)
							.size$O();

					// #line 215
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final cassia.util.JSON.Value t$24285 = ((cassia.util.JSON.Value) (this.CONFIG));

					// #line 215
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final cassia.util.JSON.Value json$24286 = ((cassia.util.JSON.Value) t$24285)
							.<java.lang.String> get(x10.rtt.Types.STRING,
									((java.lang.String) (name$24260)));

					// #line 216
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final long id$24287 = ((x10.util.ArrayList<plham.Market>) allMarkets)
							.size$O();

					// #line 217
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final x10.util.Random t$24288 = this.getRandom();

					// #line 217
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final x10.util.Random t$24289 = ((x10.util.Random) (t$24288
							.split()));

					// #line 217
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final x10.util.List t$24290 = this.createMarkets(
							(long) (id$24287),
							((java.lang.String) (name$24260)),
							((x10.util.Random) (t$24289)),
							((cassia.util.JSON.Value) (json$24286)));

					// #line 217
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					markets$24261 = ((x10.util.List) (t$24290));

					// #line 218
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					((x10.util.AbstractCollection<plham.Market>) allMarkets)
							.addAll__0$1x10$util$AbstractCollection$$T$2$O(((x10.util.Container) (markets$24261)));

					// #line 219
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final long after$24291 = ((x10.util.ArrayList<plham.Market>) allMarkets)
							.size$O();

					// #line 220
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final boolean t$24292 = ((long) before$24284) != ((long) after$24291);

					// #line 220
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					if (t$24292) {

						// #line 221
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final x10.util.Map t$24293 = ((x10.util.Map) (this.marketName2Ranges));

						// #line 221
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final x10.util.ArrayList t$24294 = ((x10.util.ArrayList) (new x10.util.ArrayList<x10.lang.LongRange>(
								(java.lang.System[]) null,
								x10.lang.LongRange.$RTT)
								.x10$util$ArrayList$$init$S()));

						// #line 221
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						((x10.util.Map<java.lang.String, x10.util.List<x10.lang.LongRange>>) t$24293)
								.$set(((java.lang.String) (name$24260)),
										x10.rtt.Types.STRING,
										((x10.util.List) (t$24294)),
										x10.rtt.ParameterizedType.make(
												x10.util.List.$RTT,
												x10.lang.LongRange.$RTT));

						// #line 222
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final x10.util.Map t$24295 = ((x10.util.Map) (this.marketName2Ranges));

						// #line 222
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final x10.util.List t$24296 = ((x10.util.List<x10.lang.LongRange>) ((x10.util.Map<java.lang.String, x10.util.List<x10.lang.LongRange>>) t$24295)
								.$apply(((java.lang.String) (name$24260)),
										x10.rtt.Types.STRING));

						// #line 222
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final long t$24297 = ((after$24291) - (((long) (1L))));

						// #line 222
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final x10.lang.LongRange t$24298 = ((x10.lang.LongRange) (new x10.lang.LongRange(
								(java.lang.System[]) null)
								.x10$lang$LongRange$$init$S(
										((long) (before$24284)),
										((long) (t$24297)))));

						// #line 222
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						((x10.util.Collection<x10.lang.LongRange>) t$24296)
								.add$Z(((x10.lang.LongRange) (t$24298)),
										x10.lang.LongRange.$RTT);
					}
				}
			}

			// #line 190 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24300 = i$24302;

			// #line 190 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24301 = ((t$24300) + (((long) (1L))));

			// #line 190 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			i$24302 = t$24301;
		}

		// #line 227 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return allMarkets;
	}

	// #line 230 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.List createMarkets(final long id,
			final java.lang.String name, final x10.util.Random random,
			final cassia.util.JSON.Value json) {

		// #line 231 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final cassia.util.JSON.Value t$23930 = ((cassia.util.JSON.Value) json)
				.<java.lang.String> get(x10.rtt.Types.STRING,
						((java.lang.String) ("class")));

		// #line 231 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final java.lang.String className = t$23930.toString();

		// #line 232 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.HashMap t$23931 = ((x10.util.HashMap) (this.marketInitializers));

		// #line 232 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.core.fun.Fun_0_4 initializer = ((x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_4<x10.core.Long, java.lang.String, x10.util.Random, cassia.util.JSON.Value, x10.util.List<plham.Market>>>) t$23931)
				.$apply__0x10$util$HashMap$$K$G(((java.lang.String) (className)));

		// #line 233 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		assert ((initializer) != (null)) : (((("Initializer is not defined for class \'") + (className))) + ("\'"));

		// #line 234 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		try {
			{

				// #line 235
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.util.List t$23932 = ((x10.util.List<plham.Market>) ((x10.core.fun.Fun_0_4<x10.core.Long, java.lang.String, x10.util.Random, cassia.util.JSON.Value, x10.util.List<plham.Market>>) initializer)
						.$apply(x10.core.Long.$box(id), x10.rtt.Types.LONG,
								name, x10.rtt.Types.STRING, random,
								x10.util.Random.$RTT, json,
								cassia.util.JSON.Value.$RTT));

				// #line 235
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				return t$23932;
			}
		} catch (final java.lang.RuntimeException e) {

			// #line 237 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.io.Printer t$23936 = ((x10.io.Printer) (x10.io.Console
					.get$ERR()));

			// #line 237 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$23933 = (("An error occurred while creating ") + (name));

			// #line 237 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$23934 = ((t$23933) + (", from "));

			// #line 237 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$23935 = plham.util.JSON
					.dump(((cassia.util.JSON.Value) (json)));

			// #line 237 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$23937 = ((t$23934) + (t$23935));

			// #line 237 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			t$23936.println(((java.lang.Object) (t$23937)));

			// #line 238 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			throw e;
		}
	}

	// #line 242 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public void createAllAgents__1$1plham$Agent$2(
			final cassia.util.JSON.Value list,
			final plham.util.DistAllocManager dm) {

		// #line 243 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		long id = 0L;

		// #line 244 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final cassia.util.JSON.Value t$23938 = ((cassia.util.JSON.Value) (this.CONFIG));

		// #line 244 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List sorted = plham.util.JSONUtils
				.getDependencySortedList(((cassia.util.JSON.Value) (t$23938)),
						((cassia.util.JSON.Value) (list)),
						((java.lang.String) ("agents")));

		// #line 245 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		long numAllAgents = 0L;

		// #line 249 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.HashMap configsGenerated = ((x10.util.HashMap) (new x10.util.HashMap<java.lang.String, x10.util.List<cassia.util.JSON.Value>>(
				(java.lang.System[]) null, x10.rtt.Types.STRING,
				x10.rtt.ParameterizedType.make(x10.util.List.$RTT,
						cassia.util.JSON.Value.$RTT))
				.x10$util$HashMap$$init$S()));

		// #line 251 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23581min$24405 = 0L;

		// #line 251 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long t$24406 = ((x10.util.Container<java.lang.String>) sorted)
				.size$O();

		// #line 251 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23581max$24407 = ((t$24406) - (((long) (1L))));

		// #line 251 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		long i$24323 = i$23581min$24405;

		// #line 251 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 251 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24324 = i$24323;

			// #line 251 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24325 = ((t$24324) <= (((long) (i$23581max$24407))));

			// #line 251 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24325)) {

				// #line 251
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 251 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$24320 = i$24323;

			// #line 252 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$24308 = ((x10.util.Indexed<java.lang.String>) sorted)
					.$apply$G((long) (i$24320));

			// #line 252 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String name$24309 = (t$24308).toString();

			// #line 253 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final cassia.util.JSON.Value t$24310 = ((cassia.util.JSON.Value) (this.CONFIG));

			// #line 253 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final cassia.util.JSON.Value config$24311 = ((cassia.util.JSON.Value) t$24310)
					.<java.lang.String> get(x10.rtt.Types.STRING,
							((java.lang.String) (name$24309)));

			// #line 254 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final cassia.util.JSON.Value t$24312 = ((cassia.util.JSON.Value) config$24311)
					.<java.lang.String> get(x10.rtt.Types.STRING,
							((java.lang.String) ("class")));

			// #line 254 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String className$24313 = t$24312.toString();

			// #line 255 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24314 = (className$24313).equals("AgentGroup");

			// #line 255 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (t$24314) {

			} else {

				// #line 258
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.util.HashMap t$24315 = ((x10.util.HashMap) (this.agentGenerators));

				// #line 258
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final boolean t$24316 = ((x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_1<cassia.util.JSON.Value, x10.util.List<cassia.util.JSON.Value>>>) t$24315)
						.containsKey__0x10$util$HashMap$$K$O(((java.lang.String) (className$24313)));

				// #line 258
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				if (t$24316) {

					// #line 259
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final x10.util.HashMap t$24317 = ((x10.util.HashMap) (this.agentGenerators));

					// #line 259
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final x10.core.fun.Fun_0_1 generator$24318 = ((x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_1<cassia.util.JSON.Value, x10.util.List<cassia.util.JSON.Value>>>) t$24317)
							.$apply__0x10$util$HashMap$$K$G(((java.lang.String) (className$24313)));

					// #line 260
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					assert ((cassia.util.JSON.Value) config$24311)
							.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(
									x10.rtt.Types.STRING,
									((java.lang.String) ("base"))) : " config does not has base ";

					// #line 261
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final x10.util.List t$24319 = ((x10.util.List<cassia.util.JSON.Value>) ((x10.core.fun.Fun_0_1<cassia.util.JSON.Value, x10.util.List<cassia.util.JSON.Value>>) generator$24318)
							.$apply(config$24311, cassia.util.JSON.Value.$RTT));

					// #line 261
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					((x10.util.HashMap<java.lang.String, x10.util.List<cassia.util.JSON.Value>>) configsGenerated)
							.$set__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(
									((java.lang.String) (name$24309)),
									((x10.util.List) (t$24319)));
				}
			}

			// #line 251 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24321 = i$24323;

			// #line 251 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24322 = ((t$24321) + (((long) (1L))));

			// #line 251 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			i$24323 = t$24322;
		}

		// #line 266 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23599min$24408 = 0L;

		// #line 266 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long t$24409 = ((x10.util.Container<java.lang.String>) sorted)
				.size$O();

		// #line 266 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23599max$24410 = ((t$24409) - (((long) (1L))));

		// #line 266 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		long i$24341 = i$23599min$24408;

		// #line 266 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 266 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24342 = i$24341;

			// #line 266 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24343 = ((t$24342) <= (((long) (i$23599max$24410))));

			// #line 266 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24343)) {

				// #line 266
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 266 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			L$24344: {

				// #line 266
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long i$24345 = i$24341;
				// #line 267
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final java.lang.String t$24326 = ((x10.util.Indexed<java.lang.String>) sorted)
						.$apply$G((long) (i$24345));
				// #line 267
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final java.lang.String name$24327 = (t$24326).toString();
				// #line 268
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value t$24328 = ((cassia.util.JSON.Value) (this.CONFIG));
				// #line 268
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value config$24329 = ((cassia.util.JSON.Value) t$24328)
						.<java.lang.String> get(x10.rtt.Types.STRING,
								((java.lang.String) (name$24327)));
				// #line 269
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value t$24330 = ((cassia.util.JSON.Value) config$24329)
						.<java.lang.String> get(x10.rtt.Types.STRING,
								((java.lang.String) ("class")));
				// #line 269
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final java.lang.String className$24331 = t$24330.toString();
				// #line 270
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				boolean t$24332 = (className$24331).equals("AgentGroup");
				// #line 270
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				if (!(t$24332)) {

					// #line 270
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final x10.util.HashMap t$24333 = ((x10.util.HashMap) (this.agentGenerators));

					// #line 270
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					t$24332 = ((x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_1<cassia.util.JSON.Value, x10.util.List<cassia.util.JSON.Value>>>) t$24333)
							.containsKey__0x10$util$HashMap$$K$O(((java.lang.String) (className$24331)));
				}
				// #line 270
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final boolean t$24334 = t$24332;
				// #line 270
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				if (t$24334) {

					// #line 270
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					break L$24344;
				}
				// #line 271
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24335 = numAllAgents;
				// #line 271
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value t$24336 = ((cassia.util.JSON.Value) config$24329)
						.<java.lang.String> get(x10.rtt.Types.STRING,
								((java.lang.String) ("numAgents")));
				// #line 271
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24337 = t$24336.toLong$O();
				// #line 271
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24338 = ((t$24335) + (((long) (t$24337))));
				// #line 271
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				numAllAgents = t$24338;
			}

			// #line 266 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24339 = i$24341;

			// #line 266 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24340 = ((t$24339) + (((long) (1L))));

			// #line 266 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			i$24341 = t$24340;
		}

		// #line 273 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.Set t$24411 = ((x10.util.Set<x10.util.Map.Entry<java.lang.String, x10.util.List<cassia.util.JSON.Value>>>) ((x10.util.HashMap<java.lang.String, x10.util.List<cassia.util.JSON.Value>>) configsGenerated)
				.entries());

		// #line 273 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.lang.Iterator entry$24412 = ((x10.lang.Iterator<x10.util.Map.Entry<java.lang.String, x10.util.List<cassia.util.JSON.Value>>>) ((x10.lang.Iterable<x10.util.Map.Entry<java.lang.String, x10.util.List<cassia.util.JSON.Value>>>) t$24411)
				.iterator());

		// #line 273 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 273 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24413 = ((x10.lang.Iterator<x10.util.Map.Entry<java.lang.String, x10.util.List<cassia.util.JSON.Value>>>) entry$24412)
					.hasNext$O();

			// #line 273 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24413)) {

				// #line 273
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 273 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.Map.Entry entry$24354 = ((x10.util.Map.Entry) (((x10.lang.Iterator<x10.util.Map.Entry<java.lang.String, x10.util.List<cassia.util.JSON.Value>>>) entry$24412)
					.next$G()));

			// #line 274 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.List t$24351 = ((x10.util.Map.Entry<java.lang.String, x10.util.List<cassia.util.JSON.Value>>) entry$24354)
					.getValue$G();

			// #line 274 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.ListIterator config$24352 = ((x10.util.ListIterator<cassia.util.JSON.Value>) ((x10.util.List<cassia.util.JSON.Value>) t$24351)
					.iterator());

			// #line 274 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			for (; true;) {

				// #line 274
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final boolean t$24353 = ((x10.util.ListIterator<cassia.util.JSON.Value>) config$24352)
						.hasNext$O();

				// #line 274
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				if (!(t$24353)) {

					// #line 274
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					break;
				}

				// #line 274
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value config$24346 = ((cassia.util.JSON.Value) (((x10.util.ListIterator<cassia.util.JSON.Value>) config$24352)
						.next$G()));

				// #line 275
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24347 = numAllAgents;

				// #line 275
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value t$24348 = ((cassia.util.JSON.Value) config$24346)
						.<java.lang.String> get(x10.rtt.Types.STRING,
								((java.lang.String) ("numAgents")));

				// #line 275
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24349 = t$24348.toLong$O();

				// #line 275
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24350 = ((t$24347) + (((long) (t$24349))));

				// #line 275
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				numAllAgents = t$24350;
			}
		}

		// #line 278 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long t$23979 = numAllAgents;

		// #line 278 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		((plham.util.DistAllocManager<plham.Agent>) dm)
				.setTotalCount((long) (t$23979));

		// #line 279 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		long lastAgentId = 0L;

		// #line 280 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.Random t$23980 = this.getRandom();

		// #line 280 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final plham.util.RandomSequenceBySplit randoms = ((plham.util.RandomSequenceBySplit) (new plham.util.RandomSequenceBySplit(
				(java.lang.System[]) null)
				.plham$util$RandomSequenceBySplit$$init$S(t$23980)));

		// #line 281 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23621min$24414 = 0L;

		// #line 281 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long t$24415 = ((x10.util.Container<java.lang.String>) sorted)
				.size$O();

		// #line 281 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23621max$24416 = ((t$24415) - (((long) (1L))));

		// #line 281 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		long i$24379 = i$23621min$24414;

		// #line 281 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 281 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24380 = i$24379;

			// #line 281 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24381 = ((t$24380) <= (((long) (i$23621max$24416))));

			// #line 281 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24381)) {

				// #line 281
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 281 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			L$24382: {

				// #line 281
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long i$24383 = i$24379;
				// #line 282
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final java.lang.String t$24355 = ((x10.util.Indexed<java.lang.String>) sorted)
						.$apply$G((long) (i$24383));
				// #line 282
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final java.lang.String name$24356 = (t$24355).toString();
				// #line 283
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value t$24357 = ((cassia.util.JSON.Value) (this.CONFIG));
				// #line 283
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value config$24358 = ((cassia.util.JSON.Value) t$24357)
						.<java.lang.String> get(x10.rtt.Types.STRING,
								((java.lang.String) (name$24356)));
				// #line 284
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value t$24359 = ((cassia.util.JSON.Value) config$24358)
						.<java.lang.String> get(x10.rtt.Types.STRING,
								((java.lang.String) ("class")));
				// #line 284
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final java.lang.String className$24360 = t$24359.toString();
				// #line 285
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				boolean t$24361 = (className$24360).equals("AgentGroup");
				// #line 285
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				if (!(t$24361)) {

					// #line 285
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final x10.util.HashMap t$24362 = ((x10.util.HashMap) (this.agentGenerators));

					// #line 285
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					t$24361 = ((x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_1<cassia.util.JSON.Value, x10.util.List<cassia.util.JSON.Value>>>) t$24362)
							.containsKey__0x10$util$HashMap$$K$O(((java.lang.String) (className$24360)));
				}
				// #line 285
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final boolean t$24363 = t$24361;
				// #line 285
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				if (t$24363) {

					// #line 285
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					break L$24382;
				}
				// #line 286
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value t$24364 = ((cassia.util.JSON.Value) config$24358)
						.<java.lang.String> get(x10.rtt.Types.STRING,
								((java.lang.String) ("numAgents")));
				// #line 286
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long numAgents$24365 = t$24364.toLong$O();
				// #line 287
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24366 = lastAgentId;
				// #line 287
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24367 = lastAgentId;
				// #line 287
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24368 = ((t$24367) + (((long) (numAgents$24365))));
				// #line 287
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24369 = ((t$24368) - (((long) (1L))));
				// #line 287
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.lang.LongRange range$24370 = ((x10.lang.LongRange) (new x10.lang.LongRange(
						(java.lang.System[]) null).x10$lang$LongRange$$init$S(
						t$24366, t$24369)));
				// #line 288
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24371 = lastAgentId;
				// #line 288
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24372 = ((t$24371) + (((long) (numAgents$24365))));
				// #line 288
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				lastAgentId = t$24372;
				// #line 289
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.RangedList subList$24373 = ((cassia.util.RangedList<plham.Agent>) ((plham.util.DistAllocManager<plham.Agent>) dm)
						.getRangedList(
								((x10.lang.Place) (x10.x10rt.X10RT.here())),
								((cassia.util.JSON.Value) (config$24358)),
								((x10.lang.LongRange) (range$24370))));
				// #line 290
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final boolean t$24374 = ((x10.util.Container<plham.Agent>) subList$24373)
						.isEmpty$O();
				// #line 290
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final boolean t$24375 = !(t$24374);
				// #line 290
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				if (t$24375) {

					// #line 290
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final x10.lang.LongRange t$24376 = ((cassia.util.RangedCommon<plham.Agent>) subList$24373)
							.getRange();

					// #line 290
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					this.createAgents__1$1x10$util$Random$2__4$1x10$lang$Long$3plham$Agent$2(
							((java.lang.String) (name$24356)),
							((x10.util.Indexed) (randoms)),
							((x10.lang.LongRange) (t$24376)),
							((cassia.util.JSON.Value) (config$24358)),
							((x10.lang.Settable) (subList$24373)));
				}
			}

			// #line 281 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24377 = i$24379;

			// #line 281 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24378 = ((t$24377) + (((long) (1L))));

			// #line 281 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			i$24379 = t$24378;
		}

		// #line 292 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.Set t$24417 = ((x10.util.Set<x10.util.Map.Entry<java.lang.String, x10.util.List<cassia.util.JSON.Value>>>) ((x10.util.HashMap<java.lang.String, x10.util.List<cassia.util.JSON.Value>>) configsGenerated)
				.entries());

		// #line 292 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.lang.Iterator entry$24418 = ((x10.lang.Iterator<x10.util.Map.Entry<java.lang.String, x10.util.List<cassia.util.JSON.Value>>>) ((x10.lang.Iterable<x10.util.Map.Entry<java.lang.String, x10.util.List<cassia.util.JSON.Value>>>) t$24417)
				.iterator());

		// #line 292 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 292 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24419 = ((x10.lang.Iterator<x10.util.Map.Entry<java.lang.String, x10.util.List<cassia.util.JSON.Value>>>) entry$24418)
					.hasNext$O();

			// #line 292 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24419)) {

				// #line 292
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 292 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.Map.Entry entry$24402 = ((x10.util.Map.Entry) (((x10.lang.Iterator<x10.util.Map.Entry<java.lang.String, x10.util.List<cassia.util.JSON.Value>>>) entry$24418)
					.next$G()));

			// #line 293 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String name$24403 = ((x10.util.Map.Entry<java.lang.String, x10.util.List<cassia.util.JSON.Value>>) entry$24402)
					.getKey$G();

			// #line 294 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.List configs$24404 = ((x10.util.Map.Entry<java.lang.String, x10.util.List<cassia.util.JSON.Value>>) entry$24402)
					.getValue$G();

			// #line 295 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.ListIterator config$24400 = ((x10.util.ListIterator<cassia.util.JSON.Value>) ((x10.util.List<cassia.util.JSON.Value>) configs$24404)
					.iterator());

			// #line 295 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			for (; true;) {

				// #line 295
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final boolean t$24401 = ((x10.util.ListIterator<cassia.util.JSON.Value>) config$24400)
						.hasNext$O();

				// #line 295
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				if (!(t$24401)) {

					// #line 295
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					break;
				}

				// #line 295
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value config$24384 = ((cassia.util.JSON.Value) (((x10.util.ListIterator<cassia.util.JSON.Value>) config$24400)
						.next$G()));

				// #line 296
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value t$24385 = ((cassia.util.JSON.Value) config$24384)
						.<java.lang.String> get(x10.rtt.Types.STRING,
								((java.lang.String) ("class")));

				// #line 296
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final java.lang.String className$24386 = t$24385.toString();

				// #line 297
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value t$24387 = ((cassia.util.JSON.Value) config$24384)
						.<java.lang.String> get(x10.rtt.Types.STRING,
								((java.lang.String) ("numAgents")));

				// #line 297
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long numAgents$24388 = t$24387.toLong$O();

				// #line 298
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24389 = lastAgentId;

				// #line 298
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24390 = lastAgentId;

				// #line 298
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24391 = ((t$24390) + (((long) (numAgents$24388))));

				// #line 298
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24392 = ((t$24391) - (((long) (1L))));

				// #line 298
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.lang.LongRange range$24393 = ((x10.lang.LongRange) (new x10.lang.LongRange(
						(java.lang.System[]) null).x10$lang$LongRange$$init$S(
						t$24389, t$24392)));

				// #line 299
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24394 = lastAgentId;

				// #line 299
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24395 = ((t$24394) + (((long) (numAgents$24388))));

				// #line 299
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				lastAgentId = t$24395;

				// #line 300
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.RangedList subList$24396 = ((cassia.util.RangedList<plham.Agent>) ((plham.util.DistAllocManager<plham.Agent>) dm)
						.getRangedList(
								((x10.lang.Place) (x10.x10rt.X10RT.here())),
								((cassia.util.JSON.Value) (config$24384)),
								((x10.lang.LongRange) (range$24393))));

				// #line 301
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final boolean t$24397 = ((x10.util.Container<plham.Agent>) subList$24396)
						.isEmpty$O();

				// #line 301
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final boolean t$24398 = !(t$24397);

				// #line 301
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				if (t$24398) {

					// #line 301
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final x10.lang.LongRange t$24399 = ((cassia.util.RangedCommon<plham.Agent>) subList$24396)
							.getRange();

					// #line 301
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					this.createAgents__1$1x10$util$Random$2__4$1x10$lang$Long$3plham$Agent$2(
							((java.lang.String) (name$24403)),
							((x10.util.Indexed) (randoms)),
							((x10.lang.LongRange) (t$24399)),
							((cassia.util.JSON.Value) (config$24384)),
							((x10.lang.Settable) (subList$24396)));
				}
			}
		}

		// #line 304 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.io.Printer t$24021 = ((x10.io.Printer) (x10.io.Console
				.get$OUT()));

		// #line 304 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long t$24019 = numAllAgents;

		// #line 304 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final java.lang.String t$24020 = (("# ") + ((x10.core.Long
				.$box(t$24019))));

		// #line 304 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final java.lang.String t$24022 = ((t$24020) + (" agents created."));

		// #line 304 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		t$24021.println(((java.lang.Object) (t$24022)));

		// #line 305 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return;
	}

	// #line 309 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.List createAgents(final cassia.util.JSON.Value json) {

		// #line 310 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final cassia.util.JSON.Value t$24023 = ((cassia.util.JSON.Value) json)
				.<java.lang.String> get(x10.rtt.Types.STRING,
						((java.lang.String) ("class")));

		// #line 310 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final java.lang.String className = t$24023.toString();

		// #line 311 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.HashMap t$24024 = ((x10.util.HashMap) (this.agentInitializers));

		// #line 311 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.core.fun.VoidFun_0_5 initializer = ((x10.util.HashMap<java.lang.String, x10.core.fun.VoidFun_0_5<java.lang.String, x10.util.Indexed<x10.util.Random>, x10.lang.LongRange, cassia.util.JSON.Value, x10.lang.Settable<x10.core.Long, plham.Agent>>>) t$24024)
				.$apply__0x10$util$HashMap$$K$G(((java.lang.String) (className)));

		// #line 312 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		assert ((initializer) != (null)) : (((("Initializer is not defined for class \'") + (className))) + ("\'"));

		// #line 313 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		assert ((cassia.util.JSON.Value) json)
				.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(
						x10.rtt.Types.STRING,
						((java.lang.String) ("numAgents")));

		// #line 314 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final cassia.util.JSON.Value t$24025 = ((cassia.util.JSON.Value) json)
				.<java.lang.String> get(x10.rtt.Types.STRING,
						((java.lang.String) ("numAgents")));

		// #line 314 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long numAgents = t$24025.toLong$O();

		// #line 315 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.ArrayList agents = ((x10.util.ArrayList) (new x10.util.ArrayList<plham.Agent>(
				(java.lang.System[]) null, plham.Agent.$RTT)
				.x10$util$ArrayList$$init$S(((long) (numAgents)))));

		// #line 316 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long t$24026 = ((numAgents) - (((long) (1L))));

		// #line 316 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.lang.LongRange range = ((x10.lang.LongRange) (new x10.lang.LongRange(
				(java.lang.System[]) null).x10$lang$LongRange$$init$S(
				((long) (0L)), t$24026)));

		// #line 317 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final java.lang.String name = ((java.lang.String) ("default"));

		// #line 318 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.ArrayList randoms = ((x10.util.ArrayList) (new x10.util.ArrayList<x10.util.Random>(
				(java.lang.System[]) null, x10.util.Random.$RTT)
				.x10$util$ArrayList$$init$S(((long) (numAgents)))));

		// #line 319 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23643min$24428 = 0L;

		// #line 319 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23643max$24429 = ((numAgents) - (((long) (1L))));

		// #line 319 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		long i$24425 = i$23643min$24428;

		// #line 319 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 319 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24426 = i$24425;

			// #line 319 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24427 = ((t$24426) <= (((long) (i$23643max$24429))));

			// #line 319 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24427)) {

				// #line 319
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 319 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$24422 = i$24425;

			// #line 320 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.Random t$24420 = this.getRandom();

			// #line 320 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.Random t$24421 = ((x10.util.Random) (t$24420.split()));

			// #line 320 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			((x10.util.ArrayList<x10.util.Random>) randoms)
					.$set__1x10$util$ArrayList$$T$G((long) (i$24422),
							((x10.util.Random) (t$24421)));

			// #line 319 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24423 = i$24425;

			// #line 319 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24424 = ((t$24423) + (((long) (1L))));

			// #line 319 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			i$24425 = t$24424;
		}

		// #line 322 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		((x10.core.fun.VoidFun_0_5<java.lang.String, x10.util.Indexed<x10.util.Random>, x10.lang.LongRange, cassia.util.JSON.Value, x10.lang.Settable<x10.core.Long, plham.Agent>>) initializer)
				.$apply(name, x10.rtt.Types.STRING, randoms,
						x10.rtt.ParameterizedType.make(x10.util.Indexed.$RTT,
								x10.util.Random.$RTT), range,
						x10.lang.LongRange.$RTT, json,
						cassia.util.JSON.Value.$RTT, agents,
						x10.rtt.ParameterizedType.make(x10.lang.Settable.$RTT,
								x10.rtt.Types.LONG, plham.Agent.$RTT));

		// #line 323 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return agents;
	}

	// #line 326 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public void createAgents__1$1x10$util$Random$2__4$1x10$lang$Long$3plham$Agent$2(
			final java.lang.String name, final x10.util.Indexed randoms,
			final x10.lang.LongRange range, final cassia.util.JSON.Value json,
			final x10.lang.Settable agents) {

		// #line 327 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		try {
			{

				// #line 328
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value t$24034 = ((cassia.util.JSON.Value) json)
						.<java.lang.String> get(x10.rtt.Types.STRING,
								((java.lang.String) ("class")));

				// #line 328
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final java.lang.String className = t$24034.toString();

				// #line 329
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.util.HashMap t$24035 = ((x10.util.HashMap) (this.agentInitializers));

				// #line 329
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.core.fun.VoidFun_0_5 initializer = ((x10.util.HashMap<java.lang.String, x10.core.fun.VoidFun_0_5<java.lang.String, x10.util.Indexed<x10.util.Random>, x10.lang.LongRange, cassia.util.JSON.Value, x10.lang.Settable<x10.core.Long, plham.Agent>>>) t$24035)
						.$apply__0x10$util$HashMap$$K$G(((java.lang.String) (className)));

				// #line 330
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				assert ((initializer) != (null)) : (((("Initializer is not defined for class \'") + (className))) + ("\'"));

				// #line 331
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				((x10.core.fun.VoidFun_0_5<java.lang.String, x10.util.Indexed<x10.util.Random>, x10.lang.LongRange, cassia.util.JSON.Value, x10.lang.Settable<x10.core.Long, plham.Agent>>) initializer)
						.$apply(name, x10.rtt.Types.STRING, randoms,
								x10.rtt.ParameterizedType.make(
										x10.util.Indexed.$RTT,
										x10.util.Random.$RTT), range,
								x10.lang.LongRange.$RTT, json,
								cassia.util.JSON.Value.$RTT, agents,
								x10.rtt.ParameterizedType.make(
										x10.lang.Settable.$RTT,
										x10.rtt.Types.LONG, plham.Agent.$RTT));
			}
		} catch (final java.lang.RuntimeException e) {

			// #line 333 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.io.Printer t$24039 = ((x10.io.Printer) (x10.io.Console
					.get$ERR()));

			// #line 333 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$24036 = (("An error occurred while creating ") + (name));

			// #line 333 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$24037 = ((t$24036) + (", from "));

			// #line 333 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$24038 = plham.util.JSON
					.dump(((cassia.util.JSON.Value) (json)));

			// #line 333 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$24040 = ((t$24037) + (t$24038));

			// #line 333 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			t$24039.println(((java.lang.Object) (t$24040)));

			// #line 334 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			throw e;
		}
	}

	// #line 339 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.List createAllEvents(final cassia.util.JSON.Value list) {

		// #line 340 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.ArrayList allEvents = ((x10.util.ArrayList) (new x10.util.ArrayList<plham.Event>(
				(java.lang.System[]) null, plham.Event.$RTT)
				.x10$util$ArrayList$$init$S()));

		// #line 341 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		long id = 0L;

		// #line 342 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23661min$24470 = 0L;

		// #line 342 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long t$24471 = list.size$O();

		// #line 342 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23661max$24472 = ((t$24471) - (((long) (1L))));

		// #line 342 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		long i$24467 = i$23661min$24470;

		// #line 342 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 342 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24468 = i$24467;

			// #line 342 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24469 = ((t$24468) <= (((long) (i$23661max$24472))));

			// #line 342 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24469)) {

				// #line 342
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 342 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$24464 = i$24467;

			// #line 343 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final cassia.util.JSON.Value t$24430 = ((cassia.util.JSON.Value) list)
					.<x10.core.Long> get(x10.rtt.Types.LONG,
							x10.core.Long.$box(i$24464));

			// #line 343 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String name$24431 = t$24430.toString();

			// #line 344 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.List events$24432;

			// #line 345 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final cassia.util.JSON.Value t$24433 = ((cassia.util.JSON.Value) (this.CONFIG));

			// #line 345 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final cassia.util.JSON.Value t$24434 = ((cassia.util.JSON.Value) t$24433)
					.<java.lang.String> get(x10.rtt.Types.STRING,
							((java.lang.String) (name$24431)));

			// #line 345 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final cassia.util.JSON.Value t$24435 = ((cassia.util.JSON.Value) t$24434)
					.<java.lang.String> get(x10.rtt.Types.STRING,
							((java.lang.String) ("class")));

			// #line 345 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String className$24436 = t$24435.toString();

			// #line 346 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24437 = (className$24436).equals("EventGroup");

			// #line 346 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (t$24437) {

				// #line 347
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value t$24438 = ((cassia.util.JSON.Value) (this.CONFIG));

				// #line 347
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value t$24439 = ((cassia.util.JSON.Value) t$24438)
						.<java.lang.String> get(x10.rtt.Types.STRING,
								((java.lang.String) (name$24431)));

				// #line 347
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.util.List t$24440 = this
						.<plham.Event> createItemGroup(plham.Event.$RTT,
								((cassia.util.JSON.Value) (t$24439)),
								((java.lang.String) ("EventGroup")),
								((java.lang.String) ("events")));

				// #line 347
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				events$24432 = ((x10.util.List) (t$24440));
			} else {

				// #line 349
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				assert ((x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_4<x10.core.Long, java.lang.String, x10.util.Random, cassia.util.JSON.Value, plham.Event>>) this.eventInitializers)
						.containsKey__0x10$util$HashMap$$K$O(((java.lang.String) (className$24436))) : ((className$24436) + ("\'s initializer is not registered."));

				// #line 350
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.util.HashMap t$24441 = ((x10.util.HashMap) (this.eventInitializers));

				// #line 350
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.core.fun.Fun_0_4 initializer$24442 = ((x10.util.HashMap<java.lang.String, x10.core.fun.Fun_0_4<x10.core.Long, java.lang.String, x10.util.Random, cassia.util.JSON.Value, plham.Event>>) t$24441)
						.$apply__0x10$util$HashMap$$K$G(((java.lang.String) (className$24436)));

				// #line 351
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				plham.Event ev$24443 = null;

				// #line 352
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				try {
					{

						// #line 353
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final long pre$24444 = id;

						// #line 353
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final long t$24445 = id;

						// #line 353
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final long t$24446 = ((t$24445) + (((long) (1L))));

						// #line 353
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						id = t$24446;

						// #line 353
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final x10.util.Random t$24447 = this.getRandom();

						// #line 353
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final x10.util.Random t$24448 = ((x10.util.Random) (t$24447
								.split()));

						// #line 353
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final cassia.util.JSON.Value t$24449 = ((cassia.util.JSON.Value) (this.CONFIG));

						// #line 353
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final cassia.util.JSON.Value t$24450 = ((cassia.util.JSON.Value) t$24449)
								.<java.lang.String> get(x10.rtt.Types.STRING,
										((java.lang.String) (name$24431)));

						// #line 353
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final plham.Event t$24451 = ((plham.Event) ((x10.core.fun.Fun_0_4<x10.core.Long, java.lang.String, x10.util.Random, cassia.util.JSON.Value, plham.Event>) initializer$24442)
								.$apply(x10.core.Long.$box(pre$24444),
										x10.rtt.Types.LONG, name$24431,
										x10.rtt.Types.STRING, t$24448,
										x10.util.Random.$RTT, t$24450,
										cassia.util.JSON.Value.$RTT));

						// #line 353
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						ev$24443 = ((plham.Event) (t$24451));
					}
				} catch (final java.lang.RuntimeException e$24452) {

					// #line 355
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final x10.io.Printer t$24453 = ((x10.io.Printer) (x10.io.Console
							.get$ERR()));

					// #line 355
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final java.lang.String t$24454 = (("An error occurred while creating ") + (name$24431));

					// #line 355
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final java.lang.String t$24455 = ((t$24454) + (", from "));

					// #line 355
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final cassia.util.JSON.Value t$24456 = ((cassia.util.JSON.Value) (this.CONFIG));

					// #line 355
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final cassia.util.JSON.Value t$24457 = ((cassia.util.JSON.Value) t$24456)
							.<java.lang.String> get(x10.rtt.Types.STRING,
									((java.lang.String) (name$24431)));

					// #line 355
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final java.lang.String t$24458 = plham.util.JSON
							.dump(((cassia.util.JSON.Value) (t$24457)));

					// #line 355
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final java.lang.String t$24459 = ((t$24455) + (t$24458));

					// #line 355
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					t$24453.println(((java.lang.Object) (t$24459)));

					// #line 356
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					throw e$24452;
				}

				// #line 358
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.util.ArrayList t$24460 = ((x10.util.ArrayList) (new x10.util.ArrayList<plham.Event>(
						(java.lang.System[]) null, plham.Event.$RTT)
						.x10$util$ArrayList$$init$S()));

				// #line 358
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				events$24432 = ((x10.util.List) (t$24460));

				// #line 359
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final plham.Event t$24461 = ((plham.Event) (ev$24443));

				// #line 359
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				((x10.util.Collection<plham.Event>) events$24432).add$Z(
						((plham.Event) (t$24461)), plham.Event.$RTT);
			}

			// #line 361 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			((x10.util.AbstractCollection<plham.Event>) allEvents)
					.addAll__0$1x10$util$AbstractCollection$$T$2$O(((x10.util.Container) (events$24432)));

			// #line 362 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.Map t$24462 = ((x10.util.Map) (this.GLOBAL));

			// #line 362 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.Object t$24463 = ((java.lang.Object) events$24432);

			// #line 362 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			((x10.util.Map<java.lang.String, java.lang.Object>) t$24462).$set(
					((java.lang.String) (name$24431)), x10.rtt.Types.STRING,
					((java.lang.Object) (t$24463)), x10.rtt.Types.ANY);

			// #line 342 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24465 = i$24467;

			// #line 342 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24466 = ((t$24465) + (((long) (1L))));

			// #line 342 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			i$24467 = t$24466;
		}

		// #line 364 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return allEvents;
	}

	// #line 372 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/**
	 * Override this to create events.
	 * 
	 * @param json
	 *            a JSON object, or properties of events.
	 * @return a list of events.
	 */
	public x10.util.List createEvents(final cassia.util.JSON.Value json) {

		// #line 373 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		assert false : "createEvents is not defined in the Simulator class.";

		// #line 374 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.ArrayList t$24074 = ((x10.util.ArrayList) (new x10.util.ArrayList<plham.Event>(
				(java.lang.System[]) null, plham.Event.$RTT)
				.x10$util$ArrayList$$init$S()));

		// #line 374 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24074;
	}

	// #line 383 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/**
	 * Create an instance of Fundamentals based on the JSON object.
	 * 
	 * @param markets
	 * @param json
	 *            a JSON object, or properties of correlations of fundamentals
	 * @return a fundamentals
	 */
	public plham.Fundamentals createFundamentals__0$1plham$Market$2(
			final x10.util.List markets, final cassia.util.JSON.Value json) {

		// #line 384 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.Random t$24075 = ((x10.util.Random) (this.RANDOM));

		// #line 384 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final plham.util.JSONRandom random = ((plham.util.JSONRandom) (new plham.util.JSONRandom(
				(java.lang.System[]) null)
				.plham$util$JSONRandom$$init$S(t$24075)));

		// #line 386 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long N = ((x10.util.Container<plham.Market>) markets).size$O();

		// #line 387 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.Random t$24076 = ((x10.util.Random) (this.RANDOM));

		// #line 387 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final plham.Fundamentals f = ((plham.Fundamentals) (new plham.Fundamentals(
				(java.lang.System[]) null).init(t$24076)));

		// #line 389 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23679min$24524 = 0L;

		// #line 389 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23679max$24525 = ((N) - (((long) (1L))));

		// #line 389 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		long i$24483 = i$23679min$24524;

		// #line 389 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 389 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24484 = i$24483;

			// #line 389 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24485 = ((t$24484) <= (((long) (i$23679max$24525))));

			// #line 389 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24485)) {

				// #line 389
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 389 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$24480 = i$24483;

			// #line 390 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final plham.Market m$24473 = ((x10.util.Indexed<plham.Market>) markets)
					.$apply$G((long) (i$24480));

			// #line 391 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			double initialPrice$24474 = ((double) (long) (((long) (0L))));

			// #line 392 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			try {
				{

					// #line 393
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					final double t$24475 = m$24473
							.getInitialFundamentalPrice$O();

					// #line 393
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					initialPrice$24474 = t$24475;
				}
			} catch (final java.util.NoSuchElementException e$24476) {

				// #line 395
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				try {
					{

						// #line 396
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						final double t$24477 = m$24473
								.getInitialMarketPrice$O();

						// #line 396
						// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
						initialPrice$24474 = t$24477;
					}
				} catch (final java.util.NoSuchElementException e$24478) {

					// #line 398
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					assert false : "there\'s no initial fundamental or market price definition in config.";
				}
			}

			// #line 401 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final double t$24479 = initialPrice$24474;

			// #line 401 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			f.setInitial(((plham.Market) (m$24473)), (double) (t$24479));

			// #line 389 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24481 = i$24483;

			// #line 389 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24482 = ((t$24481) + (((long) (1L))));

			// #line 389 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			i$24483 = t$24482;
		}

		// #line 403 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23697min$24526 = 0L;

		// #line 403 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23697max$24527 = ((N) - (((long) (1L))));

		// #line 403 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		long i$24490 = i$23697min$24526;

		// #line 403 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 403 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24491 = i$24490;

			// #line 403 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24492 = ((t$24491) <= (((long) (i$23697max$24527))));

			// #line 403 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24492)) {

				// #line 403
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 403 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$24487 = i$24490;

			// #line 404 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final plham.Market m$24486 = ((x10.util.Indexed<plham.Market>) markets)
					.$apply$G((long) (i$24487));

			// #line 405 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			f.setDrift(((plham.Market) (m$24486)), (double) (0.0));

			// #line 403 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24488 = i$24490;

			// #line 403 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24489 = ((t$24488) + (((long) (1L))));

			// #line 403 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			i$24490 = t$24489;
		}

		// #line 409 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23715min$24528 = 0L;

		// #line 409 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23715max$24529 = ((N) - (((long) (1L))));

		// #line 409 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		long i$24498 = i$23715min$24528;

		// #line 409 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 409 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24499 = i$24498;

			// #line 409 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24500 = ((t$24499) <= (((long) (i$23715max$24529))));

			// #line 409 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24500)) {

				// #line 409
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 409 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$24495 = i$24498;

			// #line 410 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final plham.Market m$24493 = ((x10.util.Indexed<plham.Market>) markets)
					.$apply$G((long) (i$24495));

			// #line 411 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final double t$24494 = m$24493.getFundamentalVolatility$O();

			// #line 411 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			f.setVolatility(((plham.Market) (m$24493)), (double) (t$24494));

			// #line 409 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24496 = i$24498;

			// #line 409 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24497 = ((t$24496) + (((long) (1L))));

			// #line 409 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			i$24498 = t$24497;
		}

		// #line 413 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final boolean t$24106 = ((cassia.util.JSON.Value) json)
				.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(
						x10.rtt.Types.STRING, ((java.lang.String) ("pairwise")));

		// #line 413 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		if (t$24106) {

			// #line 414 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final cassia.util.JSON.Value edges = ((cassia.util.JSON.Value) json)
					.<java.lang.String> get(x10.rtt.Types.STRING,
							((java.lang.String) ("pairwise")));

			// #line 415 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$23733min$24514 = 0L;

			// #line 415 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24515 = edges.size$O();

			// #line 415 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$23733max$24516 = ((t$24515) - (((long) (1L))));

			// #line 415 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			long i$24511 = i$23733min$24514;

			// #line 415 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			for (; true;) {

				// #line 415
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24512 = i$24511;

				// #line 415
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final boolean t$24513 = ((t$24512) <= (((long) (i$23733max$24516))));

				// #line 415
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				if (!(t$24513)) {

					// #line 415
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					break;
				}

				// #line 415
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long k$24508 = i$24511;

				// #line 416
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value triple$24501 = ((cassia.util.JSON.Value) edges)
						.<x10.core.Long> get(x10.rtt.Types.LONG,
								x10.core.Long.$box(k$24508));

				// #line 417
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value t$24502 = ((cassia.util.JSON.Value) triple$24501)
						.<x10.core.Long> get(x10.rtt.Types.LONG,
								x10.core.Long.$box(0L));

				// #line 417
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final plham.Market mi$24503 = this
						.<plham.Market> getItemByName$G(plham.Market.$RTT,
								((cassia.util.JSON.Value) (t$24502)));

				// #line 418
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value t$24504 = ((cassia.util.JSON.Value) triple$24501)
						.<x10.core.Long> get(x10.rtt.Types.LONG,
								x10.core.Long.$box(1L));

				// #line 418
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final plham.Market mj$24505 = this
						.<plham.Market> getItemByName$G(plham.Market.$RTT,
								((cassia.util.JSON.Value) (t$24504)));

				// #line 419
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value t$24506 = ((cassia.util.JSON.Value) triple$24501)
						.<x10.core.Long> get(x10.rtt.Types.LONG,
								x10.core.Long.$box(2L));

				// #line 419
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final double t$24507 = random
						.nextRandom$O(((cassia.util.JSON.Value) (t$24506)));

				// #line 419
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				f.setCorrelation(((plham.Market) (mi$24503)),
						((plham.Market) (mj$24505)), (double) (t$24507));

				// #line 415
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24509 = i$24511;

				// #line 415
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24510 = ((t$24509) + (((long) (1L))));

				// #line 415
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				i$24511 = t$24510;
			}
		}

		// #line 422 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23751min$24530 = 0L;

		// #line 422 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23751max$24531 = ((N) - (((long) (1L))));

		// #line 422 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		long i$24521 = i$23751min$24530;

		// #line 422 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 422 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24522 = i$24521;

			// #line 422 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24523 = ((t$24522) <= (((long) (i$23751max$24531))));

			// #line 422 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24523)) {

				// #line 422
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 422 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$24518 = i$24521;

			// #line 423 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final plham.Market m$24517 = ((x10.util.Indexed<plham.Market>) markets)
					.$apply$G((long) (i$24518));

			// #line 424 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			f.setCorrelation(((plham.Market) (m$24517)),
					((plham.Market) (m$24517)), (double) (1.0));

			// #line 422 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24519 = i$24521;

			// #line 422 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24520 = ((t$24519) + (((long) (1L))));

			// #line 422 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			i$24521 = t$24520;
		}

		// #line 427 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		f.setup();

		// #line 429 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return f;
	}

	// #line 435 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/** For system use only. */
	public void updateFundamentals(final plham.Fundamentals f) {

		// #line 436 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		f.update();
	}

	// #line 440 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/** For system use only. */
	public void updateMarketsUsingFundamentalPrice__0$1plham$Market$2(
			final x10.util.List markets, final plham.Fundamentals fundamentals) {

		// #line 441 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.ListIterator market$23769 = ((x10.util.ListIterator<plham.Market>) ((x10.util.List<plham.Market>) markets)
				.iterator());

		// #line 441 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 441 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24117 = ((x10.util.ListIterator<plham.Market>) market$23769)
					.hasNext$O();

			// #line 441 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24117)) {

				// #line 441
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 441 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final plham.Market market$24532 = ((plham.Market) (((x10.util.ListIterator<plham.Market>) market$23769)
					.next$G()));

			// #line 442 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24533 = plham.IndexMarket.$RTT
					.isInstance(market$24532);

			// #line 442 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (t$24533) {

				// #line 443
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final double t$24534 = market$24532.getFundamentalPrice();

				// #line 443
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				market$24532.updateMarketPrice((double) (t$24534));
			} else {

				// #line 445
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				double nextFundamental$24535 = fundamentals
						.get(((plham.Market) (market$24532)));

				// #line 446
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final double t$24536 = nextFundamental$24535;

				// #line 446
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				market$24532.updateMarketPrice((double) (t$24536));

				// #line 447
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final double t$24537 = nextFundamental$24535;

				// #line 447
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				market$24532.updateFundamentalPrice((double) (t$24537));
			}

			// #line 449 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			market$24532.updateOrderBooks();
		}
	}

	// #line 454 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/** For system use only. */
	public void updateMarketsUsingMarketPrice__0$1plham$Market$2(
			final x10.util.List markets, final plham.Fundamentals fundamentals) {

		// #line 455 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.ListIterator market$23771 = ((x10.util.ListIterator<plham.Market>) ((x10.util.List<plham.Market>) markets)
				.iterator());

		// #line 455 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 455 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24122 = ((x10.util.ListIterator<plham.Market>) market$23771)
					.hasNext$O();

			// #line 455 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24122)) {

				// #line 455
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 455 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final plham.Market market$24538 = ((plham.Market) (((x10.util.ListIterator<plham.Market>) market$23771)
					.next$G()));

			// #line 456 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			market$24538.updateMarketPrice();

			// #line 457 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24539 = plham.IndexMarket.$RTT
					.isInstance(market$24538);

			// #line 457 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24540 = !(t$24539);

			// #line 457 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (t$24540) {

				// #line 459
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				double nextFundamental$24541 = fundamentals
						.get(((plham.Market) (market$24538)));

				// #line 460
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final double t$24542 = nextFundamental$24541;

				// #line 460
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				market$24538.updateFundamentalPrice((double) (t$24542));
			}

			// #line 462 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			market$24538.updateOrderBooks();
		}
	}

	// #line 471 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/**
	 * Get a list of items (instances) stored in GLOBAL by the name.
	 * 
	 * @param name
	 *            a section name defined in the JSON config file.
	 * @return a list of instances having the name.
	 */
	public <$T> x10.util.List getItemsByName(final x10.rtt.Type $T,
			final java.lang.String name) {

		// #line 472 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.Map t$24123 = ((x10.util.Map) (this.GLOBAL));

		// #line 472 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final java.lang.Object t$24124 = ((java.lang.Object) ((x10.util.Map<java.lang.String, java.lang.Object>) t$24123)
				.$apply(((java.lang.String) (name)), x10.rtt.Types.STRING));

		// #line 472 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24125 = x10.rtt.Types
				.<x10.util.List<$T>> cast(t$24124,
						x10.rtt.ParameterizedType.make(x10.util.List.$RTT, $T));

		// #line 472 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24125;
	}

	// #line 482 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/**
	 * Get an item (instance) stored in GLOBAL by the name. Since in GLOBAL even
	 * a single item is stored as <code>List</code>, the size must be 1. This
	 * throws an exception if the size is &gt; 1.
	 * 
	 * @param name
	 *            a section name defined in the JSON config file.
	 * @return an instance having the name.
	 */
	public <$T> $T getItemByName$G(final x10.rtt.Type $T,
			final java.lang.String name) {

		// #line 483 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List items = this.<$T> getItemsByName($T,
				((java.lang.String) (name)));

		// #line 484 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		assert ((long) ((x10.util.Container<$T>) items).size$O()) == ((long) 1L) : "getItemByName() got more than one object";

		// #line 485 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final $T t$24126 = (($T) (((x10.util.Indexed<$T>) items)
				.$apply$G((long) (0L))));

		// #line 485 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24126;
	}

	// #line 494 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/**
	 * Get a list of items (instances) stored in GLOBAL specified by the list of
	 * names.
	 * 
	 * @param names
	 *            section names defined in the JSON config file.
	 * @param n
	 *            the length of names.
	 * @return a list of instances having the names.
	 */
	public <$T> x10.util.List getItemsByName__0$1x10$lang$Long$3x10$lang$String$2(
			final x10.rtt.Type $T, final x10.core.fun.Fun_0_1 names,
			final long n) {

		// #line 495 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.ArrayList items = ((x10.util.ArrayList) (new x10.util.ArrayList<$T>(
				(java.lang.System[]) null, $T).x10$util$ArrayList$$init$S()));

		// #line 496 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23773min$24551 = 0L;

		// #line 496 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23773max$24552 = ((n) - (((long) (1L))));

		// #line 496 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		long i$24548 = i$23773min$24551;

		// #line 496 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 496 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24549 = i$24548;

			// #line 496 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24550 = ((t$24549) <= (((long) (i$23773max$24552))));

			// #line 496 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24550)) {

				// #line 496
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 496 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$24545 = i$24548;

			// #line 497 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$24543 = ((java.lang.String) ((x10.core.fun.Fun_0_1<x10.core.Long, java.lang.String>) names)
					.$apply(x10.core.Long.$box(i$24545), x10.rtt.Types.LONG));

			// #line 497 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.List t$24544 = this.<$T> getItemsByName($T,
					((java.lang.String) (t$24543)));

			// #line 497 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			((x10.util.AbstractCollection<$T>) items)
					.addAll__0$1x10$util$AbstractCollection$$T$2$O(((x10.util.Container) (t$24544)));

			// #line 496 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24546 = i$24548;

			// #line 496 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24547 = ((t$24546) + (((long) (1L))));

			// #line 496 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			i$24548 = t$24547;
		}

		// #line 499 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return items;
	}

	// #line 507 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/**
	 * Get a list of items (instances) stored in GLOBAL specified by the list of
	 * names.
	 * 
	 * @param json
	 *            section name(s) (String or List) defined in the JSON config
	 *            file.
	 * @return a list of instances having the name(s).
	 */
	public <$T> x10.util.List getItemsByName(final x10.rtt.Type $T,
			final cassia.util.JSON.Value json) {

		// #line 508 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final boolean t$24139 = json.isList$O();

		// #line 508 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		if (t$24139) {

			// #line 509 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.core.fun.Fun_0_1 t$24136 = ((x10.core.fun.Fun_0_1) (new plham.main.Simulator.$Closure$12<$T>(
					$T, json)));

			// #line 509 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24137 = json.size$O();

			// #line 509 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.List t$24138 = this
					.<$T> getItemsByName__0$1x10$lang$Long$3x10$lang$String$2(
							$T, ((x10.core.fun.Fun_0_1) (t$24136)),
							(long) (t$24137));

			// #line 509 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			return t$24138;
		}

		// #line 511 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final java.lang.String t$24140 = json.toString();

		// #line 511 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24141 = this.<$T> getItemsByName($T,
				((java.lang.String) (t$24140)));

		// #line 511 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24141;
	}

	// #line 521 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/**
	 * Get an item (instance) stored in GLOBAL by the name. Since in GLOBAL even
	 * a single item is stored as <code>List</code>, the size must be 1. This
	 * throws an exception if the size is &gt; 1.
	 * 
	 * @param json
	 *            a section name (String or List) defined in the JSON config
	 *            file.
	 * @return an instance having the name.
	 */
	public <$T> $T getItemByName$G(final x10.rtt.Type $T,
			final cassia.util.JSON.Value json) {

		// #line 522 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List items = this.<$T> getItemsByName($T,
				((cassia.util.JSON.Value) (json)));

		// #line 523 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		assert ((long) ((x10.util.Container<$T>) items).size$O()) == ((long) 1L) : "getItemByName() got more than one object";

		// #line 524 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final $T t$24142 = (($T) (((x10.util.Indexed<$T>) items)
				.$apply$G((long) (0L))));

		// #line 524 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24142;
	}

	// #line 533 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/**
	 * Get a list of items (instances) stored in GLOBAL by the name.
	 * 
	 * @param name
	 *            a section name defined in the JSON config file.
	 * @return a list of instances having the name.
	 */
	public <$T> x10.util.List getItemsByName0__0$1x10$lang$String$3x10$util$List$1plham$main$Simulator$$T$2$2(
			final x10.rtt.Type $T, final x10.util.Map kv,
			final java.lang.String name) {

		// #line 534 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24143 = ((x10.util.List<$T>) ((x10.util.Map<java.lang.String, x10.util.List<$T>>) kv)
				.$apply(((java.lang.String) (name)), x10.rtt.Types.STRING));

		// #line 534 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24144 = ((x10.util.List<$T>) t$24143);

		// #line 534 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24144;
	}

	// #line 544 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/**
	 * Get an item (instance) stored in GLOBAL by the name. Since in GLOBAL even
	 * a single item is stored as <code>List</code>, the size must be 1. This
	 * throws an exception if the size is &gt; 1.
	 * 
	 * @param name
	 *            a section name defined in the JSON config file.
	 * @return an instance having the name.
	 */
	public <$T> $T getItemByName0__0$1x10$lang$String$3x10$util$List$1plham$main$Simulator$$T$2$2$G(
			final x10.rtt.Type $T, final x10.util.Map kv,
			final java.lang.String name) {

		// #line 545 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List items = this
				.<$T> getItemsByName0__0$1x10$lang$String$3x10$util$List$1plham$main$Simulator$$T$2$2(
						$T, ((x10.util.Map) (kv)), ((java.lang.String) (name)));

		// #line 546 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		assert ((long) ((x10.util.Container<$T>) items).size$O()) == ((long) 1L) : "getItemByName0() got more than one object";

		// #line 547 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final $T t$24145 = (($T) (((x10.util.Indexed<$T>) items)
				.$apply$G((long) (0L))));

		// #line 547 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24145;
	}

	// #line 556 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/**
	 * Get a list of items (instances) stored in GLOBAL specified by the list of
	 * names.
	 * 
	 * @param names
	 *            section names defined in the JSON config file.
	 * @param n
	 *            the length of names.
	 * @return a list of instances having the names.
	 */
	public <$T> x10.util.List getItemsByName0__0$1x10$lang$String$3x10$util$List$1plham$main$Simulator$$T$2$2__1$1x10$lang$Long$3x10$lang$String$2(
			final x10.rtt.Type $T, final x10.util.Map kv,
			final x10.core.fun.Fun_0_1 names, final long n) {

		// #line 557 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.ArrayList items = ((x10.util.ArrayList) (new x10.util.ArrayList<$T>(
				(java.lang.System[]) null, $T).x10$util$ArrayList$$init$S()));

		// #line 558 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23791min$24569 = 0L;

		// #line 558 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long i$23791max$24570 = ((n) - (((long) (1L))));

		// #line 558 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		long i$24566 = i$23791min$24569;

		// #line 558 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 558 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24567 = i$24566;

			// #line 558 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24568 = ((t$24567) <= (((long) (i$23791max$24570))));

			// #line 558 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24568)) {

				// #line 558
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 558 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$24563 = i$24566;

			// #line 559 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$24553 = ((java.lang.String) ((x10.core.fun.Fun_0_1<x10.core.Long, java.lang.String>) names)
					.$apply(x10.core.Long.$box(i$24563), x10.rtt.Types.LONG));

			// #line 559 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.List r$24554 = this
					.<$T> getItemsByName0__0$1x10$lang$String$3x10$util$List$1plham$main$Simulator$$T$2$2(
							$T, ((x10.util.Map) (kv)),
							((java.lang.String) (t$24553)));

			// #line 560 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24555 = ((r$24554) == (null));

			// #line 560 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (t$24555) {

				// #line 560
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.io.Printer t$24556 = ((x10.io.Printer) (x10.io.Console
						.get$OUT()));

				// #line 560
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final java.lang.String t$24557 = (("~~~~") + (x10.x10rt.X10RT
						.here()));

				// #line 560
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final java.lang.String t$24558 = ((t$24557) + (":"));

				// #line 560
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final java.lang.String t$24559 = ((t$24558) + (kv));

				// #line 560
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final java.lang.String t$24560 = ((t$24559) + (":"));

				// #line 560
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final java.lang.String t$24561 = ((java.lang.String) ((x10.core.fun.Fun_0_1<x10.core.Long, java.lang.String>) names)
						.$apply(x10.core.Long.$box(i$24563), x10.rtt.Types.LONG));

				// #line 560
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final java.lang.String t$24562 = ((t$24560) + (t$24561));

				// #line 560
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				t$24556.println(((java.lang.Object) (t$24562)));
			} else {

				// #line 561
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				((x10.util.AbstractCollection<$T>) items)
						.addAll__0$1x10$util$AbstractCollection$$T$2$O(((x10.util.Container) (r$24554)));
			}

			// #line 558 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24564 = i$24566;

			// #line 558 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24565 = ((t$24564) + (((long) (1L))));

			// #line 558 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			i$24566 = t$24565;
		}

		// #line 563 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return items;
	}

	// #line 571 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/**
	 * Get a list of items (instances) stored in GLOBAL specified by the list of
	 * names.
	 * 
	 * @param json
	 *            section name(s) (String or List) defined in the JSON config
	 *            file.
	 * @return a list of instances having the name(s).
	 */
	public <$T> x10.util.List getItemsByName0__0$1x10$lang$String$3x10$util$List$1plham$main$Simulator$$T$2$2(
			final x10.rtt.Type $T, final x10.util.Map kv,
			final cassia.util.JSON.Value json) {

		// #line 572 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final boolean t$24165 = json.isList$O();

		// #line 572 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		if (t$24165) {

			// #line 573 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.core.fun.Fun_0_1 t$24162 = ((x10.core.fun.Fun_0_1) (new plham.main.Simulator.$Closure$13<$T>(
					$T, json)));

			// #line 573 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long t$24163 = json.size$O();

			// #line 573 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.List t$24164 = this
					.<$T> getItemsByName0__0$1x10$lang$String$3x10$util$List$1plham$main$Simulator$$T$2$2__1$1x10$lang$Long$3x10$lang$String$2(
							$T, ((x10.util.Map) (kv)),
							((x10.core.fun.Fun_0_1) (t$24162)),
							(long) (t$24163));

			// #line 573 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			return t$24164;
		}

		// #line 575 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final java.lang.String t$24166 = json.toString();

		// #line 575 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24167 = this
				.<$T> getItemsByName0__0$1x10$lang$String$3x10$util$List$1plham$main$Simulator$$T$2$2(
						$T, ((x10.util.Map) (kv)),
						((java.lang.String) (t$24166)));

		// #line 575 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24167;
	}

	// #line 585 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	/**
	 * Get an item (instance) stored in GLOBAL by the name. Since in GLOBAL even
	 * a single item is stored as <code>List</code>, the size must be 1. This
	 * throws an exception if the size is &gt; 1.
	 * 
	 * @param json
	 *            a section name (String or List) defined in the JSON config
	 *            file.
	 * @return an instance having the name.
	 */
	public <$T> $T getItemByName0__0$1x10$lang$String$3x10$util$List$1plham$main$Simulator$$T$2$2$G(
			final x10.rtt.Type $T, final x10.util.Map kv,
			final cassia.util.JSON.Value json) {

		// #line 586 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List items = this
				.<$T> getItemsByName0__0$1x10$lang$String$3x10$util$List$1plham$main$Simulator$$T$2$2(
						$T, ((x10.util.Map) (kv)),
						((cassia.util.JSON.Value) (json)));

		// #line 587 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		assert ((long) ((x10.util.Container<$T>) items).size$O()) == ((long) 1L) : "getItemByName0() got more than one object";

		// #line 588 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final $T t$24168 = (($T) (((x10.util.Indexed<$T>) items)
				.$apply$G((long) (0L))));

		// #line 588 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24168;
	}

	// #line 593 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	private plham.Market marketConverter1(final x10.lang.LongRange range) {

		// #line 594 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24169 = ((x10.util.List) (this.markets));

		// #line 594 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long t$24170 = range.min;

		// #line 594 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final plham.Market t$24171 = ((x10.util.Indexed<plham.Market>) t$24169)
				.$apply$G((long) (t$24170));

		// #line 594 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24171;
	}

	public static plham.Market marketConverter1$P(
			final x10.lang.LongRange range, final plham.main.Simulator Simulator) {
		return Simulator.marketConverter1(((x10.lang.LongRange) (range)));
	}

	// #line 596 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	private x10.util.List marketConverterM__0$1x10$lang$LongRange$2(
			final x10.util.List ranges) {

		// #line 598 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.ArrayList result = ((x10.util.ArrayList) (new x10.util.ArrayList<plham.Market>(
				(java.lang.System[]) null, plham.Market.$RTT)
				.x10$util$ArrayList$$init$S()));

		// #line 599 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.ListIterator range$24583 = ((x10.util.ListIterator<x10.lang.LongRange>) ((x10.util.List<x10.lang.LongRange>) ranges)
				.iterator());

		// #line 599 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		for (; true;) {

			// #line 599 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$24584 = ((x10.util.ListIterator<x10.lang.LongRange>) range$24583)
					.hasNext$O();

			// #line 599 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (!(t$24584)) {

				// #line 599
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				break;
			}

			// #line 599 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.lang.LongRange range$24582 = ((x10.lang.LongRange) (((x10.util.ListIterator<x10.lang.LongRange>) range$24583)
					.next$G()));

			// #line 599 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.lang.LongRange i$23809domain$24579 = ((x10.lang.LongRange) (range$24582));

			// #line 599 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$23809min$24580 = i$23809domain$24579.min;

			// #line 599 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$23809max$24581 = i$23809domain$24579.max;

			// #line 599 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			long i$24576 = i$23809min$24580;

			// #line 599 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			for (; true;) {

				// #line 599
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24577 = i$24576;

				// #line 599
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final boolean t$24578 = ((t$24577) <= (((long) (i$23809max$24581))));

				// #line 599
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				if (!(t$24578)) {

					// #line 599
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					break;
				}

				// #line 599
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long i$24573 = i$24576;

				// #line 599
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.util.List t$24571 = ((x10.util.List) (this.markets));

				// #line 599
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final plham.Market t$24572 = ((x10.util.Indexed<plham.Market>) t$24571)
						.$apply$G((long) (i$24573));

				// #line 599
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				((x10.util.ArrayList<plham.Market>) result)
						.add__0x10$util$ArrayList$$T$O(((plham.Market) (t$24572)));

				// #line 599
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24574 = i$24576;

				// #line 599
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24575 = ((t$24574) + (((long) (1L))));

				// #line 599
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				i$24576 = t$24575;
			}
		}

		// #line 600 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return result;
	}

	public static x10.util.List marketConverterM$P__0$1x10$lang$LongRange$2(
			final x10.util.List<x10.lang.LongRange> ranges,
			final plham.main.Simulator Simulator) {
		return Simulator
				.marketConverterM__0$1x10$lang$LongRange$2(((x10.util.List) (ranges)));
	}

	// #line 605 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.List getMarketsByName(final cassia.util.JSON.Value json) {

		// #line 606 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.Map t$24181 = ((x10.util.Map) (this.marketName2Ranges));

		// #line 606 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24182 = this
				.<x10.lang.LongRange> getItemsByName0__0$1x10$lang$String$3x10$util$List$1plham$main$Simulator$$T$2$2(
						x10.lang.LongRange.$RTT, ((x10.util.Map) (t$24181)),
						((cassia.util.JSON.Value) (json)));

		// #line 606 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24183 = this
				.marketConverterM__0$1x10$lang$LongRange$2(((x10.util.List) (t$24182)));

		// #line 606 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24183;
	}

	// #line 609 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public plham.Market getMarketByName(final cassia.util.JSON.Value json) {

		// #line 609 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.Map t$24184 = ((x10.util.Map) (this.marketName2Ranges));

		// #line 609 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.lang.LongRange t$24185 = this
				.<x10.lang.LongRange> getItemByName0__0$1x10$lang$String$3x10$util$List$1plham$main$Simulator$$T$2$2$G(
						x10.lang.LongRange.$RTT, ((x10.util.Map) (t$24184)),
						((cassia.util.JSON.Value) (json)));

		// #line 609 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final plham.Market t$24186 = this
				.marketConverter1(((x10.lang.LongRange) (t$24185)));

		// #line 609 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24186;
	}

	// #line 611 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.List getMarketsByName__0$1x10$lang$String$2(
			final x10.util.List names) {

		// #line 611 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.Map t$24188 = ((x10.util.Map) (this.marketName2Ranges));

		// #line 611 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.core.fun.Fun_0_1 t$24189 = ((x10.core.fun.Fun_0_1) (new plham.main.Simulator.$Closure$14(
				names,
				(plham.main.Simulator.$Closure$14.__0$1x10$lang$String$2) null)));

		// #line 611 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long t$24190 = ((x10.util.Container<java.lang.String>) names)
				.size$O();

		// #line 611 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24191 = this
				.<x10.lang.LongRange> getItemsByName0__0$1x10$lang$String$3x10$util$List$1plham$main$Simulator$$T$2$2__1$1x10$lang$Long$3x10$lang$String$2(
						x10.lang.LongRange.$RTT, ((x10.util.Map) (t$24188)),
						((x10.core.fun.Fun_0_1) (t$24189)), (long) (t$24190));

		// #line 611 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24192 = this
				.marketConverterM__0$1x10$lang$LongRange$2(((x10.util.List) (t$24191)));

		// #line 611 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24192;
	}

	// #line 613 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.List<Market> getMarketsByName(final java.lang.String name) {

		// #line 613 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.Map t$24193 = ((x10.util.Map) (this.marketName2Ranges));

		// #line 613 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24194 = this
				.<x10.lang.LongRange> getItemsByName0__0$1x10$lang$String$3x10$util$List$1plham$main$Simulator$$T$2$2(
						x10.lang.LongRange.$RTT, ((x10.util.Map) (t$24193)),
						((java.lang.String) (name)));

		// #line 613 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24195 = this
				.marketConverterM__0$1x10$lang$LongRange$2(((x10.util.List) (t$24194)));

		// #line 613 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24195;
	}

	// #line 615 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public plham.Market getMarketByName(final java.lang.String name) {

		// #line 615 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.Map t$24196 = ((x10.util.Map) (this.marketName2Ranges));

		// #line 615 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.lang.LongRange t$24197 = this
				.<x10.lang.LongRange> getItemByName0__0$1x10$lang$String$3x10$util$List$1plham$main$Simulator$$T$2$2$G(
						x10.lang.LongRange.$RTT, ((x10.util.Map) (t$24196)),
						((java.lang.String) (name)));

		// #line 615 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final plham.Market t$24198 = this
				.marketConverter1(((x10.lang.LongRange) (t$24197)));

		// #line 615 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24198;
	}

	// #line 617 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.List getAgentsByName(final cassia.util.JSON.Value json) {

		// #line 617 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24199 = this.<plham.Agent> getItemsByName(
				plham.Agent.$RTT, ((cassia.util.JSON.Value) (json)));

		// #line 617 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24199;
	}

	// #line 619 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public plham.Agent getAgentByName(final cassia.util.JSON.Value json) {

		// #line 619 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final plham.Agent t$24200 = this.<plham.Agent> getItemByName$G(
				plham.Agent.$RTT, ((cassia.util.JSON.Value) (json)));

		// #line 619 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24200;
	}

	// #line 621 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.List getAgentsByName__0$1x10$lang$String$2(
			final x10.util.List names) {

		// #line 621 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.core.fun.Fun_0_1 t$24202 = ((x10.core.fun.Fun_0_1) (new plham.main.Simulator.$Closure$15(
				names,
				(plham.main.Simulator.$Closure$15.__0$1x10$lang$String$2) null)));

		// #line 621 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long t$24203 = ((x10.util.Container<java.lang.String>) names)
				.size$O();

		// #line 621 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24204 = this
				.<plham.Agent> getItemsByName__0$1x10$lang$Long$3x10$lang$String$2(
						plham.Agent.$RTT, ((x10.core.fun.Fun_0_1) (t$24202)),
						(long) (t$24203));

		// #line 621 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24204;
	}

	// #line 623 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.List<Agent> getAgentsByName(final java.lang.String name) {

		// #line 623 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24205 = this.<plham.Agent> getItemsByName(
				plham.Agent.$RTT, ((java.lang.String) (name)));

		// #line 623 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24205;
	}

	// #line 625 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public plham.Agent getAgentByName(final java.lang.String name) {

		// #line 625 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final plham.Agent t$24206 = this.<plham.Agent> getItemByName$G(
				plham.Agent.$RTT, ((java.lang.String) (name)));

		// #line 625 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24206;
	}

	// #line 627 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.List getEventsByName(final cassia.util.JSON.Value json) {

		// #line 627 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24207 = this.<plham.Event> getItemsByName(
				plham.Event.$RTT, ((cassia.util.JSON.Value) (json)));

		// #line 627 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24207;
	}

	// #line 629 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public plham.Event getEventByName(final cassia.util.JSON.Value json) {

		// #line 629 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final plham.Event t$24208 = this.<plham.Event> getItemByName$G(
				plham.Event.$RTT, ((cassia.util.JSON.Value) (json)));

		// #line 629 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24208;
	}

	// #line 631 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.List getEventsByName__0$1x10$lang$String$2(
			final x10.util.List names) {

		// #line 631 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.core.fun.Fun_0_1 t$24210 = ((x10.core.fun.Fun_0_1) (new plham.main.Simulator.$Closure$16(
				names,
				(plham.main.Simulator.$Closure$16.__0$1x10$lang$String$2) null)));

		// #line 631 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final long t$24211 = ((x10.util.Container<java.lang.String>) names)
				.size$O();

		// #line 631 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24212 = this
				.<plham.Event> getItemsByName__0$1x10$lang$Long$3x10$lang$String$2(
						plham.Event.$RTT, ((x10.core.fun.Fun_0_1) (t$24210)),
						(long) (t$24211));

		// #line 631 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24212;
	}

	// #line 633 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public x10.util.List getEventsByName(final java.lang.String name) {

		// #line 633 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final x10.util.List t$24213 = this.<plham.Event> getItemsByName(
				plham.Event.$RTT, ((java.lang.String) (name)));

		// #line 633 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24213;
	}

	// #line 635 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	public plham.Event getEventByName(final java.lang.String name) {

		// #line 635 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		final plham.Event t$24214 = this.<plham.Event> getItemByName$G(
				plham.Event.$RTT, ((java.lang.String) (name)));

		// #line 635 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return t$24214;
	}

	// #line 29 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	final public plham.main.Simulator plham$main$Simulator$$this$plham$main$Simulator() {

		// #line 29 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		return plham.main.Simulator.this;
	}

	// #line 29 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
	final public void __fieldInitializers_plham_main_Simulator() {

		// #line 29 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		this.GLOBAL = null;

		// #line 29 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		this.marketName2Ranges = null;

		// #line 29 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		this.CONFIG = null;

		// #line 29 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
		this.RANDOM = null;
	}

	@x10.runtime.impl.java.X10Generated
	final public static class $Closure$10 extends x10.core.Ref implements
			x10.core.fun.VoidFun_0_5, x10.serialization.X10JavaSerializable {
		public static final x10.rtt.RuntimeType<$Closure$10> $RTT = x10.rtt.StaticVoidFunType
				.<$Closure$10> make(
						$Closure$10.class,
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
				plham.main.Simulator.$Closure$10 $_obj,
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			if (x10.runtime.impl.java.Runtime.TRACE_SER) {
				x10.runtime.impl.java.Runtime
						.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
								+ $Closure$10.class + " calling");
			}
			$_obj.initializer = $deserializer.readObject();
			return $_obj;
		}

		public static x10.serialization.X10JavaSerializable $_deserializer(
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			plham.main.Simulator.$Closure$10 $_obj = new plham.main.Simulator.$Closure$10(
					(java.lang.System[]) null);
			$deserializer.record_reference($_obj);
			return $_deserialize_body($_obj, $deserializer);
		}

		public void $_serialize(x10.serialization.X10JavaSerializer $serializer)
				throws java.io.IOException {
			$serializer.write(this.initializer);

		}

		// constructor just for allocation
		public $Closure$10(final java.lang.System[] $dummy) {

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

		// synthetic type for parameter mangling
		public static final class __0$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Agent$2 {
		}

		public void $apply__1$1x10$util$Random$2__4$1x10$lang$Long$3plham$Agent$2(
				final java.lang.String name, final x10.util.Indexed randoms,
				final x10.lang.LongRange idRange,
				final cassia.util.JSON.Value config,
				final x10.lang.Settable container) {

			// #line 102 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.lang.LongRange i$23505domain$23508 = ((x10.lang.LongRange) (idRange));

			// #line 102 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$23505min$23506 = i$23505domain$23508.min;

			// #line 102 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long i$23505max$23507 = i$23505domain$23508.max;

			// #line 102 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			long i$24220 = i$23505min$23506;

			// #line 102 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			for (; true;) {

				// #line 102
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24221 = i$24220;

				// #line 102
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final boolean t$24222 = ((t$24221) <= (((long) (i$23505max$23507))));

				// #line 102
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				if (!(t$24222)) {

					// #line 102
					// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
					break;
				}

				// #line 102
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long id$24217 = i$24220;

				// #line 103
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final x10.util.Random t$24215 = ((x10.util.Indexed<x10.util.Random>) randoms)
						.$apply$G((long) (id$24217));

				// #line 103
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final plham.Agent t$24216 = ((plham.Agent) ((x10.core.fun.Fun_0_4<x10.core.Long, java.lang.String, x10.util.Random, cassia.util.JSON.Value, plham.Agent>) this.initializer)
						.$apply(x10.core.Long.$box(id$24217),
								x10.rtt.Types.LONG, name, x10.rtt.Types.STRING,
								t$24215, x10.util.Random.$RTT, config,
								cassia.util.JSON.Value.$RTT));

				// #line 103
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				((x10.lang.Settable<x10.core.Long, plham.Agent>) container)
						.$set(x10.core.Long.$box(id$24217), x10.rtt.Types.LONG,
								((plham.Agent) (t$24216)), plham.Agent.$RTT);

				// #line 102
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24218 = i$24220;

				// #line 102
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final long t$24219 = ((t$24218) + (((long) (1L))));

				// #line 102
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				i$24220 = t$24219;
			}
		}

		public x10.core.fun.Fun_0_4<x10.core.Long, java.lang.String, x10.util.Random, cassia.util.JSON.Value, plham.Agent> initializer;

		public $Closure$10(
				final x10.core.fun.Fun_0_4<x10.core.Long, java.lang.String, x10.util.Random, cassia.util.JSON.Value, plham.Agent> initializer,
				__0$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Agent$2 $dummy) {
			{
				this.initializer = ((x10.core.fun.Fun_0_4) (initializer));
			}
		}

	}

	@x10.runtime.impl.java.X10Generated
	final public static class $Closure$11 extends x10.core.Ref implements
			x10.core.fun.Fun_0_4, x10.serialization.X10JavaSerializable {
		public static final x10.rtt.RuntimeType<$Closure$11> $RTT = x10.rtt.StaticFunType
				.<$Closure$11> make(
						$Closure$11.class,
						new x10.rtt.Type[] { x10.rtt.ParameterizedType.make(
								x10.core.fun.Fun_0_4.$RTT, x10.rtt.Types.LONG,
								x10.rtt.Types.STRING, x10.util.Random.$RTT,
								cassia.util.JSON.Value.$RTT,
								x10.rtt.ParameterizedType.make(
										x10.util.List.$RTT, plham.Market.$RTT)) });

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
				plham.main.Simulator.$Closure$11 $_obj,
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			if (x10.runtime.impl.java.Runtime.TRACE_SER) {
				x10.runtime.impl.java.Runtime
						.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
								+ $Closure$11.class + " calling");
			}
			$_obj.initializer = $deserializer.readObject();
			$_obj.out$$ = $deserializer.readObject();
			return $_obj;
		}

		public static x10.serialization.X10JavaSerializable $_deserializer(
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			plham.main.Simulator.$Closure$11 $_obj = new plham.main.Simulator.$Closure$11(
					(java.lang.System[]) null);
			$deserializer.record_reference($_obj);
			return $_deserialize_body($_obj, $deserializer);
		}

		public void $_serialize(x10.serialization.X10JavaSerializer $serializer)
				throws java.io.IOException {
			$serializer.write(this.initializer);
			$serializer.write(this.out$$);

		}

		// constructor just for allocation
		public $Closure$11(final java.lang.System[] $dummy) {

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

		// synthetic type for parameter mangling
		public static final class __1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Market$2 {
		}

		public x10.util.List $apply(final long id, final java.lang.String name,
				final x10.util.Random random, final cassia.util.JSON.Value json) {

			// #line 114 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final boolean t$23847 = ((cassia.util.JSON.Value) json)
					.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(
							x10.rtt.Types.STRING,
							((java.lang.String) ("numMarkets")));

			// #line 114 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			long t$23848 = 0;

			// #line 114 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			if (t$23847) {

				// #line 114
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				final cassia.util.JSON.Value t$23846 = ((cassia.util.JSON.Value) json)
						.<java.lang.String> get(x10.rtt.Types.STRING,
								((java.lang.String) ("numMarkets")));

				// #line 114
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				t$23848 = t$23846.toLong$O();
			} else {

				// #line 114
				// "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
				t$23848 = 1L;
			}

			// #line 114 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final long numMarkets = t$23848;

			// #line 115 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.ArrayList t$23849 = ((x10.util.ArrayList) (new x10.util.ArrayList<plham.Market>(
					(java.lang.System[]) null, plham.Market.$RTT)
					.x10$util$ArrayList$$init$S(((long) (numMarkets)))));

			// #line 115 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.List markets = ((x10.util.List<plham.Market>) t$23849);

			// #line 116 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final plham.Market t$23850 = ((plham.Market) ((x10.core.fun.Fun_0_4<x10.core.Long, java.lang.String, x10.util.Random, cassia.util.JSON.Value, plham.Market>) this.initializer)
					.$apply(x10.core.Long.$box(id), x10.rtt.Types.LONG, name,
							x10.rtt.Types.STRING, random, x10.util.Random.$RTT,
							json, cassia.util.JSON.Value.$RTT));

			// #line 116 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			((x10.util.Collection<plham.Market>) markets).add$Z(
					((plham.Market) (t$23850)), plham.Market.$RTT);

			// #line 117 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final x10.util.Map t$23852 = ((x10.util.Map) (this.out$$.GLOBAL));

			// #line 117 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final plham.Market t$23851 = ((x10.util.Indexed<plham.Market>) markets)
					.$apply$G((long) (0L));

			// #line 117 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$23853 = ((java.lang.String) (t$23851.name));

			// #line 117 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.Object t$23854 = ((java.lang.Object) markets);

			// #line 117 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			((x10.util.Map<java.lang.String, java.lang.Object>) t$23852).$set(
					((java.lang.String) (t$23853)), x10.rtt.Types.STRING,
					((java.lang.Object) (t$23854)), x10.rtt.Types.ANY);

			// #line 118 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			return markets;
		}

		public plham.main.Simulator out$$;
		public x10.core.fun.Fun_0_4<x10.core.Long, java.lang.String, x10.util.Random, cassia.util.JSON.Value, plham.Market> initializer;

		public $Closure$11(
				final plham.main.Simulator out$$,
				final x10.core.fun.Fun_0_4<x10.core.Long, java.lang.String, x10.util.Random, cassia.util.JSON.Value, plham.Market> initializer,
				__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Market$2 $dummy) {
			{
				this.out$$ = out$$;
				this.initializer = ((x10.core.fun.Fun_0_4) (initializer));
			}
		}

	}

	@x10.runtime.impl.java.X10Generated
	final public static class $Closure$12<$T> extends x10.core.Ref implements
			x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable {
		public static final x10.rtt.RuntimeType<$Closure$12> $RTT = x10.rtt.StaticFunType
				.<$Closure$12> make($Closure$12.class, 1,
						new x10.rtt.Type[] { x10.rtt.ParameterizedType.make(
								x10.core.fun.Fun_0_1.$RTT, x10.rtt.Types.LONG,
								x10.rtt.Types.STRING) });

		public x10.rtt.RuntimeType<?> $getRTT() {
			return $RTT;
		}

		public x10.rtt.Type<?> $getParam(int i) {
			if (i == 0)
				return $T;
			return null;
		}

		private Object writeReplace() throws java.io.ObjectStreamException {
			return new x10.serialization.SerializationProxy(this);
		}

		public static <$T> x10.serialization.X10JavaSerializable $_deserialize_body(
				plham.main.Simulator.$Closure$12<$T> $_obj,
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			if (x10.runtime.impl.java.Runtime.TRACE_SER) {
				x10.runtime.impl.java.Runtime
						.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
								+ $Closure$12.class + " calling");
			}
			$_obj.$T = (x10.rtt.Type) $deserializer.readObject();
			$_obj.json = $deserializer.readObject();
			return $_obj;
		}

		public static x10.serialization.X10JavaSerializable $_deserializer(
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			plham.main.Simulator.$Closure$12 $_obj = new plham.main.Simulator.$Closure$12(
					(java.lang.System[]) null, (x10.rtt.Type) null);
			$deserializer.record_reference($_obj);
			return $_deserialize_body($_obj, $deserializer);
		}

		public void $_serialize(x10.serialization.X10JavaSerializer $serializer)
				throws java.io.IOException {
			$serializer.write(this.$T);
			$serializer.write(this.json);

		}

		// constructor just for allocation
		public $Closure$12(final java.lang.System[] $dummy,
				final x10.rtt.Type $T) {
			plham.main.Simulator.$Closure$12.$initParams(this, $T);

		}

		// dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
		public java.lang.Object $apply(final java.lang.Object a1,
				final x10.rtt.Type t1) {
			return $apply(x10.core.Long.$unbox(a1));

		}

		private x10.rtt.Type $T;

		// initializer of type parameters
		public static void $initParams(final $Closure$12 $this,
				final x10.rtt.Type $T) {
			$this.$T = $T;

		}

		public java.lang.String $apply(final long i) {

			// #line 509 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final cassia.util.JSON.Value t$24134 = ((cassia.util.JSON.Value) this.json)
					.<x10.core.Long> get(x10.rtt.Types.LONG,
							x10.core.Long.$box(i));

			// #line 509 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$24135 = t$24134.toString();

			// #line 509 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			return t$24135;
		}

		public cassia.util.JSON.Value json;

		public $Closure$12(final x10.rtt.Type $T,
				final cassia.util.JSON.Value json) {
			plham.main.Simulator.$Closure$12.$initParams(this, $T);
			{
				((plham.main.Simulator.$Closure$12<$T>) this).json = ((cassia.util.JSON.Value) (json));
			}
		}

	}

	@x10.runtime.impl.java.X10Generated
	final public static class $Closure$13<$T> extends x10.core.Ref implements
			x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable {
		public static final x10.rtt.RuntimeType<$Closure$13> $RTT = x10.rtt.StaticFunType
				.<$Closure$13> make($Closure$13.class, 1,
						new x10.rtt.Type[] { x10.rtt.ParameterizedType.make(
								x10.core.fun.Fun_0_1.$RTT, x10.rtt.Types.LONG,
								x10.rtt.Types.STRING) });

		public x10.rtt.RuntimeType<?> $getRTT() {
			return $RTT;
		}

		public x10.rtt.Type<?> $getParam(int i) {
			if (i == 0)
				return $T;
			return null;
		}

		private Object writeReplace() throws java.io.ObjectStreamException {
			return new x10.serialization.SerializationProxy(this);
		}

		public static <$T> x10.serialization.X10JavaSerializable $_deserialize_body(
				plham.main.Simulator.$Closure$13<$T> $_obj,
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			if (x10.runtime.impl.java.Runtime.TRACE_SER) {
				x10.runtime.impl.java.Runtime
						.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
								+ $Closure$13.class + " calling");
			}
			$_obj.$T = (x10.rtt.Type) $deserializer.readObject();
			$_obj.json = $deserializer.readObject();
			return $_obj;
		}

		public static x10.serialization.X10JavaSerializable $_deserializer(
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			plham.main.Simulator.$Closure$13 $_obj = new plham.main.Simulator.$Closure$13(
					(java.lang.System[]) null, (x10.rtt.Type) null);
			$deserializer.record_reference($_obj);
			return $_deserialize_body($_obj, $deserializer);
		}

		public void $_serialize(x10.serialization.X10JavaSerializer $serializer)
				throws java.io.IOException {
			$serializer.write(this.$T);
			$serializer.write(this.json);

		}

		// constructor just for allocation
		public $Closure$13(final java.lang.System[] $dummy,
				final x10.rtt.Type $T) {
			plham.main.Simulator.$Closure$13.$initParams(this, $T);

		}

		// dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
		public java.lang.Object $apply(final java.lang.Object a1,
				final x10.rtt.Type t1) {
			return $apply(x10.core.Long.$unbox(a1));

		}

		private x10.rtt.Type $T;

		// initializer of type parameters
		public static void $initParams(final $Closure$13 $this,
				final x10.rtt.Type $T) {
			$this.$T = $T;

		}

		public java.lang.String $apply(final long i) {

			// #line 573 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final cassia.util.JSON.Value t$24160 = ((cassia.util.JSON.Value) this.json)
					.<x10.core.Long> get(x10.rtt.Types.LONG,
							x10.core.Long.$box(i));

			// #line 573 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$24161 = t$24160.toString();

			// #line 573 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			return t$24161;
		}

		public cassia.util.JSON.Value json;

		public $Closure$13(final x10.rtt.Type $T,
				final cassia.util.JSON.Value json) {
			plham.main.Simulator.$Closure$13.$initParams(this, $T);
			{
				((plham.main.Simulator.$Closure$13<$T>) this).json = ((cassia.util.JSON.Value) (json));
			}
		}

	}

	@x10.runtime.impl.java.X10Generated
	final public static class $Closure$14 extends x10.core.Ref implements
			x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable {
		public static final x10.rtt.RuntimeType<$Closure$14> $RTT = x10.rtt.StaticFunType
				.<$Closure$14> make($Closure$14.class,
						new x10.rtt.Type[] { x10.rtt.ParameterizedType.make(
								x10.core.fun.Fun_0_1.$RTT, x10.rtt.Types.LONG,
								x10.rtt.Types.STRING) });

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
				plham.main.Simulator.$Closure$14 $_obj,
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			if (x10.runtime.impl.java.Runtime.TRACE_SER) {
				x10.runtime.impl.java.Runtime
						.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
								+ $Closure$14.class + " calling");
			}
			$_obj.names = $deserializer.readObject();
			return $_obj;
		}

		public static x10.serialization.X10JavaSerializable $_deserializer(
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			plham.main.Simulator.$Closure$14 $_obj = new plham.main.Simulator.$Closure$14(
					(java.lang.System[]) null);
			$deserializer.record_reference($_obj);
			return $_deserialize_body($_obj, $deserializer);
		}

		public void $_serialize(x10.serialization.X10JavaSerializer $serializer)
				throws java.io.IOException {
			$serializer.write(this.names);

		}

		// constructor just for allocation
		public $Closure$14(final java.lang.System[] $dummy) {

		}

		// dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
		public java.lang.Object $apply(final java.lang.Object a1,
				final x10.rtt.Type t1) {
			return $apply(x10.core.Long.$unbox(a1));

		}

		// synthetic type for parameter mangling
		public static final class __0$1x10$lang$String$2 {
		}

		public java.lang.String $apply(final long i) {

			// #line 611 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$24187 = ((x10.util.Indexed<java.lang.String>) this.names)
					.$apply$G((long) (i));

			// #line 611 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			return t$24187;
		}

		public x10.util.List<java.lang.String> names;

		public $Closure$14(final x10.util.List<java.lang.String> names,
				__0$1x10$lang$String$2 $dummy) {
			{
				this.names = ((x10.util.List) (names));
			}
		}

	}

	@x10.runtime.impl.java.X10Generated
	final public static class $Closure$15 extends x10.core.Ref implements
			x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable {
		public static final x10.rtt.RuntimeType<$Closure$15> $RTT = x10.rtt.StaticFunType
				.<$Closure$15> make($Closure$15.class,
						new x10.rtt.Type[] { x10.rtt.ParameterizedType.make(
								x10.core.fun.Fun_0_1.$RTT, x10.rtt.Types.LONG,
								x10.rtt.Types.STRING) });

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
				plham.main.Simulator.$Closure$15 $_obj,
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			if (x10.runtime.impl.java.Runtime.TRACE_SER) {
				x10.runtime.impl.java.Runtime
						.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
								+ $Closure$15.class + " calling");
			}
			$_obj.names = $deserializer.readObject();
			return $_obj;
		}

		public static x10.serialization.X10JavaSerializable $_deserializer(
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			plham.main.Simulator.$Closure$15 $_obj = new plham.main.Simulator.$Closure$15(
					(java.lang.System[]) null);
			$deserializer.record_reference($_obj);
			return $_deserialize_body($_obj, $deserializer);
		}

		public void $_serialize(x10.serialization.X10JavaSerializer $serializer)
				throws java.io.IOException {
			$serializer.write(this.names);

		}

		// constructor just for allocation
		public $Closure$15(final java.lang.System[] $dummy) {

		}

		// dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
		public java.lang.Object $apply(final java.lang.Object a1,
				final x10.rtt.Type t1) {
			return $apply(x10.core.Long.$unbox(a1));

		}

		// synthetic type for parameter mangling
		public static final class __0$1x10$lang$String$2 {
		}

		public java.lang.String $apply(final long i) {

			// #line 621 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$24201 = ((x10.util.Indexed<java.lang.String>) this.names)
					.$apply$G((long) (i));

			// #line 621 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			return t$24201;
		}

		public x10.util.List<java.lang.String> names;

		public $Closure$15(final x10.util.List<java.lang.String> names,
				__0$1x10$lang$String$2 $dummy) {
			{
				this.names = ((x10.util.List) (names));
			}
		}

	}

	@x10.runtime.impl.java.X10Generated
	final public static class $Closure$16 extends x10.core.Ref implements
			x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable {
		public static final x10.rtt.RuntimeType<$Closure$16> $RTT = x10.rtt.StaticFunType
				.<$Closure$16> make($Closure$16.class,
						new x10.rtt.Type[] { x10.rtt.ParameterizedType.make(
								x10.core.fun.Fun_0_1.$RTT, x10.rtt.Types.LONG,
								x10.rtt.Types.STRING) });

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
				plham.main.Simulator.$Closure$16 $_obj,
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			if (x10.runtime.impl.java.Runtime.TRACE_SER) {
				x10.runtime.impl.java.Runtime
						.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
								+ $Closure$16.class + " calling");
			}
			$_obj.names = $deserializer.readObject();
			return $_obj;
		}

		public static x10.serialization.X10JavaSerializable $_deserializer(
				x10.serialization.X10JavaDeserializer $deserializer)
				throws java.io.IOException {
			plham.main.Simulator.$Closure$16 $_obj = new plham.main.Simulator.$Closure$16(
					(java.lang.System[]) null);
			$deserializer.record_reference($_obj);
			return $_deserialize_body($_obj, $deserializer);
		}

		public void $_serialize(x10.serialization.X10JavaSerializer $serializer)
				throws java.io.IOException {
			$serializer.write(this.names);

		}

		// constructor just for allocation
		public $Closure$16(final java.lang.System[] $dummy) {

		}

		// dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
		public java.lang.Object $apply(final java.lang.Object a1,
				final x10.rtt.Type t1) {
			return $apply(x10.core.Long.$unbox(a1));

		}

		// synthetic type for parameter mangling
		public static final class __0$1x10$lang$String$2 {
		}

		public java.lang.String $apply(final long i) {

			// #line 631 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			final java.lang.String t$24209 = ((x10.util.Indexed<java.lang.String>) this.names)
					.$apply$G((long) (i));

			// #line 631 "/home/dsl/workspace/plhamK/plham/main/Simulator.x10"
			return t$24209;
		}

		public x10.util.List<java.lang.String> names;

		public $Closure$16(final x10.util.List<java.lang.String> names,
				__0$1x10$lang$String$2 $dummy) {
			{
				this.names = ((x10.util.List) (names));
			}
		}

	}

}
