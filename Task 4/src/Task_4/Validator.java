package Task_4;

/**
 * Validate coefficients of the equation
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 04-10-2016
 */
public class Validator {

    /**
     * Validate entered coefficients
     *
     * @param firstCoeff  first coefficient of equation
     * @param secondCoeff second coefficient of equation
     * @param thirdCoeff  first coefficient of equation
     * @throws Exception if invalid coefficient
     */
    public void validateCoefficients(double firstCoeff, double secondCoeff, double thirdCoeff) throws Exception {
        if (isZero(firstCoeff)) {
            throw new Exception("Invalid coefficient!");
        } else if (isInfinite(firstCoeff) || isInfinite(secondCoeff) || isInfinite(thirdCoeff)) {
            throw new Exception("Invalid coefficient!");
        }
    }

    /**
     * Method return true if "a" equal to zero
     *
     * @param a number to check the vanishing
     * @return true if number is zero
     */
    private static boolean isZero(double a) {
        return Double.isNaN(0 / a);
    }

    /**
     * Method return true if "a" equal to infinite
     *
     * @param a number to check the vanishing
     * @return true if number is infinite
     */
    private static boolean isInfinite(double a) {
        return Double.isInfinite(a);
    }
}
