package plham.core;

import java.io.Serializable;
import java.util.List;

/**
 * Class in charge of collecting the outputs programmed by the users of the library 
 * @author Patrick Finnerty
 *
 */
public class SimulationOutput implements Serializable {

    /** Serial Version UID */
    private static final long serialVersionUID = 2980368321076917922L;

    /**
     * Method called at the beginning of a session. By default, does not print
     * anything. Override this method if you want to print some information at the
     * beginning of a session.
     *
     * @param sessionName the name of the current session
     */
    public void beginSession(OutputCollector output, String sessionName, List<Market> markets, List<Agent> agents, List<Event> sessionEvents) {
    }
    
    /**
     * Method called at the beginning of the simulation. By default, does not print
     * anything. Override this method if you want to print some information at the
     * beginning of the simulation.
     */
    public void beginSimulation(OutputCollector output, List<Market> markets, List<Agent> agents) {
    }

    /**
     * Method called at the end of a session that holds the "withprint" operation.
     * By default this method does not do anything. Override this method to print
     * some information.
     *
     * @param sessionName    name of the session being run
     * @param iterationSteps the number of steps that have just run
     */
    public void endprint(OutputCollector output, String sessionName, List<Market> markets, List<Agent> agents, List<Event> sessionEvents, long iterationStep) {
    }

    /**
     * Method called at the end of a session. By default does not print anything.
     * Override this method if you want to print some information at the end of a
     * session.
     *
     * @param sessionName
     */
    public void endSession(OutputCollector output, String sessionName, List<Market> markets, List<Agent> agents, List<Event> sessionEvents) {
    }

    /**
     * Method called at the end of the simulation. By default, does not print
     * anything. Override this method if you want to print some information at the
     * end of the simulation.
     */
    public void endSimulation(OutputCollector output, List<Market> markets, List<Agent> agents) {
    }

    /**
     * Prints information about the current state of the simulation at each
     * iteration during a session. It is only called in sessions that have the
     * "withPrint" option. By default does not print anything. Override this method
     * to make the desired outputs.
     *
     * @param sessionName the name of the ongoing session
     */
    public void print(OutputCollector output, String sessionName, List<Market> markets, List<Agent> agents, List<Event> sessionEvents) {
    }
}
