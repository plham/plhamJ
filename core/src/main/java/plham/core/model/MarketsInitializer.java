package plham.core.model;

import java.io.Serializable;
import java.util.List;

import cassia.util.JSON;
import plham.core.Market;
import plham.core.util.Random;

public interface MarketsInitializer extends Serializable {

	List<Market> initialize(long id, String name, Random random, JSON.Value json);

}
