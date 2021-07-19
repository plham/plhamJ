package plham.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import plham.core.util.Random;

public class Test_Fundamentals {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /** Fundamental under test */
    Fundamentals f;

    /** Random generator */
    Random random;

    @Before
    public void setUp() throws Exception {
        random = new Random();
        f = new Fundamentals(random);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Code ported (with some mistakes, most likely) from the X10 Fundamentals main method.
     */
    /*
     * public static def main(Rail[String]) { val random = new Random(); val N = 4; // # of initial markets val m = 2;
     * // # of additional markets
     * 
     * val id = new Rail[Long](N + m, (i:Long) => i * 10);
     * 
     * val f = new Fundamentals(random); for (i in 0..(N - 1)) { f.setInitial(id(i), 100 * random.nextDouble() + 100);
     * f.setDrift(id(i), 1e-6 * random.nextDouble()); f.setVolatility(id(i), 1e-3 * random.nextDouble()); for (j in
     * 0..(N - 1)) { if (random.nextDouble() < 0.3) { f.setCorrelation(id(i), id(j), random.nextDouble()); } } }
     * f.setup();
     * 
     * // SESSION 1
     * 
     * f.update(); for (t in 1..1000) { for (i in 0..(N + m - 1)) { Console.OUT.print(f.get(id(i)) + " "); }
     * Console.OUT.println(); f.update(); }
     * 
     * // MODIFY PARAMETERS
     * 
     * for (i in 2..(N - 1)) { f.setVolatility(id(i), 1e-3 * random.nextDouble()); // Change volatilities for i =
     * 2,..,N-1 }
     * 
     * // ADDITIONAL MARKETS
     * 
     * for (i in N..(N + m - 1)) { f.setInitial(id(i), 100 * random.nextDouble() + 100); f.setDrift(id(i), 1e-6 *
     * random.nextDouble()); f.setVolatility(id(i), 1e-3 * random.nextDouble()); for (j in 0..(N + m - 1)) { if
     * (random.nextDouble() < 0.3) { f.setCorrelation(id(i), id(j), random.nextDouble()); } else if (random.nextDouble()
     * < 0.3) { f.removeCorrelation(id(i), id(j)); } } } f.setup();
     * 
     * // SESSION 2
     * 
     * f.update(); for (t in 1..1000) { for (i in 0..(N + m - 1)) { Console.OUT.print(f.get(id(i)) + " "); }
     * Console.OUT.println(); f.update(); } }
     */
    @Ignore
    @Test
    public void test() {

        int N = 4; // # of initial markets
        int m = 2; // # of additional markets

        long[] id = new long[N + m];
        for (int idx = 0; idx < id.length; idx++) {
            id[idx] = idx * 10; // (N + m, (i:Long) => i * 10);
        }

        for (int i = 0; i <= (N - 1); i++) {
            f.setInitial(id[i], 100 * random.nextDouble() + 100);
            f.setDrift(id[i], 1e-6 * random.nextDouble());
            f.setVolatility(id[i], 1e-3 * random.nextDouble());
            for (int j = 0; j <= (N - 1); j++) {
                if (random.nextDouble() < 0.3) {
                    f.setCorrelation(id[i], id[j], random.nextDouble());
                }
            }
        }
        f.setup();

        // SESSION 1

        f.update();
        for (int t = 1; t <= 1000; t++) {
            for (int i = 0; i <= (N + m - 1); i++) {
                System.out.print(f.get(id[i]) + " ");
            }
            System.out.println();
            f.update();
        }

        // MODIFY PARAMETERS

        for (int i = 2; i <= (N - 1); i++) {
            f.setVolatility(id[i], 1e-3 * random.nextDouble()); // Change volatilities for i = 2,..,N-1
        }

        // ADDITIONAL MARKETS

        for (int i = N; i <= N + m - 1; i++) {
            f.setInitial(id[i], 100 * random.nextDouble() + 100);
            f.setDrift(id[i], 1e-6 * random.nextDouble());
            f.setVolatility(id[i], 1e-3 * random.nextDouble());
            for (int j = 0; j <= (N + m - 1); j++) {
                if (random.nextDouble() < 0.3) {
                    f.setCorrelation(id[i], id[j], random.nextDouble());
                } else if (random.nextDouble() < 0.3) {
                    f.removeCorrelation(id[i], id[j]);
                }
            }
        }
        f.setup();

        // SESSION 2

        f.update();
        for (int t = 1; t <= 1000; t++) {
            for (int i = 0; i <= (N + m - 1); i++) {
                System.out.print(f.get(id[i]) + " ");
            }
            System.out.println();
            f.update();
        }
    }

}
