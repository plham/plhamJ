package plham.samples;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import plham.core.main.ParallelRunnerMT;
import plham.samples.multiThread.MultiThreadCI2002;

@RunWith(Parameterized.class)
public class IT_MultiThreadCI2002 extends PlhamOutputTester {

	final static String CONFIG = "src/test/resources/CI2002/config.json";

	final static String EXPECTED_OUTPUT = "src/test/resources/MultithreadedOutputs/CI2002.txt";

	final static String SEED = "100";

	final String NB_THREADS;
	
	public IT_MultiThreadCI2002(String parallelism) {
		super(MultiThreadCI2002.class, CONFIG, SEED, EXPECTED_OUTPUT);
		NB_THREADS = parallelism;
	}
	
	/**
	 * Clear the potential "old value" of the property which determines with how many threads
	 * the multithreaded runner operates.
	 */
	@Before
	public void setupEnvironment() {
	    System.setProperty(ParallelRunnerMT.PARALLEL_RUNNER_THREAD_PROPERTY, NB_THREADS);
	}
	
	@Parameters(name="Thread count: {0}")
	public static Collection<Object[]> constructorParameters() {
	    return Arrays.asList(new Object [][]{
	        {"1"},
	        {"2"},
	        {"4"}
	    });
	}
	
}
