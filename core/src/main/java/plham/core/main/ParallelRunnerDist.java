package plham.core.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

import apgas.Constructs;
import apgas.util.PlaceLocalObject;
import cassia.util.JSON;
import cassia.util.JSON.Value;
import handist.collections.Bag;
import handist.collections.Chunk;
import handist.collections.LongRange;
import handist.collections.RangedList;
import handist.collections.RangedListView;
import handist.collections.dist.CachableArray;
import handist.collections.dist.DistBag;
import handist.collections.dist.DistCol;
import handist.collections.dist.DistMap;
import handist.collections.dist.DistMultiMap;
import handist.collections.dist.TeamedPlaceGroup;
import plham.core.Agent;
import plham.core.Fundamentals;
import plham.core.Market;
import plham.core.Market.AgentUpdate;
import plham.core.Order;
import plham.core.SimulationOutput;
import plham.core.util.AllocManager;

@SuppressWarnings("unused")
public final class ParallelRunnerDist extends Runner {

    static class AgentUpdateProxy extends Agent.Proxy {
        /**
         *
         */
        private static final long serialVersionUID = -206816526099531233L;
        DistMultiMap<Long, Market.AgentUpdate> cOrders;

        AgentUpdateProxy(long id, DistMultiMap<Long, Market.AgentUpdate> cOrders) {
            super(id);
            this.cOrders = cOrders;
        }

        @Override
        public void executeUpdate(Market.AgentUpdate update) {
            cOrders.put1(update.agentId, update);
        }
    }

    /*
     * TODO var agentDistribution: Rail[Place];
     */
    static class BranchHandle extends PlaceLocalObject {
        DistCol<Agent> allAgents;
        DistMultiMap<Long, Market.AgentUpdate> contractedOrders;
        CachableArray<Market> markets;
        // TODO long, short
        DistBag<List<Order>> orders;
        TeamedPlaceGroup placeGroup;
        ParallelRunnerDist runner;
        SimulatorFactory sim;

        public BranchHandle(SimulatorFactory sim2, ParallelRunnerDist parallelRunnerDist,
                CachableArray<Market> dMarkets, DistCol<Agent> dAgents, DistBag<List<Order>> dOrders,
                DistMap<Long, List<AgentUpdate>> dContractedOrders) {
        }

        // TODO orders
        public BranchHandle(TeamedPlaceGroup placeGroup, ParallelRunnerDist runner, SimulatorFactory sim,
                CachableArray<Market> markets, DistCol<Agent> allAgents, DistBag<List<Order>> orders,
                DistMultiMap<Long, AgentUpdate> contractedOrders) {
            this.placeGroup = placeGroup;
            this.runner = runner;
            this.sim = sim;
            this.markets = markets;
            this.allAgents = allAgents;
            this.orders = orders;
            this.contractedOrders = contractedOrders;
        }

        public boolean isMaster() {
            return placeGroup.rank() == 0;
        }
    }

    static public class MarketInfo {
        static MarketInfo pack(Market m) {
            return new MarketInfo(m._isRunning, m.getLastMarketPrice(), m.getLastFundamentalPrice(), m.getTime());
        }

        static void unpack(Market m, MarketInfo mi) {
            m._isRunning = mi._isRunning;
            // TODO (int)
            m.marketPrices.set((int) mi.time, mi.marketPrice);
            m.fundamentalPrices.set((int) mi.time, mi.fundamentalPrice);
            m.setTime(mi.time);
        }

        boolean _isRunning;
        double fundamentalPrice;

        double marketPrice;

        long time;

        public MarketInfo(boolean _isRunning, double marketPrice, double fundamentalPrice, long time) {
            this._isRunning = _isRunning;
            this.marketPrice = marketPrice;
            this.fundamentalPrice = fundamentalPrice;
            this.time = time;
        }
    }

    /**
     *
     */
    private static final long serialVersionUID = -8584132179986832924L;

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

    transient ArrayList<LongRange> arbRanges = new ArrayList<>();

    /**
     * The distributed simulation data, which consist of constant data, a list of distributed collections.
     *
     */
    BranchHandle bh;
    private final String here;

    transient TreeSet<LongRange> myRanges = new TreeSet<>();

    int NPLACES;

    int NTHREADS;

    transient ArrayList<LongRange> ordRanges = new ArrayList<>();
    // TODO duplicated with MT
    transient private ExecutorService pool;
    long TIME_THE_BEGINNING;

    public ParallelRunnerDist(SimulationOutput sim, SimulatorFactory factory) {
        this(sim, factory, initializeNThreads());
    }

    public ParallelRunnerDist(SimulationOutput simulation, SimulatorFactory factory, int nthreads) {
        super(simulation, factory);
        NTHREADS = nthreads;
        here = Constructs.here().toString();
    }

    void createAllAgents(JSON.Value list) {
        // TODO
        // val randoms = new RandomSequenceBySplit(sim.getRandom());
        sim.hifreqAgents = new ArrayList<>();
        assert (factory.CONFIG != null);
        AllocManager<Agent> dm = new AllocManager<Agent>() {
            @Override
            public RangedList<Agent> getRangedList(JSON.Value config, LongRange range) {
                // TODO JSON.value
                JSON.Value className = config.get("class");
                JSON.Value classType = config.get("schedule");
                try {
                    if (bh.isMaster()) {
                        if (classType.equals("arbitrager")) {
                            debug(here + " rangeForArbitrage = " + range);
                            debug(here + " type " + sim.agents);
                            Chunk<Agent> chunk = new Chunk<>(range);
                            bh.allAgents.add(chunk);
                            return chunk;
                        } else {
                            return RangedListView.<Agent>emptyView();
                        }
                    } else {
                        if (classType.equals("arbitrager")) {
                            return RangedListView.<Agent>emptyView();
                        } else {
                            // boolean longType = classType.equals("longTerm");
                            LongRange myrange = getAssignedRange(range);
                            if (myrange == null) {
                                return RangedListView.<Agent>emptyView();
                            }
                            Chunk<Agent> chunk = new Chunk<>(myrange);
                            bh.allAgents.add(chunk);
                            /*
                             * if(longType) longTermAgents.putChunk(chunk); else shortTermAgents.putChunk(chunk);
                             * debug("place:"+here+" alloc "+myrange+ " @" + (longType?"long":"short"));
                             */
                            return chunk;
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException("put chunk duplicated!");
                }
            }

            @Override
            public void registerRange(Value config, LongRange range) {
                registerConfigAndRange(config, range);
            }

            @Override
            public void scanDone() {
                separateAgentRanges();
            }

            @Override
            public void setTotalCount(long size) {
                sim.numAgents = size;
            }

            @Override
            public boolean use2scan() {
                return true;
            }
        };
        factory.createAllAgents(list, dm /* , sim */);
    }

    private void debug(Object o) {
        System.err.println(o);
    }

    LongRange getAssignedRange(LongRange targetRange) {

        LongRange floor = myRanges.floor(targetRange);
        if (floor != null && floor.isOverlapped(targetRange)) {
            return floor;
        }
        LongRange ceil = myRanges.ceiling(targetRange);
        if (ceil != null && ceil.isOverlapped(targetRange)) {
            return ceil;
        }
        return null;
    }

    public void iterateMarketUpdates(final String sessionName, final long iterationSteps,
            final boolean withOrderPlacement, final boolean withOrderExecution, final boolean withPrint,
            final boolean forDummyTimeseries, final long maxNormalOrders, final long maxHifreqOrders,
            final Fundamentals fundamentals) {
        bh.placeGroup.barrier();
        iterateMarketUpdatesPara(sessionName, iterationSteps, withOrderPlacement, withOrderExecution, withPrint,
                forDummyTimeseries, maxNormalOrders, maxHifreqOrders, fundamentals);
    }

    public void iterateMarketUpdatesPara(String sessionName, long iterationSteps, boolean withOrderPlacement,
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
            ParallelRunnerMT.Step step = new ParallelRunnerMT.Step(id, epoch);
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
//					sim.print(sessionName); // FIXME
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
//			sim.endprint(sessionName, iterationSteps); // FIXME
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

    public void processAgentUpdate() {
        // TODO
        // maybe contracted.forEach() become faster
        bh.allAgents.forEach(/* pool, NTHREADS, */ (long index, Agent agent) -> {
            Collection<AgentUpdate> cs = bh.contractedOrders.get(index);
            if (cs == null)
                return;
            cs.forEach((AgentUpdate c) -> {
                agent.executeUpdate(c);
            });
        });

        bh.contractedOrders.clear();
    }

    void registerConfigAndRange(JSON.Value config, LongRange range) {
        // JSON.Value className = config.get("class");
        JSON.Value classType = config.get("schedule");
        if (classType.equals("arbitrager"))
            arbRanges.add(range);
        // TODO long/short using className
        else
            ordRanges.add(range);
    }

    @Override
    public void run(long seed) {
        // TODO Auto-generated method stub
        // The main simulation procedure should be written here
    }

    void separateAgentRanges() {
        if (bh.isMaster()) {
            for (LongRange r : arbRanges)
                myRanges.add(r);
        } else {
            int numWorkers = bh.placeGroup.size() - 1;
            List<List<LongRange>> split = LongRange.splitList(numWorkers, ordRanges);
            List<LongRange> mine = split.get(bh.placeGroup.rank() - 1);
            for (LongRange r : mine)
                if (r.size() > 0)
                    myRanges.add(r);
        }
    }

    public void setupEnv() {
        // TODO
        // setupMarkets(markets);
        // setupAgents(agents);
    }

    void submitOrders(long iterStep, Bag<List<Order>> bag) {
        // TODO
        List<Market> markets = sim.markets;
        bh.allAgents.forEach((Agent a, Consumer<? super List<Order>> receiver) -> {
            List<Order> orders = a.submitOrders(markets);
            if (!orders.isEmpty()) {
                receiver.accept(orders);
            }
        }, bag);
    }

    void updateAgents(ParallelRunnerMT.Step step) {
        // no need for remote propagation of contractedorders
        for (Market m : sim.markets) {
            List<List<AgentUpdate>> updatesHistory = m.agentUpdates;
            assert updatesHistory.get(updatesHistory.size() - 1).isEmpty();
        }
    }

//	@Override
//	public Main env() {
//		return bh.sim;
//	}

    public List<List<Order>> updateMarkets(long maxNormalOrders, long maxHifreqOrders, boolean diffPass) {
        throw new Error("should not called");
    }

//	public void run(String[] args) {
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
//		System.out.println("#NPLACES=" + NPLACES);
//		System.out.println("#NTHREADS=" + NTHREADS);
//		// System.out.println("#ORDER_RATE=" + Env.getenvOrElse("ORDER_RATE", "0.1"));
//		System.out.println("#HIFREQ_SUBMIT_RATE=" + Runner.HIFREQ_SUBMIT_RATE);
//
//		TIME_THE_BEGINNING = System.nanoTime();
//
//		Map<String, Object> GLOBAL = new LinkedHashMap<String, Object>();
//		sim.GLOBAL = GLOBAL;
//		JSON.Value CONFIG = JSON.parse(new File(args[0]));
//		sim.CONFIG = CONFIG;
//		JSON.extendDeeply(CONFIG, CONFIG);
//		// System.err.println(JSON.dump(CONFIG));
//		TeamedPlaceGroup pg = TeamedPlaceGroup.getWorld();
//		if (!bh.isMaster()) {
//			System.err.println("NOT master" + bh.placeGroup);
//		}
//		final long seed0 = seed;
//		pg.broadcastFlat(() -> {
//			Random RANDOM = new Random(seed0 + here().id);
//			bh.sim.RANDOM = RANDOM;
//		});
//		// ////// MARKETS INSTANTIATION ////////
//		List<Market> markets = sim.createAllMarkets(CONFIG.get("simulation").get("markets"));
//		final CachableArray<Market> dMarkets = CachableArray.make(pg, markets);
//		List<LongRange> mrange = new ArrayList<LongRange>();
//		mrange.add(new LongRange(0, markets.size()));
//		sim.marketName2Ranges.put("markets", mrange);
//		sim.markets = dMarkets;
//		System.out.println("# #(markets) " + markets.size());
//
//		// Setup Dist Collections
//		final DistCol<Agent> dAgents = new DistCol<>();
//		final DistBag<List<Order>> dOrders = new DistBag<>();
//		DistMap<Long, List<Market.AgentUpdate>> dContractedOrders = new DistMap<>();
//		this.bh = PlaceLocalObject.make(pg.places(), () -> {
//			BranchHandle result = new BranchHandle(sim, this, dMarkets, dAgents, dOrders, dContractedOrders);
//			dMarkets.forEach((Market m) -> { // TODO
//				m.env = result.sim;
//			});
//			sim.GLOBAL.put("agents", dAgents);
//			return result;
//		});
//
//	}
//
//	private void parallelRun() {
//		SimulatorFactory sim = bh.sim;
//		this.pool = Executors.newFixedThreadPool(this.NTHREADS);
//		JSON.Value CONFIG = sim.CONFIG;
//		Map<String, Object> GLOBAL = sim.GLOBAL;
//
//		// ////// AGENTS INSTANTIATION ////////
//		createAllAgents(CONFIG.get("simulation").get("agents"));
//		bh.allAgents.setProxyGenerator((Long index)->{
//			return new AgentUpdateProxy(index, bh.contractedOrders);
//		});
//
//		// ////// MULTIVARIATE GEOMETRIC BROWNIAN ////////
//		Fundamentals fundamentals = sim.createFundamentals(bh.markets,
//				sim.CONFIG.get("simulation").getOrElse("fundamentalCorrelations", "{}"));
//		sim.updateFundamentals(fundamentals);
//		GLOBAL.put("fundamentals", fundamentals);
//		// ////// SERIAL/PARALLEL ENV SETUP ////////
//
//		setupEnv();
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
//			long maxNormalOrders = json.getOrElse("maxNormalOrders", String.valueOf(bh.markets.size())).toLong();
//			long maxHifreqOrders = json.getOrElse("maxHifreqOrders", "0").toLong();
//			if (true && bh.isMaster()) {
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
//		if (bh.isMaster()) {
//			System.out.println("# TIME " + ((TIME_THE_END - TIME_THE_BEGINNING) / 1e+9));
//		}
//		pool.shutdown();
//	}

    public void updateMarketsInBatch(long id, ParallelRunnerMT.Step step, long maxHifreqOrders) {
        try {
            // TODO comm time
            Bag<List<Order>> bag = new Bag<>();
            bh.markets.<MarketInfo>broadcast(MarketInfo::pack, MarketInfo::unpack);
            bh.orders.clear();
            long t0 = System.nanoTime();
            submitOrders(id, bag);
            long t1 = System.nanoTime();
            System.out.println("CYCLE submitOrders: " + ((t1 - t0) * 1e-9));

            bh.orders.GLOBAL.gather(bh.placeGroup.get(0));

            // handleOrders(bag.convertToList(), maxHifreqOrders); // FIXME
            long t2 = System.nanoTime();
            System.out.println("CYCLE handleOrders: " + ((t2 - t1) * 1e-9));
            updateAgents(step);

            bh.contractedOrders.relocate(bh.allAgents.getDistributionLong());

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("[ParallelRunnerDist] updateMarketBatch MPI exception");
        }
    }
}
