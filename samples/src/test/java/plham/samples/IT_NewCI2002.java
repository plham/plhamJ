package plham.samples;

import plham.samples.CI2002.NewCI2002Main;

public class IT_NewCI2002 extends PlhamOutputTester {

	final static String CONFIG = "src/test/resources/CI2002/config.json";

	final static String EXPECTED_OUTPUT = "src/test/resources/CI2002/correct_output.txt";

	final static String SEED = "100";

	public IT_NewCI2002() {
		super(NewCI2002Main.class, CONFIG, SEED, EXPECTED_OUTPUT);
	}
}
