package samples.TradingHalt;

import java.util.List;

import plham.Market;
import plham.agent.FCNAgent;
import plham.event.FundamentalPriceShock;
import plham.event.TradingHaltRule;
import plham.main.SequentialRunner;
import samples.CI2002.CI2002Main;

public class TradingHaltMain extends CI2002Main {
	/*
	public static def main(args:Rail[String]) {
		val sim = new TradingHaltMain();
		FCNAgent.register(sim);
		Market.register(sim);
		FundamentalPriceShock.register(sim);
		TradingHaltRule.register(sim);
		new SequentialRunner(sim).run(args);
	}
	 */
	public static void main(String[] args) {
		final TradingHaltMain sim = new TradingHaltMain();
		FCNAgent.register(sim);
		Market.register(sim);
		FundamentalPriceShock.register(sim);
		TradingHaltRule.register(sim);
		final SequentialRunner<TradingHaltMain> runner = new SequentialRunner<TradingHaltMain>(
				sim);
		runner.run(args);
	}

	/*
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
				market.isRunning(),
				"", ""], " ", "", Int.MAX_VALUE));
		}
	}	 */
	@Override
	public void print(String sessionName) {
		@SuppressWarnings("hiding")
		List<Market> markets = getMarketsByName("markets");
		// List<Agent> agents = getAgentsByName("agents");
		for (Market market : markets) {
			long t = market.getTime();
			System.out.println(String.format("%s %s %s %s %s %s %s  ",
					sessionName, t, market.id, market.name, market.getPrice(t),
					market.getFundamentalPrice(t), market.isRunning()));
		}
	}
}
