package plham.samples.DistParallel;

import handist.collections.dist.TeamedPlaceGroup;
import plham.core.OutputCollector;
import plham.core.main.ParallelRunnerDist;
import plham.core.main.ParallelRunnerMT;
import plham.core.main.SimulatorFactory;
import plham.core.util.Random;
import plham.samples.CI2002.NewCI2002MainForLogging;

import java.io.PrintStream;
import java.io.PrintWriter;

public class DistParallelMainDebug {

	/**
     * 
     */
    private static final long serialVersionUID = 4103707038034011459L;

    public static void main(final String[] args) throws Exception {
		SimulatorFactory factory = new SimulatorFactory(args[0]);
		TeamedPlaceGroup world = TeamedPlaceGroup.getWorld();
		long seed;
		if (args.length > 1) {
			seed = Long.valueOf(args[1]);
		} else {
			seed = new Random().nextLong(Long.MAX_VALUE / 2); // MEMO: main()
		}
		ParallelRunnerDist.DistOutputCollector out0 = new ParallelRunnerDist.DistOutputCollector(world);
		//ParallelRunnerMT.ParallelOutputLogger out0 = new ParallelRunnerMT.ParallelOutputLogger();
		{
			final NewCI2002MainForLogging sim = new NewCI2002MainForLogging();
			System.err.println("# Running with seed: " + seed);
			final ParallelRunnerMT runner = new ParallelRunnerMT(sim, factory, 1);
			runner.setLogger(out0);
			runner.run(seed, true);
			out0.clear();
			out0.printAll(new PrintStream("logA.txt"));
		}
		System.out.println("==================");

		ParallelRunnerDist.DistOutputCollector out1 = new ParallelRunnerDist.DistOutputCollector(world);
		{
			final NewCI2002MainForLogging sim = new NewCI2002MainForLogging();
			System.err.println("# Running with seed: " + seed);
			final ParallelRunnerDist runner = new ParallelRunnerDist(sim, factory, 3);
			runner.setLogger(out1);
			runner.run(seed, true);
			out1.clear();
			out1.getDistLog().globalGather();
			out1.printAll(new PrintStream("logB.txt"));
		}
		// diff check
		boolean flag = out1.getDistLog().distributionFreeEquals(out0.getDistLog(), System.out);
		if(flag) System.out.println("Exact match. Congratulation!");
		boolean flag2 = out0.getDistLog().distributionFreeEquals(out1.getDistLog(), System.out);
		if(flag2) System.out.println("Exact match. Congratulation again!");
	}
}
