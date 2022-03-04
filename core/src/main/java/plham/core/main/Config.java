package plham.core.main;

import plham.core.main.glb.GlbRunner;
import plham.core.main.glb.PlhamLifeline;

/**
 * Class containing various constants used to influence the behavior of the
 * runner implementations.
 */
public class Config {

    /**
     * Property which when set to true will force the use of the pipelined schedule
     * even if there are no long-term agents in the simulation. Only applies to
     * {@link ParallelRunnerDist} and {@link GlbRunner}
     */
    public static final String FORCE_PIPELINE_SCHEDULE = "plhamj.forcePipeline";

    /**
     * Property which determines after how many rounds the data structures used to
     * progress tracking in the GLB are discarded. By default is disabled.
     */
    public static final String RESET_GLB_TRACKING = "plhamJ.resetglbtrackers";
    /**
     * Default value for {@link #RESET_GLB_TRACKING}, disables resetting trackers by
     * default.
     */
    public static final String RESET_GLB_TRACKING_DEFAULT = "-1";

    /**
     * Defines the factor compared to {@link Runtime#availableProcessors()} many
     * threads are scheduled in the {@link ParallelRunnerDist} and
     * {@link ParallelRunnerDist} runners for parallel order generation.
     */
    public static final String PARALLELISM_FACTOR = "plhamj.parallelismFactor";
    /**
     * Default vale for {@link #PARALLELISM_FACTOR}.
     */
    public static final String PARALLELISM_FACTOR_DEFAULT = "1";

    /**
     * Property which allows to choose the lifeline strategy used to relocate agents
     * between hosts. Only applies to {@link GlbRunner}.
     */
    public static final String LIFELINE_CLASS = "plhamj.lifeline";

    /**
     * Default value for {@link #LIFELINE_CLASS} property.
     */
    public static final String LIFELINE_CLASS_DEFAULT = PlhamLifeline.class.getCanonicalName();

    /**
     * Property which can be used to specify a file to which the logged events will
     * be written after the computation has completed (i.e.
     * -D{@value #SAVE_LOG_TO_FILE}=<file name>). Leave undefined to discard the
     * data logged during the runner execution.
     * <p>
     * Only applies to {@link ParallelRunnerDist} and {@link GlbRunner}.
     */
    public static final String SAVE_LOG_TO_FILE = "plhamj.logfile";
}
