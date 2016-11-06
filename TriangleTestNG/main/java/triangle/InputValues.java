package triangle;

import java.util.Scanner;

/**
 * Entering sides of the triangle from the keyboard
 * @author Irina Bogatko
 * @version 2.1
 * @since 04-10-2016
 */
public class InputValues {

    /**
     * Expects the entering of sides of the triangle
     * @return entered sides of the triangle
     */
    public Triangle valuesEntering() throws Exception {
        double firstSide = 0;
        double secondSide = 0;
        double thirdSide = 0;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter first side of triangle: ");
            firstSide = sc.nextDouble();
            System.out.println("Enter second side of triangle: ");
            secondSide = sc.nextDouble();
            System.out.println("Enter third side of triangle: ");
            thirdSide = sc.nextDouble();
        } catch (Exception ex) {
            System.out.println("You entered not a number!");
        }
        return new Triangle(firstSide, secondSide, thirdSide);
    }
}

