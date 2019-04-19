package samples.MarketShare;

import java.util.List;

import plham.Market;
import plham.main.SequentialRunner;
import samples.CI2002.CI2002Main;

/**
 * Reference: Kusada, Mizuta, Hayakawa, Izumi, Yoshimura (2014) Analysis of the
 * market makers spread's impact to markets volume shares using an artificial
 * market (in Japanese).
 */
public class MarketShareMain extends CI2002Main {

	/*
	public static def main(args:Rail[String]) {
		val sim = new MarketShareMain();
		MarketMakerAgent.register(sim);
		MarketShareFCNAgent.register(sim);
		new SequentialRunner(sim).run(args);
	}
	*/
	public static void main(String[] args) {
		final MarketShareMain sim = new MarketShareMain();
		MarketMakerAgent.register(sim);
		MarketShareFCNAgent.register(sim);
		final SequentialRunner<CI2002Main> runner = new SequentialRunner<CI2002Main>(
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
				market.getTradeVolume(t),
				"", ""], " ", "", Int.MAX_VALUE));
		}
	}
	*/
	@Override
	public void print(String sessionName) {
		@SuppressWarnings("hiding")
		List<Market> markets = getMarketsByName("markets");
		// List<Agent> agents = getAgentsByName("agents");
		for (Market market : markets) {
			long t = market.getTime();
			System.out.println(String.format("%s %s %s %s %s %s %s  ",
					sessionName, t, market.id, market.name, market.getPrice(t),
					market.getFundamentalPrice(t), market.getTradeVolume(t)));
		}
	}
}
