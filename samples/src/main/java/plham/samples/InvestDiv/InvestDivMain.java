package plham.samples.InvestDiv;

import plham.core.main.SequentialRunner;
import plham.core.main.SimulatorFactory;
import plham.core.util.Random;
import plham.samples.TradingHalt.TradingHaltMain;

/**
 * Reference: Nozaki, Mizuta, Yagi (2016) Investigation of the rule for investment diversification at the time of a
 * market crash using an artificial market (in Japanese).
 */
public class InvestDivMain {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Arguments for InvestDivMain");
            System.err.println("\tJSON configuration file");
            System.err.println("\tseed (optional)");
            return;
        }
        try {
            final TradingHaltMain sim = new TradingHaltMain();
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
}
