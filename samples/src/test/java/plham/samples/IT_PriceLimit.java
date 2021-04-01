package plham.samples;

import plham.samples.CI2002.CI2002Main;

public class IT_PriceLimit extends PlhamOutputTester {

	final static String CONFIG = "src/test/resources/PriceLimit/config.json";

	final static String EXPECTED_OUTPUT = "src/test/resources/PriceLimit/correct_output.txt";

	final static String SEED = "100";

	public IT_PriceLimit() {
		super(CI2002Main.class, CONFIG, SEED, EXPECTED_OUTPUT);
	}
}
