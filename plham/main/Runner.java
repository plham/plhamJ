package plham.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cassia.util.random.RandomPermutation;
import plham.Agent;
import plham.Env;
import plham.Fundamentals;
import plham.IndexMarket;
import plham.Market;
import plham.Order;
import plham.agent.FCNAgent;
import plham.event.FundamentalPriceShock;
import plham.event.OrderMistakeShock;
import plham.event.PriceLimitRule;
import plham.event.TradingHaltRule;
import samples.ShockTransfer.ArbitrageAgent;

/**
 * A base class for execution models. See {@link plham.main.Simulator} for
 * simulation models. This class is basically for system developers.
 */
@SuppressWarnings("hiding")
public abstract class Runner<T> implements Serializable {

	private static final long serialVersionUID = 4487185718113921593L;

	/*
	public var _PROFILE:Boolean = false;
	public static val useTeam:Boolean = true;
	protected static val HIFREQ_SUBMIT_RATE = System.getenv("HIFREQ_SUBMIT_RATE") != null ? Double.parse(System.getenv("HIFREQ_SUBMIT_RATE")) : 1.0;
	 */
	public boolean _PROFILE = false;
	public static boolean useTeam = true;
	protected static double HIFREQ_SUBMIT_RATE = System
			.getenv("HIFREQ_SUBMIT_RATE") != null ? Double.parseDouble(System
			.getenv("HIFREQ_SUBMIT_RATE")) : 1.0d;

	/*
	var sim:B;
	public def env():Env = this.sim;
	public def this(sim:B) {
		this.sim = sim;
		FCNAgent.register(sim);
		ArbitrageAgent.register(sim);
		Market.register(sim);
		IndexMarket.register(sim);
		FundamentalPriceShock.register(sim);
		OrderMistakeShock.register(sim);
		TradingHaltRule.register(sim);
		PriceLimitRule.register(sim);
	}
	*/

	Simulator sim;

	public Simulator env() {
		return this.sim;
	}

	public Runner(Simulator sim) {
		this.sim = sim;
		FCNAgent.register(sim);
		ArbitrageAgent.register(sim);
		Market.register(sim);
		IndexMarket.register(sim);
		FundamentalPriceShock.register(sim);
		OrderMistakeShock.register(sim);
		TradingHaltRule.register(sim);
		PriceLimitRule.register(sim);
	}

	/*
	public def handleOrders(localOrders:List[List[Order]], MAX_HIFREQ_ORDERS:Long):List[List[Order]] {
		val env = this.env();
		val beginTime = System.nanoTime();
		val allOrders = new ArrayList[List[Order]]();
		val markets = env.markets;

		val random = sim.getRandom();
		val tmpRandom = new Random(System.nanoTime());
	    val agents = env.hifreqAgents; 
		val randomAgents = new RandomPermutation[Agent](random, agents);
		val randomOrders = new RandomPermutation[List[Order]](random, localOrders);

		randomOrders.shuffle();
		for (someOrders in randomOrders) {
			// This handles one order-list submitted by an agent per loop.
			// TODO: If needed, one-market one-order handling.
			for (order in someOrders) {
				val m = env.markets(order.marketId);
				m.triggerBeforeOrderHandlingEvents(order);
				m.handleOrder(order); // NOTE: DO it now.
				m.triggerAfterOrderHandlingEvents(order);
				m.tickUpdateMarketPrice();
			}

			if (HIFREQ_SUBMIT_RATE < tmpRandom.nextDouble()) {
				continue;
			}

			var k:Long = 0;
			randomAgents.shuffle();
			for (agent in randomAgents) {
				if (k >= MAX_HIFREQ_ORDERS) {
					break;
				}
				val orders = agent.submitOrders(markets);
				if(!orders.isEmpty()) allOrders.add(orders);

				if (orders.size() > 0) {
					for (order in orders) {
						val m = env.markets(order.marketId);
						m.triggerBeforeOrderHandlingEvents(order);
						m.handleOrder(order);
						m.triggerAfterOrderHandlingEvents(order);
						m.tickUpdateMarketPrice();
					}
					k++;
				}
			}
		}

		val endTime = System.nanoTime();
		if (_PROFILE) {
			Console.OUT.println("#PROFILE ORDER-EXEC TOTAL " + ((endTime - beginTime) / 1e+9) + " sec");
			Console.OUT.println("#PROFILE MAX-HIFREQ-ORDERS " + MAX_HIFREQ_ORDERS + " x " + localOrders.size());
			Console.OUT.println("#PROFILE NUM-HIFREQ-ORDERS " + allOrders.size());
		}
		return allOrders;
	}
	*/
	public List<List<Order>> handleOrders(List<List<Order>> localOrders,
			long MAX_HIFREQ_ORDERS) {
		Env env = this.env();
		long beginTime = System.nanoTime();
		List<List<Order>> allOrders = new ArrayList<List<Order>>();
		List<Market> markets = env.markets;

		Random random = sim.getRandom();
		Random tmpRandom = new Random(System.nanoTime());
		List<Agent> agents = env.hifreqAgents;
		RandomPermutation<Agent> randomAgents = new RandomPermutation<Agent>(
				random, agents);
		RandomPermutation<List<Order>> randomOrders = new RandomPermutation<List<Order>>(
				random, localOrders);

		randomOrders.shuffle();
		for (List<Order> someOrders : randomOrders) {
			// This handles one order-list submitted by an agent per loop.
			// TODO: If needed, one-market one-order handling.
			for (Order order : someOrders) {
				Market m = env.markets.get(((int) order.marketId));
				m.triggerBeforeOrderHandlingEvents(order);
				m.handleOrder(order); // NOTE: DO it now.
				m.triggerAfterOrderHandlingEvents(order);
				m.tickUpdateMarketPrice();
			}

			if (HIFREQ_SUBMIT_RATE < tmpRandom.nextDouble()) {
				continue;
			}

			long k = 0;
			randomAgents.shuffle();
			for (Agent agent : randomAgents) {
				if (k >= MAX_HIFREQ_ORDERS) {
					break;
				}
				List<Order> orders = agent.submitOrders(markets);
				if (!orders.isEmpty())
					allOrders.add(orders);

				if (orders.size() > 0) {
					for (Order order : orders) {
						Market m = env.markets.get((int) order.marketId);
						m.triggerBeforeOrderHandlingEvents(order);
						m.handleOrder(order);
						m.triggerAfterOrderHandlingEvents(order);
						m.tickUpdateMarketPrice();
					}
					k++;
				}
			}
		}

		long endTime = System.nanoTime();
		if (_PROFILE) {
			// do nothing
		}
		return allOrders;
	}

	/*
	def syncCheck(markets:List[Market]) {
		val env = this.env();
		val N_PLACES = Place.numPlaces(); 
		for (m in markets) {
			val id = m.id;
			val price = env.markets(id).getPrice();
			val size = env.markets(id).marketPrices.size();
			val time = env.markets(id).getTime();
		}
		Console.OUT.println("#SyncCheck: OK");
	}
	*/
	public void syncCheck(List<Market> markets) {
		Simulator env = this.env();
		/*
		val N_PLACES = Place.numPlaces(); 
		for (m in markets) {
			val id = m.id;
			val price = env.markets(id).getPrice();
			val size = env.markets(id).marketPrices.size();
			val time = env.markets(id).getTime();
		}
		*/
	}

	/*
	public abstract def updateMarkets(maxNormalOrders:Long, maxHifreqOrders:Long, 
			diffPass:Boolean): void; 
	*/
	public abstract List<List<Order>> updateMarkets(long maxNormalOrders,
			long maxHifreqOrders, boolean diffPass);

	/*
	public def iterateMarketUpdates(sessionName:String, iterationSteps:Long,
			withOrderPlacement:Boolean, withOrderExecution:Boolean, withPrint:Boolean, forDummyTimeseries:Boolean,
			maxNormalOrders:Long, maxHifreqOrders:Long,
			fundamentals:Fundamentals) {
		//Console.OUT.println("#hoge1-1");
		val env = this.env();
		val markets = env.markets;  
		for (market in markets) {
			market.setRunning(withOrderExecution);
		}
		for (market in markets) {
	//			market.cleanOrderBooks(market.getPrice()); // Better to use plham.util.Itayose?
			market.itayoseOrderBooks();
		}
		for (market in markets) {
			market.check();
		}
		//Console.OUT.println("#hoge1-2SessionName:"+sessionName+",itestep:"+iterationSteps+",withplacement:"+withOrderPlacement);
		for (t in 1..iterationSteps) {
			sim.updateFundamentals(fundamentals);
			for (market in markets) {
				market.triggerBeforeSimulationStepEvents(); // Assuming the markets in dependency order.
			}
			//Console.OUT.println("#hoge1-3:t="+t);
			if (withOrderPlacement) {
				updateMarkets(maxNormalOrders, maxHifreqOrders, t > 0);
			}
			//Console.OUT.println("#hoge1-4");			
			if (forDummyTimeseries) {
				sim.updateMarketsUsingFundamentalPrice(markets, fundamentals);
			} else {
				sim.updateMarketsUsingMarketPrice(markets, fundamentals);
			}
			//Console.OUT.println("#hoge1-5");
			if (withPrint) {
				sim.print(sessionName);
			}
			//Console.OUT.println("#hoge1-6");
			for (market in markets) {
				market.triggerAfterSimulationStepEvents();
			}
			//Console.OUT.println("#hoge1-7");			
			for (market in markets) {
				market.updateTime();
				market.updateOrderBooks();
			}
			//Console.OUT.println("#hoge1-8");
		}
		if (withPrint) {
			sim.endprint(sessionName,iterationSteps);
		}
	}
	 */
	public void iterateMarketUpdates(String sessionName, long iterationSteps,
			boolean withOrderPlacement, boolean withOrderExecution,
			boolean withPrint, boolean forDummyTimeseries,
			long maxNormalOrders, long maxHifreqOrders,
			Fundamentals fundamentals) {
	}

	/*
	public def setupEnv(markets:List[Market], agents:List[Agent]) {
		val env = this.env();
		val normalAgents = new ArrayList[Agent]();
		val hifreqAgents = new ArrayList[Agent]();
		for (a in agents) {
			if (a instanceof HighFrequencyAgent) {
				hifreqAgents.add(a);
			} else {
				normalAgents.add(a);
			}
		}

		for (m in markets) { m.env = env; }
		env.markets = markets;
		env.agents = agents;
		env.normalAgents = normalAgents;
		env.hifreqAgents = hifreqAgents;
	}
	 */
	public void setupEnv(List<Market> markets, List<Agent> agents) {

	}

	/*
	public def run(args:Rail[String]) {
		if (args.size < 1) {
			throw new Exception("Usage: ./a.out config.json [SEED]");
		}

		val seed:Long;
		if (args.size > 1) {
			seed = Long.parse(args(1));
		} else {
			seed = new Random().nextLong(Long.MAX_VALUE / 2); // MEMO: main()
		}

		Console.OUT.println("# X10_NPLACES  " + Env.getenvOrElse("X10_NPLACES", ""));
		Console.OUT.println("# X10_NTHREADS " + Env.getenvOrElse("X10_NTHREADS", ""));

		val TIME_THE_BEGINNING = System.nanoTime();

		val GLOBAL = new HashMap[String,Any]();
		sim.GLOBAL = GLOBAL;
		val CONFIG = JSON.parse(new File(args(0)));
		sim.CONFIG = CONFIG;
		JSON.extendDeeply(CONFIG, CONFIG);

		val RANDOM = new Random(seed);
		sim.RANDOM = RANDOM;
		Console.OUT.println("# Random.seed " + seed);

		//////// MARKETS INSTANTIATION ////////

		val markets = sim.createAllMarkets(CONFIG("simulation")("markets"));
		//TODO
		val mrange = new ArrayList[LongRange](); mrange.add(0..(markets.size()-1));
		sim.marketName2Ranges("markets") = mrange;

		Console.OUT.println("# #(markets) " + markets.size());

		//////// AGENTS INSTANTIATION ////////
		val dm = new CentricAllocManager[Agent]();
		sim.createAllAgents(CONFIG("simulation")("agents"), dm);
		GLOBAL("agents") = dm.getBody();

		//////// MULTIVARIATE GEOMETRIC BROWNIAN ////////

		val fundamentals = sim.createFundamentals(markets, CONFIG("simulation")("fundamentalCorrelations", "{}"));
		//val fundamentals = sim.createFundamentals(CONFIG("simulation")("fundamentalCorrelations", "{}"), CONFIG("simulation")("markets"));
		GLOBAL("fundamentals") = fundamentals as Any;

		//////// SERIAL/PARALLEL ENV SETUP ////////

		setupEnv(markets, dm.getBody()); // TODObyTK

		//Console.OUT.println("# #(agents) " + agents.size());
		//Console.OUT.println("# #(hifreqAgents) " + env().hifreqAgents.size());

		//////// MAIN SIMULATION PROCEDURE ////////

		sim.beginSimulation();

		val sessions = CONFIG("simulation")("sessions");
		for (i in 0..(sessions.size() - 1)) {

		Console.OUT.println("------------Session "+i+" Start@"+here);
			val json = sessions(i);
			val sessionName = json("sessionName").toString();
			val iterationSteps:Long;
			if(json.has("iterationSteps")){
				iterationSteps = json("iterationSteps").toLong();
			}else{
				iterationSteps = json("iterationDays").toLong()*CONFIG("numStepsOneDay").toLong();
			}

			val withOrderPlacement = json("withOrderPlacement").toBoolean();
			val withOrderExecution = json("withOrderExecution").toBoolean();
			val withPrint = json("withPrint", "true").toBoolean();
			var forDummyTimeseries:boolean = (!withOrderPlacement && !withOrderExecution);
			if (json.has("forDummyTimeseries")) {
				forDummyTimeseries = json("forDummyTimeseries").toBoolean();
			}
			val maxNormalOrders = json("maxNormalOrders", markets.size().toString()).toLong();
			val maxHifreqOrders = json("maxHifreqOrders", "0").toLong();

			if (true) {
				Console.OUT.println("# SESSION: " + sessionName);
				Console.OUT.println("# iterationSteps: " + iterationSteps);
				Console.OUT.println("# withOrderPlacement: " + withOrderPlacement);
				Console.OUT.println("# withOrderExecution: " + withOrderExecution);
				Console.OUT.println("# withPrint: " + withPrint);
				Console.OUT.println("# forDummyTimeseries: " + forDummyTimeseries);
				Console.OUT.println("# maxNormalOrders: " + maxNormalOrders);
				Console.OUT.println("# maxHifreqOrders: " + maxHifreqOrders);
			}

			GLOBAL("events") = null;
			if (json.has("events")) {
				val events = sim.createAllEvents(json("events"));
				GLOBAL("events") = events;
			}
			//Console.OUT.println("#hoge0");
			sim.beginSession(sessionName);
			//Console.OUT.println("#hoge1");
			iterateMarketUpdates(
					sessionName, iterationSteps,
					withOrderPlacement, withOrderExecution, withPrint, forDummyTimeseries,
					maxNormalOrders, maxHifreqOrders,
					fundamentals);
			//Console.OUT.println("#hoge2");			
			sim.endSession(sessionName);
			//Console.OUT.println("#hoge3");
		}
		sim.endSimulation();

		val TIME_THE_END = System.nanoTime();
		Console.OUT.println("# TIME " + ((TIME_THE_END - TIME_THE_BEGINNING) / 1e+9));
	}
	 */
	public void run(String[] args) {
	}
}
