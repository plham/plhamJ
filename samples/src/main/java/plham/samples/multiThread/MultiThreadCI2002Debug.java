package plham.samples.multiThread;

import plham.core.main.ParallelRunnerMT;
import plham.core.main.SimulatorFactory;
import plham.core.util.Random;
import plham.samples.CI2002.NewCI2002MainForLogging;

public class MultiThreadCI2002Debug {

    public static void main(String[] args) throws Exception {
        SimulatorFactory factory = new SimulatorFactory(args[0]);
        long seed;
        if (args.length > 1) {
            seed = Long.valueOf(args[1]);
        } else {
            seed = new Random().nextLong(Long.MAX_VALUE / 2); // MEMO: main()
        }
        ParallelRunnerMT.ParallelOutputLogger out0 = new ParallelRunnerMT.ParallelOutputLogger();
        {

            final NewCI2002MainForLogging sim = new NewCI2002MainForLogging();
            System.err.println("# Running with seed: " + seed);
            final ParallelRunnerMT runner = new ParallelRunnerMT(sim, factory, 1);
            runner.setLogger(out0);
            runner.run(seed, true);
            out0.clear();
        }
        // ParallelRunnerMT.ParallelOutputLogger outC = new ParallelRunnerMT.ParallelOutputLogger();
        ParallelRunnerMT.ParallelOutputChecker outC = new ParallelRunnerMT.ParallelOutputChecker(out0);
        {
            final NewCI2002MainForLogging sim = new NewCI2002MainForLogging();
            System.err.println("# Running with seed: " + seed);
            final ParallelRunnerMT runner = new ParallelRunnerMT(sim, factory, 3);
            runner.setLogger(outC);
            runner.run(seed, true);
            boolean exactSame = outC.checkRemains();
            if (exactSame)
                System.out.println("Congratulation!");
        }
    }
}
