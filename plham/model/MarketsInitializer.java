package plham.model;

import java.io.Serializable;
import java.util.List;
import plham.util.Random;

import plham.Market;
import cassia.util.JSON;

/*
	public static type MarketsInitializer = (Long, String, Random, JSON.Value)=>List[Market];
 */
public interface MarketsInitializer extends Serializable {

	public List<Market> initialize(long id, String name, Random random,
			JSON.Value json);

}