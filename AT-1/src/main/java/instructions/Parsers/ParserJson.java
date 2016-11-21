package instructions.Parsers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import instructions.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Contains method, which parse strings from json-file
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public class ParserJson {
    ArrayList<Command> commands = new ArrayList<Command>();
    public final String PATH = ".\\CommandsJson.json";
    private final String COMMANDS = "commands";
    private final String NAME = "name";
    private final String URL = "url";
    private final String OPEN = "open";
    private final String ARGUMENT = "argument";
    JsonObject json;

    /**
     * Parsing strings from json-file
     *
     * @return list of parsed commands with arguments
     * @throws Exception if problem to create new command
     */
    public ArrayList<Command> parseCommands() throws Exception {
        try {
            json = new JsonParser().parse(new BufferedReader(new FileReader(PATH))).getAsJsonObject();
            JsonArray commandJsonArray = json.getAsJsonArray(COMMANDS);
            for (JsonElement command : commandJsonArray) {
                String nameCommand =
                        command.getAsJsonObject().get(NAME) == null ? null :
                                command.getAsJsonObject().get(NAME).getAsString();
                String url =
                        command.getAsJsonObject().get(URL) == null ? null :
                                command.getAsJsonObject().get(URL).getAsString();
                String argument =
                        command.getAsJsonObject().get(ARGUMENT) == null ? null :
                                command.getAsJsonObject().get(ARGUMENT).getAsString();
                if (nameCommand.equals(OPEN)) {
                    commands.add(new Command(nameCommand, url, argument));
                } else {
                    commands.add(new Command(nameCommand, null, argument));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return commands;
    }
}
