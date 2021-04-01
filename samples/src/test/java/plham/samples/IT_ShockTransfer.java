package plham.samples;

import plham.samples.ShockTransfer.ShockTransferMain;

public class IT_ShockTransfer extends PlhamOutputTester {

	final static String CONFIG = "src/test/resources/ShockTransfer/config.json";

	final static String EXPECTED_OUTPUT = "src/test/resources/ShockTransfer/correct_output.txt";

	final static String SEED = "100";

	public IT_ShockTransfer() {
		super(ShockTransferMain.class, CONFIG, SEED, EXPECTED_OUTPUT);
	}
}
