package plham.samples.blackscholes;

import plham.core.util.Random;
import cassia.util.random.Gaussian;

public class BlackScholes {

    final Random random;
    final double initialPrice;
    final double strikePrice;
    final double riskFreeRate;
    final double volatility;
    final double maturityTime;

    public BlackScholes(Random r, double initPrice, double strike, double rateRiskFree, double vol, double maturity) {
        random = r;
        initialPrice = initPrice;
        strikePrice = strike;
        riskFreeRate = rateRiskFree;
        volatility = vol;
        maturityTime = maturity;                
    }
    
    public double compute (long nsamples, long nsteps) {
        Gaussian g = new Gaussian(random);
        
        double r = riskFreeRate;
        double sigma = volatility;
        double dt = maturityTime / nsteps;
        
        double sum = 0.0;
        for (long i = 0; i < nsamples; i++) {
            double price = initialPrice;
            for (long t = 0; t < nsteps; t++) {
                price += price * r * dt + price * g.nextGaussian() * sigma * Math.sqrt(dt);   
            }
            sum += Math.max(price - strikePrice, 0.0);
        }
        return Math.exp(-riskFreeRate * maturityTime) * (sum/nsamples);
    }
    
    /**
     * Dummy Main program which launches a known BlackScholes simulation
     * @param args no argument
     */
    public static void main(String [] args) {
        Random r = new Random();
        BlackScholes bs = new BlackScholes(r, 100.0, 100.0, 0.1, 0.3, 3);
        System.out.println("Theory: 33.6044837628");
        System.out.println("Estimated: " + bs.compute(1000, 100));
    }
}
