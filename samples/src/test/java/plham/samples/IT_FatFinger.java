package plham.samples;

import plham.samples.FatFinger.FatFingerMain;

public class IT_FatFinger extends PlhamOutputTester {

	final static String CONFIG = "src/test/resources/FatFinger/config.json";

	final static String EXPECTED_OUTPUT = "src/test/resources/FatFinger/correct_output.txt";

	final static String SEED = "100";

	public IT_FatFinger() {
		super(FatFingerMain.class, CONFIG, SEED, EXPECTED_OUTPUT);
	}
}
