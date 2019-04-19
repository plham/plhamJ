package plham.util;

import java.io.Serializable;

public class RandomOrderGenerator implements Serializable {
	private static final long serialVersionUID = -2553437044799975522L;

	/*
	public var random:Random;
	public var nextPrice:(Double)=>Double;
	public var nextVolume:()=>Long;
	public var nextTimeLength:()=>Long;

	public def this(nextPrice:(Double)=>Double, nextVolume:()=>Long, nextTimeLength:()=>Long) {
		this.nextPrice = nextPrice;
		this.nextVolume = nextVolume;
		this.nextTimeLength = nextTimeLength;
	}

	public def get(market:Market, agent:Agent):Order {
		val middlePrice = market.getPrice();
		val price = this.nextPrice(middlePrice);
		val volume = this.nextVolume();
		val timeLength = this.nextTimeLength();
		if (price < middlePrice) {
			return new Order(Order.KIND_BUY_LIMIT_ORDER, agent, market, price, volume, timeLength);
		} else {//if (price > middlePrice) {
			return new Order(Order.KIND_SELL_LIMIT_ORDER, agent, market, price, volume, timeLength);
		}
	}

	public def get(market:Market, nextAgent:()=>Agent, N:Long):List[Order] {
		val random = this.random;
		val orders = new ArrayList[Order]();
		for (i in 0..(N - 1)) {
			val agent = nextAgent();
			orders.add(this.get(market, agent));
		}
		return orders;
	}
	*/

	/*
	public static def main(args:Rail[String]) {

		val random = new RandomHelper(new Random()); // MEMO: main()

		val market = new Market(-1);
		market.setInitialMarketPrice(300.0);
		
		val rog = new RandomOrderGenerator(
				(p:Double) => Math.max(0.0, p + random.nextGaussian() * 10),
				() => 1,
				() => random.nextLong(100) + 10);

		val agent = new TestAgent(-1);

		for (order in rog.get(market, () => agent, 100)) {
			Console.OUT.println(order);
		}
	}
	*/

}
