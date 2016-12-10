package Task_4;

import java.util.Scanner;

/**
 * Requires input coefficients and return equation with entered coefficients
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 04-10-2016
 */
public class GetInput {

    /**
     * Expects entering coefficients of user
     *
     * @return equation with entered coefficients
     * @throws Exception if invalid coefficient
     */
    public Equation inputCoefficients() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first coefficient: ");
        double firstCoefficient = sc.nextDouble();

        System.out.println("Enter second coefficient: ");
        double secondCoefficient = sc.nextDouble();

        System.out.println("Enter third coefficient: ");
        double thirdCoefficient = sc.nextDouble();

        Validator validator = new Validator();
        validator.validateCoefficients(firstCoefficient, secondCoefficient, thirdCoefficient);

        return new Equation(firstCoefficient, secondCoefficient, thirdCoefficient);
    }
}
