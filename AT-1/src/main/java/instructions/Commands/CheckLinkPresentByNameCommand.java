package instructions.Commands;

import instructions.Command;
import instructions.Result;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class execute command "checkLinkPresentByName"
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public class CheckLinkPresentByNameCommand extends AllCommand {

    /**
     * Checks name of link of page
     *
     * @param webDriver webDriver
     * @param command   entered command "checkLinkPresentByName"
     * @return class Result, which consist result of exe command and execute time
     * @throws Exception if problem to execute command
     */
    public Result doCommand(WebDriver webDriver, Command command) throws Exception {
        String result;
        long startTime = System.currentTimeMillis();
        try {
            webDriver.findElement(By.xpath("//a[text()='" + command.getArgument() + "']"));
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
