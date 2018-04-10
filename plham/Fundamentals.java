package plham;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import plham.util.Random;
import java.util.Set;

import plham.util.GraphUtils;
import plham.util.MultiGeomBrownian;

/**
 * A class for fundamental values of multiple markets (assets). This can
 * generate multivariate geometric Brownian motion (MGBM).
 * <p>
 * Calling <code>setup()</code> instantiates MGBM. Just setting the parameters
 * (initials, drifts, volatilities, correlations) does not modify the behavior
 * of MGBM; so call <code>setup()</code> to re-instanciate (
 * <code>setup(true)</code> inherits the current state of MGBM).
 * <p>
 * The <code>initials</code> must be specified (no defaults). On the
 * <code>drafts</code>, <code>volatilities</code>, <code>correlations</code>,
 * their default values are 0.0.
 */

public class Fundamentals implements Serializable {
	private static final long serialVersionUID = -752778551974516783L;
	/*
	static type Key = Pair[Long,Long];
	public var random:Random;
	public var table:Map[Long,Long] = new HashMap[Long,Long](); // Market.id --> GBM internal index
	public var initials:Map[Long,Double] = new HashMap[Long,Double]();
	public var drifts:Map[Long,Double] = new HashMap[Long,Double]();
	public var volatilities:Map[Long,Double] = new HashMap[Long,Double]();
	public var correlations:Map[Pair[Long,Long],Double] = new HashMap[Pair[Long,Long],Double]();
	*/

	public Random random;
	public Map<Long, Long> table = new HashMap<Long, Long>();
	public Map<Long, Double> initials = new HashMap<Long, Double>();
	public Map<Long, Double> drifts = new HashMap<Long, Double>();
	public Map<Long, Double> volatilities = new HashMap<Long, Double>();
	public Map<List<Long>, Double> correlations = new HashMap<List<Long>, Double>();

	/*
	static type Key = Pair[Long,Long];
	*/
	public static List<Long> getKey(long id1, long id2) {
		List<Long> key = new ArrayList<Long>();
		key.add(id1);
		key.add(id2);
		return key;
	}

	/*
	public def this(random:Random) {
		this.random = random;
	}
	*/
	public Fundamentals(Random random) {
		this.random = random;
	}

	/*
	protected def addIndex(id:Long):Long {
		if (table.containsKey(id)) {
			return table(id);
		}
		return table(id) = table.size();
	}
	*/
	protected long addIndex(long id) {
		if (table.containsKey(id)) {
			return table.get(id);
		}
		table.put(id, (long) table.size());
		return table.get(id);
	}

	/*
	public def setInitial(market:Market, initial:Double) {
		this.setInitial(market.id, initial);
	}
	*/
	public void setInitial(Market market, double initial) {
		this.setInitial(market.id, initial);
	}

	/*
	public def setInitial(id:Long, initial:Double) {
		addIndex(id);
		this.initials(id) = initial;
	}
	*/
	public void setInitial(long id, double initial) {
		addIndex(id);
		this.initials.put(id, initial);
	}

	/*
	public def setDrift(market:Market, drift:Double) {
		this.setDrift(market.id, drift);
	}
	*/

	public void setDrift(Market market, double drift) {
		this.setDrift(market.id, drift);
	}

	/*

	public def setDrift(id:Long, drift:Double) {
		addIndex(id);
		this.drifts(id) = drift;
	}
	*/

	public void setDrift(long id, double drift) {
		addIndex(id);
		this.drifts.put(id, drift);
	}

	/*
	public def setVolatility(market:Market, volatility:Double) {
		this.setVolatility(market.id, volatility);
	}
	*/
	public void setVolatility(Market market, double volatility) {
		this.setVolatility(market.id, volatility);
	}

	/*
	public def setVolatility(id:Long, volatility:Double) {
		addIndex(id);
		this.volatilities(id) = volatility;
	}
	*/
	public void setVolatility(long id, double volatility) {
		addIndex(id);
		this.volatilities.put(id, volatility);
	}

	/*
	public def setCorrelation(market1:Market, market2:Market, correlation:Double) {
		this.setCorrelation(market1.id, market2.id, correlation);
	}
	*/
	public void setCorrelation(Market market1, Market market2,
			double correlation) {
		this.setCorrelation(market1.id, market2.id, correlation);
	}

	/*
	public def setCorrelation(id1:Long, id2:Long, correlation:Double) {
		addIndex(id1);
		addIndex(id2);
		this.correlations(Key(id1, id2)) = correlation;
		this.correlations(Key(id2, id1)) = correlation;
	}
	*/
	public void setCorrelation(long id1, long id2, double correlation) {
		addIndex(id1);
		addIndex(id2);
		this.correlations.put(Fundamentals.getKey(id1, id2), correlation);
		this.correlations.put(Fundamentals.getKey(id2, id1), correlation);
	}

	/*
	public def removeCorrelation(id1:Long, id2:Long) {
		this.correlations.remove(Key(id1, id2));
		this.correlations.remove(Key(id2, id1));
	}
	*/
	public void removeCorrelation(long id1, long id2) {
		this.correlations.remove(Fundamentals.getKey(id1, id2));
		this.correlations.remove(Fundamentals.getKey(id2, id1));
	}

	/*
	public def get(market:Market):Double = this.get(market.id, market.getFundamentalPrice());
	*/
	public double get(Market market) {
		return get(market.id, market.getFundamentalPrice());
	}

	/*
	public def get(id:Long):Double = this.get(id, Double.NaN);
	*/
	public double get(long id) {
		return get(id, Double.NaN);
	}

	/*
	public def get(id:Long, orElse:Double):Double {
		if (this.table.containsKey(id)) {
			return this.GBM(this.g(id)).get(this.l(id));
		}
		return orElse;
	}
	*/
	public double get(long id, double orElse) {
		if (table.containsKey(id)) {
			return this.GBM.get(g.get(id).intValue()).get(l.get(id));
		}
		return orElse;
	}

	/*
	public def update() {
		for (gbm in this.GBM) {
			gbm.nextBrownian();
		}
	}
	*/
	public void update() {
		for (MultiGeomBrownian gbm : GBM) {
			gbm.nextBrownian();
		}
	}

	/*
	public def setup() {
		this.setup(true);
	}
	*/
	public void setup() {
		setup(true);
	}

	/*
	public var GBM:Rail[MultiGeomBrownian];
	public var g:Map[Long,Long];
	public var l:Map[Long,Long];
	*/
	public List<MultiGeomBrownian> GBM;
	public Map<Long, Long> g;
	public Map<Long, Long> l;

	/*

	public def setup(inheritance:Boolean) {
		val nodes = table.keySet();
		val pairs = correlations.keySet();
		val cclist = GraphUtils.getConnectedComponents(nodes, pairs);
		GraphUtils.dump(cclist);

		val g = new HashMap[Long,Long](); // market.id --> group id
		val l = new HashMap[Long,Long](); // market.id --> local index

		var gid:Long;
		var lid:Long;

		gid = 0;
		for (ccitems in cclist) {
			lid = 0;
			for (id in ccitems) {
				g(id) = gid;
				l(id) = lid++;
			}
			gid++;
		}

		val GBM = new Rail[MultiGeomBrownian](cclist.size());
		for (ccitems in cclist) {
			val N = ccitems.size();
			val gbm = new MultiGeomBrownian(random, N);

			val m = new Rail[Long](N); // local index ==> market.id
			for (id in ccitems) {
				m(l(id)) = id;
			}

			for (i in 0..(N - 1)) {
				gbm.s0(i) = this.initials.get(m(i));
			}
			for (i in 0..(N - 1)) {
				gbm.mu(i) = this.drifts.getOrElse(m(i), 0.0);
			}
			for (i in 0..(N - 1)) {
				gbm.sigma(i) = this.volatilities.getOrElse(m(i), 0.0);
			}
			for (i in 0..(N - 1)) {
				for (j in 0..(N - 1)) {
					gbm.cor(i)(j) = this.correlations.getOrElse(Key(m(i), m(j)), 0.0);
					gbm.cor(j)(i) = this.correlations.getOrElse(Key(m(j), m(i)), 0.0);
				}
			}
			for (i in 0..(N - 1)) {
				gbm.cor(i)(i) = 1.0;
			}

			gid = cclist.size(); // Error if ccitems is empty
			for (id in ccitems) {
				gid = g(id); // Use the 1st one (all the same)
				break;
			}
			GBM(gid) = gbm;
		}

		// Copying the internal states.
		if (inheritance && this.GBM != null) {
			for (id in nodes) {
				if (this.g.containsKey(id)) {
					GBM(g(id)).state(l(id)) = this.GBM(this.g(id)).state(this.l(id));
				}
			}
		}

		Console.OUT.println("#Fundamentals.setup() finished");
		Console.OUT.println("# #groups " + GBM.size);
	//		Console.OUT.println("# group id " + g);
	//		Console.OUT.println("# local index " + l);

		this.GBM = GBM;
		this.g = g;
		this.l = l;
	}
	*/
	public void setup(boolean inheritance) {
		Set<Long> nodes = table.keySet();
		Set<List<Long>> pairs = correlations.keySet();
		List<Set<Long>> cclist = GraphUtils
				.getConnectedComponents(nodes, pairs);
		// GraphUtils.dump(cclist);

		@SuppressWarnings("hiding")
		Map<Long, Long> g = new HashMap<Long, Long>();
		@SuppressWarnings("hiding")
		Map<Long, Long> l = new HashMap<Long, Long>();

		long gid;
		long lid;

		gid = 0;
		for (Set<Long> ccitems : cclist) {
			lid = 0;
			for (long id : ccitems) {
				g.put(id, gid);
				l.put(id, lid++);
			}
		}

		@SuppressWarnings("hiding")
		List<MultiGeomBrownian> GBM = new ArrayList<MultiGeomBrownian>(
				cclist.size());
		for (Set<Long> ccitems : cclist) {
			long N = ccitems.size();
			MultiGeomBrownian gbm = new MultiGeomBrownian(random, N);

			List<Long> m = new ArrayList<Long>((int) N);
			for (long id : ccitems) {
				m.set(l.get(id).intValue(), id);
			}
			for (long i = 0; i < N; i++) {
				gbm.s0.set((int) i, initials.get(m.get((int) i)));
			}
			for (long i = 0; i < N; i++) {
				long k = m.get((int) i);
				if (drifts.containsKey(k)) {
					gbm.mu.set((int) i, drifts.get(k));
				} else {
					gbm.mu.set((int) i, 0.0);
				}
			}
			for (long i = 0; i < N; i++) {
				long k = m.get((int) i);
				if (drifts.containsKey(k)) {
					gbm.sigma.set((int) i, volatilities.get(k));
				} else {
					gbm.sigma.set((int) i, 0.0);
				}
			}
			for (long i = 0; i < N; i++) {
				for (long j = 0; j < N; j++) {
					List<Long> k1 = Fundamentals.getKey(m.get((int) i),
							m.get((int) j));
					List<Long> k2 = Fundamentals.getKey(m.get((int) j),
							m.get((int) i));
					if (correlations.containsKey(k1)) {
						gbm.cor.get((int) i).set((int) j, correlations.get(k1));
					} else {
						gbm.cor.get((int) i).set((int) j, 0.0);
					}
					if (correlations.containsKey(k2)) {
						gbm.cor.get((int) j).set((int) i, correlations.get(k2));
					} else {
						gbm.cor.get((int) j).set((int) i, 0.0);
					}
				}
			}
			for (long i = 0; i < N; i++) {
				gbm.cor.get((int) i).set((int) i, 1.0);
			}
			gid = cclist.size();
			for (long id : ccitems) {
				gid = g.get(id);
				break;
			}
			GBM.set((int) gid, gbm);
		}

		// Copying the internal states.
		if (inheritance && this.GBM != null) {
			for (long id : nodes) {
				if (this.g.containsKey(id)) {
					List<Double> state = GBM.get(g.get((int) id).intValue()).state;
					state.set(l.get(id).intValue(), this.GBM.get(this.g.get(id)
							.intValue()).state.get(this.l.get(id).intValue()));
				}
			}
		}

		this.GBM = GBM;
		this.g = g;
		this.l = l;
	}
	/*
	public static def main(Rail[String]) {
		val random = new Random();
		val N = 4; // # of initial markets
		val m = 2; // # of additional markets

		val id = new Rail[Long](N + m, (i:Long) => i * 10);
		
		val f = new Fundamentals(random);
		for (i in 0..(N - 1)) {
			f.setInitial(id(i), 100 * random.nextDouble() + 100);
			f.setDrift(id(i), 1e-6 * random.nextDouble());
			f.setVolatility(id(i), 1e-3 * random.nextDouble());
			for (j in 0..(N - 1)) {
				if (random.nextDouble() < 0.3) {
					f.setCorrelation(id(i), id(j), random.nextDouble());
				}
			}
		}
		f.setup();

		// SESSION 1

		f.update();
		for (t in 1..1000) {
			for (i in 0..(N + m - 1)) {
				Console.OUT.print(f.get(id(i)) + " ");
			}
			Console.OUT.println();
			f.update();
		}

		// MODIFY PARAMETERS

		for (i in 2..(N - 1)) {
			f.setVolatility(id(i), 1e-3 * random.nextDouble()); // Change volatilities for i = 2,..,N-1
		}

		// ADDITIONAL MARKETS

		for (i in N..(N + m - 1)) {
			f.setInitial(id(i), 100 * random.nextDouble() + 100);
			f.setDrift(id(i), 1e-6 * random.nextDouble());
			f.setVolatility(id(i), 1e-3 * random.nextDouble());
			for (j in 0..(N + m - 1)) {
				if (random.nextDouble() < 0.3) {
					f.setCorrelation(id(i), id(j), random.nextDouble());
				} else if (random.nextDouble() < 0.3) {
					f.removeCorrelation(id(i), id(j));
				}
			}
		}
		f.setup();

		// SESSION 2

		f.update();
		for (t in 1..1000) {
			for (i in 0..(N + m - 1)) {
				Console.OUT.print(f.get(id(i)) + " ");
			}
			Console.OUT.println();
			f.update();
		}
	}	 */

}
