package cassia.util.random;

import java.io.Serializable;
import plham.util.Random;

public class Gaussian implements Serializable {
	private static final long serialVersionUID = -3828581207744757485L;
	/*
	var state:Boolean;
	var g:Double;
	var random:Random;
	*/

	public boolean state;
	public double g;
	public Random random;

	/*
	public def this(random:Random) {
		this.state = false;
		this.g = -1;
		this.random = random;
	}
	*/

	public Gaussian(Random random) {
		this.state = false;
		this.g = -1;
		this.random = random;
	}

	/*
	public def nextGaussian():Double {
		if (state) {
			state = false;
			return this.g;
		} else {
			state = true;
			var v1:Double;
			var v2:Double;
			var s:Double;
			do {
				v1 = 2.0 * random.nextDouble() - 1.0;
				v2 = 2.0 * random.nextDouble() - 1.0;
				s = v1 * v1 + v2 * v2;
			} while (s >= 1.0);
			
			var norm:Double = Math.sqrt(-2.0 * Math.log(s) / s);
			this.g = v2 * norm;
			return v1 * norm;
		}
	}
	*/

	public double nextGaussian() {
		if (state) {
			state = false;
			return this.g;
		} else {
			state = true;
			double v1;
			double v2;
			double s;
			do {
				v1 = 2.0 * random.nextDouble() - 1.0;
				v2 = 2.0 * random.nextDouble() - 1.0;
				s = v1 * v1 + v2 * v2;
			} while (s >= 1.0);

			double norm = Math.sqrt(-2.0 * Math.log(s) / s);
			this.g = v2 * norm;
			return v1 * norm;
		}
	}

	/*
	public def nextGaussian(mu:Double, sigma:Double) {
		return mu + sigma * this.nextGaussian();
	}
	*/
	public double nextGaussian(double mu, double sigma) {
		return mu + sigma * this.nextGaussian();
	}

	/*
	public static def gaussDenseValue(x:Double, mu:Double, sigma:Double):Double{
		val out = Math.exp( -1*(x-mu)*(x-mu)/(2*sigma*sigma) )/Math.pow(2*Math.PI*sigma*sigma,0.5);
		return out;
	}
	*/
	public static double gaussDenseValue(double x, double mu, double sigma) {
		return Math.exp(-1 * (x - mu) * (x - mu) / (2 * sigma * sigma))
				/ Math.pow(2 * Math.PI * sigma * sigma, 0.5);
	}

	/*
	public static def gaussCumulativeValue(a:Double, b:Double, delta:Double, mu:Double, sigma:Double):Double{
		assert a<b && delta > 0.0 && delta < 1.0 && !a.isInfinite() && !b.isInfinite(): "gaussCumulativeValueError";
		var out:Double = 0.0;
		val n = (b-a)/delta;
		for (var i:Long = 0; i<=n; i++) {
			val v = a + i*delta;
			out = out + gaussDenseValue(v, mu, sigma)*delta;
		}
		return out;
	}
	*/
	public static double gaussCumulativeValue(double a, double b, double delta,
			double mu, double sigma) {
		assert a < b && delta > 0.0 && delta < 1.0
				&& !(Double.valueOf(a).isInfinite())
				&& !(Double.valueOf(b).isInfinite()) : "gaussCumulativeValueError";
		double out = 0.0;
		double n = (b - a) / delta;
		for (long i = 0; i <= n; i++) {
			double v = a + i * delta;
			out = out + gaussDenseValue(v, mu, sigma) * delta;

		}
		return out;
	}

	/*
	public static def gaussExpectedValue(a:Double, b:Double, delta:Double, mu:Double, sigma:Double):Double{
		assert a<b && delta > 0.0 && delta < 1.0 && !a.isInfinite() && !b.isInfinite(): "gaussExpectedValueError";
		var out:Double = 0.0;
		val n = (b-a)/delta;
		for (var i:Long = 0; i<=n; i++) {
			val v = a + i*delta;
			out = out + v*gaussDenseValue(v, mu, sigma)*delta;
		}
		return out;
	}
	*/
	public static double gaussExpectedValue(double a, double b, double delta,
			double mu, double sigma) {
		assert a < b && delta > 0.0 && delta < 1.0
				&& !(Double.valueOf(a).isInfinite())
				&& !(Double.valueOf(b).isInfinite()) : "gaussExpectedValueError";

		double out = 0.0;
		double n = (b - a) / delta;
		for (long i = 0; i <= n; i++) {
			double v = a + i * delta;
			out = out + v * gaussDenseValue(v, mu, sigma) * delta;
		}
		return out;
	}

	/*
	public static def confidence(confInterval:Double):Double{
		var value:Double = 0.5;
		val delta = Math.pow(10,-5);
		var i:Long = 0;
		var x:Double = 0.00;
		do{
			x = i*delta;
			value = value + gaussDenseValue(x, 0.0, 1.0)*delta;
			i++; 
		}while(value <= confInterval);
		return x;
	}
	*/
	public static double doubleconfidence(double confInterval) {
		double value = 0.5;
		double delta = Math.pow(10, -5);
		long i = 0;
		double x = 0.00;
		do {
			x = i * delta;
			value = value + gaussDenseValue(x, 0.0, 1.0) * delta;
			i++;
		} while (value <= confInterval);
		return x;
	}

	/*
	public static def main(Rail[String]) {
		val std = 0.01;
		val g = new Gaussian(new Random()); // MEMO: main()
		for (val t in 1..1000) {
			Console.OUT.println(g.nextGaussian() * std);
		}
	}
	 */

}
