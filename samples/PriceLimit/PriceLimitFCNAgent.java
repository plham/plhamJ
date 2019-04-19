package samples.PriceLimit;

import java.util.List;

import cassia.util.JSON;
import cassia.util.JSON.Value;
import plham.Agent;
import plham.Market;
import plham.Order;
import plham.agent.FCNAgent;
import plham.event.PriceLimitRule;
import plham.main.Simulator;
import plham.model.AgentInitializer;
import plham.util.Random;

public class PriceLimitFCNAgent extends FCNAgent {
	private static final long serialVersionUID = -422099265741636519L;

	/*
	public var priceLimit:PriceLimitRule;
	*/
	public PriceLimitRule priceLimit;

	/*
	public def submitOrders(market:Market):List[Order] {
		val orders = super.submitOrders(market);
		if (orders.size() == 0) {
			return orders;
		}

		for (order in orders) {
			val oldPrice = order.getPrice();
			val newPrice = priceLimit.getLimitedPrice(order, market);
			if (newPrice != oldPrice) {
				order.setPrice(newPrice); // Adjust the price.
				// You may need replanning.
			}
		}
		return orders;
	}
	*/
	@Override
	public List<Order> submitOrders(Market market) {
		List<Order> orders = super.submitOrders(market);
		if (orders.size() == 0) {
			return orders;
		}

		for (Order order : orders) {
			double oldPrice = order.getPrice();
			double newPrice = priceLimit.getLimitedPrice(order, market);
			if (newPrice != oldPrice) {
				order.setPrice(newPrice); // Adjust the price.
				// You may need replanning.
			}
		}
		return orders;
	}

	/*
	public static def register(sim:Simulator):void {
		val className = "PriceLimitFCNAgent";
		sim.addAgentInitializer(className,
			(
				id:Long,
				name:String, 
				random:Random,
				json:JSON.Value
			) => {
				return new PriceLimitFCNAgent(id, name, random).setup(json, sim);
			}
		);
	}
	*/
	public static void register(Simulator sim) {
		String className = "PriceLimitFCNAgent";
		sim.addAgentInitializer(className, new AgentInitializer() {
			public Agent initialize(long id, String name, Random random,
					Value json) {
				return new PriceLimitFCNAgent(id, name, random)
						.setup(json, sim);
			}
		});
	}

	/*
	public def this(id:Long, name:String, random:Random) = super(id, name, random);
	*/
	public PriceLimitFCNAgent(long id, String name, Random random) {
		super(id, name, random);
	}

	/*
	public def setup(json:JSON.Value, sim:Simulator):PriceLimitFCNAgent {
		super.setup(json, sim);
		this.priceLimit = new PriceLimitMain().createEvents(sim.CONFIG(json("priceLimit")))(0) as PriceLimitRule;
		return this;
	}
	 */
	@Override
	public PriceLimitFCNAgent setup(JSON.Value json, Simulator sim) {
		super.setup(json, sim);
		this.priceLimit = (PriceLimitRule) new PriceLimitMain().createEvents(
				sim.CONFIG.get(json.get("priceLimit"))).get(0);
		return this;
	}
}
