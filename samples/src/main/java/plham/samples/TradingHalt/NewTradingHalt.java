package plham.samples.TradingHalt;

import java.util.List;

import plham.core.Market;
import plham.core.OutputCollector;
import plham.core.SimulationOutput;
import plham.core.main.Simulator.Session;

public class NewTradingHalt extends SimulationOutput {

    /** Serial Version UID */
    private static final long serialVersionUID = 926470720380549779L;

    @Override
    public void marketOutput(OutputCollector out, SimulationStage stage, Market market) {
        switch (stage) {
        case WITH_PRINT_DURING_SESSION:
            long t = market.getTime();
            out.log(market.name, String.format("%s %s %s %s %s %s  ", t, market.id, market.name,
                    market.getPrice(t), market.getFundamentalPrice(t), market.isRunning()));
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
    public void postProcess(OutputCollector output, SimulationStage stage) {
        switch (stage) {
        case WITH_PRINT_DURING_SESSION:
            // Here we combine the session name with the state of each market in a single line
            // First remove the session name from the "logs" Map
            String sessionName = (String) output.removeLog("_SESSION_NAME_").get(0);
            // All remaining entries in the "logs" correspond to the markets taking part in the simulation
            output.forEach((String key, List<String> lo)->{
                if (key.equals("Market")) {
                    String marketSuffix = lo.get(0);
                    output.print(sessionName + " " + marketSuffix);
                }
            });
            break;
        default:
            // No grouped outputs in all other stages
        }
    }
    

//	@Override
//	public void print(OutputCollector output, Session s, List<Market> markets, ChunkedList<Agent> agents, List<Event> sessionEvents) {
////		List<Market> markets = getMarketsByName("markets");
//		for (Market market : markets) {
//			long t = market.getTime();
//			System.out.println(String.format("%s %s %s %s %s %s %s  ", s.sessionName, t, market.id, market.name,
//					market.getPrice(t), market.getFundamentalPrice(t), market.isRunning()));
//		}
//	}
}
