package Task_4;

/**
 * Equation with entered coefficients
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 04-10-2016
 */
public class Equation {
    private double firstCoefficient;
    private double secondCoefficient;
    private double thirdCoefficient;

    /**
     * Create new Equation
     *
     * @param firstCoefficient  first entered coefficient
     * @param secondCoefficient second entered coefficient
     * @param thirdCoefficient  third entered coefficient
     */
    public Equation(double firstCoefficient, double secondCoefficient, double thirdCoefficient) {
        this.firstCoefficient = firstCoefficient;
        this.secondCoefficient = secondCoefficient;
        this.thirdCoefficient = thirdCoefficient;
    }

    /**
     * @return first entered coefficient
     */
    public double getFirstCoefficient() {
        return firstCoefficient;
    }

    /**
     * @return second entered coefficient
     */
    public double getSecondCoefficient() {
        return secondCoefficient;
    }

    /**
     * @return third entered coefficient
     */
    public double getThirdCoefficient() {
        return thirdCoefficient;
    }
}
