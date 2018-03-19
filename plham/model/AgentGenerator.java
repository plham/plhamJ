package plham.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode ;

/*
	public static type AgentGenerator = (JSON.Value)=>List[JSON.Value];
 */
public class AgentGenerator implements Serializable {

	private static final long serialVersionUID = -2146852207612926214L;

	private JsonNode  jsonValue;

	public AgentGenerator(JsonNode  jsonValue) {
		this.jsonValue = jsonValue;
	}

	public List<JsonNode > get() {
		// TODO
		return null;
	}

	/**
	 * jsonValueを取得します。
	 * 
	 * @return jsonValue
	 */
	public JsonNode  getJsonValue() {
		return jsonValue;
	}

	/**
	 * jsonValueを設定します。
	 * 
	 * @param jsonValue
	 *            jsonValue
	 */
	public void setJsonValue(JsonNode  jsonValue) {
		this.jsonValue = jsonValue;
	}
}