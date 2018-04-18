package samples.DarkPool;

import java.util.List;

import plham.Market;
import plham.main.SequentialRunner;
import samples.CI2002.CI2002Main;

/**
 * Reference: Mizuta, Kosugi, Kusumoto, Matsumoto, Izumi (2014) Analysis of the
 * impact of dark pool to the market efficiency using an artificial market (in
 * Japanese).
 */
public class DarkPoolMain extends CI2002Main {
	/*
	public static def main(args:Rail[String]) {
		val sim = new DarkPoolMain();
		DarkPoolFCNAgent.register(sim);
		DarkPoolMarket.register(sim);
		new SequentialRunner(sim).run(args);
	}
	*/
	public static void main(String[] args) {
		final DarkPoolMain sim = new DarkPoolMain();
		DarkPoolFCNAgent.register(sim);
		DarkPoolMarket.register(sim);
		final SequentialRunner<DarkPoolMain> runner = new SequentialRunner<DarkPoolMain>(
				sim);
		runner.run(args);
	}

	/*
	public def print(sessionName:String) {
		val markets = getMarketsByName("markets");
		val agents = getAgentsByName("agents");

		assert markets.size() == 2;
		val lit = getMarketByName("LitMarket"); // Name defined in JSON file.
		val dark = getMarketByName("DarkPoolMarket");
		var tradePrice:Double = Double.NaN;
		if (dark.getTradeVolume() > 0) {
			tradePrice = dark.getPrice();
		} else if (lit.getTradeVolume() > 0) {
			tradePrice = lit.getPrice();
		}

		for (market in markets) {
			val t = market.getTime();
			Console.OUT.println(StringUtil.formatArray([
				sessionName,
				t, 
				market.id,
				market.name,
				market.getPrice(t),
				market.getFundamentalPrice(t),
				//
				tradePrice,
				market.getTradeVolume(),
				"", ""], " ", "", Int.MAX_VALUE));
		}
	}
	 */
	@Override
	public void print(String sessionName) {
		@SuppressWarnings("hiding")
		List<Market> markets = getMarketsByName("markets");
		// List<Agent> agents = getAgentsByName("agents");

		assert markets.size() == 2;
		Market lit = getMarketByName("LitMarket"); // Name defined in JSON file.
		Market dark = getMarketByName("DarkPoolMarket");
		double tradePrice = Double.NaN;
		if (dark.getTradeVolume() > 0) {
			tradePrice = dark.getPrice();
		} else if (lit.getTradeVolume() > 0) {
			tradePrice = lit.getPrice();
		}

		for (Market market : markets) {
			long t = market.getTime();
			System.out.println(String.format("%s %s %s %s %s %s %s %s  ",
					sessionName, t, market.id, market.name, market.getPrice(t),
					market.getFundamentalPrice(t), tradePrice,
					market.getTradeVolume()));
		}
	}
}
