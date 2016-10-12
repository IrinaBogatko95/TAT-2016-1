package Task_8;
import java.util.ArrayList;

/**
 * Class consists of a method main, which is the starting point of the program
 *
 * @author Bogatko Irina
 * @version 1.0
 * @since 12.10.2016
 */
public class Main {

    /**
     * Calls methods that read information from the keyboard and display its processed result
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        try {
            ArrayList<Goods> parameters = new ArrayList<>();

            Input input = new Input();
            parameters = input.getInput();

            Valid validator = new Valid();
            ArrayList<Commands> inputCommands = validator.commandsValidator();
            String command = validator.inputCommand();
            validator.checkCommands(parameters, inputCommands, command);
        } catch (Exception e) {
            System.out.println("Error in program! Please, try again.");
        }
    }
}
