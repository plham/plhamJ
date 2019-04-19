package samples.FatTail;

import plham.Market;
import plham.agent.FCNAgent;
import plham.main.SequentialRunner;
import samples.CI2002.CI2002Main;

public class FatTailMain extends CI2002Main {
	/*
	public static def main(args:Rail[String]) {
		val sim = new FatTailMain();
		FCNAgent.register(sim);
		Market.register(sim);
		new SequentialRunner(sim).run(args);
	}
	 */
	public static void main(String[] args) {
		final FatTailMain sim = new FatTailMain();
		FCNAgent.register(sim);
		Market.register(sim);
		final SequentialRunner<FatTailMain> runner = new SequentialRunner<FatTailMain>(
				sim);
		runner.run(args);
	}
}
