package Movement;

/**
 * Class, which create new kind of transport - bicycle and count tripTime and tripPrice.
 * @author Irina Bogatko
 * @version 1.1
 * @since 26.10.2016
 */
public class BicycleTrip extends Trip {
    //name of vehicle
    private final String NAME = "Bicycle";
    //speed of vehicle
    private final double SPEED = 20;

    /**
     * Returns name of bicycle
     */
    public String getName() {
        return NAME;
    }

    /**
     * Returns time of trip
     * @param distance distance between checkpoints
     */
    public double getTripTime(Distance distance) {
        double time = distance.getDistance() / SPEED;
        return time;
    }

    /**
     * Returns price of trip
     * @param distance distance between checkpoints
     */
    public double getTripPrice(Distance distance) {
        return 0;
    }

    /**
     * Address to next checkpoint of trip
     * @param point    current point of trip
     * @param distance distance between checkpoints
     */
    public void nextCheckpoint(Checkpoint point, Distance distance) {
        distance.nextPoint(point);
    }
}

