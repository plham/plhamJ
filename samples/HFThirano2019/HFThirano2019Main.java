package samples.HFThirano2019;

import plham.Agent;
import plham.Main;
import plham.Market;
import plham.event.FundamentalPriceShock;
import plham.main.SequentialRunner;
import plham.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

import java.io.IOException;
import java.util.stream.Collectors;

public class HFThirano2019Main extends Main {
    public static void main(String[] args) {
        final HFThirano2019Main sim = new HFThirano2019Main();
        DelayFCNAgent.register(sim);
        HFTMMAgent.register(sim);
        Market.register(sim);
        FundamentalPriceShock.register(sim);
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
            HashMap<Double, Long> sellBookHFT = new HashMap<Double, Long>();
            for (Order order: market.getSellOrderBook().queue){
                if (order.isExpired(t) || market.getSellOrderBook().isCancelled(order)){
                    continue;
                }
                if (sellBook.get(order.price) == null){
                    sellBook.put(order.price, order.volume);
                }else{
                    Long volume = sellBook.get(order.price);
                    volume += order.volume;
                    sellBook.put(order.price, volume);
                }

                List<Agent> agentList = this.agents.stream().filter(one -> one.id == order.agentId).collect(Collectors.toUnmodifiableList());
                assert  agentList.size() == 1: "Order cannot pick up one agent";
                Agent ag = agentList.get(0);
                if (ag.name.equals("HFTMMAgents")){
                    if (sellBookHFT.get(order.price) == null){
                        sellBookHFT.put(order.price, order.volume);
                    }else{
                        Long volume = sellBookHFT.get(order.price);
                        volume += order.volume;
                        sellBookHFT.put(order.price, volume);
                    }
                }
            }
            HashMap<Double, Long> buyBook = new HashMap<Double, Long>();
            HashMap<Double, Long> buyBookHFT = new HashMap<Double, Long>();
            for (Order order: market.getBuyOrderBook().queue){
                if (order.isExpired(t) || market.getBuyOrderBook().isCancelled(order)){
                    continue;
                }
                if (buyBook.get(order.price) == null){
                    buyBook.put(order.price, order.volume);
                }else{
                    Long volume = buyBook.get(order.price);
                    volume += order.volume;
                    buyBook.put(order.price, volume);
                }
                List<Agent> agentList = this.agents.stream().filter(one -> one.id == order.agentId).collect(Collectors.toUnmodifiableList());
                assert  agentList.size() == 1: "Order cannot pick up one agent";
                Agent ag = agentList.get(0);
                if (ag.name.equals("HFTMMAgents")){
                    if (buyBookHFT.get(order.price) == null){
                        buyBookHFT.put(order.price, order.volume);
                    }else{
                        Long volume = buyBookHFT.get(order.price);
                        volume += order.volume;
                        buyBookHFT.put(order.price, volume);
                    }
                }
            }

            sellBook.entrySet().stream()
                    .sorted(java.util.Collections.reverseOrder(java.util.Map.Entry.comparingByKey()))
                    .forEach(s -> System.out.println(String.format("%s %s %s %s %s %s %s %s %s %s ",
                            "OrderBook", sessionName, t, market.id, "Sell", s.getKey(),s.getValue()
                            , sellBookHFT.get(s.getKey()) == null ? 0: sellBookHFT.get(s.getKey()), "-", "-")));

            buyBook.entrySet().stream()
                    .sorted(java.util.Collections.reverseOrder(java.util.Map.Entry.comparingByKey()))
                    .forEach(s -> System.out.println(String.format("%s %s %s %s %s %s %s %s %s %s",
                            "OrderBook", sessionName, t, market.id, "Buy", s.getKey(),s.getValue()
                            , buyBookHFT.get(s.getKey()) == null ? 0: buyBookHFT.get(s.getKey()), "-", "-")));


            //System.out.println(market.getSellOrderBook().queue.size()+ market.getSellOrderBook().queue.size());

        }
    }
    @Override
    public void endprint(String sessionName, long iterationSteps) {
        super.endprint(sessionName, iterationSteps);
        System.out.println("# LogType SessionName Time MarketId MarketName FundamentalPrice lastPrice BestBuyPrice BestSellPrice TradeVolume");

        System.out.println("# Result of HFT order volume >>>>>>>");
        HashMap<Long, HashMap<String, Long>> orderPlace = new HashMap<>();
        for (Agent agent: this.agents.stream().filter(s -> s.name.equals("HFTMMAgents")).collect(Collectors.toUnmodifiableList())){
            assert agent.name.equals("HFTMMAgents"): "type Error";
            HFTMMAgent agent2 = (HFTMMAgent) agent;
            //System.out.println(agent2.name);
            HashMap<Order, HFTMMAgent.OrderData> orderMap = agent2.orderMap;
            for (HFTMMAgent.OrderData orderData: orderMap.values()){
                long volume = orderData.volume;
                long tick = orderData.tickPlace;
                boolean isExcuted = orderData.isExcuted;
                if (orderPlace.get(tick) == null){
                    HashMap<String, Long> temp = new HashMap<>();
                    temp.put("volume", volume);
                    temp.put("volumeExcuted", (isExcuted? volume: 0));
                    orderPlace.put(tick, temp);
                }else{
                    HashMap<String, Long> temp = orderPlace.get(tick);
                    long _volume = volume + temp.get("volume");
                    long _volumeExcuted = (isExcuted? volume: 0) + temp.get("volumeExcuted");
                    temp.put("volume", _volume);
                    temp.put("volumeExcuted", _volumeExcuted);
                    orderPlace.put(tick, temp);
                }
            }
        }
        orderPlace.entrySet().stream().sorted(HashMap.Entry.comparingByKey())
                .collect(Collectors.toUnmodifiableList()).forEach(k -> System.out.println(String.format(
                "%s %s %s %s %s","HFTOrderVolumePlace", k.getKey(), k.getValue().get("volume"), k.getValue().get("volumeExcuted"),
                k.getValue().get("volumeExcuted") * 1.0 / k.getValue().get("volume")
        )));

        long plusVolume = 0;
        long plusVolumeExcuted = 0;
        for (long key: orderPlace.keySet()){
            if (key < 0){
                continue;
            }
            plusVolume += orderPlace.get(key).get("volume");
            plusVolumeExcuted += orderPlace.get(key).get("volumeExcuted");
        }
        System.out.println(plusVolumeExcuted * 1.0 / plusVolume);

        System.out.println("# Result of HFT orders >>>>>>>");
        HashMap<Long, HashMap<String, Long>> orderPlace2 = new HashMap<>();
        for (Agent agent: this.agents.stream().filter(s -> s.name.equals("HFTMMAgents")).collect(Collectors.toUnmodifiableList())){
            assert agent.name.equals("HFTMMAgents"): "type Error";
            HFTMMAgent agent2 = (HFTMMAgent) agent;
            //System.out.println(agent2.name);
            HashMap<Order, HFTMMAgent.OrderData> orderMap = agent2.orderMap;
            for (HFTMMAgent.OrderData orderData: orderMap.values()){
                long volume = orderData.volume;
                long tick = orderData.tickPlace;
                boolean isExcuted = orderData.isExcuted;
                if (orderPlace2.get(tick) == null){
                    HashMap<String, Long> temp = new HashMap<>();
                    temp.put("volume", (long) 1);
                    temp.put("volumeExcuted", (isExcuted? volume: 0));
                    orderPlace2.put(tick, temp);
                }else{
                    HashMap<String, Long> temp = orderPlace2.get(tick);
                    long _volume = (long) 1 + temp.get("volume");
                    long _volumeExcuted = (isExcuted? volume: 0) + temp.get("volumeExcuted");
                    temp.put("volume", _volume);
                    temp.put("volumeExcuted", _volumeExcuted);
                    orderPlace2.put(tick, temp);
                }
            }
        }
        orderPlace2.entrySet().stream().sorted(HashMap.Entry.comparingByKey())
                .collect(Collectors.toUnmodifiableList()).forEach(k -> System.out.println(String.format(
                "%s %s %s %s %s","HFTOrderPlace", k.getKey(), k.getValue().get("volume"), k.getValue().get("volumeExcuted"),
                k.getValue().get("volumeExcuted") * 1.0 / k.getValue().get("volume")
        )));

        long plusVolume2 = 0;
        long plusVolumeExcuted2 = 0;
        for (long key: orderPlace2.keySet()){
            if (key < 0){
                continue;
            }
            plusVolume2 += orderPlace2.get(key).get("volume");
            plusVolumeExcuted2 += orderPlace2.get(key).get("volumeExcuted");
        }
        System.out.println(plusVolumeExcuted2 * 1.0 / plusVolume2);


        System.out.println("# Result of each agent >>>>>>>");
        HashMap<String, List<Double>> cashMap = new HashMap<String, List<Double>>();
        for (Agent oneAgent: this.agents){
            //System.out.println(String.format("%s %s", oneAgent.name, oneAgent.getCashAmount()));
            List<Double> cashList = new ArrayList<Double>();
            if (cashMap.keySet().contains(oneAgent.name)){
                cashList = cashMap.get(oneAgent.name);
            }
            double price = oneAgent.getCashAmount();
            for (Market market : this.markets){
                price += oneAgent.getAssetVolume(market) * market.getPrice();
            }
            cashList.add(price);
            cashMap.put(oneAgent.name, cashList);
        }
        System.out.println("# Result of each agents type >>>>>>>");
        for (String key: cashMap.keySet()){
            double mean = 0;
            for (double cash: cashMap.get(key)){
                mean += cash;
            }
            mean /= cashMap.get(key).size();
            System.out.println(String.format("%s %s", key, mean));
        }

    }
}
