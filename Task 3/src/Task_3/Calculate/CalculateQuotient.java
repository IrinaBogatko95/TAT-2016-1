package Task_3.Calculate;

import Task_3.Validator;

/**
 * Class contains quotient of two numbers
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 02.10.2016
 */
public class CalculateQuotient extends Calculation {
    private double x;
    private double y;
    private double quotient;

    /**
     * Create new CalculateQuotient
     *
     * @param numbers numbers, which will calculate
     */
    public CalculateQuotient(double[] numbers) {
        this.x = numbers[0];
        this.y = numbers[1];
    }

    /**
     * Quotient of two numbers
     */
    public void calculate() throws Exception {
        quotient = x / y * 1000;
        int i = (int) Math.round(quotient);
        quotient = (double) i / 1000;
        Validator validator = new Validator();
        validator.validateQuotient(quotient);
    }

    /**
     * Print result of quotient
     */
    public void printResult() {
        System.out.println("Quotient = " + " " + x + " / " + y + " = " + quotient);
    }
}