package Task_7;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class includes a method "main" that is the starting point in the program
 * and method "input" which take values from the keyboard
 * @author Irina Bogatko
 * @version 1.1
 * @since 09-10-2016
 */
public class Main {

    /**
     * Challenge methods, which taking values, from the keyboard and  comparing them with the rules
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        try {
            String enterString = getInput();
            ArrayList<RulesBuilder> outputRules = Builder.buildRules();
            Builder.checkToRules(outputRules, enterString);
        } catch (Exception e) {
            System.out.println("Error in program! Please, try again!");
        }
    }

    /**
     * Takes values from the keyboard
     */
    private static String getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("The program check the input string against enabled rules.");
        System.out.println("Rules: \n 1 - string doesn't contain figures; \n 2 - string contain only figures;" +
                " \n 3 - string contain more than five words; \n 4 - string contains word from vocabulary ");
        System.out.println("Please, enter string: ");
        String inputString = sc.nextLine();
        return inputString;
    }

}
