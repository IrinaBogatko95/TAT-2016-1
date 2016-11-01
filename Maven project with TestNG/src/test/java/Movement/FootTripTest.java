package Movement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

public class FootTripTest {
    private ArrayList<Checkpoint> checkpoints;
    private FootTrip footTrip;

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

    @BeforeMethod
    public void setUp() {
        checkpoints = new ArrayList<Checkpoint>();
        footTrip = new FootTrip();
    }

    @Test
    public void positiveTestGetName() throws Exception {
        assertEquals(footTrip.getName(), "On foot");
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
        assertEquals(time, 40.0);
    }

    @Test(dataProvider = "Negative test", expectedExceptions = ArithmeticException.class)
    public void negativeTestGetTripTime(double expected, ArrayList<Checkpoint> checkpoints) throws Exception {
        assertEquals(footTrip.getTripTime(checkpoints), expected);
    }
}