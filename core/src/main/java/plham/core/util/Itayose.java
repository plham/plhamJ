package plham.core.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import plham.core.Market;
import plham.core.Market.AgentUpdate;
import plham.core.Order;

public class Itayose implements Serializable {
    private static final long serialVersionUID = -8621943005604743083L;

    public static void itayose(Market market) {
        List<AgentUpdate> buyUpdates = new ArrayList<>();
        List<AgentUpdate> sellUpdates = new ArrayList<>();
        double lastBuyPrice = 0.0;
        double lastSellPrice = 0.0;
        long sumExchangeVolume = 0;
        while (remainExecutableOrders(market)) {
            Order buyOrder = market.getBestBuyOrder();
            Order sellOrder = market.getBestSellOrder();

            lastBuyPrice = buyOrder.getPrice();
            lastSellPrice = sellOrder.getPrice();
            long exchangeVolume = Math.min(buyOrder.getVolume(), sellOrder.getVolume());
            sumExchangeVolume += exchangeVolume;

            buyOrder.updateVolume(-exchangeVolume);
            sellOrder.updateVolume(-exchangeVolume);

            // val cashAmountDelta = exchangePrice * exchangeVolume;
            long assetVolumeDelta = exchangeVolume;

            AgentUpdate buyUpdate = new AgentUpdate();
            buyUpdate.agentId = buyOrder.agentId;
            buyUpdate.marketId = buyOrder.marketId;
            buyUpdate.orderId = buyOrder.orderId;
            buyUpdate.price = Double.NaN;
            buyUpdate.cashAmountDelta = Double.NaN; // A buyer pays cash
            buyUpdate.assetVolumeDelta = +assetVolumeDelta; // and gets stocks
            buyUpdates.add(buyUpdate);

            AgentUpdate sellUpdate = new AgentUpdate();
            sellUpdate.agentId = sellOrder.agentId;
            sellUpdate.marketId = sellOrder.marketId;
            sellUpdate.orderId = sellOrder.orderId;
            sellUpdate.price = Double.NaN;
            sellUpdate.cashAmountDelta = Double.NaN; // A seller gets cash
            sellUpdate.assetVolumeDelta = -assetVolumeDelta; // and gives stocks
            sellUpdates.add(sellUpdate);

            if (buyOrder.getVolume() <= 0) {
                market.getBuyOrderBook().remove(buyOrder);
            }
            if (sellOrder.getVolume() <= 0) {
                market.getSellOrderBook().remove(sellOrder);
            }
        }

        // If there are only market orders in the buy or sell side, use the counter part
        // price as the exchange price
        if (Double.isNaN(lastBuyPrice))
            lastBuyPrice = lastSellPrice;
        if (Double.isNaN(lastSellPrice))
            lastSellPrice = lastBuyPrice;
        // If there are only market orders in the both buy and sell side, we cannot
        // determine what price to use. It should be handled as an error.
        if (Double.isNaN(lastBuyPrice) && Double.isNaN(lastSellPrice)) {
            System.out
                    .println("#WARNING: there remains only market orders in the " + market.name + " market orderbook.");
        }
        // Or mid price???
        double exchangePrice = (lastBuyPrice + lastSellPrice) / 2.0;
        for (AgentUpdate update : buyUpdates) {
            long exchangeVolume = Math.abs(update.assetVolumeDelta);
            double cashAmountDelta = exchangePrice * exchangeVolume;
            update.price = exchangePrice;
            update.cashAmountDelta = -cashAmountDelta; // A buyer pays cash
        }
        for (AgentUpdate update : sellUpdates) {
            long exchangeVolume = Math.abs(update.assetVolumeDelta);
            double cashAmountDelta = exchangePrice * exchangeVolume;
            update.price = exchangePrice;
            update.cashAmountDelta = +cashAmountDelta; // A seller gets cash
        }

        market.handleItayoseUpdate(buyUpdates.size(), exchangePrice, sumExchangeVolume);

        for (AgentUpdate update : buyUpdates) {
            market.handleAgentUpdate(update);
        }
        for (AgentUpdate update : sellUpdates) {
            market.handleAgentUpdate(update);
        }
    }

    public static boolean remainExecutableOrders(Market market) {
        if (market.getBuyOrderBook().size() == 0)
            return false;
        if (market.getSellOrderBook().size() == 0)
            return false;
        Order buy = market.getBestBuyOrder();
        Order sell = market.getBestSellOrder();
        return buy.isMarketOrder() || sell.isMarketOrder() || buy.price >= sell.price;
    }
}
