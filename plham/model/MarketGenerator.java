package plham.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

/*
	public static type MarketGenerator = (JsonNode )=>List[JsonNode ];
 */
public interface MarketGenerator extends Serializable {
	public List<JsonNode> generate(JsonNode jsonNode);
}