package samples.CancelTest;

import java.util.ArrayList;
import java.util.List;

import cassia.util.JSON;
import cassia.util.JSON.Value;
import plham.Agent;
import plham.Cancel;
import plham.Market;
import plham.Order;
import plham.agent.FCNAgent;
import plham.main.Simulator;
import plham.model.AgentInitializer;
import plham.util.Random;

public class CancelFCNAgent extends FCNAgent {
	private static final long serialVersionUID = -2320743142680239863L;
	/*
	// This enables automated order numbering.
	// Use this hack if you wanna send cancel requests.
	public var orderId:Long = 1;
	public def nextOrderId():Long {
		return orderId++;
	}
	*/
	public long orderId = 1;

	@Override
	public long nextOrderId() {
		return orderId++;
	}

	/*
	public def submitOrders(market:Market):List[Order] {
		val orders = super.submitOrders(market);
		if (orders.size() == 0) {
			return orders;
		}

		val CANCEL_RATE = 0.3;
		for (o in orders.clone()) {
			if (this.getRandom().nextDouble() < CANCEL_RATE) {
				orders.add(new Cancel(o));
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

		double CANCEL_RATE = 0.3D;
		List<Order> clones = new ArrayList<Order>(orders);
		for (Order o : clones) {
			if (this.getRandom().nextDouble() < CANCEL_RATE) {
				orders.add(new Cancel(o));
			}
		}
		return orders;
	}

	/*
	public def this(id:Long, name:String, random:Random) = super(id, name, random);
	*/
	public CancelFCNAgent(long id, String name, Random random) {
		super(id, name, random);
	}

	/*
	public def setup(json:JSON.Value, sim:Simulator):CancelFCNAgent {
		return super.setup(json, sim) as CancelFCNAgent;
	}
	*/
	@Override
	public CancelFCNAgent setup(JSON.Value json, Simulator sim) {
		return (CancelFCNAgent) super.setup(json, sim);
	}

	/*
	public static def register(sim:Simulator):void {
		val className = "CancelFCNAgent";
		sim.addAgentInitializer(className,
			(
				id:Long,
				name:String, 
				random:Random,
				json:JSON.Value
			) => {
				return new CancelFCNAgent(id, name, random).setup(json, sim);
			}
		);
	}
	*/
	public static void register(Simulator sim) {
		String className = "CancelFCNAgent";
		sim.addAgentInitializer(className, new AgentInitializer() {
			public Agent initialize(long id, String name, Random random,
					Value json) {
				return new CancelFCNAgent(id, name, random).setup(json,
						sim);
			}
		});
	}
}