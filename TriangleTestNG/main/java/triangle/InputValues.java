package triangle;

import java.util.Scanner;

/**
 * Entering sides of the triangle from the keyboard
 * @author Irina Bogatko
 * @version 2.0
 * @since 04-10-2016
 */
public class InputValues {

    /**
     * Expects the entering of sides of the triangle
     * @return entered sides of the triangle
     */
    public Triangle valuesEntering(Triangle triangle) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            Double firstSide;
            Double secondSide;
            Double thirdSide;
            System.out.println("Enter first side of triangle: ");
            firstSide = sc.nextDouble();
            System.out.println("Enter second side of triangle: ");
            secondSide = sc.nextDouble();
            System.out.println("Enter third side of triangle: ");
            thirdSide = sc.nextDouble();
            triangle = new Triangle(firstSide, secondSide, thirdSide);
        } catch (Exception ex) {
            System.out.println("You entered not a number!");
            System.exit(1);
        }
        return triangle;
    }
}
