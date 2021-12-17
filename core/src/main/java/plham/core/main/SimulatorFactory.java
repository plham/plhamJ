package plham.core.main;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import cassia.util.JSON;
import cassia.util.JSON.Value;
import handist.collections.LongRange;
import handist.collections.RangedList;
import plham.core.Agent;
import plham.core.Event;
import plham.core.Fundamentals;
import plham.core.HighFrequencyAgent;
import plham.core.IndexMarket;
import plham.core.Market;
import plham.core.agent.ArbitrageAgent;
import plham.core.agent.FCNAgent;
import plham.core.event.FundamentalPriceShock;
import plham.core.event.OrderMistakeShock;
import plham.core.event.PriceLimitRule;
import plham.core.event.TradingHaltRule;
import plham.core.main.Simulator.Session;
import plham.core.model.AgentGenerator;
import plham.core.model.AgentInitializer;
import plham.core.model.AgentsInitializer;
import plham.core.model.EventGenerator;
import plham.core.model.EventInitializer;
import plham.core.model.MarketGenerator;
import plham.core.model.MarketInitializer;
import plham.core.model.MarketsInitializer;
import plham.core.util.AgentAllocManager;
import plham.core.util.AgentGeneratorForEachMarket;
import plham.core.util.JSONRandom;
import plham.core.util.JSONUtils;
import plham.core.util.Random;
import plham.core.util.RandomSequenceBySplit;
import plham.core.util.SimpleMarketGenerator;

public class SimulatorFactory {

    /**
     * Utility class in charge of making the proper initialization for a
     * SimulatorFactory by calling the 'register' method of the classes involved in
     * a simulation though reflection.
     *
     */
    private class SimulationParser {

        /**
         * JSON value of the "agents" entry in the provided file
         */
        Value agents;

        /**
         * Events declarations are fragmented between the various sessions. This
         * collection gathers all the "events" declarations from each session.
         */
        List<Value> events;

        /**
         * JSON value of the "market" entry in the provided file
         */
        Value markets;

        /**
         * JSON value of the "sessions" entry in the provided file
         */
        Value sessions;

        /**
         * Constructor with the file to parse specified as parameter
         *
         * @param f the file to parse
         */
        public SimulationParser(File f) {
            this(JSON.parse(f));
        }

        public SimulationParser(JSON.Value json) {
            CONFIG = json;
        }

        public SimulationParser(String fileName) {
            this(new File(fileName));
        }

        /**
         * Starts parsing the JSON configuration to identify the agents, events,
         * markets, and sessions declared.
         *
         * @param json
         */
        void extractSimulation(Value json) {
            try {
                final Value simulationObject = json.get("simulation");

                // We now look for the elements expected in the simulation
                markets = simulationObject.get("markets");
                agents = simulationObject.get("agents");
                sessions = simulationObject.get("sessions");

                events = new ArrayList<>();

                for (final Value sessionValue : sessions.asList()) {
                    if (sessionValue.has("events")) {
                        // If "events" is present, it is declared as an array
                        final List<Value> eventsFromSession = sessionValue.get("events").asList();
                        // We accumulate all the events in a single arrayList
                        events.addAll(eventsFromSession);
                    }
                }

            } catch (final Exception e) {
                e.printStackTrace();
                throw e;
            }
        }

        /**
         * Parses the configuration with which this {@link SimulationParser} was
         * constructed and calls the various objects' register method onto the provided
         * {@link SimulatorFactory} instance.
         *
         * @throws Exception if an exception is thrown
         */
        public void parseFile() throws Exception {
            // First extract the Simulation
            // s.CONFIG = CONFIG;
            try {
                extractSimulation(CONFIG);
            } catch (final Exception e) {
                System.err.println("Could not extract configuration from the provided file");
                e.printStackTrace();
                throw e;
            }

            for (final Value v : markets.asList()) {
                registerClass(v);
            }
            for (final Value v : agents.asList()) {
                registerClass(v);
            }
            for (final Value v : events) {
                registerClass(v);
            }
        }

        /**
         * Helper method which uses reflection to call the static method "register" of
         * the various classes that are going to be used in the simulation
         *
         * @param s                       the simulator factory in charge of building
         *                                the instances of the various classes used in
         *                                the simulation
         * @param participantInSimulation the JSON entry which contains a declaration of
         *                                a participant in the simulation (i.e. a Market
         *                                / Agent / Event)
         * @throws NoSuchMethodException     if the class indicated in the configuration
         *                                   file does not have the desired method
         * @throws IllegalAccessException    if the current {@link SecurityManager} does
         *                                   not allow reflection
         * @throws InvocationTargetException if thrown during the reflective call
         * @throws ClassNotFoundException    if the class indicated in the configuration
         *                                   file could not be resolved
         */
        private void registerClass(Value participantInSimulation) throws NoSuchMethodException, IllegalAccessException,
                InvocationTargetException, ClassNotFoundException {
            // for (Object objectDeclaration : participantInSimulation.asList()) {
            final String name = participantInSimulation.toString(); // The actual underlying object is a String

            final Value jsonObjectConfiguration = CONFIG.get(name);

            // Identify the implementing class
            String implementingClassName = jsonObjectConfiguration.get("class").toString();
            // Helper for legacy "class" declarations
            // This allows users to keep old configuration files unchanged, the old "class"
            // mapping is
            // changed to the fullyQualifiedName of the corresponding class automatically
            if (legacyClassResolver.containsKey(implementingClassName)) {
                final String replacement = legacyClassResolver.get(implementingClassName);
                if (WARNING_FOR_LEGACY_CLASS) {
                    System.err.println("[WARNING] Implementation class \"" + implementingClassName
                            + "\" for simulation participant \"" + name + "\" was resolved to Java class \""
                            + replacement + "\"");
                }
                implementingClassName = replacement;
            }
            try {
                // The implementing class has been found,
                final Class<?> objectClass = Class.forName(implementingClassName);
                // We call the "register(SimulatorFactory)" method through reflection
                final Method registerMethod = objectClass.getMethod("register", SimulatorFactory.class);
                registerMethod.invoke(null, SimulatorFactory.this);
                name2class.put(name, objectClass);
            } catch (final ClassNotFoundException e) {
                System.err.println("Unable to find class " + implementingClassName
                        + ". Are you using a custom class? Use the fully qualified name, i.e.  \"class\" : \"package.subpackage.MyClass\" in your configuration file");
                throw e;
            }
        }

    }

    /**
     * Property used to activate/deactivate the printing of warnings when parsing
     * configuration files.
     */
    public final static String LEGACY_CLASS_WARNINGS_PROPERTY = "plham.legacyWarnings";

    /**
     * Map containing mappings from "simple name" of classes as written in existing
     * configuration files, to the corresponding class' full Java name. This map is
     * used to allow backward compatibility with older configuration files in which
     * the "simple name" of the classes to use for the simulation is written. Newer
     * configuration files should be written with the fully qualified name
     */
    static final Map<String, String> legacyClassResolver;
    /**
     * This private member is initialized based on the value assigned to property
     * {@link #LEGACY_CLASS_WARNINGS_PROPERTY}. Is true by default, which results in
     * the SimulatorFactory to print warning messages when "old" class
     * implementation specification in JSon configuration files are used.
     */
    private static boolean WARNING_FOR_LEGACY_CLASS = Boolean
            .parseBoolean(System.getProperty(LEGACY_CLASS_WARNINGS_PROPERTY, "false"));

    /**
     * Static constructor
     * <p>
     * This constructor prepares a map which is used to resolve the 'fully qualified
     * name' of classes used in simulations. The entry "class" : "SomeClassName" in
     * the configuration files should use the fully qualified name of the Java
     * classes used. However, to allow the execution of existing configuration files
     * which did not abidfe by this system, this map is used to map the 'simple
     * name' of classes as declared in the configuration file to the current 'fully
     * qualified name' of these classes.
     */
    static {
        final HashMap<String, String> resolver = new HashMap<>();
        resolver.put(Market.class.getSimpleName(), Market.class.getCanonicalName());
        resolver.put(IndexMarket.class.getSimpleName(), IndexMarket.class.getCanonicalName());
        resolver.put(ArbitrageAgent.class.getSimpleName(), ArbitrageAgent.class.getCanonicalName());
        resolver.put(FCNAgent.class.getSimpleName(), FCNAgent.class.getCanonicalName());
        resolver.put(FundamentalPriceShock.class.getSimpleName(), FundamentalPriceShock.class.getCanonicalName());
        resolver.put(OrderMistakeShock.class.getSimpleName(), OrderMistakeShock.class.getCanonicalName());
        resolver.put(PriceLimitRule.class.getSimpleName(), PriceLimitRule.class.getCanonicalName());
        resolver.put(TradingHaltRule.class.getSimpleName(), TradingHaltRule.class.getCanonicalName());
        resolver.put(SimpleMarketGenerator.class.getSimpleName(), SimpleMarketGenerator.class.getCanonicalName());
        resolver.put(AgentGeneratorForEachMarket.class.getSimpleName(),
                AgentGeneratorForEachMarket.class.getCanonicalName());

        // Below are the names of the classes present in module "samples"
        resolver.put("CancelFCNAgent", "plham.samples.CancelTest.CancelFCNAgent");
        resolver.put("DarkPoolFCNAgent", "plham.samples.DarkPool.DarkPoolFCNAgent");
        resolver.put("DarkPoolMarket", "plham.samples.DarkPool.DarkPoolMarket");
        resolver.put("InvestDivFCNAgent", "plham.samples.InvestDiv.InvestDivFCNAgent");
        resolver.put("MarketMakerAgent", "plham.samples.MarketShare.MarketMakerAgent");
        resolver.put("MarketShareFCNAgent", "plham.samples.MarketShare.MarketShareFCNAgent");
        resolver.put("PriceLimitFCNAgent", "plham.samples.PriceLimit.PriceLimitFCNAgent");
        resolver.put("WorkloadFCNAgent", "plham.samples.blackscholes.WorkloadFCNAgent");
        legacyClassResolver = resolver;
    }

    public Map<String, AgentGenerator> agentGenerators;

    public Map<String, AgentsInitializer> agentInitializers;

    public JSON.Value CONFIG;
    public Map<String, EventGenerator> eventGenerators;

    public Map<String, EventInitializer> eventInitializers;
    private Simulator inConstruction = null;

    public Map<String, MarketGenerator> marketGenerators;
    public Map<String, MarketsInitializer> marketInitializers;
    public Map<String, Class<?>> name2class;
    private SimulationParser parser;
    public Random randomForAgentsSetup;
    public Random randomForMarketsSetup;

    private SimulatorFactory() {
        name2class = new LinkedHashMap<>();
        agentInitializers = new LinkedHashMap<>();
        agentGenerators = new LinkedHashMap<>();
        marketInitializers = new LinkedHashMap<>();
        marketGenerators = new LinkedHashMap<>();
        eventInitializers = new LinkedHashMap<>();
        eventGenerators = new LinkedHashMap<>();
    }

    public SimulatorFactory(JSON.Value config) throws Exception {
        this();
        parser = new SimulationParser(config);
        parser.parseFile();
    }

    public SimulatorFactory(String configFilePath) throws Exception {
        this();
        parser = new SimulationParser(configFilePath);
        parser.parseFile();
    }

    public void addAgentGenerator(String name, AgentGenerator generator) {
        agentGenerators.put(name, generator);
    }

    public void addAgentInitializer(String name, AgentInitializer initializer) {
        final AgentsInitializer initializers = new AgentsInitializer() {
            private static final long serialVersionUID = 9190318304985601907L;

            @Override
            public void initialize(String name, RangedList<Random> randoms, LongRange idRange, JSON.Value json,
                    RangedList<Agent> agents) {
                final long min = idRange.from;
                final long max = idRange.to;
                long n = min;

                while (n < max) {
                    final Random random = randoms.get(n);
                    final Agent agent = initializer.initialize(n, name, random, json);
                    agents.set(n, agent);
                    n++;
                }

            }
        };
        agentInitializers.put(name, initializers);
    }

    public void addAgentsInitializer(String name, AgentsInitializer initializer) {
        agentInitializers.put(name, initializer);
    }

    public void addEventInitializer(String name, EventInitializer initializer) {
        eventInitializers.put(name, initializer);
    }

    public void addMarketGenerator(String name, MarketGenerator generator) {
        marketGenerators.put(name, generator);
    }

    public void addMarketInitializer(String className, MarketInitializer initializer) {
        // final SimulatorFactory factory = this;
        final MarketsInitializer initializers = new MarketsInitializer() {
            private static final long serialVersionUID = 2739579036719738032L;

            @Override
            public List<Market> initialize(long id, String name, Random random, JSON.Value json) {
                final long numMarkets = json.has("numMarkets") ? json.get("numMarkets").toLong() : 1;
                final List<Market> markets = new ArrayList<>((int) numMarkets);
                final Market market = initializer.initialize(id, name, random, json);
                markets.add(market);
                // factory.getSimulatorInConstruction().GLOBAL.put(name, markets);
                return markets;
            }
        };
        addMarketsInitializer(className, initializers);
    }

    public void addMarketsInitializer(String name, MarketsInitializer initializer) {
        marketInitializers.put(name, initializer);
    }

    private void createAgents(String name, RangedList<Random> randoms, LongRange range, JSON.Value json,
            RangedList<Agent> agents) {
        try {
            final String className = json.get("class").toString();
            final AgentsInitializer initializer = agentInitializers.get(className);
//            assert initializer != null : "Initializer is not defined for class '" + className + "'";
            if (initializer == null) {
                System.err.println("INITIALIZER NOT DEFINE FOR CLASS " + className);
            }
            initializer.initialize(name, randoms, range, json, agents);
        } catch (final Exception e) {
            System.err.println("An error occurred while creating " + name + ", from " + JSON.dump(json));
            throw e;
        }

    }

    public void createAllAgents(JSON.Value list, AgentAllocManager dm) {
        // long id = 0;
        final List<String> sorted = JSONUtils.getDependencySortedList(CONFIG, list, "agents");
        long numAllAgents = 0;

        // create agent group referred in "AgentGroup"s.
        // and create agents' config by calling agent-generators(they're macros.
        // AgentsForEachMarkets ex)
        final Map<String, List<JSON.Value>> configsGenerated = new LinkedHashMap<>();
        // agents' configs generated by macros
        for (int i = 0; i < sorted.size(); i++) {

            final String name = sorted.get(i).toString();
            final JSON.Value config = CONFIG.get(name);
            final String className = config.get("class").toString();
            if (className.equals("AgentGroup")) {
                // agents = createItemGroup<Agent>(config, "AgentGroup",
                // "agents");
                // GLOBAL(name) = agents as Any;
            } else if (agentGenerators.containsKey(className)) { // it's a
                // macro.
                final AgentGenerator generator = agentGenerators.get(className);
                assert (config.has("base")) : " config does not has base ";
                configsGenerated.put(name, generator.generate(config));
            }
        }

        // count the number of agents to be created.
        for (long i = 0; i < sorted.size(); i++) {
            final String name = sorted.get((int) i).toString();
            final JSON.Value config = CONFIG.get(name);
            final String className = config.get("class").toString();
            if (className.equals("AgentGroup") || agentGenerators.containsKey(className)) {
                continue;
            }
            numAllAgents += config.get("numAgents").toLong();
        }
        for (final Map.Entry<String, List<JSON.Value>> entry : configsGenerated.entrySet()) {
            for (final JSON.Value config : entry.getValue()) {
                numAllAgents += config.get("numAgents").toLong();
            }
        }
        dm.setTotalCount(numAllAgents);
        long lastAgentId = 0;
        final RandomSequenceBySplit randoms = new RandomSequenceBySplit(randomForAgentsSetup);
        if (dm.use2scan()) {
            // prescan
            for (int i = 0; i < sorted.size(); i++) {
                final String name = sorted.get(i).toString();
                final JSON.Value config = CONFIG.get(name);
                final String className = config.get("class").toString();
                if (className.equals("AgentGroup") || agentGenerators.containsKey(className)) {
                    continue;
                }
                final long numAgents = config.get("numAgents").toLong();
                final LongRange range = new LongRange(lastAgentId, lastAgentId + numAgents);
                lastAgentId += numAgents;
                dm.registerRange(config, range, name, this);
            }
            for (final Map.Entry<String, List<JSON.Value>> entry : configsGenerated.entrySet()) {
                final String name = entry.getKey();
                final List<JSON.Value> configs = entry.getValue();
                for (final JSON.Value config : configs) {
                    // String className = commented out but keeping the config.get("class") for
                    // potential side-effects
                    config.get("class").toString();
                    final long numAgents = config.get("numAgents").toLong();
                    final LongRange range = new LongRange(lastAgentId, lastAgentId + numAgents);
                    lastAgentId += numAgents;
                    dm.registerRange(config, range, name, this);
                }
            }
            dm.scanDone();
        }

        lastAgentId = 0;
        for (int i = 0; i < sorted.size(); i++) {
            final String name = sorted.get(i).toString();
            final JSON.Value config = CONFIG.get(name);
            final String className = config.get("class").toString();
            if (className.equals("AgentGroup") || agentGenerators.containsKey(className)) {
                continue;
            }
            final long numAgents = config.get("numAgents").toLong();
            final LongRange range = new LongRange(lastAgentId, lastAgentId + numAgents);
            lastAgentId += numAgents;
            final RangedList<Agent> subList = dm.getRangedList(config, range, name, this);
            if (!subList.isEmpty()) {
                createAgents(name, randoms, subList.getRange(), config, subList);
            }
        }
        for (final Map.Entry<String, List<JSON.Value>> entry : configsGenerated.entrySet()) {
            final String name = entry.getKey();
            final List<JSON.Value> configs = entry.getValue();
            for (final JSON.Value config : configs) {
                // String className = // commenting because unsused, but keeping the side-effect
                // of config.get("class")
                config.get("class").toString();
                final long numAgents = config.get("numAgents").toLong();
                final LongRange range = new LongRange(lastAgentId, lastAgentId + numAgents);
                lastAgentId += numAgents;
                final RangedList<Agent> subList = dm.getRangedList(config, range, name, this);
                if (!subList.isEmpty()) {
                    createAgents(name, randoms, subList.getRange(), config, subList);
                }
            }
        }
        // System.err.println("# " + numAllAgents + " agents created.");
        return;
    }

    @SuppressWarnings("unused")
    private List<Event> createAllEvents(JSON.Value list) {
        final List<Event> allEvents = new ArrayList<>();
        long id = 0;
        for (long i = 0; i < list.size(); i++) {
            final String name = list.get(i).toString();
            List<Event> events;
            final String className = CONFIG.get(name).get("class").toString();
            if (className.equals("EventGroup")) {
                events = createItemGroup(CONFIG.get(name), "EventGroup", "events");
            } else {
                assert eventInitializers.containsKey(className) : className + "'s initializer is not registered.";
                final EventInitializer initializer = eventInitializers.get(className);
                Event ev = null;
                try {
                    ev = initializer.initialize(id++, inConstruction.getRandom().split(), name, CONFIG.get(name));
                } catch (final Exception e) {
                    System.err.println(
                            "An error occurred while creating " + name + ", from " + JSON.dump(CONFIG.get(name)));
                    throw e;
                }
                events = new ArrayList<>();
                events.add(ev);
            }
            allEvents.addAll(events);
            // inConstruction.GLOBAL.put(name, events);
        }
        return allEvents;
    }

    private List<Market> createAllMarkets(JSON.Value list) {
        final List<Market> allMarkets = new ArrayList<>();
        final List<String> keywords = this.<String>fromRail(new String[] { "requires" });
        final List<String> sorted = JSONUtils.getDependencySortedList(CONFIG, list, keywords);
        // TODO tk hack
        inConstruction.markets = allMarkets;
        inConstruction.marketName2Ranges = new LinkedHashMap<>();
        // Console.OUT.println("#createAllMarkets");
        for (long i = 0; i < sorted.size(); i++) {
            final String name = sorted.get((int) i).toString();
            final JSON.Value config = CONFIG.get(name);
            final String className = config.get("class").toString();
            // Console.OUT.println("#"+i+"."+name);
            if (config.get("class").toString().equals("MarketGroup")) {
                inConstruction.marketName2Ranges.put(name, createItemGroup(config, "MarketGroup", "markets"));
            } else if (marketGenerators.containsKey(className)) { // it's a
                // macro.
                final long before = allMarkets.size();
                final MarketGenerator generator = marketGenerators.get(className);
                final List<Market> markets = new ArrayList<>();
                final List<JSON.Value> configs = generator.generate(config);
                for (final JSON.Value configGenerated : configs) {
                    final long id = allMarkets.size() + markets.size();
                    final String marketName = configGenerated.get("name").toString();
                    markets.addAll(createMarkets(id, marketName, inConstruction.getRandom().split(), configGenerated));
                }
                allMarkets.addAll(markets);
                final long after = allMarkets.size();
                if (before != after) {
                    inConstruction.marketName2Ranges.put(name, new ArrayList<LongRange>());
                    inConstruction.marketName2Ranges.get(name).add(new LongRange(before, after));
                }
            } else {
                final long before = allMarkets.size();
                final JSON.Value json = CONFIG.get(name);
                final long id = allMarkets.size();
                final List<Market> markets = createMarkets(id, name, randomForMarketsSetup.split(), json);
                allMarkets.addAll(markets);
                final long after = allMarkets.size();
                if (before != after) {
                    inConstruction.marketName2Ranges.put(name, new ArrayList<LongRange>());
                    inConstruction.marketName2Ranges.get(name).add(new LongRange(before, after));
                }
            }
            // Console.OUT.println("#MarketGroup " + name + "@ ranges:" +
            // marketName2Ranges(name));
        }
        return allMarkets;
    }

    public List<Event> createEvents(JSON.Value json) {
        assert false : "createEvents is not defined in the Simulator class.";
        return new ArrayList<>();
    }

    /**
     * Creates and initializes the events that are involved in the specified session
     *
     * @param s the sessions whose events are to be generated
     * @return null if there are no events for this session, a list of freshly
     *         created Events otherwise
     */
    public List<Event> createEventsForASession(Session s, Simulator sim) {
        inConstruction = sim;
        if (s.eventsToInitialize.isEmpty()) {
            return null;
        }

        long id = 0;
        final ArrayList<Event> events = new ArrayList<>();
        for (final String name : s.eventsToInitialize) {
            final String className = CONFIG.get(name).get("class").toString();
            if (className.equals("EventGroup")) {
                final List<Event> eventGroup = createItemGroup(CONFIG.get(name), "EventGroup", "events");
                // inConstruction.GLOBAL.put(name, eventGroup);
                events.addAll(eventGroup);
            } else {
                assert eventInitializers.containsKey(className) : className + "'s initializer is not registered.";
                final EventInitializer initializer = eventInitializers.get(className);
                Event ev = null;
                try {
                    ev = initializer.initialize(id++, inConstruction.getRandom().split(), name, CONFIG.get(name));
                } catch (final Exception e) {
                    System.err.println(
                            "An error occurred while creating " + name + ", from " + JSON.dump(CONFIG.get(name)));
                    throw e;
                }
                events.add(ev);
                // inConstruction.GLOBAL.put(name, ev);
            }
        }
        // TODO
        // inConstruction = null;
        return events;
    }

    public Fundamentals createFundamentals(List<Market> markets, JSON.Value json) {
        final Random RANDOM = inConstruction.RANDOM;
        final JSONRandom random = new JSONRandom(RANDOM);

        // int N = commented-out but keeping markets.size()
        markets.size();
        final Fundamentals f = new Fundamentals(RANDOM);

        for (final Market m : markets) {
            // TODO long->int
            double initialPrice = 0;
            try {
                initialPrice = m.getInitialFundamentalPrice();
            } catch (final NoSuchElementException e) {
                try {
                    initialPrice = m.getInitialMarketPrice();
                } catch (final NoSuchElementException e2) {
                    assert false : "there's no initial fundamental or market price definition in config.";
                }
            }
            f.setInitial(m, initialPrice);
        }
        for (final Market m : markets) {
            f.setDrift(m, 0.0);
            // (5/31, matsuura) commented out the line below. "fundamentalDrift"
            // never appeared in config files, nor in x10 sources currently.
            // f.setDrift(m,
            // random.nextRandom(CONFIG(m.name)("fundamentalDrift", "0.0")));
        }
        for (final Market m : markets) {
            f.setVolatility(m, m.getFundamentalVolatility());
        }
        if (json.has("pairwise")) {
            final JSON.Value edges = json.get("pairwise");
            for (long k = 0; k < edges.size(); k++) {
                final JSON.Value triple = edges.get(k);
                final Market mi = inConstruction.getMarketByName(triple.get(0));
                final Market mj = inConstruction.getMarketByName(triple.get(1));
                f.setCorrelation(mi, mj, random.nextRandom(triple.get(2)));
            }
        }
        for (final Market m : markets) {
            f.setCorrelation(m, m, 1.0);
        }

        f.setup(); // MAKE SURE to call this.

        return f;
    }

    protected <T> List<T> createItemGroup(JSON.Value json, String className, String keyword) {
        final List<T> items = new ArrayList<>();
        if (json.get("class").toString().equals(className)) { // A dummy class
            final List<JSON.Value> list = json.get(keyword).asList();
            for (long i = 0; i < list.size(); i++) {
                // String name = list.get((int) i).toString();
                // items.add((T) inConstruction.GLOBAL.get(name)); // SEE:
                // getDependencySortedList()
            }
        }
        return items;
    }

    public List<Market> createMarkets(long id, String name, Random random, JSON.Value json) {
        final String className = json.get("class").toString();
        final MarketsInitializer initializer = marketInitializers.get(className);
        assert initializer != null : "Initializer is not defined for class '" + className + "'";
        try {
            if (initializer == null) {
                System.err.println("PROBLEM FOR CLASS " + className);
            }
            return initializer.initialize(id, name, random, json);
        } catch (final Exception e) {
            System.err.println("An error occurred while creating " + name + ", from " + JSON.dump(json));
            throw e;
        }
    }

    private <T> List<T> fromRail(T[] xs) {
        final List<T> ret = new ArrayList<>(Collections.nCopies(xs.length, null));
        for (long i = 0; i < xs.length; i++) {
            ret.set((int) i, xs[(int) i]);
        }
        return ret;
    }

    public Class<?> getClass(String name) {
        return name2class.get(name);
    }

    public Simulator getSimulatorInConstruction() {
        return inConstruction;
    }

    public boolean judgeHFTorNot(String name) {
        final Class<?> clazz = name2class.get(name);
        return HighFrequencyAgent.class.isAssignableFrom(clazz);
    }

    /**
     * Takes all the accumulated initializers of this class, calls them, and stores
     * the result in the provided Simulator instance. This method is for sequential
     * or multi-thread simulations.
     *
     * @param seed the seed used to initiliaze all the objects that participate in
     *             the computation
     * @return a build {@link Simulator} instance
     */
    public Simulator makeNewSimulation(long seed) { // for sequential use
        return makeNewSimulation(seed, false, true, new AgentAllocManager.Centric());
    }

    public Simulator makeNewSimulation(long seed, AgentAllocManager.Centric am) {
        return makeNewSimulation(seed, true, true, am);
    }

    /**
     * Takes all the accumulated initializers of this class, calls them, and stores
     * the result in the provided Simulator instance.
     *
     * @param seed            the seed used to initiliaze all the objects that
     *                        participate in the computation
     * @param skippableRandom represents whether the runner use skippable random
     *                        assignments or not. Please use skippableRandome(=true)
     *                        for distributed environments. This flag changes the
     *                        random seed of agents and markets and their behaviors.
     * @return a build {@link Simulator} instance
     */
    public Simulator makeNewSimulation(long seed, boolean skippableRandom, boolean genAgents, AgentAllocManager am) {
        inConstruction = new Simulator();
        final Simulator sim = inConstruction;
        // Allows access of the various initializers to the Simulator
        // instance directly through method SimulationFactory#getSimulatorInConstruction

        // sim.GLOBAL = new LinkedHashMap<>();
        // JSON.extendDeeply(CONFIG, CONFIG);
        sim.RANDOM = new Random(seed);

        // Market initialization
        randomForMarketsSetup = skippableRandom ? sim.RANDOM.split() : sim.RANDOM;
        randomForAgentsSetup = skippableRandom ? sim.RANDOM.split() : sim.RANDOM;
        // TODO ->
        final List<Market> markets = createAllMarkets(CONFIG.get("simulation").get("markets"));
        final List<LongRange> mrange = new ArrayList<>();
        mrange.add(new LongRange(0l, markets.size()));
        sim.marketName2Ranges.put("markets", mrange);
        // <- TODO
        // Agent initialization
        sim.dm = am;
        if (genAgents) {
            createAllAgents(CONFIG.get("simulation").get("agents"), am);
        }
        // sim.GLOBAL.put("agents", dm.getBody());

        // Fundamentals
        final Fundamentals fundamentals = createFundamentals(markets,
                CONFIG.get("simulation").getOrElse("fundamentalCorrelations", "{}"));
        sim.fundamentals = fundamentals;
        // sim.GLOBAL.put("fundamentals", fundamentals);

        // Small correction to separate Agents and HighFrequencyAgents
        setupMarkets(sim.markets);
        setupAgents();

        // Parse all the sessions one by one
        sim.sessions = new ArrayList<>();

        final JSON.Value sessions = CONFIG.get("simulation").get("sessions");
        for (int i = 0; i < sessions.size(); i++) {
            final Session s = sim.new Session(); // Session is linked to a parent "Simulator" instance
            final JSON.Value json = sessions.get(i);
            s.sessionName = json.get("sessionName").toString();
            s.iterationSteps = parseIterationSteps(json);

            s.withOrderPlacement = json.get("withOrderPlacement").toBoolean();
            s.withOrderExecution = json.get("withOrderExecution").toBoolean();
            s.withPrint = json.getOrElse("withPrint", "true").toBoolean();
            s.forDummyTimeseries = (!s.withOrderPlacement && !s.withOrderExecution);
            if (json.has("forDummyTimeseries")) {
                s.forDummyTimeseries = json.get("forDummyTimeseries").toBoolean();
            }
            s.maxNormalOrders = json.getOrElse("maxNormalOrders", String.valueOf(markets.size())).toLong();
            s.maxHighFreqOrders = json.getOrElse("maxHifreqOrders", "0").toLong();
            s.highFreqSubmissionRate = json.getOrElse("hifreqSubmitRate", "1.0d").toDouble();

            final ArrayList<String> eventNames = new ArrayList<>();
            if (json.has("events")) {
                for (final Value v : json.get("events").asList()) {
                    eventNames.add(v.toString());
                }
            }
            s.eventsToInitialize = eventNames;
            sim.sessions.add(s);
        }
        // TODO
        // inConstruction = null;
        return sim;
    }

    private long parseIterationSteps(Value json) {
        if (json.has("iterationSteps")) {
            return json.get("iterationSteps").toLong();
        } else {
            return json.get("iterationDays").toLong() * CONFIG.get("numStepsOneDay").toLong();
        }
    }

    public void setupAgents() {
        // TODO ugly
        inConstruction.dm.finalSetup(inConstruction);
        /*
         * if(inConstruction.dm instanceof AllocManager.Centric) {
         * AllocManager.Centric<Agent> dm = (AllocManager.Centric<Agent>)
         * inConstruction.dm; ChunkedList<Agent> agents = new ChunkedList();
         * agents.add(dm.getChunk()); // TODO List<Agent> normalAgents = new
         * ArrayList<>(); List<Agent> hifreqAgents = new ArrayList<>(); for (Agent agent
         * : agents) { if (agent instanceof HighFrequencyAgent) {
         * hifreqAgents.add(agent); } else { normalAgents.add(agent); } }
         * inConstruction.agents = agents; inConstruction.normalAgents = normalAgents;
         * inConstruction.hifreqAgents = hifreqAgents; }
         */
    }

    public void setupMarkets(List<Market> markets) {
        for (final Market market : markets) {
            market.env = inConstruction;
        }
        inConstruction.markets = markets;
    }
}
