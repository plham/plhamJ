package plham.samples;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import apgas.impl.Config;
import apgas.impl.DebugFinish;
import handist.mpijunit.DistributedParameterizedTestLauncher;
import handist.mpijunit.ParameterizedMpi;
import handist.mpijunit.ParameterizedMpi.ParameterizedMpiConfig;
import plham.core.main.SimulatorFactory;
import plham.core.main.glb.GlbRunner;
import plham.samples.CI2002.NewCI2002Main;
import plham.samples.MarketShare.NewMarketShare;
import plham.samples.ShockTransfer.NewShockTransfer;
import plham.samples.TradingHalt.NewTradingHalt;

@Ignore
@ParameterizedMpiConfig(ranks = 4, launcher = DistributedParameterizedTestLauncher.class, timeout = 90l)
@RunWith(ParameterizedMpi.class)
public class IT_GlbRunner extends PlhamOutputTester {

    @Parameters(name = "{0}")
    public static Collection<Object[]> constructorParameters() {
        // in the 2D array below are the configurations for each sample program
        Collection<Object[]> parameters = Arrays.asList(new Object[][] {
            /* Simulation name, OutpuClass, JSON configuration file, SEED, expected output */
            { "New CI2002", NewCI2002Main.class, "src/test/resources/CI2002/config.json", "100",
            "src/test/resources/MultithreadedOutputs/CI2002.txt" },
            { "New CancelTest", NewCI2002Main.class, "src/test/resources/CancelTest/config.json", "100",
            "src/test/resources/MultithreadedOutputs/CancelTest.txt" },
            { "MarketShare", NewMarketShare.class, "src/test/resources/MarketShare/config.json", "100",
            "src/test/resources/MultithreadedOutputs/MarketShare.txt" },
            { "New FatTail", NewCI2002Main.class, "src/test/resources/FatTail/config-shortened.json", "100",
            "src/test/resources/MultithreadedOutputs/FatTail-shortened.txt" }, // using the "shortened"
            // version of FatTail
            { "New TradingHalt", NewTradingHalt.class, "src/test/resources/TradingHalt/config.json", "100",
            "src/test/resources/MultithreadedOutputs/TradingHalt.txt" },
            { "New ShockTransfer", NewShockTransfer.class, "src/test/resources/ShockTransfer/config.json", "100",
            "src/test/resources/MultithreadedOutputs/ShockTransfer.txt" },
            { "New PriceLimit", NewCI2002Main.class, "src/test/resources/PriceLimit/config.json", "100",
            "src/test/resources/MultithreadedOutputs/PriceLimit.txt" },
            { "FatFinger", NewCI2002Main.class, "src/test/resources/FatFinger/config.json", "100",
            "src/test/resources/MultithreadedOutputs/FatFinger.txt" },
            { "BlackScholes", NewShockTransfer.class, "src/test/resources/BlackScholes/config-a099.json", "100", "src/test/resources/BlackScholes/expected_output.txt"},
            { "BlackScholes with load", NewShockTransfer.class, "src/test/resources/BlackScholes/config-shutdown.json", "100", "src/test/resources/BlackScholes/expected_shutdown_output.txt"}
        });
        return parameters;
    }

    public IT_GlbRunner(String name, Class<?> mainClass, String jsonFile, String seed, String expectedFileOutput) {
        super(name, GlbRunner.class, expectedFileOutput, mainClass.getCanonicalName(), jsonFile, seed);
    }

    @Rule
    public transient TestName nameOfCurrentTest = new TestName();

    @BeforeClass
    public static void beforeClass() {
        System.setProperty(PLHAMOUTPUTTEST_CREATE_OUTPUT, "true");
        System.setProperty(SimulatorFactory.LEGACY_CLASS_WARNINGS_PROPERTY, "false");
    }

    @After
    public void afterEachTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
    NoSuchMethodException, SecurityException {
        if (DebugFinish.class.getCanonicalName().equals(System.getProperty(Config.APGAS_FINISH))) {
            System.err.println("Dumping the errors that occurred during " + nameOfCurrentTest.getMethodName());
            // If we are using the DebugFinish, dump all throwables collected on each host
            DebugFinish.dumpAllSuppressedExceptions();
        }
    }
}
