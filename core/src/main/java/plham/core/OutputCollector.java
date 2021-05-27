package plham.core;

/**
 * Interface supplied to programmers of {@link SimulationOutput}. The implementation of the methods is left to the
 * Runner (sequential, parallel, distributed) used.
 * 
 * @author Patrick Finnerty
 *
 */
public interface OutputCollector {

    /**
     * Registers an object at the specified key for later use in method {@link SimulationOutput#postProcess(java.util.Map)}. This method is meant to store information from multiple object participating in the computation (Markets, Agents, Events, Session ...) and combine these information to make outputs for the simulations. 
     * If all the information needed to output a line is contained within a single participant in the simulation, method {@link #log(String)} should be used. This method is only here to allow outputs that combine information from different participants. 
     * @param topic   the topic into which the message will be gathered
     * @param o the object to register for the specified topic
     */
    public void log(String topic, Object o);

    /**
     * Prints the given message as part of the simulation outputs
     * @param message the message to print
     */
    public void print(String message);
}
