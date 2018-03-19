package samples.CI2002;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import plham.Agent;
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
		plham.Market.register(sim);
		final SequentialRunner<CI2002Main> runner = new SequentialRunner<CI2002Main>();
		runner.run(args);
	}

	public CI2002Main() {
		// do nothing
	}

	@Override
	public void print(String sessionName) {
		@SuppressWarnings("hiding")
		List<Market> markets = getMarketsByName("markets");
		for (Market market : markets) {
			long t = market.getTime$O();
			System.out.println(String.format("%s %s %s %s %s %s", sessionName,
					t, market.id, market.name, market.getPrice$O(t),
					market.getFundamentalPrice(t)));
		}
	}
}
