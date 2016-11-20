package instructions.Commands;

import instructions.Command;
import instructions.Result;
import org.openqa.selenium.WebDriver;

/**
 * Class execute command "open"
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public class OpenCommand extends AllCommand {

    /**
     * Checks if page open some url
     *
     * @param webDriver webDriver
     * @param command   entered command "open"
     * @return class Result, which consist result of exe command and execute time
     */
    public Result doCommand(WebDriver webDriver, Command command) {
        String result;
        long startTime = System.currentTimeMillis();
        int timeGiven = Integer.parseInt(command.getArgument());
        try {
            webDriver.get(command.getUrl());
            result = "+";
        } catch (Exception ex) {
            result = "!";
        }
        String instruction = "[" + command.getNameCommand() + " " + "\"" + command.getUrl() + "\""
                + " " + "\"" + command.getArgument() + "\"" + "]";
        long endTime = System.currentTimeMillis();
        double executeTime = (double) (endTime - startTime) / 1000;
        if (executeTime > timeGiven) {
            result = "!";
        }
        return new Result(result, executeTime, instruction);
    }
}
