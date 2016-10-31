package Task_10;

/**
 * The class contains the constants that get random numbers and max of them.
 * @author Bogatko Irina
 * @version 1.0
 * @since 19.10.2016
 */
public class GetNumbers{

    /**
     * Method calls method, which get random numbers and return them
     * @param size numbers of responses
     */
    public int[] getResponse(int size) {
        int[] getResponse = new int[size];
        for (int i = 0; i < getResponse.length; i++) {
            getResponse[i] = rnd(10, 500);
        }
        return getResponse;
    }

    /**
     * Method get max value of responses
     * @param responses array with all responses
     */
    public int maxPingOFServers(int[] responses) {
        int maxValue = 0;
        for (int response : responses) {
            if (response >= maxValue) {
                maxValue = response;
            }
        }
        return maxValue;
    }

    /**
     * Method create random numbers within "min" and "max".
     * @param min min possible value of responses
     * @param max max possible value of responses
     */
    private int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }


}
