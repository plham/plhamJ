package plham.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import plham.util.Random;
import cassia.util.random.RandomPermutation;
import plham.Agent;
import plham.Env;
import plham.Market;
import plham.Order;

/**
 * A Runner class for sequential execution.
 */
@SuppressWarnings("unused")
public class SequentialRunner<T> extends Runner<T> implements Serializable {
	private static final long serialVersionUID = -4747415797682000153L;

	/*
	public def this(sim:B) {
		super(sim);
	}
	 */
	@SuppressWarnings("hiding")
	public <T> SequentialRunner(Simulator sim) {
		<T> super(sim);
	}

	/*
	public def updateMarkets(maxNormalOrders:Long, maxHifreqOrders:Long, diffPass:Boolean) { 
		val orders = collectOrders(maxNormalOrders);
		handleOrders(orders, maxHifreqOrders);
	}
	 */
	@Override
	public List<List<Order>> updateMarkets(long maxNormalOrders,
			long maxHifreqOrders, boolean diffPass) {
		List<List<Order>> orders = collectOrders(maxNormalOrders);
		return handleOrders(orders, maxHifreqOrders);
	}

	/*
	public def collectOrders(MAX_NORMAL_ORDERS:Long):List[List[Order]] {
		val env = this.env();
		val markets = env.markets;
		val agents = env.normalAgents;
		
		val beginTime = System.nanoTime();
		val allOrders = new ArrayList[List[Order]]();

		val random = sim.getRandom();
		val randomAgents = new RandomPermutation[Agent](random, agents);

		var k:Long = 0;
		randomAgents.shuffle();
		for (agent in randomAgents) {
			if (k >= MAX_NORMAL_ORDERS) {
				break;
			}
			val orders = agent.submitOrders(markets);
			if (orders.size() > 0) {
				allOrders.add(orders);
				k++;
			}
		}
		val endTime = System.nanoTime();
		if (_PROFILE) {
			Console.OUT.println("#PROFILE ORDER-MAKE TOTAL " + ((endTime - beginTime) / 1e+9) + " sec");
			Console.OUT.println("#PROFILE MAX-NORMAL-ORDERS " + MAX_NORMAL_ORDERS);
			Console.OUT.println("#PROFILE NUM-NORMAL-ORDERS " + allOrders.size());
		}
		return allOrders;
	}
	 */
	public List<List<Order>> collectOrders(long MAX_NORMAL_ORDERS) {
		Env env = this.env();
		List<Market> markets = env.markets;
		List<Agent> agents = env.normalAgents;

		long beginTime = System.nanoTime();
		List<List<Order>> allOrders = new ArrayList<List<Order>>();

		Random random = sim.getRandom();
		RandomPermutation<Agent> randomAgents = new RandomPermutation<Agent>(
				random, agents);

		long k = 0;
		randomAgents.shuffle();
		for (Agent agent : randomAgents) {
			if (k >= MAX_NORMAL_ORDERS) {
				break;
			}
			List<Order> orders = agent.submitOrders(markets);
			if (orders.size() > 0) {
				allOrders.add(orders);
				k++;
			}
		}
		long endTime = System.nanoTime();
		if (_PROFILE) {
			System.out.println("#PROFILE ORDER-MAKE TOTAL "
					+ ((endTime - beginTime) / 1e+9) + " sec");
			System.out.println("#PROFILE MAX-NORMAL-ORDERS "
					+ MAX_NORMAL_ORDERS);
			System.out
					.println("#PROFILE NUM-NORMAL-ORDERS " + allOrders.size());
		}
		return allOrders;
	}
}
