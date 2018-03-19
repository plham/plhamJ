package plham.model;

import java.io.Serializable;

import com.fasterxml.jackson.databind.JsonNode ;

import plham.Market;
import x10.util.Random;

/*
	public static type MarketsInitializer = (Long, String, Random, JSON.Value)=>List[Market];
 */
public class MarketsInitializer implements Serializable {

	private static final long serialVersionUID = -5368073881285608996L;

	private Long id;
	private String name;
	private Random random;
	private JsonNode  jsonValue;

	public MarketsInitializer(Long id, String name, Random random,
			JsonNode  jsonValue) {
		this.id = id;
		this.name = name;
		this.random = random;
		this.jsonValue = jsonValue;
	}

	public Market get() {
		// TODO
		return null;
	}

	/**
	 * idを取得します。
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * idを設定します。
	 * 
	 * @param id
	 *            id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * nameを取得します。
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * nameを設定します。
	 * 
	 * @param name
	 *            name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * randomを取得します。
	 * 
	 * @return random
	 */
	public Random getRandom() {
		return random;
	}

	/**
	 * randomを設定します。
	 * 
	 * @param random
	 *            random
	 */
	public void setRandom(Random random) {
		this.random = random;
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