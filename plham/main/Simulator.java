package plham.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.fasterxml.jackson.databind.JsonNode;

import plham.Agent;
import plham.Env;
import plham.Market;
import plham.model.AgentGenerator;
import plham.model.AgentInitializer;
import plham.model.AgentsInitializer;
import plham.model.EventGenerator;
import plham.model.EventInitializer;
import plham.model.MarketGenerator;
import plham.model.MarketInitializer;
import plham.model.MarketsInitializer;
import plham.model.as;
import plham.model.numMarkets;
import plham.model.val;
import x10.lang.LongRange;

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
	public JsonNode CONFIG;
	public Random RANDOM;
	private Map<String, AgentsInitializer> agentInitializers;
	private Map<String, AgentGenerator> agentGenerators;
	private Map<String, MarketsInitializer> marketInitializers;
	private Map<String, MarketGenerator> marketGenerators;
	private Map<String, EventInitializer> eventInitializers;
	private Map<String, EventGenerator> eventGenerators;

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
		this.agentInitializers = new HashMap<String, AgentsInitializer>();
		this.agentGenerators = new HashMap<String, AgentGenerator>();
		this.marketInitializers = new HashMap<String, MarketsInitializer>();
		this.marketGenerators = new HashMap<String, MarketGenerator>();
		this.eventInitializers = new HashMap<String, EventInitializer>();
		this.eventGenerators = new HashMap<String, EventGenerator>();
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
	public void addAgentInitializer(String name, Agent clazz) {
		AgentsInitializer initializer = this.agentInitializers.get(name);
		LongRange idRange = initializer.getIdRange();
		List<Random> randoms = initializer.getRandoms();
		JsonNode jsonValue = initializer.getJsonValue();
		@SuppressWarnings("hiding")
		List<Agent> agents = new ArrayList<Agent>();

		final long min = idRange.min;
		final long max = idRange.max;
		long n = min;

		while (n <= max) {
			int i = (int) n;
			Random random = randoms.get(i);
			Agent agent = clazz.create(i, name, random, jsonValue);
			agents.set(i, agent);
			n++;
		}
		AgentsInitializer initializsers = new AgentsInitializer(name, randoms,
				idRange, jsonValue, agents);
		this.agentInitializers.put(name, initializsers);
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
	public void addMarketInitializer(String name, MarketInitializer initializer) {
		long numMarkets = jsonNode.has("numMarkets") ? jsonNode.get("numMarkets").asLong() : 1;
		
		
		val markets = new ArrayList[Market](numMarkets) as List[Market];
		markets.add(initializer(id, name, random, json));
		this.GLOBAL(markets(0).name) = markets as Any; // assuming 'numMarkets' is always set to 1.
		return markets;
	}

	/*
	public def addMarketsInitializer(name:String, initializer:MarketsInitializer) {
		marketInitializers.put(name, initializer);
	}

	public def addMarketGenerator(name:String, generator:MarketGenerator) {
		marketGenerators.put(name, generator);
	}

	public def addEventInitializer(name:String, initializer:EventInitializer) = eventInitializers.put(name, initializer);
	public def addEventGenerator(name:String, generator:EventGenerator) = eventGenerators.put(name, generator);

	public def getRandom():Random {
		// assert here.id == 0 : "getRandom() must be called at Place(0)";
		return RANDOM;
	}

	public abstract def beginSimulation():void;

	public abstract def endSimulation():void;

	public abstract def beginSession(sessionName:String):void;

	public abstract def endSession(sessionName:String):void;

	public abstract def print(sessionName:String):void;

	public abstract def endprint(sessionName:String,iterationSteps:Long):void;

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

	private def fromRail[T](xs:Rail[T]):ArrayList[T] {
		val ret = new ArrayList[T](xs.size);
		for (i in xs.range()) {
			ret(i) = xs(i);
		}
		return ret;
	}

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
	public def createEvents(json:JSON.Value):List[Event] {
		assert false : "createEvents is not defined in the Simulator class.";
		return new ArrayList[Event]();
	}

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



	public def updateFundamentals(f:Fundamentals) {
		f.update();
	}

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
	public def getItemsByName[T](name:String):List[T] {
		return GLOBAL(name) as List[T];
	}
	public def getItemByName[T](name:String):T {
		val items = getItemsByName[T](name);
		assert items.size() == 1 : "getItemByName() got more than one object";
		return items(0);
	}

	public def getItemsByName[T](names:(i:Long)=>String, n:Long):List[T] {
		val items = new ArrayList[T]();
		for (i in 0..(n - 1)) {
			items.addAll(getItemsByName[T](names(i)));
		}
		return items;
	}

	public def getItemsByName[T](json:JSON.Value):List[T] {
		if (json.isList()) {
			return getItemsByName[T]((i:Long) => json(i).toString(), json.size());
		}
		return getItemsByName[T](json.toString());
	}

	public def getItemByName[T](json:JSON.Value):T {
		val items = getItemsByName[T](json);
		assert items.size() == 1 : "getItemByName() got more than one object";
		return items(0);
	}

	public def getItemsByName0[T](kv:Map[String,List[T]], name:String):List[T] {
		return kv(name) as List[T];
	}

	public def getItemByName0[T](kv:Map[String,List[T]], name:String):T {
		val items = getItemsByName0[T](kv, name);
		assert items.size() == 1 : "getItemByName0() got more than one object";
		return items(0);
	}

	public def getItemsByName0[T](kv:Map[String,List[T]], names:(i:Long)=>String, n:Long):List[T] {
		val items = new ArrayList[T]();
		for (i in 0..(n - 1)) {
		    val r = getItemsByName0[T](kv, names(i));
		    if(r==null) Console.OUT.println("~~~~" + here+ ":"+ kv +":"+names(i));
		    else items.addAll(r);
		}
		return items;
	}

	public def getItemsByName0[T](kv:Map[String,List[T]], json:JSON.Value):List[T] {
		if (json.isList()) {
			return getItemsByName0[T](kv, (i:Long) => json(i).toString(), json.size());
		}
		return getItemsByName0[T](kv, json.toString());
	}

	public def getItemByName0[T](kv:Map[String,List[T]], json:JSON.Value):T {
		val items = getItemsByName0[T](kv, json);
		assert items.size() == 1 : "getItemByName0() got more than one object";
		return items(0);
	}


	private def marketConverter1(range:LongRange):Market {
	return markets(range.min);
	}
	private def marketConverterM(ranges:List[LongRange]):List[Market] {
	//	Console.OUT.println(""+here+"converterM:"+ranges + ":"+ markets);
	val result = new ArrayList[Market]();
	for(range in ranges) for(i in range) result.add(markets(i));
	return result;
	}


	
	public def getMarketsByName(json:JSON.Value) {
	    return marketConverterM(getItemsByName0[LongRange](marketName2Ranges,json));
	}

	public def getMarketByName(json:JSON.Value) = marketConverter1(getItemByName0[LongRange](marketName2Ranges,json));

	public def getMarketsByName(names:List[String]) = marketConverterM(getItemsByName0[LongRange](marketName2Ranges,(i:Long) => names(i), names.size()));

	public def getMarketsByName(name:String) = marketConverterM(getItemsByName0[LongRange](marketName2Ranges,name));

	public def getMarketByName(name:String) = marketConverter1(getItemByName0[LongRange](marketName2Ranges,name));

	public def getAgentsByName(json:JSON.Value) = getItemsByName[Agent](json);

	public def getAgentByName(json:JSON.Value) = getItemByName[Agent](json);

	public def getAgentsByName(names:List[String]) = getItemsByName[Agent]((i:Long) => names(i), names.size());

	public def getAgentsByName(name:String) = getItemsByName[Agent](name);

	public def getAgentByName(name:String) = getItemByName[Agent](name);

	public def getEventsByName(json:JSON.Value) = getItemsByName[Event](json);

	public def getEventByName(json:JSON.Value) = getItemByName[Event](json);

	public def getEventsByName(names:List[String]) = getItemsByName[Event]((i:Long) => names(i), names.size());

	public def getEventsByName(name:String) = getItemsByName[Event](name);

	public def getEventByName(name:String) = getItemByName[Event](name);
	*/
}
