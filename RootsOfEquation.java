import java.util.Scanner;
/**
 * Class has methods which output roots of the equation ax2 + bx + c = 0; a, b, c input from the keyboard
 */
public class RootsOfEquation {
        /**
         * Output roots of the quadratic equation ax2 + bx + c = 0
         */
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter a:");
            double a = sc.nextDouble();

            System.out.println("Enter b:");
            double b = sc.nextDouble();

            System.out.println("Enter c:");
            double c = sc.nextDouble();

            if(a < 0.00001 && a > -0.00001){
                System.out.println("The coefficient at the first term can not equal zero. Try again.");
            } else {
                System.out.println("Your equation: (" + a + ") * x ^ 2" + " + (" + b + ") * x " + " + (" + c + ")");
                roots(a, b, c);
            }
    }
    /**
     * Counting discriminant and finding the roots of the equation
     */
    public static void roots(double a, double b, double c){
            double[] mas = new double[2];
            //discriminant calculation
            double d = Math.pow(b, 2) - 4  * a * c;
            if ( d < 0){
                System.out.println("D < 0, the equation does not have roots");
            } else if (d < 0.00001 && d > -0.00001){
                mas[0] = (- b /(2 * a));
                System.out.println("D = 0, the equation have one root");
                System.out.println("x = " + mas[0]);
            } else if(d > 0) {
                mas[0] = (-b + Math.sqrt(d)) / (2 * a);
                mas[1] = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println("D > 0, the equation have two roots:");
                System.out.println("x1 = " + mas[0]);
                System.out.println("x2 = " + mas[1]);
            }
    }
}
