package Task_3.Calculate;

/**
 * Class contains composition of two numbers
 * @author Irina Bogatko
 * @version 1.1
 * @since 02.10.2016
 */
public class CalculateComposition extends Calculation {
    private double x;
    private double y;
    private double composition;

    /**
     * Create new CalculateComposition
     * @param numbers numbers, which will calculate
     */
    public CalculateComposition (double[] numbers) {
        this.x = numbers[0];
        this.y = numbers[1];
    }

    /**
     * Composition of two numbers
     */
    public void calculate() {
        composition = x * y;
    }

    /**
     * Print result of composition
     */
    public void printResult() {
        System.out.println("Composition = " + " " + x + " * " + y + " = " + composition);
    }
}
