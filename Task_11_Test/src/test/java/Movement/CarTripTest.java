package Movement;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CarTripTest {
    private ArrayList<Checkpoint> checkpoints;
    private CarTrip carTrip;

    @Before
    public void setUp() {
        checkpoints = new ArrayList<Checkpoint>();
        carTrip = new CarTrip();
    }

    @Test
    public void positiveTestGetName() throws Exception {
        assertEquals("By car", carTrip.getName());
    }

    @Test
    public void positiveTestGetTripTime() throws Exception {
        Checkpoint checkpoint1 = new Checkpoint(8.0, 1.11);
        Checkpoint checkpoint2 = new Checkpoint(-150.0, 0.3);
        Checkpoint checkpoint3 = new Checkpoint(-40.0, 6.1);
        checkpoints.add(checkpoint1);
        checkpoints.add(checkpoint2);
        checkpoints.add(checkpoint3);
        double time = carTrip.getTripTime(checkpoints);
        assertEquals(3.573, time, 0.001);
    }

    @Test
    public void positiveTestGetTripPrice() throws Exception {
        Checkpoint checkpoint1 = new Checkpoint(0.0, 2.6);
        Checkpoint checkpoint2 = new Checkpoint(6.0, 9.0);
        Checkpoint checkpoint3 = new Checkpoint(156.0, 80.0);
        checkpoints.add(checkpoint1);
        checkpoints.add(checkpoint2);
        checkpoints.add(checkpoint3);
        double price = carTrip.getTripPrice(checkpoints);
        assertEquals(4.375, price, 0.001);
    }
}