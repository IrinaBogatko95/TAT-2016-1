package Movement;

import java.util.ArrayList;

/**
 * Class, which count the distance between checkpoints
 * @author Irina Bogatko
 * @version 1.3
 * @since 26.10.2016
 */
public class Distance {

    /**
     * Sum distance between all checkpoints
     * @param checkpoints list of all checkpoints
     * @return all distance of trip
     */
    public double getDistance(ArrayList<Checkpoint> checkpoints) {

        double distance = 0;
        for (int i = 1; i < checkpoints.size(); i++) {
            distance += distanceBetweenCheckpoints(checkpoints.get(i - 1), checkpoints.get(i));
        }
        double allDistance = 1000 * Math.rint(distance) / 1000;
        if(allDistance == Double.NaN ||allDistance == Double.NEGATIVE_INFINITY || allDistance == Double.POSITIVE_INFINITY)
            throw new ArithmeticException("Wrong distance!");
        return allDistance;
    }

    /**
     * Count and return distance between two checkpoints
     * @param firstCheckpoint  first checkpoint of trip
     * @param secondCheckpoint second checkpoint of trip
     * @return distance between checkpoints
     */
    public double distanceBetweenCheckpoints(Checkpoint firstCheckpoint, Checkpoint secondCheckpoint) {
        double distance = Math.sqrt((secondCheckpoint.getX() - firstCheckpoint.getX()) * (secondCheckpoint.getX()
                - firstCheckpoint.getX()) + (secondCheckpoint.getY() - firstCheckpoint.getY())
                * (secondCheckpoint.getY() - firstCheckpoint.getY()));
        if(distance == Double.NaN ||distance == Double.NEGATIVE_INFINITY || distance == Double.POSITIVE_INFINITY)
            throw new ArithmeticException("Wrong distance!");
        return distance;
    }
}