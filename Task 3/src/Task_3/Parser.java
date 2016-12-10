package Task_3;

/**
 * Parse string from cmd
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 02.10.2016
 */
public class Parser {

    /**
     * Parse string from cmd and return numbers
     *
     * @param args arguments of command line
     * @return array with numbers, which will be calculate
     * @throws Exception if problem with parsing arguments
     */
    public double[] parseArguments(String[] args) throws Exception {
        Validator validator = new Validator();
        validator.validateArguments(args);
        double[] numbers = new double[2];
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        numbers[0] = x;
        numbers[1] = y;
        System.out.println("You entered :" + " " + numbers[0] + ", " + numbers[1]);
        System.out.println(" ");
        return numbers;
    }
}
