package plham.event;

import plham.util.Random;

import cassia.util.JSON;
import plham.Event;
import plham.Market;
import plham.Market.OrderEvent;
import plham.main.Simulator;
import plham.model.EventInitializer;
import plham.Order;

public class PriceLimitRule implements OrderEvent {
	private static final long serialVersionUID = -6123579735261509979L;

	/*
	public val id:Long;
	public val name:String;
	public val random:Random;
	public var referenceMarketId:Long;
	public var referencePrice:Double;
	public var triggerChangeRate:Double;
	public var activationCount:Long;
	*/
	public long id;
	public String name;
	public Random random;
	public long referenceMarketId;
	public double referencePrice;
	public double triggerChangeRate;
	public long activationCount;

	/*
	public def this(id:Long, name:String, random:Random) {
		this.id = id;
		this.name = name;
		this.random = random;
	//		this.referenceMarketId = market.id;
	//		this.referencePrice = referencePrice;
	//		this.triggerChangeRate = triggerChangeRate;
		this.activationCount = 0;
	}
	*/
	public PriceLimitRule(long id, String name, Random random) {
		this.id = id;
		this.name = name;
		this.random = random;
		this.activationCount = 0;
	}

	/*
	public def getLimitedPrice(order:Order, market:Market):Double {
		assert this.referenceMarketId == market.id;
		val orderPrice = order.getPrice();
		val priceChange = orderPrice - this.referencePrice;
		val thresholdChange = this.referencePrice * this.triggerChangeRate;
		if (Math.abs(priceChange) >= Math.abs(thresholdChange)) {
			val maxPrice = this.referencePrice * (1 + this.triggerChangeRate);
			val minPrice = this.referencePrice * (1 - this.triggerChangeRate);
			val limitedPrice = Math.min(Math.max(orderPrice, minPrice), maxPrice);
			return limitedPrice;
		}
		return orderPrice;
	}
	*/
	public Double getLimitedPrice(Order order, Market market) {
		assert this.referenceMarketId == market.id;
		double orderPrice = order.getPrice();
		double priceChange = orderPrice - this.referencePrice;
		double thresholdChange = this.referencePrice * this.triggerChangeRate;
		if (Math.abs(priceChange) >= Math.abs(thresholdChange)) {
			double maxPrice = this.referencePrice
					* (1 + this.triggerChangeRate);
			double minPrice = this.referencePrice
					* (1 - this.triggerChangeRate);
			double limitedPrice = Math.min(Math.max(orderPrice, minPrice),
					maxPrice);
			return limitedPrice;
		}
		return orderPrice;
	}

	/*
	public def update(market:Market, order:Order) {
		assert this.referenceMarketId == market.id;
		if (market.isRunning()) {
			// Mizuta etal (2014)'s implementation.
			val oldPrice = order.getPrice();
			val newPrice = this.getLimitedPrice(order, market);
			order.setPrice(newPrice);
			if (newPrice != oldPrice) {
				this.activationCount++;
			}
		}
	}
	*/
	public void update(Market market, Order order) {
		assert this.referenceMarketId == market.id;
		if (market.isRunning()) {
			// Mizuta etal (2014)'s implementation.
			double oldPrice = order.getPrice();
			double newPrice = this.getLimitedPrice(order, market);
			order.setPrice(newPrice);
			if (newPrice != oldPrice) {
				this.activationCount++;
			}
		}
	}

	/*
	public static def register(sim:Simulator):void {
		val name = "PriceLimitRule";
		sim.addEventInitializer(name, (id:Long, name:String, random:Random, json:JSON.Value)=>{
			return new PriceLimitRule(id, name, random).setup(json, sim);
		});
	}
	*/
	public static void register(Simulator sim) {
		String className = "PriceLimitRule";
		sim.addEventInitializer(className, new EventInitializer() {
			private static final long serialVersionUID = -7933070846074121349L;

			public Event initialize(long id, Random random, String name,
					JSON.Value json) {
				return new PriceLimitRule(id, name, random).setup(json, sim);
			}
		});
	}

	/*
	public def setup(json:JSON.Value, sim:Simulator):PriceLimitRule {
		val referenceMarket = sim.getMarketByName(json("referenceMarket"));
		this.referenceMarketId = referenceMarket.id;
		this.referencePrice = referenceMarket.getPrice();
		this.triggerChangeRate = json("triggerChangeRate").toDouble();
		referenceMarket.addBeforeOrderHandlingEvent(this);
		return this;
	}
	*/
	public PriceLimitRule setup(JSON.Value json, Simulator sim) {
		Market referenceMarket = sim.getMarketByName(json
				.get("referenceMarket"));
		this.referenceMarketId = referenceMarket.id;
		this.referencePrice = referenceMarket.getPrice();
		this.triggerChangeRate = json.get("triggerChangeRate").toDouble();
		referenceMarket.addBeforeOrderHandlingEvent(this);
		return this;
	}
}
