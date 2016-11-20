package instructions;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Read values from xml-file
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public class FileReader {

    /**
     * Get nodeList of elements with certain tag
     * @param path path of xml-file
     * @param tag certain tag
     * @return nodelist of elements
     * @throws Exception if problem to get values
     */
    public NodeList fileReaderFromXml(String path, String tag) throws Exception {
        File inputFile = new File(path);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList nodeList = document.getElementsByTagName(tag);
        return nodeList;
    }
}
