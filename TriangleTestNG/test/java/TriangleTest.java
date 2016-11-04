import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

import static org.testng.Assert.assertEquals;

public class TriangleTest {

    @DataProvider(name = "Detect triangle provider")
    public Object[][] positiveKindTriangle() {
        return new Object[][]{
                {1.0, 100, 100, 100},  //equilateral
                {2.0, 8, 8, 6},        //isosceles
                {3.0, 15, 16, 17},     //ordinary
                {1.0, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE}
        };
    }

    @DataProvider(name = "Negative detect triangle provider")
    public Object[][] negativeKindTriangle() {
        return new Object[][]{
                {0, 0, 0},
                {100, 200, 1},
                {1, 100, 200},
                {100, 1, 200},
                {-4, 5, 6},
                {4, -5, 6},
                {4, 5, -6},
                {-4, -3, -5},
                {1 / 2, 1 / 5, 1 / 66},
                {00000100, 00000011, 00000101},
                {4e10, 3e10, 5e10},
                {null, null, null},
                {null, 3, null},
                {null, null, 6},
                {Double.NEGATIVE_INFINITY, 4, 3},
                {Double.POSITIVE_INFINITY, 5, 6},
                {Double.NaN, 3, 10},
                {20, Double.NEGATIVE_INFINITY, 3},
                {7, Double.POSITIVE_INFINITY, 6},
                {14, Double.NaN, 10},
                {12, 4, Double.NEGATIVE_INFINITY},
                {43, 5, Double.POSITIVE_INFINITY},
                {2, 3, Double.NaN},
                {-4.9e-324, 9, 10},
                {20, 10, -4.9e-324},
                {7, -4.9e-324, 6},
                {1.7e+308, 9, 10},
                {20, 10, 1.7e+308},
                {7, -1.7e+308, 6},
        };
    }

    @Test(dataProvider = "Detect triangle provider")
    public void positiveTestKindOfTriangle(double expected, double a, double b, double c) throws Exception {
        Triangle triangle = new Triangle(a, b, c);
        assertEquals(triangle.kindOfTriangle(), expected);
    }

    @Test(dataProvider = "Negative detect triangle provider")
    public void negativeTestKindOfTriangle(double a, double b, double c) throws Exception {
        Triangle triangle = new Triangle(a, b, c);
        triangle.kindOfTriangle();
    }
}
