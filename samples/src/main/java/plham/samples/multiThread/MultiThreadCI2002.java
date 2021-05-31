package plham.samples.multiThread;

import plham.core.main.ParallelRunnerMT;
import plham.core.main.SimulatorFactory;
import plham.core.util.Random;
import plham.samples.CI2002.NewCI2002Main;

public class MultiThreadCI2002 {

	public static void main(String[] args) throws Exception {
		final NewCI2002Main sim = new NewCI2002Main();
		
		SimulatorFactory factory = new SimulatorFactory(args[0]);
        long seed;
        if (args.length > 1) {
            seed = Long.valueOf(args[1]);
        } else {
            seed = new Random().nextLong(Long.MAX_VALUE / 2); // MEMO: main()
        }
		
		final ParallelRunnerMT runner = new ParallelRunnerMT(sim, factory);
		runner.run(seed);
	}
}
