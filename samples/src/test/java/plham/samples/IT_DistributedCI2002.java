package plham.samples;

import org.junit.Ignore;
import org.junit.runner.RunWith;

import handist.mpijunit.MpiConfig;
import handist.mpijunit.MpiRunner;
import handist.mpijunit.TestLauncher;
import plham.core.main.ParallelRunnerDist;
import plham.samples.CI2002.CI2002Main;

@Ignore
@MpiConfig(ranks=4,launcher = TestLauncher.class)
@RunWith(MpiRunner.class)
public class IT_DistributedCI2002 extends PlhamOutputTester {

    public IT_DistributedCI2002() {
        super("DistributedRunner_CI2002", ParallelRunnerDist.class, "src/test/resources/CI2002/correct_output.txt", CI2002Main.class.getCanonicalName(), "src/test/resources/CI2002/config.json", "100");
    }
}
