package plham.core.model;

import cassia.util.JSON;
import plham.core.Market;
import plham.core.util.Random;

public interface MarketInitializer {
	Market initialize(long id, String name, Random random, JSON.Value json);
}
