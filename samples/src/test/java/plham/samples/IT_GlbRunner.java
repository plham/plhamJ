package plham.samples;

import static plham.core.main.Config.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import apgas.impl.Config;
import apgas.impl.DebugFinish;
import handist.collections.dist.TeamedPlaceGroup;
import handist.mpijunit.DistributedParameterizedTestLauncher;
import handist.mpijunit.ParameterizedMpi;
import handist.mpijunit.ParameterizedMpi.ParameterizedMpiConfig;
import plham.core.main.SimulatorFactory;
import plham.core.main.glb.GlbRunner;
import plham.core.main.glb.PlhamLifeline;
import plham.samples.CI2002.NewCI2002Main;
import plham.samples.MarketShare.NewMarketShare;
import plham.samples.ShockTransfer.NewShockTransfer;
import plham.samples.TradingHalt.NewTradingHalt;

@ParameterizedMpiConfig(ranks = 4, launcher = DistributedParameterizedTestLauncher.class, timeout = 120l)
@RunWith(ParameterizedMpi.class)
public class IT_GlbRunner extends PlhamOutputTester {

    @Parameters(name = "{0}")
    public static Collection<Object[]> constructorParameters() {
        // in the 2D array below are the configurations for each sample program
        final Collection<Object[]> parameters = Arrays.asList(new Object[][] {
                /*
                 * Simulation name, OutpuClass, JSON configuration file, SEED, expected output
                 */
                { "New CI2002", NewCI2002Main.class, "src/test/resources/CI2002/config.json", "100",
                        "src/test/resources/MultithreadedOutputs/CI2002.txt", "src/test/resources/CI2002/config.json" },
                { "New CancelTest", NewCI2002Main.class, "src/test/resources/CancelTest/config.json", "100",
                        "src/test/resources/MultithreadedOutputs/CancelTest.txt",
                        "src/test/resources/CI2002/config.json" },
                { "MarketShare", NewMarketShare.class, "src/test/resources/MarketShare/config.json", "100",
                        "src/test/resources/MultithreadedOutputs/MarketShare.txt",
                        "src/test/resources/CI2002/config.json" },
                { "New FatTail", NewCI2002Main.class, "src/test/resources/FatTail/config-shortened.json", "100",
                        "src/test/resources/MultithreadedOutputs/FatTail-shortened.txt",
                        "src/test/resources/CI2002/config.json" }, // using the "shortened"
                // version of FatTail
                { "New TradingHalt", NewTradingHalt.class, "src/test/resources/TradingHalt/config.json", "100",
                        "src/test/resources/MultithreadedOutputs/TradingHalt.txt",
                        "src/test/resources/CI2002/config.json" },
                { "New ShockTransfer", NewShockTransfer.class, "src/test/resources/ShockTransfer/config.json", "100",
                        "src/test/resources/MultithreadedOutputs/ShockTransfer.txt",
                        "src/test/resources/CI2002/config.json" },
                { "New PriceLimit", NewCI2002Main.class, "src/test/resources/PriceLimit/config.json", "100",
                        "src/test/resources/MultithreadedOutputs/PriceLimit.txt",
                        "src/test/resources/CI2002/config.json" },
                { "FatFinger", NewCI2002Main.class, "src/test/resources/FatFinger/config.json", "100",
                        "src/test/resources/MultithreadedOutputs/FatFinger.txt",
                        "src/test/resources/CI2002/config.json" }// ,
//            { "BlackScholes", NewShockTransfer.class, "src/test/resources/BlackScholes/config-a099.json", "100",
//                                                "src/test/resources/BlackScholes/expected_output.txt", "src/test/resources/BlackScholes/bs-warmup.json"}//,
//            { "BlackScholes with load", NewShockTransfer.class, "src/test/resources/BlackScholes/config-shutdown.json", "100",
//            "src/test/resources/BlackScholes/expected_shutdown_output.txt", "src/test/resources/BlackScholes/bs-warmup.json"}
        });

        // For each problem we check with 2 lifeline strategies
        final Collection<Object[]> toReturn = new ArrayList<>(parameters.size() * 1);
        parameters.forEach(a -> {
//            final Object[] noLifeline = Arrays.copyOf(a, a.length + 1);
            final Object[] plhamLifeline = Arrays.copyOf(a, a.length + 1);

//            noLifeline[a.length] = NoLifeline.class.getCanonicalName();
            plhamLifeline[a.length] = PlhamLifeline.class.getCanonicalName();

            // Modify the name
//            noLifeline[0] = noLifeline[0] + " - No Lifeline";
            plhamLifeline[0] = plhamLifeline[0] + " - Plham Lifeline";

//            toReturn.add(noLifeline);
            toReturn.add(plhamLifeline);
        });

        return toReturn;
    }

    /**
     * Canonical name of the lifeline being used to run this specific test
     */
    private final String lifeline;

    @Rule
    public transient TestName nameOfCurrentTest = new TestName();

    public IT_GlbRunner(String name, Class<?> mainClass, String jsonFile, String seed, String expectedFileOutput,
            String warmupJson, String lifelineClass) {
        super(name, GlbRunner.class, expectedFileOutput, mainClass.getCanonicalName(), jsonFile, seed, warmupJson);
        lifeline = lifelineClass;
    }

    @After
    public void afterEachTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException {
        if (DebugFinish.class.getCanonicalName().equals(System.getProperty(Config.APGAS_FINISH))
                && DebugFinish.suppressedExceptionsPresent()) {
            System.err.println("Dumping the errors that occurred during " + nameOfCurrentTest.getMethodName());
            // If we are using the DebugFinish, dump all throwables collected on each host
            DebugFinish.dumpAllSuppressedExceptions();
        }
    }

    @Before
    @Override
    public void before() {
        super.before();
        final String slifeline = lifeline;
        TeamedPlaceGroup.getWorld().broadcastFlat(() -> {
            System.setProperty(LIFELINE_CLASS, slifeline);
            System.setProperty(PLHAMOUTPUTTEST_CREATE_OUTPUT, "true");
            System.setProperty(SimulatorFactory.LEGACY_CLASS_WARNINGS_PROPERTY, "false");
            System.setProperty(handist.collections.glb.Config.GRANULARITY, "100");
            System.setProperty(RESET_GLB_TRACKING, "15");
//            System.setProperty(ParallelRunnerDistManualLB.LOAD_BALANCE_DUMPFILE, "glb_runner_distribution_dump.csv");
        });
    }
}
