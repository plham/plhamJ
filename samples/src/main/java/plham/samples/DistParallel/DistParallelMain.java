package plham.samples.DistParallel;

import java.util.ArrayList;
import java.util.List;

import cassia.util.JSON;
import plham.core.Event;
import plham.samples.ShockTransfer.ShockTransferMain;

public class DistParallelMain extends ShockTransferMain {

	public static void main(final String[] args) {
//		final ParallelRunnerDist runner = new ParallelRunnerDist(
//				new DistParallelMain().loadClasses());
//		runner.run(args);
	}

	public List<Event> createEvents(final JSON.Value json) {
		final ArrayList<Event> events = new ArrayList<>();
		return events;
	}

	DistParallelMain loadClasses() {
		// This refers to this class before Simulator and SimulationFactory were
		// separated.
//		FCNAgent.register(this);
//		Market.register(this);
//		IndexMarket.register(this);
//		plham.core.util.AgentGeneratorForEachMarket.register(this);
//		ArbitrageAgent.register(this);
//		FCNAgent.register(this);
//		plham.core.util.SimpleMarketGenerator.register(this);
		return this;
	}
}
