import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Class reads values from xml-file and add them to Object
 * @author Irina Bogatko
 * @version 2.1
 * @since 04-10-2016
 */
public class TestXmlFileReader {
    public static final String PATH = ".\\DataTriangle.xml";
    public static final String EXPECTED = "expected";
    public static final String SIDE_A = "side_a";
    public static final String SIDE_B = "side_b";
    public static final String SIDE_C = "side_c";

    /**
     * Reads sides of triangle from xml-file
     * @param tagName name of tag, which reads from xml-file
     * @return object, which consist of sides of triangle
     */
    public Object[][] readSidesXmlFile(String tagName) throws Exception {
        File inputFile = new File(PATH);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList nodeList = document.getElementsByTagName(tagName);
        Object[][] result = new Object[nodeList.getLength()][];
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            result[i] = new Object[]{
                    map.getNamedItem(SIDE_A) == null ? null : getDoubleSide(map.getNamedItem(SIDE_A).getNodeValue()),
                    map.getNamedItem(SIDE_B) == null ? null : getDoubleSide(map.getNamedItem(SIDE_B).getNodeValue()),
                    map.getNamedItem(SIDE_C) == null ? null : getDoubleSide(map.getNamedItem(SIDE_C).getNodeValue()),
            };
        }
        return result;
    }

    /**
     * Reads sides of triangle and expected results from xml-file
     * @param tagName name of tag, which reads from xml-file
     * @return object, which consist of sides of triangle and expected results
     */
    public Object[][] readSidesXmlFileWithExpected(String tagName) throws Exception {
        File inputFile = new File(PATH);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList nodeList = document.getElementsByTagName(tagName);
        Object[][] result = new Object[nodeList.getLength()][];
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            result[i] = new Object[]{
                    map.getNamedItem(EXPECTED).getNodeValue(),
                    getDoubleSide(map.getNamedItem(SIDE_A).getNodeValue()),
                    getDoubleSide(map.getNamedItem(SIDE_B).getNodeValue()),
                    getDoubleSide(map.getNamedItem(SIDE_C).getNodeValue()),
            };
        }
        return result;
    }

    /**
     * Parse sides to Double
     * @param side side of triangle
     * @return parsed side
     */
    public double getDoubleSide(String side) {
        if (side.equals("Double.MAX_VALUE")) {
            return Double.MAX_VALUE;
        }
        if (side.equals("Double.MIN_VALUE")) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(side);
    }
}

