package plham.samples;

import plham.samples.MarketShare.MarketShareMain;

public class IT_MarketShare extends PlhamOutputTester {

	final static String CONFIG = "src/test/resources/MarketShare/config.json";

	final static String EXPECTED_OUTPUT = "src/test/resources/MarketShare/correct_output.txt";

	final static String SEED = "100";

	public IT_MarketShare() {
		super(MarketShareMain.class, CONFIG, SEED, EXPECTED_OUTPUT);
	}
}
