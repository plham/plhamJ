package samples.CI2002;

import plham.Main;
import plham.Market;
import plham.agent.FCNAgent;
import plham.main.SequentialRunner;

public class CI2002Main extends Main {
	/*
	public static def main(args:Rail[String]) {
		val sim = new CI2002Main();
		FCNAgent.register(sim);
		Market.register(sim);
		new SequentialRunner(sim).run(args);
	}

	public def print(sessionName:String) {
		val markets = getMarketsByName("markets");
		val agents = getAgentsByName("agents");
		for (market in markets) {
			val t = market.getTime();
			Console.OUT.println(StringUtil.formatArray([
				sessionName,
				t, 
				market.id,
				market.name,
				market.getPrice(t),
				market.getFundamentalPrice(t),
				"", ""], " ", "", Int.MAX_VALUE));
		}
	}
	 */
	public static void main(String[] args) {
		final CI2002Main sim = new CI2002Main();
		FCNAgent.register(sim);
		Market.register(sim);
		final SequentialRunner<CI2002Main> runner = new SequentialRunner<CI2002Main>(
				sim);
		runner.run(args);
	}

	public CI2002Main() {
		// do nothing
	}

	@Override
	public void print(String sessionName) {
		super.print(sessionName);
	}
}
