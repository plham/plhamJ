package plham;

import x10.rtt.NamedType;

/**
 * A marker interface for events, e.g., shocks and rules (regulations).
 */
public interface Event extends x10.core.Any {
	@SuppressWarnings("unchecked")
	public static final x10.rtt.RuntimeType<Event> $RTT = NamedType
			.<Event> make("plham.Event", Event.class);

}
