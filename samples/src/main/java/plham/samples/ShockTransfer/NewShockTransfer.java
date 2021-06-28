package plham.samples.ShockTransfer;

import plham.core.IndexMarket;
import plham.core.Market;
import plham.core.OutputCollector;
import plham.core.SimulationOutput;
import plham.core.main.Simulator.Session;

public class NewShockTransfer extends SimulationOutput {

    /** Serial Version UID */
    private static final long serialVersionUID = -5912846100236874197L;


    @Override
    public void marketOutput(OutputCollector out, SimulationStage stage, Market market) {
        switch (stage) {
        case WITH_PRINT_DURING_SESSION:
            long t = market.getTime();
            double marketIndex = Double.NaN;
            if (market instanceof IndexMarket) {
                marketIndex = ((IndexMarket) market).getIndex(t);
            }
            out.log(market.name, String.format("%s %s %s %s %s %s  ", t, market.id, market.name,
                    market.getPrice(t), market.getFundamentalPrice(t), marketIndex));
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
            
            String market1 = output.removeLog("SpotMarket-1").get(0);
            String market2 = output.removeLog("SpotMarket-2").get(0);
            String indexMarket = output.removeLog("IndexMarket-I").get(0);
            
            output.print(sessionName + " " + market2);
            output.print(sessionName + " " + market1);
            output.print(sessionName + " " + indexMarket);
            break;
        default:
            // No grouped outputs in all other stages
        }
    }
}
