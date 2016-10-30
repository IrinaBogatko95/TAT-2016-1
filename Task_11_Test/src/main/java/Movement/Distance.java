package Movement;

import java.util.ArrayList;

/**
 * Class, which count the distance between checkpoints
 * @author Irina Bogatko
 * @version 1.2
 * @since 26.10.2016
 */
public class Distance {

    /**
     * Sum distance between all checkpoints
     * @param checkpoints list of all checkpoints
     */
    public double getDistance(ArrayList<Checkpoint> checkpoints) {
        double distance = 0;
        for (int i = 1; i < checkpoints.size(); i++) {
            distance += distanceBetweenCheckpoints(checkpoints.get(i - 1), checkpoints.get(i));
        }
        double allDistance = 1000 * Math.rint(distance) / 1000;
        return allDistance;
    }

    /**
     * Count and return distance between two checkpoints
     * @param firstCheckpoint  first checkpoint of trip
     * @param secondCheckpoint second checkpoint of trip
     */
    public double distanceBetweenCheckpoints(Checkpoint firstCheckpoint, Checkpoint secondCheckpoint) {
        double distance = Math.sqrt((secondCheckpoint.getX() - firstCheckpoint.getX()) * (secondCheckpoint.getX()
                - firstCheckpoint.getX()) + (secondCheckpoint.getY() - firstCheckpoint.getY())
                * (secondCheckpoint.getY() - firstCheckpoint.getY()));
        return distance;
    }
}