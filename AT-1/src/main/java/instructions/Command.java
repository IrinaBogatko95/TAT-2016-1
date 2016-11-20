package instructions;

/**
 * Class contains one command
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public class Command {
    private String nameCommand;
    private String url;
    private String argument;

    /**
     * Constructor, which create new command
     *
     * @param nameCommand name of command
     * @param url         url
     * @param argument    argument of command
     */
    public Command(String nameCommand, String url, String argument) {
        this.nameCommand = nameCommand;
        this.url = url;
        this.argument = argument;
    }

    /**
     * @return name of command
     */
    public String getNameCommand() {
        return nameCommand;
    }

    /**
     * @return argument of command
     */
    public String getArgument() {
        return argument;
    }

    /**
     * @return url of command
     */
    public String getUrl() {
        return url;
    }
}
