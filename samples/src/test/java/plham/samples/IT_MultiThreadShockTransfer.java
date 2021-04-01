package plham.samples;

import org.junit.Ignore;

import plham.samples.multiThread.MultiThreadShockTransfer;

@Ignore
public class IT_MultiThreadShockTransfer extends PlhamOutputTester {

	final static String CONFIG = "src/test/resources/ShockTransfer/config.json";

	final static String EXPECTED_OUTPUT = "src/test/resources/ShockTransfer/correct_output.txt";

	final static String SEED = "100";

	public IT_MultiThreadShockTransfer() {
		super(MultiThreadShockTransfer.class, CONFIG, SEED, EXPECTED_OUTPUT);
	}
}
