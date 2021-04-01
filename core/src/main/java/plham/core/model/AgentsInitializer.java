package plham.core.model;

import java.io.Serializable;

import cassia.util.JSON;
import handist.collections.LongRange;
import handist.collections.RangedList;
import plham.core.Agent;
import plham.core.util.Random;

public interface AgentsInitializer extends Serializable {

	void initialize(String name, RangedList<Random> randoms, LongRange longRange, JSON.Value json,
			RangedList<Agent> agents);
}
