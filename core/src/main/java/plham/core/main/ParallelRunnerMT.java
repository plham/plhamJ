package plham.core.main;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import handist.collections.Bag;
import handist.collections.ChunkedList;
import plham.core.Agent;
import plham.core.Fundamentals;
import plham.core.Market;
import plham.core.Market.AgentUpdate;
import plham.core.Order;

@SuppressWarnings("unused")
public final class ParallelRunnerMT extends Runner {

	static class Step {
		long epoch;
		long id;
		StringBuilder sb = new StringBuilder();

		public Step(long id, long epoch) {
			this.id = id;
			this.epoch = epoch;
		}

		void log(String message) {
			long stamp = System.currentTimeMillis() - epoch;
			synchronized (this) {
				sb.append(this + " " + message + " " + stamp + "\n");
			}
		}

		void message() {
			System.err.print(sb);
		}

		@Override
		public String toString() {
			return "#" + /* here() + " " + */ id;
		}
	}

	private static final long serialVersionUID = -8642146572725786897L;

	/**
	 * Utility method which checks how many threads this runner should run with
	 *
	 * @return the level of parallelism desired
	 */
	private static int initializeNThreads() {
		String NTHREADS_ENV = System.getenv("NTHREADS");
		if (NTHREADS_ENV != null) {
			try {
				return Integer.parseInt(NTHREADS_ENV);
			} catch (RuntimeException e) {
				System.err.println("[Env: NTHREADS] " + NTHREADS_ENV + " is not integer (parse error).");
			}
		}
		return 1;
	}

	ChunkedList<Agent> cAgents;

	int NTHREADS;

	private ExecutorService pool;

	public ParallelRunnerMT(Simulator sim, SimulatorFactory factory) {
		this(sim, factory, initializeNThreads());
	}

	public ParallelRunnerMT(Simulator sim, SimulatorFactory factory, int nthreads) {
		super(sim, factory);
		NTHREADS = nthreads;
		pool = Executors.newFixedThreadPool(nthreads);
	}

	private void debug(Object o) {
		System.err.println(o);
	}

	public void iterateMarketUpdates(String sessionName, long iterationSteps, boolean withOrderPlacement,
			boolean withOrderExecution, boolean withPrint, boolean forDummyTimeseries, long maxNormalOrders,
			long maxHifreqOrders, Fundamentals fundamentals) {
		// TODO
		boolean isMaster = true;
		if (isMaster)
			marketSetup(sim.markets, withOrderExecution);
		long epoch = System.currentTimeMillis();
		for (long id = 0; id < iterationSteps; id++) {
			assert withOrderPlacement;
			// System.out.println("------------IterateLoop " + id + " @"+here);
			Step step = new Step(id, epoch);
			long begin = System.nanoTime();
			if (isMaster)
				iterSetup(fundamentals);
			if (withOrderPlacement) {
				updateMarketsInBatch(id, step, maxHifreqOrders);
			}
			if (isMaster) {
				long t0 = System.nanoTime();
				if (forDummyTimeseries) {
					sim.updateMarketsUsingFundamentalPrice(sim.markets, fundamentals);
				} else {
					sim.updateMarketsUsingMarketPrice(sim.markets, fundamentals);
				}
				long t1 = System.nanoTime();
				if (withPrint) {
					sim.print(sessionName);
				}
				long t2 = System.nanoTime();
				for (Market market : sim.markets) {
					market.triggerAfterSimulationStepEvents();
				}
				long t3 = System.nanoTime();
				for (Market market : sim.markets) {
					market.updateTime();
					market.updateOrderBooks();
				}
				long t4 = System.nanoTime();
				long end = System.nanoTime();
				System.out.println("CYCLE upMarket: " + ((t1 - t0) * 1e-9));
				System.out.println("CYCLE print: " + ((t2 - t1) * 1e-9));
				System.out.println("CYCLE triEvent: " + ((t3 - t2) * 1e-9));
				System.out.println("CYCLE upTime: " + ((t4 - t3) * 1e-9));
				System.out.println("CYCLE all" + ((end - begin) * 1e-9));

			}
		}
		if (isMaster && withPrint) {
			sim.endprint(sessionName, iterationSteps);
		}
	}

	void iterSetup(Fundamentals fundamentals) {
		sim.updateFundamentals(fundamentals);
		for (Market market : sim.markets) {
			market.triggerBeforeSimulationStepEvents(); // Assuming the markets in dependency order.
		}
	}

	void marketSetup(List<Market> markets, boolean withOrderExecution) {
		markets.forEach((Market market) -> {
			market.setRunning(withOrderExecution);
		});
		markets.forEach((Market market) -> {
			market.itayoseOrderBooks();
		});
		markets.forEach((Market market) -> {
			market.check();
		});
	}

	@Override
	public void run(long seed) {
		// TODO Auto-generated method stub
		// The main simulation procedure should be written here
	}

	void submitOrders(long iterStep, Bag<List<Order>> bag) {
		List<Market> markets = sim.markets;
		cAgents.forEach(/* pool, NTHREADS, */
				(Agent a, Consumer<? super List<Order>> receiver) -> {
					List<Order> orders = a.submitOrders(markets);
					if (!orders.isEmpty()) {
						receiver.accept(orders);
					}
				}, bag.getReceiver());
	}

	void updateAgents(Step step) {
		for (Market m : sim.markets) {
			List<List<AgentUpdate>> updatesHistory = m.agentUpdates;
			assert updatesHistory.get(updatesHistory.size() - 1).isEmpty();
		}
	}

	public List<List<Order>> updateMarkets(long maxNormalOrders, long maxHifreqOrders, boolean diffPass) {
		throw new Error("should not called");
	}

//	@Override
//	public void run(String[] args) {
//
//		if (args.length < 1) {
//			throw new RuntimeException("Usage: ./a.out config.json [SEED]");
//		}
//
//		long seed;
//		if (args.length > 1) {
//			seed = Long.valueOf(args[1]);
//		} else {
//			Random random = new Random();
//			seed = random.nextLong(Long.MAX_VALUE / 2); // MEMO: main()
//		}
//		System.out.println("#NTHREADS=" + NTHREADS);
//		System.out.println("#HIFREQ_SUBMIT_RATE=" + Runner.HIFREQ_SUBMIT_RATE);
//
//		long TIME_THE_BEGINNING = System.nanoTime();
//
//		Map<String, Object> GLOBAL = new LinkedHashMap<String, Object>();
//		sim.GLOBAL = GLOBAL;
//		JSON.Value CONFIG = JSON.parse(new File(args[0]));
//		sim.CONFIG = CONFIG;
//		JSON.extendDeeply(CONFIG, CONFIG);
//
//		Random RANDOM = new Random(seed);
//		sim.RANDOM = RANDOM;
//		System.out.println("# Random.seed " + seed);
//
//		// ////// MARKETS INSTANTIATION ////////
//		List<Market> markets = sim.createAllMarkets(CONFIG.get("simulation").get("markets"));
//		List<LongRange> mrange = new ArrayList<LongRange>();
//		mrange.add(new LongRange(0, markets.size()));
//		sim.marketName2Ranges.put("markets", mrange);
//
//		System.out.println("# #(markets) " + markets.size());
//
//		// ////// AGENTS INSTANTIATION ////////
//		AllocManager.Centric<Agent> dm = new AllocManager.Centric<Agent>();
//		sim.createAllAgents(CONFIG.get("simulation").get("agents"), dm);
//		GLOBAL.put("agents", dm.getBody());
//		// TODO tmp hack
//		this.cAgents = new ChunkedList<>();
//		cAgents.add(dm.getChunk());
//
//
//		// ////// MULTIVARIATE GEOMETRIC BROWNIAN ////////
//
//		Fundamentals fundamentals = sim.createFundamentals(markets,
//				CONFIG.get("simulation").getOrElse("fundamentalCorrelations", "{}"));
//		sim.updateFundamentals(fundamentals);
//		GLOBAL.put("fundamentals", fundamentals);
//
//		// ////// SERIAL/PARALLEL ENV SETUP ////////
//
//		setupEnv(markets, dm.getBody());
//
//		// ////// MAIN SIMULATION PROCEDURE ////////
//
//		sim.beginSimulation();
//
//		JSON.Value sessions = CONFIG.get("simulation").get("sessions");
//		for (long i = 0; i < sessions.size(); i++) {
//			JSON.Value json = sessions.get(i);
//			String sessionName = json.get("sessionName").toString();
//			long iterationSteps = parseIterationSteps(json);
//			boolean withOrderPlacement = json.get("withOrderPlacement").toBoolean();
//			boolean withOrderExecution = json.get("withOrderExecution").toBoolean();
//			boolean withPrint = json.getOrElse("withPrint", "true").toBoolean();
//			boolean forDummyTimeseries = (!withOrderPlacement && !withOrderExecution);
//			if (json.has("forDummyTimeseries")) {
//				forDummyTimeseries = json.get("forDummyTimeseries").toBoolean();
//			}
//			long maxNormalOrders = json.getOrElse("maxNormalOrders", String.valueOf(markets.size())).toLong();
//			long maxHifreqOrders = json.getOrElse("maxHifreqOrders", "0").toLong();
//			if (true) {
//				System.out.println("# SESSION: " + sessionName);
//				System.out.println("# iterationSteps: " + iterationSteps);
//				System.out.println("# withOrderPlacement: " + withOrderPlacement);
//				System.out.println("# withOrderExecution: " + withOrderExecution);
//				System.out.println("# withPrint: " + withPrint);
//				System.out.println("# forDummyTimeseries: " + forDummyTimeseries);
//				System.out.println("# maxNormalOrders: " + maxNormalOrders);
//				System.out.println("# maxHifreqOrders: " + maxHifreqOrders);
//			}
//
//			GLOBAL.put("events", null);
//			if (json.has("events")) {
//				List<Event> events = sim.createAllEvents(json.get("events"));
//				GLOBAL.put("events", events);
//			}
//			sim.beginSession(sessionName);
//			iterateMarketUpdates(sessionName, iterationSteps, withOrderPlacement, withOrderExecution, withPrint,
//					forDummyTimeseries, maxNormalOrders, maxHifreqOrders, fundamentals);
//			sim.endSession(sessionName);
//		}
//		sim.endSimulation();
//
//		long TIME_THE_END = System.nanoTime();
//		System.out.println("# TIME " + ((TIME_THE_END - TIME_THE_BEGINNING) / 1e+9));
//		pool.shutdown();
//	}

	public void updateMarketsInBatch(long id, Step step, long maxHifreqOrders) {
		Bag<List<Order>> bag = new Bag<>();
		// TODO tuning
		long t0 = System.nanoTime();
		submitOrders(id, bag);
		long t1 = System.nanoTime();
		System.out.println("CYCLE submitOrders: " + ((t1 - t0) * 1e-9));
		// handleOrders(bag.convertToList(), maxHifreqOrders); // FIXME
		long t2 = System.nanoTime();
		System.out.println("CYCLE handleOrders: " + ((t2 - t1) * 1e-9));
		updateAgents(step);
	}

}
