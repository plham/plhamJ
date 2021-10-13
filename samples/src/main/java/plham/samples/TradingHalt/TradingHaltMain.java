package plham.samples.TradingHalt;

import java.util.List;

import handist.collections.ChunkedList;
import plham.core.Agent;
import plham.core.Event;
import plham.core.Market;
import plham.core.OutputCollector;
import plham.core.SimulationOutput;
import plham.core.main.SequentialRunner;
import plham.core.main.Simulator.Session;
import plham.core.main.SimulatorFactory;
import plham.core.util.Random;

public class TradingHaltMain extends SimulationOutput {

    /**
     *
     */
    private static final long serialVersionUID = 4527490578477086915L;

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Arguments for TradingHaltMain");
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

    @Override
    public void print(OutputCollector output, Session s, List<Market> markets, ChunkedList<Agent> agents,
            List<Event> sessionEvents) {
//		List<Market> markets = getMarketsByName("markets");
        for (Market market : markets) {
            long t = market.getTime();
            System.out.println(String.format("%s %s %s %s %s %s %s  ", s.sessionName, t, market.id, market.name,
                    market.getPrice(), market.getFundamentalPrice(), market.isRunning()));
        }
    }
}
