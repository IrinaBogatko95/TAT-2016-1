package Task_3.Calculate;

/**
 * Class contains difference of two numbers
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 02.10.2016
 */
public class CalculateDifference extends Calculation {
    private double x;
    private double y;
    private double difference;

    /**
     * Create new CalculateDifference
     *
     * @param numbers numbers, which will calculate
     */
    public CalculateDifference(double[] numbers) {
        this.x = numbers[0];
        this.y = numbers[1];
    }

    /**
     * Difference of two numbers
     */
    public void calculate() {
        difference = x - y;
    }

    /**
     * Print result of difference
     */
    public void printResult() {
        System.out.println("Difference = " + " " + x + " - " + y + " = " + difference);
    }
}