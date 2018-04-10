package plham.util;

import java.io.Serializable;

/**
 * A generator class for markets. This class generates markets. All of them have
 * the same 'base' configuration. example: ```json "SpotMarket":{ "class":
 * "Market", "tickSize": 0.00001, "marketPrice": 300.0, "outstandingShares":
 * 25000 }, "SpotMarket-N": { "class": "MarketGenerator", "prefix":
 * "SpotMarket-", "from": 1, "to": 2, "base": { "extends": "SpotMarket" } }, ```
 * This example generates 2 markets "SpotMarket-1" and "SpotMarket-2", whose
 * config is the same as "SpotMarket", and a market group named "SpotMarket-N"
 * which contains both markets.
 */

public class SimpleMarketGenerator implements Serializable {
	private static final long serialVersionUID = -3075666505766941755L;
	/*
	public static def register(sim:Simulator):void {
		val className = "SimpleMarketGenerator";
		sim.addMarketGenerator(className, (json:JSON.Value):List[JSON.Value] => {
			assert json.has("prefix");
			assert json.has("from");
			assert json.has("to");
			assert json.has("base");
			val prefix = json("prefix").toString();
			val from = json("from").toLong();
			val to = json("to").toLong();
			val base = json("base");
			val ret = new ArrayList[JSON.Value]();
			val n = to - from;
			for (i in 0 .. n) {
				val id = i + from;
				val name = prefix + id;
				val generated = base.apply("name", new JSON.Value(name));
				ret.add(generated);
			}
			return ret as List[JSON.Value];
		});
	}
	 */

}
