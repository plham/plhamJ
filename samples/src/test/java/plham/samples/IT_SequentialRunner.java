package plham.samples;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import plham.core.main.SimulatorFactory;
import plham.samples.CI2002.CI2002Main;
import plham.samples.CI2002.NewCI2002Main;
import plham.samples.CancelTest.CancelTestMain;
import plham.samples.DarkPool.DarkPoolMain;
import plham.samples.FatFinger.FatFingerMain;
import plham.samples.FatTail.FatTailMain;
import plham.samples.MarketShare.MarketShareMain;
import plham.samples.PriceLimit.PriceLimitMain;
import plham.samples.ShockTransfer.ShockTransferMain;
import plham.samples.TradingHalt.TradingHaltMain;

@RunWith(Parameterized.class)
public class IT_SequentialRunner extends PlhamOutputTester {

    @BeforeClass
    public static void beforeClass() {
        System.setProperty(PLHAMOUTPUTTEST_CREATE_OUTPUT, "true");
        System.setProperty(SimulatorFactory.LEGACY_CLASS_WARNINGS_PROPERTY, "false");
    }

    @Parameters(name = "{0}")
    public static Collection<Object[]> constructorParameters() {
        return Arrays.asList(new Object[][] {
                { CI2002Main.class, "src/test/resources/CI2002/config.json", "100",
                        "src/test/resources/CI2002/correct_output.txt" },
                { NewCI2002Main.class, "src/test/resources/CI2002/config.json", "100",
                        "src/test/resources/CI2002/correct_output.txt" },
                { CancelTestMain.class, "src/test/resources/CancelTest/config.json", "100",
                        "src/test/resources/CancelTest/correct_output.txt" },
                { MarketShareMain.class, "src/test/resources/MarketShare/config.json", "100",
                        "src/test/resources/MarketShare/correct_output.txt" },
                { FatTailMain.class, "src/test/resources/FatTail/config.json", "100",
                        "src/test/resources/FatTail/correct_output.txt" },
                { TradingHaltMain.class, "src/test/resources/TradingHalt/config.json", "100",
                        "src/test/resources/TradingHalt/correct_output.txt" },
                { ShockTransferMain.class, "src/test/resources/ShockTransfer/config.json", "100",
                        "src/test/resources/ShockTransfer/correct_output.txt" },
                { PriceLimitMain.class, "src/test/resources/PriceLimit/config.json", "100",
                        "src/test/resources/PriceLimit/correct_output.txt" },
                { FatFingerMain.class, "src/test/resources/FatFinger/config.json", "100",
                        "src/test/resources/FatFinger/correct_output.txt" },
                { DarkPoolMain.class, "src/test/resources/DarkPool/config.json", "100",
                        "src/test/resources/DarkPool/correct_output.txt" } });
    }

    public IT_SequentialRunner(Class<?> mainClass, String config, String seed, String expectedOutput) {
        super("SequentialRunner_" + mainClass.getName(), mainClass, expectedOutput, config, seed);
    }
}
