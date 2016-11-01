package Movement;

import java.util.ArrayList;

/**
 * Class, which create new mean of transport - on foot and count tripTime and tripPrice.
 * @author Irina Bogatko
 * @version 1.3
 * @since 26.10.2016
 */
public class FootTrip extends Trip {
    //name of mean of transport
    private final String NAME = "On foot";
    //speed on foot
    private final double SPEED = 4;

    /**
     * Method get name of mean of transport
     * @return name of mean of transport
     */
    public String getName() {
        return NAME;
    }

    /**
     * Method count time of trip on foot
     * @param checkpoints list of all checkpoints of trip
     * @return time of trip on foot
     */
    public double getTripTime(ArrayList<Checkpoint> checkpoints) {
        Distance distance = new Distance();
        double time = distance.getDistance(checkpoints) / SPEED;
        if(time == Double.NaN || time == Double.NEGATIVE_INFINITY || time == Double.POSITIVE_INFINITY){
            throw new ArithmeticException("Invalid time!");
        }
        return time;
    }
}