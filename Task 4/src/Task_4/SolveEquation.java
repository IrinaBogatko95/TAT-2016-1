package Task_4;

/**
 * Counting discriminant and getting roots of equation
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 04-10-2016
 */
public class SolveEquation {
    private double x1;
    private double x2;

    /**
     * Finding the roots of the equation
     *
     * @param equation equation with entered coefficients
     */
    public void getRoots(Equation equation) {
        System.out.println("Your equation: (" + equation.getFirstCoefficient() + ") * x ^ 2"
                + " + (" + equation.getSecondCoefficient() + ") * x "
                + " + (" + equation.getThirdCoefficient() + ")");
        System.out.println("");
        double discriminant = countDiscriminant(equation);

        if (isZero(discriminant)) {
            x1 = roundResult((-equation.getSecondCoefficient() / (2 * equation.getFirstCoefficient())));

            System.out.println("D = 0, the equation have one root");
            System.out.println("");
            System.out.println("x = " + x1);
        } else if (discriminant < 0) {

            System.out.println("D < 0, the equation does not have roots");

        } else if (discriminant > 0) {
            x1 = roundResult((-equation.getSecondCoefficient() + Math.sqrt(discriminant)) /
                    (2 * equation.getFirstCoefficient()) * 1000);

            x2 = roundResult((-equation.getSecondCoefficient() - Math.sqrt(discriminant)) /
                    (2 * equation.getFirstCoefficient()) * 1000);

            System.out.println("D > 0, the equation have two roots:");
            System.out.println("");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
    }


    /**
     * Method return true if "a" equal to zero
     *
     * @param a number to check the vanishing
     * @return true if number id zero
     */
    private static boolean isZero(double a) {
        return Double.isNaN(0 / a);
    }

    /**
     * Method round result of equation
     *
     * @param result result of equation
     * @return rounded result
     */
    private static double roundResult(double result) {
        int i = (int) Math.round(result);
        result = (double) i / 1000;
        return result;
    }

    /**
     * Method count discriminant of equation
     *
     * @param equation equation with entered coefficients
     * @return counted discriminant
     */
    private static double countDiscriminant(Equation equation) {
        return Math.pow(equation.getSecondCoefficient(), 2) - 4 * equation.getFirstCoefficient()
                * equation.getThirdCoefficient();
    }
}
