package plham.samples.DarkPool;

import java.util.List;

import plham.core.Market;
import plham.core.OutputCollector;
import plham.core.SimulationOutput;
import plham.core.main.Simulator.Session;

/**
 * Reference: Mizuta, Kosugi, Kusumoto, Matsumoto, Izumi (2014) Analysis of the
 * impact of dark pool to the market efficiency using an artificial market (in
 * Japanese).
 */
public class NewDarkPool extends SimulationOutput {

    /** Serial Version UID */
    private static final long serialVersionUID = -3107504389856037530L;


    @Override
    public void marketOutput(OutputCollector out, SimulationStage stage, Market market) {
        switch (stage) {
        case WITH_PRINT_DURING_SESSION:
            String key = market.name;

            Double price = market.getPrice();
            long t = market.getTime();
            String marketOutput = String.format("%s %s %s %s %s", t, market.id, market.name,
                    market.getPrice(), market.getFundamentalPrice());

            long tradeVolume = market.getTradeVolume();

            out.log(key, price);
            out.log(key, marketOutput);
            out.log(key, tradeVolume);
            break;
        default:
        }
    }

    @Override
    public void sessionOutput(OutputCollector out, SimulationStage stage, Session s) {
        switch (stage) {
        case WITH_PRINT_DURING_SESSION:
            out.log("_SESSION_", s.sessionName);
            break;
        default:
        }
    }

    @Override
    public void postProcess(OutputCollector output, SimulationStage stage) {
        switch (stage) {
        case WITH_PRINT_DURING_SESSION:
            List<String> litMarket = output.removeLog("LitMarket");
            List<String> darkMarket = output.removeLog("DarkPoolMarket");

            String sessionName = output.removeLog("_SESSION_").get(0);

            double litPrice = Double.parseDouble(litMarket.get(0));
            double darkPrice = Double.parseDouble(darkMarket.get(0));
            String litString = litMarket.get(1);
            String darkString = darkMarket.get(1);
            long litVolume = Long.parseLong(litMarket.get(2));
            long darkVolume = Long.parseLong(darkMarket.get(2));

            double tradePrice = Double.NaN;
            if (darkVolume > 0) {
                tradePrice = darkPrice;
            } else if (litVolume > 0){
                tradePrice = litPrice;
            }

            output.print(sessionName + " " + litString + " " + tradePrice + " " + litVolume + "  ");
            output.print(sessionName + " " + darkString + " " + tradePrice + " " + darkVolume + "  ");
            break;
        default:
        }
    }
}
