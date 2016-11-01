package Movement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class DistanceTest {
    private Distance distance;

    @DataProvider(name = "Positive test")
    public Object[][] positiveTestAddPointsToGetDistance() {
        ArrayList<Checkpoint> firstSet = new ArrayList<Checkpoint>();
        firstSet.add(new Checkpoint(20.0, 2.0));
        firstSet.add(new Checkpoint(79.0, 8.5));
        ArrayList<Checkpoint> secondSet = new ArrayList<Checkpoint>();
        secondSet.add(new Checkpoint(50.0, 0.0));
        secondSet.add(new Checkpoint(100.0, 0.0));
        secondSet.add(new Checkpoint(0.0, 0.0));
        secondSet.add(new Checkpoint(50.0, 0.0));
        ArrayList<Checkpoint> thirdSet = new ArrayList<Checkpoint>();
        thirdSet.add(new Checkpoint(0.0, 0.0));
        thirdSet.add(new Checkpoint(50.0, 0.0));
        thirdSet.add(new Checkpoint(100.0, 0.0));
        thirdSet.add(new Checkpoint(150.0, 0.0));
        ArrayList<Checkpoint> fourthSet = new ArrayList<Checkpoint>();
        fourthSet.add(new Checkpoint(0.0, 0.0));
        fourthSet.add(new Checkpoint(500.0, 0.0));
        fourthSet.add(new Checkpoint(250.0, 0.0));

        return new Object[][]{
                {59.0, firstSet},
                {200.0, secondSet},
                {150.0, thirdSet},
                {750.0, fourthSet}
        };
    }

    @DataProvider(name = "Negative test")
    public Object[][] negativeTestAddPointsToGetDistance() {
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
        ArrayList<Checkpoint> seventhSet = new ArrayList<Checkpoint>();
        seventhSet.add(new Checkpoint(0.0, 0.0));
        seventhSet.add(new Checkpoint(20.0, 0.0));
        seventhSet.add(new Checkpoint(0.0, 0.0));
        ArrayList<Checkpoint> eighthSet = new ArrayList<Checkpoint>();
        eighthSet.add(new Checkpoint(-4.9e-324, 0.0));
        eighthSet.add(new Checkpoint(1.7e+308, 0.0));
        ArrayList<Checkpoint> ninthSet = new ArrayList<Checkpoint>();
        ninthSet.add(new Checkpoint(1.7e+308, 0.0));
        ninthSet.add(new Checkpoint(-4.9e-324, 0.0));

        return new Object[][]{
                {Double.NaN, firstSet},
                {Double.NaN, secondSet},
                {Double.NEGATIVE_INFINITY, thirdSet},
                {Double.POSITIVE_INFINITY, fourthSet},
                {Double.POSITIVE_INFINITY, fifthSet},
                {Double.NEGATIVE_INFINITY, sixthSet},
                {40.0, seventhSet},
                {Double.NEGATIVE_INFINITY, eighthSet},
                {Double.NEGATIVE_INFINITY, ninthSet}
        };
    }

    @DataProvider(name = "Positive test for two points")
    public Object[][] positiveTestAddPointsToDistanceBetweenCheckpoints() {
        return new Object[][]{
                {100.0, new Checkpoint(0.0, 0.0), new Checkpoint(100.0, 0.0)},
                {100.0, new Checkpoint(100.0, 0.0), new Checkpoint(0.0, 0.0)},
                {141.4213562373095, new Checkpoint(100.0, 200.0), new Checkpoint(200.0, 100.0)},
                {250.0, new Checkpoint(500.0, 0.0), new Checkpoint(250.0, 0.0)},
                {141.4213562373095, new Checkpoint(-100.0, -200.0), new Checkpoint(-200.0, -100.0)},
                {250.0, new Checkpoint(-500.0, 0.0), new Checkpoint(-250.0, 0.0)}
        };
    }

    @DataProvider(name = "Negative test for two points")
    public Object[][] negativeTestAddPointsToDistanceBetweenCheckpoints() {
        return new Object[][]{
                {Double.NaN, new Checkpoint(Double.NaN, 0.0), new Checkpoint(0.0, Double.NaN)},
                {Double.NaN, new Checkpoint(0.0, Double.NaN), new Checkpoint(Double.NaN, 0.0)},
                {Double.POSITIVE_INFINITY, new Checkpoint(Double.POSITIVE_INFINITY, 0.0),
                        new Checkpoint(0.0, Double.NEGATIVE_INFINITY)},
                {Double.NEGATIVE_INFINITY, new Checkpoint(0.0, Double.POSITIVE_INFINITY),
                        new Checkpoint(Double.NEGATIVE_INFINITY, 0.0)},
                {Double.NEGATIVE_INFINITY, new Checkpoint(1.7e+308, 0.0), new Checkpoint(-4.9e-324, 0.0)},
                {Double.NEGATIVE_INFINITY, new Checkpoint(-4.9e-324, 0.0), new Checkpoint(1.7e+308, 0.0)}
        };
    }

    @BeforeMethod
    public void setUp() {
        distance = new Distance();
    }

    @Test(dataProvider = "Positive test")
    public void positiveTestGetDistance(double expected, ArrayList<Checkpoint> checkpoints) {
        assertEquals(distance.getDistance(checkpoints), expected);
    }

    @Test(dataProvider = "Negative test", expectedExceptions = ArithmeticException.class)
    public void negativeTestGetDistance(double expected, ArrayList<Checkpoint> checkpoints) {
        assertEquals(distance.getDistance(checkpoints), expected);
    }

    @Test(dataProvider = "Positive test for two points")
    public void positiveTestDistanceBetweenCheckpoints(double expected, Checkpoint first, Checkpoint second) {
        assertEquals(distance.distanceBetweenCheckpoints(first, second), expected);
    }

    @Test(dataProvider = "Negative test for two points", expectedExceptions = ArithmeticException.class)
    public void negativeTestDistanceBetweenCheckpoints(double expected, Checkpoint first, Checkpoint second) {
        assertEquals(distance.distanceBetweenCheckpoints(first, second), expected);
    }
}