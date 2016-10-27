package Movement;

/**
 * Class, which count the distance between checkpoints
 * @author Irina Bogatko
 * @version 1.1
 * @since 26.10.2016
 */
public class Distance {
    private Checkpoint givenPoint;
    private double distance = 0;

    /**
     * Count distance between checkpoints
     * @param point current point of trip
     */
    public void nextPoint(Checkpoint point) {
        if (givenPoint == null) {
            givenPoint = point;
            return;
        }
        distance += Math.sqrt((point.getX() - givenPoint.getX()) * (point.getX() - givenPoint.getX())
                + (point.getY() - givenPoint.getY()) * (point.getY() - givenPoint.getY()));
        givenPoint = point;
    }

    /**
     * Returns distance between checkpoints
     */
    public double getDistance() {
        return distance;
    }
}