package Movement;

/**
 * Abstract class, consist of methods getName, getTripPrice,
 * getTripTime, nextCheckpoint, which basic for another classes
 * @author Irina Bogatko
 * @version 1.1
 * @since 26.10.2016
 */
public abstract class Trip {

    /**
     * Returns name of vehicle
     */
    public abstract String getName();

    /**
     * Returns price of trip
     * @param distance distance between checkpoints
     */
    public abstract double getTripPrice(Distance distance);

    /**
     * Returns time of trip
     * @param distance distance between checkpoints
     */
    public abstract double getTripTime(Distance distance);

    /**
     * Address to next checkpoint
     * @param point    current point of trip
     * @param distance distance between checkpoints
     */
    public abstract void nextCheckpoint(Checkpoint point, Distance distance);
}