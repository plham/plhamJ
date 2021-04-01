package plham.samples;

import plham.samples.TradingHalt.TradingHaltMain;

public class IT_TradingHalt extends PlhamOutputTester {

	final static String CONFIG = "src/test/resources/TradingHalt/config.json";

	final static String EXPECTED_OUTPUT = "src/test/resources/TradingHalt/correct_output.txt";

	final static String SEED = "100";

	public IT_TradingHalt() {
		super(TradingHaltMain.class, CONFIG, SEED, EXPECTED_OUTPUT);
	}
}
