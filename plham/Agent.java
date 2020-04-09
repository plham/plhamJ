package plham;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import plham.util.Random;
import cassia.util.JSON;
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
	public long id;
	public String name;
	protected Random random;
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
	public Agent(long id, String name, Random random) {
		this.id = id;
		this.name = name;
		this.random = random;
		this.cashAmount = 0.0D;
		this.assetsVolumes = new LinkedHashMap<Long, Long>();
	}

	public static Agent create(long id, String name, Random random) {
		return new Agent(id, name, random);
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

		@Override
		public List<Order> submitOrders(List<Market> markets) {
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
	public Agent setup(JSON.Value json, Simulator sim) {
		JSONRandom jsonRandom = new JSONRandom(random);
		this.assetsVolumes = new LinkedHashMap<Long, Long>();
		this.cashAmount = jsonRandom.nextRandom(json.get("cashAmount"));
		List<Market> markets = sim.getMarketsByName(json.get("markets"));
		for (Market market : markets) {
			this.assetsVolumes.put(market.id, 0L);
			this.assetsVolumes.put(market.id,
					new Double(jsonRandom.nextRandom(json.get("assetVolume")))
							.longValue());
		}
		return this;
	}

	/*
	public abstract def submitOrders(markets:List[Market]):List[Order];
	*/
	@SuppressWarnings({ "unused", "static-method" })
	public List<Order> submitOrders(List<Market> markets) {
		return null;
	}

	/*
	public def isMarketAccessible(id:Long) = this.assetsVolumes.containsKey(id);
	*/
	@SuppressWarnings("hiding")
	public boolean isMarketAccessible(long id) {
		return this.assetsVolumes.containsKey(id);
	}

	/*
	public def isMarketAccessible(market:Market) = this.isMarketAccessible(market.id);
	*/
	public boolean isMarketAccessible(Market market) {
		return this.isMarketAccessible(market.id);
	}

	/*
	public def setMarketAccessible(id:Long) = this.assetsVolumes(id) = 0;
	*/

	public void setMarketAccessible(Long id) {
		this.assetsVolumes.put(id, 0L);
	}

	/*
	public def setMarketAccessible(market:Market) = this.setMarketAccessible(market.id);
	*/

	public void setMarketAccessible(Market market) {
		this.setMarketAccessible(market.id);
	}

	/*
	public def getCashAmount():Double = this.cashAmount;
	*/

	/**
	 * get Random
	 * 
	 * @return random
	 */
	public Random getRandom() {
		return random;
	}

	public double getCashAmount() {
		return this.cashAmount;
	}

	/*
	public def setCashAmount(cashAmount:Double):Double = this.cashAmount = cashAmount;
	*/

	public void setCashAmount(Double cashAmount) {
		this.cashAmount = cashAmount;
	}

	/*
	public def updateCashAmount(delta:Double) = this.cashAmount += delta;
	*/

	public void updateCashAmount(Double delta) {
		this.cashAmount += delta;
	}

	/*
	public def executeUpdate(update:Market.AgentUpdate) {
	updateCashAmount(update.cashAmountDelta);
	updateAssetVolume(update.marketId, update.assetVolumeDelta);
	orderExecuted(update.marketId, update.orderId, update.price, update.cashAmountDelta, update.assetVolumeDelta);
	}
	*/
	public void executeUpdate(Market.AgentUpdate update) {
		updateCashAmount(update.cashAmountDelta);
		updateAssetVolume(update.marketId, update.assetVolumeDelta);
		orderExecuted(update.marketId, update.orderId, update.price,
				update.cashAmountDelta, update.assetVolumeDelta);
	}

	/*
	public def getAssetVolume(id:Long):Long {
		assert this.isMarketAccessible(id);
		return this.assetsVolumes(id);
	}
	*/
	@SuppressWarnings("hiding")
	public long getAssetVolume(long id) {
		assert this.isMarketAccessible(id);
		return this.assetsVolumes.get(id);
	}

	/*
	public def setAssetVolume(id:Long, assetVolume:Long) {
		assert this.isMarketAccessible(id);
		return this.assetsVolumes(id) = assetVolume;
	}
	*/

	public void setAssetVolume(long id, long assetVolume) {
		assert this.isMarketAccessible(id);
		this.assetsVolumes.put(id, assetVolume);
	}

	/*
	public def getAssetVolume(market:Market) = this.getAssetVolume(market.id);
	*/

	public long getAssetVolume(Market market) {
		return this.getAssetVolume(market.id);
	}

	/*
	public def setAssetVolume(market:Market, assetVolume:Long) = this.setAssetVolume(market.id, assetVolume);
	*/
	public void setAssetVolume(Market market, long assetVolume) {
		this.setAssetVolume(market.id, assetVolume);
	}

	/*
	public def updateAssetVolume(id:Long, delta:Long) {
		assert this.isMarketAccessible(id);
		return this.assetsVolumes(id) = this.assetsVolumes(id) + delta;
	}
	*/
	@SuppressWarnings("hiding")
	public void updateAssetVolume(long id, long delta) {
		assert this.isMarketAccessible(id);
		this.assetsVolumes.put(id, this.assetsVolumes.get(id) + delta);
	}

	/*
	public def updateAssetVolume(market:Market, delta:Long) = this.updateAssetVolume(market.id, delta);
	*/
	public void updateAssetVolume(Market market, long delta) {
		this.updateAssetVolume(market.id, delta);
	}

	/*
	public def orderExecuted(marketId:Long, orderId:Long, price:Double, cashAmountDelta:Double, assetVolumeDelta:Long) {
		//Console.OUT.println("#Agent#orderExecuted: " + ["agent:" + this.id, "market:" + market.id, "order:" + orderId, "price:" + price, "cashAmountDelta:" + cashAmountDelta, "assetVolumeDelta:" + assetVolumeDelta]);
	}
	*/
	@SuppressWarnings("unused")
	public void orderExecuted(long marketId, long orderId, double price,
			double cashAmountDelta, long assetVolumeDelta) {
		// do nothing
	}

	/*
	public def nextOrderId():Long = 0;
	*/
	@SuppressWarnings("static-method")
	public long nextOrderId() {
		return 0L;
	}

	/*
	public def toString():String {
		return this.typeName() + [this.id, this.cashAmount, this.assetsVolumes.keySet()];
	}
	*/
	@Override
	public String toString() {
		return this.getClass().getName() + this.id + "," + this.cashAmount
				+ "," + this.assetsVolumes.keySet();
	}

}
