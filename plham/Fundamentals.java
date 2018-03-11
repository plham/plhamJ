package plham;

import java.io.IOException;
import java.io.ObjectStreamException;

import plham.util.MultiGeomBrownian;
import x10.core.Long;
import x10.core.Rail;
import x10.lang.Iterator;
import x10.rtt.NamedType;
import x10.rtt.ParameterizedType;
import x10.rtt.RuntimeType;
import x10.rtt.StaticFunType;
import x10.rtt.Type;
import x10.rtt.Types;
import x10.runtime.impl.java.Runtime;
import x10.serialization.SerializationProxy;
import x10.serialization.X10JavaDeserializer;
import x10.serialization.X10JavaSerializable;
import x10.serialization.X10JavaSerializer;
import x10.util.HashMap;
import x10.util.List;
import x10.util.ListIterator;
import x10.util.Map;
import x10.util.Pair;
import x10.util.Random;
import x10.util.Set;

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

@SuppressWarnings("unused")
public class Fundamentals extends x10.core.Ref implements X10JavaSerializable {
	@SuppressWarnings({ "hiding", "unchecked" })
	public static final RuntimeType<Fundamentals> $RTT = NamedType
			.<Fundamentals> make("plham.Fundamentals", Fundamentals.class);

	public RuntimeType<?> $getRTT() {
		return $RTT;
	}

	public Type<?> $getParam(int i) {
		return null;
	}

	private Object writeReplace() throws ObjectStreamException {
		return new SerializationProxy(this);
	}

	public static X10JavaSerializable $_deserialize_body(Fundamentals $_obj,
			X10JavaDeserializer $deserializer) throws IOException {
		if (Runtime.TRACE_SER) {
			Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
					+ Fundamentals.class + " calling");
		}
		$_obj.GBM = $deserializer.readObject();
		$_obj.correlations = $deserializer.readObject();
		$_obj.drifts = $deserializer.readObject();
		$_obj.g = $deserializer.readObject();
		$_obj.initials = $deserializer.readObject();
		$_obj.l = $deserializer.readObject();
		$_obj.random = $deserializer.readObject();
		$_obj.table = $deserializer.readObject();
		$_obj.volatilities = $deserializer.readObject();
		return $_obj;
	}

	public static X10JavaSerializable $_deserializer(
			X10JavaDeserializer $deserializer) throws IOException {
		Fundamentals $_obj = new Fundamentals((java.lang.System[]) null);
		$deserializer.record_reference($_obj);
		return $_deserialize_body($_obj, $deserializer);
	}

	public void $_serialize(X10JavaSerializer $serializer) throws IOException {
		$serializer.write(this.GBM);
		$serializer.write(this.correlations);
		$serializer.write(this.drifts);
		$serializer.write(this.g);
		$serializer.write(this.initials);
		$serializer.write(this.l);
		$serializer.write(this.random);
		$serializer.write(this.table);
		$serializer.write(this.volatilities);

	}

	// constructor just for allocation
	public Fundamentals(final java.lang.System[] $dummy) {
		// do nothing
	}

	public Random random;

	public Map<x10.core.Long, x10.core.Long> table;
	public Map<x10.core.Long, x10.core.Double> initials;
	public Map<x10.core.Long, x10.core.Double> drifts;
	public Map<x10.core.Long, x10.core.Double> volatilities;
	public Map<Pair<x10.core.Long, x10.core.Long>, x10.core.Double> correlations;

	public Fundamentals(final Random random) {
		this((java.lang.System[]) null);
		init(random);
	}

	// constructor for non-virtual call
	@SuppressWarnings("hiding")
	final public plham.Fundamentals init(final Random random) {
		this.fieldInitializersPlhamFundamentals();
		this.random = random;
		return this;
	}

	public long addIndex(final long id) {
		if (this.table.containsKey$Z(x10.core.Long.$box(id), Types.LONG)) {
			return x10.core.Long.$unbox(this.table.$apply(
					x10.core.Long.$box(id), Types.LONG));
		}

		return x10.core.Long
				.$unbox(this.table.$set(x10.core.Long.$box(id), Types.LONG,
						x10.core.Long.$box(this.table.size$O()), Types.LONG));
	}

	public void setInitial(final plham.Market market, final double initial) {
		this.setInitial(market.id, initial);
	}

	public void setInitial(final long id, final double initial) {
		this.addIndex(id);
		this.initials.$set(x10.core.Long.$box(id), Types.LONG,
				x10.core.Double.$box(initial), Types.DOUBLE);
	}

	public void setDrift(final plham.Market market, final double drift) {
		this.setDrift(market.id, drift);
	}

	public void setDrift(final long id, final double drift) {
		this.addIndex(id);
		this.drifts.$set(x10.core.Long.$box(id), Types.LONG,
				x10.core.Double.$box(drift), Types.DOUBLE);
	}

	public void setVolatility(final plham.Market market, final double volatility) {
		this.setVolatility(market.id, volatility);
	}

	public void setVolatility(final long id, final double volatility) {
		this.addIndex(id);
		this.volatilities.$set(x10.core.Long.$box(id), Types.LONG,
				x10.core.Double.$box(volatility), Types.DOUBLE);
	}

	public void setCorrelation(final plham.Market market1,
			final plham.Market market2, final double correlation) {
		this.setCorrelation(market1.id, market2.id, correlation);
	}

	// #line 73 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
	@SuppressWarnings("rawtypes")
	public void setCorrelation(final long id1, final long id2,
			final double correlation) {
		this.addIndex((id1));
		this.addIndex((id2));
		final Pair pair1 = new Pair<x10.core.Long, x10.core.Long>(
				(java.lang.System[]) null, Types.LONG, Types.LONG)
				.x10$util$Pair$$init$S((x10.core.Long.$box(id1)),
						(x10.core.Long.$box(id2)),
						(Pair.__0x10$util$Pair$$T__1x10$util$Pair$$U) null);
		this.correlations.$set(pair1,
				ParameterizedType.make(Pair.$RTT, Types.LONG, Types.LONG),
				x10.core.Double.$box(correlation), Types.DOUBLE);

		final Pair pair2 = new Pair<x10.core.Long, x10.core.Long>(
				(java.lang.System[]) null, Types.LONG, Types.LONG)
				.x10$util$Pair$$init$S((x10.core.Long.$box(id2)),
						(x10.core.Long.$box(id1)),
						(Pair.__0x10$util$Pair$$T__1x10$util$Pair$$U) null);
		this.correlations.$set(pair2,
				ParameterizedType.make(Pair.$RTT, Types.LONG, Types.LONG),
				x10.core.Double.$box(correlation), Types.DOUBLE);
	}

	@SuppressWarnings({ "rawtypes" })
	public void removeCorrelation(final long id1, final long id2) {
		final Pair pair1 = new Pair<x10.core.Long, x10.core.Long>(
				(java.lang.System[]) null, Types.LONG, Types.LONG)
				.x10$util$Pair$$init$S((x10.core.Long.$box(id1)),
						(x10.core.Long.$box(id2)),
						(Pair.__0x10$util$Pair$$T__1x10$util$Pair$$U) null);
		this.correlations.remove(pair1,
				ParameterizedType.make(Pair.$RTT, Types.LONG, Types.LONG));
		final Pair pair2 = new Pair<x10.core.Long, x10.core.Long>(
				(java.lang.System[]) null, Types.LONG, Types.LONG)
				.x10$util$Pair$$init$S((x10.core.Long.$box(id2)),
						(x10.core.Long.$box(id1)),
						(Pair.__0x10$util$Pair$$T__1x10$util$Pair$$U) null);
		this.correlations.remove(pair2,
				ParameterizedType.make(Pair.$RTT, Types.LONG, Types.LONG));
	}

	public double get(final Market market) {
		return this.get(market.id, market.getFundamentalPrice());
	}

	public double get(final long id) {
		return this.get(id, java.lang.Double.NaN);
	}

	@SuppressWarnings("hiding")
	public double get(final long id, final double orElse) {
		if (x10.core.Boolean.$unbox(this.table.containsKey$Z(
				x10.core.Long.$box(id), Types.LONG))) {
			final long g = x10.core.Long.$unbox(this.g.$apply(
					x10.core.Long.$box(id), Types.LONG));
			final MultiGeomBrownian map = ((plham.util.MultiGeomBrownian[]) this.GBM.value)[(int) g];

			final long l = x10.core.Long.$unbox(this.l.$apply(
					x10.core.Long.$box(id), Types.LONG));
			return map.get((l));
		}
		return orElse;
	}

	public void update() {
		final long size = this.GBM.size;
		long idx = 0L;
		final MultiGeomBrownian[] brownians = (plham.util.MultiGeomBrownian[]) this.GBM.value;
		while (idx < size) {
			final plham.util.MultiGeomBrownian brownian = brownians[(int) idx];
			brownian.nextBrownian();
			idx++;
		}
	}

	public void setup() {
		this.setup(true);
	}

	public Rail<MultiGeomBrownian> GBM;
	public Map<x10.core.Long, x10.core.Long> g;
	public Map<x10.core.Long, x10.core.Long> l;

	@SuppressWarnings({ "rawtypes", "unchecked", "hiding" })
	public void setup(final boolean inheritance) {
		final Set nodes = this.table.keySet();
		final Set pairs = this.correlations.keySet();

		final List cclist = plham.util.GraphUtils
				.<x10.core.Long> getConnectedComponents(Types.LONG, nodes,
						pairs);
		plham.util.GraphUtils.<x10.core.Long> dump(Types.LONG, cclist);

		final Map gMap = new x10.util.HashMap<x10.core.Long, x10.core.Long>(
				(java.lang.System[]) null, Types.LONG, Types.LONG)
				.x10$util$HashMap$$init$S();
		final Map lMap = new x10.util.HashMap<x10.core.Long, x10.core.Long>(
				(java.lang.System[]) null, Types.LONG, Types.LONG)
				.x10$util$HashMap$$init$S();
		long gid = 0;
		long lid = 0;
		final ListIterator iterator = cclist.iterator();
		while (iterator.hasNext$O()) {
			final Set<Long> ccitems = (Set<Long>) iterator.next$G();
			lid = 0L;

			Iterator<Long> it = ccitems.iterator();
			while (it.hasNext$O()) {
				final long id = x10.core.Long.$unbox(it.next$G());
				gMap.$set(x10.core.Long.$box(id), x10.rtt.Types.LONG,
						x10.core.Long.$box(gid), x10.rtt.Types.LONG);
				lMap.$set(x10.core.Long.$box(id), x10.rtt.Types.LONG,
						x10.core.Long.$box(lid), x10.rtt.Types.LONG);
				lid++;
			}
			gid++;
		}

		final long ccListSize = cclist.size$O();
		final Rail GBM = new Rail<MultiGeomBrownian>(
				plham.util.MultiGeomBrownian.$RTT, ccListSize);
		final ListIterator listIterator = cclist.iterator();
		final MultiGeomBrownian[] gbmValues = (MultiGeomBrownian[]) GBM.value;

		while (listIterator.hasNext$O()) {
			final Set<Long> ccItems = (Set<Long>) listIterator.next$G();
			final long ccItemSize = ccItems.size$O();
			final MultiGeomBrownian brownian = new MultiGeomBrownian(
					(java.lang.System[]) null).init(this.random, ccItemSize);
			final Rail rails = ((new Rail<x10.core.Long>(Types.LONG, ccItemSize)));

			final Iterator it = ccItems.iterator();
			final long[] railValues = ((long[]) rails.value);
			while (it.hasNext$O()) {
				final long id = x10.core.Long.$unbox(it.next$G());
				final long t = x10.core.Long.$unbox(lMap.$apply(
						x10.core.Long.$box(id), x10.rtt.Types.LONG));
				railValues[(int) t] = id;
			}

			final long max = ccItemSize - 1;
			final long[] values = (long[]) rails.value;

			long i = 0;
			while (i <= max) {
				final Rail rail = brownian.s0;
				final Map initials = this.initials;
				final double d = x10.core.Double.$unbox(this.initials.get(
						x10.core.Long.$box(values[(int) i]), Types.LONG));
				((double[]) rail.value)[(int) i] = d;
				i++;
			}
			long j = 0;
			while (j <= max) {
				final Rail rail = ((brownian.mu));
				final double d = x10.core.Double.$unbox((this.drifts)
						.getOrElse(x10.core.Long.$box(values[(int) j]),
								Types.LONG, x10.core.Double.$box(0.0),
								Types.DOUBLE));
				((double[]) rail.value)[(int) j] = d;
				j++;
			}

			long k = 0;
			while (k <= max) {
				final double d = x10.core.Double.$unbox(this.volatilities
						.getOrElse(x10.core.Long.$box(values[(int) k]),
								Types.LONG, x10.core.Double.$box(0.0),
								Types.DOUBLE));
				((double[]) brownian.sigma.value)[(int) k] = d;
				k++;
			}

			long l = 0;
			while (l < max) {
				long m = 0;
				while (m <= max) {
					final Pair t$30275 = new Pair<x10.core.Long, x10.core.Long>(
							(java.lang.System[]) null, Types.LONG, Types.LONG)
							.x10$util$Pair$$init$S(
									x10.core.Long.$box(values[(int) l]),
									x10.core.Long.$box(values[(int) m]),
									(Pair.__0x10$util$Pair$$T__1x10$util$Pair$$U) null);
					final double d1 = x10.core.Double.$unbox(this.correlations
							.getOrElse(((t$30275)), ParameterizedType.make(
									Pair.$RTT, Types.LONG, Types.LONG),
									x10.core.Double.$box(0.0), Types.DOUBLE));
					((double[]) ((Rail[]) brownian.cor.value)[(int) l].value)[(int) m] = d1;

					final Pair t$30282 = new Pair<x10.core.Long, x10.core.Long>(
							(java.lang.System[]) null, Types.LONG, Types.LONG)
							.x10$util$Pair$$init$S(
									x10.core.Long.$box(values[(int) m]),
									x10.core.Long.$box(values[(int) l]),
									(Pair.__0x10$util$Pair$$T__1x10$util$Pair$$U) null);
					final double d2 = x10.core.Double.$unbox(this.correlations
							.getOrElse(((t$30282)), ParameterizedType.make(
									Pair.$RTT, Types.LONG, Types.LONG),
									x10.core.Double.$box(0.0), Types.DOUBLE));
					((double[]) ((Rail[]) brownian.cor.value)[(int) m].value)[(int) l] = d2;
					m++;
				}
				l++;
			}

			long n = 0;
			while (n <= max) {
				((double[]) ((Rail[]) brownian.cor.value)[(int) n].value)[(int) n] = 1.0;
				n++;
			}

			gid = ccListSize;
			final Iterator it2 = ccItems.iterator();
			while (it2.hasNext$O()) {
				gid = x10.core.Long.$unbox(gMap.$apply(
						x10.core.Long.$box(x10.core.Long.$unbox(it2.next$G())),
						x10.rtt.Types.LONG));
				break;
			}
			gbmValues[(int) gid] = brownian;
		}
		boolean inheritanceNext = inheritance;
		if (inheritance) {
			inheritanceNext = this.GBM != null;
		}
		if (inheritanceNext) {
			Iterator it = nodes.iterator();
			final MultiGeomBrownian[] brownians = (plham.util.MultiGeomBrownian[]) GBM.value;
			while (it.hasNext$O()) {
				final long id = x10.core.Long
						.$unbox(((x10.lang.Iterator<x10.core.Long>) it)
								.next$G());
				if (x10.core.Boolean.$unbox(this.g.containsKey$Z(
						x10.core.Long.$box(id), Types.LONG))) {
					final plham.util.MultiGeomBrownian brownian1 = (brownians[(int) x10.core.Long
							.$unbox(gMap.$apply(x10.core.Long.$box(id),
									x10.rtt.Types.LONG))]);
					final long id1 = x10.core.Long
							.$unbox(((x10.util.HashMap<x10.core.Long, x10.core.Long>) lMap)
									.$apply__0x10$util$HashMap$$K$G(x10.core.Long
											.$box(id)));
					final long id2 = x10.core.Long.$unbox(this.g.$apply(
							x10.core.Long.$box(id), Types.LONG));
					final plham.util.MultiGeomBrownian brownian2 = ((plham.util.MultiGeomBrownian[]) this.GBM.value)[(int) id2];
					final long id3 = x10.core.Long.$unbox(this.l.$apply(
							x10.core.Long.$box(id), Types.LONG));
					final double t$30343 = ((double[]) brownian2.state.value)[(int) id3];
					((double[]) brownian1.state.value)[(int) id1] = t$30343;
				}
			}
		}

		System.out.println("#Fundamentals.setup() finished");
		System.out.println("# #groups " + GBM.size);
		this.GBM = GBM;
		this.g = gMap;
		this.l = lMap;
	}

	public static class $Main extends x10.runtime.impl.java.Runtime {
		public static void main(java.lang.String[] args) {
			new $Main().start(args);
		}

		@Override
		@SuppressWarnings("hiding")
		public void runtimeCallback(final Rail<String> args) {
			Fundamentals.main(args);
		}
	}

	// the original app-main method
	@SuppressWarnings({ "rawtypes", "unchecked", "cast" })
	public static void main(final Rail<java.lang.String> arg) {
		final Random random = ((new Random((java.lang.System[]) null)
				.x10$util$Random$$init$S()));
		final long N = 4L;
		final long m = 2L;
		final x10.core.fun.Fun_0_1 closure = ((new plham.Fundamentals.Closure()));
		final Rail id = ((new Rail<x10.core.Long>(Types.LONG, 6L, closure,
				(Rail.__1$1x10$lang$Long$3x10$lang$Rail$$T$2) null)));
		final plham.Fundamentals f = ((plham.Fundamentals) (new plham.Fundamentals(
				(java.lang.System[]) null).init(((x10.util.Random) (random)))));

		final long max = 3L;
		long i = 0;
		{
			final long[] values = ((long[]) id.value);
			while (i <= max) {
				double d1 = (double) 100 * random.nextDouble$O();
				d1 += (double) 100;
				f.setInitial((long) values[(int) i], d1);

				// #line 207 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30367 = ((long) values[(int) i]);

				// #line 207 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final double t$30368 = random.nextDouble$O();

				// #line 207 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final double t$30369 = ((1.0E-6) * (((double) (t$30368))));

				// #line 207 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				f.setDrift((long) (t$30367), (double) (t$30369));

				// #line 208 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30370 = ((long) values[(int) i]);

				// #line 208 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final double t$30371 = random.nextDouble$O();

				// #line 208 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final double t$30372 = ((0.001) * (((double) (t$30371))));

				// #line 208 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				f.setVolatility((long) (t$30370), (double) (t$30372));

				// #line 209 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long i$29804min$30359 = 0L;

				// #line 209 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long i$29804max$30360 = 3L;

				// #line 209 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				long i$30356 = i$29804min$30359;
				{

					// #line 209
					// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
					for (; true;) {

						// #line 209
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long t$30357 = i$30356;

						// #line 209
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final boolean t$30358 = ((t$30357) <= (((long) (i$29804max$30360))));

						// #line 209
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						if (!(t$30358)) {

							// #line 209
							// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
							break;
						}

						// #line 209
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long j$30353 = i$30356;

						// #line 210
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final double t$30348 = random.nextDouble$O();

						// #line 210
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final boolean t$30349 = ((t$30348) < (((double) (0.3))));

						// #line 210
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						if (t$30349) {

							// #line 211
							// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
							final long t$30350 = ((long) values[(int) i]);

							// #line 211
							// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
							final long t$30351 = ((long) values[(int) j$30353]);

							// #line 211
							// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
							final double t$30352 = random.nextDouble$O();

							// #line 211
							// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
							f.setCorrelation((long) (t$30350),
									(long) (t$30351), (double) (t$30352));
						}

						// #line 209
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long t$30354 = i$30356;

						// #line 209
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long t$30355 = ((t$30354) + (((long) (1L))));

						// #line 209
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						i$30356 = t$30355;
					}
				}
				i++;
			}
		}

		// #line 215 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
		f.setup();

		// #line 219 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
		f.update();

		// #line 220 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
		final long i$29858min$30466 = 1L;

		// #line 220 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
		final long i$29858max$30467 = 1000L;

		// #line 220 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
		long i$30396 = i$29858min$30466;
		{

			// #line 220 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
			final long[] id$value$30484 = ((long[]) id.value);

			// #line 220 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
			for (; true;) {

				// #line 220 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30397 = i$30396;

				// #line 220 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final boolean t$30398 = ((t$30397) <= (((long) (i$29858max$30467))));

				// #line 220 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				if (!(t$30398)) {

					// #line 220
					// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
					break;
				}

				// #line 220 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30393 = i$30396;

				// #line 221 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long i$29840min$30389 = 0L;

				// #line 221 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30390 = 6L;

				// #line 221 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long i$29840max$30391 = 5L;

				// #line 221 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				long i$30386 = i$29840min$30389;
				{

					// #line 221
					// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
					for (; true;) {

						// #line 221
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long t$30387 = i$30386;

						// #line 221
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final boolean t$30388 = ((t$30387) <= (((long) (i$29840max$30391))));

						// #line 221
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						if (!(t$30388)) {

							// #line 221
							// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
							break;
						}

						// #line 221
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long i$30383 = i$30386;

						// #line 222
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final x10.io.Printer t$30379 = ((x10.io.Printer) (x10.io.Console
								.get$OUT()));

						// #line 222
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long t$30380 = ((long) id$value$30484[(int) i$30383]);

						// #line 222
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final double t$30381 = f.get((long) (t$30380));

						// #line 222
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final java.lang.String t$30382 = (((x10.core.Double
								.$box(t$30381))) + (" "));

						// #line 222
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						t$30379.print(((java.lang.String) (t$30382)));

						// #line 221
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long t$30384 = i$30386;

						// #line 221
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long t$30385 = ((t$30384) + (((long) (1L))));

						// #line 221
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						i$30386 = t$30385;
					}
				}

				// #line 224 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final x10.io.Printer t$30392 = ((x10.io.Printer) (x10.io.Console
						.get$OUT()));

				// #line 224 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				t$30392.println();

				// #line 225 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				f.update();

				// #line 220 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30394 = i$30396;

				// #line 220 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30395 = ((t$30394) + (((long) (1L))));

				// #line 220 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				i$30396 = t$30395;
			}
		}

		// #line 230 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
		final long i$29876min$30468 = 2L;

		// #line 230 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
		final long i$29876max$30469 = 3L;

		// #line 230 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
		long i$30405 = i$29876min$30468;
		{

			// #line 230 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
			final long[] id$value$30485 = ((long[]) id.value);

			// #line 230 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
			for (; true;) {

				// #line 230 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30406 = i$30405;

				// #line 230 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final boolean t$30407 = ((t$30406) <= (((long) (i$29876max$30469))));

				// #line 230 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				if (!(t$30407)) {

					// #line 230
					// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
					break;
				}

				// #line 230 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long i$30402 = i$30405;

				// #line 231 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30399 = ((long) id$value$30485[(int) i$30402]);

				// #line 231 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final double t$30400 = random.nextDouble$O();

				// #line 231 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final double t$30401 = ((0.001) * (((double) (t$30400))));

				// #line 231 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				f.setVolatility((long) (t$30399), (double) (t$30401));

				// #line 230 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30403 = i$30405;

				// #line 230 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30404 = ((t$30403) + (((long) (1L))));

				// #line 230 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				i$30405 = t$30404;
			}
		}

		// #line 236 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
		final long i$29912min$30470 = N;

		// #line 236 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
		final long t$30471 = 6L;

		// #line 236 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
		final long i$29912max$30472 = 5L;

		// #line 236 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
		long i$30441 = i$29912min$30470;
		{

			// #line 236 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
			final long[] id$value$30486 = ((long[]) id.value);

			// #line 236 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
			for (; true;) {

				// #line 236 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30442 = i$30441;

				// #line 236 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final boolean t$30443 = ((t$30442) <= (((long) (i$29912max$30472))));

				// #line 236 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				if (!(t$30443)) {

					// #line 236
					// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
					break;
				}

				// #line 236 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long i$30438 = i$30441;

				// #line 237 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30426 = ((long) id$value$30486[(int) i$30438]);

				// #line 237 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final double t$30427 = ((double) (long) (((long) (100L))));

				// #line 237 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final double t$30428 = random.nextDouble$O();

				// #line 237 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final double t$30429 = ((t$30427) * (((double) (t$30428))));

				// #line 237 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final double t$30430 = ((double) (long) (((long) (100L))));

				// #line 237 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final double t$30431 = ((t$30429) + (((double) (t$30430))));

				// #line 237 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				f.setInitial((long) (t$30426), (double) (t$30431));

				// #line 238 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30432 = ((long) id$value$30486[(int) i$30438]);

				// #line 238 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final double t$30433 = random.nextDouble$O();

				// #line 238 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final double t$30434 = ((1.0E-6) * (((double) (t$30433))));

				// #line 238 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				f.setDrift((long) (t$30432), (double) (t$30434));

				// #line 239 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30435 = ((long) id$value$30486[(int) i$30438]);

				// #line 239 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final double t$30436 = random.nextDouble$O();

				// #line 239 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final double t$30437 = ((0.001) * (((double) (t$30436))));

				// #line 239 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				f.setVolatility((long) (t$30435), (double) (t$30437));

				// #line 240 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long i$29894min$30423 = 0L;

				// #line 240 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30424 = 6L;

				// #line 240 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long i$29894max$30425 = 5L;

				// #line 240 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				long i$30420 = i$29894min$30423;
				{

					// #line 240
					// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
					for (; true;) {

						// #line 240
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long t$30421 = i$30420;

						// #line 240
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final boolean t$30422 = ((t$30421) <= (((long) (i$29894max$30425))));

						// #line 240
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						if (!(t$30422)) {

							// #line 240
							// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
							break;
						}

						// #line 240
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long j$30417 = i$30420;

						// #line 241
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final double t$30408 = random.nextDouble$O();

						// #line 241
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final boolean t$30409 = ((t$30408) < (((double) (0.3))));

						// #line 241
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						if (t$30409) {

							// #line 242
							// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
							final long t$30410 = ((long) id$value$30486[(int) i$30438]);

							// #line 242
							// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
							final long t$30411 = ((long) id$value$30486[(int) j$30417]);

							// #line 242
							// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
							final double t$30412 = random.nextDouble$O();

							// #line 242
							// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
							f.setCorrelation((long) (t$30410),
									(long) (t$30411), (double) (t$30412));
						} else {

							// #line 243
							// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
							final double t$30413 = random.nextDouble$O();

							// #line 243
							// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
							final boolean t$30414 = ((t$30413) < (((double) (0.3))));

							// #line 243
							// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
							if (t$30414) {

								// #line 244
								// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
								final long t$30415 = ((long) id$value$30486[(int) i$30438]);

								// #line 244
								// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
								final long t$30416 = ((long) id$value$30486[(int) j$30417]);

								// #line 244
								// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
								f.removeCorrelation((long) (t$30415),
										(long) (t$30416));
							}
						}

						// #line 240
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long t$30418 = i$30420;

						// #line 240
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long t$30419 = ((t$30418) + (((long) (1L))));

						// #line 240
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						i$30420 = t$30419;
					}
				}

				// #line 236 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30439 = i$30441;

				// #line 236 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30440 = ((t$30439) + (((long) (1L))));

				// #line 236 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				i$30441 = t$30440;
			}
		}

		// #line 248 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
		f.setup();

		// #line 252 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
		f.update();

		// #line 253 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
		final long i$29948min$30473 = 1L;

		// #line 253 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
		final long i$29948max$30474 = 1000L;

		// #line 253 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
		long i$30461 = i$29948min$30473;
		{

			// #line 253 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
			final long[] id$value$30487 = ((long[]) id.value);

			// #line 253 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
			for (; true;) {

				// #line 253 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30462 = i$30461;

				// #line 253 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final boolean t$30463 = ((t$30462) <= (((long) (i$29948max$30474))));

				// #line 253 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				if (!(t$30463)) {

					// #line 253
					// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
					break;
				}

				// #line 253 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30458 = i$30461;

				// #line 254 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long i$29930min$30454 = 0L;

				// #line 254 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30455 = 6L;

				// #line 254 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long i$29930max$30456 = 5L;

				// #line 254 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				long i$30451 = i$29930min$30454;
				{

					// #line 254
					// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
					for (; true;) {

						// #line 254
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long t$30452 = i$30451;

						// #line 254
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final boolean t$30453 = ((t$30452) <= (((long) (i$29930max$30456))));

						// #line 254
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						if (!(t$30453)) {

							// #line 254
							// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
							break;
						}

						// #line 254
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long i$30448 = i$30451;

						// #line 255
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final x10.io.Printer t$30444 = ((x10.io.Printer) (x10.io.Console
								.get$OUT()));

						// #line 255
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long t$30445 = ((long) id$value$30487[(int) i$30448]);

						// #line 255
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final double t$30446 = f.get((long) (t$30445));

						// #line 255
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final java.lang.String t$30447 = (((x10.core.Double
								.$box(t$30446))) + (" "));

						// #line 255
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						t$30444.print(((java.lang.String) (t$30447)));

						// #line 254
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long t$30449 = i$30451;

						// #line 254
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						final long t$30450 = ((t$30449) + (((long) (1L))));

						// #line 254
						// "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
						i$30451 = t$30450;
					}
				}

				// #line 257 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final x10.io.Printer t$30457 = ((x10.io.Printer) (x10.io.Console
						.get$OUT()));

				// #line 257 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				t$30457.println();

				// #line 258 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				f.update();

				// #line 253 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30459 = i$30461;

				// #line 253 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				final long t$30460 = ((t$30459) + (((long) (1L))));

				// #line 253 "/home/dsl/workspace/plhamK/plham/Fundamentals.x10"
				i$30461 = t$30460;
			}
		}
	}

	final public Fundamentals getFundamentals() {
		return Fundamentals.this;
	}

	@SuppressWarnings("unchecked")
	final public void fieldInitializersPlhamFundamentals() {
		this.random = null;
		this.table = new HashMap<x10.core.Long, x10.core.Long>(
				(java.lang.System[]) null, Types.LONG, Types.LONG)
				.x10$util$HashMap$$init$S();
		this.initials = new x10.util.HashMap<x10.core.Long, x10.core.Double>(
				(java.lang.System[]) null, Types.LONG, Types.DOUBLE)
				.x10$util$HashMap$$init$S();
		this.drifts = new x10.util.HashMap<x10.core.Long, x10.core.Double>(
				(java.lang.System[]) null, Types.LONG, Types.DOUBLE)
				.x10$util$HashMap$$init$S();
		this.volatilities = new x10.util.HashMap<x10.core.Long, x10.core.Double>(
				(java.lang.System[]) null, Types.LONG, Types.DOUBLE)
				.x10$util$HashMap$$init$S();
		this.correlations = new x10.util.HashMap<Pair<x10.core.Long, x10.core.Long>, x10.core.Double>(
				(java.lang.System[]) null, ParameterizedType.make(Pair.$RTT,
						Types.LONG, Types.LONG), Types.DOUBLE)
				.x10$util$HashMap$$init$S();
		this.GBM = null;
		this.g = null;
		this.l = null;
	}

	@SuppressWarnings("rawtypes")
	final public static class Closure extends x10.core.Ref implements
			x10.core.fun.Fun_0_1, X10JavaSerializable {
		@SuppressWarnings({ "hiding", "unchecked" })
		public static final RuntimeType<Closure> $RTT = StaticFunType
				.<Closure> make(Closure.class,
						new Type[] { ParameterizedType.make(
								x10.core.fun.Fun_0_1.$RTT, Types.LONG,
								Types.LONG) });

		public RuntimeType<?> $getRTT() {
			return $RTT;
		}

		public Type<?> $getParam(int i) {
			return null;
		}

		private Object writeReplace() throws java.io.ObjectStreamException {
			return new SerializationProxy(this);
		}

		public static X10JavaSerializable $_deserialize_body(
				plham.Fundamentals.Closure $_obj,
				X10JavaDeserializer $deserializer) throws IOException {
			if (Runtime.TRACE_SER) {
				Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of "
						+ Closure.class + " calling");
			}
			return $_obj;
		}

		public static X10JavaSerializable $_deserializer(
				X10JavaDeserializer $deserializer) throws IOException {
			Fundamentals.Closure $_obj = new Fundamentals.Closure(
					(java.lang.System[]) null);
			$deserializer.record_reference($_obj);
			return $_deserialize_body($_obj, $deserializer);
		}

		public void $_serialize(X10JavaSerializer $serializer)
				throws IOException {
			// do nothing
		}

		// constructor just for allocation
		public Closure(final java.lang.System[] $dummy) {
			// do nothing
		}

		// dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
		public Object $apply(final Object a1, final Type t1) {
			return x10.core.Long.$box(apply(x10.core.Long.$unbox(a1)));

		}

		// dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
		public long apply(final Object a1, final Type t1) {
			return apply(x10.core.Long.$unbox(a1));

		}

		@SuppressWarnings("static-method")
		public long apply(final long i) {
			return i * 10L;
		}

		public Closure() {
			// do nothing
		}

	}

}
