package plham.event;

import java.util.HashSet;
import java.util.List;
import plham.util.Random;
import java.util.Set;

import cassia.util.JSON;
import plham.Env;
import plham.Event;
import plham.Market;
import plham.Market.MarketEvent;
import plham.Market.OrderEvent;
import plham.main.Simulator;
import plham.model.EventInitializer;
import plham.Order;

/**
 * A trading halt is a market regulation that suspends the trading of some
 * assets. The current implementation sets
 * <code>Market#isRunning() = false</code> when the price changed beyond the
 * prespecified threshold range.
 */

public class TradingHaltRule implements MarketEvent, OrderEvent {
	private static final long serialVersionUID = 7954530038790226915L;

	/*
	public val id:Long;
	public val name:String;
	public val random:Random;
	public var referenceMarketId:Long;
	public var referencePrice:Double;
	public var triggerChangeRate:Double;
	public var haltingTimeLength:Long;
	public var haltingTimeStarted:Long;
	public var activationCount:Long;
	public var targetMarketIds:Set[Long];    // Use referenceMarket.id ?
	*/
	public long id;
	public String name;
	public Random random;
	public long referenceMarketId;
	public Double referencePrice;
	public Double triggerChangeRate;
	public long haltingTimeLength;
	public long haltingTimeStarted;
	public long activationCount;
	public Set<Long> targetMarketIds; // Use referenceMarket.id ?

	public TradingHaltRule(Long id, String name, Random random) {
		this.id = id;
		this.name = name;
		this.random = random;
		this.haltingTimeStarted = Long.MIN_VALUE;
		this.activationCount = 0;
		this.targetMarketIds = new HashSet<Long>();
	}

	/*
	public def this(id:Long, name:String, random:Random) {
	//		this.referenceMarketId = referenceMarket.id;
	//		this.referencePrice = referencePrice;
	//		this.triggerChangeRate = triggerChangeRate;
	//		this.haltingTimeLength = haltingTimeLength;
		this.id = id;
		this.name = name;
		this.random = random;
		this.haltingTimeStarted = Long.MIN_VALUE;
		this.activationCount = 0;
		this.targetMarketIds = new HashSet[Long]();
	}
	*/

	/*
	public def update(market:Market, order:Order) {
		this.update(market);
	}
	*/
	public void update(Market market, Order order) {
		this.update(market);
	}

	/*
	public def update(market:Market) {
		assert this.referenceMarketId == market.id;
		val referenceMarket = market;
		val env = market.env;
		val t = referenceMarket.getTime();
		if (referenceMarket.isRunning()) {
			val priceChange = this.referencePrice - referenceMarket.getPrice();
			val thresholdChange = this.referencePrice * this.triggerChangeRate * (this.activationCount + 1);
			if (Math.abs(priceChange) >= Math.abs(thresholdChange)) {
				referenceMarket.setRunning(false);
				for (i in this.targetMarketIds) {
					val target = env.markets(i);
					target.setRunning(false);
				}
				this.haltingTimeStarted = t;
				this.activationCount++;
			}
		} else {
			if (t > this.haltingTimeStarted + this.haltingTimeLength) {
				referenceMarket.setRunning(true);
				for (i in this.targetMarketIds) {
					val target = env.markets(i);
	//					target.cleanOrderBooks(target.getPrice()); // Better to use Itayose.
					target.itayoseOrderBooks();
					target.setRunning(true);
				}
				this.haltingTimeStarted = Long.MIN_VALUE;
			}
		}
	}
	*/

	public void update(Market market) {
		assert this.referenceMarketId == market.id;
		Market referenceMarket = market;
		Env env = market.env;
		long t = referenceMarket.getTime();
		if (referenceMarket.isRunning()) {
			double priceChange = this.referencePrice
					- referenceMarket.getPrice();
			double thresholdChange = this.referencePrice
					* this.triggerChangeRate * (this.activationCount + 1);
			if (Math.abs(priceChange) >= Math.abs(thresholdChange)) {
				referenceMarket.setRunning(false);
				for (long i : this.targetMarketIds) {
					Market target = env.markets.get((int) i);
					target.setRunning(false);
				}
				this.haltingTimeStarted = t;
				this.activationCount++;
			}
		} else {
			if (t > this.haltingTimeStarted + this.haltingTimeLength) {
				referenceMarket.setRunning(true);
				for (long i : this.targetMarketIds) {
					Market target = env.markets.get((int) i);
					target.itayoseOrderBooks();
					target.setRunning(true);
				}
				this.haltingTimeStarted = Long.MIN_VALUE;
			}
		}
	}

	/*
	public def setReferencePrice(referencePrice:Double) {
		this.referencePrice = referencePrice;
	}
	*/
	public void setReferencePrice(Double referencePrice) {
		this.referencePrice = referencePrice;
	}

	/*
	public def addTargetMarket(market:Market) {
		this.targetMarketIds.add(market.id);
	}
	*/
	public void addTargetMarket(Market market) {
		this.targetMarketIds.add(market.id);
	}

	/*
	public def addTargetMarkets(markets:List[Market]) {
		for (market in markets) {
			this.targetMarketIds.add(market.id);
		}
	}
	*/

	public void addTargetMarkets(List<Market> markets) {
		for (Market market : markets) {
			this.targetMarketIds.add(market.id);
		}
	}

	/*
	public static def register(sim:Simulator) {
		val name = "TradingHaltRule";
		sim.addEventInitializer(name, (id:Long, name:String, random:Random, json:JSON.Value)=>{
			return new TradingHaltRule(id, name, random).setup(json, sim);
		});
	}
	*/
	public static void register(Simulator sim) {
		String className = "TradingHaltRule";
		sim.addEventInitializer(className, new EventInitializer() {
			private static final long serialVersionUID = -4077307430140468053L;

			public Event initialize(long id, Random random, String name,
					JSON.Value json) {
				return new TradingHaltRule(id, name, random).setup(json, sim);
			}
		});
	}

	/*
	public def setup(json:JSON.Value, sim:Simulator):TradingHaltRule {
		val market = sim.getMarketByName(json("referenceMarket"));
		this.referenceMarketId = market.id;
		this.referencePrice = market.getPrice();
		this.triggerChangeRate = json("triggerChangeRate").toDouble();
		this.haltingTimeLength = json("haltingTimeLength").toLong();
		val targetMarkets = sim.getMarketsByName(json("targetMarkets"));
		this.addTargetMarkets(targetMarkets);
		market.addAfterOrderHandlingEvent(this);
		return this;
	}
	*/
	public TradingHaltRule setup(JSON.Value json, Simulator sim) {
		Market market = sim.getMarketByName(json.get("referenceMarket"));
		this.referenceMarketId = market.id;
		this.referencePrice = market.getPrice();
		this.triggerChangeRate = json.get("triggerChangeRate").toDouble();
		this.haltingTimeLength = json.get("haltingTimeLength").toLong();
		List<Market> targetMarkets = sim.getMarketsByName(json
				.get("targetMarkets"));
		this.addTargetMarkets(targetMarkets);
		market.addAfterOrderHandlingEvent(this);
		return this;
	}

}
