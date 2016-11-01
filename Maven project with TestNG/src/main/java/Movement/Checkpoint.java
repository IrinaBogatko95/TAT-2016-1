package Movement;

/**
 * Class, which consist of coordinates of checkpoints
 * @author Irina Bogatko
 * @version 1.3
 * @since 26.10.2016
 */
public class Checkpoint {
    private double x;
    private double y;

    /**
     * Constructor, which create new checkpoint
     * @param x coordinate X
     * @param y coordinate Y
     */
    public Checkpoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return coordinate X
     */
    public double getX() {
        return x;
    }

    /**
     * @return coordinate Y
     */
    public double getY() {
        return y;
    }
}