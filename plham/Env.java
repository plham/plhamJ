package plham;

import java.io.IOException;
import java.io.ObjectStreamException;

import x10.serialization.SerializationProxy;
import x10.serialization.X10JavaDeserializer;
import x10.serialization.X10JavaSerializable;
import x10.serialization.X10JavaSerializer;
import x10.util.ArrayList;
import x10.rtt.NamedType;
import x10.rtt.RuntimeType;
import x10.rtt.Type;
import x10.runtime.impl.java.Runtime;
import x10.util.List;

/**
 * For system use only.
 */

public class Env extends x10.core.Ref {
	@SuppressWarnings({ "unchecked", "hiding" })
	public static final RuntimeType<Env> $RTT = NamedType.<Env> make(
			"plham.Env", Env.class);

	public RuntimeType<?> $getRTT() {
		return $RTT;
	}

	public Type<?> $getParam(int i) {
		return null;
	}

	@SuppressWarnings("unused")
	private Object writeReplace() throws ObjectStreamException {
		return new SerializationProxy(this);
	}

	public static X10JavaSerializable $_deserialize_body(plham.Env $_obj,
			X10JavaDeserializer $deserializer) throws java.io.IOException {
		if (Runtime.TRACE_SER) {
			Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
					+ Env.class + " calling");
		}
		$_obj.agents = $deserializer.readObject();
		$_obj.hifreqAgents = $deserializer.readObject();
		$_obj.markets = $deserializer.readObject();
		$_obj.normalAgents = $deserializer.readObject();
		$_obj.numAgents = $deserializer.readLong();
		return $_obj;
	}

	public static X10JavaSerializable $_deserializer(
			X10JavaDeserializer $deserializer) throws IOException {
		Env $_obj = new Env((java.lang.System[]) null);
		$deserializer.record_reference($_obj);
		return $_deserialize_body($_obj, $deserializer);
	}

	public void $_serialize(X10JavaSerializer $serializer) throws IOException {
		$serializer.write(this.agents);
		$serializer.write(this.hifreqAgents);
		$serializer.write(this.markets);
		$serializer.write(this.normalAgents);
		$serializer.write(this.numAgents);

	}

	// constructor just for allocation
	@SuppressWarnings("unused")
	public Env(final java.lang.System[] $dummy) {
		// do nothing
	}

	public static final long DEBUG = 0L;

	public static String getenvOrElse(final String name, final String orElse) {
		final String value = x10.lang.System.getenv(name);
		if (value == null) {
			return orElse;
		}
		return value;
	}

	public List<Agent> agents;
	public long numAgents;
	public List<Market> markets;
	public List<Agent> normalAgents;
	public List<Agent> hifreqAgents;

	public Env() {
		this((java.lang.System[]) null);
		init();
	}

	// constructor for non-virtual call
	@SuppressWarnings("unchecked")
	public Env init() {
		this.fieldInitializersPlhamEnv();
		this.agents = new ArrayList<plham.Agent>((java.lang.System[]) null,
				plham.Agent.$RTT).x10$util$ArrayList$$init$S();
		return this;
	}

	final public Env getEnv() {
		return plham.Env.this;
	}

	final public void fieldInitializersPlhamEnv() {
		this.agents = null;
		this.numAgents = 0L;
		this.markets = null;
		this.normalAgents = null;
		this.hifreqAgents = null;
	}

	public static long isDebug() {
		return Env.DEBUG;
	}
}
