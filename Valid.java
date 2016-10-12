package Task_8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class consists of a method, which make a list of commands, input commands, check commands and exit from program
 *
 * @author Bogatko Irina
 * @version 1.0
 * @since 12.10.2016
 */
public class Valid {

    /**
     * Method, which make a list of commands
     */
    public ArrayList<Commands> commandsBuilder() {
        ArrayList<Commands> allCommands = new ArrayList<>();
        allCommands.add(new CountTypes());
        allCommands.add(new CountAll());
        allCommands.add(new AveragePrice());
        allCommands.add(new AveragePriceType());
        return allCommands;
    }

    /**
     * Method, which input commands
     */
    public String inputCommand() {
        String command;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter command: ");
            command = sc.nextLine();

            return command;
        } while (!(checkEnteredCommand(command)));
    }

    /**
     * Method, which check commands
     *
     * @param params      entered values
     * @param allCommands list of commands
     * @param command     entered command
     */
    public void checkCommands(ArrayList<Goods> params, ArrayList<Commands> allCommands, String command) {

        for (Commands check : allCommands) {
            if (check.checkToInput(command)) {
                check.computing(params);
            }
        }
    }

    /**
     * Method, which exit from program
     *
     * @param command entered command
     */
    private boolean checkEnteredCommand(String command) {
        boolean commandTrue = true;
        if (command.equals("exit")) {
            System.out.println("Exit from the command line. Completion of the program. Have a nice day!");
            commandTrue = false;
        }
        return commandTrue;
    }
}