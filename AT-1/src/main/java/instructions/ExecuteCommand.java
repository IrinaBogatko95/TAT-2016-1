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

    /**
     * Find some commands and execute them
     *
     * @param commands list of entered commands
     * @return list of result of execute commands
     * @throws Exception if problems to do commands
     */
    public ArrayList<Result> doCommands(ArrayList<Command> commands) throws Exception {
        System.setProperty("webdriver.firefox.driver", "C:\\Users\\irina\\IdeaProjects\\AT-1\\geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        ArrayList<Result> results = new ArrayList<Result>();
        for (Command selectedCommand : commands) {
            RequestCommand requestCommand = RequestCommand.getCommand(selectedCommand.getNameCommand());
            switch (requestCommand) {
                case OPEN:
                    OpenCommand openCommand = new OpenCommand();
                    results.add(openCommand.doCommand(webDriver, selectedCommand));
                    break;
                case CHECK_LINK_PRESENT_BY_HREF:
                    CheckLinkPresentByHrefCommand byHrefCommand = new CheckLinkPresentByHrefCommand();
                    results.add(byHrefCommand.doCommand(webDriver, selectedCommand));
                    break;
                case CHECK_LINK_PRESENT_BY_NAME:
                    CheckLinkPresentByNameCommand byNameCommand = new CheckLinkPresentByNameCommand();
                    results.add(byNameCommand.doCommand(webDriver, selectedCommand));
                    break;
                case CHECK_PAGE_TITLE:
                    CheckPageTitleCommand pageTitleCommand = new CheckPageTitleCommand();
                    results.add(pageTitleCommand.doCommand(webDriver, selectedCommand));
                    break;
                case CHECK_PAGE_CONTAINS:
                    CheckPageContainsCommand pageContainsCommand = new CheckPageContainsCommand();
                    results.add(pageContainsCommand.doCommand(webDriver, selectedCommand));
                    break;
                default: throw new Exception("Unknown command!");
            }
        }
        return results;
    }
}
