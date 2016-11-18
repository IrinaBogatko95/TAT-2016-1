import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;
import triangle.Validator;

public class ValidatorTest {
    public static final String NEGATIVE = "negative";

    @DataProvider(name = "Negative check triangle provider")
    public Object[][] negativeCheckExistenceTriangle() throws Exception {
        TestXmlFileReader testXmlFileReader = new TestXmlFileReader();
        Object[][] result = testXmlFileReader.readSidesXmlFile(NEGATIVE);
        return result;
    }

    @Test(dataProvider = "Negative check triangle provider", expectedExceptions = Exception.class)
    public void negativeTestCheckExistenceTriangle(double a, double b, double c) throws Exception {
        Validator validator = new Validator();
        Triangle triangle = new Triangle(a, b, c);
        validator.checkExistenceTriangle(triangle);
    }

}
