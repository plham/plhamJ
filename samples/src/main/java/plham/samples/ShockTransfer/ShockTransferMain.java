package plham.samples.ShockTransfer;

import java.util.List;

import handist.collections.ChunkedList;
import plham.core.Agent;
import plham.core.Event;
import plham.core.IndexMarket;
import plham.core.Market;
import plham.core.OutputCollector;
import plham.core.SimulationOutput;
import plham.core.main.SequentialRunner;
import plham.core.main.Simulator.Session;
import plham.core.main.SimulatorFactory;
import plham.core.util.Random;

public class ShockTransferMain extends SimulationOutput {

    /** Serial Version UID */
    private static final long serialVersionUID = -5912846100236874197L;

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Arguments for ShockTransferMain");
            System.err.println("\tJSON configuration file");
            System.err.println("\tseed (optional)");
            return;
        }
        try {
            final ShockTransferMain sim = new ShockTransferMain();
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
            double marketIndex = Double.NaN;
            if (market instanceof IndexMarket) {
                marketIndex = ((IndexMarket) market).getIndex(t);
            }
            System.out.println(String.format("%s %s %s %s %s %s %s  ", s.sessionName, t, market.id, market.name,
                    market.getPrice(t), market.getFundamentalPrice(), marketIndex));
        }
    }
}
