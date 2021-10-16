package plham.core.main;

import plham.core.main.glb.GlbRunner;
import plham.core.main.glb.PlhamLifeline;

/**
 * Class containing various constants used to influence the behavior of the
 * runner implementations.
 */
public class Config {
    

    /**
     * Property which when set to true will force the use of the pipelined schedule even if there are
     * no long-term agents in the simulation. Only applies to {@link ParallelRunnerDist} and {@link GlbRunner}
     */
    public static final String FORCE_PIPELINE_SCHEDULE = "plhamj.forcePipeline";
    

    /**
     * Property which allows to choose the lifeline strategy used to relocate agents between hosts.
     * Only applies to {@link GlbRunner}.
     */
    public static final String LIFELINE_CLASS = "plhamj.lifeline";

    /**
     * Default value for {@link #LIFELINE_CLASS} property.
     */
    public static final String LIFELINE_CLASS_DEFAULT = PlhamLifeline.class.getCanonicalName();

    /**
     * Property which can be used to specify a file to which the logged events will be written
     * after the computation has completed (i.e. -D{@value #SAVE_LOG_TO_FILE}=<file name>). 
     * Leave undefined to discard the data logged during the runner execution.
     * <p>
     * Only applies to {@link ParallelRunnerDist} and {@link GlbRunner}.
     */
    public static final String SAVE_LOG_TO_FILE = "plhamj.logfile";
}
