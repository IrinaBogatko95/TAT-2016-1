package Task_3;

/**
 * Validate numbers, which will be calculate
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 02.10.2016
 */
public class Validator {

    /**
     * Validate arguments from cmd
     *
     * @param args arguments from command line
     * @throws Exception if problem with parsing arguments
     */
    public void validateArguments(String[] args) throws Exception {
        if (args.length == 0) {
            throw new Exception("Not have numbers!");
        }
        if (args.length > 2) {
            throw new Exception("More than two numbers!");
        }
        if (args.length < 2) {
            throw new Exception("Less than two numbers!");
        }
    }

    /**
     * Validate quotient of two numbers
     *
     * @param quotient result of quotient
     * @throws Exception if invalid quotient
     */
    public void validateQuotient(double quotient) throws Exception {
        if (Double.isInfinite(quotient) || Double.isNaN(quotient)) {
            throw new Exception("Invalid quotient!");
        }
    }
}

