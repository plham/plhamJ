package plham.model;

import java.io.Serializable;
import java.util.List;
import plham.util.Random;

import cassia.util.JSON;

import plham.Agent;
import x10.lang.LongRange;

/*
	public static type AgentsInitializer = (String, Indexed[Random], LongRange, JSON.Value, Settable[Long, Agent])=>void;
 */
public interface AgentsInitializer extends Serializable {

	public void initialize(String name, List<Random> randoms,
			LongRange longRange, JSON.Value json, List<Agent> agents);
}