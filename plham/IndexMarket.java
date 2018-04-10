package plham;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import plham.util.Random;

import cassia.util.JSON;
import plham.main.Simulator;
import plham.util.JSONRandom;

/**
 * A class for markets (assets) associated with some underlying markets
 * (assets).
 *
 * <p>
 * <ul>
 * <li>Call <code>addMarkets(List[Market])</code> to add underlying components.
 * </ul>
 */
public class IndexMarket extends Market {
	private static final long serialVersionUID = -3047381851468236308L;

	/*
	public var components:List[Long];
	*/
	public List<Long> components;

	/*
	public def this(id:Long, name:String, random:Random) {
		super(id, name, random);
		this.components = new ArrayList[Long]();
	}
	*/
	public IndexMarket(long id, String name, Random random) {
		super(id, name, random);
		this.components = new ArrayList<Long>();
	}

	/*
	public def this() {
		this(-1, "default", new Random());
	}
	*/
	public IndexMarket() {
		this(-1, "default", new Random());
	}

	/*
	public def addMarket(market:Market) {
		assert !this.components.contains(market.id);
		this.components.add(market.id);
	}
	*/
	public void addMarket(Market market) {
		assert !this.components.contains(market.id);
		this.components.add(market.id);
	}

	/*
	public def addMarkets(markets:Container[Market]) {
		for (m in markets) {
			this.addMarket(m);
		}
	}
	*/
	public void addMarkets(List<Market> markets) {
		for (Market market : markets) {
			this.addMarket(market);
		}
	}

	/*
	public def getComponents():List[Long] = this.components;
	*/

	public List<Long> getComponents() {
		return this.components;
	}

	/*
	public def getMarkets():List[Market] {
		assert this.env != null : "Cannot call during the setup procedure";
		val m = new ArrayList[Market]();
		for (id in this.components) {
			m.add(this.env.markets(id));
		}
		return m;
	}
	*/

	public List<Market> getMarkets() {
		assert this.env != null : "Cannot call during the setup procedure";
		List<Market> m = new ArrayList<Market>();
		for (@SuppressWarnings("hiding")
		long id : this.components) {
			m.add(this.env.markets.get((int) id));
		}
		return m;
	}

	/*
	public def isAllMarketsRunning() {
		assert this.env != null : "Cannot call during the setup procedure";
		for (id in this.components) {
			if (!this.env.markets(id).isRunning()) {
				return false;
			}
		}
		return this.isRunning();
	}
	*/
	public boolean isAllMarketsRunning() {
		assert this.env != null : "Cannot call during the setup procedure";
		for (@SuppressWarnings("hiding")
		long id : this.components) {
			if (!this.env.markets.get((int) id).isRunning()) {
				return false;
			}
		}
		return this.isRunning();
	}

	/*
	// Override
	public def check() {
		val t = this.getTime();
		assert this.marketPrices.size() - 1 == t;
		//assert this.fundamentalPrices.size() - 1 == t;
		assert this.lastExecutedPrices.size() - 1 == t;
		assert this.sumExecutedVolumes.size() - 1 == t;
		assert this.buyOrdersCounts.size() - 1 == t;
		assert this.sellOrdersCounts.size() - 1 == t;
		assert this.executedOrdersCounts.size() - 1 == t;
		assert this.executionLogs.size() - 1 == t;
		assert this.agentUpdates.size() - 1 == t;
		Console.OUT.println("#MARKET CHECK PASSED");
	}
	*/
	@Override
	public void check() {
		long t = this.getTime();
		assert this.marketPrices.size() - 1 == t;
		// assert this.fundamentalPrices.size() - 1 == t;
		assert this.lastExecutedPrices.size() - 1 == t;
		assert this.sumExecutedVolumes.size() - 1 == t;
		assert this.buyOrdersCounts.size() - 1 == t;
		assert this.sellOrdersCounts.size() - 1 == t;
		assert this.executedOrdersCounts.size() - 1 == t;
		assert this.executionLogs.size() - 1 == t;
		assert this.agentUpdates.size() - 1 == t;
	}

	/*
	public def getIndex() = this.getMarketIndex();
	*/
	public double getIndex() {
		return this.getMarketIndex();
	}

	/*
	public def getIndex(t:Long) = this.getMarketIndex(t);
	*/
	public double getIndex(long t) {
		return this.getMarketIndex(t);
	}

	/*
	public def getMarketIndex() = this.getMarketIndex(this.getTime());
	*/
	public double getMarketIndex() {
		return this.getMarketIndex(this.getTime());

	}

	/*
	public def getMarketIndex(t:Long) {
		return this.computeMarketIndex(t);
	}
	*/
	public double getMarketIndex(long t) {
		return this.computeMarketIndex(t);
	}

	/*
	public def getFundamentalPrice(t:Long) {
		if (this.fundamentalPrices.size() <= t) {
			this.fundamentalPrices.resize(t + 1, Double.NaN);
		}
		if (this.fundamentalPrices(t).isNaN()) {
			this.fundamentalPrices(t) = this.computeFundamentalIndex(t);
		}
		return this.fundamentalPrices(t);
	}
	*/
	@Override
	public double getFundamentalPrice(long t) {
		int size = this.fundamentalPrices.size();
		if (size <= t) {
			List<Double> l = new ArrayList<Double>((int) (t + 1));
			Collections.nCopies((int) (t - size), Double.NaN);
			this.fundamentalPrices.addAll(l);
		}
		if (this.fundamentalPrices.get((int) t).isNaN()) {
			this.fundamentalPrices
					.set((int) t, this.computeFundamentalIndex(t));
		}
		return this.fundamentalPrices.get((int) t);
	}

	/*
	public def getFundamentalPrice() = this.getFundamentalPrice(this.getTime());
	*/
	@Override
	public double getFundamentalPrice() {
		return this.getFundamentalPrice(this.getTime());
	}

	/*
	public def getFundamentalIndex() = this.getFundamentalPrice();
	*/
	public double getFundamentalIndex() {
		return this.getFundamentalPrice();
	}

	/*
	public def getFundamentalIndex(t:Long) = this.getFundamentalPrice(t);
	*/
	public double getFundamentalIndex(long t) {
		return this.getFundamentalPrice(t);
	}

	/*
	public static struct WHICH_INDEX(id:Long) {}
	public static FUNDAMENTAL = WHICH_INDEX(0);
	public static MARKET = WHICH_INDEX(1);
	public def computeIndex(t:Long, which_type:WHICH_INDEX) {
		var total_value:Double = 0;
		var total_shares:Double = 0;
		for (component_id in this.components) {
			val m = this.env.markets(component_id);
			// Assuming that the number of markets' outstanding shares is always the same during a simulation.
			total_value += (which_type == FUNDAMENTAL ? m.getFundamentalPrice(t) : m.getMarketPrice(t)) * m.getOutstandingShares();
			total_shares += m.getOutstandingShares();
		}
		return total_value / total_shares;
	}
	*/
	public static long FUNDAMENTAL = 0L;
	public static long MARKET = 1L;

	public double computeIndex(long t, long whichType) {
		double totalValue = 0;
		double totalShares = 0;
		for (long componentId : this.components) {
			Market m = this.env.markets.get((int) componentId);
			totalValue += (whichType == FUNDAMENTAL ? m.getFundamentalPrice(t)
					: m.getMarketPrice(t)) * m.getOutstandingShares();
			totalShares += m.getOutstandingShares();
		}
		return totalValue / totalShares;
	}

	/*
	public def computeMarketIndex():Double {
		assert this.env != null : "Cannot call during the setup procedure";
		return this.computeIndex(this.getTime(), MARKET);
	}
	*/
	public double computeMarketIndex() {
		assert this.env != null : "Cannot call during the setup procedure";
		return this.computeIndex(this.getTime(), MARKET);
	}

	/*
	public def computeMarketIndex(t:Long):Double {
		assert this.env != null : "Cannot call during the setup procedure";
		return this.computeIndex(t, MARKET);
	}
	*/
	public double computeMarketIndex(long t) {
		assert this.env != null : "Cannot call during the setup procedure";
		return this.computeIndex(t, MARKET);
	}

	/*
	public def computeFundamentalIndex():Double = this.computeFundamentalIndex(this.getTime());
	*/
	public double computeFundamentalIndex() {
		return this.computeFundamentalIndex(this.getTime());
	}

	/*
	public def computeFundamentalIndex(t:Long):Double {
		assert this.env != null : "Cannot call during the setup procedure";
		return this.computeIndex(t, FUNDAMENTAL);
	}
	*/
	public double computeFundamentalIndex(long t) {
		assert this.env != null : "Cannot call during the setup procedure";
		return this.computeIndex(t, FUNDAMENTAL);
	}

	/*
	public def setup(json:JSON.Value, sim:Simulator) {
		val random = new JSONRandom(getRandom());
		val spots = sim.getMarketsByName(json("markets"));
		this.addMarkets(spots);

		// WARN: Market's methods access to market.env is not available here :WARN

		this.setOutstandingShares(random.nextRandom(json("outstandingShares")) as Long);
		
		// helper function for setInitialMarketPrice, setInitialFundamentalPrice
		val compute = (which_type:WHICH_INDEX) => {
			var total_value:Double = 0;
			var total_shares:Double = 0;
			for (m in spots) {
				total_value += (which_type == FUNDAMENTAL ? m.getFundamentalPrice() : m.getMarketPrice()) * m.getOutstandingShares();
				total_shares += m.getOutstandingShares();
			}
			return total_value / total_shares;
		};
		this.setInitialMarketPrice(compute(MARKET));
		this.setInitialFundamentalPrice(compute(FUNDAMENTAL));
		return this;
	}
	*/

	@SuppressWarnings("static-method")
	public double computeIndex(long whichType, List<Market> spots) {
		double totalValue = 0;
		double totalShares = 0;
		for (Market m : spots) {
			totalValue += (whichType == FUNDAMENTAL ? m.getFundamentalPrice()
					: m.getMarketPrice()) * m.getOutstandingShares();
			totalShares += m.getOutstandingShares();
		}
		return totalValue / totalShares;
	}

	public Market setup(JSON.Value json, Simulator sim) {
		JSONRandom random = new JSONRandom(getRandom());
		List<Market> spots = sim.getMarketsByName(json.get("markets"));
		this.addMarkets(spots);

		// WARN: Market's methods access to market.env is not available here
		// :WARN
		this.setOutstandingShares(new Double(random.nextRandom(json
				.get("outstandingShares"))).longValue());

		this.setInitialMarketPrice(computeIndex(MARKET, spots));
		this.setInitialFundamentalPrice(computeIndex(FUNDAMENTAL, spots));
		return this;
	}

	/*
	public static def register(sim:Simulator):void {
		val className = "IndexMarket";
		sim.addMarketsInitializer(className, (id:Long, name:String, random:Random, json:JSON.Value) => {
			val markets = new ArrayList[Market]();
			val market = new IndexMarket(id, name, random).setup(json, sim);
			markets.add(market);
			Console.OUT.println("# " + json("class").toString() + " : " + JSON.dump(json));
			return markets;
		});
	}
	*/
	@SuppressWarnings({ "static-method", "unused", "hiding" })
	public List<Market> register(Simulator sim, long id, String name,
			Random random, JSON.Value json) {
		// String className = "IndexMarket";

		List<Market> markets = new ArrayList<Market>();
		Market market = new IndexMarket(id, name, random).setup(json);
		markets.add(market);
		return markets;
	}
}
