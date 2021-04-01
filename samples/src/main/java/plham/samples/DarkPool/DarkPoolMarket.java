package plham.samples.DarkPool;

import java.util.List;

import cassia.util.JSON;
import cassia.util.JSON.Value;
import plham.core.Market;
import plham.core.Order;
import plham.core.main.SimulatorFactory;
import plham.core.model.MarketInitializer;
import plham.core.util.Random;

public class DarkPoolMarket extends Market {
	private static final long serialVersionUID = 5830290220586815964L;

	public static void register(SimulatorFactory sim) {
		String className = "DarkPoolMarket";
		sim.addMarketInitializer(className, new MarketInitializer() {
			@Override
			public Market initialize(long id, String name, Random random, Value json) {
				return new DarkPoolMarket(id, name, random).setup(json, sim);
			}
		});
	}

	public long litMarketId;

	public DarkPoolMarket(long id, String name, Random random) {
		super(id, name, random);
	}

	@Override
	protected void executeBuyOrders(Order buyOrder, Order sellOrder) {
		assert buyOrder.getPrice() == Order.NO_PRICE : "The price must be Order.NO_PRICE"; // Check
																							// it
																							// now
																							// (easy
																							// impl)
		assert sellOrder.getPrice() == Order.NO_PRICE : "The price must be Order.NO_PRICE";
		executeOrders(roundSellPrice(getLitMidPrice()), buyOrder, sellOrder, true); // Always use the mid price.
	}

	@Override
	protected void executeSellOrders(Order sellOrder, Order buyOrder) {
		assert buyOrder.getPrice() == Order.NO_PRICE : "The price must be Order.NO_PRICE"; // Check
																							// it
																							// now
																							// (easy
																							// impl)
		assert sellOrder.getPrice() == Order.NO_PRICE : "The price must be Order.NO_PRICE";
		executeOrders(roundBuyPrice(getLitMidPrice()), buyOrder, sellOrder, false); // Always use the mid price.
	}

	public Market getLitMarket() {
		return env.markets.get((int) litMarketId);
	}

	public double getLitMidPrice() {
		Market lit = getLitMarket();
		double litPrice = lit.getMidPrice();
		if (Double.valueOf(litPrice).isNaN()) { // If the lit's orderbooks are
												// empty.
			litPrice = getLitMarket().getPrice();
		}
		return litPrice;
	}

	@Override
	public void handleOrder(Order order) {
		if (isRunning()) { // Accept only if market is open.
			super.handleOrder(order);
		}
	}

	@Override
	public void handleOrders(List<Order> orders) {
		if (isRunning()) { // Accept only if market is open.
			super.handleOrders(orders);
		}
	}

	public void setLitMarket(Market market) {
		litMarketId = market.id;
	}

	@Override
	public DarkPoolMarket setup(JSON.Value json, SimulatorFactory sim) {
		assert json.get("markets").size() == 1;
		super.setup(json, sim);
		Market lit = sim.getSimulatorInConstruction().getMarketByName(json.get("markets").asList().get(0));
		setLitMarket(lit);
		return this;
	}
}
