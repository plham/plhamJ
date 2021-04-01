package plham.core.util;

import java.io.Serializable;

import cassia.util.random.Gaussian;

public class MultiGeomBrownian implements Serializable {
	private static final long serialVersionUID = 3360288287000813047L;

	public double[] c;
	public double[][] chol;
	public double[][] cor;
	public int dim;
	public double dt;
	public double[] g;
	public Gaussian gaussian;
	public boolean initialCheck;
	public boolean logType;
	public double[] mu;
	public Random random;
	public double[] s0;
	public double[] sigma;
	public double[] state;

	public MultiGeomBrownian(Random random, int dim) {
		this(random, dim, true);
	}

	public MultiGeomBrownian(Random random, int dim, boolean logType) {
		this.random = random;
		gaussian = new Gaussian(random);
		mu = new double[dim];
		// mu.addAll(Collections.nCopies((int) dim, (double) 0.0D));
		sigma = new double[dim];
		// sigma.addAll(Collections.nCopies((int) dim, (double) 0.0D));
		cor = new double[dim][dim];
		// for (int i = 0; i < (int) dim; i++) {
		// cor.add(new ArrayList<double>());
		// }
		chol = null;
		s0 = new double[dim];
		// s0.addAll(Collections.nCopies((int) dim, (double) 0.0D));
		dt = 1.0;
		this.dim = dim;
		state = new double[dim];
		// state.addAll(Collections.nCopies((int) dim, (double) 0.0D));
		initialCheck = true;
		g = new double[dim];
		// g.addAll(Collections.nCopies((int) dim, (double) 0.0D));
		c = new double[dim];
		// c.addAll(Collections.nCopies((int) dim, (double) 0.0D));
		this.logType = logType;
	}

	public double get(int i) {
		return g[i];
	}

	public double[] nextBrownian() {
		double[] out;
		if (logType) {
			out = nextBrownian2();
		} else {
			out = nextBrownian3();
		}
		return out;
	}

	public double[] nextBrownian2() {
		if (chol == null) {
			chol = Cholesky.decompose(cor);
		}
		int dim = this.dim;
		for (int i = 0; i < dim; i++) {
			g[i] = gaussian.nextGaussian();
		}
		for (int i = 0; i < dim; i++) {
			c[i] = 0.0;
			for (int j = 0; j <= i; j++) {
				c[i] += g[j] * chol[i][j];
			}
		}
		for (int i = 0; i < dim; i++) {
			// this.state(i) += this.mu(i) * this.dt + this.sigma(i) * this.c(i) * dt * dt;
			state[i] += (mu[i] - sigma[i] * sigma[i] * 0.5) * dt + sigma[i] * c[i] * Math.sqrt(dt);
			g[i] = s0[i] * Math.exp(state[i]);
		}
		return g;
	}

	public double[] nextBrownian3() {
		int dim = this.dim;
		if (initialCheck) {
			for (int i = 0; i < dim; i++) {
				g[i] = s0[i];
			}
			initialCheck = false;
		}

		if (chol == null) {
			chol = Cholesky.decompose(cor);
		}

		double[] hoge = new double[dim];
		for (int i = 0; i < dim; i++) {
			hoge[i] = gaussian.nextGaussian();
		}
		for (int i = 0; i < dim; i++) {
			c[i] = 0.0;
			for (int j = 0; j <= i; j++) {
				c[i] += hoge[j] * chol[i][j];
			}
		}
		for (int i = 0; i < dim; i++) {
			// this.state(i) = this.mu(i) * this.dt + this.sigma(i) * this.c(i) * dt * dt;
			state[i] = (mu[i] - sigma[i] * sigma[i] * 0.5) * dt + sigma[i] * c[i] * Math.sqrt(dt);
			g[i] = g[i] * (1 + state[i]);
		}
		return g;
	}

}
