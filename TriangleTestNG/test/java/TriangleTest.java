import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

import static org.testng.Assert.assertEquals;

public class TriangleTest {

    @DataProvider(name = "Detect triangle provider")
    public Object[][] positiveKindTriangle() {
        return new Object[][]{
                {"equilateral", 100, 100, 100},
                {"equilateral", Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                {"equilateral", Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE},
                {"isosceles", 8, 8, 6},
                {"isosceles", Double.MAX_VALUE, 20, Double.MAX_VALUE},
                {"isosceles", 20, Double.MAX_VALUE, Double.MAX_VALUE},
                {"isosceles", Double.MAX_VALUE, Double.MAX_VALUE, 20},
                {"isosceles", Double.MIN_VALUE, 1, 1},
                {"isosceles", 1, Double.MIN_VALUE, 1},
                {"isosceles", 1, 1, Double.MIN_VALUE},
                {"ordinary", 15, 16, 17}
        };
    }

    @Test(dataProvider = "Detect triangle provider")
    public void positiveTestKindOfTriangle(String expected, double a, double b, double c) throws Exception {
        Triangle triangle = new Triangle(a, b, c);
        triangle.kindOfTriangle(triangle);
        assertEquals(triangle.getType(), expected);
    }
}
