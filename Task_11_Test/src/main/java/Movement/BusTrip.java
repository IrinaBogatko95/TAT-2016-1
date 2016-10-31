package Movement;

import java.util.ArrayList;

/**
 * Class, which create new kind of transport - bus and count tripTime and tripPrice.
 * @author Irina Bogatko
 * @version 1.2
 * @since 26.10.2016
 */
public class BusTrip extends Trip {
    //name of vehicle
    private final String NAME = "By bus";
    //speed of vehicle
    private final double SPEED = 40;
    //consumption of fuel
    private final double FUEL_CONSUMPTION = 15;
    //price of fuel
    private final double FUEL_PRICE = 0.5;
    //quantity of passengers
    private int passengers = 40;

    /**
     * Method get name of the bus
     * @return name of the bus
     */
    public String getName() {
        return NAME;
    }

    /**
     * Method count time of trip by bus
     * @param checkpoints list of all checkpoints of trip
     * @return time of trip by bus
     */
    public double getTripTime(ArrayList<Checkpoint> checkpoints) {
        Distance distance = new Distance();
        double time = distance.getDistance(checkpoints) / SPEED;
        return time;
    }

    /**
     * Method count price of trip by bus
     * @param checkpoints list of all checkpoints of trip
     * @return price of trip by bus
     */
    public double getTripPrice(ArrayList<Checkpoint> checkpoints) {
        Distance distance = new Distance();
        double allFuelConsumption = (distance.getDistance(checkpoints) * FUEL_CONSUMPTION / 100);
        double price = allFuelConsumption * FUEL_PRICE / passengers;
        return price;
    }
}
