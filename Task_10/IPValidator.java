package Task_10;

import java.util.ArrayList;

/**
 * The class checks IP address for validity
 * @author Bogatko Irina
 * @version 1.0
 * @since 19.10.2016
 */
public class IPValidator {

    /**
     * Method checks IP address for validity
     * @param ipAddress arraylist with IP of servers
     */
    public void validateIpAddress(ArrayList<String> ipAddress) {

        for (String ip : ipAddress) {
            for (int i = 0; i < 3; i++) {
                int delimiter = ip.indexOf(".");
                String ipPart = ip.substring(0, delimiter);
                int devideNumbers = Integer.parseInt(ipPart);
                if ((delimiter == -1) || (devideNumbers < 0 || devideNumbers > 255)) {
                   System.out.println("Error: Wrong IP address.");
                }
            }
        }
    }
}