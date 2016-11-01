package Movement;

import java.util.ArrayList;

/**
 * Interface consist of methods getName, getTripPrice,
 * getTripTime, implements classes of fueled transports
 * @author Irina Bogatko
 * @version 1.3
 * @since 26.10.2016
 */
public interface TripByFueledVehicle {

    /**
     * Method get name of vehicle
     */
    String getName();

    /**
     * Method count time of trip
     * @param checkpoints list of all checkpoints of trip
     */
    double getTripTime(ArrayList<Checkpoint> checkpoints);

    /**
     * Method count price of trip
     * @param checkpoints list of all checkpoints of trip
     */
    double getTripPrice(ArrayList<Checkpoint> checkpoints);
}
