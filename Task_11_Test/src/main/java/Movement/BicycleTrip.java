package Movement;

import java.util.ArrayList;

/**
 * Class, which create new kind of transport - bicycle and count tripTime and tripPrice.
 * @author Irina Bogatko
 * @version 1.2
 * @since 26.10.2016
 */
public class BicycleTrip extends Trip {
    //name of vehicle
    private final String NAME = "By bicycle";
    //speed of vehicle
    private final double SPEED = 20;

    /**
     * Returns name of bicycle
     */
    public String getName() {
        return NAME;
    }

    /**
     * Returns time of trip on bicycle
     * @param checkpoints list of all checkpoints of trip
     */
    public double getTripTime(ArrayList<Checkpoint> checkpoints) {
        Distance distance = new Distance();
        double time = distance.getDistance(checkpoints) / SPEED;
        return time;
    }

    /**
     * Returns price of trip on bicycle
     * @param checkpoints list of all checkpoints of trip
     */
    public double getTripPrice(ArrayList<Checkpoint> checkpoints) {
        return 0;
    }
}

