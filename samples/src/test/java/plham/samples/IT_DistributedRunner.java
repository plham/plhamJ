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
import handist.mpijunit.ParameterizedMpi;
import handist.mpijunit.ParameterizedMpi.ParameterizedMpiConfig;
import handist.mpijunit.DistributedParameterizedTestLauncher;
import plham.core.main.ParallelRunnerDist;
import plham.samples.CI2002.NewCI2002Main;
import plham.samples.DarkPool.NewDarkPool;
import plham.samples.MarketShare.NewMarketShare;
import plham.samples.ShockTransfer.NewShockTransfer;
import plham.samples.TradingHalt.NewTradingHalt;

@ParameterizedMpiConfig(ranks=4,launcher = DistributedParameterizedTestLauncher.class, timeout = 90l)
@RunWith(ParameterizedMpi.class)
public class IT_DistributedRunner extends PlhamOutputTester {

    public IT_DistributedRunner(String parameterName, Class<?> outputClass, String jsonFile, String seed, String expectedResultFile) {
        super("Distributed_4hosts_"+ parameterName, ParallelRunnerDist.class, expectedResultFile, outputClass.getCanonicalName(), jsonFile, seed);
    }
    
    @Parameters(name="{0}")
    public static Collection<Object[]> constructorParameters() {
        // in the 2D array below are the configurations for each sample program
        Collection<Object[]> parameters = Arrays.asList(new Object [][]{
            /* Simulation name,  OutpuClass,     JSON configuration file,                SEED,        expected output */
            {"New CI2002", NewCI2002Main.class, "src/test/resources/CI2002/config.json", "100", "src/test/resources/MultithreadedOutputs/CI2002.txt"},
            {"New CancelTest", NewCI2002Main.class, "src/test/resources/CancelTest/config.json", "100", "src/test/resources/MultithreadedOutputs/CancelTest.txt"},
            {"MarketShare", NewMarketShare.class, "src/test/resources/MarketShare/config.json", "100", "src/test/resources/MultithreadedOutputs/MarketShare.txt"},
            {"New FatTail", NewCI2002Main.class, "src/test/resources/FatTail/config-shortened.json", "100", "src/test/resources/MultithreadedOutputs/FatTail-shortened.txt"}, // using the "shortened" version of FatTail
            {"New TradingHalt", NewTradingHalt.class, "src/test/resources/TradingHalt/config.json", "100", "src/test/resources/MultithreadedOutputs/TradingHalt.txt"},
            {"New ShockTransfer", NewShockTransfer.class, "src/test/resources/ShockTransfer/config.json", "100", "src/test/resources/MultithreadedOutputs/ShockTransfer.txt"},
            {"New PriceLimit", NewCI2002Main.class, "src/test/resources/PriceLimit/config.json", "100", "src/test/resources/MultithreadedOutputs/PriceLimit.txt"},
            {"FatFinger", NewCI2002Main.class, "src/test/resources/FatFinger/config.json", "100", "src/test/resources/MultithreadedOutputs/FatFinger.txt"},
// Not Supported yet {"DarkPool", NewDarkPool.class, "src/test/resources/DarkPool/config.json", "100", "src/test/resources/MultithreadedOutputs/DarkPool.txt"}
        });
        
        return parameters;
    }
    

    @Rule
    public transient TestName nameOfCurrentTest = new TestName();
    
    @After
    public void afterEachTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException {
        if (DebugFinish.class.getCanonicalName().equals(System.getProperty(Config.APGAS_FINISH))) {
            System.err.println("Dumping the errors that occurred during " + nameOfCurrentTest.getMethodName());
            // If we are using the DebugFinish, dump all throwables collected on each host
            DebugFinish.dumpAllSuppressedExceptions();
        }
    }
    
    @BeforeClass
    public static void beforeClass() {
        System.setProperty(PLHAMOUTPUTTEST_CREATE_OUTPUT, "true");
    }
}
