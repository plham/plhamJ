package plham.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

/*
	public static type AgentGenerator = (JSON.Value)=>List[JSON.Value];
 */
public interface AgentGenerator extends Serializable {
	public List<JsonNode> generate(JsonNode jsonNode);
}