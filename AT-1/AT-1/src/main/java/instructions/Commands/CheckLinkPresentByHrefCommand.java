package instructions.Commands;

import instructions.Command;
import instructions.Result;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class execute command "checkLinkPresentByHref"
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public class CheckLinkPresentByHrefCommand extends AllCommand {

    /**
     * Checks href of link of page
     *
     * @param webDriver webDriver
     * @param command   entered command "checkLinkPresentByHref"
     * @return class Result, which consist of result of command and execute time
     * @throws Exception if problem to execute command
     */
    public Result doCommand(WebDriver webDriver, Command command) throws Exception {
        String result;
        long startTime = System.currentTimeMillis();
        try {
            webDriver.findElement(By.xpath("//a[@href='" + command.getArgument() + "']"));
            result = "+";
        } catch (Exception ex) {
            result = "!";
        }
        String instruction = "[" + command.getNameCommand() + " " + "\"" + command.getArgument() + "\"" + "]";
        long endTime = System.currentTimeMillis();
        double executeTime = (double) (endTime - startTime) / 1000;
        return new Result(result, executeTime, instruction);
    }
}
