package plham.samples.CancelTest;

import java.util.ArrayList;
import java.util.List;

import cassia.util.JSON;
import cassia.util.JSON.Value;
import plham.core.Agent;
import plham.core.Cancel;
import plham.core.Market;
import plham.core.Order;
import plham.core.agent.FCNAgent;
import plham.core.main.SimulatorFactory;
import plham.core.model.AgentInitializer;
import plham.core.util.Random;

public class CancelFCNAgent extends FCNAgent {
	private static final long serialVersionUID = -2320743142680239863L;

	public static void register(SimulatorFactory sim) {
		String className = "CancelFCNAgent";
		sim.addAgentInitializer(className, new AgentInitializer() {
			@Override
			public Agent initialize(long id, String name, Random random, Value json) {
				return new CancelFCNAgent(id, name, random).setup(json, sim);
			}
		});
	}

	public long orderId = 1;

	public CancelFCNAgent(long id, String name, Random random) {
		super(id, name, random);
	}

	@Override
	public long nextOrderId() {
		return orderId++;
	}

	@Override
	public CancelFCNAgent setup(JSON.Value json, SimulatorFactory sim) {
		return (CancelFCNAgent) super.setup(json, sim);
	}

	@Override
	public List<Order> submitOrders(Market market) {
		List<Order> orders = super.submitOrders(market);
		if (orders.size() == 0) {
			return orders;
		}

		double CANCEL_RATE = 0.3D;
		List<Order> clones = new ArrayList<>(orders);
		for (Order o : clones) {
			if (getRandom().nextDouble() < CANCEL_RATE) {
				orders.add(new Cancel(o));
			}
		}
		return orders;
	}
}
