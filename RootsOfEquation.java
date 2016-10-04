package Task_4;
import java.util.Scanner;
/**
 * Class has methods which output roots of the equation ax2 + bx + c = 0; a, b, c input from the keyboard
 * @author Irina Bogatko
 * @version 1.0
 * @since 04-10-2016
 */
public class RootsOfEquation {
    /**
     * Output roots of the quadratic equation ax2 + bx + c = 0
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        double[] coeff = new double[3];
        entry(coeff);
        System.out.println("Your equation: (" + coeff[0] + ") * x ^ 2" + " + (" + coeff[1] + ") * x " + " + (" + coeff[2] + ")");
        roots(coeff);
    }
    /**
     * Counting discriminant and finding the roots of the equation
     * @param coeff array with input values(a, b, c)
     */
    public static void roots(double[] coeff) {
        //discriminant calculation
        double x1;
        double x2;
        double d = Math.pow(coeff[1], 2) - 4  * coeff[0] * coeff[2];
        if ( d < 0) {
            System.out.println("D < 0, the equation does not have roots");
        } else if (zero(d)) {
            x1 = (- coeff[1] /(2 * coeff[0]));
            System.out.println("D = 0, the equation have one root");
            System.out.println("x = " + x1);
        } else if( d > 0 ) {
            x1 = (-coeff[1] + Math.sqrt(d)) / (2 * coeff[0]);
            x2 = (-coeff[1] - Math.sqrt(d)) / (2 * coeff[0]);
            System.out.println("D > 0, the equation have two roots:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
    }
    /**
     * Method return true if "a" equal to zero
     * @param a number to check the vanishing
     */
    private static boolean zero (double a) {
        if(Double.isNaN(1. / a)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * expects the entering of values from the user, returns this values
     * @param coeff array of input values
     */
    public static double[] entry(double[] coeff) {
        Scanner sc = new Scanner(System.in);
        try {
            for(int i=0; i < coeff.length; i++) {
                System.out.println("Enter " + (i + 1) + " coeff:");
                coeff[i] = sc.nextDouble();
            }
            if(coeff[0]==0) {
                System.out.println("The coefficient at the first term can not equal zero. Try again.");
            }
        } catch(Exception ex) {
            System.out.println("You entered not a number. Please, enter number");
        }
        return coeff;
    }
}
