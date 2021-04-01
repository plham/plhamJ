package plham.core.model;

import java.io.Serializable;

import cassia.util.JSON;
import plham.core.Event;
import plham.core.util.Random;

public interface EventInitializer extends Serializable {
	Event initialize(long id, Random random, String name, JSON.Value json);
}
