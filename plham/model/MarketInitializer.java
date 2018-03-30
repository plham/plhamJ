package plham.model;

import java.util.Random;

import plham.Market;

import com.fasterxml.jackson.databind.JsonNode;

/*
	public static type MarketInitializer = (Long, String, Random, JSON.Value)=>Market;
 */
public interface MarketInitializer {
	public Market initialize(long id, String name, Random random,
			JsonNode jsonNode);
}