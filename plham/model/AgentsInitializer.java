package plham.model;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.JsonNode;

import plham.Agent;
import x10.lang.LongRange;

/*
	public static type AgentsInitializer = (String, Indexed[Random], LongRange, JSON.Value, Settable[Long, Agent])=>void;
 */
public class AgentsInitializer implements Serializable {

	private static final long serialVersionUID = 1921313834240374376L;

	private String name;
	private List<Random> randoms;
	private LongRange idRange;
	private JsonNode jsonValue;
	private List<Agent> agents;

	public AgentsInitializer(String name, List<Random> randoms,
			LongRange idRange, JsonNode jsonValue, List<Agent> agents) {
		this.name = name;
		this.randoms = randoms;
		this.idRange = idRange;
		this.jsonValue = jsonValue;
		this.agents = agents;
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
	 * randomsを取得します。
	 * 
	 * @return randoms
	 */
	public List<Random> getRandoms() {
		return randoms;
	}

	/**
	 * randomsを設定します。
	 * 
	 * @param randoms
	 *            randoms
	 */
	public void setRandoms(List<Random> randoms) {
		this.randoms = randoms;
	}

	/**
	 * idRangeを取得します。
	 * 
	 * @return idRange
	 */
	public LongRange getIdRange() {
		return idRange;
	}

	/**
	 * idRangeを設定します。
	 * 
	 * @param idRange
	 *            idRange
	 */
	public void setIdRange(LongRange idRange) {
		this.idRange = idRange;
	}

	/**
	 * jsonValueを取得します。
	 * 
	 * @return jsonValue
	 */
	public JsonNode getJsonValue() {
		return jsonValue;
	}

	/**
	 * jsonValueを設定します。
	 * 
	 * @param jsonValue
	 *            jsonValue
	 */
	public void setJsonValue(JsonNode jsonValue) {
		this.jsonValue = jsonValue;
	}

	/**
	 * agentsを取得します。
	 * 
	 * @return agents
	 */
	public List<Agent> getAgents() {
		return agents;
	}

	/**
	 * agentsを設定します。
	 * 
	 * @param agents
	 *            agents
	 */
	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
}