package Movement;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class DistanceTest {
    private ArrayList<Checkpoint> checkpoints;
    private Distance distance;

    @Before
    public void setUp() {
        checkpoints = new ArrayList<Checkpoint>();
        distance = new Distance();
    }

    @Test
    public void testGetDistance() {
        Checkpoint checkpoint1 = new Checkpoint(0.0, 0.0);
        Checkpoint checkpoint2 = new Checkpoint(-2.6, 0.0);
        Checkpoint checkpoint3 = new Checkpoint(100.2, 0.0);
        Checkpoint checkpoint4 = new Checkpoint(-136.8, 0.0);
        checkpoints.add(checkpoint1);
        checkpoints.add(checkpoint2);
        checkpoints.add(checkpoint3);
        checkpoints.add(checkpoint4);
        assertEquals(342.0, distance.getDistance(checkpoints), 0.01);
    }

    @Test
    public void testGetDistanceNotNegative() {
        Checkpoint checkpoint1 = new Checkpoint(0.0, 0);
        Checkpoint checkpoint2 = new Checkpoint(-100.0, 0);
        Checkpoint checkpoint3 = new Checkpoint(-40.0, 0);
        checkpoints.add(checkpoint1);
        checkpoints.add(checkpoint2);
        checkpoints.add(checkpoint3);
        assertNotEquals(-60, distance.getDistance(checkpoints));
    }

    @Test
    public void testDistanceBetweenCheckpoints() {
        Checkpoint checkpoint1 = new Checkpoint(0.0, 0.0);
        Checkpoint checkpoint2 = new Checkpoint(-2.6, 0.2);
        double allDistance = distance.distanceBetweenCheckpoints(checkpoint1, checkpoint2);
        assertEquals(2.6, allDistance, 0.01);
    }
}