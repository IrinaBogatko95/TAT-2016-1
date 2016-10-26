package Movement;

/**
 * Class, which consist of coordinates of checkpoints
 * @author Irina Bogatko
 * @version 1.0
 * @since 26.10.2016
 */
public class Checkpoint {

    private double x;
    private double y;

    /**
     * Constructor, which create new checkpoint
     */
    public Checkpoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns coordinate X
     */
    public double getX() {
        return x;
    }

    /**
     * Returns coordinate Y
     */
    public double getY() {
        return y;
    }
}