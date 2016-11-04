package Movement;

import java.util.ArrayList;
import java.util.List;

/**
 * Class, which consist of methods main(input point in the program), meansOfTransport, which create list of
 * them and print, which output on the screen.
 * @author Irina Bogatko
 * @version 1.2
 * @since 26.10.2016
 */
public class Main {

    /**
     * Output point in the program
     * @param args command line params.
     */
    public static void main(String[] args) {
        ArrayList<Checkpoint> checkpoints = new ArrayList<Checkpoint>();
        GetCheckpoints getCheckpoints = new GetCheckpoints();
        checkpoints = getCheckpoints.readCheckpoints("points.txt");
        ArrayList<Trip> allTrip = meansOfTransport();

        print(allTrip, checkpoints);
    }

    /**
     * Method create list of means of transport
     * @return list of means of transport
     */
    private static ArrayList<Trip> meansOfTransport() {
        ArrayList<Trip> travellersList = new ArrayList<Trip>();
        travellersList.add(new BicycleTrip());
        travellersList.add(new BusTrip());
        travellersList.add(new CarTrip());
        travellersList.add(new FootTrip());
        return travellersList;
    }

    /**
     * Output time and price of trip on the screen
     * @param allTrip  list of vehicles
     * @param checkpoints all checkpoints of the trip
     */
    private static void print(List<Trip> allTrip, ArrayList<Checkpoint> checkpoints) {
        for (Trip vehicle : allTrip) {
            System.out.print(vehicle.getName() + ": ");
            System.out.print("time = " + vehicle.getTripTime(checkpoints) + " hours, ");
            System.out.println("price = " + vehicle.getTripPrice(checkpoints) + " $");
        }
    }
}