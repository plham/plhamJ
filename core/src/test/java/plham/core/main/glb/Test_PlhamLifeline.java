package plham.core.main.glb;

import static apgas.Constructs.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import apgas.Place;
import handist.collections.dist.TeamedPlaceGroup;
import handist.mpijunit.MpiConfig;
import handist.mpijunit.MpiRunner;
import handist.mpijunit.launcher.TestLauncher;

@RunWith(MpiRunner.class)
@MpiConfig(ranks = 4, launcher = TestLauncher.class)
public class Test_PlhamLifeline {

    PlhamLifeline l;

    @Before
    public void before() {
        l = new PlhamLifeline(TeamedPlaceGroup.getWorld());
    }

    @Test
    public void checkPlace0() {
        // Place 0 has no lifeline
        List<Place> p0lifeline = l.lifeline(place(0));
        List<Place> p0reverseLifeline = l.reverseLifeline(place(0));
        assertTrue(p0lifeline.isEmpty());
        assertTrue(p0reverseLifeline.isEmpty());
    }


    @Test
    public void checkPlace1() {
        Place p = place(1);
        List<Place> lifeline = l.lifeline(p);
        List<Place> reverseLifeline = l.reverseLifeline(p);

        assertEquals(lifeline.size(), 2);
        assertEquals(reverseLifeline.size(), 2);

        assertTrue(lifeline.contains(place(3)));
        assertTrue(lifeline.contains(place(2)));
        assertTrue(reverseLifeline.contains(place(3)));
        assertTrue(reverseLifeline.contains(place(2)));
    }
    
    @Test
    public void checkPlace2() {
        Place p = place(2);
        List<Place> lifeline = l.lifeline(p);
        List<Place> reverseLifeline = l.reverseLifeline(p);

        assertEquals(lifeline.size(), 2);
        assertEquals(reverseLifeline.size(), 2);

        assertTrue(lifeline.contains(place(3)));
        assertTrue(lifeline.contains(place(1)));
        assertTrue(reverseLifeline.contains(place(3)));
        assertTrue(reverseLifeline.contains(place(1)));
    }
    
    @Test
    public void checkPlace3() {
        Place p = place(3);
        List<Place> lifeline = l.lifeline(p);
        List<Place> reverseLifeline = l.reverseLifeline(p);

        assertEquals(lifeline.size(), 2);
        assertEquals(reverseLifeline.size(), 2);

        assertTrue(lifeline.contains(place(1)));
        assertTrue(lifeline.contains(place(2)));
        assertTrue(reverseLifeline.contains(place(1)));
        assertTrue(reverseLifeline.contains(place(2)));
    }
}
