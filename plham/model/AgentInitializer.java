package plham.model;

import plham.util.Random;

import plham.Agent;
import cassia.util.JSON;

/*
	public static type AgentInitializer = (Long, String, Random, JSON.Value)=>Agent;
 */
public interface AgentInitializer {
	public Agent initialize(long id, String name, Random random,
			JSON.Value json);
}