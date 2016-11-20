package instructions;

import instructions.Parsers.ParserCmd;
import instructions.Parsers.ParserJson;
import instructions.Parsers.ParserTxt;
import instructions.Parsers.ParserXml;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Selects where to read commands
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public class Selector {
    ArrayList<Command> commands;

    /**
     * Asks to enter kind of file where are commands(if args not null) and calls method which do them
     *
     * @param args arguments from cmd
     * @return list of all commands
     */
    public ArrayList<Command> chooser(String[] args) throws Exception {
        if (args.length > 0) {
            ParserCmd parserCmd = new ParserCmd();
            commands = parserCmd.parseCommands(args);
        } else {
            System.out.println("What kind of file contains commands? " + "Enter 1 - if txt, 2 - if xml, 3 - if json.");
            Scanner scanner = new Scanner(System.in);
            int selectedFile = scanner.nextInt();
            switch (selectedFile) {
                case 1: {
                    ParserTxt parserTxt = new ParserTxt();
                    commands = parserTxt.parseCommands();
                    break;
                }
                case 2: {
                    ParserXml parserXml = new ParserXml();
                    commands = parserXml.parseCommands();
                    break;
                }
                case 3: {
                    ParserJson parserJson = new ParserJson();
                    commands = parserJson.parseCommands();
                    break;
                }
                default: {
                    throw new Exception("You entered wrong number! Please, try again!");
                }
            }
        }
        return commands;
    }
}
