package Movement;

/**
 * Class, which create new mean of transport - on foot and count tripTime and tripPrice.
 * @author Irina Bogatko
 * @version 1.1
 * @since 26.10.2016
 */
public class TripOnFoot extends Trip {
    //name of mean of transport
    private final String NAME = "On foot";
    //speed on foot
    private final double SPEED = 4;

    /**
     * Returns name of mean of transport
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