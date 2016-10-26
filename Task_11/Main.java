package Movement;

import java.util.ArrayList;
import java.util.List;

/**
 * Class, which consist of methods main(input point in the program), meansOfTransport, which create list of
 * them and print, which output on the screen.
 * @author Irina Bogatko
 * @version 1.0
 * @since 26.10.2016
 */
public class Main {

    /**
     * Output point in the program
     * @param args command line params.
     */
    public static void main(String[] args) {
        ArrayList<Checkpoint> points = new ArrayList<Checkpoint>();
        GetCheckpoints getCheckpoints = new GetCheckpoints();
        points = getCheckpoints.readCheckpoints();
        ArrayList<Trip> allTrip = meansOfTransport();
        for (Checkpoint point : points) {
            for (Trip vehicle : allTrip) {
                vehicle.nextCheckpoint(point);
            }
        }
        print(allTrip);
    }

    /**
     * Method create list of vehicles
     */
    private static ArrayList<Trip> meansOfTransport() {
        ArrayList<Trip> travellersList = new ArrayList<Trip>();
        travellersList.add(new Bicycle());
        travellersList.add(new Bus());
        travellersList.add(new Car());
        travellersList.add(new OnFoot());
        return travellersList;
    }

    /**
     * Output time and price of trip on the screen
     * @param allTrip list of vehicles
     */
    private static void print(List<Trip> allTrip) {
        for (Trip vehicle : allTrip) {
            System.out.print(vehicle.getName() + ": ");
            System.out.print("time = " +  vehicle.getTripTime() + " hours, ");
            System.out.println("price = " + vehicle.getTripPrice() + " $");
        }
    }
}