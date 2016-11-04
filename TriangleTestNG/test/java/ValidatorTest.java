import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;
import triangle.Validator;

import static org.testng.Assert.assertEquals;

/**
 * Created by irina on 03.11.2016.
 */

public class ValidatorTest {

    @DataProvider(name = "Check triangle provider")
    public Object[][] positiveCheckExistenceTriangle() {
        Triangle firstTriangle = new Triangle(100, 100, 100);
        Triangle secondTriangle = new Triangle(8, 8, 6);
        Triangle thirdTriangle = new Triangle(15, 16, 17);
        return new Object[][]{
                {firstTriangle},         //equilateral
                {secondTriangle},        //isosceles
                {thirdTriangle},         //ordinary
        };
    }

    @DataProvider(name = "Negative check triangle provider")
    public Object[][] negativeCheckExistenceTriangle() {
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

    @Test(dataProvider = "Check triangle provider")
    public void positiveTestCheckExistenceTriangle(Triangle triangle) throws Exception {
        Validator validator = new Validator();
        assertEquals(validator.checkExistenceTriangle(triangle), validator.checkExistenceTriangle(triangle));
    }

    @Test(dataProvider = "Negative check triangle provider", expectedExceptions = Exception.class)
    public void negativeTestCheckExistenceTriangle(double a, double b, double c) throws Exception {
        Validator validator = new Validator();
        Triangle triangle = new Triangle(a, b, c);
        validator.checkExistenceTriangle(triangle);
    }
}
