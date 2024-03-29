package plham.samples.DistParallel;

import handist.collections.dist.TeamedPlaceGroup;
import plham.core.main.ParallelRunnerDist;
import plham.core.main.SimulatorFactory;
import plham.core.util.Random;
import plham.samples.CI2002.NewCI2002MainForLogging;

public class DistParallelMain {

    public static void main(final String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Arguments for DistParallelMain");
            System.err.println("\tJSON configuration file");
            System.err.println("\tseed (optional)");
            return;
        }
        final NewCI2002MainForLogging sim = new NewCI2002MainForLogging();

        SimulatorFactory factory = new SimulatorFactory(args[0]);
        long seed;
        if (args.length > 1) {
            seed = Long.valueOf(args[1]);
        } else {
            seed = new Random().nextLong(Long.MAX_VALUE / 2); // MEMO: main()
        }
        System.err.println("# Running with seed: " + seed);
        final ParallelRunnerDist runner = ParallelRunnerDist.initializeRunner(seed, sim, factory, TeamedPlaceGroup.getWorld()); 
        runner.run();
    }
}
