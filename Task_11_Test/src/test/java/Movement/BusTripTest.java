package Movement;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BusTripTest {
    private ArrayList<Checkpoint> checkpoints;
    private BusTrip busTrip;

    @Before
    public void setUp() {
        checkpoints = new ArrayList<Checkpoint>();
        busTrip = new BusTrip();
    }

    @Test
    public void positiveTestGetName() throws Exception {
        assertEquals("By bus", busTrip.getName());
    }

    @Test
    public void positiveTestGetTripTime() throws Exception {
        Checkpoint checkpoint1 = new Checkpoint(8.0, 0.8);
        Checkpoint checkpoint2 = new Checkpoint(250.0, 0.3);
        Checkpoint checkpoint3 = new Checkpoint(-40.0, 6.1);
        checkpoints.add(checkpoint1);
        checkpoints.add(checkpoint2);
        checkpoints.add(checkpoint3);
        double time = busTrip.getTripTime(checkpoints);
        assertEquals(13.3, time, 0.001);
    }

    @Test
    public void positiveTestGetTripPrice() throws Exception {
        Checkpoint checkpoint1 = new Checkpoint(0.0, 0.0);
        Checkpoint checkpoint2 = new Checkpoint(6.0, 0.0);
        Checkpoint checkpoint3 = new Checkpoint(156.0, 0.0);
        checkpoints.add(checkpoint1);
        checkpoints.add(checkpoint2);
        checkpoints.add(checkpoint3);
        double price = busTrip.getTripPrice(checkpoints);
        assertEquals(0.2925, price, 0.001);
    }
}