package Movement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class BusTripTest {
    private ArrayList<Checkpoint> checkpoints;
    private BusTrip busTrip;

    @BeforeMethod
    public void setUp() {
        checkpoints = new ArrayList<Checkpoint>();
        busTrip = new BusTrip();
    }

    @DataProvider(name = "Negative test")
    public Object[][] negativeTestBusTrip() {
        ArrayList<Checkpoint> firstSet = new ArrayList<Checkpoint>();
        firstSet.add(new Checkpoint(0.0, Double.NaN));
        firstSet.add(new Checkpoint(Double.NaN, 0.0));
        ArrayList<Checkpoint> secondSet = new ArrayList<Checkpoint>();
        secondSet.add(new Checkpoint(Double.NaN, 0.0));
        secondSet.add(new Checkpoint(0.0, Double.NaN));
        ArrayList<Checkpoint> thirdSet = new ArrayList<Checkpoint>();
        thirdSet.add(new Checkpoint(0.0, Double.POSITIVE_INFINITY));
        thirdSet.add(new Checkpoint(Double.NEGATIVE_INFINITY, 0.0));
        ArrayList<Checkpoint> fourthSet = new ArrayList<Checkpoint>();
        fourthSet.add(new Checkpoint(Double.POSITIVE_INFINITY, 0.0));
        fourthSet.add(new Checkpoint(0.0, Double.NEGATIVE_INFINITY));
        ArrayList<Checkpoint> fifthSet = new ArrayList<Checkpoint>();
        fifthSet.add(new Checkpoint(0.0, Double.NEGATIVE_INFINITY));
        fifthSet.add(new Checkpoint(Double.POSITIVE_INFINITY, 0.0));
        ArrayList<Checkpoint> sixthSet = new ArrayList<Checkpoint>();
        sixthSet.add(new Checkpoint(Double.NEGATIVE_INFINITY, 0.0));
        sixthSet.add(new Checkpoint(0.0, Double.POSITIVE_INFINITY));

        return new Object[][]{
                {Double.NaN, firstSet},
                {Double.NaN, secondSet},
                {Double.NEGATIVE_INFINITY, thirdSet},
                {Double.POSITIVE_INFINITY, fourthSet},
                {Double.POSITIVE_INFINITY, fifthSet},
                {Double.NEGATIVE_INFINITY, sixthSet},
        };
    }

    @Test
    public void positiveTestGetName() throws Exception {
        assertEquals(busTrip.getName(), "By bus");
    }

    @Test
    public void positiveTestGetTripTime() {
        Checkpoint checkpoint1 = new Checkpoint(8.0, 0.8);
        Checkpoint checkpoint2 = new Checkpoint(250.0, 0.3);
        Checkpoint checkpoint3 = new Checkpoint(-40.0, 6.1);
        checkpoints.add(checkpoint1);
        checkpoints.add(checkpoint2);
        checkpoints.add(checkpoint3);
        double time = busTrip.getTripTime(checkpoints);
        assertEquals(time, 13.3);
    }

    @Test(dataProvider = "Negative test", expectedExceptions = ArithmeticException.class)
    public void negativeTestGetTripTime(double expected, ArrayList<Checkpoint> checkpoints) throws Exception {
        assertEquals(busTrip.getTripTime(checkpoints), expected);
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
        assertEquals(price, 0.2925);
    }

    @Test(dataProvider = "Negative test", expectedExceptions = ArithmeticException.class)
    public void negativeTestGetTripPrice(double expected, ArrayList<Checkpoint> checkpoints) throws Exception {
        assertEquals(busTrip.getTripPrice(checkpoints), expected);
    }
}