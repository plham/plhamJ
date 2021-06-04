package plham.core.model;

import cassia.util.JSON;
import plham.core.Agent;
import plham.core.util.Random;

import java.io.Serializable;

public interface AgentInitializer extends Serializable {
    Agent initialize(long id, String name, Random random, JSON.Value json);
}
