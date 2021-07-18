package plham.samples.DistParallel;

import handist.collections.dist.TeamedPlaceGroup;
import plham.core.main.ParallelRunnerDist;
import plham.core.main.ParallelRunnerMT;
import plham.core.main.SimulatorFactory;
import plham.core.util.Random;
import plham.samples.CI2002.NewCI2002MainForLogging;

import java.io.PrintStream;

public class DistParallelMainDebug {

    public static void main(final String[] args) throws Exception {
		SimulatorFactory factory = new SimulatorFactory(args[0]);
		TeamedPlaceGroup world = TeamedPlaceGroup.getWorld();
		boolean pipeline = false;
		long seed;
		for(String arg: args) {
			if(arg.equals("-pipeline")) pipeline = true;
		}

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
			runner.run(seed, pipeline);
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
			runner.run(seed, pipeline);
			out1.clear();
			out1.getDistLog().globalGather();
			out1.printAll(new PrintStream("logB.txt"));
		}
		// diff check
		PrintStream diffOut = new PrintStream("diff.txt");
		boolean flag = out1.getDistLog().distributionFreeEquals(out0.getDistLog(), diffOut);
		if(flag) {
			System.out.println("Exact match. Congratulation!");
		} else {
			System.out.println("Check diff file: diff.txt");
		}
		//boolean flag2 = out0.getDistLog().distributionFreeEquals(out1.getDistLog(), System.out);
		//if(flag2) System.out.println("Exact match. Congratulation again!");
	}
}
