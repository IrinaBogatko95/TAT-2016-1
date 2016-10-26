package Movement;

/**
 * Class, which create new mean of transport - on foot and count tripTime and tripPrice.
 * @author Irina Bogatko
 * @version 1.0
 * @since 26.10.2016
 */
public class OnFoot extends Trip {
    //name of mean of transport
    private final String NAME = "On foot";
    //speed on foot
    private final double SPEED = 4;

    private Distance distance = new Distance();

    /**
     * Returns name of mean of transport
     */
    public String getName() {
        return NAME;
    }

    /**
     * Returns time of trip
     */
    public double getTripTime()  {
        double time = distance.getDistance() / SPEED;
        return time;
    }

    /**
     * Returns price of trip
     */
    public double getTripPrice() {
        return 0;
    }

    /**
     * Address to next checkpoint of trip
     */
    public void nextCheckpoint(Checkpoint point) {
        distance.nextPoint(point);
    }


}