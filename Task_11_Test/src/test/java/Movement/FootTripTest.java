package Movement;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FootTripTest {
    private ArrayList<Checkpoint> checkpoints;
    private FootTrip footTrip;

    @Before
    public void setUp() {
        checkpoints = new ArrayList<Checkpoint>();
        footTrip = new FootTrip();
    }

    @Test
    public void positiveTestGetName() throws Exception {
        assertEquals("On foot", footTrip.getName());
    }

    @Test
    public void positiveTestGetTripTime() throws Exception {
        Checkpoint checkpoint1 = new Checkpoint(0.0, 0);
        Checkpoint checkpoint2 = new Checkpoint(100.0, 0);
        Checkpoint checkpoint3 = new Checkpoint(40.0, 0);
        checkpoints.add(checkpoint1);
        checkpoints.add(checkpoint2);
        checkpoints.add(checkpoint3);
        double time = footTrip.getTripTime(checkpoints);
        assertEquals(40, time, 0.001);
    }

    @Test
    public void positiveTestGetTripPrice() throws Exception {
        double price = footTrip.getTripPrice(checkpoints);
        assertEquals(0, price, 0.001);
    }
}