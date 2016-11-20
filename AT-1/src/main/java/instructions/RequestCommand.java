package instructions;

/**
 * Enum which contains all commands
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public enum RequestCommand {

    OPEN("open"),
    CHECK_LINK_PRESENT_BY_HREF("checkLinkPresentByHref"),
    CHECK_LINK_PRESENT_BY_NAME("checkLinkPresentByName"),
    CHECK_PAGE_TITLE("checkPageTitle"),
    CHECK_PAGE_CONTAINS("checkPageContains");

    private String commandValue;

    /**
     * Create new enum command
     *
     * @param command comparison value
     */
    private RequestCommand(String command) {
        commandValue = command;
    }

    /**
     * Method, which get selected command
     *
     * @param selectedCommand command to enum
     * @return entered command
     */
    static public RequestCommand getCommand(String selectedCommand) {
        for (RequestCommand requestCommand : RequestCommand.values()) {
            if (requestCommand.getTypeValue().equals(selectedCommand)) {
                return requestCommand;
            }
        }
        throw new RuntimeException("Unknown command!");
    }

    /**
     * @return requested command
     */
    public String getTypeValue() {
        return commandValue;
    }
}