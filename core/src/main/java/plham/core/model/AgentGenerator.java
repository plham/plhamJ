package plham.core.model;

import java.io.Serializable;
import java.util.List;

import cassia.util.JSON;

public interface AgentGenerator extends Serializable {
	List<JSON.Value> generate(JSON.Value json);
}
