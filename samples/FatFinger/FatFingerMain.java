package samples.FatFinger;

import java.util.List;

import plham.Market;
import plham.agent.FCNAgent;
import plham.event.OrderMistakeShock;
import plham.main.SequentialRunner;
import samples.CI2002.CI2002Main;

public class FatFingerMain extends CI2002Main {

	/*
	public static def main(args:Rail[String]) {
		val sim = new FatFingerMain();
		FCNAgent.register(sim);
		Market.register(sim);
		OrderMistakeShock.register(sim);
		new SequentialRunner(sim).run(args);
	}
	*/
	public static void main(String[] args) {
		final FatFingerMain sim = new FatFingerMain();
		FCNAgent.register(sim);
		Market.register(sim);
		OrderMistakeShock.register(sim);
		final SequentialRunner<FatFingerMain> runner = new SequentialRunner<FatFingerMain>(
				sim);
		runner.run(args);
	}

	/*
	public def print(sessionName:String) {
		super.print(sessionName);
		val markets = getMarketsByName("markets");
		for (market in markets) {
			market.getBuyOrderBook().dump();
			market.getSellOrderBook().dump();
		}
	}
	*/
	@Override
	@SuppressWarnings("hiding")
	public void print(String sessionName) {
		super.print(sessionName);
		List<Market> markets = getMarketsByName("markets");
		for (Market market : markets) {
			market.getBuyOrderBook().dump();
			market.getSellOrderBook().dump();
		}
	}
}
