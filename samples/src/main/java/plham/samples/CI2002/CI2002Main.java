package plham.samples.CI2002;

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

public class CI2002Main extends SimulationOutput {

	/** Serial Version UID */
    private static final long serialVersionUID = 2493462616283426664L;

    public static void main(String[] args) {
		try {
			final CI2002Main sim = new CI2002Main();
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
	public void print(OutputCollector output, Session session, List<Market> markets, ChunkedList<Agent> agents, List<Event> sessionEvents) {
		for (Market market : markets) {
			long t = market.getTime();
			System.out.println(String.format("%s %s %s %s %s %s  ", session.sessionName, t, market.id, market.name,
					market.getPrice(t), market.getFundamentalPrice()));
		}
	}
}
