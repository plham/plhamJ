package plham.core.event;

import cassia.util.JSON;
import plham.core.Event;
import plham.core.Market;
import plham.core.Market.MarketEvent;
import plham.core.main.SimulatorFactory;
import plham.core.model.EventInitializer;
import plham.core.util.Random;

/**
 * This suddenly changes the fundamental price (just changing it).
 */
public class FundamentalPriceShock implements MarketEvent {
	public static long NO_TIME_LENGTH = Long.MAX_VALUE / 2;

	private static final long serialVersionUID = 7289366271787338478L;

	public static void register(SimulatorFactory sim) {
		String className = "FundamentalPriceShock";
		sim.addEventInitializer(className, new EventInitializer() {
			private static final long serialVersionUID = -4077307430140468053L;

			@Override
			public Event initialize(long id, Random random, String name, JSON.Value json) {
				return new FundamentalPriceShock(id, name, random).setup(json, sim);
			}
		});
	}

	public long id;
	public long marketId;

	public String name;
	public double priceChangeRate;
	protected Random random;
	public long shockTimeLength;

	public long triggerTime;

	public FundamentalPriceShock(long id, String name, Random random) {
		this.id = id;
		this.name = name;
		this.random = random;
		shockTimeLength = NO_TIME_LENGTH;
	}

	@Override
	public FundamentalPriceShock setup(JSON.Value json, SimulatorFactory sim) {
		Market market = sim.getSimulatorInConstruction().getMarketByName(json.get("target"));
		marketId = market.id;
		if (json.has("triggerTime")) {
			triggerTime = json.get("triggerTime").toLong();
		} else if (json.has("triggerDays")) {
			// It's probably a bad idea that 'numStepsOneDay', which is a
			// toplevel element of config.json, is needed to setup
			// FundamentalPriceShocks.";
			// Should it be fixed?
			if (!sim.CONFIG.has("numStepsOneDay")) {
				assert false : "FundamentalPriceShock: triggerDays was specified, but could not find 'numStepsOneDay'. Specify 'numStepsOneDay' in the config.";
			}
			long numStepsOneDay = sim.CONFIG.get("numStepsOneDay").toLong();
			long triggerDays = json.get("triggerDays").toLong();
			triggerTime = triggerDays * numStepsOneDay;
		} else {
			assert false : "Could not find triggerTime. Specify 'triggerTime' or 'triggerDays' of 'FundamentalPriceShock' in the config file.";
		}
		shockTimeLength = FundamentalPriceShock.NO_TIME_LENGTH;
		priceChangeRate = json.get("priceChangeRate").toDouble();
		market.addBeforeSimulationStepEvent(this);
		return this;
	}

	@Override
	public void update(Market market) {
		assert marketId == market.id;
		long t = market.getTime();
		if (t >= triggerTime && t <= triggerTime + shockTimeLength) {
			double price = market.fundamentalPrices.get((int) t);
			market.fundamentalPrices.set((int) t, price * (1 + priceChangeRate));
		}
	}
}
