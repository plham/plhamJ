package plham.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode ;

/*
	public static type EventGenerator = (JsonNode  )=>List[JsonNode  ];
 */
public class EventGenerator implements Serializable {

	private static final long serialVersionUID = -1718994536109440124L;

	private JsonNode  jsonValue;

	public EventGenerator(JsonNode  jsonValue) {
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