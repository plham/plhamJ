package plham.samples.MarketShare;

import java.util.List;

import plham.core.Agent;
import plham.core.Event;
import plham.core.Market;
import plham.core.OutputCollector;
import plham.core.SimulationOutput;
import plham.core.main.SequentialRunner;
import plham.core.main.SimulatorFactory;
import plham.core.util.Random;

/**
 * Reference: Kusada, Mizuta, Hayakawa, Izumi, Yoshimura (2014) Analysis of the
 * market makers spread's impact to markets volume shares using an artificial
 * market (in Japanese).
 */
public class MarketShareMain extends SimulationOutput {

	/** Serial Version UID */
    private static final long serialVersionUID = 182717018142244006L;

    public static void main(String[] args) {
		try {
			final MarketShareMain sim = new MarketShareMain();
			SimulatorFactory factory = new SimulatorFactory(args[0]);
			long seed;
			if (args.length > 1) {
				seed = Long.valueOf(args[1]);
			} else {
				seed = new Random().nextLong(Long.MAX_VALUE / 2); // MEMO: main()
			}

			final SequentialRunner runner = new SequentialRunner(factory, sim);
			runner.run(seed);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	@Override
	public void print(OutputCollector output, String sessionName, List<Market> markets, List<Agent> agents, List<Event> sessionEvents) {
//		List<Market> markets = getMarketsByName("markets");
		for (Market market : markets) {
			long t = market.getTime();
			System.out.println(String.format("%s %s %s %s %s %s %s  ", sessionName, t, market.id, market.name,
					market.getPrice(t), market.getFundamentalPrice(t), market.getTradeVolume(t)));
		}
	}
}
