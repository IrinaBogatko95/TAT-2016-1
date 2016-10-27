package Movement;

/**
 * Class, which create new kind of transport - bus and count tripTime and tripPrice.
 * @author Irina Bogatko
 * @version 1.1
 * @since 26.10.2016
 */
public class BusTrip extends Trip {
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

    /**
     * Returns name of bus
     */
    public String getName() {
        return NAME;
    }

    /**
     * Returns time of trip
     * @param distance distance between checkpoints
     */
    public double getTripTime(Distance distance) {
        double time = distance.getDistance() / SPEED;
        return time;
    }

    /**
     * Returns price of trip
     * @param distance distance between checkpoints
     */
    public double getTripPrice(Distance distance) {
        double allFuelConsumption = (distance.getDistance() * FUEL_CONSUMPTION / 100);
        double price = allFuelConsumption * FUEL_PRICE / passengers;
        return price;
    }

    /**
     * Address to next checkpoint of trip
     * @param point    current point of trip
     * @param distance distance between checkpoints
     */
    public void nextCheckpoint(Checkpoint point, Distance distance) {
        distance.nextPoint(point);
    }
}
