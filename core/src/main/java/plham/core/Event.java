package plham.core;

import java.io.Serializable;

import cassia.util.JSON.Value;
import plham.core.main.SimulatorFactory;

/**
 * A marker interface for events, e.g., shocks and rules (regulations).
 */
public interface Event extends Serializable {
	Event setup(Value value, SimulatorFactory sim);
}
