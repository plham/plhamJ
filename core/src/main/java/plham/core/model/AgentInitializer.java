package plham.core.model;

import java.io.Serializable;

import cassia.util.JSON;
import plham.core.Agent;
import plham.core.util.Random;

public interface AgentInitializer extends Serializable {
    Agent initialize(long id, String name, Random random, JSON.Value json);
}
