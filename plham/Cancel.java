package plham;

import java.io.IOException;
import java.io.ObjectStreamException;

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
 * A cancel request of an order.
 *
 * <p>
 * Cancel is performed in terms of <code>Order</code>'s <code>agentId</code> and
 * <code>orderId</code>. When a cancel request is accepted, any orders having
 * the <code>agentId</code> and <code>orderId</code> will be cancelled. To be
 * cancelleable, the <code>orderId</code> must be &gt; 0 (which is 0 by
 * default). One (<code>Agent</code>) should assign a unique
 * <code>orderId</code> for each order if needed. The cancel behavior when using
 * the same <code>orderId</code> more than once is <i>undefined</i>.
 */

@SuppressWarnings("unused")
public class Cancel extends Order implements X10JavaSerializable {
	@SuppressWarnings({ "hiding", "unchecked" })
	public static final RuntimeType<Cancel> $RTT = NamedType.<Cancel> make(
			"plham.Cancel", Cancel.class, new Type[] { plham.Order.$RTT });

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

	public static X10JavaSerializable $_deserialize_body(Cancel $_obj,
			X10JavaDeserializer $deserializer) throws IOException {
		if (Runtime.TRACE_SER) {
			Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
					+ Cancel.class + " calling");
		}
		plham.Order.$_deserialize_body($_obj, $deserializer);
		return $_obj;
	}

	public static X10JavaSerializable $_deserializer(
			X10JavaDeserializer $deserializer) throws java.io.IOException {
		plham.Cancel $_obj = new plham.Cancel((java.lang.System[]) null);
		$deserializer.record_reference($_obj);
		return $_deserialize_body($_obj, $deserializer);
	}

	@Override
	public void $_serialize(x10.serialization.X10JavaSerializer $serializer)
			throws java.io.IOException {
		super.$_serialize($serializer);
	}

	// constructor just for allocation
	public Cancel(final java.lang.System[] $dummy) {
		super($dummy);
	}

	// creation method for java code (1-phase java constructor)
	public Cancel(final plham.Order order) {
		this((java.lang.System[]) null);
		init(order);
	}

	@Override
	public Cancel init(final plham.Order order) {
		super.init(order);
		this.fieldInitializersPlhamCancel();
		return this;
	}

	final public plham.Cancel getCancel() {
		return plham.Cancel.this;
	}

	final public void fieldInitializersPlhamCancel() {
		// do nothing
	}
}
