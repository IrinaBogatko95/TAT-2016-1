package instructions.Parsers;

import instructions.Command;
import instructions.FileReader;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

/**
 * Contains method, which parse strings from xml-file
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public class ParserXml {
    private final String PATH = ".\\CommandsXml.xml";
    private final String TAG = "instruction";
    ArrayList<Command> commands = new ArrayList<Command>();

    /**
     * Parsing strings from xml-file
     *
     * @return list of parsed commands with arguments
     * @throws Exception if problem to create new command
     */
    public ArrayList<Command> parseCommands() throws Exception {
        FileReader fileReader = new FileReader();
        NodeList nodeList = fileReader.fileReaderFromXml(PATH, TAG);
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            if (map.getNamedItem("name").getNodeValue().equals("open")) {
                commands.add(new Command(String.valueOf(map.getNamedItem("name").getNodeValue()),
                        String.valueOf(map.getNamedItem("url").getNodeValue()),
                        String.valueOf(map.getNamedItem("arg").getNodeValue())));
            } else {
                commands.add(new Command(String.valueOf(map.getNamedItem("name").getNodeValue()),
                        null,
                        String.valueOf(map.getNamedItem("arg").getNodeValue())));
            }
        }
        return commands;
    }
}
