package plham.model;

import plham.util.Random;

import cassia.util.JSON;
import plham.Market;

/*
	public static type MarketInitializer = (Long, String, Random, JSON.Value)=>Market;
 */
public interface MarketInitializer {
	public Market initialize(long id, String name, Random random,
			JSON.Value json);
}