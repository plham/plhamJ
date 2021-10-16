package plham.core.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cassia.util.JSON;
import plham.core.Market;
import plham.core.main.SimulatorFactory;
import plham.core.model.AgentGenerator;

public class AgentGeneratorForEachMarket implements Serializable {
    private static final long serialVersionUID = -8463271501350460315L;

    public static void register(SimulatorFactory sim) {
        String className = "AgentGeneratorForEachMarket";
        sim.addAgentGenerator(className, new AgentGenerator() {
            private static final long serialVersionUID = -4304199503369909935L;

            @Override
            public List<JSON.Value> generate(JSON.Value json) {
                assert (json.has("markets"));
                List<Market> markets = new ArrayList<>();
                JSON.Value marketNames = json.get("markets");
                for (JSON.Value marketName : marketNames.asList()) { // marketName
                                                                     // ::
                                                                     // JSON.Value
                    String name = marketName.toString();
                    markets.addAll(sim.getSimulatorInConstruction().getMarketsByName(name));
                }
                assert (json.has("base"));
                List<JSON.Value> agentConfigs = new ArrayList<>();
                for (Market market : markets) {
                    List<JSON.Entry> l = new ArrayList<>();
                    l.add(new JSON.Entry("accessibleMarkets", JSON.parse("[" + market.name + "]")));
                    l.add(new JSON.Entry("markets", JSON.parse("[" + market.name + "]")));

                    JSON.Value agentConfig = json.get("base").apply(l);
                    agentConfigs.add(agentConfig);
                }
                return agentConfigs;
            }
        });
    }
}
