package plham.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import cassia.util.JSON;
import handist.collections.ChunkedList;
import handist.collections.LongRange;
import plham.core.main.Simulator;
import plham.core.main.SimulatorFactory;
import plham.core.model.ComparatorHighersFirst;
import plham.core.model.ComparatorLowersFirst;
import plham.core.model.MarketsInitializer;
import plham.core.util.Itayose;
import plham.core.util.JSONRandom;
import plham.core.util.Random;

/**
 * The base class for markets. A continuous double auction mechanism is implemented.
 *
 * <p>
 * <ul>
 * <li>Override <code>handleOrders(List[Order])</code> and <code>handleOrder(Order)</code> to implement a matching
 * mechanism.
 * <li>The price of every order will be rounded in increments of a tick size (in <code>handleOrder(Order)</code>).
 * <li>Market orders never be added onto the orderbooks (in the current implementation).
 * <li>Do not call <code>handleOrders(List[Order])</code> family in <code>Agent#submitOrders(List[Market])</code>.
 * <li>Do not access to the fields as much as possible; Use the corresponding methods if exist.
 * </ul>
 *
 * <p>
 * On events, it currently supports four places to register.
 * <p>
 * <ul>
 * <li>beforeSimulationStep: Called once before a simulation step (once each step)
 * <li>afterSimulationStep: Called once after a simulation step (once each step)
 * <li>beforeOrderHandling: Called every before handling an order (once per order)
 * <li>afterOrderHandling: Called every after handling an order (once per order)
 * </ul>
 */
public class Market implements Serializable {
    /**
     * Class used to carry update information to the Agents that were involved in a trade
     */
    public static class AgentUpdate {
        public long agentId;
        public long assetVolumeDelta;
        public double cashAmountDelta;
        public long marketId;
        public long orderId;
        public double price;

        public boolean isBuySide() {
            return assetVolumeDelta > 0;
        }

        public boolean isSellSide() {
            return assetVolumeDelta < 0;
        }
    }

    public static class ExecutionLog {
        public long buyAgentId;
        public double exchangePrice;
        public long exchangeVolume;
        public boolean isSellMajor;
        public long sellAgentId;
        public long time;
    }

    public interface MarketEvent extends Event {

        /**
         * Method which performs the modification on the state of the simulation
         * 
         * @param market the market on which this event may act on
         */
        public abstract void update(Market market);

    }

    public interface OrderEvent extends Event {

        /**
         * Method which performs the modification on the state of the simulation
         * 
         * @param market the market on which this event can act
         * @param order  the order on which this event can act
         */
        public abstract void update(Market market, Order order);

    }

    private static final long serialVersionUID = -5679918172876739712L;

    public static Market create(long id, String name, Random random) {
        return new Market(id, name, random);
    }

    public static void register(SimulatorFactory sim) {
        String className = "Market";
        MarketsInitializer initializers = new MarketsInitializer() {
            private static final long serialVersionUID = 2739579036719738032L;

            @Override
            public List<Market> initialize(long id, String name, Random random, JSON.Value json) {
                long numMarkets = json.has("numMarkets") ? json.get("numMarkets").toLong() : 1;
                List<Market> markets = new ArrayList<>((int) numMarkets);
                Market market = Market.create(id, name, random).setup(json);
                markets.add(market);

                Simulator s = sim.getSimulatorInConstruction();
//				s.GLOBAL.put(markets.get(0).name, markets);
                List<LongRange> r = new ArrayList<>();
                r.add(new LongRange(id, id + 1));
                s.marketName2Ranges.put(name, r);
                return markets;
            }

        };
        sim.marketInitializers.put(className, initializers);
    }

    public static double roundLower(double price, double tickSize) {
        return (Math.floor(price / tickSize)) * tickSize;
    }

    public static double roundUpper(double price, double tickSize) {
        return (Math.ceil(price / tickSize)) * tickSize;
    }

    public boolean _isRunning;
    public List<OrderEvent> afterOrderHandlingEvents = new ArrayList<>();
    public List<MarketEvent> afterSimulationStepEvents = new ArrayList<>();

    public transient List<List<AgentUpdate>> agentUpdates = new ArrayList<>();
    public List<OrderEvent> beforeOrderHandlingEvents = new ArrayList<>();
    public List<MarketEvent> beforeSimulationStepEvents = new ArrayList<>();

    public OrderBook buyOrderBook;
    public transient List<Long> buyOrdersCounts;
    public transient Simulator env;
    public transient List<Long> executedOrdersCounts;
    public transient List<List<ExecutionLog>> executionLogs = new ArrayList<>();

    public List<Double> fundamentalPrices;

    public double fundamentalVolatility;

    public long id;

    // // Historical data (hidden) ////
    public transient List<Double> lastExecutedPrices;

    // // Historical data (public) ////
    public List<Double> marketPrices;

    public String name;

    public double NO_TICKSIZE = -1.0;

    public long outstandingShares;

    private Random random;

    public OrderBook sellOrderBook;

    public transient List<Long> sellOrdersCounts;

    public transient List<Long> sumExecutedVolumes;

    public double tickSize;

    public Time time;

    public Market(long id, String name, Random random) {
        this.id = id;
        this.name = name;
        this.random = random;
        _isRunning = true;
        buyOrderBook = new OrderBook(new ComparatorHighersFirst());
        sellOrderBook = new OrderBook(new ComparatorLowersFirst());
        outstandingShares = 1;

        time = new Time(0);
        buyOrderBook.setTime(time); // Share the clock.
        sellOrderBook.setTime(time); // Share the clock.
        tickSize = NO_TICKSIZE;

        marketPrices = new ArrayList<>();
        fundamentalPrices = new ArrayList<>();

        lastExecutedPrices = new ArrayList<>();
        sumExecutedVolumes = new ArrayList<>();
        buyOrdersCounts = new ArrayList<>();
        sellOrdersCounts = new ArrayList<>();
        executedOrdersCounts = new ArrayList<>();
        fundamentalVolatility = 0.0;
    }

    public void addAfterOrderHandlingEvent(OrderEvent e) {
        afterOrderHandlingEvents.add(e);
    }

    public void addAfterSimulationStepEvent(MarketEvent e) {
        afterSimulationStepEvents.add(e);
    }

    public void addBeforeOrderHandlingEvent(OrderEvent e) {
        beforeOrderHandlingEvents.add(e);
    }

    public void addBeforeSimulationStepEvent(MarketEvent e) {
        beforeSimulationStepEvents.add(e);
    }

    protected void cancelBuyOrder(Order order) {
        assert order.isBuyOrder();
        buyOrderBook.cancel(order);
    }

    protected void cancelSellOrder(Order order) {
        assert order.isSellOrder();
        sellOrderBook.cancel(order);
    }

    public void check() {
        long t = getTime();
        assert marketPrices.size() - 1 == t;
        assert fundamentalPrices.size() - 1 == t;
        assert lastExecutedPrices.size() - 1 == t;
        assert sumExecutedVolumes.size() - 1 == t;
        assert buyOrdersCounts.size() - 1 == t;
        assert sellOrdersCounts.size() - 1 == t;
        assert executedOrdersCounts.size() - 1 == t;
        assert executionLogs.size() - 1 == t;
        assert agentUpdates.size() - 1 == t;
        System.out.println("#MARKET CHECK PASSED");
    }

    public void executeAgentUpdate(ChunkedList<Agent> agents, AgentUpdate update) {
        long id = update.agentId;
        Agent agent = agents.get((int) id);
        if (agent != null) {
            agent.executeUpdate(update);
        }
    }

    protected void executeBuyOrders(Order buyOrder, Order sellOrder) {
        executeOrders(sellOrder.getPrice(), buyOrder, sellOrder, true);
    }

    protected void executeOrders(double price, Order buyOrder, Order sellOrder, boolean isSellMajor) {
        assert buyOrder.marketId == id;
        assert sellOrder.marketId == id;

        double exchangePrice = price;
        long exchangeVolume = Math.min(buyOrder.getVolume(), sellOrder.getVolume());
        assert exchangePrice >= 0.0;
        assert exchangeVolume >= 0;

        double cashAmountDelta = exchangePrice * exchangeVolume;
        long assetVolumeDelta = exchangeVolume;

        long t = getTime();

        AgentUpdate buyUpdate = new AgentUpdate();
        buyUpdate.agentId = buyOrder.agentId;
        buyUpdate.marketId = buyOrder.marketId;
        buyUpdate.orderId = buyOrder.orderId;
        buyUpdate.price = exchangePrice;
        buyUpdate.cashAmountDelta = -cashAmountDelta; // A buyer pays cash
        buyUpdate.assetVolumeDelta = +assetVolumeDelta; // and gets stocks
        handleAgentUpdate(buyUpdate);

        AgentUpdate sellUpdate = new AgentUpdate();
        sellUpdate.agentId = sellOrder.agentId;
        sellUpdate.marketId = sellOrder.marketId;
        sellUpdate.orderId = sellOrder.orderId;
        sellUpdate.price = exchangePrice;
        sellUpdate.cashAmountDelta = +cashAmountDelta; // A seller gets cash
        sellUpdate.assetVolumeDelta = -assetVolumeDelta; // and gives stocks
        handleAgentUpdate(sellUpdate);

        boolean EXECUTION_LOG = false;
        if (EXECUTION_LOG) {
            ExecutionLog log = new ExecutionLog();
            log.isSellMajor = isSellMajor;
            log.time = t;
            log.buyAgentId = buyOrder.agentId;
            log.sellAgentId = sellOrder.agentId;
            log.exchangePrice = exchangePrice;
            log.exchangeVolume = exchangeVolume;
            executionLogs.get((int) t).add(log);
        }

        buyOrder.updateVolume(-exchangeVolume);
        sellOrder.updateVolume(-exchangeVolume);

        executedOrdersCounts.set((int) t, executedOrdersCounts.get((int) t) + 1);
        lastExecutedPrices.set((int) t, exchangePrice);
        sumExecutedVolumes.set((int) t, sumExecutedVolumes.get((int) t) + exchangeVolume);

        boolean DEBUG = false;
        if (DEBUG) {
            // do nothing
        }
    }

    protected void executeSellOrders(Order sellOrder, Order buyOrder) {
        executeOrders(buyOrder.getPrice(), buyOrder, sellOrder, false);
    }

    public double getBestBuyPrice() {
        return buyOrderBook.getBestPrice();
    }

    public double getBestSellPrice() {
        return sellOrderBook.getBestPrice();
    }

    public OrderBook getBuyOrderBook() {
        return buyOrderBook;
    }

    public double getFundamentalPrice() {
        return fundamentalPrices.get((int) getTime());
    }

    public double getFundamentalPrice(long t) {
        return fundamentalPrices.get((int) t);
    }

    public final double getFundamentalVolatility() {
        return fundamentalVolatility;
    }

    public final double getInitialFundamentalPrice() {
        if (fundamentalPrices.size() == 0) {
            throw new NoSuchElementException();
        }
        return fundamentalPrices.get(0);
    }

    public final double getInitialMarketPrice() {
        if (marketPrices.size() == 0)
            throw new NoSuchElementException();
        return marketPrices.get(0);
    }

    public double getLastFundamentalPrice() {
        return fundamentalPrices.get(fundamentalPrices.size() - 1);
    }

    public double getLastMarketPrice() {
        return marketPrices.get(marketPrices.size() - 1);
    }

    public double getMarketPrice() {
        return marketPrices.get((int) getTime());
    }

    public double getMarketPrice(long t) {
        return marketPrices.get((int) t);
    }

    public double getMidPrice() {
        return (getBestBuyPrice() + getBestSellPrice()) / 2.0;
    }

    public double getNextFundamentalPrice() {
        assert getTime() == fundamentalPrices.size() - 1;
        return fundamentalPrices.get(fundamentalPrices.size() - 1);
    }

    public double getNextMarketPrice() {
        double lastPrice = marketPrices.get(marketPrices.size() - 1);
        double price = lastPrice;
        if (isRunning()) {
            if (executedOrdersCounts.get(executedOrdersCounts.size() - 1) > 0) {
                price = lastExecutedPrices.get(lastExecutedPrices.size() - 1);
            } else if (buyOrderBook.size() > 0 && sellOrderBook.size() > 0) {
                price = getMidPrice();
            }
        }
        return price;
    }

    public long getOutstandingShares() {
        return outstandingShares;
    }

    public double getPrice() {
        return this.getMarketPrice();
    }

    public double getPrice(long t) {
        return this.getMarketPrice(t);
    }

    public Random getRandom() {
        return random;
    }

    public OrderBook getSellOrderBook() {
        return sellOrderBook;
    }

    public double getTickSize() {
        return tickSize;
    }

    public long getTime() {
        return time.t;
    }

    public long getTradeVolume() {
        return getTradeVolume(getTime());
    }

    public long getTradeVolume(long t) {
        return sumExecutedVolumes.get((int) t);
    }

    public void handleAgentUpdate(AgentUpdate update) {
        long t = getTime();
        try {
            executeAgentUpdate(env.agents, update); // Process
        } catch (IndexOutOfBoundsException e) {
            agentUpdates.get((int) t).add(update); // Keep
        }
    }

    protected void handleBuyLimitOrder(Order buyOrder) {
        assert buyOrder.isBuyOrder() && buyOrder.isLimitOrder();
        // long t = this.getTime();
        if (isRunning()) {
            while (buyOrder.getVolume() > 0) {
                if (sellOrderBook.size() == 0) {
                    break;
                }
                Order sellOrder = sellOrderBook.getBestOrder();
                if (buyOrder.getPrice() >= sellOrder.getPrice()) {
                    executeBuyOrders(buyOrder, sellOrder);
                } else {
                    break;
                }
                if (sellOrder.getVolume() <= 0) {
                    sellOrderBook.remove(sellOrder);
                }
            }
        }
        if (buyOrder.getVolume() > 0) {
            buyOrderBook.add(buyOrder);
        }
    }

    protected void handleBuyMarketOrder(Order buyOrder) {
        assert buyOrder.isBuyOrder() && buyOrder.isMarketOrder();
        // long t = this.getTime();
        if (isRunning()) {
            while (buyOrder.getVolume() > 0) {
                if (sellOrderBook.size() == 0) {
                    break;
                }
                Order sellOrder = sellOrderBook.getBestOrder();
                executeBuyOrders(buyOrder, sellOrder);
                if (sellOrder.getVolume() <= 0) {
                    sellOrderBook.remove(sellOrder);
                }
            }
        }
        if (buyOrder.getVolume() > 0) {
            buyOrderBook.add(buyOrder);
        }
    }

    protected void handleBuyOrder(Order order) {
        assert order.isBuyOrder();
        if (order.isLimitOrder()) {
            handleBuyLimitOrder(order);
        }
        if (order.isMarketOrder()) {
            handleBuyMarketOrder(order);
        }
    }

    public void handleOrder(Order order) {
        assert order.marketId == id;
        long t = getTime();
        if (order.getPrice() < 0.0) {
            return;
        }
        if (order.getVolume() <= 0) {
            return;
        }

        roundPrice(order); // Do in the agent's place

        if (order.isCancel()) {
            if (order.isBuyOrder()) {
                cancelBuyOrder(order);
            }
            if (order.isSellOrder()) {
                cancelSellOrder(order);
            }
            return;
        }
        if (order.isBuyOrder()) {
            handleBuyOrder(order);
            buyOrdersCounts.set((int) t, buyOrdersCounts.get((int) t) + 1);
        }
        if (order.isSellOrder()) {
            handleSellOrder(order);
            sellOrdersCounts.set((int) t, sellOrdersCounts.get((int) t) + 1);
        }
    }

    public void handleOrders(List<Order> orders) {
        for (Order order : orders) {
            if (order.marketId == id) {
                handleOrder(order);
            }
        }
    }

    protected void handleSellLimitOrder(Order sellOrder) {
        assert sellOrder.isSellOrder() && sellOrder.isLimitOrder();
        // long t = this.getTime();
        if (isRunning()) {
            while (sellOrder.getVolume() > 0) {
                if (buyOrderBook.size() == 0) {
                    break;
                }
                Order buyOrder = buyOrderBook.getBestOrder();
                if (buyOrder.getPrice() >= sellOrder.getPrice()) {
                    executeSellOrders(sellOrder, buyOrder);
                } else {
                    break;
                }
                if (buyOrder.getVolume() <= 0) {
                    buyOrderBook.remove(buyOrder);
                }
            }
        }
        if (sellOrder.getVolume() > 0) {
            sellOrderBook.add(sellOrder);
        }
    }

    protected void handleSellMarketOrder(Order sellOrder) {
        assert sellOrder.isSellOrder() && sellOrder.isMarketOrder();
        // long t = this.getTime();
        if (isRunning()) {
            while (sellOrder.getVolume() > 0) {
                if (buyOrderBook.size() == 0) {
                    break;
                }
                Order buyOrder = buyOrderBook.getBestOrder();
                executeSellOrders(sellOrder, buyOrder);
                if (buyOrder.getVolume() <= 0) {
                    buyOrderBook.remove(buyOrder);
                }
            }
        }
        if (sellOrder.getVolume() > 0) {
            sellOrderBook.add(sellOrder);
        }
    }

    protected void handleSellOrder(Order order) {
        assert order.isSellOrder();
        if (order.isLimitOrder()) {
            handleSellLimitOrder(order);
        }
        if (order.isMarketOrder()) {
            handleSellMarketOrder(order);
        }
    }

    public boolean isRunning() {
        return _isRunning;
    }

    public void itayoseOrderBooks() {
        Itayose.itayose(this);
        updateOrderBooks();
    }

    public double roundBuyPrice(double price) {
        return roundLower(price, tickSize);
    }

    public Order roundPrice(Order order) {
        if (tickSize <= 0.0) {
            return order;
        }
        if (order.getPrice() == Order.NO_PRICE) {
            return order;
        }
        if (order.isBuyOrder()) {
            order.setPrice(roundBuyPrice(order.getPrice()));
        }
        if (order.isSellOrder()) {
            order.setPrice(roundSellPrice(order.getPrice()));
        }
        return order;
    }

    public double roundSellPrice(double price) {
        return roundUpper(price, tickSize);
    }

    public final void setFundamentalVolatility(double v) {
        fundamentalVolatility = v;
    }

    public final void setInitialFundamentalPrice(double price) {
        fundamentalPrices.set(0, price);
    }

    public final void setInitialMarketPrice(double price) {
        assert marketPrices.size() == 0;
        marketPrices.add(price); // t = 0
        fundamentalPrices.add(price); // t = 0
        // FIXME: The below should not come here.
        buyOrdersCounts.add(0L);
        sellOrdersCounts.add(0L);
        executedOrdersCounts.add(0L);
        lastExecutedPrices.add(Double.NaN);
        sumExecutedVolumes.add(0L);
        executionLogs.add(new ArrayList<ExecutionLog>());
        agentUpdates.add(new ArrayList<AgentUpdate>());
    }

    public void setOutstandingShares(long outstandingShares) {
        this.outstandingShares = outstandingShares;
    }

    public void setRunning(boolean isRunning) {
        _isRunning = isRunning;
    }

    public final void setTickSize(double tickSize) {
        this.tickSize = tickSize;
    }

    public void setTime(long time) {
        this.time.t = time;
    }

    public void setTradeVolume(long t, long tradeVolume) {
        sumExecutedVolumes.set((int) t, tradeVolume);
    }

    private Market setup(JSON.Value json) {
        JSONRandom jsonRandom = new JSONRandom(getRandom());
        if (json.get("tickSize") == null) { // " tick-size <= 0.0 means no
                                            // tick size.
            setTickSize(-1.0);
        } else {
            setTickSize(jsonRandom.nextRandom(json.get("tickSize")));
        }
        setInitialMarketPrice(jsonRandom.nextRandom(json.get("marketPrice")));
        setInitialFundamentalPrice(jsonRandom.nextRandom(json.get("marketPrice")));
        setFundamentalVolatility(jsonRandom.nextRandom(json.getOrElse("fundamentalVolatility", "0.0")));
        setOutstandingShares(Double.valueOf(jsonRandom.nextRandom(json.get("outstandingShares"))).longValue());
        return this;
    }

    public Market setup(JSON.Value json, SimulatorFactory sim) {
        return setup(json);
    }

    @Override
    public String toString() {
        return "[Market"+ id + ", seed" + random + ", time: " + time.t + ", marketPrice" + getPrice();
    }

    public void tickUpdateMarketPrice() {
        long t = getTime();
        double price = getNextMarketPrice();
        marketPrices.set((int) t, price);
    }

    public void triggerAfterOrderHandlingEvents(Order order) {
        for (OrderEvent e : afterOrderHandlingEvents) {
            e.update(this, order);
        }
    }

    public void triggerAfterSimulationStepEvents() {
        for (MarketEvent e : afterSimulationStepEvents) {
            e.update(this);
        }
    }

    public void triggerBeforeOrderHandlingEvents(Order order) {
        for (OrderEvent e : beforeOrderHandlingEvents) {
            e.update(this, order);
        }
    }

    public void triggerBeforeSimulationStepEvents() {
        for (MarketEvent e : beforeSimulationStepEvents) {
            e.update(this);
        }
    }

    public void updateFundamentalPrice(Double price) {
        assert !price.isNaN() : "!price.isNaN()";
        assert price >= 0.0 : "price >= 0.0";
        fundamentalPrices.add(price);
    }

    public void updateMarketPrice() {
        double price = getNextMarketPrice();
        this.updateMarketPrice(price);
    }

    public void updateMarketPrice(Double price) {
        assert !price.isNaN() : "!price.isNaN()";
        assert price >= 0.0 : "price >= 0.0";
        marketPrices.add(price);
        // FIXME: The below should not come here.
        buyOrdersCounts.add(0L);
        sellOrdersCounts.add(0L);
        executedOrdersCounts.add(0L);
        lastExecutedPrices.add(Double.NaN);
        sumExecutedVolumes.add(0L);
        executionLogs.add(new ArrayList<ExecutionLog>());
        agentUpdates.add(new ArrayList<AgentUpdate>());
    }

    public void updateOrderBooks() {
        final Market m = this;
        Predicate<Order> condition = (order) -> {
            return order.isExpired(m) || order.getVolume() <= 0;
        };
        buyOrderBook.removeAllWhere(condition);
        sellOrderBook.removeAllWhere(condition);
    }

    public void updateTime() {
        time.t++; // Call this explicitly!
    }

}
