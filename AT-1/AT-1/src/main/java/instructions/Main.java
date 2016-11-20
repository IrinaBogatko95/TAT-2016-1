package instructions;

import java.util.ArrayList;

/**
 * Calls methods which get commands from cmd or file, execute them and write log-file
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public class Main {

    /**
     * Input point in the program
     *
     * @param args arguments of the command line
     * @throws Exception if errors in program
     */
    public static void main(String[] args) throws Exception {
        try {
            Selector selector = new Selector();
            ArrayList<Command> commands = selector.chooser(args);
            ExecuteCommand executeCommand = new ExecuteCommand();
            ArrayList<Result> results = executeCommand.doCommands(commands);
            WriteLog writeLog = new WriteLog();
            writeLog.writeResultsToLog(results);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}