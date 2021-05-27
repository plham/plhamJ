package plham.samples.CI2002;

import java.util.Map;

import plham.core.Market;
import plham.core.OutputCollector;
import plham.core.SimulationOutput;
import plham.core.main.SequentialRunner;
import plham.core.main.Simulator.Session;
import plham.core.main.SimulatorFactory;
import plham.core.util.Random;

public class NewCI2002Main extends SimulationOutput {

	/** Serial Version UID */
    private static final long serialVersionUID = 2493462616283426664L;

    public static void main(String[] args) {
		try {
			final NewCI2002Main sim = new NewCI2002Main();
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
    public void marketOutput(OutputCollector out, SimulationStage stage, Market market) {
        switch (stage) {
        case WITH_PRINT_DURING_SESSION:
            long t = market.getTime();
            out.log(market.name, String.format("%s %s %s %s %s  ", t, market.id, market.name,
                    market.getPrice(t), market.getFundamentalPrice(t)));
            break;
            
            default:
                // No outputs made in all other stages
        }
    }
    
    @Override
    public void sessionOutput(OutputCollector out, SimulationStage stage, Session s) {
        switch (stage) {
        case WITH_PRINT_DURING_SESSION:
            out.log("_SESSION_NAME_", s.sessionName);
            break;
            
            default:
                // No outputs made in all other stages
        }
    }
    
    @Override
    public void postProcess(OutputCollector output, SimulationStage stage, Map<String, Object> logs) {
        switch (stage) {
        case WITH_PRINT_DURING_SESSION:
            // Here we combine the session name with the state of each market in a single line
            // First remove the session name from the "logs" Map
            String sessionName = (String) logs.remove("_SESSION_NAME_");
            // All remaining entries in the "logs" correspond to the markets taking part in the simulation
            for (Object o : logs.values()) {
                String marketSuffix = (String) o;
                output.print(sessionName + " " + marketSuffix);
            }
            break;
            default:
                // No grouped outputs in all other stages
        }
    }
    
//  OLD OUTPUT METHOD HAS NOW BEEN REPLACED WITH THE THREE METHODS ABOVE    
//	@Override
//	public void print(OutputCollector output, Session session, List<Market> markets, List<Agent> agents, List<Event> sessionEvents) {
//		for (Market market : markets) {
//			long t = market.getTime();
//			System.out.println(String.format("%s %s %s %s %s %s  ", session.sessionName, t, market.id, market.name,
//					market.getPrice(t), market.getFundamentalPrice(t)));
//		}
//	}
}
