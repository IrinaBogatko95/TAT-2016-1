package Movement;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckpointTest {
    @Test
    public void positiveTestGetX() throws Exception {
        Checkpoint checkpoint = new Checkpoint(100, 0);
        assertEquals(100, checkpoint.getX(), 0.001);
    }

    @Test
    public void negativeTestGetXInfinity() throws Exception {
        Checkpoint checkpoint = new Checkpoint(Double.POSITIVE_INFINITY, 0);
        assertEquals(Double.POSITIVE_INFINITY, checkpoint.getX(), 0.001);
    }

    @Test
    public void negativeTestGetXNaN() throws Exception {
        Checkpoint checkpoint = new Checkpoint(Double.NaN, 0);
        assertEquals(Double.NaN, checkpoint.getX(), 0.001);
    }

    @Test
    public void negativeTestGetXHugeValues() throws Exception {
        Checkpoint checkpoint = new Checkpoint(-4.9e-324, 0);
        assertEquals(-4.9e-324, checkpoint.getX(), 0.001);
    }

    @Test
    public void positiveTestGetXDecimal() throws Exception {
        Checkpoint checkpoint = new Checkpoint(4 / 10, 0);
        assertEquals(0.4, checkpoint.getX(), 0.001);
    }

    @Test
    public void positiveTestGetY() throws Exception {
        Checkpoint checkpoint = new Checkpoint(0, 100);
        assertEquals(100, checkpoint.getY(), 0.001);
    }

    @Test
    public void negativeTestGetYInfinity() throws Exception {
        Checkpoint checkpoint = new Checkpoint(0, Double.NEGATIVE_INFINITY);
        assertEquals(Double.NEGATIVE_INFINITY, checkpoint.getY(), 0.001);
    }

    @Test
    public void negativeTestGetYNaN() throws Exception {
        Checkpoint checkpoint = new Checkpoint(0, Double.NaN);
        assertEquals(Double.NaN, checkpoint.getY(), 0.001);
    }

    @Test
    public void negativeTestGetYHugeValues() throws Exception {
        Checkpoint checkpoint = new Checkpoint(0, 1.7e+308);
        assertEquals(1.7e+308, checkpoint.getY(), 0.001);
    }

    @Test
    public void positiveTestGetYDecimal() throws Exception {
        Checkpoint checkpoint = new Checkpoint(0, 3 / 8);
        assertEquals(0.375, checkpoint.getY(), 0.001);
    }
}