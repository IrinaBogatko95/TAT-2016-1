package instructions;

import java.util.ArrayList;

/**
 * Class validate entered commands
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public class ValidatorCommands {

    /**
     * Checks commands to the valid values
     *
     * @param commands list of commands
     * @throws Exception if invalid commands
     */
    public ArrayList<Command> validate(ArrayList<Command> commands) throws Exception {
        for (Command requestedCommand : commands) {
            if (requestedCommand.getArgument() == null) {
                throw new Exception("Illegal arg!");
            }
            if (requestedCommand.getNameCommand() == null) {
                throw new Exception("Illegal name com!");
            }
        }
        return commands;
    }
}
