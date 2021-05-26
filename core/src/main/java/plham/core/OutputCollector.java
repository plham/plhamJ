package plham.core;

/**
 * Interface supplied to programmers of {@link SimulationOutput}. The implementation of the methods is left to the
 * Runner (sequential, parallel, distributed) used.
 * 
 * @author patrick
 *
 */
public interface OutputCollector {

    /**
     * Logs the desired message with the designated topic. Topics are used to sort and group together output messages.
     * This is particularly useful when the outputs are gathered in parallel.
     * 
     * @param topic   the topic into which the message will be gathered
     * @param message the message to display
     */
    public void log(String topic, String message);

    /**
     * Logs the desired message without specifying a particular topic. The message given in parameter is stored with the
     * "empty string" topic.
     * 
     * @param message the message to log
     */
    public default void log(String message) {
        log("", message);
    }
}
