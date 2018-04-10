package plham.model;

import java.io.Serializable;
import plham.util.Random;

import cassia.util.JSON;

import plham.Event;

/*
	public static type EventInitializer = (Long, String, Random, JSON.Value json)=>Event;
 */
public interface EventInitializer extends Serializable {
	public Event initialize(long id, Random random, String name, JSON.Value json);
}