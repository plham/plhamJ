package plham.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import plham.core.main.ParallelRunnerMT;
import plham.samples.CI2002.CI2002Main;
import plham.samples.CI2002.NewCI2002Main;
import plham.samples.DarkPool.DarkPoolMain;
import plham.samples.FatFinger.FatFingerMain;
import plham.samples.MarketShare.MarketShareMain;
import plham.samples.PriceLimit.PriceLimitMain;
import plham.samples.ShockTransfer.ShockTransferMain;
import plham.samples.TradingHalt.TradingHaltMain;

@RunWith(Parameterized.class)
public class IT_MultiThreadedRunner extends PlhamOutputTester {
	
	public IT_MultiThreadedRunner(String testName, Class<?> outputClass, String jsonConfig, String seed, String expectedOutput, String parallelism) {
		super(ParallelRunnerMT.class, expectedOutput, outputClass.getCanonicalName(), jsonConfig, seed, parallelism);
	}
	
	@Parameters(name="{0} with {5} threads")
	public static Collection<Object[]> constructorParameters() {
	    // in the 2D array below are the configurations for each sample program
	    Collection<Object[]> parameters = Arrays.asList(new Object [][]{
	        /* SimulatorOutput,                JSON configuration file,  SEED,        expected output */
            {"CI2002", CI2002Main.class, "src/test/resources/CI2002/config.json", "100", "src/test/resources/MultithreadedOutputs/CI2002.txt"},
            {"New CI2002", NewCI2002Main.class, "src/test/resources/CI2002/config.json", "100", "src/test/resources/MultithreadedOutputs/CI2002.txt"},
            {"CancelTest", CI2002Main.class, "src/test/resources/CancelTest/config.json", "100", "src/test/resources/MultithreadedOutputs/CancelTest.txt"},
            {"MarketShare", MarketShareMain.class, "src/test/resources/MarketShare/config.json", "100", "src/test/resources/MultithreadedOutputs/MarketShare.txt"},
            {"FatTail", CI2002Main.class, "src/test/resources/FatTail/config.json", "100", "src/test/resources/MultithreadedOutputs/FatTail.txt"},
            {"TradingHalt", TradingHaltMain.class, "src/test/resources/TradingHalt/config.json", "100", "src/test/resources/MultithreadedOutputs/TradingHalt.txt"},
            {"ShockTransfer", ShockTransferMain.class, "src/test/resources/ShockTransfer/config.json", "100", "src/test/resources/MultithreadedOutputs/ShockTransfer.txt"},
            {"PriceLimit", PriceLimitMain.class, "src/test/resources/PriceLimit/config.json", "100", "src/test/resources/MultithreadedOutputs/PriceLimit.txt"},
            {"FatFinger", FatFingerMain.class, "src/test/resources/FatFinger/config.json", "100", "src/test/resources/MultithreadedOutputs/FatFinger.txt"},
            {"DarkPool", DarkPoolMain.class, "src/test/resources/DarkPool/config.json", "100", "src/test/resources/MultithreadedOutputs/DarkPool.txt"}
        });
	    
	    // We create 3 configurations per sample, 
	    // - 1 thread 
	    // - 2 threads 
	    // - 4 threads
	    Collection<Object[]> toReturn = new ArrayList<>(parameters.size()*3);
	    parameters.forEach(a -> {
	        Object [] thread1 = Arrays.copyOf(a, a.length + 1);
	        Object [] thread2 = Arrays.copyOf(a, a.length + 1);
	        Object [] thread4 = Arrays.copyOf(a, a.length + 1);
	        
	        thread1[a.length] = "1";
	        thread2[a.length] = "2";
	        thread4[a.length] = "4";
	        
	        toReturn.add(thread1);
	        toReturn.add(thread2);
	        toReturn.add(thread4);
	    });
	    
	    return toReturn;
	}
	
	
	@BeforeClass
	public static void beforeClass() {
	    System.setProperty(PLHAMOUTPUTTEST_CREATE_OUTPUT, "true");
	}
}
