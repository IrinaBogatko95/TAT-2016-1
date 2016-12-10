package Task_3.Calculate;

/**
 * Class contains sum of two numbers
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 02.10.2016
 */
public class CalculateSum extends Calculation {
    private double x;
    private double y;
    private double sum;

    /**
     * Create new CalculateSum
     *
     * @param numbers numbers, which will calculate
     */
    public CalculateSum(double[] numbers) {
        this.x = numbers[0];
        this.y = numbers[1];
    }

    /**
     * Sum of two numbers
     */
    public void calculate() {
        sum = x + y;
    }

    /**
     * Print result of sum
     */
    public void printResult() {
        System.out.println("Sum = " + " " + x + " + " + y + " = " + sum);
    }
}
