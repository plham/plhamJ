package plham.core.main.log;

/**
 * Class containing the constants for the various topics about which logs are recorded as part of the runner executions
 * @author Patrick Finnerty
 */
public class LogConstants {

    /**
     * Log key for when a session starts
     */
    public static final String LOG_SESSION_START = "Session Start";
    
    /**
     * Log key for when a session ends
     */
    public static final String LOG_SESSION_STOP = "Session Stop";
    
    /**
     * Log key for when an iteration of a session starts
     */
    public static final String LOG_ITERATION_START = "Iteration Start";
    
    /**
     * Log key for when an iteration of a session ends
     */
    public static final String LOG_ITERATION_STOP = "Iteration Stop";
    
    /**
     * Log key for when the processing of orders during an iteration starts
     */
    public static final String LOG_PROCESSORDERS_START = "ProcessOrders Start";

    /**
     * Log key for when the processing of orders during an iteration ends
     */
    public static final String LOG_PROCESSORDERS_STOP = "ProcessOrders Stop";
    
    /**
     * Log key for when the short-term agents start submitting their orders
     */
    public static final String LOG_SAGENTSUBMISSION_START = "sAgentSubmission Start";
    
    /**
     * Log key for when the short-term agents have finished submitting their orders
     */
    public static final String LOG_SAGENTSUBMISSION_STOP = "sAgentSubmission Stop";
    
    /**
     * Log key for when the long-term agents startsubmitting their orders
     */
    public static final String LOG_LAGENTSUBMISSION_START = "lAgentSubission Start";
    
    /**
     * Log key for when the long-term agents have finished submitting their orders
     */
    public static final String LOG_LAGENTSUBMISSTION_STOP = "lAgentSubmission Stop";
}

