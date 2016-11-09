package triangle;

/**
 * Call methods, which expects input sides of triangle, check them for validity
 * and output on the screen whether the  triangle equilateral, isosceles or the usual
 * @author Irina Bogatko
 * @version 2.1
 * @since 04-10-2016
 */
public class Main {

    /**
     * Entering point in the program
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception {
        try {
            InputValues inputValues = new InputValues();
            Triangle triangle = inputValues.valuesEntering();
            triangle.kindOfTriangle(triangle);
            System.out.println("This triangle is " + triangle.getType() + "!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
