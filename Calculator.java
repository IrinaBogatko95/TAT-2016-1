/**
 * * Class accepts two numbers from the command line, counting sum, difference, composition and quotient
 */
public class Calculator {
    /**
     * Output on the screen sum, difference, composition and quotient of two numbers
     */
    public static void main(String[] args){
        if(args.length > 2) {
            System.out.println("You entered more than two numbers! Please, input  two numbers.");
        } else if(args.length < 2) {
            System.out.println("You entered less than two numbers! Please, input  two numbers.");
        } else {
            double x;
            x = Double.parseDouble(args[0]);
            double y;
            y = Double.parseDouble(args[1]);
            double sum;
            sum = calculateSum(x, y);
            double difference;
            difference = calculateDifference(x, y);
            double composition;
            composition = calculateComposition(x, y);
            double quotient;
            quotient = calculateQuotient(x, y);

            System.out.println("Sum = " + sum);
            System.out.println("Difference = " + difference);
            System.out.println("Composition = " + composition);

            if (y < 0.00001 && y > -0.00001) {
                System.out.println("You can not divide by zero! ");
            } else {
                System.out.println("Quotient = " + quotient);
            }
        }
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
        public static double calculateDifference(double a, double b){
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
