package samples.PriceLimit;

import plham.Market;
import plham.event.PriceLimitRule;
import plham.main.SequentialRunner;
import samples.CI2002.CI2002Main;

public class PriceLimitMain extends CI2002Main {

	/*
	public static def main(args:Rail[String]) {
		val sim = new PriceLimitMain();
		PriceLimitFCNAgent.register(sim);
		Market.register(sim);
		PriceLimitRule.register(sim);
		new SequentialRunner(sim).run(args);
	}
	*/
	public static void main(String[] args) {
		final PriceLimitMain sim = new PriceLimitMain();
		PriceLimitFCNAgent.register(sim);
		Market.register(sim);
		PriceLimitRule.register(sim);
		final SequentialRunner<CI2002Main> runner = new SequentialRunner<CI2002Main>(
				sim);
		runner.run(args);
	}
}
