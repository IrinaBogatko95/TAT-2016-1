package instructions.Commands;

import instructions.Command;
import instructions.Result;
import org.openqa.selenium.WebDriver;

/**
 * Class execute command "checkPageContains"
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public class CheckPageContainsCommand extends AllCommand {

    /**
     * Checks if page contains some text
     *
     * @param webDriver webDriver
     * @param command   entered command "checkPageContains"
     * @return class Result, which consist result of exe command and execute time
     */
    public Result doCommand(WebDriver webDriver, Command command) throws Exception {
        String result;
        long startTime = System.currentTimeMillis();
        if (webDriver.getPageSource().contains(command.getArgument())) {
            result = "+";
        } else {
            result = "!";
        }
        String instruction = "[" + command.getNameCommand() + " " + "\"" + command.getArgument() + "\"" + "]";
        long endTime = System.currentTimeMillis();
        double executeTime = (double) (endTime - startTime) / 1000;
        return new Result(result, executeTime, instruction);
    }
}
