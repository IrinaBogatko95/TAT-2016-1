import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import triangle.Triangle;
import triangle.Validator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ValidatorTest {
    public static final String PATH = "\\Maven_Triangle\\NegativeDataTriangle.xml";
    public static final String NEGATIVE = "negative";
    public static final String SIDE_A = "side_a";
    public static final String SIDE_B = "side_b";
    public static final String SIDE_C = "side_c";

    @DataProvider(name = "Negative check triangle provider")
    public Object[][] negativeCheckExistenceTriangle() throws Exception {
        File inputFile = new File(PATH);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(inputFile);
        NodeList nodeList = document.getElementsByTagName(NEGATIVE);
        Object[][] result = new Double[nodeList.getLength()][];
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            result[i] = new Double[]{
                    map.getNamedItem(SIDE_A) == null ? null : Double.parseDouble(map.getNamedItem(SIDE_A).getNodeValue()),
                    map.getNamedItem(SIDE_B) == null ? null : Double.parseDouble(map.getNamedItem(SIDE_B).getNodeValue()),
                    map.getNamedItem(SIDE_C) == null ? null : Double.parseDouble(map.getNamedItem(SIDE_C).getNodeValue()),
            };
        }
        return result;
    }

    @Test(dataProvider = "Negative check triangle provider", expectedExceptions = Exception.class)
    public void negativeTestCheckExistenceTriangle(Double a, Double b, Double c) throws Exception {
        Validator validator = new Validator();
        Triangle triangle = new Triangle(a, b, c);
        validator.checkExistenceTriangle(triangle);
    }
}
