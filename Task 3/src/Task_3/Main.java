package Task_3;

import Task_3.Calculate.Calculation;

import java.util.ArrayList;

/**
 * Class accepts two numbers from the command line, counting sum, difference, composition and quotient
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 02.10.2016
 */
public class Main {

    /**
     * Output on the screen sum, difference, composition and quotient of two numbers
     *
     * @param args arguments of the command line
     */
    public static void main(String[] args) {
        try {
            Parser parser = new Parser();
            double[] numbers = parser.parseArguments(args);
            ArrayList<Calculation> calculations = Builder.buildCalculator(numbers);
            Builder.calculateAll(calculations);
        } catch (Exception e) {
            System.out.println("Error in program: " + e.getMessage());
        }
    }
}
