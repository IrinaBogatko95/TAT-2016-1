package instructions.Commands;

import instructions.Command;
import instructions.Result;
import org.openqa.selenium.WebDriver;

/**
 * Class execute command "checkPageTitle"
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public class CheckPageTitleCommand extends AllCommand {

    /**
     * Checks title of page
     *
     * @param webDriver webDriver
     * @param command   entered command "checkPageTitle"
     * @return class Result, which consist result of exe command and execute time
     * @throws Exception if problem with execute command
     */
    public Result doCommand(WebDriver webDriver, Command command) throws Exception {
        String result;
        long startTime = System.currentTimeMillis();
        if (webDriver.getTitle().equals(command.getArgument())) {
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
