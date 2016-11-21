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
    private final String NAME = "name";
    private final String URL = "url";
    private final String OPEN = "open";
    private final String ARGUMENT = "arg";
    ArrayList<Command> commands = new ArrayList<Command>();

    /**
     * Parsing strings from xml-file
     *
     * @return list of parsed commands with arguments
     * @throws Exception if problem to create new command
     */
    public ArrayList<Command> parseCommands() throws Exception {
        FileReaderXml fileReader = new FileReaderXml();
        NodeList nodeList = fileReader.fileReaderFromXml(PATH, TAG);
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            if (map.getNamedItem(NAME).getNodeValue().equals(OPEN)) {
                commands.add(new Command(String.valueOf(map.getNamedItem(NAME).getNodeValue()),
                        String.valueOf(map.getNamedItem(URL).getNodeValue()),
                        String.valueOf(map.getNamedItem(ARGUMENT).getNodeValue())));
            } else {
                commands.add(new Command(String.valueOf(map.getNamedItem(NAME).getNodeValue()),
                        null,
                        String.valueOf(map.getNamedItem(ARGUMENT).getNodeValue())));
            }
        }
        return commands;
    }
}
