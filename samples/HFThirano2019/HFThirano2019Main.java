package samples.HFThirano2019;

import plham.Main;
import plham.Market;
import plham.main.SequentialRunner;
import plham.Order;

import java.util.List;

public class HFThirano2019Main extends Main {
    public static void main(String[] args) {
        final HFThirano2019Main sim = new HFThirano2019Main();
        DelayFCNAgent.register(sim);
        Market.register(sim);
        final SequentialRunner<HFThirano2019Main> runner = new SequentialRunner<HFThirano2019Main>(
                sim);
        runner.run(args);
    }

    public HFThirano2019Main() {
        // do nothing
    }

    /*@Override
    public void print(String sessionName) {
        super.print(sessionName);
    }*/
    @Override
    public void beginSession(String sessionName) {
        super.beginSession(sessionName);
        System.out.println("# SessionName Time MarketId MarketName FundamentalPrice BestBuyPrice BestSellPrice TradeVolume");
    }

    @Override
    public void print(String sessionName) {
        @SuppressWarnings("hiding")
        List<Market> markets = getMarketsByName("markets");
        // List<Agent> agents = getAgentsByName("agents");

        assert markets.size() == 2;

        for (Market market : markets) {
            long t = market.getTime();
            System.out.println(String.format("%s %s %s %s %s %s %s %s %s %s ",
                    "MarketPrice",sessionName, t, market.id, market.name, market.getFundamentalPrice(t),
                    market.getPrice(t), market.getBestBuyPrice(), market.getBestSellPrice(),
                    market.getTradeVolume()));
        }
    }
    @Override
    public void endprint(String sessionName, long iterationSteps) {
        super.endprint(sessionName, iterationSteps);
        System.out.println("# LogType SessionName Time MarketId MarketName FundamentalPrice lastPrice BestBuyPrice BestSellPrice TradeVolume");
    }
}
