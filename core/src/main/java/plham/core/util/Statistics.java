package plham.core.util;

import java.io.Serializable;
import java.util.List;

public class Statistics implements Serializable {
	public interface MapDouble {
		double f(double d);
	}

	private static final long serialVersionUID = -735583688573427629L;

	public static double corrcoef(List<Double> a, List<Double> b) {
		return covariance(a, b) / (Math.sqrt(variance(a)) * Math.sqrt(variance(b)));
	}

	public static double covariance(List<Double> a, List<Double> b) {
		if (a.size() == 0) {
			return 0.0D;
		}
		return sumofproducts(a, b) / a.size() - mean(a) * mean(b);
	}

	public static List<Double> exp(List<Double> a) {
		return map(a, new MapDouble() {
			@Override
			public double f(double d) {
				return Math.exp(d);
			}
		});
	}

	public static List<Double> map(List<Double> a, MapDouble f) {
		for (int i = 0; i < a.size(); i++) {
			a.set(i, f.f(a.get(i)));
		}
		return a;
	}

	public static double mean(List<Double> a) {
		if (a.size() == 0) {
			return 0.0D;
		}
		return sum(a) / a.size();
	}

	public static double regcoef(List<Double> x, List<Double> y) {
		return covariance(x, y) / variance(x);
	}

	public static long roulette(Random random, List<Double> weights) {
		int size = weights.size();
		double total = 0.0D;
		for (int i = 0; i < size; i++) {
			total += weights.get(i);
		}
		double d = total * random.nextDouble();
		double w = 0.0D;
		for (int i = 0; i < size; i++) {
			w += weights.get(i);
			if (d <= w) {
				return i;
			}
		}
		return size - 1;
	}

	public static double sum(List<Double> a) {
		double sum = 0.0D;
		for (Double d : a) {
			sum += d.doubleValue();
		}
		return sum;
	}

	public static double sumofproducts(List<Double> a, List<Double> b) {
		assert a.size() == b.size();
		int size = a.size();
		double sum = 0.0D;
		for (int i = 0; i < size; i++) {
			sum += a.get(i) * b.get(i);
		}
		return sum;
	}

	public static double sumofsquares(List<Double> a) {
		return sumofproducts(a, a);
	}

	public static double variance(List<Double> a) {
		if (a.size() == 0) {
			return 0.0D;
		}
		double m = mean(a);
		return sumofsquares(a) / a.size() - m * m;
	}
}
