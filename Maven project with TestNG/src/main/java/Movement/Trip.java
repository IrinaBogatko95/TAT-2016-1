package Movement;

import java.util.ArrayList;

/**
 * Abstract class, consist of methods getName, getTripPrice,
 * getTripTime, which basic for another classes
 * @author Irina Bogatko
 * @version 1.3
 * @since 26.10.2016
 */
public abstract class Trip {

    /**
     * Method get name of vehicle
     */
    public abstract String getName();

    /**
     * Method count time of trip
     * @param checkpoints list of all checkpoints of trip
     */
    public abstract double getTripTime(ArrayList<Checkpoint> checkpoints);
}
