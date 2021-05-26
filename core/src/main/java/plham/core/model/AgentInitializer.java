package plham.core.model;

import cassia.util.JSON;
import plham.core.Agent;
import plham.core.util.Random;

public interface AgentInitializer {
    Agent initialize(long id, String name, Random random, JSON.Value json);
}
