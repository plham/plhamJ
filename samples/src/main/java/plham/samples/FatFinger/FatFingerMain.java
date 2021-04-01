package plham.samples.FatFinger;

import java.util.List;

import plham.core.Market;
import plham.core.main.SequentialRunner;
import plham.core.main.SimulatorFactory;
import plham.core.util.Random;
import plham.samples.CI2002.CI2002Main;

public class FatFingerMain extends CI2002Main {

	public static void main(String[] args) {
		try {
			final FatFingerMain sim = new FatFingerMain();
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
	public void print(String sessionName) {
		super.print(sessionName); // Calls CI2002Main#print(String)

		// Print additional information compared to CI2002Main
		List<Market> markets = getMarketsByName("markets");
		for (Market market : markets) {
			market.getBuyOrderBook().dump();
			market.getSellOrderBook().dump();
		}
	}
}
