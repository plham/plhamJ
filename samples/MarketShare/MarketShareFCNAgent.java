package samples.MarketShare;

import java.util.ArrayList;
import java.util.List;

import cassia.util.JSON;
import cassia.util.JSON.Value;
import plham.Agent;
import plham.Market;
import plham.Order;
import plham.agent.FCNAgent;
import plham.main.Simulator;
import plham.model.AgentInitializer;
import plham.util.Random;
import plham.util.Statistics;


public class MarketShareFCNAgent extends FCNAgent {
	private static final long serialVersionUID = -8791648119282933905L;

	/*
	public def this(id:Long, name:String, random:Random) = super(id, name, random);
	*/
	public MarketShareFCNAgent(long id, String name, Random random) {
		super(id, name, random);
	}

	/*
	public def setup(json:JSON.Value, sim:Simulator):MarketShareFCNAgent = super.setup(json, sim) as MarketShareFCNAgent;
	*/
	@Override
	public MarketShareFCNAgent setup(JSON.Value json, Simulator sim) {
		return (MarketShareFCNAgent) super.setup(json, sim);
	}

	/*
	public static def register(sim:Simulator):void {
		val className = "MarketShareFCNAgent";
		sim.addAgentInitializer(className,
			(
				id:Long,
				name:String, 
				random:Random,
				json:JSON.Value
			) => {
				return new MarketShareFCNAgent(id, name, random).setup(json, sim);
			}
		);
	}
	*/
	public static void register(Simulator sim) {
		String className = "MarketShareFCNAgent";
		sim.addAgentInitializer(className, new AgentInitializer() {
			public Agent initialize(long id, String name, Random random,
					Value json) {
				return new MarketShareFCNAgent(id, name, random).setup(json,
						sim);
			}
		});
	}

	/*
	public def submitOrders(var markets:List[Market]):List[Order] {
		markets = filterMarkets(markets);
		val weights = new ArrayList[Double]();
		for (m in markets) {
			weights.add(getSumTradeVolume(m));
		}
		val k = Statistics.roulette(getRandom(), weights);
		return super.submitOrders(markets(k));
	}
	*/
	@Override
	public List<Order> submitOrders(List<Market> original) {
		List<Market> markets = filterMarkets(original);
		List<Double> weights = new ArrayList<Double>();
		for (Market m : markets) {
			weights.add(Double.valueOf(getSumTradeVolume(m)));
		}
		long k = Statistics.roulette(getRandom(), weights);
		return super.submitOrders(markets.get((int) k));
	}

	/*
	public def getSumTradeVolume(market:Market):Long {
		val t = market.getTime();
		val timeWindowSize = Math.min(t, this.timeWindowSize);
		var volume:Long = 0;
		for (d in 1..timeWindowSize) {
			volume += market.getTradeVolume(t - d);
		}
		return volume;
	}
	*/
	@SuppressWarnings("hiding")
	public long getSumTradeVolume(Market market) {
		long t = market.getTime();
		long timeWindowSize = Math.min(t, this.timeWindowSize);
		long volume = 0;
		for (long d = 1; d <= timeWindowSize; d++) {
			volume += market.getTradeVolume(t - d);
		}
		return volume;
	}

	/*
	public def filterMarkets(markets:List[Market]):List[Market] {
		val a = new ArrayList[Market]();
		for (market in markets) {
			if (this.isMarketAccessible(market)) {
				a.add(market);
			}
		}
		return a;
	}
	*/
	public List<Market> filterMarkets(List<Market> markets) {
		List<Market> a = new ArrayList<Market>();
		for (Market market : markets) {
			if (this.isMarketAccessible(market)) {
				a.add(market);
			}
		}
		return a;
	}
}
