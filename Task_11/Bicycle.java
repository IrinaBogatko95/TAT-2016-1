package Movement;

/**
 * Class, which create new kind of transport - bicycle and count tripTime and tripPrice.
 * @author Irina Bogatko
 * @version 1.0
 * @since 26.10.2016
 */
public class Bicycle extends Trip {
    //name of vehicle
    private final String NAME = "Bicycle";
    //speed of vehicle
    private final int SPEED = 20;

    private Distance distance = new Distance();

    /**
     * Returns name of bicycle
     */
    public String getName() {
        return NAME;
    }

    /**
     * Returns time of trip
     */
    public double getTripTime() {
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

