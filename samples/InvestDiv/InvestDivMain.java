package samples.InvestDiv;

import plham.main.SequentialRunner;
import samples.TradingHalt.TradingHaltMain;

/**
 * Reference: Nozaki, Mizuta, Yagi (2016) Investigation of the rule for
 * investment diversification at the time of a market crash using an artificial
 * market (in Japanese).
 */
public class InvestDivMain extends TradingHaltMain {
	/*
	public static def main(args:Rail[String]) {
		val sim = new InvestDivMain();
		InvestDivFCNAgent.register(sim);
		new SequentialRunner(sim).run(args);
	}
	 */
	public static void main(String[] args) {
		final InvestDivMain sim = new InvestDivMain();
		InvestDivFCNAgent.register(sim);
		final SequentialRunner<InvestDivMain> runner = new SequentialRunner<InvestDivMain>(
				sim);
		runner.run(args);
	}
}
