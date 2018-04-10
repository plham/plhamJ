package plham.util;

import java.io.Serializable;

public class Statistics implements Serializable {
	private static final long serialVersionUID = -735583688573427629L;
	
	/*
	public static def sum(a:List[Double]):Double {
		var sum:Double = 0.0;
		for (i in 0..(a.size() - 1)) {
			sum += a(i);
		}
		return sum;
	}
	
	public static def sumofproducts(a:List[Double], b:List[Double]):Double {
		assert a.size() == b.size();
		var sum:Double = 0.0;
		for (i in 0..(a.size() - 1)) {
			sum += a(i) * b(i);
		}
		return sum;
	}
	
	public static def sumofsquares(a:List[Double]):Double {
		return sumofproducts(a, a);
	}
	
	public static def mean(a:List[Double]):Double {
		if (a.size() == 0) return 0.0;
		return sum(a) / a.size();
	}
	
	public static def variance(a:List[Double]):Double {
		if (a.size() == 0) return 0.0;
		val m = mean(a);
		return sumofsquares(a) / a.size() - m * m;
	}
	
	public static def covariance(a:List[Double], b:List[Double]):Double {
		if (a.size() == 0) return 0.0;
		return sumofproducts(a, b) / a.size() - mean(a) * mean(b);
	}

	public static def corrcoef(a:List[Double], b:List[Double]):Double {
		return covariance(a, b) / (Math.sqrt(variance(a)) * Math.sqrt(variance(b)));
	}

	public static def regcoef(x:List[Double], y:List[Double]):Double {
		return covariance(x, y) / variance(x);
	}

	public static def map(a:List[Double], f:(Double)=>Double):List[Double] {
		for (i in 0..(a.size() - 1)) {
			a(i) = f(a(i));
		}
		return a;
	}

	public static def log(a:List[Double]):List[Double] {
		return map(a, (x:Double) => Math.log(x));
	}

	public static def exp(a:List[Double]):List[Double] {
		return map(a, (x:Double) => Math.exp(x));
	}

	public static def roulette(random:Random, weights:List[Double]):Long {
		// The standard roulette selection.
		val size = weights.size();
		var total:Double = 0.0;
		for (i in 0..(size - 1)) {
			total += weights(i);
		}
		val d = total * random.nextDouble();
		var w:Double = 0.0;
		for (i in 0..(size - 1)) {
			w += weights(i);
			if (d <= w) {
				return i;
			}
		}
		return size - 1;
	}
	*/

	/*
	public static def main(args:Rail[String]) {
		val a = new ArrayList[Double]();
		a.add(1.0);
		a.add(2.0);
		a.add(3.0);
		a.add(4.0);
		a.add(5.0);
		Console.OUT.println(a);
		Console.OUT.println(log(a));
		Console.OUT.println(sum(a));
		Console.OUT.println(sum(a.subList(0, a.size()))); // Of a time window.
		Console.OUT.println(sum(a.subList(0, 2)));
		Console.OUT.println(sumofproducts(a, a));
		Console.OUT.println(sumofsquares(a));
		Console.OUT.println(corrcoef(a, a));
	}
	*/

}
