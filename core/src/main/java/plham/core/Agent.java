package plham.core;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cassia.util.JSON;
import plham.core.agent.FCNAgent;
import plham.core.main.SimulatorFactory;
import plham.core.util.JSONRandom;
import plham.core.util.Random;

/**
 * The base class for agents.
 *
 * <ul>
 * <li>Override {@link #submitOrders(List)} to implement a trading strategy.
 * <li>Only overriding {@link #submitOrders(List)} would not work expectedly.
 * <li>While it is possible for an {@link Agent} to access instances of
 * {@link Market}, you should not call method {@link Market#handleOrders(List)}
 * as part of method {@link #submitOrders(List)},
 * <li>Call {@link #setMarketAccessible(Long)} to tell the agent to enter the
 * specified market that market.
 * <li>Without calling <code>setMarketAccessible(Market)</code>,
 * <code>getAssetVolume(Market)</code> will raise an error.
 * <li>Use member {@link #random} to generate the random numbers needed for your
 * agent. Do not use any other {@link Random} object or the result of the
 * simulation would not be reproducible with an initial seed
 * <li>implement a
 * <code>public static void register(SimulatorFactory factory)</code> method in
 * your child class which registers a factory method for your class into the
 * provided factory. Refer to {@link FCNAgent#register(SimulatorFactory)} for an
 * implementation example.
 * </ul>
 */
public abstract class Agent implements Serializable {
	public static class Proxy extends Agent {
		private static final long serialVersionUID = 5720370841906231049L;

		protected Proxy(long id) {
			super(id);
		}

		@Override
		public List<Order> submitOrders(List<Market> markets) {
			throw new UnsupportedOperationException("should not called");
		}
	}

	private static final long serialVersionUID = 8125568561529801185L;
	public Map<Long, Long> assetsVolumes;
	public double cashAmount;
	public long id;
	public String name;

	protected final Random random;

	private Agent(long id) {
		this.id = id;
		name = null;
		random = null;
		cashAmount = 0.0D;
		assetsVolumes = null;
	}

	public Agent(long id, String name, Random random) {
		this.id = id;
		this.name = name;
		this.random = random;
		cashAmount = 0.0D;
		assetsVolumes = new LinkedHashMap<>();
	}

	public void executeUpdate(Market.AgentUpdate update) {
		updateCashAmount(update.cashAmountDelta);
		updateAssetVolume(update.marketId, update.assetVolumeDelta);
		orderExecuted(update.marketId, update.orderId, update.price, update.cashAmountDelta, update.assetVolumeDelta);
	}

	public long getAssetVolume(long id) {
		assert this.isMarketAccessible(id);
		return assetsVolumes.get(id);
	}

	public long getAssetVolume(Market market) {
		return this.getAssetVolume(market.id);
	}

	public double getCashAmount() {
		return cashAmount;
	}

	/**
	 * Return the {@link Random} object which is used by this object when some
	 * random number needs to be used.
	 *
	 * @return the random number generator used by this object
	 */
	public Random getRandom() {
		return random;
	}

	public boolean isMarketAccessible(long id) {
		return assetsVolumes.containsKey(id);
	}

	public boolean isMarketAccessible(Market market) {
		return this.isMarketAccessible(market.id);
	}

	public long nextOrderId() {
		return 0L;
	}

	public void orderExecuted(long marketId, long orderId, double price, double cashAmountDelta,
			long assetVolumeDelta) {
		// do nothing
	}

	public void setAssetVolume(long id, long assetVolume) {
		assert this.isMarketAccessible(id);
		assetsVolumes.put(id, assetVolume);
	}

	public void setAssetVolume(Market market, long assetVolume) {
		this.setAssetVolume(market.id, assetVolume);
	}

	public void setCashAmount(Double cashAmount) {
		this.cashAmount = cashAmount;
	}

	public void setMarketAccessible(Long id) {
		assetsVolumes.put(id, 0L);
	}

	/**
	 * Sets the assets of this agent into the specified market to 0, also granting
	 * it access for trading. This method is equivalent to calling method
	 * {@link #setMarketAccessible(Long)} with {@link Market#id} as parameter.
	 *
	 * @param market the market that this agent can now access and trade into.
	 */
	public void setMarketAccessible(Market market) {
		this.setMarketAccessible(market.id);
	}

	public Agent setup(JSON.Value json, SimulatorFactory sim) {
		JSONRandom jsonRandom = new JSONRandom(random);
		assetsVolumes = new LinkedHashMap<>();
		cashAmount = jsonRandom.nextRandom(json.get("cashAmount"));
		List<Market> markets = sim.getSimulatorInConstruction().getMarketsByName(json.get("markets"));
		for (Market market : markets) {
			assetsVolumes.put(market.id, 0L);
			assetsVolumes.put(market.id, Double.valueOf(jsonRandom.nextRandom(json.get("assetVolume"))).longValue());
		}
		return this;
	}

	public abstract List<Order> submitOrders(List<Market> markets);

	@Override
	public String toString() {
		return this.getClass().getName() + id + "," + cashAmount + "," + assetsVolumes.keySet();
	}

	public void updateAssetVolume(long id, long delta) {
		assert this.isMarketAccessible(id);
		assetsVolumes.put(id, assetsVolumes.get(id) + delta);
	}

	public void updateAssetVolume(Market market, long delta) {
		this.updateAssetVolume(market.id, delta);
	}

	public void updateCashAmount(Double delta) {
		cashAmount += delta;
	}
}
