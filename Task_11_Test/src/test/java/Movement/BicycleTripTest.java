package Movement;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class BicycleTripTest {
    private ArrayList<Checkpoint> checkpoints;
    private BicycleTrip bicycleTrip;

    @Before
    public void setUp() {
        checkpoints = new ArrayList<Checkpoint>();
        bicycleTrip = new BicycleTrip();
    }

    @Test
    public void positiveTestGetName() throws Exception {
        assertEquals("By bicycle", bicycleTrip.getName());
    }

    @Test
    public void positiveTestGetTripTime() throws Exception {
        Checkpoint checkpoint1 = new Checkpoint(0.0, 0);
        Checkpoint checkpoint2 = new Checkpoint(100.0, 0);
        Checkpoint checkpoint3 = new Checkpoint(40.0, 0);
        checkpoints.add(checkpoint1);
        checkpoints.add(checkpoint2);
        checkpoints.add(checkpoint3);
        double time = bicycleTrip.getTripTime(checkpoints);
        assertEquals(8, time, 0.001);
    }

    @Test
    public void positiveTestGetTripPrice() throws Exception {
        Checkpoint checkpoint1 = new Checkpoint(0.0, 0);
        Checkpoint checkpoint2 = new Checkpoint(100.0, 0);
        Checkpoint checkpoint3 = new Checkpoint(40.0, 0);
        checkpoints.add(checkpoint1);
        checkpoints.add(checkpoint2);
        checkpoints.add(checkpoint3);
        double price = bicycleTrip.getTripPrice(checkpoints);
        assertEquals(0, price, 0.001);
    }
}