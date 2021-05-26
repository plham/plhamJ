package plham.core.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cassia.util.JSON;
import handist.collections.LongRange;
import plham.core.Agent;
import plham.core.Event;
import plham.core.Fundamentals;
import plham.core.IndexMarket;
import plham.core.Market;
import plham.core.util.Random;

public class Simulator {

    /**
     * Class representing a session of a market
     * <p>
     * All the characteristics of a session are gathered in this class
     *
     */
    public class Session {
        public List<String> eventsToInitialize;
        public boolean forDummyTimeseries;
        public long iterationSteps;
        public long maxHighFreqOrders;
        public long maxNormalOrders;
        public String sessionName;
        public boolean withOrderExecution;
        public boolean withOrderPlacement;

        boolean withPrint;

        void print() {
            System.out.println("# SESSION: " + sessionName);
            System.out.println("# iterationSteps: " + iterationSteps);
            System.out.println("# withOrderPlacement: " + withOrderPlacement);
            System.out.println("# withOrderExecution: " + withOrderExecution);
            System.out.println("# withPrint: " + withPrint);
            System.out.println("# forDummyTimeseries: " + forDummyTimeseries);
            System.out.println("# maxNormalOrders: " + maxNormalOrders);
            System.out.println("# maxHifreqOrders: " + maxHighFreqOrders);
        }
    }

    public static final long DEBUG = 0L;

    public static long isDebug() {
        return DEBUG;
    }

    public List<Agent> agents;
    // public Map<String, Object> GLOBAL;
    public List<Event> sessionEvents;
    public List<Agent> hifreqAgents;
    public Map<String, List<LongRange>> marketName2Ranges;

    public List<Market> markets;

    public List<Agent> normalAgents;
    public long numAgents;
    public Random RANDOM;

    public List<Session> sessions;

    public Fundamentals fundamentals;

    public Simulator() {
    }

    public Agent getAgentByName(JSON.Value json) {
//		return this.<Agent>getItemByName(json);
        return getAgentByName(json.toString());
    }

    public Agent getAgentByName(String name) {
        return agents.stream().filter(a -> {
            return a.name.equals(name);
        }).findFirst().get();
    }

//	public List<Agent> getAgentsByName(JSON.Value json) {
//		return this.<Agent>getItemsByName(json);
//	}

//	public List<Agent> getAgentsByName(List<String> names) {
//		return getItemsByName(names, (long) names.size());
//	}

    public List<Agent> getAgentsByName(String name) {
//		return getItemsByName(name);
        ArrayList<Agent> toReturn = new ArrayList<>();
        agents.stream().filter(a -> {
            return a.name.equals(name);
        }).forEach(a -> toReturn.add(a));
        return toReturn;
    }

    public Event getEventByName(JSON.Value json) {
//		return this.<Event>getItemByName(json);
        return getEventByName(json.toString());
    }

    public Event getEventByName(String name) {
//		return getItemByName(name);
        return sessionEvents.stream().filter(e -> {
            return e.getName().equals(name);
        }).findFirst().get();
    }

//	public List<Event> getEventsByName(JSON.Value json) {
//		return this.<Event>getItemsByName(json);
//	}
//
//	public List<Event> getEventsByName(List<String> names) {
//		return getItemsByName(names, (long) names.size());
//	}

    public List<Event> getEventsByName(String name) {
//		return getItemsByName(name);
        ArrayList<Event> toReturn = new ArrayList<>();
        sessionEvents.stream().filter(a -> {
            return a.getName().equals(name);
        }).forEach(a -> toReturn.add(a));
        return toReturn;
    }

//	public <T> T getItemByName(JSON.Value json) {
//		List<T> items = getItemsByName(json);
//		assert items.size() == 1 : "getItemByName() got more than one object";
//		return items.get(0);
//	}

//	public <T> T getItemByName(String name) {
//		List<T> items = getItemsByName(name);
//		assert items.size() == 1 : "getItemByName() got more than one object";
//		return items.get(0);
//	}

    public <T> T getItemByName0(Map<String, List<T>> kv, JSON.Value json) {
        List<T> items = getItemsByName0(kv, json);
        assert items.size() == 1 : "getItemByName0() got more than one object";
        return items.get(0);
    }

    public <T> T getItemByName0(Map<String, List<T>> kv, String name) {
        List<T> items = getItemsByName0(kv, name);
        assert items.size() == 1 : "getItemByName0() got more than one object";
        return items.get(0);
    }

//	public <T> List<T> getItemsByName(JSON.Value json) {
//		if (json.isList()) {
//			List<T> items = new ArrayList<>();
//			for (final JSON.Value name : json.asList()) {
//				items.add(getItemByName(name.toString()));
//			}
//			return items;
//		}
//		return getItemsByName(json.toString());
//	}
//
//	public <T> List<T> getItemsByName(List<String> names, long n) {
//		List<T> items = new ArrayList<>();
//		for (long i = 0; i < n; i++) {
//			items.addAll(getItemsByName(names.get((int) i)));
//		}
//		return items;
//	}

//	@SuppressWarnings("unchecked")
//	public <T> List<T> getItemsByName(String name) {
//		return (List<T>) GLOBAL.get(name);
//	}

    public <T> List<T> getItemsByName0(Map<String, List<T>> kv, JSON.Value json) {
        if (json.isList()) {
            List<JSON.Value> l = json.asList();
            List<T> result = new ArrayList<>();
            for (JSON.Value value : l) {
                result.addAll(getItemsByName0(kv, value));
            }
            return result;
        }
        return getItemsByName0(kv, json.toString());
    }

    public <T> List<T> getItemsByName0(Map<String, List<T>> kv, List<String> names, long n) {
        List<T> items = new ArrayList<>();
        for (long i = 0; i < n; i++) {
            List<T> r = getItemsByName0(kv, names.get((int) i));
            if (r == null) {
                System.out.println("~~~~" + ":" + kv + ":" + names.get((int) i));
            } else
                items.addAll(r);
        }
        return items;
    }

    public <T> List<T> getItemsByName0(Map<String, List<T>> kv, String name) {
        return kv.get(name);
    }

    public Market getMarketByName(JSON.Value json) {
        return marketConverter1(getItemByName0(marketName2Ranges, json));
    }

    public Market getMarketByName(String name) {
        return marketConverter1(getItemByName0(marketName2Ranges, name));
    }

    public List<Market> getMarketsByName(JSON.Value json) {
        return marketConverterM(getItemsByName0(marketName2Ranges, json));
    }

    public List<Market> getMarketsByName(List<String> names) {
        return marketConverterM(getItemsByName0(marketName2Ranges, names, names.size()));
    }

    public List<Market> getMarketsByName(String name) {
        return marketConverterM(getItemsByName0(marketName2Ranges, name));
    }

    public Random getRandom() {
        return RANDOM;
    }

    private Market marketConverter1(LongRange range) {
        return markets.get((int) range.from);
    }

    private List<Market> marketConverterM(List<LongRange> ranges) {
        List<Market> result = new ArrayList<>();
        for (LongRange range : ranges) {
            for (long i = range.from; i < range.to; i++) {
                result.add(markets.get((int) i));
            }
        }
        return result;
    }

    public void updateFundamentals(Fundamentals f) {
        f.update();
    }

    public void updateMarketsUsingFundamentalPrice(List<Market> markets, Fundamentals fundamentals) {
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

    public void updateMarketsUsingMarketPrice(List<Market> markets, Fundamentals fundamentals) {
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
}
