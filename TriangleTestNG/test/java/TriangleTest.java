import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

import static org.testng.Assert.assertEquals;

public class TriangleTest {
    public static final String POSITIVE = "positive";

    @DataProvider(name = "Detect triangle provider")
    public Object[][] positiveKindTriangle() throws Exception {
        TestXmlFileReader testXmlFileReader = new TestXmlFileReader();
        Object[][] result = testXmlFileReader.readSidesXmlFileWithExpected(POSITIVE);
        return result;
    }

    @Test(dataProvider = "Detect triangle provider")
    public void positiveTestKindOfTriangle(String expected, double a, double b, double c) throws Exception {
        Triangle triangle = new Triangle(a, b, c);
        triangle.kindOfTriangle(triangle);
        assertEquals(triangle.getType(), expected);
    }
}
