package plham.core.util;

import java.io.Serializable;

import cassia.util.random.Gaussian;

/**
 * A helper class adding more utilities to Random.
 */

public class RandomHelper implements Serializable {
	private static final long serialVersionUID = -2193216876120126299L;

	private Gaussian g;
	private Random random;

	public RandomHelper(Random random) {
		this.random = random;
		g = new Gaussian(random);

	}

	public Boolean nextBoolean() {
		return random.nextBoolean();
	}

	public boolean nextBoolean(double d) {
		double rd = random.nextDouble();
		return rd < d;
	}

	public double nextDouble() {
		return random.nextDouble();
	}

	public double nextDouble(double max) {
		return random.nextDouble() * max;
	}

	public double nextExponential(double lambda) {
		return lambda * -Math.log(this.nextDouble());
	}

	public float nextFloat() {
		return random.nextFloat();
	}

	public float nextFloat(float max) {
		return random.nextFloat() * max;
	}

	public double nextGaussian() {
		return g.nextGaussian();
	}

	public int nextInt(int max) {
		return random.nextInt(max);
	}

	public long nextLong(long max) {
		return random.nextLong(max);
	}

	public double nextNormal(double mu, double sigma) {
		return mu + nextGaussian() * sigma;
	}

	public double nextUniform(double min, double max) {
		return this.nextDouble() * (max - min) + min;
	}

}
