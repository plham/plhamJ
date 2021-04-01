package plham.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cassia.util.JSON;
import plham.core.main.SimulatorFactory;
import plham.core.model.MarketsInitializer;
import plham.core.util.JSONRandom;
import plham.core.util.Random;

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
	public static long FUNDAMENTAL = 0L;

	public static long MARKET = 1L;

	private static final long serialVersionUID = -3047381851468236308L;

	public static void register(SimulatorFactory sim) {
		String className = "IndexMarket";
		MarketsInitializer initializers = new MarketsInitializer() {
			private static final long serialVersionUID = -5278272316635355514L;

			@Override
			public List<Market> initialize(long id, String name, Random random, JSON.Value json) {
				List<Market> markets = new ArrayList<>();
				Market market = new IndexMarket(id, name, random).setup(json, sim);
				markets.add(market);
				System.out.println("# " + json.get("class").toString() + " : " + JSON.dump(json));
				return markets;
			}

		};
		sim.marketInitializers.put(className, initializers);
	}

	public List<Long> components;

	public IndexMarket() {
		this(-1, "default", new Random());
	}

	public IndexMarket(long id, String name, Random random) {
		super(id, name, random);
		components = new ArrayList<>();
	}

	public void addMarket(Market market) {
		assert !components.contains(market.id);
		components.add(market.id);
	}

	public void addMarkets(List<Market> markets) {
		for (Market market : markets) {
			addMarket(market);
		}
	}

	@Override
	public void check() {
		long t = getTime();
		assert marketPrices.size() - 1 == t;
		// assert this.fundamentalPrices.size() - 1 == t;
		assert lastExecutedPrices.size() - 1 == t;
		assert sumExecutedVolumes.size() - 1 == t;
		assert buyOrdersCounts.size() - 1 == t;
		assert sellOrdersCounts.size() - 1 == t;
		assert executedOrdersCounts.size() - 1 == t;
		assert executionLogs.size() - 1 == t;
		assert agentUpdates.size() - 1 == t;
		System.out.println("#MARKET CHECK PASSED");
	}

	public double computeFundamentalIndex() {
		return this.computeFundamentalIndex(getTime());
	}

	public double computeFundamentalIndex(long t) {
		assert env != null : "Cannot call during the setup procedure";
		return this.computeIndex(t, FUNDAMENTAL);
	}

	public double computeIndex(long whichType, List<Market> spots) {
		double totalValue = 0;
		double totalShares = 0;
		for (Market m : spots) {
			totalValue += (whichType == FUNDAMENTAL ? m.getFundamentalPrice() : m.getMarketPrice())
					* m.getOutstandingShares();
			totalShares += m.getOutstandingShares();
		}
		return totalValue / totalShares;
	}

	public double computeIndex(long t, long whichType) {
		double totalValue = 0;
		double totalShares = 0;
		for (long componentId : components) {
			Market m = env.markets.get((int) componentId);
			totalValue += (whichType == FUNDAMENTAL ? m.getFundamentalPrice(t) : m.getMarketPrice(t))
					* m.getOutstandingShares();
			totalShares += m.getOutstandingShares();
		}
		return totalValue / totalShares;
	}

	public double computeMarketIndex() {
		assert env != null : "Cannot call during the setup procedure";
		return this.computeIndex(getTime(), MARKET);
	}

	public double computeMarketIndex(long t) {
		assert env != null : "Cannot call during the setup procedure";
		return this.computeIndex(t, MARKET);
	}

	public List<Long> getComponents() {
		return components;
	}

	public double getFundamentalIndex() {
		return this.getFundamentalPrice();
	}

	public double getFundamentalIndex(long t) {
		return this.getFundamentalPrice(t);
	}

	@Override
	public double getFundamentalPrice() {
		return this.getFundamentalPrice(getTime());
	}

	@Override
	public double getFundamentalPrice(long t) {
		int size = fundamentalPrices.size();
		if (size <= t) {
			int addSize = size - (int) t + 1;
			fundamentalPrices.addAll(Collections.nCopies(addSize, Double.NaN));
		}
		if (fundamentalPrices.get((int) t).isNaN()) {
			fundamentalPrices.set((int) t, this.computeFundamentalIndex(t));
		}
		return fundamentalPrices.get((int) t);
	}

	public double getIndex() {
		return this.getMarketIndex();
	}

	public double getIndex(long t) {
		return this.getMarketIndex(t);
	}

	public double getMarketIndex() {
		return this.getMarketIndex(getTime());

	}

	public double getMarketIndex(long t) {
		return this.computeMarketIndex(t);
	}

	public List<Market> getMarkets() {
		assert env != null : "Cannot call during the setup procedure";
		List<Market> m = new ArrayList<>();
		for (long id : components) {
			m.add(env.markets.get((int) id));
		}
		return m;
	}

	public boolean isAllMarketsRunning() {
		assert env != null : "Cannot call during the setup procedure";
		for (long idx : components) {
			if (!env.markets.get((int) idx).isRunning()) {
				return false;
			}
		}
		return isRunning();
	}

	@Override
	public Market setup(JSON.Value json, SimulatorFactory sim) {
		JSONRandom random = new JSONRandom(getRandom());
		List<Market> spots = sim.getSimulatorInConstruction().getMarketsByName(json.get("markets"));
		addMarkets(spots);

		// WARN: Market's methods access to market.env is not available here
		// :WARN
		setOutstandingShares(Double.valueOf(random.nextRandom(json.get("outstandingShares"))).longValue());

		setInitialMarketPrice(computeIndex(MARKET, spots));
		setInitialFundamentalPrice(computeIndex(FUNDAMENTAL, spots));
		return this;
	}
}
