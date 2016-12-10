package Task_2;

/**
 * Class has a method that displays name which input from command line
 * @author Irina Bogatko
 * @version 1.1
 * @since 02.10.2016
 */
public class CommandLineName {

    /**
     * Input point in the program
     * @param args arguments of the cmd
     */
    public static void main(String[] args) {
        for (String result : args) {
            System.out.println("Hello, " + result);
        }
    }
}
