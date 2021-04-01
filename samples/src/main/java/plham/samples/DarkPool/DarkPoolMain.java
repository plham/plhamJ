package plham.samples.DarkPool;

import java.util.List;

import plham.core.Market;
import plham.core.main.SequentialRunner;
import plham.core.main.Simulator;
import plham.core.main.SimulatorFactory;
import plham.core.util.Random;

/**
 * Reference: Mizuta, Kosugi, Kusumoto, Matsumoto, Izumi (2014) Analysis of the
 * impact of dark pool to the market efficiency using an artificial market (in
 * Japanese).
 */
public class DarkPoolMain extends Simulator {

	public static void main(String[] args) {
		try {
			final DarkPoolMain sim = new DarkPoolMain();
			SimulatorFactory factory = new SimulatorFactory(args[0]);
			long seed;
			if (args.length > 1) {
				seed = Long.valueOf(args[1]);
			} else {
				seed = new Random().nextLong(Long.MAX_VALUE / 2);
			}

			final SequentialRunner runner = new SequentialRunner(factory, sim);
			runner.run(seed);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	@Override
	public void print(String sessionName) {
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
			System.out.println(String.format("%s %s %s %s %s %s %s %s  ", sessionName, t, market.id, market.name,
					market.getPrice(t), market.getFundamentalPrice(t), tradePrice, market.getTradeVolume()));
		}
	}
}
