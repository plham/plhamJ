package plham.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cassia.util.JSON;
import plham.Market;
import plham.main.Simulator;
import plham.model.AgentGenerator;

public class AgentGeneratorForEachMarket implements Serializable {
	private static final long serialVersionUID = -8463271501350460315L;

	/*
	public static def register(sim:Simulator):void {
		val className = "AgentGeneratorForEachMarket";
		sim.addAgentGenerator(className, (json:JSON.Value):List[JSON.Value] => {
			assert(json.has("markets"));
			val markets = new ArrayList[Market]();
			val marketNames = json("markets").asList();
			for (marketName in marketNames) { // marketName :: JSON.Value
				val name = marketName.toString();
				markets.addAll(sim.getMarketsByName(name));
			}
			assert(json.has("base"));
			val agentConfigs = new ArrayList[JSON.Value]();
			for (market in markets) {
				val agentConfig = json("base").apply([
					new JSON.Entry(
						"accessibleMarkets",
						JSON.parse("[" + market.name + "]")
					) as JSON.Entry,
					new JSON.Entry(
						"markets",
						JSON.parse("[" + market.name + "]")
					)
				] as Rail[JSON.Entry]);
				agentConfigs.add(agentConfig);
			}
			return agentConfigs as List[JSON.Value];
		});
	}
	*/

	public static void register(Simulator sim) {
		String className = "AgentGeneratorForEachMarket";
		sim.addAgentGenerator(className, new AgentGenerator() {
			private static final long serialVersionUID = -4304199503369909935L;

			public List<JSON.Value> generate(JSON.Value json) {
				assert (json.has("markets"));
				List<Market> markets = new ArrayList<Market>();
				JSON.Value marketNames = json.get("markets");
				for (JSON.Value marketName : marketNames.asList()) { // marketName
																		// ::
																		// JSON.Value
					String name = marketName.toString();
					markets.addAll(sim.getMarketsByName(name));
				}
				assert (json.has("base"));
				List<JSON.Value> agentConfigs = new ArrayList<JSON.Value>();
				for (Market market : markets) {
					List<JSON.Entry> l = new ArrayList<JSON.Entry>();
					l.add(new JSON.Entry("accessibleMarkets", JSON.parse("["
							+ market.name + "]")));
					l.add(new JSON.Entry("markets", JSON.parse("["
							+ market.name + "]")));

					JSON.Value agentConfig = json.get("base").apply(l);
					agentConfigs.add(agentConfig);
				}
				return agentConfigs;
			}
		});
	}
}
