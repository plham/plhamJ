package plham.core.agent;

import java.util.ArrayList;
import java.util.List;

import plham.core.Agent;
import plham.core.Market;
import plham.core.Order;
import plham.core.util.Random;

public class TestAgent extends Agent {

	private static final long serialVersionUID = 1964050334365818752L;

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

		List<Order> orders = new ArrayList<>();

		for (Market market : markets) {
			if (this.isMarketAccessible(market)) {
				Random random = getRandom();
				long marketTime = market.getTime();
				double price = market.getPrice() + (random.nextDouble() * 2 * MARGIN_SCALE - MARGIN_SCALE);
				long volume = random.nextLong(VOLUME_SCALE) + 1;
				long timeLength = random.nextLong(TIME_LENGTH_SCALE) + 10;
				double p = random.nextDouble();
				if (p < BUY_CHANCE) {
					orders.add(new Order(Order.KIND_BUY_LIMIT_ORDER, id, market.id, price, volume, timeLength,
							marketTime));
				} else if (p < BUY_CHANCE + SELL_CHANCE) {
					orders.add(new Order(Order.KIND_SELL_LIMIT_ORDER, id, market.id, price, volume, timeLength,
							marketTime));
				}
			}
		}
		return orders;
	}
}
