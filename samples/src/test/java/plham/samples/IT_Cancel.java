package plham.samples;

import plham.samples.CancelTest.CancelTestMain;

public class IT_Cancel extends PlhamOutputTester {

	final static String CONFIG = "src/test/resources/CancelTest/config.json";

	final static String EXPECTED_OUTPUT = "src/test/resources/CancelTest/correct_output.txt";

	final static String SEED = "100";

	public IT_Cancel() {
		super(CancelTestMain.class, CONFIG, SEED, EXPECTED_OUTPUT);
	}
}
