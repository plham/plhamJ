package samples.TradingHalt;
import x10.util.ArrayList;
import x10.util.List;
import x10.util.StringUtil;
import plham.Agent;
import plham.Event;
import plham.Market;
import plham.event.FundamentalPriceShock;
import plham.event.TradingHaltRule;
import plham.util.JSON;
import plham.util.JSONRandom;
import samples.CI2002.CI2002Main;
import plham.main.SequentialRunner;
import plham.agent.FCNAgent;

public class TradingHaltMain extends CI2002Main {

	public static def main(args:Rail[String]) {
		val sim = new TradingHaltMain();
		FCNAgent.register(sim);
		Market.register(sim);
		FundamentalPriceShock.register(sim);
		TradingHaltRule.register(sim);
		new SequentialRunner(sim).run(args);
	}

	public def print(sessionName:String) {
		val markets = getMarketsByName("markets");
		val agents = getAgentsByName("agents");
		for (market in markets) {
			val t = market.getTime();
			Console.OUT.println(StringUtil.formatArray([
				sessionName,
				t, 
				market.id,
				market.name,
				market.getPrice(t),
				market.getFundamentalPrice(t),
				market.isRunning(),
				"", ""], " ", "", Int.MAX_VALUE));
		}
	}
}
