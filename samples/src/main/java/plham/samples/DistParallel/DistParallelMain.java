package plham.samples.DistParallel;

import plham.core.main.ParallelRunnerDist;
import plham.core.main.SimulatorFactory;
import plham.core.util.Random;
import plham.samples.CI2002.NewCI2002MainForLogging;

public class DistParallelMain {

    public static void main(final String[] args) throws Exception {
        final NewCI2002MainForLogging sim = new NewCI2002MainForLogging();

        SimulatorFactory factory = new SimulatorFactory(args[0]);
        long seed;
        if (args.length > 1) {
            seed = Long.valueOf(args[1]);
        } else {
            seed = new Random().nextLong(Long.MAX_VALUE / 2); // MEMO: main()
        }
        System.err.println("# Running with seed: " + seed);
        final ParallelRunnerDist runner = new ParallelRunnerDist(sim, factory);
        runner.run(seed);
    }
}
