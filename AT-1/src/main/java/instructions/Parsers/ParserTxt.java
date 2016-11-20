package instructions.Parsers;

import instructions.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Contains method, which parse strings from txt-file
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public class ParserTxt {
    private final String PATH = ".\\Commands.txt";
    ArrayList<Command> commands = new ArrayList<Command>();

    /**
     * Parsing strings from txt-file
     *
     * @return list of parsed commands with arguments
     * @throws Exception if problem to create new command
     */
    public ArrayList<Command> parseCommands() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(PATH));
            String line;
            while ((line = br.readLine()) != null) {
                String[] instructions = line.split("\\s+", 2);
                String[] parsedInstructions = instructions[1].split("\\s+", 2);
                if (instructions[0].equals("open")) {
                    commands.add(new Command(instructions[0],
                            parsedInstructions[0].substring(1, parsedInstructions[0].length() - 1),
                            parsedInstructions[1].substring(1, parsedInstructions[1].length() - 1)));
                } else {
                    commands.add(new Command(instructions[0], null,
                            instructions[1].substring(1, instructions[1].length() - 1)));
                }
            }
        } catch (IOException e) {
            System.out.println("Error in reading file!");
        }
        return commands;
    }
}
