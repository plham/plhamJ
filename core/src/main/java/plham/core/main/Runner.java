package plham.core.main;

import java.io.Serializable;

import plham.core.SimulationOutput;

/**
 * A base class for execution models. See
 * {@link plham.core.main.SimulatorFactory} for simulation models. This class is
 * basically for system developers.
 */
public abstract class Runner implements Serializable {

	protected static double HIFREQ_SUBMIT_RATE = System.getenv("HIFREQ_SUBMIT_RATE") != null
			? Double.valueOf(System.getenv("HIFREQ_SUBMIT_RATE"))
			: 1.0d;

	private static final long serialVersionUID = 4487185718113921593L;
	public boolean _PROFILE = false;

	SimulatorFactory factory;
	Simulator sim;
	SimulationOutput output;

	public Runner(SimulationOutput out, SimulatorFactory f) {
//		sim = s;
		output = out;
		factory = f;
	}

	/**
	 * Run the simulation with which the runner was constructed, calling the
	 * provided {@link Simulator}'s output methods at the appropriate time
	 */
	public abstract void run(long seed);
}
