package plham.util;

import java.util.concurrent.atomic.AtomicLong;

/*
 * proted from x10.util.Random
 */

public final class Random {
	private static AtomicLong defaultGen = new AtomicLong(System.nanoTime());
	private static long GOLDEN_GAMMA = -7046029254386353131L;
	private static float FLOAT_ULP = 0.0F;
	private static double DOUBLE_ULP = 0.0;

	private long seed;
	private long gamma;
	private double storedGaussian;
	private boolean haveStoredGaussian = false;

	public Random(long seed, long gamma) {
		this.seed = seed;
		this.gamma = gamma;
	}

	public Random(long seed) {
		this(seed, GOLDEN_GAMMA);
	}

	public Random() {
		long s = defaultGen.getAndAdd(2 * GOLDEN_GAMMA);
		seed = mix64(s);
		gamma = mixGamma(s + GOLDEN_GAMMA);
	}

	public Random split() {
		return new Random(mix64(nextSeed()), mixGamma(nextSeed()));
	}

	public int nextInt() {
		return mix32(nextSeed());
	}

	public int nextInt(int maxPlus1) {
		if (maxPlus1 <= 0) {
			return 0;
		}

		int n = maxPlus1;

		if ((n & -n) == n) {
			return nextInt() & (n - 1);
		}

		int mask = 1;
		while ((n & ~mask) != 0) {
			mask <<= 1;
			mask |= 1;
		}

		int x;
		do {
			x = nextInt() & mask;
		} while (x >= n);

		return x;
	}

	public void nextBytes(byte[] buf) {
		int i = 0;
		while (true) {
			long x = nextLong();
			while (i <= 8L) {
				if (i >= buf.length) {
					return;
				}
				long l = x & 255L;
				buf[i] = ((byte) l);
				i++;
				x >>= 8;
			}
		}
	}

	public long nextLong() {
		return mix64(nextSeed());
	}

	public long nextLong(long maxPlus1) {
		if (maxPlus1 <= 0) {
			return 0;
		}
		long n = maxPlus1;
		if ((n & -n) == n) {
			return nextLong() & (n - 1);
		}

		long mask = 1;
		while ((n & ~mask) != 0) {
			mask <<= 1;
			mask |= 1;
		}

		long x;
		do {
			x = nextLong() & mask;
		} while (x >= n);

		return x;
	}

	public boolean nextBoolean() {
		return nextInt() < 0;
	}

	public float nextFloat() {
		return (nextInt() >>> 8) * FLOAT_ULP;
	}

	public double nextDouble() {
		return (nextLong() >>> 11) * DOUBLE_ULP;
	}

	public double nextGaussian() {
		if (haveStoredGaussian) {
			haveStoredGaussian = false;
			return storedGaussian;
		} else {
			double u1;
			double u2;
			double s;
			do {
				u1 = 2.0 * nextDouble() - 1.0;
				u2 = 2.0 * nextDouble() - 1.0;
				s = u1 * u1 + u2 * u2;
			} while (s >= 1.0 || s == 0.0);
			double m = Math.sqrt(-2.0 * Math.log(s) / s);
			storedGaussian = u2 * m;
			haveStoredGaussian = true;
			return u1 * m;
		}
	}

	private long nextSeed() {
		return (seed += gamma);
	}

	private static long mix64(long z) {
		long l = z;
		long l1 = ((l) >>> (int) (((33L))));
		long l2 = ((l) ^ (((l1))));
		l = ((l2) * (((-49064778989728563L))));
		long l3 = ((l) >>> (int) (((33L))));
		long l4 = ((l) ^ (((l3))));
		l = ((l4) * (((-4265267296055464877L))));
		long l5 = ((l) >>> (int) (((33L))));
		long l6 = ((l) ^ (((l5))));
		return l6;
	}

	private static int mix32(long z) {
		long l = z;
		long l1 = l >>> (int) 33L;
		long l2 = l ^ l1;
		l = l2 * -49064778989728563L;
		long l3 = l >>> (int) 33L;
		long l4 = l ^ l3;
		l = l4 * -4265267296055464877L;
		long l5 = l >>> (int) 32L;
		return (int) l5;
	}

	private static long mix64variant13(long z) {
		long l = z;
		long l1 = l >>> (int) 30L;
		long l2 = l ^ l1;
		l = l2 * -4658895280553007687L;
		long l3 = l >>> (int) 27L;
		long l4 = l ^ l3;
		l = l4 * -7723592293110705685L;
		long l5 = l >>> (int) 31L;
		long l6 = l ^ l5;
		return l6;
	}

	private static long mixGamma(long z) {
		long l = z;
		long l1 = mix64variant13((l));
		l = l1 | 1L;
		long l2 = l >>> (int) 1L;
		long l3 = l ^ l2;
		int n = Long.bitCount(l3);
		long l4 = n;
		boolean b = l4 >= 24L;
		if (b) {
			l = l ^ -6148914691236517206L;
		}
		return l;
	}
}
