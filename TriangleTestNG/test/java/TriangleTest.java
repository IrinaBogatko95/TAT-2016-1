import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import triangle.Triangle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import static org.testng.Assert.assertEquals;

public class TriangleTest {
    public static final String PATH = ".\\PositiveDataTriangle.xml";
    public static final String POSITIVE = "positive";
    public static final String EXPECTED = "expected";
    public static final String SIDE_A = "side_a";
    public static final String SIDE_B = "side_b";
    public static final String SIDE_C = "side_c";

    @DataProvider(name = "Detect triangle provider")
    public Object[][] positiveKindTriangle() throws Exception {
        File inputFile = new File(PATH);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList nodeList = document.getElementsByTagName(POSITIVE);
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

    @Test(dataProvider = "Detect triangle provider")
    public void positiveTestKindOfTriangle(String expected, double a, double b, double c) throws Exception {
        Triangle triangle = new Triangle(a, b, c);
        triangle.kindOfTriangle(triangle);
        assertEquals(triangle.getType(), expected);
    }

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
