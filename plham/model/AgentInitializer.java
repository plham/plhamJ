package plham.model;

import java.util.Random;

import plham.Agent;

import com.fasterxml.jackson.databind.JsonNode;

/*
	public static type AgentInitializer = (Long, String, Random, JSON.Value)=>Agent;
 */
public interface AgentInitializer {
	public Agent initialize(long id, String name, Random random,
			JsonNode jsonNode);
}