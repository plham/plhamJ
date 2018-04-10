package plham.main;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import plham.util.CentricAllocManager;
import plham.util.Random;
import cassia.util.JSON;
import cassia.util.random.RandomPermutation;
import plham.Agent;
import plham.Env;
import plham.Event;
import plham.Fundamentals;
import plham.HighFrequencyAgent;
import plham.IndexMarket;
import plham.Market;
import plham.Order;
import plham.agent.FCNAgent;
import plham.event.FundamentalPriceShock;
import plham.event.OrderMistakeShock;
import plham.event.PriceLimitRule;
import plham.event.TradingHaltRule;
import plham.util.RandomHelper;
import samples.ShockTransfer.ArbitrageAgent;
import x10.lang.LongRange;

/**
 * A base class for execution models. See {@link plham.main.Simulator} for
 * simulation models. This class is basically for system developers.
 */
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
			.getenv("HIFREQ_SUBMIT_RATE") != null ? Double.valueOf(System
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

	@SuppressWarnings("static-access")
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
			System.out.println("#PROFILE ORDER-EXEC TOTAL " + ((endTime - beginTime) / 1e+9) + " sec");
			System.out.println("#PROFILE MAX-HIFREQ-ORDERS " + MAX_HIFREQ_ORDERS + " x " + localOrders.size());
			System.out.println("#PROFILE NUM-HIFREQ-ORDERS " + allOrders.size());
		}
		return allOrders;
	}
	*/
	@SuppressWarnings("unused")
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
		System.out.println("#SyncCheck: OK");
	}
	*/
	@SuppressWarnings("unused")
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
		//System.out.println("#hoge1-1");
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
		//System.out.println("#hoge1-2SessionName:"+sessionName+",itestep:"+iterationSteps+",withplacement:"+withOrderPlacement);
		for (t in 1..iterationSteps) {
			sim.updateFundamentals(fundamentals);
			for (market in markets) {
				market.triggerBeforeSimulationStepEvents(); // Assuming the markets in dependency order.
			}
			//System.out.println("#hoge1-3:t="+t);
			if (withOrderPlacement) {
				updateMarkets(maxNormalOrders, maxHifreqOrders, t > 0);
			}
			//System.out.println("#hoge1-4");			
			if (forDummyTimeseries) {
				sim.updateMarketsUsingFundamentalPrice(markets, fundamentals);
			} else {
				sim.updateMarketsUsingMarketPrice(markets, fundamentals);
			}
			//System.out.println("#hoge1-5");
			if (withPrint) {
				sim.print(sessionName);
			}
			//System.out.println("#hoge1-6");
			for (market in markets) {
				market.triggerAfterSimulationStepEvents();
			}
			//System.out.println("#hoge1-7");			
			for (market in markets) {
				market.updateTime();
				market.updateOrderBooks();
			}
			//System.out.println("#hoge1-8");
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
		Env env = this.env();
		List<Market> markets = env.markets;
		for (Market market : markets) {
			market.setRunning(withOrderExecution);
		}
		for (Market market : markets) {
			market.itayoseOrderBooks();
		}
		for (Market market : markets) {
			market.check();
		}
		// System.out.println("#hoge1-2SessionName:"+sessionName+",itestep:"+iterationSteps+",withplacement:"+withOrderPlacement);
		for (long t = 1; t < iterationSteps; t++) {
			sim.updateFundamentals(fundamentals);
			for (Market market : markets) {
				market.triggerBeforeSimulationStepEvents(); // Assuming the
															// markets in
															// dependency order.
			}
			// System.out.println("#hoge1-3:t="+t);
			if (withOrderPlacement) {
				updateMarkets(maxNormalOrders, maxHifreqOrders, t > 0);
			}
			// System.out.println("#hoge1-4");
			if (forDummyTimeseries) {
				sim.updateMarketsUsingFundamentalPrice(markets, fundamentals);
			} else {
				sim.updateMarketsUsingMarketPrice(markets, fundamentals);
			}
			// System.out.println("#hoge1-5");
			if (withPrint) {
				sim.print(sessionName);
			}
			// System.out.println("#hoge1-6");
			for (Market market : markets) {
				market.triggerAfterSimulationStepEvents();
			}
			// System.out.println("#hoge1-7");
			for (Market market : markets) {
				market.updateTime();
				market.updateOrderBooks();
			}
			// System.out.println("#hoge1-8");
		}
		if (withPrint) {
			sim.endprint(sessionName, iterationSteps);
		}
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
		Env env = this.env();
		List<Agent> normalAgents = new ArrayList<Agent>();
		List<Agent> hifreqAgents = new ArrayList<Agent>();
		for (Agent agent : agents) {
			if (agent instanceof HighFrequencyAgent) {
				hifreqAgents.add(agent);
			} else {
				normalAgents.add(agent);
			}
		}

		for (Market market : markets) {
			market.env = env;
		}
		env.markets = markets;
		env.agents = agents;
		env.normalAgents = normalAgents;
		env.hifreqAgents = hifreqAgents;
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

		System.out.println("# X10_NPLACES  " + Env.getenvOrElse("X10_NPLACES", ""));
		System.out.println("# X10_NTHREADS " + Env.getenvOrElse("X10_NTHREADS", ""));

		val TIME_THE_BEGINNING = System.nanoTime();

		val GLOBAL = new HashMap[String,Any]();
		sim.GLOBAL = GLOBAL;
		val CONFIG = JSON.parse(new File(args(0)));
		sim.CONFIG = CONFIG;
		JSON.extendDeeply(CONFIG, CONFIG);

		val RANDOM = new Random(seed);
		sim.RANDOM = RANDOM;
		System.out.println("# Random.seed " + seed);

		//////// MARKETS INSTANTIATION ////////

		val markets = sim.createAllMarkets(CONFIG("simulation")("markets"));
		//TODO
		val mrange = new ArrayList[LongRange](); mrange.add(0..(markets.size()-1));
		sim.marketName2Ranges("markets") = mrange;

		System.out.println("# #(markets) " + markets.size());

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

		//System.out.println("# #(agents) " + agents.size());
		//System.out.println("# #(hifreqAgents) " + env().hifreqAgents.size());

		//////// MAIN SIMULATION PROCEDURE ////////

		sim.beginSimulation();

		val sessions = CONFIG("simulation")("sessions");
		for (i in 0..(sessions.size() - 1)) {

		System.out.println("------------Session "+i+" Start@"+here);
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
				System.out.println("# SESSION: " + sessionName);
				System.out.println("# iterationSteps: " + iterationSteps);
				System.out.println("# withOrderPlacement: " + withOrderPlacement);
				System.out.println("# withOrderExecution: " + withOrderExecution);
				System.out.println("# withPrint: " + withPrint);
				System.out.println("# forDummyTimeseries: " + forDummyTimeseries);
				System.out.println("# maxNormalOrders: " + maxNormalOrders);
				System.out.println("# maxHifreqOrders: " + maxHifreqOrders);
			}

			GLOBAL("events") = null;
			if (json.has("events")) {
				val events = sim.createAllEvents(json("events"));
				GLOBAL("events") = events;
			}
			//System.out.println("#hoge0");
			sim.beginSession(sessionName);
			//System.out.println("#hoge1");
			iterateMarketUpdates(
					sessionName, iterationSteps,
					withOrderPlacement, withOrderExecution, withPrint, forDummyTimeseries,
					maxNormalOrders, maxHifreqOrders,
					fundamentals);
			//System.out.println("#hoge2");			
			sim.endSession(sessionName);
			//System.out.println("#hoge3");
		}
		sim.endSimulation();

		val TIME_THE_END = System.nanoTime();
		System.out.println("# TIME " + ((TIME_THE_END - TIME_THE_BEGINNING) / 1e+9));
	}
	 */
	public void run(String[] args) {
		if (args.length < 1) {
			throw new RuntimeException("Usage: ./a.out config.json [SEED]");
		}

		long seed;
		if (args.length > 1) {
			seed = Long.valueOf(args[1]);
		} else {
			Random random = new Random();
			RandomHelper helper = new RandomHelper(random);
			seed = helper.nextLong(Long.MAX_VALUE / 2); // MEMO: main()
		}

		System.out.println("# X10_NPLACES  "
				+ Env.getEnvOrElse("X10_NPLACES", ""));
		System.out.println("# X10_NTHREADS "
				+ Env.getEnvOrElse("X10_NTHREADS", ""));

		long TIME_THE_BEGINNING = System.nanoTime();

		Map<String, Object> GLOBAL = new HashMap<String, Object>();
		sim.GLOBAL = GLOBAL;
		JSON.Value CONFIG = JSON.parse(new File(args[0]));
		sim.CONFIG = CONFIG;
		JSON.extendDeeply(CONFIG, CONFIG);

		Random RANDOM = new Random(seed);
		sim.RANDOM = RANDOM;
		System.out.println("# Random.seed " + seed);

		// ////// MARKETS INSTANTIATION ////////

		List<Market> markets = sim.createAllMarkets(CONFIG.get("simulation")
				.get("markets"));
		// TODO
		List<LongRange> mrange = new ArrayList<LongRange>();
		mrange.add(new LongRange(0, markets.size() - 1));
		sim.marketName2Ranges.put("markets", mrange);

		System.out.println("# #(markets) " + markets.size());

		// ////// AGENTS INSTANTIATION ////////
		CentricAllocManager<Agent> dm = new CentricAllocManager<Agent>();
		sim.createAllAgents(CONFIG.get("simulation").get("agents"), dm);
		GLOBAL.put("agents", dm.getBody());

		// ////// MULTIVARIATE GEOMETRIC BROWNIAN ////////

		Fundamentals fundamentals = sim.createFundamentals(
				markets,
				CONFIG.get("simulation").getOrElse("fundamentalCorrelations",
						"{}"));
		// val fundamentals =
		// sim.createFundamentals(CONFIG("simulation")("fundamentalCorrelations",
		// "{}"), CONFIG("simulation")("markets"));
		GLOBAL.put("fundamentals", fundamentals);

		// ////// SERIAL/PARALLEL ENV SETUP ////////

		setupEnv(markets, dm.getBody()); // TODObyTK

		// System.out.println("# #(agents) " + agents.size());
		// System.out.println("# #(hifreqAgents) " + env().hifreqAgents.size());

		// ////// MAIN SIMULATION PROCEDURE ////////

		sim.beginSimulation();

		JSON.Value sessions = CONFIG.get("simulation").get("sessions");
		for (long i = 0; i < sessions.size(); i++) {

			System.out.println("------------Session " + i + " Start@" + here);
			JSON.Value json = sessions.get(i);
			String sessionName = json.get("sessionName").toString();
			long iterationSteps;
			if (json.has("iterationSteps")) {
				iterationSteps = json.get("iterationSteps").toLong();
			} else {
				iterationSteps = json.get("iterationDays").toLong()
						* CONFIG.get("numStepsOneDay").toLong();
			}

			boolean withOrderPlacement = json.get("withOrderPlacement")
					.toBoolean();
			boolean withOrderExecution = json.get("withOrderExecution")
					.toBoolean();
			boolean withPrint = json.getOrElse("withPrint", "true").toBoolean();
			boolean forDummyTimeseries = (!withOrderPlacement && !withOrderExecution);
			if (json.has("forDummyTimeseries")) {
				forDummyTimeseries = json.get("forDummyTimeseries").toBoolean();
			}
			long maxNormalOrders = json.getOrElse("maxNormalOrders",
					String.valueOf(markets.size())).toLong();
			long maxHifreqOrders = json.getOrElse("maxHifreqOrders", "0")
					.toLong();

			if (true) {
				System.out.println("# SESSION: " + sessionName);
				System.out.println("# iterationSteps: " + iterationSteps);
				System.out.println("# withOrderPlacement: "
						+ withOrderPlacement);
				System.out.println("# withOrderExecution: "
						+ withOrderExecution);
				System.out.println("# withPrint: " + withPrint);
				System.out.println("# forDummyTimeseries: "
						+ forDummyTimeseries);
				System.out.println("# maxNormalOrders: " + maxNormalOrders);
				System.out.println("# maxHifreqOrders: " + maxHifreqOrders);
			}

			GLOBAL.put("events", null);
			if (json.has("events")) {
				List<Event> events = sim.createAllEvents(json.get("events"));
				GLOBAL.put("events", events);
			}
			// System.out.println("#hoge0");
			sim.beginSession(sessionName);
			// System.out.println("#hoge1");
			iterateMarketUpdates(sessionName, iterationSteps,
					withOrderPlacement, withOrderExecution, withPrint,
					forDummyTimeseries, maxNormalOrders, maxHifreqOrders,
					fundamentals);
			// System.out.println("#hoge2");
			sim.endSession(sessionName);
			// System.out.println("#hoge3");
		}
		sim.endSimulation();

		long TIME_THE_END = System.nanoTime();
		System.out.println("# TIME "
				+ ((TIME_THE_END - TIME_THE_BEGINNING) / 1e+9));
	}

	// TODO
	protected String here = "PLACE";
}
