package samples.ShockTransfer;

import java.util.List;

import plham.IndexMarket;
import plham.Market;
import plham.agent.FCNAgent;
import plham.event.FundamentalPriceShock;
import plham.main.SequentialRunner;
import plham.util.AgentGeneratorForEachMarket;
import plham.util.SimpleMarketGenerator;
import samples.CI2002.CI2002Main;

public class ShockTransferMain extends CI2002Main {
	/*
	public static def main(args:Rail[String]) {
		val sim = new ShockTransferMain();
		FCNAgent.register(sim);
		Market.register(sim);
		ArbitrageAgent.register(sim);
		IndexMarket.register(sim);
		SimpleMarketGenerator.register(sim);
		AgentGeneratorForEachMarket.register(sim);
		FundamentalPriceShock.register(sim);
		new SequentialRunner(sim).run(args);
	}
	*/
	public static void main(String[] args) {
		final ShockTransferMain sim = new ShockTransferMain();
		FCNAgent.register(sim);
		Market.register(sim);
		ArbitrageAgent.register(sim);
		IndexMarket.register(sim);
		SimpleMarketGenerator.register(sim);
		AgentGeneratorForEachMarket.register(sim);
		FundamentalPriceShock.register(sim);
		final SequentialRunner<CI2002Main> runner = new SequentialRunner<CI2002Main>(
				sim);
		runner.run(args);
	}

	/*
	public def print(sessionName:String) {
		val markets = getMarketsByName("markets");
		for (market in markets) {
			val t = market.getTime();
			var marketIndex:Double = Double.NaN;
			if (market instanceof IndexMarket) {
				marketIndex = (market as IndexMarket).getIndex(t);
			}
			Console.OUT.println(StringUtil.formatArray([
				sessionName,
				t, 
				market.id,
				market.name,
				market.getPrice(t),
				market.getFundamentalPrice(t),
				marketIndex,
				"", ""], " ", "", Int.MAX_VALUE));
		}
	}
	*/
	@Override
	public void print(String sessionName) {
		@SuppressWarnings("hiding")
		List<Market> markets = getMarketsByName("markets");
		for (Market market : markets) {
			long t = market.getTime();
			double marketIndex = Double.NaN;
			if (market instanceof IndexMarket) {
				marketIndex = ((IndexMarket) market).getIndex(t);
			}
			System.out.println(String.format("%s %s %s %s %s %s %s  ",
					sessionName, t, market.id, market.name, market.getPrice(t),
					market.getFundamentalPrice(t), marketIndex));
		}
	}
}
