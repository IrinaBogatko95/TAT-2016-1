package Task_5;
import java.util.Scanner;
/**
 * Output on the screen whether the  triangle equilateral, isosceles or the usual
 * @author Irina Bogatko
 * @version 1.0
 * @since 04-10-2016
 */
public class Triangle {

    /**
     * challenge "valuesEntering" and "kindOfTriangle" methods
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        double[] values = new double[3];
        valuesEntering(values);
        kindOfTriangle(values);
    }

    /**
     * Determining whether the triangle equilateral, isosceles or the usual.
     * @param values array with input values
     */
    public static void kindOfTriangle(double[] values) {

        //side comparison
        int compare_ab = Double.compare(values[0], values[1]);
        int compare_ac = Double.compare(values[0], values[2]);
        int compare_cb = Double.compare(values[2], values[1]);

        if(compare_ab == 0 && compare_ac == 0){
            System.out.println("This triangle is equilateral");
        } else if ((compare_ab == 0 && compare_ac != 0 ) || (compare_ac == 0 && compare_cb != 0)
                || (compare_cb == 0 && compare_ab !=0)){
            System.out.println("This triangle is isosceles");
        } else {
            System.out.println("This triangle is ordinary");
        }
    }

    /**
     * Expects the entering of values from the user, returns this values
     * and verifies the existence of a triangle
     * @param values array of input values
     */
    public static double[] valuesEntering(double[] values) {
        Scanner sc = new Scanner(System.in);
        try {
            for (int i = 0; i < values.length; i++) {
                System.out.println("Enter " + (i + 1) + " side of the triangle:");
                values[i] = sc.nextDouble();
            }

            //checks for equality sides to zero and the existence of a triangle
            if (zero(values[0]) || zero(values[1]) || zero(values[2])) {
                System.out.println("Side of the triangle cannot be equal to zero!");
                System.exit(1);
            } else if (values[0] < 0 || values[1] < 0 || values[2] < 0) {
                System.out.println("Side of the triangle cannot be less than zero!");
                System.exit(1);
            } else if (values[0] + values[1] < values[2] || values[0] + values[2] < values[1] || values[1] + values[2] < values[0]) {
                System.out.println("Triangle with such sides does not exist!");
                System.exit(1);
            }
        } catch (Exception ex) {
            System.out.println("You entered not a number. Please, enter number");
            System.exit(1);
        }
        return values;
    }

    /**
     * Method return true if "a" equal to zero
     * @param a number to check the vanishing
     */
    private static boolean zero (double a) {
        return Double.isNaN(0/a);
    }
}
