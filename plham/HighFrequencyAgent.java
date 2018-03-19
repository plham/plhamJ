package plham;

import java.io.Serializable;
import java.util.Random;

/**
 * A marker class for high-frequency trading agents.
 */

@SuppressWarnings("unused")
public abstract class HighFrequencyAgent extends Agent implements Serializable {
	private static final long serialVersionUID = 1373496247017251032L;

	public HighFrequencyAgent(long id, String name, Random random) {
		super(id, name, random);
	}
}
