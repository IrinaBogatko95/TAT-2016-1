package Movement;

import java.util.ArrayList;

/**
 * Class, which create new kind of transport - car and count tripTime and tripPrice.
 * @author Irina Bogatko
 * @version 1.2
 * @since 26.10.2016
 */
public class CarTrip extends Trip {
    //name of vehicle
    private final String NAME = "By car";
    //speed of vehicle
    private final double SPEED = 75;
    //consumption of fuel
    private final double FUEL_CONSUMPTION = 5;
    //price of fuel
    private final double FUEL_PRICE = 0.5;

    /**
     * Returns name of car
     */
    public String getName() {
        return NAME;
    }

    /**
     * Returns time of trip on car
     * @param checkpoints list of all checkpoints of trip
     */
    public double getTripTime(ArrayList<Checkpoint> checkpoints) {
        Distance distance = new Distance();
        double time = distance.getDistance(checkpoints) / SPEED;
        return 1000 * time / 1000;
    }

    /**
     * Returns price of trip on car
     * @param checkpoints list of all checkpoints of trip
     */
    public double getTripPrice(ArrayList<Checkpoint> checkpoints) {
        Distance distance = new Distance();
        double allFuelConsumption = distance.getDistance(checkpoints) * FUEL_CONSUMPTION / 100;
        double price = allFuelConsumption * FUEL_PRICE;
        return 1000 * price / 1000;
    }
}