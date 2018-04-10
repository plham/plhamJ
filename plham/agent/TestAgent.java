package plham.agent;

import java.util.ArrayList;
import java.util.List;
import plham.util.Random;

import plham.Agent;
import plham.Market;
import plham.Order;
import plham.util.RandomHelper;

public class TestAgent extends Agent {
	private static final long serialVersionUID = 1964050334365818752L;

	/*
	public def this(id:Long) = super(id, "test-agent", new Random());
	 */
	public TestAgent(long id) {
		super(id, "test-agent", new Random());
	}

	@Override
	public List<Order> submitOrders(List<Market> markets) {
		double MARGIN_SCALE = 10.0;
		long VOLUME_SCALE = 100;
		long TIME_LENGTH_SCALE = 100;
		double BUY_CHANCE = 0.4;
		double SELL_CHANCE = 0.4;

		List<Order> orders = new ArrayList<Order>();

		for (Market market : markets) {
			if (this.isMarketAccessible(market)) {
				long marketTime = market.getTime();
				double price = market.getPrice()
						+ (random.nextDouble() * 2 * MARGIN_SCALE - MARGIN_SCALE);
				RandomHelper helper = new RandomHelper(random);
				long volume = helper.nextLong(VOLUME_SCALE) + 1;
				long timeLength = helper.nextLong(TIME_LENGTH_SCALE) + 10;
				double p = random.nextDouble();
				if (p < BUY_CHANCE) {
					orders.add(new Order(Order.KIND_BUY_LIMIT_ORDER, this.id,
							market.id, price, volume, timeLength, marketTime));
				} else if (p < BUY_CHANCE + SELL_CHANCE) {
					orders.add(new Order(Order.KIND_SELL_LIMIT_ORDER, this.id,
							market.id, price, volume, timeLength, marketTime));
				}
			}
		}
		return orders;
	}
}
