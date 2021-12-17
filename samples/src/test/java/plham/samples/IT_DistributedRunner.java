package plham.samples;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import apgas.impl.Config;
import apgas.impl.DebugFinish;
import handist.mpijunit.DistributedParameterizedTestLauncher;
import handist.mpijunit.ParameterizedMpi;
import handist.mpijunit.ParameterizedMpi.ParameterizedMpiConfig;
import plham.core.main.ParallelRunnerDist;
import plham.core.main.SimulatorFactory;
import plham.samples.CI2002.NewCI2002Main;
import plham.samples.DarkPool.NewDarkPool;
import plham.samples.MarketShare.NewMarketShare;
import plham.samples.ShockTransfer.NewShockTransfer;
import plham.samples.TradingHalt.NewTradingHalt;

@ParameterizedMpiConfig(ranks = 4, launcher = DistributedParameterizedTestLauncher.class, timeout = 90l)
@RunWith(ParameterizedMpi.class)
public class IT_DistributedRunner extends PlhamOutputTester {

    @BeforeClass
    public static void beforeClass() {
        System.setProperty(PLHAMOUTPUTTEST_CREATE_OUTPUT, "true");
        System.setProperty(SimulatorFactory.LEGACY_CLASS_WARNINGS_PROPERTY, "false");
    }

    @Parameters(name = "{0}")
    public static Collection<Object[]> constructorParameters() {
        // in the 2D array below are the configurations for each sample program
        Collection<Object[]> parameters = Arrays.asList(new Object[][] {
                /* Simulation name, OutpuClass, JSON configuration file, SEED, expected output */
                { "New CI2002", NewCI2002Main.class, "src/test/resources/CI2002/config.json", "100",
                        "src/test/resources/MultithreadedOutputs/CI2002.txt", "src/test/resources/CI2002/config.json"},
                { "New CancelTest", NewCI2002Main.class, "src/test/resources/CancelTest/config.json", "100",
                        "src/test/resources/MultithreadedOutputs/CancelTest.txt", "src/test/resources/CI2002/config.json"},
                { "MarketShare", NewMarketShare.class, "src/test/resources/MarketShare/config.json", "100",
                        "src/test/resources/MultithreadedOutputs/MarketShare.txt", "src/test/resources/CI2002/config.json" },
                { "New FatTail", NewCI2002Main.class, "src/test/resources/FatTail/config-shortened.json", "100",
                        "src/test/resources/MultithreadedOutputs/FatTail-shortened.txt", "src/test/resources/CI2002/config.json" }, // using the "shortened" version of FatTail
                { "New TradingHalt", NewTradingHalt.class, "src/test/resources/TradingHalt/config.json", "100",
                        "src/test/resources/MultithreadedOutputs/TradingHalt.txt", "src/test/resources/CI2002/config.json" },
                { "New ShockTransfer", NewShockTransfer.class, "src/test/resources/ShockTransfer/config.json", "100",
                        "src/test/resources/MultithreadedOutputs/ShockTransfer.txt", "src/test/resources/CI2002/config.json" },
                { "New PriceLimit", NewCI2002Main.class, "src/test/resources/PriceLimit/config.json", "100",
                        "src/test/resources/MultithreadedOutputs/PriceLimit.txt", "src/test/resources/CI2002/config.json" },
                { "FatFinger", NewCI2002Main.class, "src/test/resources/FatFinger/config.json", "100",
                        "src/test/resources/MultithreadedOutputs/FatFinger.txt", "src/test/resources/CI2002/config.json" },
                { "BlackScholes", NewShockTransfer.class, "src/test/resources/BlackScholes/config-a099.json", "100", "src/test/resources/BlackScholes/expected_output.txt", "src/test/resources/BlackScholes/config-a099.json"},
                { "BlackScholes with load", NewShockTransfer.class, "src/test/resources/BlackScholes/config-shutdown.json", "100", "src/test/resources/BlackScholes/expected_shutdown_output.txt", "src/test/resources/BlackScholes/config-a099.json"},
//                {"DarkPool", NewDarkPool.class, "src/test/resources/DarkPool/config.json", "100", "src/test/resources/MultithreadedOutputs/DarkPool.txt"} // FIXME
        });
        return parameters;
    }

    @Rule
    public transient TestName nameOfCurrentTest = new TestName();

    public IT_DistributedRunner(String parameterName, Class<?> outputClass, String jsonFile, String seed,
            String expectedResultFile, String warmupFile) {
        super("Distributed_4hosts_" + parameterName, ParallelRunnerDist.class, expectedResultFile,
                outputClass.getCanonicalName(), jsonFile, seed, warmupFile);
    }
    
    @After
    public void afterEachTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException {
        if (DebugFinish.class.getCanonicalName().equals(System.getProperty(Config.APGAS_FINISH)) && DebugFinish.suppressedExceptionsPresent()) {
            System.err.println("Dumping the errors that occurred during " + nameOfCurrentTest.getMethodName());
            // If we are using the DebugFinish, dump all throwables collected on each host
            DebugFinish.dumpAllSuppressedExceptions();
        }
    }
}
