package plham.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import plham.core.main.ParallelRunnerMT;
import plham.core.main.SimulatorFactory;
import plham.samples.CI2002.CI2002Main;
import plham.samples.CI2002.NewCI2002Main;
import plham.samples.DarkPool.NewDarkPool;
import plham.samples.FatFinger.FatFingerMain;
import plham.samples.MarketShare.MarketShareMain;
import plham.samples.MarketShare.NewMarketShare;
import plham.samples.ShockTransfer.NewShockTransfer;
import plham.samples.ShockTransfer.ShockTransferMain;
import plham.samples.TradingHalt.NewTradingHalt;
import plham.samples.TradingHalt.TradingHaltMain;

@RunWith(Parameterized.class)
public class IT_MultiThreadedRunner extends PlhamOutputTester {

    @BeforeClass
    public static void beforeClass() {
        System.setProperty(PLHAMOUTPUTTEST_CREATE_OUTPUT, "true");
        System.setProperty(SimulatorFactory.LEGACY_CLASS_WARNINGS_PROPERTY, "false");
    }

    @Parameters(name = "{0}")
    public static Collection<Object[]> constructorParameters() {
        // in the 2D array below are the configurations for each sample program
        Collection<Object[]> parameters = Arrays.asList(new Object[][] {
                /* SimulatorOutput, JSON configuration file, SEED, expected output */
                { "CI2002", CI2002Main.class, "src/test/resources/CI2002/config.json","false", "100",
                        "src/test/resources/MultithreadedOutputs/CI2002.txt" },
                { "New CI2002", NewCI2002Main.class, "src/test/resources/CI2002/config.json","false", "100",
                        "src/test/resources/MultithreadedOutputs/CI2002.txt" },
                { "CancelTest", CI2002Main.class, "src/test/resources/CancelTest/config.json","false", "100",
                        "src/test/resources/MultithreadedOutputs/CancelTest.txt" },
                { "MarketShare", MarketShareMain.class, "src/test/resources/MarketShare/config.json","false", "100",
                        "src/test/resources/MultithreadedOutputs/MarketShare.txt" },
                { "New MarketShare", NewMarketShare.class, "src/test/resources/MarketShare/config.json","false", "100",
                        "src/test/resources/MultithreadedOutputs/MarketShare.txt" },
                { "FatTail", CI2002Main.class, "src/test/resources/FatTail/config-shortened.json","false", "100",
                        "src/test/resources/MultithreadedOutputs/FatTail-shortened.txt" }, // using the "shortened"
                                                                                           // version of FatTail
                { "New FatTail", NewCI2002Main.class, "src/test/resources/FatTail/config-shortened.json","false", "100",
                        "src/test/resources/MultithreadedOutputs/FatTail-shortened.txt" },
                { "TradingHalt", TradingHaltMain.class, "src/test/resources/TradingHalt/config.json","false", "100",
                        "src/test/resources/MultithreadedOutputs/TradingHalt.txt" },
                { "New TradingHalt", NewTradingHalt.class, "src/test/resources/TradingHalt/config.json","false", "100",
                        "src/test/resources/MultithreadedOutputs/TradingHalt.txt" },
                { "ShockTransfer", ShockTransferMain.class, "src/test/resources/ShockTransfer/config.json","false", "100",
                        "src/test/resources/MultithreadedOutputs/ShockTransfer.txt" },
                { "New ShockTransfer", NewShockTransfer.class, "src/test/resources/ShockTransfer/config.json","false", "100",
                        "src/test/resources/MultithreadedOutputs/ShockTransfer.txt" },
                { "PriceLimit", CI2002Main.class, "src/test/resources/PriceLimit/config.json","false", "100",
                        "src/test/resources/MultithreadedOutputs/PriceLimit.txt" },
                { "New PriceLimit", NewCI2002Main.class, "src/test/resources/PriceLimit/config.json","false", "100",
                        "src/test/resources/MultithreadedOutputs/PriceLimit.txt" },
                { "FatFinger", FatFingerMain.class, "src/test/resources/FatFinger/config.json","false", "100",
                        "src/test/resources/MultithreadedOutputs/FatFinger.txt" },
                { "New FatFinger", NewCI2002Main.class, "src/test/resources/FatFinger/config.json","false", "100",
                        "src/test/resources/MultithreadedOutputs/FatFinger.txt" },
                { "New DarkPool", NewDarkPool.class, "src/test/resources/DarkPool/config.json", "false", "100",
                        "src/test/resources/MultithreadedOutputs/DarkPool.txt" }
                        //,
//                { "BlackScholes", NewShockTransfer.class, "src/test/resources/BlackScholes/config-a099.json", "true", "100", "src/test/resources/BlackScholes/expected_output.txt"}
        });

        // We create 3 configurations per sample,
        // - 1 thread
        // - 2 threads
        // - 4 threads
        Collection<Object[]> toReturn = new ArrayList<>(parameters.size() * 3);
        parameters.forEach(a -> {
            Object[] thread1 = Arrays.copyOf(a, a.length + 1);
            Object[] thread2 = Arrays.copyOf(a, a.length + 1);
            Object[] thread4 = Arrays.copyOf(a, a.length + 1);

            thread1[a.length] = "1";
            thread2[a.length] = "2";
            thread4[a.length] = "4";

            thread1[0] = thread1[0] + "_1thread";
            thread2[0] = thread2[0] + "_2thread";
            thread4[0] = thread4[0] + "_4thread";
            
            toReturn.add(thread1);
            toReturn.add(thread2);
            toReturn.add(thread4);
        });

        return toReturn;
    }

    public IT_MultiThreadedRunner(String testName, Class<?> outputClass, String jsonConfig, String pipeline, String seed,
            String expectedOutput, String parallelism) {
        super("ParallelRunner_" + testName + "_" + parallelism + "threads", ParallelRunnerMT.class, expectedOutput,
                outputClass.getCanonicalName(), jsonConfig, seed, pipeline, parallelism);
    }
}
