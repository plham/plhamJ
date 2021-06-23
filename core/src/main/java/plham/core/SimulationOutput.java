package plham.core;

import java.io.Serializable;
import java.util.List;
import handist.collections.ChunkedList;
import plham.core.main.Simulator.Session;

/**
 * Class in charge of collecting the outputs programmed by the users of the library. Users of the library may extend
 * this class and override the methods they want to print information about the {@link Agent}s, {@link Market}s during
 * the simulation.
 * 
 * @author Patrick Finnerty
 *
 */
public class SimulationOutput implements Serializable {

    /**
     * Enumerator used to indicate to the various object methods in which stage the simulation is currently in. This can
     * be used to make different outputs from the same participant in a simulation based on the current stage.
     * 
     * @author Patrick Finnerty
     *
     */
    public enum SimulationStage {
        BEGIN_SESSION, BEGIN_SIMULATION, END_SESSION, END_SIMULATION, WITH_PRINT_DURING_SESSION, WITH_PRINT_END_SESSION
    }

    /** Serial Version UID */
    private static final long serialVersionUID = 2980368321076917922L;

    /**
     * 
     * @param out   object in which the various outputs need to be recorded
     * @param stage the current stage of the simulation
     * @param a     agent taking part in the computation from which information may be logged
     */
    public void agentOutput(OutputCollector out, SimulationStage stage, Agent a) {
    }

    /**
     * Method called at the beginning of a session. By default, does not print anything. Override this method if you
     * want to print some information at the beginning of a session.
     *
     * @param session the current session
     * @param agents
     * @deprecated instead of overriding this method, consider using {@link #agentOutput(OutputCollector, SimulationStage, Agent)}, {@link #marketOutput(OutputCollector, SimulationStage, Market)}, {@link #sessionOutput(OutputCollector, SimulationStage, Session)} and {@link #eventOutput(OutputCollector, SimulationStage, Event)}
     */
    @Deprecated
    public void beginSession(OutputCollector output, Session session, List<Market> markets, ChunkedList<Agent> agents,
                             List<Event> sessionEvents) {
        sessionOutput(output, SimulationStage.BEGIN_SESSION, session);
        for (Market m : markets) {
            marketOutput(output, SimulationStage.BEGIN_SESSION, m);
        }

        for (Agent a : agents) {
            agentOutput(output, SimulationStage.BEGIN_SESSION, a);
        }
        if (sessionEvents != null) {
            for (Event e : sessionEvents) {
                eventOutput(output, SimulationStage.BEGIN_SESSION, e);
            }
        }
    }

    /**
     * Method called at the beginning of the simulation. By default, calls on methods {@link #marketOutput(OutputCollector, SimulationStage, Market)} and {@link #agentOutput(OutputCollector, SimulationStage, Agent)} for all markets and agents participating in the computation.
     * @deprecated instead of overriding this method, consider using {@link #agentOutput(OutputCollector, SimulationStage, Agent)}, {@link #marketOutput(OutputCollector, SimulationStage, Market)}, {@link #sessionOutput(OutputCollector, SimulationStage, Session)} and {@link #eventOutput(OutputCollector, SimulationStage, Event)}  
     */
    @Deprecated
    public void beginSimulation(OutputCollector output, List<Market> markets, ChunkedList<Agent> agents) {
        for (Market m : markets) {
            marketOutput(output, SimulationStage.BEGIN_SIMULATION, m);
        }

        for (Agent a : agents) {
            agentOutput(output, SimulationStage.BEGIN_SIMULATION, a);
        }
    }

    /**
     * Method called at the end of a session that holds the "withprint" operation. By default this method calls method {@link #sessionOutput(OutputCollector, SimulationStage, Session)} with the session that has just ended, and method {@link #marketOutput(OutputCollector, SimulationStage, Market)} and {@link #agentOutput(OutputCollector, SimulationStage, Agent)} for every market and every agent taking part in the computation. 
     *
     * @param session the session which has just ended
     * @param markets the markets taking part in the computation
     * @param agents the agent taking part in the computation
     * @param sessionEvents the events that were part of this session, may be null
     * @param iterationStep the number of steps that have just run (for legacy outputs only)
     * @deprecated instead of overriding this method, consider using {@link #agentOutput(OutputCollector, SimulationStage, Agent)}, {@link #marketOutput(OutputCollector, SimulationStage, Market)}, {@link #sessionOutput(OutputCollector, SimulationStage, Session)} and {@link #eventOutput(OutputCollector, SimulationStage, Event)}
     */
    @Deprecated
    public void endprint(OutputCollector output, Session session, List<Market> markets, ChunkedList<Agent> agents,
                         List<Event> sessionEvents, long iterationStep) {
        sessionOutput(output, SimulationStage.WITH_PRINT_END_SESSION, session);
        for (Market m : markets) {
            marketOutput(output, SimulationStage.WITH_PRINT_END_SESSION, m);
        }

        for (Agent a : agents) {
            agentOutput(output, SimulationStage.WITH_PRINT_END_SESSION, a);
        }

        if (sessionEvents != null) {
            for (Event e : sessionEvents) {
                eventOutput(output, SimulationStage.WITH_PRINT_END_SESSION, e);
            }
        }
    }

    /**
     * Method called at the end of a session. By default does not print anything. Override this method if you want to
     * print some information at the end of a session.
     *
     * @param session
     * @param agents
     * @deprecated instead of overriding this method, consider using {@link #agentOutput(OutputCollector, SimulationStage, Agent)}, {@link #marketOutput(OutputCollector, SimulationStage, Market)}, {@link #sessionOutput(OutputCollector, SimulationStage, Session)} and {@link #eventOutput(OutputCollector, SimulationStage, Event)}
     */
    @Deprecated
    public void endSession(OutputCollector output, Session session, List<Market> markets, ChunkedList<Agent> agents,
                           List<Event> sessionEvents) {
        sessionOutput(output, SimulationStage.END_SESSION, session);
        for (Market m : markets) {
            marketOutput(output, SimulationStage.END_SESSION, m);
        }

        for (Agent a : agents) {
            agentOutput(output, SimulationStage.END_SESSION, a);
        }

        if (sessionEvents != null) {
            for (Event e : sessionEvents) {
                eventOutput(output, SimulationStage.END_SESSION, e);
            }
        }
    }

    /**
     * Method called at the end of the simulation. By default, does not print anything. Override this method if you want
     * to print some information at the end of the simulation.
     * 
     * @deprecated instead of overriding this method, consider using {@link #agentOutput(OutputCollector, SimulationStage, Agent)}, {@link #marketOutput(OutputCollector, SimulationStage, Market)}, {@link #sessionOutput(OutputCollector, SimulationStage, Session)} and {@link #eventOutput(OutputCollector, SimulationStage, Event)}
     */
    @Deprecated
    public void endSimulation(OutputCollector output, List<Market> markets, ChunkedList<Agent> agents) {
        for (Market m : markets) {
            marketOutput(output, SimulationStage.END_SIMULATION, m);
        }

        for (Agent a : agents) {
            agentOutput(output, SimulationStage.END_SIMULATION, a);
        }
    }

    /**
     * Allows for information from Events to be looged during the simulation. By default, this method does not log
     * anything. Override to log information into the provided {@link OutputCollector}.
     * 
     * @param out   object in which the various outputs need to be recorded
     * @param stage the current stage of the simulation
     * @param e     agent taking part in the computation from which information may be logged
     */
    public void eventOutput(OutputCollector out, SimulationStage stage, Event e) {
    }

    /**
     * Allows for information about markets to be logged. By default does not log anything. Override this method to log information into the provided {@link OutputCollector}. 
     * @param out
     * @param stage
     * @param m
     */
    public void marketOutput(OutputCollector out, SimulationStage stage, Market m) {
    }

    /**
     * Prints information about the current state of the simulation at each iteration during a session. It is only
     * called in sessions that have the "withPrint" option. By default does not print anything. Override this method to
     * make the desired outputs.
     *
     * @param session the ongoing session
     * @param agents
     * @deprecated instead of overriding this method, consider using {@link #agentOutput(OutputCollector, SimulationStage, Agent)}, {@link #marketOutput(OutputCollector, SimulationStage, Market)}, {@link #sessionOutput(OutputCollector, SimulationStage, Session)} and {@link #eventOutput(OutputCollector, SimulationStage, Event)}
     */
    @Deprecated
    public void print(OutputCollector output, Session session, List<Market> markets, ChunkedList<Agent> agents,
                      List<Event> sessionEvents) {
        sessionOutput(output, SimulationStage.WITH_PRINT_DURING_SESSION, session);
        for (Market m : markets) {
            marketOutput(output, SimulationStage.WITH_PRINT_DURING_SESSION, m);
        }

        for (Agent a : agents) {
            agentOutput(output, SimulationStage.WITH_PRINT_DURING_SESSION, a);
        }

        if (sessionEvents != null) {
            for (Event e : sessionEvents) {
                eventOutput(output, SimulationStage.WITH_PRINT_DURING_SESSION, e);
            }
        }
    }

    /**
     * 
     * @param out   object in which the various outputs need to be recorded
     * @param stage the current stage of the simulation
     * @param s     session being run from which information may be taken and logged
     */
    public void sessionOutput(OutputCollector out, SimulationStage stage, Session s) {
    }

    /**
     * Allows for information about order submission to be logged. By default does not log anything. Override this method to log information into the provided {@link OutputCollector}.
     * @param out
     * @param stage
     * @param a
     * @param orders
     * @param markets
     */
    public void orderSubmissionOutput(OutputCollector out, SimulationStage stage, Agent a, List<Order> orders, List<Market> markets) {
    }
    /**
     * Allows for outputs to be made based on information gathered from various objects participating in the computation
     * <p>
     * By default, prints the contents stored using method {@link OutputCollector#log(String, Object)} in the previous stage. 
     * Override this method if you want to make outputs combining information from multiple participants in the simulation.
     * @param output the object into which the outputs to make about the simulation need to be registered
     * @param stage the stage of the simulation about which outputs are being made
     */
    public void postProcess(OutputCollector output, SimulationStage stage) {
        output.forEach((String key, List<String> values)-> {
            StringBuilder sb = new StringBuilder(key + " : ");
            for (String v : values) {
                sb.append(v+ " ");
            }
            output.print(sb.toString());
        });
    }
}
