package plham.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.fasterxml.jackson.databind.JsonNode;

import plham.Agent;
import x10.lang.LongRange;

/*
	public static type AgentsInitializer = (String, Indexed[Random], LongRange, JSON.Value, Settable[Long, Agent])=>void;
 */
public interface AgentsInitializer extends Serializable {

	public void initialize(String name, List<Random> randoms,
			LongRange longRange, JsonNode jsonNode, Map<Long, Agent> agents);
}