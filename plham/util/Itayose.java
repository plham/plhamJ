package plham.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import plham.Market;
import plham.Market.AgentUpdate;
import plham.Order;

public class Itayose implements Serializable {
	private static final long serialVersionUID = -8621943005604743083L;

	/*
	static type AgentUpdate = Market.AgentUpdate;
	*/

    public static boolean remainExecutableOrders(Market market) {
        if (market.getBuyOrderBook().size() == 0) return false;
        if (market.getSellOrderBook().size() == 0) return false;
        Order buy = market.getBuyOrderBook().getBestOrder();
        Order sell = market.getSellOrderBook().getBestOrder();
        return buy.isMarketOrder() || sell.isMarketOrder() || buy.price >= sell.price;
    }

	/*
	public static def itayose(market:Market) {
		val buyUpdates = new ArrayList<Market.AgentUpdate>();
		val sellUpdates = new ArrayList<Market.AgentUpdate>();
		var lastBuyPrice:Double = 0.0;
		var lastSellPrice:Double = 0.0;
		var sumExchangeVolume:Long = 0;
		while (market.getBestBuyPrice() >= market.getBestSellPrice()) {
			val buyOrder = market.buyOrderBook.getBestOrder();
			val sellOrder = market.sellOrderBook.getBestOrder();

			lastBuyPrice = buyOrder.getPrice();
			lastSellPrice = sellOrder.getPrice();
			val exchangeVolume = Math.min(buyOrder.getVolume(), sellOrder.getVolume());
			sumExchangeVolume += exchangeVolume;

			buyOrder.updateVolume(-exchangeVolume);
			sellOrder.updateVolume(-exchangeVolume);

			//val cashAmountDelta = exchangePrice * exchangeVolume;
			val assetVolumeDelta = exchangeVolume;

			val buyUpdate = new AgentUpdate();
			buyUpdate.agentId = buyOrder.agentId;
			buyUpdate.marketId = buyOrder.marketId;
			buyUpdate.orderId = buyOrder.orderId;
			buyUpdate.price = Double.NaN;
			buyUpdate.cashAmountDelta = Double.NaN;         // A buyer pays cash
			buyUpdate.assetVolumeDelta = +assetVolumeDelta; // and gets stocks
			buyUpdates.add(buyUpdate);

			val sellUpdate = new AgentUpdate();
			sellUpdate.agentId = sellOrder.agentId;
			sellUpdate.marketId = sellOrder.marketId;
			sellUpdate.orderId = sellOrder.orderId;
			sellUpdate.price = Double.NaN;
			sellUpdate.cashAmountDelta = Double.NaN;         // A seller gets cash
			sellUpdate.assetVolumeDelta = -assetVolumeDelta; // and gives stocks
			sellUpdates.add(sellUpdate);

			if (buyOrder.getVolume() <= 0) {
				market.buyOrderBook.remove(buyOrder);
			}
			if (sellOrder.getVolume() <= 0) {
				market.sellOrderBook.remove(sellOrder);
			}
		}

		// Or mid price???
		val exchangePrice = (lastBuyPrice + lastSellPrice) / 2.0;
		for (update in buyUpdates) {
			val exchangeVolume = Math.abs(update.assetVolumeDelta);
			val cashAmountDelta = exchangePrice * exchangeVolume;
			update.price = exchangePrice;
			update.cashAmountDelta = -cashAmountDelta; // A buyer pays cash
		}
		for (update in sellUpdates) {
			val exchangeVolume = Math.abs(update.assetVolumeDelta);
			val cashAmountDelta = exchangePrice * exchangeVolume;
			update.price = exchangePrice;
			update.cashAmountDelta = +cashAmountDelta; // A seller gets cash
		}

		val t = market.getTime();
		market.executedOrdersCounts(t) += buyUpdates.size();
		market.lastExecutedPrices(t) = exchangePrice;
		market.sumExecutedVolumes(t) = market.sumExecutedVolumes(t) + sumExchangeVolume;

		Console.OUT.println("# Itayose exchangePrice " + exchangePrice);

		for (update in buyUpdates) {
			market.handleAgentUpdate(update);
		}
		for (update in sellUpdates) {
			market.handleAgentUpdate(update);
		}
	}
	 */
	public static void itayose(Market market) {
		List<AgentUpdate> buyUpdates = new ArrayList<AgentUpdate>();
		List<AgentUpdate> sellUpdates = new ArrayList<AgentUpdate>();
		double lastBuyPrice = 0.0;
		double lastSellPrice = 0.0;
		long sumExchangeVolume = 0;
		while (remainExecutableOrders(market)) {
			Order buyOrder = market.buyOrderBook.getBestOrder();
			Order sellOrder = market.sellOrderBook.getBestOrder();

			lastBuyPrice = buyOrder.getPrice();
			lastSellPrice = sellOrder.getPrice();
			long exchangeVolume = Math.min(buyOrder.getVolume(),
					sellOrder.getVolume());
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
				market.buyOrderBook.remove(buyOrder);
			}
			if (sellOrder.getVolume() <= 0) {
				market.sellOrderBook.remove(sellOrder);
			}
		}

        // If there are only market orders in the buy or sell side, use the counter part price as the exchange price
        if (Double.isNaN(lastBuyPrice)) lastBuyPrice = lastSellPrice;
        if (Double.isNaN(lastSellPrice)) lastSellPrice = lastBuyPrice;
        // If there are only market orders in the both buy and sell side, we cannot determine what price to use. It should be handled as an error.
        assert !(Double.isNaN(lastBuyPrice) && Double.isNaN(lastSellPrice));
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

		long t = market.getTime();

		long t1 = market.executedOrdersCounts.get((int) t);
		market.executedOrdersCounts.set((int) t, t1 + buyUpdates.size());
		market.lastExecutedPrices.set((int) t, exchangePrice);

		long t2 = market.sumExecutedVolumes.get((int) t);
		market.sumExecutedVolumes.set((int) t, t2 + sumExchangeVolume);
		
		for (AgentUpdate update : buyUpdates) {
			market.handleAgentUpdate(update);
		}
		for (AgentUpdate update : sellUpdates) {
			market.handleAgentUpdate(update);
		}
	}
	/*
	public static def main(args:Rail[String]) {

		val random = new RandomHelper(new Random()); // MEMO: main()

		val market = new Market(-1);
		market.setInitialMarketPrice(300.0);
		market.setInitialFundamentalPrice(300.0);
		market.setOutstandingShares(10000);
	//		market.updateTime();
		market.env = new Env();

		val agent = new TestAgent(0);
		agent.setMarketAccessible(market);
		// TODO tkhack
		val agents = new ArrayList[Agent]();
		agents.add(agent);
		market.env.agents = agents;
		
		val rog = new RandomOrderGenerator(
				(p:Double) => Math.max(0.0, p + random.nextGaussian() * 10),
				() => 1,
				() => random.nextLong(100) + 10);

		market.setRunning(false);
		val orders = rog.get(market, () => agent, 100);
		for (order in orders) {
			if (random.nextDouble() < 0.5) {
				order.kind = Order.KIND_BUY_LIMIT_ORDER;
			} else {
				order.kind = Order.KIND_SELL_LIMIT_ORDER;
			}
		}
		market.handleOrders(orders);

		Console.OUT.println("######## SELL SIDE ########");
		market.getSellOrderBook().dump(OrderBook.HIGHERS_FIRST);
		Console.OUT.println("######## BUY  SIDE ########");
		market.getBuyOrderBook().dump(OrderBook.HIGHERS_FIRST);

		itayose(market);
		
		Console.OUT.println("######## SELL SIDE ########");
		market.getSellOrderBook().dump(OrderBook.HIGHERS_FIRST);
		Console.OUT.println("######## BUY  SIDE ########");
		market.getBuyOrderBook().dump(OrderBook.HIGHERS_FIRST);
	}	 */
}
