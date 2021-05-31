package plham.samples;

import plham.samples.multiThread.MultiThreadCI2002;

public class IT_MultiThreadCI2002 extends PlhamOutputTester {

	final static String CONFIG = "src/test/resources/CI2002/config.json";

	final static String EXPECTED_OUTPUT = "src/test/resources/CI2002/correct_output.txt";

	final static String SEED = "100";

	public IT_MultiThreadCI2002() {
		super(MultiThreadCI2002.class, CONFIG, SEED, EXPECTED_OUTPUT);
	}
}
