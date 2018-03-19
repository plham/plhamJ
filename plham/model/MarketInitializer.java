package plham.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import x10.util.Random;

/*
	public static type MarketInitializer = (Long, String, Random, JsonNode  )=>Market;
 */
public class MarketInitializer implements Serializable {
	private static final long serialVersionUID = 5714735741947527170L;

	private Long id;
	private String name;
	private Random random;
	private JsonNode jsonNode;

	public MarketInitializer(Long id, String name, Random random,
			JsonNode jsonNode) {
		this.id = id;
		this.name = name;
		this.random = random;
		this.jsonNode = jsonNode;
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
	 * jsonNodeを取得します。
	 * 
	 * @return jsonNode
	 */
	public JsonNode getJsonNode() {
		return jsonNode;
	}

	/**
	 * jsonNodeを設定します。
	 * 
	 * @param jsonNode
	 *            jsonNode
	 */
	public void setJsonNode(JsonNode jsonNode) {
		this.jsonNode = jsonNode;
	}
}