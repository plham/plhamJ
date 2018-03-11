package samples.CI2002;

import java.io.IOException;

import plham.Agent;
import plham.Main;
import plham.Market;
import plham.agent.FCNAgent;
import plham.main.SequentialRunner;
import x10.rtt.NamedType;
import x10.rtt.RuntimeType;
import x10.rtt.Type;
import x10.runtime.impl.java.Runtime;
import x10.serialization.SerializationProxy;
import x10.serialization.X10JavaDeserializer;
import x10.serialization.X10JavaSerializable;
import x10.serialization.X10JavaSerializer;
import x10.util.List;
import x10.util.ListIterator;

@SuppressWarnings("serial")
public class CI2002Main extends plham.Main {
	@SuppressWarnings({ "unchecked", "hiding" })
	public static final RuntimeType<CI2002Main> $RTT = NamedType
			.<CI2002Main> make("samples.CI2002.CI2002Main", CI2002Main.class,
					new Type[] { plham.Main.$RTT });

	@Override
	public RuntimeType<?> $getRTT() {
		return $RTT;
	}

	@Override
	public Type<?> $getParam(int i) {
		return null;
	}

	private Object writeReplace() {
		return new SerializationProxy(this);
	}

	public static X10JavaSerializable $_deserialize_body(CI2002Main $_obj,
			X10JavaDeserializer $deserializer) throws java.io.IOException {
		if (Runtime.TRACE_SER) {
			Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
					+ CI2002Main.class + " calling");
		}
		plham.Main.$_deserialize_body($_obj, $deserializer);
		return $_obj;
	}

	public static X10JavaSerializable $_deserializer(
			X10JavaDeserializer $deserializer) throws IOException {
		CI2002Main $_obj = new CI2002Main(null);
		$deserializer.record_reference($_obj);
		return $_deserialize_body($_obj, $deserializer);
	}

	@Override
	public void $_serialize(X10JavaSerializer $serializer) throws IOException {
		super.$_serialize($serializer);

	}

	public CI2002Main(final System[] system) {
		super(system);
	}

	public static class $Main extends x10.runtime.impl.java.Runtime {
		public static void main(java.lang.String[] args) {
			new $Main().start(args);
		}

		@Override
		@SuppressWarnings("hiding")
		public void runtimeCallback(final x10.core.Rail<java.lang.String> args) {
			Main.main(args);
		}
	}

	public static void main(final x10.core.Rail<java.lang.String> args) {
		final CI2002Main sim = new CI2002Main(null).init();
		FCNAgent.register(sim);
		plham.Market.register(sim);
		final SequentialRunner<CI2002Main> runner = new SequentialRunner<CI2002Main>(
				null, $RTT);
		runner.run(args);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void print(final String sessionName) {
		@SuppressWarnings("hiding")
		final List<Market> markets = this.getMarketsByName("markets");
		@SuppressWarnings({ "hiding", "unused" })
		final List<Agent> agents = this.getAgentsByName("agents");
		ListIterator<Market> iterator = markets.iterator();
		while (iterator.hasNext$O()) {
			Market market = iterator.next$G();
			long t = market.getTime$O();
			System.out.println(String.format("%s %s %s %s %s %s", sessionName,
					t, market.id, market.name, market.getPrice$O(t),
					market.getFundamentalPrice(t)));

		}
	}

	final public CI2002Main main() {
		return CI2002Main.this;
	}

	public CI2002Main() {
		this(null);
		init();
	}

	@Override
	final public CI2002Main init() {
		this.fieldInitializers();
		return this;
	}

	final public void fieldInitializers() {
		// do nothign
	}
}
