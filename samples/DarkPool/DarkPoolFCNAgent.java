package samples.DarkPool;

import java.util.ArrayList;
import java.util.List;

import cassia.util.JSON;
import cassia.util.JSON.Value;
import plham.Agent;
import plham.Market;
import plham.Order;
import plham.agent.FCNAgent;
import plham.main.Simulator;
import plham.model.AgentInitializer;
import plham.util.JSONRandom;
import plham.util.Random;
import plham.util.RandomHelper;

public class DarkPoolFCNAgent extends FCNAgent {

	private static final long serialVersionUID = -522177499921561753L;

	/*
	public def this(id:Long, name:String, random:Random) = super(id, name, random);
	*/
	public DarkPoolFCNAgent(long id, String name, Random random) {
		super(id, name, random);
	}

	/*
	public def setup(json:JSON.Value, sim:Simulator):DarkPoolFCNAgent {
		super.setup(json, sim);
		this.darkPoolChance = new JSONRandom(this.getRandom()).nextRandom(json("darkPoolChance"));
		return this;
	}
	*/
	@Override
	public DarkPoolFCNAgent setup(JSON.Value json, Simulator sim) {
		super.setup(json, sim);
		this.darkPoolChance = new JSONRandom(this.getRandom()).nextRandom(json
				.get("darkPoolChance"));
		return this;
	}

	/*
	public static def register(sim:Simulator) {
		val className = "DarkPoolFCNAgent";
		sim.addAgentInitializer(className,
			(
				id:Long,
				name:String, 
				random:Random,
				json:JSON.Value
			) => {
				return new DarkPoolFCNAgent(id, name, random).setup(json, sim);
			}
		);
	}
	*/
	public static void register(Simulator sim) {
		String className = "DarkPoolFCNAgent";
		sim.addAgentInitializer(className, new AgentInitializer() {
			public Agent initialize(long id, String name, Random random,
					Value json) {
				return new DarkPoolFCNAgent(id, name, random).setup(json,
						sim);
			}
		});

	}

	/*
	public var darkPoolChance:Double;
	*/
	public double darkPoolChance;

	/*
	public def submitOrders(market:Market):List[Order] {
		val orders = new ArrayList[Order]();
		if (!this.isMarketAccessible(market)) {
			return orders;
		}
		if (!(market instanceof DarkPoolMarket)) {
			return orders;
		}

		val random = new RandomHelper(getRandom());

		val dark = market as DarkPoolMarket;
		val lit = dark.getLitMarket();

		orders.addAll(super.submitOrders(lit));
		for (order in orders) {
			if (!isFinite(dark.getMidPrice()) && random.nextBoolean(darkPoolChance)) {
				order.marketId = dark.id; // Change it from Lit to DarkPool
				order.setPrice(Order.NO_PRICE);
			}
		}
		return orders;
	}
	 */
	@Override
	@SuppressWarnings("hiding")
	public List<Order> submitOrders(Market market) {
		List<Order> orders = new ArrayList<Order>();
		if (!this.isMarketAccessible(market)) {
			return orders;
		}
		if (!(market instanceof DarkPoolMarket)) {
			return orders;
		}

		RandomHelper random = new RandomHelper(getRandom());
		DarkPoolMarket dark = (DarkPoolMarket) market;
		Market lit = dark.getLitMarket();

		orders.addAll(super.submitOrders(lit));

		for (Order order : orders) {
			if (!isFinite(dark.getMidPrice())
					&& random.nextBoolean(darkPoolChance)) {
				order.marketId = dark.id; // Change it from Lit to DarkPool
				order.setPrice(Order.NO_PRICE);
			}
		}
		return orders;
	}

}
