package plham.samples;

import plham.samples.FatTail.FatTailMain;

public class IT_FatTail extends PlhamOutputTester {

	final static String CONFIG = "src/test/resources/FatTail/config.json";

	final static String EXPECTED_OUTPUT = "src/test/resources/FatTail/correct_output.txt";

	final static String SEED = "100";

	public IT_FatTail() {
		super(FatTailMain.class, CONFIG, SEED, EXPECTED_OUTPUT);
	}
}
