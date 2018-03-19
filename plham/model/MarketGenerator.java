package plham.model;

import java.io.Serializable;

import com.fasterxml.jackson.databind.JsonNode ;

/*
	public static type MarketGenerator = (JsonNode )=>List[JsonNode ];
 */
public class MarketGenerator implements Serializable {

	private static final long serialVersionUID = 6691286378272640128L;

	private JsonNode  jsonValue;

	public MarketGenerator(JsonNode  jsonValue) {
		this.jsonValue = jsonValue;
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