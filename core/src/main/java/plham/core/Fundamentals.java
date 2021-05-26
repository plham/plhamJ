package plham.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import plham.core.util.GraphUtils;
import plham.core.util.GraphUtils.KeyPair;
import plham.core.util.MultiGeomBrownian;
import plham.core.util.Random;

/**
 * A class for fundamental values of multiple markets (assets). This can generate multivariate geometric Brownian motion
 * (MGBM).
 * <p>
 * Calling <code>setup()</code> instantiates MGBM. Just setting the parameters (initials, drifts, volatilities,
 * correlations) does not modify the behavior of MGBM; so call <code>setup()</code> to re-instanciate (
 * <code>setup(true)</code> inherits the current state of MGBM).
 * <p>
 * The <code>initials</code> must be specified (no defaults). On the <code>drafts</code>, <code>volatilities</code>,
 * <code>correlations</code>, their default values are 0.0.
 */
public class Fundamentals implements Serializable {
    private static final long serialVersionUID = -752778551974516783L;

    public static List<Long> getKey(long id1, long id2) {
        List<Long> key = new ArrayList<>();
        key.add(id1);
        key.add(id2);
        return key;
    }

    public Map<KeyPair<Long>, Double> correlations = new LinkedHashMap<>();
    public Map<Long, Double> drifts = new LinkedHashMap<>();
    public Map<Long, Integer> g;
    public MultiGeomBrownian[] GBM;
    public Map<Long, Double> initials = new LinkedHashMap<>();

    public Map<Long, Integer> l;

    public Random random;

    public Map<Long, Long> table = new LinkedHashMap<>();

    public Map<Long, Double> volatilities = new LinkedHashMap<>();

    public Fundamentals(Random random) {
        this.random = random;
    }

    protected long addIndex(long id) {
        if (table.containsKey(id)) {
            return table.get(id);
        }
        table.put(id, (long) table.size());
        return table.get(id);
    }

    public double get(long id) {
        return get(id, Double.NaN);
    }

    public double get(long id, double orElse) {
        if (table.containsKey(id)) {
            return GBM[g.get(id).intValue()].get(l.get(id));
        }
        return orElse;
    }

    public double get(Market market) {
        return get(market.id, market.getFundamentalPrice());
    }

    double getOrElse(Map<Long, Double> map, long k, double v) {
        Double r = map.get(k);
        return (r == null) ? v : r;
    }

    double getOrElse2(Map<KeyPair<Long>, Double> map, KeyPair<Long> k, double v) {
        Double r = map.get(k);
        return (r == null) ? v : r;
    }

    public void removeCorrelation(long id1, long id2) {
        correlations.remove(new KeyPair<>(id1, id2));
        correlations.remove(new KeyPair<>(id2, id1));
    }

    public void setCorrelation(long id1, long id2, double correlation) {
        addIndex(id1);
        addIndex(id2);
        correlations.put(new KeyPair<>(id1, id2), correlation);
        correlations.put(new KeyPair<>(id2, id1), correlation);
    }

    public void setCorrelation(Market market1, Market market2, double correlation) {
        this.setCorrelation(market1.id, market2.id, correlation);
    }

    public void setDrift(long id, double drift) {
        addIndex(id);
        drifts.put(id, drift);
    }

    public void setDrift(Market market, double drift) {
        this.setDrift(market.id, drift);
    }

    public void setInitial(long id, double initial) {
        addIndex(id);
        initials.put(id, initial);
    }

    public void setInitial(Market market, double initial) {
        this.setInitial(market.id, initial);
    }

    public void setup() {
        setup(true);
    }

    public void setup(boolean inheritance) {
        Set<Long> nodes = table.keySet();
        Set<KeyPair<Long>> pairs = correlations.keySet();
        List<Set<Long>> cclist = GraphUtils.getConnectedComponents(nodes, pairs);
        // GraphUtils.dump(cclist);

        Map<Long, Integer> g = new LinkedHashMap<>();
        Map<Long, Integer> l = new LinkedHashMap<>();

        int gid;
        int lid;

        gid = 0;
        for (Set<Long> ccitems : cclist) {
            lid = 0;
            for (long id : ccitems) {
                g.put(id, gid);
                l.put(id, lid++);
            }
            gid++;
        }

        MultiGeomBrownian[] GBM = new MultiGeomBrownian[cclist.size()];
        for (Set<Long> ccitems : cclist) {
            int N = ccitems.size();
            MultiGeomBrownian gbm = new MultiGeomBrownian(random, N);

            long[] m = new long[N]; // local index ==> market.id
            for (long id : ccitems) {
                m[l.get(id)] = id;
            }

            for (int i = 0; i < N; i++) {
                gbm.s0[i] = initials.get(m[i]);
            }
            for (int i = 0; i < N; i++) {
                gbm.mu[i] = getOrElse(drifts, m[i], 0.0);
            }
            for (int i = 0; i < N; i++) {
                gbm.sigma[i] = getOrElse(volatilities, m[i], 0.0);
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    gbm.cor[i][j] = getOrElse2(correlations, new KeyPair<>(m[i], m[j]), 0.0);
                    gbm.cor[j][i] = getOrElse2(correlations, new KeyPair<>(m[j], m[i]), 0.0);
                }
            }
            for (int i = 0; i < N; i++) {
                gbm.cor[i][i] = 1.0;
            }

            gid = cclist.size(); // Error if ccitems is empty
            for (long id : ccitems) {
                gid = g.get(id); // Use the 1st one (all the same)
                break;
            }
            GBM[gid] = gbm;
        }

        // Copying the internal states.
        if (inheritance && this.GBM != null) {
            for (long id : nodes) {
                if (this.g.containsKey(id)) {
                    GBM[g.get(id)].state[l.get(id)] = this.GBM[this.g.get(id)].state[this.l.get(id)];
                }
            }
        }

        System.out.println("#Fundamentals.setup() finished");
        System.out.println("# #groups " + GBM.length);

        this.GBM = GBM;
        this.g = g;
        this.l = l;
    }

    public void setVolatility(long id, double volatility) {
        addIndex(id);
        volatilities.put(id, volatility);
    }

    public void setVolatility(Market market, double volatility) {
        this.setVolatility(market.id, volatility);
    }

    public void update() {
        for (MultiGeomBrownian gbm : GBM) {
            gbm.nextBrownian();
        }
    }

}
