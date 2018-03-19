package plham;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.fasterxml.jackson.databind.JsonNode;

import plham.main.Simulator;
import plham.util.JSONRandom;

/**
 * The base class for agents.
 * 
 * <p>
 * <ul>
 * <li>Override <code>submitOrders(List[Market])</code> to implement a trading
 * strategy.
 * <li>Only overriding <code>submitOrders(Market)</code> would not work
 * expectedly.
 * <li>Do not call <code>Market#handleOrders(List[Order])</code> in
 * <code>submitOrders(List[Market])</code> family.
 * <li>Call <code>setMarketAccessible(Market)</code> to tell the agent to enter
 * that market.
 * <li>Without calling <code>setMarketAccessible(Market)</code>,
 * <code>getAssetVolume(Market)</code> will raise an error.
 * <li>Use <code>getRandom()</code> and do NOT make <code>new Random()</code>.
 * </ul>
 */
public class Agent implements Serializable {
	private static final long serialVersionUID = 8125568561529801185L;

	/*
	public val id:Long;
	public val name:String;
	private val random:Random;
	protected def getRandom():Random = this.random;
	public var cashAmount:Double;
	public var assetsVolumes:Map[Long,Long];
	 */
	private long id;
	private String name;
	private Random random;
	private JsonNode jsonValue;
	public double cashAmount;
	public Map<Long, Long> assetsVolumes;

	/*
	public def this(id:Long, name:String, random:Random) {
		this.id = id;
		this.name = name;
		this.random = random;
		this.cashAmount = 0.0;
		this.assetsVolumes = new HashMap[Long,Long]();
	}
	 */
	public Agent(long id, String name, Random random, JsonNode jsonValue) {
		this.id = id;
		this.name = name;
		this.random = random;
		this.jsonValue = jsonValue;
		this.cashAmount = 0.0D;
		this.assetsVolumes = new HashMap<Long, Long>();
	}

	public Agent(long id, String name, Random random) {
		this.id = id;
		this.name = name;
		this.random = random;
		this.cashAmount = 0.0D;
		this.assetsVolumes = new HashMap<Long, Long>();
	}

	@SuppressWarnings("hiding")
	public Agent create(long id, String name, Random random, JsonNode jsonValue) {
		return new Agent(id, name, random, jsonValue);
	}

	/*
	private def this(id:Long) {
	    this.id=id;
	    this.name = null;
	    this.random = null;
	    this.cashAmount = 0.0;
	    this.assetsVolumes = null;
	}
	 */
	private Agent(long id) {
		this.id = id;
		this.name = null;
		this.random = null;
		this.jsonValue = null;
		this.cashAmount = 0.0D;
		this.assetsVolumes = null;
	}

	/*
	static public class Proxy extends Agent {
	    protected def this(id:Long) { super(id); }
	    public def submitOrders(markets:List[Market]):List[Order] { throw new Error("should not called");}
	}
	 */
	public static class Proxy extends Agent {
		private static final long serialVersionUID = 5720370841906231049L;

		@SuppressWarnings("synthetic-access")
		protected Proxy(long id) {
			super(id);
		}

		@SuppressWarnings("static-method")
		public List<Order> submitOrders(
				@SuppressWarnings("unused") List<Market> markets) {
			throw new UnsupportedOperationException("should not called");
		}
	}

	/*
	public def setup(json:JsonNode  , sim:Simulator):Agent {
		val jsonrandom = new JSONRandom(getRandom());
		this.assetsVolumes = new HashMap[Long, Long]();
		this.cashAmount = jsonrandom.nextRandom(json("cashAmount"));
		for (market in sim.getMarketsByName(json("markets"))) {
			this.assetsVolumes(market.id) = 0;
			this.assetsVolumes(market.id) = jsonrandom.nextRandom(json("assetVolume")) as Long;
		}
		return this;
	}
	*/
	public Agent setup(JsonNode jsonNode, Simulator sim) {
		JSONRandom jsonRandom = new JSONRandom(getRandom());
		this.assetsVolumes = new HashMap<Long, Long>();
		this.cashAmount =jsonRandom.nextRandom(jsonNode.get("cashAmount"));
		sim.getMarketsByName(jsonNode.get("markets"));
		for (market in sim.getMarketsByName(json.get(json("markets"))) {
			this.assetsVolumes(market.id) = 0;
			this.assetsVolumes(market.id) = jsonrandom.nextRandom(json("assetVolume")) as Long;
		}
		return this;
	}

	/**
	 * idを取得します。
	 * 
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * idを設定します。
	 * 
	 * @param id
	 *            id
	 */
	public void setId(long id) {
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

}
