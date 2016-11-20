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
            JsonArray commandJsonArray = json.getAsJsonArray("commands");
            for (JsonElement command : commandJsonArray) {
                String name =
                        command.getAsJsonObject().get("name") == null ? null :
                                command.getAsJsonObject().get("name").getAsString();
                String url =
                        command.getAsJsonObject().get("url") == null ? null :
                                command.getAsJsonObject().get("url").getAsString();
                String argument =
                        command.getAsJsonObject().get("argument") == null ? null :
                                command.getAsJsonObject().get("argument").getAsString();
                if (name.equals("open")) {
                    commands.add(new Command(name, url, argument));
                } else {
                    commands.add(new Command(name, null, argument));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return commands;
    }
}
