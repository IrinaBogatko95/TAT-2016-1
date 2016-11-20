package instructions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import instructions.Commands.*;

import java.util.ArrayList;

/**
 * Class, which execute all commands
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public class ExecuteCommand {
    private final String DRIVER = "webdriver.firefox.driver";
    private final String PATH = ".\\geckodriver.exe";

    /**
     * Find some commands and execute them
     *
     * @param commands list of entered commands
     * @return list of result of execute commands
     * @throws Exception if problems to do commands
     */
    public ArrayList<Result> doCommands(ArrayList<Command> commands) throws Exception {
        System.setProperty(DRIVER, PATH);
        WebDriver webDriver = new FirefoxDriver();
        ArrayList<Result> results = new ArrayList<Result>();
        for (Command selectedCommand : commands) {
            RequestCommand requestCommand = RequestCommand.getCommand(selectedCommand.getNameCommand());
            AllCommand executeCommand;
            switch (requestCommand) {
                case OPEN:
                    executeCommand = new OpenCommand();
                    results.add(executeCommand.doCommand(webDriver, selectedCommand));
                    break;
                case CHECK_LINK_PRESENT_BY_HREF:
                    executeCommand = new CheckLinkPresentByHrefCommand();
                    results.add(executeCommand.doCommand(webDriver, selectedCommand));
                    break;
                case CHECK_LINK_PRESENT_BY_NAME:
                    executeCommand = new CheckLinkPresentByNameCommand();
                    results.add(executeCommand.doCommand(webDriver, selectedCommand));
                    break;
                case CHECK_PAGE_TITLE:
                    executeCommand = new CheckPageTitleCommand();
                    results.add(executeCommand.doCommand(webDriver, selectedCommand));
                    break;
                case CHECK_PAGE_CONTAINS:
                    executeCommand = new CheckPageContainsCommand();
                    results.add(executeCommand.doCommand(webDriver, selectedCommand));
                    break;
                default: throw new Exception("Unknown command!");
            }
        }
        return results;
    }
}
