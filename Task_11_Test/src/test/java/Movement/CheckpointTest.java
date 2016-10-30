package Movement;

import org.junit.Test;
import static org.junit.Assert.*;

public class CheckpointTest {
    @Test
    public void testGetX() throws Exception {
        Checkpoint checkpoint = new Checkpoint(100, 0);
        assertEquals(100, checkpoint.getX(), 0.001);
    }

    @Test
    public void testGetXHugeValues() throws Exception {
        Checkpoint checkpoint = new Checkpoint(-4.9e-324, 0);
        assertEquals(-4.9e-324, checkpoint.getX(), 0.001);
    }

    @Test
    public void testGetXDecimal() throws Exception {
        Checkpoint checkpoint = new Checkpoint(4 / 10, 0);
        assertEquals(0.4, checkpoint.getX(), 0.001);
    }

    @Test
    public void getY() throws Exception {
        Checkpoint checkpoint = new Checkpoint(0, 100);
        assertEquals(100, checkpoint.getY(), 0.001);
    }

    @Test
    public void testGetYHugeValues() throws Exception {
        Checkpoint checkpoint = new Checkpoint(0, 1.7e+308);
        assertEquals(1.7e+308, checkpoint.getY(), 0.001);
    }

    @Test
    public void testGetYDecimal() throws Exception {
        Checkpoint checkpoint = new Checkpoint(0, 3 / 8);
        assertEquals(0.375, checkpoint.getY(), 0.001);
    }
}