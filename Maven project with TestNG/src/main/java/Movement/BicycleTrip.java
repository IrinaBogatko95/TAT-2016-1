package Movement;

import java.util.ArrayList;

/**
 * Class, which create new kind of transport - bicycle and count tripTime and tripPrice.
 * @author Irina Bogatko
 * @version 1.3
 * @since 26.10.2016
 */
public class BicycleTrip extends Trip {
    //name of vehicle
    private final String NAME = "By bicycle";
    //speed of vehicle
    private final double SPEED = 20;

    /**
     * Method get name of the bicycle
     * @return name of the bicycle
     */
    public String getName() {
        return NAME;
    }

    /**
     * Method count time of trip by bicycle
     * @param checkpoints list of all checkpoints of trip
     * @return time of trip by bicycle
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

