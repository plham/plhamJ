package plham;

import java.util.List;

import plham.main.SequentialRunner;
import plham.main.Simulator;

/**
 * The base class for user-defined <q>main</q> classes. See the
 * <code>samples</code> to know how to extend this class.
 */
public class Main extends Simulator {
	/*
	public static def main(args:Rail[String]) {
		val sim = new Main();
		new SequentialRunner[Main](sim).run(args);
	}
	 */
	public static void main(String args[]) {
		Simulator sim = new Main();
		new SequentialRunner<Main>(sim).run(args);
	}

	/*
	public def beginSimulation() {}
	 */
	@Override
	public void beginSimulation() {
		// do nothing;
	}

	/*
	public def endSimulation() {}
	 */
	@Override
	public void endSimulation() {
		// do nothing;
	}

	/*
	public def beginSession(sessionName:String) {}
	 */
	@Override
	public void beginSession(String sessionName) {
		// do nothing;
	}

	/*
	public def endSession(sessionName:String) {}
	 */
	@Override
	public void endSession(String endSession) {
		// do nothing;
	}

	/*
	public def endprint(sessionName:String,iterationSteps:Long) {

	}
	 */
	@Override
	public void endprint(String sessionName, long iterationSteps) {
		// do nothing
	}

	/*
	public def print(sessionName:String) {
		val markets = getMarketsByName("markets") as List[Market];
		for (market in markets) {
			val t = market.getTime();
			Console.OUT.println(StringUtil.formatArray([
				sessionName,
				t, 
				market.id,
				market.name,
				market.getPrice(t),
				market.getFundamentalPrice(t),
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
			System.out.println(String.format("%s %s %s %s %s %s  ", sessionName,
					t, market.id, market.name, market.getPrice(t),
					market.getFundamentalPrice(t)));
		}
	}
}
