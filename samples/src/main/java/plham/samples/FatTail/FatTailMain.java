package plham.samples.FatTail;

import plham.core.main.SequentialRunner;
import plham.core.main.SimulatorFactory;
import plham.core.util.Random;
import plham.samples.CI2002.CI2002Main;

public class FatTailMain {

	public static void main(String[] args) {
		try {
			final CI2002Main sim = new CI2002Main();
			SimulatorFactory factory = new SimulatorFactory(args[0]);
			long seed;
			if (args.length > 1) {
				seed = Long.valueOf(args[1]);
			} else {
				seed = new Random().nextLong(Long.MAX_VALUE / 2); // MEMO: main()
			}

			final SequentialRunner runner = new SequentialRunner(factory, sim);
			runner.run(seed);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
