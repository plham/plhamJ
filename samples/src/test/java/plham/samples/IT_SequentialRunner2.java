package plham.samples;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import plham.core.main.SequentialRunner;
import plham.core.main.SimulatorFactory;
import plham.samples.CI2002.CI2002Main;
import plham.samples.CI2002.NewCI2002Main;
import plham.samples.DarkPool.DarkPoolMain;
import plham.samples.FatFinger.FatFingerMain;
import plham.samples.MarketShare.MarketShareMain;
import plham.samples.PriceLimit.PriceLimitMain;
import plham.samples.ShockTransfer.ShockTransferMain;
import plham.samples.TradingHalt.TradingHaltMain;

/**
 * Same tests as in {@link IT_SequentialRunner} but using the main from class
 * {@link SequentialRunner}.
 * @author Patrick Finnerty
 *
 */
@RunWith(Parameterized.class)
public class IT_SequentialRunner2 extends PlhamOutputTester {

    @BeforeClass
    public static void beforeClass() {
        System.setProperty(PLHAMOUTPUTTEST_CREATE_OUTPUT, "true");
        System.setProperty(SimulatorFactory.LEGACY_CLASS_WARNINGS_PROPERTY, "false");
    }

    @Parameters(name = "{0}")
    public static Collection<Object[]> constructorParameters() {
        return Arrays.asList(new Object[][] {
                { "CI2002", CI2002Main.class, "src/test/resources/CI2002/config.json", "100",
                        "src/test/resources/CI2002/correct_output.txt" },
                { "NewCI2002", NewCI2002Main.class, "src/test/resources/CI2002/config.json", "100",
                        "src/test/resources/CI2002/correct_output.txt" },
                { "CancelTest", CI2002Main.class, "src/test/resources/CancelTest/config.json", "100",
                        "src/test/resources/CancelTest/correct_output.txt" },
                { "MarketShare", MarketShareMain.class, "src/test/resources/MarketShare/config.json", "100",
                        "src/test/resources/MarketShare/correct_output.txt" },
                { "FatTail", CI2002Main.class, "src/test/resources/FatTail/config.json", "100",
                        "src/test/resources/FatTail/correct_output.txt" },
                { "TradingHalt", TradingHaltMain.class, "src/test/resources/TradingHalt/config.json", "100",
                        "src/test/resources/TradingHalt/correct_output.txt" },
                { "ShockTransfer", ShockTransferMain.class, "src/test/resources/ShockTransfer/config.json", "100",
                        "src/test/resources/ShockTransfer/correct_output.txt" },
                { "PriceLimit", PriceLimitMain.class, "src/test/resources/PriceLimit/config.json", "100",
                        "src/test/resources/PriceLimit/correct_output.txt" },
                { "FatFinger", FatFingerMain.class, "src/test/resources/FatFinger/config.json", "100",
                        "src/test/resources/FatFinger/correct_output.txt" },
                { "DarkPool", DarkPoolMain.class, "src/test/resources/DarkPool/config.json", "100",
                        "src/test/resources/DarkPool/correct_output.txt" },
                { "BlackScholes", ShockTransferMain.class, "src/test/resources/BlackScholes/config-a099.json", "100", 
                            "src/test/resources/BlackScholes/sequential_expected_output.txt"}
                        });
    }

    public IT_SequentialRunner2(String name, Class<?> mainClass, String config, String seed, String expectedOutput) {
        super(name, SequentialRunner.class, expectedOutput, mainClass.getCanonicalName(),  config, seed);
    }
}
