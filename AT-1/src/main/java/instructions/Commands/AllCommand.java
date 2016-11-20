package instructions.Commands;

import instructions.Command;
import instructions.Result;
import org.openqa.selenium.WebDriver;

/**
 * Abstract class, which execute all commands
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public abstract class AllCommand {

    /**
     * Execute entered command
     *
     * @param webDriver webDriver
     * @param command   entered command
     * @return class Result, which consist of result of command and execute time
     * @throws Exception if problem to execute command
     */
    public abstract Result doCommand(WebDriver webDriver, Command command) throws Exception;
}
