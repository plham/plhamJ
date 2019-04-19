package plham.util;

import java.io.Serializable;

import cassia.util.random.Gaussian;
import plham.util.Random;

/**
 * A helper class adding more utilities to Random.
 */

public class RandomHelper implements Serializable {
	private static final long serialVersionUID = -2193216876120126299L;

	/*
	public var random:Random;
	public var g:Gaussian;
	*/
	private Random random;
	private Gaussian g;

	/*
	public def this(random:Random) {
		this.random = random;
		this.g = new Gaussian(random);
	}
	*/
	public RandomHelper(Random random) {
		this.random = random;
		this.g = new Gaussian(random);

	}

	/*
	public def nextBoolean() = this.random.nextBoolean();
	*/
	public Boolean nextBoolean() {
		return random.nextBoolean();
	}

	/*
	public def nextBoolean(p:Double) = this.random.nextDouble() < p;
	 */
	public boolean nextBoolean(double d) {
		double rd = random.nextDouble();
		return rd < d;
	}

	/*
	public def nextDouble() = this.random.nextDouble();
	 */
	public double nextDouble() {
		return random.nextDouble();
	}

	/*
	public def nextDouble(max:Double) = this.random.nextDouble() * max;
	 */
	public double nextDouble(double max) {
		return random.nextDouble() * max;
	}

	/*
	public def nextFloat() = this.random.nextFloat();
	 */
	public float nextFloat() {
		return random.nextFloat();
	}

	/*
	public def nextFloat(max:Float) = this.random.nextFloat() * max;
	 */
	public float nextFloat(float max) {
		return random.nextFloat() * max;
	}

	/*
	public def nextInt(max:Int) = this.random.nextInt(max);
	 */
	public int nextInt(int max) {
		return random.nextInt(max);
	}

	/*
	public def nextLong(max:Long) = this.random.nextLong(max);
	 */
	public long nextLong(long max) {
		return random.nextLong(max);
	}

	/*
	public def nextGaussian() = this.g.nextGaussian(); // Java compatible
	 */
	public double nextGaussian() {
		return this.g.nextGaussian();
	}

	/*
	public def nextUniform(min:Double, max:Double):Double {
		return this.nextDouble() * (max - min) + min;
	}
	 */
	public double nextUniform(double min, double max) {
		return this.nextDouble() * (max - min) + min;
	}

	/*
	public def nextNormal(mu:Double, sigma:Double):Double {
		return mu + this.nextGaussian() * sigma;
	}
	 */
	public double nextNormal(double mu, double sigma) {
		return mu + this.nextGaussian() * sigma;
	}

	/*
	public def nextExponential(lambda:Double):Double {
		return lambda * -Math.log(this.nextDouble());
	}
	 */
	public double nextExponential(double lambda) {
		return lambda * -Math.log(this.nextDouble());
	}

}
