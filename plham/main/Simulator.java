package plham.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import plham.util.DistAllocManager;
import plham.util.JSONRandom;
import plham.util.Random;
import plham.util.RandomSequenceBySplit;
import cassia.util.JSON;
import cassia.util.RangedList;
import plham.Agent;
import plham.Env;
import plham.Event;
import plham.Fundamentals;
import plham.IndexMarket;
import plham.Market;
import plham.model.AgentGenerator;
import plham.model.AgentInitializer;
import plham.model.AgentsInitializer;
import plham.model.EventGenerator;
import plham.model.EventInitializer;
import plham.model.MarketGenerator;
import plham.model.MarketInitializer;
import plham.model.MarketsInitializer;
import plham.util.JSONUtils;
import apgas.core.LongRange;

/**
 * A base class for simulation models. See {@link plham.main.Runner} for
 * execution models. See the subclass {@link plham.Main} for the core methods.
 */
public abstract class Simulator extends Env {

	/*
	public var GLOBAL:Map[String,Any];
	public var marketName2Ranges:Map[String,List[LongRange]];
	public var CONFIG:JSON.Value;
	public var RANDOM:Random;
	private val agentInitializers:HashMap[String, AgentsInitializer];
	private val agentGenerators:HashMap[String, AgentGenerator];
	private val marketInitializers:HashMap[String, MarketsInitializer];
	private val marketGenerators:HashMap[String, MarketGenerator];
	private val eventInitializers:HashMap[String, EventInitializer];
	private val eventGenerators:HashMap[String, EventGenerator];
	 */
	public Map<String, Object> GLOBAL;
	public Map<String, List<LongRange>> marketName2Ranges;
	public JSON.Value CONFIG;
	public Random RANDOM;
	public Map<String, AgentsInitializer> agentInitializers;
	public Map<String, AgentGenerator> agentGenerators;
	public Map<String, MarketsInitializer> marketInitializers;
	public Map<String, MarketGenerator> marketGenerators;
	public Map<String, EventInitializer> eventInitializers;
	public Map<String, EventGenerator> eventGenerators;

	/*
	public def this() {
		agentInitializers = new HashMap[String, AgentsInitializer]();
		agentGenerators = new HashMap[String, AgentGenerator]();
		marketInitializers = new HashMap[String, MarketsInitializer]();
		marketGenerators = new HashMap[String, MarketGenerator]();
		eventInitializers = new HashMap[String, EventInitializer]();
		eventGenerators = new HashMap[String, EventGenerator]();
	}
	 */
	public Simulator() {
		this.agentInitializers = new LinkedHashMap<String, AgentsInitializer>();
		this.agentGenerators = new LinkedHashMap<String, AgentGenerator>();
		this.marketInitializers = new LinkedHashMap<String, MarketsInitializer>();
		this.marketGenerators = new LinkedHashMap<String, MarketGenerator>();
		this.eventInitializers = new LinkedHashMap<String, EventInitializer>();
		this.eventGenerators = new LinkedHashMap<String, EventGenerator>();
	}

	/*
	public def addAgentsInitializer(name:String, initializer:AgentsInitializer) {
		agentInitializers.put(name, initializer);
	}
	 */
	public void addAgentsInitializer(String name, AgentsInitializer initializer) {
		agentInitializers.put(name, initializer);
	}

	/*
	public def addAgentInitializer(name:String, initializer:AgentInitializer) {
		agentInitializers.put(name, (name:String, randoms:Indexed[Random], idRange:LongRange, config:JSON.Value, container:Settable[Long, Agent]) => {
			for (id in idRange) {
				container(id) = initializer(id, name, randoms(id), config);
			}
		});
	}
	 */
	public void addAgentInitializer(String name, AgentInitializer initializer) {
		AgentsInitializer initializers = new AgentsInitializer() {
			private static final long serialVersionUID = 9190318304985601907L;

			@SuppressWarnings("hiding")
			public void initialize(String name, List<Random> randoms,
					LongRange idRange, JSON.Value json, List<Agent> agents) {
				final long min = idRange.from;
				final long max = idRange.to;
				long n = min;

				while (n < max) {
					Random random = randoms.get((int) n);
					Agent agent = initializer.initialize(n, name, random, json);
					agents.set((int) n, agent);
					n++;
				}

			}
		};
		this.agentInitializers.put(name, initializers);
	}

	/*
	public def addAgentGenerator(name:String, generator:AgentGenerator) {
		agentGenerators.put(name, generator);
	}
	*/
	public void addAgentGenerator(String name, AgentGenerator generator) {
		agentGenerators.put(name, generator);
	}

	/*
	public def addMarketInitializer(name:String, initializer:MarketInitializer) {
		this.addMarketsInitializer(name, (id:Long, name:String, random:Random, json:JSON.Value) => {
			val numMarkets = json.has("numMarkets") ? json("numMarkets").toLong() : 1;
			val markets = new ArrayList[Market](numMarkets) as List[Market];
			markets.add(initializer(id, name, random, json));
			this.GLOBAL(markets(0).name) = markets as Any; // assuming 'numMarkets' is always set to 1.
			return markets;
		});
	}
	*/
	public void addMarketInitializer(String className,
			MarketInitializer initializer) {
		MarketsInitializer initializers = new MarketsInitializer() {
			private static final long serialVersionUID = 2739579036719738032L;

			@SuppressWarnings("hiding")
			public List<Market> initialize(long id, String name, Random random,
					JSON.Value json) {
				long numMarkets = json.has("numMarkets") ? json.get(
						"numMarkets").toLong() : 1;
				List<Market> markets = new ArrayList<Market>((int) numMarkets);
				Market market = initializer.initialize(id, name, random, json);
				markets.add(market);
				GLOBAL.put(name, markets);
				return markets;
			}

		};
		this.addMarketsInitializer(className, initializers);
	}

	/*
	public def addMarketsInitializer(name:String, initializer:MarketsInitializer) {
		marketInitializers.put(name, initializer);
	}
	*/

	public void addMarketsInitializer(String name,
			MarketsInitializer initializer) {
		marketInitializers.put(name, initializer);
	}

	/*
	public def addMarketGenerator(name:String, generator:MarketGenerator) {
		marketGenerators.put(name, generator);
	}
	*/
	public void addMarketGenerator(String name, MarketGenerator generator) {
		marketGenerators.put(name, generator);
	}

	/*
	public def addEventInitializer(name:String, initializer:EventInitializer) = eventInitializers.put(name, initializer);
	*/
	public void addEventInitializer(String name, EventInitializer initializer) {
		eventInitializers.put(name, initializer);
	}

	/*
	public def addEventGenerator(name:String, generator:EventGenerator) = eventGenerators.put(name, generator);
	*/

	public Random getRandom() {
		return RANDOM;
	}

	/*
	public abstract def beginSimulation():void;
	public abstract def endSimulation():void;
	public abstract def beginSession(sessionName:String):void;
	public abstract def endSession(sessionName:String):void;
	public abstract def print(sessionName:String):void;
	public abstract def endprint(sessionName:String,iterationSteps:Long):void;
	*/
	public abstract void beginSimulation();

	public abstract void endSimulation();

	public abstract void beginSession(String sessionName);

	public abstract void endSession(String sessionName);

	public abstract void print(String sessionName);

	public abstract void endprint(String sessionName, long iterationSteps);

	/*
	protected def createItemGroup[T](json:JSON.Value, className:String, keyword:String):List[T] {
		val items = new ArrayList[T]();
		//Console.OUT.println("#classname:"+json("class"));
		if (json("class").equals(className)) { // A dummy class
			val list = json(keyword);
			for (i in 0..(list.size() - 1)) {
				val name = list(i).toString();
				items.addAll(GLOBAL(name) as List[T]); // SEE: getDependencySortedList()
			}
		}
		return items;
	}
	*/
	@SuppressWarnings("unchecked")
	protected <T> List<T> createItemGroup(JSON.Value json, String className,
			String keyword) {
		List<T> items = new ArrayList<T>();
		if (json.get("class").equals(className)) { // A dummy class
			List<JSON.Value> list = json.get(keyword).asList();
			for (long i = 0; i < list.size(); i++) {
				String name = list.get((int) i).toString();
				items.add((T) GLOBAL.get(name)); // SEE:
				// getDependencySortedList()
			}
		}
		return items;
	}

	/*
	private def fromRail[T](xs:Rail[T]):ArrayList[T] {
		val ret = new ArrayList[T](xs.size);
		for (i in xs.range()) {
			ret(i) = xs(i);
		}
		return ret;
	}
	*/
	@SuppressWarnings("static-method")
	private <T> List<T> fromRail(T[] xs) {
		List<T> ret = new ArrayList<T>(Collections.nCopies(xs.length, null));
		for (long i = 0; i < xs.length; i++) {
			ret.set((int) i, xs[(int) i]);
		}
		return ret;
	}

	/*
	public def createAllMarkets(list:JSON.Value):List[Market] {
		val allMarkets = new ArrayList[Market]();
		val keywords = fromRail(["requires" as String]);
		val sorted = JSONUtils.getDependencySortedList(CONFIG, list, keywords);
		// TODO tk hack
		this.markets = allMarkets;
		marketName2Ranges = new HashMap[String,List[LongRange]]();
		//Console.OUT.println("#createAllMarkets");
		for (i in 0..(sorted.size() - 1)) {
			val name = sorted(i).toString();
			val markets:List[Market];
			val config = CONFIG(name);
			val className = config("class").toString();
			//Console.OUT.println("#"+i+"."+name);
			if (config("class").equals("MarketGroup")) {
			    marketName2Ranges(name) = createItemGroup[LongRange](config, "MarketGroup", "markets");
			} else if (marketGenerators.containsKey(className)) { // it's a macro.
			    val before = allMarkets.size();
			    val generator = marketGenerators(className);
				markets = new ArrayList[Market]();
				for (configGenerated in generator(config)) {
				    val id = allMarkets.size() + markets.size();
					val marketName = configGenerated("name").toString();
					markets.addAll(createMarkets(id, marketName, getRandom().split(), configGenerated));
				}
				allMarkets.addAll(markets);
			    val after = allMarkets.size();
			    if(before!=after) {
				marketName2Ranges(name) = new ArrayList[LongRange]();
				marketName2Ranges(name).add(before..(after-1));
			    }
			} else {
			    val before = allMarkets.size();
				val json = CONFIG(name);
				val id = allMarkets.size();
				markets = createMarkets(id, name, getRandom().split(), json);
				allMarkets.addAll(markets);
			    val after = allMarkets.size();
			    if(before!=after) {
				marketName2Ranges(name) = new ArrayList[LongRange]();
				marketName2Ranges(name).add(before..(after-1));
			    }
			}
	//Console.OUT.println("#MarketGroup " + name + "@ ranges:" + marketName2Ranges(name));
		}
		return allMarkets;
	}
	*/
	@SuppressWarnings("hiding")
	public List<Market> createAllMarkets(JSON.Value list) {
		List<Market> allMarkets = new ArrayList<Market>();
		List<String> keywords = this
				.<String> fromRail(new String[] { "requires" });
		List<String> sorted = JSONUtils.getDependencySortedList(CONFIG, list,
				keywords);
		// TODO tk hack
		this.markets = allMarkets;
		marketName2Ranges = new LinkedHashMap<String, List<LongRange>>();
		// Console.OUT.println("#createAllMarkets");
		for (long i = 0; i < sorted.size(); i++) {
			String name = sorted.get((int) i).toString();
			List<Market> markets;
			JSON.Value config = CONFIG.get(name);
			String className = config.get("class").toString();
			// Console.OUT.println("#"+i+"."+name);
			if (config.get("class").equals("MarketGroup")) {
				marketName2Ranges.put(name,
						createItemGroup(config, "MarketGroup", "markets"));
			} else if (marketGenerators.containsKey(className)) { // it's a
																	// macro.
				long before = allMarkets.size();
				MarketGenerator generator = marketGenerators.get(className);
				markets = new ArrayList<Market>();
				List<JSON.Value> configs = generator.generate(config);
				for (JSON.Value configGenerated : configs) {
					long id = allMarkets.size() + markets.size();
					String marketName = configGenerated.get("name").toString();
					markets.addAll(createMarkets(id, marketName, getRandom()
							.split(), configGenerated));
				}
				allMarkets.addAll(markets);
				long after = allMarkets.size();
				if (before != after) {
					marketName2Ranges.put(name, new ArrayList<LongRange>());
					marketName2Ranges.get(name).add(
							new LongRange(before, after));
				}
			} else {
				long before = allMarkets.size();
				JSON.Value json = CONFIG.get(name);
				long id = allMarkets.size();
				markets = createMarkets(id, name, getRandom().split(), json);
				allMarkets.addAll(markets);
				long after = allMarkets.size();
				if (before != after) {
					marketName2Ranges.put(name, new ArrayList<LongRange>());
					marketName2Ranges.get(name).add(
							new LongRange(before, after));
				}
			}
			// Console.OUT.println("#MarketGroup " + name + "@ ranges:" +
			// marketName2Ranges(name));
		}
		return allMarkets;
	}

	/*
	public def createMarkets(id:Long, name:String, random:Random, json:JSON.Value):List[Market] {
		val className = json("class").toString();
		val initializer = marketInitializers(className);
		assert initializer != null : "Initializer is not defined for class '" + className + "'";
		try {
			return initializer(id, name, random, json);
		} catch (e:Exception) {
			Console.ERR.println("An error occurred while creating " + name + ", from " + JSON.dump(json));
			throw e;
		}
	}
	*/
	public List<Market> createMarkets(long id, String name, Random random,
			JSON.Value json) {
		String className = json.get("class").toString();
		MarketsInitializer initializer = marketInitializers.get(className);
		assert initializer != null : "Initializer is not defined for class '"
				+ className + "'";
		try {
			return initializer.initialize(id, name, random, json);
		} catch (Exception e) {
			System.err.println("An error occurred while creating " + name
					+ ", from " + JSON.dump(json));
			throw e;
		}
	}

	/*
	public def createAllAgents(list:JSON.Value, dm:DistAllocManager[Agent]) {
		var id:Long = 0;
		val sorted = JSONUtils.getDependencySortedList(CONFIG, list, "agents");
		var numAllAgents:Long = 0;

		// create agent group referred in "AgentGroup"s.
		// and create agents' config by calling agent-generators(they're macros. ex:AgentsForEachMarkets)
		val configsGenerated = new HashMap[String, List[JSON.Value]]();
		// agents' configs generated by macros
		for (i in 0 .. (sorted.size() - 1)) {
			val name = sorted(i).toString();
			val config = CONFIG(name);
			val className = config("class").toString();
			if (className.equals("AgentGroup")) {
				//agents = createItemGroup[Agent](config, "AgentGroup", "agents");
				//GLOBAL(name) = agents as Any;
			} else if (agentGenerators.containsKey(className)) { // it's a macro.
				val generator = agentGenerators(className);
				assert (config.has("base")): " config does not has base ";
				configsGenerated(name) = generator(config);
			}
		}

		// count the number of agents to be created.
		for (i in 0 .. (sorted.size() - 1)) {
			val name = sorted(i).toString();
			val config = CONFIG(name);
			val className = config("class").toString();
			if (className.equals("AgentGroup") || agentGenerators.containsKey(className)) continue;
			numAllAgents += config("numAgents").toLong();
		}
		for (entry in configsGenerated.entries()) {
			for (config in entry.getValue()) {
				numAllAgents += config("numAgents").toLong();
			}
		}
		dm.setTotalCount(numAllAgents);
		var lastAgentId:Long = 0;
		val randoms = new plham.util.RandomSequenceBySplit(getRandom());
		for (i in 0 .. (sorted.size() - 1)) {
			val name = sorted(i).toString();
			val config = CONFIG(name);
			val className = config("class").toString();
			if (className.equals("AgentGroup") || agentGenerators.containsKey(className)) continue;
			val numAgents = config("numAgents").toLong();
			val range = new LongRange(lastAgentId, lastAgentId + numAgents - 1);
			lastAgentId += numAgents;
			val subList = dm.getRangedList(here, config, range);
			if(!subList.isEmpty()) createAgents(name, randoms, subList.getRange(), config, subList);
		}
		for (entry in configsGenerated.entries()) {
			val name = entry.getKey();
			val configs = entry.getValue();
			for (config in configs) {
				val className = config("class").toString();
				val numAgents = config("numAgents").toLong();
				val range = new LongRange(lastAgentId, lastAgentId + numAgents - 1);
				lastAgentId += numAgents;
				val subList = dm.getRangedList(here, config, range);
				if(!subList.isEmpty()) createAgents(name, randoms, subList.getRange(), config, subList);
			}
		}
		Console.OUT.println("# " + numAllAgents + " agents created.");
		return;
	}
	*/
	@SuppressWarnings({ "unused", "hiding" })
	public void createAllAgents(JSON.Value list, DistAllocManager<Agent> dm) {
		long id = 0;
		List<String> sorted = JSONUtils.getDependencySortedList(CONFIG, list,
				"agents");
		long numAllAgents = 0;

		// create agent group referred in "AgentGroup"s.
		// and create agents' config by calling agent-generators(they're macros.
		// AgentsForEachMarkets ex)
		Map<String, List<JSON.Value>> configsGenerated = new LinkedHashMap<String, List<JSON.Value>>();
		// agents' configs generated by macros
		for (int i = 0; i < sorted.size(); i++) {

			String name = sorted.get(i).toString();
			JSON.Value config = CONFIG.get(name);
			String className = config.get("class").toString();
			if (className.equals("AgentGroup")) {
				// agents = createItemGroup<Agent>(config, "AgentGroup",
				// "agents");
				// GLOBAL(name) = agents as Any;
			} else if (agentGenerators.containsKey(className)) { // it's a
																	// macro.
				AgentGenerator generator = agentGenerators.get(className);
				assert (config.has("base")) : " config does not has base ";
				configsGenerated.put(name, generator.generate(config));
			}
		}

		// count the number of agents to be created.
		for (long i = 0; i < sorted.size(); i++) {
			String name = sorted.get((int) i).toString();
			JSON.Value config = CONFIG.get(name);
			String className = config.get("class").toString();
			if (className.equals("AgentGroup")
					|| agentGenerators.containsKey(className)) {
				continue;
			}
			numAllAgents += config.get("numAgents").toLong();
		}
		for (Map.Entry<String, List<JSON.Value>> entry : configsGenerated
				.entrySet()) {
			for (JSON.Value config : entry.getValue()) {
				numAllAgents += config.get("numAgents").toLong();
			}
		}
		dm.setTotalCount(numAllAgents);
		long lastAgentId = 0;
		RandomSequenceBySplit randoms = new RandomSequenceBySplit(getRandom());
		for (int i = 0; i < sorted.size(); i++) {
			String name = sorted.get(i).toString();
			JSON.Value config = CONFIG.get(name);
			String className = config.get("class").toString();
			if (className.equals("AgentGroup")
					|| agentGenerators.containsKey(className)) {
				continue;
			}
			long numAgents = config.get("numAgents").toLong();
			LongRange range = new LongRange(lastAgentId, lastAgentId + numAgents);
			lastAgentId += numAgents;
			RangedList<Agent> subList = dm.getRangedList(here, config, range);
			if (!subList.isEmpty()) {
				createAgents(name, randoms, subList.getRange(), config, subList);
			}
		}
		for (Map.Entry<String, List<JSON.Value>> entry : configsGenerated
				.entrySet()) {
			String name = entry.getKey();
			List<JSON.Value> configs = entry.getValue();
			for (JSON.Value config : configs) {
				String className = config.get("class").toString();
				long numAgents = config.get("numAgents").toLong();
				LongRange range = new LongRange(lastAgentId, lastAgentId + numAgents);
				lastAgentId += numAgents;
				RangedList<Agent> subList = dm.getRangedList(here, config,
						range);
				if (!subList.isEmpty())
					createAgents(name, randoms, subList.getRange(), config,
							subList);
			}
		}
		System.err.println("# " + numAllAgents + " agents created.");
		return;
	}

	/*
	public def createAgents(name:String, randoms:Indexed[Random], range:LongRange, json:JSON.Value, agents:Settable[Long, Agent]):void {
	try {
		val className = json("class").toString();
		val initializer = agentInitializers(className);
		assert initializer != null : "Initializer is not defined for class '" + className + "'";
		initializer(name, randoms, range, json, agents);
	} catch (e:Exception) { 
		Console.ERR.println("An error occurred while creating " + name + ", from " + JSON.dump(json));
		throw e;
	}

	}
	*/
	@SuppressWarnings("hiding")
	public void createAgents(String name, List<Random> randoms,
			LongRange range, JSON.Value json, List<Agent> agents) {
		try {
			String className = json.get("class").toString();
			AgentsInitializer initializer = agentInitializers.get(className);
			assert initializer != null : "Initializer is not defined for class '"
					+ className + "'";
			initializer.initialize(name, randoms, range, json, agents);
		} catch (Exception e) {
			System.err.println("An error occurred while creating " + name
					+ ", from " + JSON.dump(json));
			throw e;
		}

	}

	/*
	public def createAllEvents(list:JSON.Value):List[Event] {
		val allEvents = new ArrayList[Event]();
		var id:Long = 0;
		for (i in 0..(list.size() - 1)) {
			val name = list(i).toString();
			val events:List[Event];
			val className = CONFIG(name)("class").toString();
			if (className.equals("EventGroup")) {
				events = createItemGroup[Event](CONFIG(name), "EventGroup", "events");
			} else {
				assert eventInitializers.containsKey(className) : className + "'s initializer is not registered.";
				val initializer = eventInitializers(className);
				var ev:Event = null;
				try {
					ev = initializer(id++, name, this.getRandom().split(), CONFIG(name));
				} catch (e:Exception) {
					Console.ERR.println("An error occurred while creating " + name + ", from " + JSON.dump(CONFIG(name)));
					throw e;
				}
				events = new ArrayList[Event]();
				events.add(ev);
			}
			allEvents.addAll(events);
			GLOBAL(name) = events as Any;
		}
		return allEvents;
	}
	*/
	public List<Event> createAllEvents(JSON.Value list) {
		List<Event> allEvents = new ArrayList<Event>();
		long id = 0;
		for (long i = 0; i < list.size(); i++) {
			String name = list.get(i).toString();
			List<Event> events;
			String className = CONFIG.get(name).get("class").toString();
			if (className.equals("EventGroup")) {
				events = createItemGroup(CONFIG.get(name), "EventGroup",
						"events");
			} else {
				assert eventInitializers.containsKey(className) : className
						+ "'s initializer is not registered.";
				EventInitializer initializer = eventInitializers.get(className);
				Event ev = null;
				try {
					ev = initializer.initialize(id++, this.getRandom().split(),
							name, CONFIG.get(name));
				} catch (Exception e) {
					System.err.println("An error occurred while creating "
							+ name + ", from " + JSON.dump(CONFIG.get(name)));
					throw e;
				}
				events = new ArrayList<Event>();
				events.add(ev);
			}
			allEvents.addAll(events);
			GLOBAL.put(name, events);
		}
		return allEvents;
	}

	/*
	public def createEvents(json:JSON.Value):List[Event] {
		assert false : "createEvents is not defined in the Simulator class.";
		return new ArrayList[Event]();
	}
	*/
	@SuppressWarnings({ "static-method", "unused" })
	public List<Event> createEvents(JSON.Value json) {
		assert false : "createEvents is not defined in the Simulator class.";
		return new ArrayList<Event>();
	}

	/*
	public def createFundamentals(markets:List[Market], json:JSON.Value):Fundamentals {
		val random = new JSONRandom(RANDOM);

		val N = markets.size();
		val f = new Fundamentals(RANDOM);

		for (i in 0..(N - 1)) {
			val m = markets(i);
			var initialPrice:Double = 0;
			try {
				initialPrice = m.getInitialFundamentalPrice();
			} catch (e:NoSuchElementException) {
				try {
					initialPrice = m.getInitialMarketPrice();
				} catch (e2:NoSuchElementException) {
					assert false : "there's no initial fundamental or market price definition in config.";
				}
			}
			f.setInitial(m, initialPrice);
		}
		for (i in 0..(N - 1)) {
			val m = markets(i);
			f.setDrift(m, 0.0);
			// (5/31, matsuura) commented out the line below. "fundamentalDrift" never appeared in config files, nor in x10 sources currently.
			// f.setDrift(m, random.nextRandom(CONFIG(m.name)("fundamentalDrift", "0.0")));
		}
		for (i in 0..(N - 1)) {
			val m = markets(i);
			f.setVolatility(m, m.getFundamentalVolatility());
		}
		if (json.has("pairwise")) {
			val edges = json("pairwise");
			for (k in 0..(edges.size() - 1)) {
				val triple = edges(k);
				val mi = getItemByName[Market](triple(0));
				val mj = getItemByName[Market](triple(1));
				f.setCorrelation(mi, mj, random.nextRandom(triple(2)));
			}
		}
		for (i in 0..(N - 1)) {
			val m = markets(i);
			f.setCorrelation(m, m, 1.0);
		}
		
		f.setup(); // MAKE SURE to call this.

		return f;
	}
	*/
	@SuppressWarnings("hiding")
	public Fundamentals createFundamentals(List<Market> markets, JSON.Value json) {
		JSONRandom random = new JSONRandom(RANDOM);

		int N = markets.size();
		Fundamentals f = new Fundamentals(RANDOM);

		for (long i = 0; i < N; i++) {
			Market m = markets.get((int) i);
			double initialPrice = 0;
			try {
				initialPrice = m.getInitialFundamentalPrice();
			} catch (NoSuchElementException e) {
				try {
					initialPrice = m.getInitialMarketPrice();
				} catch (NoSuchElementException e2) {
					assert false : "there's no initial fundamental or market price definition in config.";
				}
			}
			f.setInitial(m, initialPrice);
		}
		for (long i = 0; i < N; i++) {
			Market m = markets.get((int) i);
			f.setDrift(m, 0.0);
			// (5/31, matsuura) commented out the line below. "fundamentalDrift"
			// never appeared in config files, nor in x10 sources currently.
			// f.setDrift(m,
			// random.nextRandom(CONFIG(m.name)("fundamentalDrift", "0.0")));
		}
		for (long i = 0; i < N; i++) {
			Market m = markets.get((int) i);
			f.setVolatility(m, m.getFundamentalVolatility());
		}
		if (json.has("pairwise")) {
			JSON.Value edges = json.get("pairwise");
			for (long k = 0; k < edges.size(); k++) {
				JSON.Value triple = edges.get(k);
				Market mi = getItemByName(triple.get(0));
				Market mj = getItemByName(triple.get(1));
				f.setCorrelation(mi, mj, random.nextRandom(triple.get(2)));
			}
		}
		for (long i = 0; i < N; i++) {
			Market m = markets.get((int) i);
			f.setCorrelation(m, m, 1.0);
		}

		f.setup(); // MAKE SURE to call this.

		return f;
	}

	/*
	public def updateFundamentals(f:Fundamentals) {
		f.update();
	}
	*/
	@SuppressWarnings("static-method")
	public void updateFundamentals(Fundamentals f) {
		f.update();
	}

	/*
	public def updateMarketsUsingFundamentalPrice(markets:List[Market], fundamentals:Fundamentals) {
		for (market in markets) {
			if (market instanceof IndexMarket) {
				market.updateMarketPrice(market.getFundamentalPrice());
			} else {
				var nextFundamental:Double = fundamentals.get(market);
				market.updateMarketPrice(nextFundamental);
				market.updateFundamentalPrice(nextFundamental);
			}
			market.updateOrderBooks();
		}
	}
	*/
	@SuppressWarnings({ "hiding", "static-method" })
	public void updateMarketsUsingFundamentalPrice(List<Market> markets,
			Fundamentals fundamentals) {
		for (Market market : markets) {
			if (market instanceof IndexMarket) {
				market.updateMarketPrice(market.getFundamentalPrice());
			} else {
				double nextFundamental = fundamentals.get(market);
				market.updateMarketPrice(nextFundamental);
				market.updateFundamentalPrice(nextFundamental);
			}
			market.updateOrderBooks();
		}
	}

	/*
	public def updateMarketsUsingMarketPrice(markets:List[Market], fundamentals:Fundamentals) {
		for (market in markets) {
			market.updateMarketPrice();
			if (! (market instanceof IndexMarket)) {
				// index markets need not updated fundamentals. they calculates fundamental price from the underlyings on the fly.
				var nextFundamental:Double = fundamentals.get(market);
				market.updateFundamentalPrice(nextFundamental);
			}
			market.updateOrderBooks();
		}
	}
	*/
	@SuppressWarnings({ "hiding", "static-method" })
	public void updateMarketsUsingMarketPrice(List<Market> markets,
			Fundamentals fundamentals) {
		for (Market market : markets) {
			market.updateMarketPrice();
			if (!(market instanceof IndexMarket)) {
				// index markets need not updated fundamentals. they calculates
				// fundamental price from the underlyings on the fly.
				double nextFundamental = fundamentals.get(market);
				market.updateFundamentalPrice(nextFundamental);
			}
			market.updateOrderBooks();
		}
	}

	/*
	public def getItemsByName[T](name:String):List[T] {
		return GLOBAL(name) as List[T];
	}
	*/
	@SuppressWarnings("unchecked")
	public <T> List<T> getItemsByName(String name) {
		return (List<T>) GLOBAL.get(name);
	}

	/*
	public def getItemByName[T](name:String):T {
		val items = getItemsByName[T](name);
		assert items.size() == 1 : "getItemByName() got more than one object";
		return items(0);
	}
	*/
	public <T> T getItemByName(String name) {
		List<T> items = getItemsByName(name);
		assert items.size() == 1 : "getItemByName() got more than one object";
		return items.get(0);
	}

	/*
	public def getItemsByName[T](names:(i:Long)=>String, n:Long):List[T] {
		val items = new ArrayList[T]();
		for (i in 0..(n - 1)) {
			items.addAll(getItemsByName[T](names(i)));
		}
		return items;
	}
	*/
	public <T> List<T> getItemsByName(List<String> names, long n) {
		List<T> items = new ArrayList<T>();
		for (long i = 0; i < n; i++) {
			items.addAll(getItemsByName(names.get((int) i)));
		}
		return items;
	}

	/*
	public def getItemsByName[T](json:JSON.Value):List[T] {
		if (json.isList()) {
			return getItemsByName[T]((i:Long) => json(i).toString(), json.size());
		}
		return getItemsByName[T](json.toString());
	}
	*/
	public <T> List<T> getItemsByName(JSON.Value json) {
		if (json.isList()) {
			List<T> items = new ArrayList<T>();
			for (final JSON.Value name : json.asList()) {
				items.add(getItemByName(name.toString()));
			}
			return items;
		}
		return getItemsByName(json.toString());
	}

	/*
	public def getItemByName[T](json:JSON.Value):T {
		val items = getItemsByName[T](json);
		assert items.size() == 1 : "getItemByName() got more than one object";
		return items(0);
	}
	*/
	public <T> T getItemByName(JSON.Value json) {
		List<T> items = getItemsByName(json);
		assert items.size() == 1 : "getItemByName() got more than one object";
		return items.get(0);
	}

	/*
	public def getItemsByName0[T](kv:Map[String,List[T]], name:String):List[T] {
		return kv(name) as List[T];
	}
	*/
	@SuppressWarnings("static-method")
	public <T> List<T> getItemsByName0(Map<String, List<T>> kv, String name) {
		return kv.get(name);
	}

	/*
	public def getItemByName0[T](kv:Map[String,List[T]], name:String):T {
		val items = getItemsByName0[T](kv, name);
		assert items.size() == 1 : "getItemByName0() got more than one object";
		return items(0);
	}
	*/
	public <T> T getItemByName0(Map<String, List<T>> kv, String name) {
		List<T> items = getItemsByName0(kv, name);
		assert items.size() == 1 : "getItemByName0() got more than one object";
		return items.get(0);
	}

	/*
	public def getItemsByName0[T](kv:Map[String,List[T]], names:(i:Long)=>String, n:Long):List[T] {
		val items = new ArrayList[T]();
		for (i in 0..(n - 1)) {
		    val r = getItemsByName0[T](kv, names(i));
		    if(r==null) Console.OUT.println("~~~~" + here+ ":"+ kv +":"+names(i));
		    else items.addAll(r);
		}
		return items;
	}
	*/
	public <T> List<T> getItemsByName0(Map<String, List<T>> kv,
			List<String> names, long n) {
		List<T> items = new ArrayList<T>();
		for (long i = 0; i < n; i++) {
			List<T> r = getItemsByName0(kv, names.get((int) i));
			if (r == null) {
				System.out
						.println("~~~~" + ":" + kv + ":" + names.get((int) i));
			} else
				items.addAll(r);
		}
		return items;
	}

	/*
	public def getItemsByName0[T](kv:Map[String,List[T]], json:JSON.Value):List[T] {
		if (json.isList()) {
			return getItemsByName0[T](kv, (i:Long) => json(i).toString(), json.size());
		}
		return getItemsByName0[T](kv, json.toString());
	}
	*/
	public <T> List<T> getItemsByName0(Map<String, List<T>> kv, JSON.Value json) {
		if (json.isList()) {
			List<JSON.Value> l = json.asList();
			List<T> result = new ArrayList<T>();
			for (JSON.Value value : l) {
				result.addAll(getItemsByName0(kv, value));
			}
			return result;
		}
		return getItemsByName0(kv, json.toString());
	}

	/*
	public def getItemByName0[T](kv:Map[String,List[T]], json:JSON.Value):T {
		val items = getItemsByName0[T](kv, json);
		assert items.size() == 1 : "getItemByName0() got more than one object";
		return items(0);
	}
	*/
	public <T> T getItemByName0(Map<String, List<T>> kv, JSON.Value json) {
		List<T> items = getItemsByName0(kv, json);
		assert items.size() == 1 : "getItemByName0() got more than one object";
		return items.get(0);
	}

	/*
	private def marketConverter1(range:LongRange):Market {
	return markets(range.min);
	}
	*/
	private Market marketConverter1(LongRange range) {
		return markets.get((int) range.from);
	}

	/*
	private def marketConverterM(ranges:List[LongRange]):List[Market] {
	//	Console.OUT.println(""+here+"converterM:"+ranges + ":"+ markets);
	val result = new ArrayList[Market]();
	for(range in ranges) for(i in range) result.add(markets(i));
	return result;
	}
	*/
	private List<Market> marketConverterM(List<LongRange> ranges) {
		List<Market> result = new ArrayList<Market>();
		for (LongRange range : ranges) {
			for (long i = range.from; i < range.to; i++) {
				result.add(markets.get((int) i));
			}
		}
		return result;
	}

	/*
	public def getMarketsByName(json:JSON.Value) {
	    return marketConverterM(getItemsByName0[LongRange](marketName2Ranges,json));
	}
	*/
	public List<Market> getMarketsByName(JSON.Value json) {
		return marketConverterM(getItemsByName0(marketName2Ranges, json));
	}

	/*
	public def getMarketByName(json:JSON.Value) = marketConverter1(getItemByName0[LongRange](marketName2Ranges,json));
	 */
	public Market getMarketByName(JSON.Value json) {
		return marketConverter1(getItemByName0(marketName2Ranges, json));
	}

	/*
	public def getMarketsByName(names:List[String]) = marketConverterM(getItemsByName0[LongRange](marketName2Ranges,(i:Long) => names(i), names.size()));
	 */
	public List<Market> getMarketsByName(List<String> names) {
		return marketConverterM(getItemsByName0(marketName2Ranges, names,
				names.size()));
	}

	/*
	public def getMarketsByName(name:String) = marketConverterM(getItemsByName0[LongRange](marketName2Ranges,name));
	 */
	public List<Market> getMarketsByName(String name) {
		return marketConverterM(getItemsByName0(marketName2Ranges, name));
	}

	/*
	public def getMarketByName(name:String) = marketConverter1(getItemByName0[LongRange](marketName2Ranges,name));
	 */
	public Market getMarketByName(String name) {
		return marketConverter1(getItemByName0(marketName2Ranges, name));
	}

	/*
	public def getAgentsByName(json:JSON.Value) = getItemsByName[Agent](json);
	*/
	public List<Agent> getAgentsByName(JSON.Value json) {
		return this.<Agent> getItemsByName(json);
	}

	/*
	public def getAgentByName(json:JSON.Value) = getItemByName[Agent](json);
	*/
	public Agent getAgentByName(JSON.Value json) {
		return this.<Agent> getItemByName(json);
	}

	/*
	public def getAgentsByName(names:List[String]) = getItemsByName[Agent]((i:Long) => names(i), names.size());
	*/
	public List<Agent> getAgentsByName(List<String> names) {
		return getItemsByName(names, (long) names.size());
	}

	/*
	public def getAgentsByName(name:String) = getItemsByName[Agent](name);
	*/
	public List<Agent> getAgentsByName(String name) {
		return getItemsByName(name);
	}

	/*
	public def getAgentByName(name:String) = getItemByName[Agent](name);
	*/
	public Agent getAgentByName(String name) {
		return getItemByName(name);
	}

	/*
	public def getEventsByName(json:JSON.Value) = getItemsByName[Event](json);
	*/
	public List<Event> getEventsByName(JSON.Value json) {
		return this.<Event> getItemsByName(json);
	}

	/*
	public def getEventByName(json:JSON.Value) = getItemByName[Event](json);
	*/
	public Event getEventByName(JSON.Value json) {
		return this.<Event> getItemByName(json);
	}

	/*
	public def getEventsByName(names:List[String]) = getItemsByName[Event]((i:Long) => names(i), names.size());
	*/
	public List<Event> getEventsByName(List<String> names) {
		return getItemsByName(names, (long) names.size());
	}

	/*
	public def getEventsByName(name:String) = getItemsByName[Event](name);
	*/
	public List<Event> getEventsByName(String name) {
		return getItemsByName(name);
	}

	/*
	public def getEventByName(name:String) = getItemByName[Event](name);
	*/
	public Event getEventByName(String name) {
		return getItemByName(name);
	}
}
