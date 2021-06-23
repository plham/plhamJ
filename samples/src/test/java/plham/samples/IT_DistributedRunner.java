package plham.samples;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import handist.mpijunit.ParameterizedMpi;
import handist.mpijunit.ParameterizedMpi.ParameterizedMpiConfig;
import handist.mpijunit.DistributedParameterizedTestLauncher;
import plham.core.main.ParallelRunnerDist;
import plham.samples.CI2002.NewCI2002Main;

@ParameterizedMpiConfig(ranks=4,launcher = DistributedParameterizedTestLauncher.class, timeout = 60l)
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
            {"CancelTest", NewCI2002Main.class, "src/test/resources/CancelTest/config.json", "100", "src/test/resources/MultithreadedOutputs/CancelTest.txt"},
//            {"MarketShare", MarketShareMain.class, "src/test/resources/MarketShare/config.json", "100", "src/test/resources/MultithreadedOutputs/MarketShare.txt"},
            {"FatTail", NewCI2002Main.class, "src/test/resources/FatTail/config-shortened.json", "100", "src/test/resources/MultithreadedOutputs/FatTail-shortened.txt"}, // using the "shortened" version of FatTail
//            {"TradingHalt", TradingHaltMain.class, "src/test/resources/TradingHalt/config.json", "100", "src/test/resources/MultithreadedOutputs/TradingHalt.txt"},
//            {"ShockTransfer", ShockTransferMain.class, "src/test/resources/ShockTransfer/config.json", "100", "src/test/resources/MultithreadedOutputs/ShockTransfer.txt"},
//            {"PriceLimit", PriceLimitMain.class, "src/test/resources/PriceLimit/config.json", "100", "src/test/resources/MultithreadedOutputs/PriceLimit.txt"},
//            {"FatFinger", FatFingerMain.class, "src/test/resources/FatFinger/config.json", "100", "src/test/resources/MultithreadedOutputs/FatFinger.txt"},
//            {"DarkPool", DarkPoolMain.class, "src/test/resources/DarkPool/config.json", "100", "src/test/resources/MultithreadedOutputs/DarkPool.txt"}
        });
        
        return parameters;
    }
    
    
    @BeforeClass
    public static void beforeClass() {
        System.setProperty(PLHAMOUTPUTTEST_CREATE_OUTPUT, "true");
    }
}
