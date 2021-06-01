package plham.samples;

import org.junit.Before;
import org.junit.Test;

import plham.core.main.ParallelRunnerMT;
import plham.samples.multiThread.MultiThreadCI2002;

public class IT_MultiThreadCI2002 extends PlhamOutputTester {

	final static String CONFIG = "src/test/resources/CI2002/config.json";

	final static String EXPECTED_OUTPUT = "src/test/resources/MultithreadedOutputs/CI2002.txt";

	final static String SEED = "100";

	public IT_MultiThreadCI2002() {
		super(MultiThreadCI2002.class, CONFIG, SEED, EXPECTED_OUTPUT);
	}
	
	/**
	 * Clear the potential "old value" of the property which determines with how many threads
	 * the multithreaded runner operates.
	 */
	@Before
	public void before() {
	    System.clearProperty(ParallelRunnerMT.PARALLEL_RUNNER_THREAD_PROPERTY);
	}
	
	/**
	 * Tests the multithreaded CI2002 program with a single thread
	 * @throws Exception is thrown as part of this test
	 */
	@Test
	public void test1Thread() throws Exception {
	    System.setProperty(ParallelRunnerMT.PARALLEL_RUNNER_THREAD_PROPERTY, "1");
	    super.defaultTest();
	}
	
	/**
     * Tests the multithreaded CI2002 program with 2 threads
     * @throws Exception is thrown as part of this test
     */
	@Test
    public void test2Threads() throws Exception {
        System.setProperty(ParallelRunnerMT.PARALLEL_RUNNER_THREAD_PROPERTY, "2");
        super.defaultTest();
    }
    
    /**
     * Tests the multithreaded CI2002 program with 4 threads
     * @throws Exception is thrown as part of this test
     */
	@Test
    public void test4Thread() throws Exception {
        System.setProperty(ParallelRunnerMT.PARALLEL_RUNNER_THREAD_PROPERTY, "4");
        super.defaultTest();
    }
}
