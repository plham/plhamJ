package plham.core.util;

import java.io.Serializable;

/**
 * Cholesky decomposition of a positive definite matrix. Reference: Numerical
 * Recipes 3rd Ed, p.100.
 */

public class Cholesky implements Serializable {
	private static final long serialVersionUID = 816933497269357924L;

	public static double[][] decompose(double[][] m) {
		int n = m.length;
		double[][] a = new double[n][];
		for (int i = 0; i < n; i++) {
			a[i] = m[i].clone();
		}
		double sum;
		for (int i = 0; i < n; i++) {
			assert a[i].length == n;
			for (int j = i; j < n; j++) {
				sum = a[i][j];
				for (int k = 0; k < i; k++) {
					sum -= a[i][k] * a[j][k];
				}
				if (i == j) {
					if (sum <= 0.0) {
						throw new NumericalException("a matrix is not positive definite");
					}
					a[i][i] = Math.sqrt(sum);
				} else {
					a[j][i] = sum / a[i][i];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				a[j][i] = 0.0;
			}
		}
		return a;
	}
}
