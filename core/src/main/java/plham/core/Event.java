package plham.core;

import java.io.Serializable;

import cassia.util.JSON.Value;
import plham.core.main.SimulatorFactory;

/**
 * A marker interface for events, e.g., shocks and rules (regulations).
 */
public interface Event extends Serializable {

    public Event setup(Value value, SimulatorFactory sim);

    /**
     * Provides the name of this event
     * 
     * @return the string given to this event in the configuration file of the simulation
     */
    public String getName();

}
