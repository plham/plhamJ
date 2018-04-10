package plham.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import plham.util.Random;

import cassia.util.random.Gaussian;

public class MultiGeomBrownian implements Serializable {
	private static final long serialVersionUID = 3360288287000813047L;
	/*
	public var random:Random;
	public var gaussian:Gaussian;
	public var s0:Rail[Double];
	public var mu:Rail[Double];
	public var sigma:Rail[Double];
	public var cor:Rail[Rail[Double]];
	public var dt:Double;
	public var dim:Long;
	public var chol:Rail[Rail[Double]];
	public var state:Rail[Double];
	public var logType:boolean; 
	public var g:Rail[Double];
	public var c:Rail[Double];
	public var initialCheck:Boolean;
	public def this(random:Random, s0:Rail[Double], mu:Rail[Double], sigma:Rail[Double], cor:Rail[Rail[Double]], dt:Double, logType:boolean) {
		this.random = random;
		this.gaussian = new Gaussian(random);
		this.s0 = s0;
		this.mu = mu;
		this.sigma = sigma;
		this.cor = cor;
		this.chol = Cholesky.decompose(cor);
		this.dt = dt;
		this.dim = mu.size;
		this.state = new Rail[Double](dim);
		this.initialCheck = true;
		this.g = new Rail[Double](dim);
		this.c = new Rail[Double](dim);
		this.logType = logType;
		val dim = this.dim;
		assert dim == s0.size;
		assert dim == mu.size;
		assert dim == sigma.size;
		assert dim == chol.size;
		for (i in 0..(dim - 1)) {
			for (j in 0..(i - 1)) {
				assert chol(j)(i) == 0.0;
			}
		}
		//Console.OUT.println("testConst:"+this.logType);
	}
	*/
	public Random random;
	public Gaussian gaussian;
	public List<Double> s0;
	public List<Double> mu;
	public List<Double> sigma;
	public List<List<Double>> cor;
	public double dt;
	public long dim;
	public List<List<Double>> chol;
	public List<Double> state;
	public boolean logType;
	public List<Double> g;
	public List<Double> c;
	public boolean initialCheck;

	/*
	public def this(random:Random, dim:Long) {
		this(random, dim, true);
	}
	*/
	public MultiGeomBrownian(Random random, long dim) {
		this(random, dim, true);
	}

	/*
	public def this(random:Random, dim:Long, logType:boolean) {
		this.random = random;
		this.gaussian = new Gaussian(random);
		this.mu = new Rail[Double](dim);
		this.sigma = new Rail[Double](dim);
		this.cor = new Rail[Rail[Double]](dim, (Long) => new Rail[Double](dim));
		this.chol = null;
		this.s0 = new Rail[Double](dim);
		this.dt = 1.0;
		this.dim = dim;
		this.state = new Rail[Double](dim);
		this.initialCheck = true;
		this.g = new Rail[Double](dim);
		this.c = new Rail[Double](dim);
		this.logType = logType;
		//Console.OUT.println("testConst:"+this.logType);
	}
	*/

	public MultiGeomBrownian(Random random, long dim, boolean logType) {
		this.random = random;
		this.gaussian = new Gaussian(random);
		this.mu = new ArrayList<Double>((int) dim);
		this.sigma = new ArrayList<Double>((int) dim);
		this.cor = new ArrayList<List<Double>>();
		this.chol = null;
		this.s0 = new ArrayList<Double>((int) dim);
		this.dt = 1.0;
		this.dim = dim;
		this.state = new ArrayList<Double>((int) dim);
		this.initialCheck = true;
		this.g = new ArrayList<Double>((int) dim);
		this.c = new ArrayList<Double>((int) dim);
		this.logType = logType;
	}

	/*
	public def nextBrownian():Rail[Double] {
		var out:Rail[Double] = new Rail[Double]();
		if(this.logType){
			//Console.OUT.println("trueLog");
			out = nextBrownian2();
		}else{
			//Console.OUT.println("falseLog");
			out = nextBrownian3();
		}
		return out;
	}
	*/

	public List<Double> nextBrownian() {
		List<Double> out = new ArrayList<Double>();
		if (this.logType) {
			out = nextBrownian2();
		} else {
			out = nextBrownian3();
		}
		return out;
	}

	/*
	public def nextBrownian2():Rail[Double] {
		if (this.chol == null) {
			this.chol = Cholesky.decompose(this.cor);
		}
		val dim = this.dim;
		for (i in 0..(dim - 1)) {
			this.g(i) = gaussian.nextGaussian() ;
		}
		for (i in 0..(dim - 1)) {
			this.c(i) = 0.0;
			for (j in 0..i) {
				this.c(i) += this.g(j) * this.chol(i)(j);
			}
		}
		for (i in 0..(dim - 1)) {
			//this.state(i) += this.mu(i) * this.dt + this.sigma(i) * this.c(i) * dt * dt;
			this.state(i) += (this.mu(i) - sigma(i) * sigma(i) * 0.5) * this.dt + this.sigma(i) * this.c(i) * Math.sqrt(dt);
			this.g(i) = this.s0(i) * Math.exp(this.state(i));
		}
		return this.g;
	}
	*/

	public List<Double> nextBrownian2() {
		if (this.chol == null) {
			this.chol = Cholesky.decompose(this.cor);
		}
		for (long i = 0; i < dim; i++) {
			this.g.set((int) i, gaussian.nextGaussian());
		}
		for (long i = 0; i < dim - 1; i++) {
			this.c.set((int) i, 0.0);
			for (long j = 0; j < i; j++) {
				double d = this.c.get((int) i);
				this.c.set(
						(int) i,
						d + this.g.get((int) j)
								* this.chol.get((int) i).get((int) j));

			}
		}
		for (long i = 0; i < dim - 1; i++) {
			double d1 = this.state.get((int) i);
			double d2 = this.g.get((int) i);
			this.state.set(
					(int) i,
					d1
							+ ((this.mu.get((int) i) - sigma.get((int) i)
									* sigma.get((int) i) * 0.5)
									* this.dt + this.sigma.get((int) i)
									* this.c.get((int) i) * Math.sqrt(dt)));
			this.g.set(
					(int) i,
					d2
							+ (this.s0.get((int) i) * Math.exp(this.state
									.get((int) i))));
		}
		return this.g;
	}

	/*
	public def nextBrownian3():Rail[Double] {
		val dim = this.dim;
		if(this.initialCheck){
			for (i in 0..(dim - 1)) {
				this.g(i) = this.s0(i);
			}
			this.initialCheck = false;
		}

		if (this.chol == null) {
			this.chol = Cholesky.decompose(this.cor);
		}

		val hoge = new Rail[Double](dim);
		for (i in 0..(dim - 1)) {
			hoge(i) = gaussian.nextGaussian() ;
		}
		for (i in 0..(dim - 1)) {
			this.c(i) = 0.0;
			for (j in 0..i) {
				this.c(i) += hoge(j) * this.chol(i)(j);
			}
		}
		for (i in 0..(dim - 1)) {
			//this.state(i) = this.mu(i) * this.dt + this.sigma(i) * this.c(i) * dt * dt;
			this.state(i) = (this.mu(i) - sigma(i) * sigma(i) * 0.5) * this.dt + this.sigma(i) * this.c(i) * Math.sqrt(dt);
			this.g(i) = this.g(i)*( 1+this.state(i) );
		}
		return this.g;
	}
	*/

	public List<Double> nextBrownian3() {
		if (this.initialCheck) {
			for (long i = 0; i < dim - 1; i++) {
				this.g.set((int) i, this.s0.get((int) i));
			}
			this.initialCheck = false;
		}

		if (this.chol == null) {
			this.chol = Cholesky.decompose(this.cor);
		}

		List<Double> hoge = new ArrayList<Double>((int) dim);
		for (long i = 0; i < dim - 1; i++) {
			hoge.set((int) i, gaussian.nextGaussian());
		}
		for (long i = 0; i < dim - 1; i++) {
			this.c.set((int) i, 0.0);
			for (long j = 0; j < i; j++) {
				double d = this.c.get((int) i);
				this.c.set(
						(int) i,
						d
								+ (hoge.get((int) j) * this.chol.get((int) i)
										.get((int) j)));
			}
		}
		for (long i = 0; i < dim - 1; i++) {
			this.state.set((int) i, (this.mu.get((int) i) - sigma.get((int) i)
					* sigma.get((int) i) * 0.5)
					* this.dt
					+ this.sigma.get((int) i)
					* this.c.get((int) i)
					* Math.sqrt(dt));
			this.g.set((int) i,
					this.g.get((int) i) * (1 + this.state.get((int) i)));
		}
		return this.g;
	}

	/*
	public def get(i:Long):Double {
		return this.g(i);
	}
	*/
	public double get(long i) {
		return this.get(i);
	}

	/*
	public static def main(Rail[String]) {
		// X10's very intelligent type inference gives rigorous constraints;
		// so we have to avoid filling the array with all zeros, and to achive
		// this we have to substitute zeros for the non-zero elements.
		val dim = 3;
		val s0 = new Rail[Double]([300.0, 200.0, 100.0]);
		val mu = new Rail[Double]([1.0, 0.0, 0.0]); mu(0) = 0.0;
		val sigma = new Rail[Double]([0.001, 0.01, 0.05]);
		val cor = new Rail[Rail[Double]](dim);
		cor(0) = [ 1.0,  0.8,  0.0];
		cor(1) = [ 0.8,  1.0,  0.0];
		cor(2) = [ 0.0,  0.0,  1.0];
	//		val s0 = new Rail[Double](S0);
	//		val mu = new Rail[Double](MU); mu(0) = 0.0;    // It's here.
	//		val sigma = new Rail[Double](SIGMA);
	//		val cor = new Rail[Rail[Double]](dim);
	//		for (i in 0..(dim - 1)) {
	//			cor(i) = new Rail[Double](COR(i));
	//		}
		val dt = 1.0;

		val logType =true;
		val random = new Random(); // MEMO: main()
		val mgbm = new MultiGeomBrownian(random, s0, mu, sigma, cor, dt,logType);
		Console.OUT.println("Cholesky\n" + mgbm.chol);

		for (t in 0..1000) {
			val X = mgbm.nextBrownian();
			for (x in X) {
				Console.OUT.print(x + " ");
			}
			Console.OUT.println();
		}
	}
	*/

}
