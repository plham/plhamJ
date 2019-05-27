package samples.HFThirano2019;

import plham.Main;
import plham.Market;
import plham.main.SequentialRunner;
import plham.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

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
            HashMap<Double, Long> sellBook = new HashMap<Double, Long>();
            for (Order order: market.getSellOrderBook().queue){
                if (sellBook.get(order.price) == null){
                    sellBook.put(order.price, order.volume);
                }else{
                    Long volume = sellBook.get(order.price);
                    volume += order.volume;
                    sellBook.put(order.price, volume);
                }
            }
            HashMap<Double, Long> buyBook = new HashMap<Double, Long>();
            for (Order order: market.getBuyOrderBook().queue){
                if (buyBook.get(order.price) == null){
                    buyBook.put(order.price, order.volume);
                }else{
                    Long volume = buyBook.get(order.price);
                    volume += order.volume;
                    buyBook.put(order.price, volume);
                }
            }

            sellBook.entrySet().stream()
                    .sorted(java.util.Collections.reverseOrder(java.util.Map.Entry.comparingByKey()))
                    .forEach(s -> System.out.println(String.format("%s %s %s %s %s %s %s",
                            "OrderBook", sessionName, t, market.id, "Sell", s.getKey(),s.getValue())));

            buyBook.entrySet().stream()
                    .sorted(java.util.Collections.reverseOrder(java.util.Map.Entry.comparingByKey()))
                    .forEach(s -> System.out.println(String.format("%s %s %s %s %s %s %s",
                            "OrderBook", sessionName, t, market.id, "Buy", s.getKey(),s.getValue())));

        }
    }
    @Override
    public void endprint(String sessionName, long iterationSteps) {
        super.endprint(sessionName, iterationSteps);
        System.out.println("# LogType SessionName Time MarketId MarketName FundamentalPrice lastPrice BestBuyPrice BestSellPrice TradeVolume");
    }
}
