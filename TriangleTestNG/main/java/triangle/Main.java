package triangle;

/**
 * Call methods, which expects input sides of triangle, check them for validity
 * and output on the screen whether the  triangle equilateral, isosceles or the usual
 * @author Irina Bogatko
 * @version 2.0
 * @since 04-10-2016
 */
public class Main {
    private final static int EQUILATERAL = 1;
    private final static int ISOSCELES = 2;
    private final static int ORDINARY = 3;

    /**
     * Entering point in the program
     * @param args command-line arguments
     */
    public static void main(String[] args) throws Exception {
            Validator validator = new Validator();
            InputValues inputValues = new InputValues();
            Triangle triangle = inputValues.valuesEntering();
        try {
            validator.checkExistenceTriangle(triangle);
            int result = triangle.kindOfTriangle();
            outputResults(result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Output result on the screen
     * @param result kind of the triangle
     */
    public static void outputResults(int result) {
        switch (result) {
            case EQUILATERAL:
                System.out.println("This triangle is equilateral!");
                break;
            case ISOSCELES:
                System.out.println("This triangle is isosceles!");
                break;
            case ORDINARY:
                System.out.println("This triangle is ordinary!");
                break;
        }
        System.out.println("");
        System.out.println("The program is completed, have a good day!");
    }
}
