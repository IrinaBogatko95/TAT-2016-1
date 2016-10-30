package Movement;

import java.util.ArrayList;

/**
 * Class, which create new mean of transport - on foot and count tripTime and tripPrice.
 * @author Irina Bogatko
 * @version 1.2
 * @since 26.10.2016
 */
public class FootTrip extends Trip {
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
     * Returns time of trip on foot
     * @param checkpoints list of all checkpoints of trip
     */
    public double getTripTime(ArrayList<Checkpoint> checkpoints) {
        Distance distance = new Distance();
        double time = distance.getDistance(checkpoints) / SPEED;
        return time;
    }

    /**
     * Returns price of trip on foot
     * @param checkpoints list of all checkpoints of trip
     */
    public double getTripPrice(ArrayList<Checkpoint> checkpoints) {
        return 0;
    }
}