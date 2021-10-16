package cassia.util.random;

import java.io.Serializable;

import plham.core.util.Random;

public class Gaussian implements Serializable {
    private static final long serialVersionUID = -3828581207744757485L;

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

    public static double gaussCumulativeValue(double a, double b, double delta, double mu, double sigma) {
        assert a < b && delta > 0.0 && delta < 1.0 && !(Double.valueOf(a).isInfinite())
                && !(Double.valueOf(b).isInfinite()) : "gaussCumulativeValueError";
        double out = 0.0;
        double n = (b - a) / delta;
        for (long i = 0; i <= n; i++) {
            double v = a + i * delta;
            out = out + gaussDenseValue(v, mu, sigma) * delta;

        }
        return out;
    }

    public static double gaussDenseValue(double x, double mu, double sigma) {
        return Math.exp(-1 * (x - mu) * (x - mu) / (2 * sigma * sigma)) / Math.pow(2 * Math.PI * sigma * sigma, 0.5);
    }

    public static double gaussExpectedValue(double a, double b, double delta, double mu, double sigma) {
        assert a < b && delta > 0.0 && delta < 1.0 && !(Double.valueOf(a).isInfinite())
                && !(Double.valueOf(b).isInfinite()) : "gaussExpectedValueError";

        double out = 0.0;
        double n = (b - a) / delta;
        for (long i = 0; i <= n; i++) {
            double v = a + i * delta;
            out = out + v * gaussDenseValue(v, mu, sigma) * delta;
        }
        return out;
    }

    public double g;

    public Random random;

    public boolean state;

    public Gaussian(Random random) {
        state = false;
        g = -1;
        this.random = random;
    }

    public double nextGaussian() {
        if (state) {
            state = false;
            return g;
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
            g = v2 * norm;
            return v1 * norm;
        }
    }

    public double nextGaussian(double mu, double sigma) {
        return mu + sigma * this.nextGaussian();
    }
}
