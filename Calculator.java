
public class Calculator {
    /**
     * Output on the screen sum, difference, composition and quotient of two numbers
     */
    public static void main(String[] args){
        double x;
        double y;
        double sum;
        double difference;
        double composition;
        double quotient;
        x = Double.parseDouble(args[0]);
        y = Double.parseDouble(args[1]);

        sum = calculateSum(x, y);
        difference = calculateDifference(x, y);
        composition = calculateComposition(x, y);
        quotient = calculateQuotient(x,y);

        System.out.println("Sum = " + sum);
        System.out.println("Difference = " + difference);
        System.out.println("Composition = " + composition);
        System.out.println("Quotient = " + quotient);
}
     /**
     *  Sum of two numbers
     */
        public static double calculateSum(double a, double b){

            return a + b;
        }
     /**
     * Difference of two numbers
     */
        public static double calculateDifference(double a, double b) {

            return a - b;
        }
     /**
     * Composition of two numbers
     */
        public static double calculateComposition(double a, double b){

            return a * b;
        }
    /**
     * Quotient of two numbers
     */
        public static double calculateQuotient(double a, double b){

            return a / b;
        }
}
