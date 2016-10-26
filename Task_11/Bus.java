package Movement;

/**
 * Class, which create new kind of transport - bus and count tripTime and tripPrice.
 * @author Irina Bogatko
 * @version 1.0
 * @since 26.10.2016
 */
public class Bus extends Trip {
    //name of vehicle
    private final String NAME = "Bus";
    //speed of vehicle
    private final double SPEED = 40;
    //consumption of fuel
    private final double FUEL_CONSUMPTION = 15;
    //price of fuel
    private final double FUEL_PRICE = 0.5;
    //quantity of passengers
    private int passengers = 40;

    private Distance distance = new Distance();

    /**
     * Returns name of bus
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
        double allFuelConsumption = (distance.getDistance() * FUEL_CONSUMPTION / 100);
        double price = allFuelConsumption * FUEL_PRICE / passengers;
        return price;
    }

    /**
     * Address to next checkpoint of trip
     */
    public void nextCheckpoint(Checkpoint point) {
        distance.nextPoint(point);
    }

}

