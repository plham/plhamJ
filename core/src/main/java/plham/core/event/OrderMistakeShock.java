package plham.core.event;

import cassia.util.JSON;
import plham.core.Agent;
import plham.core.Event;
import plham.core.Market;
import plham.core.Market.MarketEvent;
import plham.core.Order;
import plham.core.main.Simulator;
import plham.core.main.SimulatorFactory;
import plham.core.model.EventInitializer;
import plham.core.util.Random;

/**
 * This suddenly changes the market price as a consequence of a fat finger
 * error, e.g., caused by an huge amount of orders at an extremely cheap or
 * expensive price.
 */

public class OrderMistakeShock implements MarketEvent {
	private static final long serialVersionUID = 3343618253022836528L;

	public static void register(SimulatorFactory sim) {
		String className = "OrderMistakeShock";
		sim.addEventInitializer(className, new EventInitializer() {
			private static final long serialVersionUID = -7531902801400285258L;

			@Override
			public Event initialize(long id, Random random, String name, JSON.Value json) {
				return new OrderMistakeShock(id, name, random).setup(json, sim);
			}
		});
	}

	public long agentId;
	public long id;
	public long marketId;
	public String name;
	public long orderTimeLength;
	public long orderVolume;
	public double priceChangeRate;
	public Random random;

	public long triggerTime;

	public OrderMistakeShock(long id, String name, Random random) {
		this.id = id;
		this.name = name;
		this.random = random;
	}

	@Override
	public OrderMistakeShock setup(JSON.Value json, SimulatorFactory sim) {
		Simulator s = sim.getSimulatorInConstruction();
		Market market = s.getMarketByName(json.get("target"));
//		Agent agent = s.getAgentsByName("agents").get(0); // Use the first
//															// one.
		Agent agent = s.agents.get(0); // Directly get the first agent instead of calling getAgentsByName
		
		long t = market.getTime();
		marketId = market.id;
		agentId = agent.id;
		triggerTime = t + json.get("triggerTime").toLong();
		priceChangeRate = json.get("priceChangeRate").toDouble();
		orderVolume = json.get("orderVolume").toLong();
		orderTimeLength = json.get("orderTimeLength").toLong();
		market.addBeforeSimulationStepEvent(this);
		return this;
	}

	@Override
	public void update(Market market) {
		assert market.id == marketId;
		Simulator env = market.env;
		long t = market.getTime();
		if (t == triggerTime) {
			Agent agent = env.agents.get((int) agentId);
			double basePrice = market.getPrice();
			double orderPrice = basePrice * (1 + priceChangeRate);
			long timeLength = orderTimeLength;
			Order order;
			if (priceChangeRate <= 0.0) {
				// Hit sell orders to the buy side.
				order = new Order(Order.KIND_SELL_LIMIT_ORDER, agent, market, orderPrice, orderVolume, timeLength);
			} else {
				// Hit buy orders to the sell side.
				order = new Order(Order.KIND_BUY_LIMIT_ORDER, agent, market, orderPrice, orderVolume, timeLength);
			}
			market.handleOrder(order);
		}
	}

    @Override
    public String getName() {
        return name;
    }
}
