package Task_1;

/**
 * Class have a method that displays elements of the array in reverse order
 * @author Irina Bogatko
 * @version 1.1
 * @since 02.10.2016
 */
public class CommandLineParams {

    /**
     * Output of the array elements in the reverse order
     * @param args arguments of cmd
     */
    public static void main(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println("Argument " + i + " = " + args[i]);
        }
    }
}