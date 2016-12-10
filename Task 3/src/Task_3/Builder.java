package Task_3;

import Task_3.Calculate.*;

import java.util.ArrayList;

/**
 * Class builds new calculations
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 02.10.2016
 */
public class Builder {

    /**
     * Builds new calculations
     *
     * @param numbers numbers, which will be calculate
     * @return list of calculations
     */
    public static ArrayList<Calculation> buildCalculator(double[] numbers) {
        ArrayList<Calculation> calculations = new ArrayList<>();
        calculations.add(new CalculateSum(numbers));
        calculations.add(new CalculateDifference(numbers));
        calculations.add(new CalculateComposition(numbers));
        calculations.add(new CalculateQuotient(numbers));
        return calculations;
    }

    /**
     * Do all calculations
     *
     * @param calculations list of all calculations
     * @throws Exception if problem with calculation
     */
    public static void calculateAll(ArrayList<Calculation> calculations) throws Exception {
        for (Calculation currentCalculation : calculations) {
            currentCalculation.calculate();
            currentCalculation.printResult();
        }
    }
}
