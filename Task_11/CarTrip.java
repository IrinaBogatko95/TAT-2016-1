package Movement;

/**
 * Class, which create new kind of transport - car and count tripTime and tripPrice.
 * @author Irina Bogatko
 * @version 1.0
 * @since 26.10.2016
 */
public class CarTrip extends Trip {
    //name of vehicle
    private final String NAME = "Car";
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
        double allFuelConsumption = distance.getDistance() * FUEL_CONSUMPTION / 100;
        double price = allFuelConsumption * FUEL_PRICE;
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