package plham.samples;

import plham.samples.DarkPool.DarkPoolMain;

public class IT_DarkPool extends PlhamOutputTester {

	final static String CONFIG = "src/test/resources/DarkPool/config.json";

	final static String EXPECTED_OUTPUT = "src/test/resources/DarkPool/correct_output.txt";

	final static String SEED = "100";

	public IT_DarkPool() {
		super(DarkPoolMain.class, CONFIG, SEED, EXPECTED_OUTPUT);
	}
}
