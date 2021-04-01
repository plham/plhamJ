package plham.samples;

import plham.samples.CI2002.CI2002Main;

public class IT_CI2002 extends PlhamOutputTester {

	final static String CONFIG = "src/test/resources/CI2002/config.json";

	final static String EXPECTED_OUTPUT = "src/test/resources/CI2002/correct_output.txt";

	final static String SEED = "100";

	public IT_CI2002() {
		super(CI2002Main.class, CONFIG, SEED, EXPECTED_OUTPUT);
	}
}
