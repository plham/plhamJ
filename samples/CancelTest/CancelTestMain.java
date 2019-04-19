package samples.CancelTest;

import plham.main.SequentialRunner;
import samples.CI2002.CI2002Main;

public class CancelTestMain extends CI2002Main {
	/*
	public static def main(args:Rail[String]) {
		val sim = new CancelTestMain();
		CancelFCNAgent.register(sim);
		new SequentialRunner(sim).run(args);
	}
	 */
	public static void main(String[] args) {
		final CancelTestMain sim = new CancelTestMain();
		CancelFCNAgent.register(sim);
		final SequentialRunner<CancelTestMain> runner = new SequentialRunner<CancelTestMain>(
				sim);
		runner.run(args);
	}
}
