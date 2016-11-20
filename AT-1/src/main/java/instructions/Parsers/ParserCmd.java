package instructions.Parsers;

import instructions.Command;

import java.util.ArrayList;

/**
 * Contains method, which parse commands from command line
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public class ParserCmd {
    ArrayList<Command> commands = new ArrayList<Command>();

    /**
     * Parsing commands from command line
     *
     * @return list of parsed commands with arguments
     * @throws Exception if problem to create new command
     */
    public ArrayList<Command> parseCommands(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("--command")) {
                if (args[i + 1].startsWith("open")) {
                    commands.add(new Command(args[i + 1], args[i + 2], args[i + 3]));
                } else {
                    commands.add(new Command(args[i + 1], null, args[i + 2]));
                }
            }
        }
        return commands;
    }
}


