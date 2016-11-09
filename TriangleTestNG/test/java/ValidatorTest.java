import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;
import triangle.Validator;

public class ValidatorTest {

    @DataProvider(name = "Negative check triangle provider")
    public Object[][] negativeCheckExistenceTriangle() {
        return new Object[][]{
                {0, 0, 0},
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0},
                {100, 200, 1},
                {1, 100, 200},
                {100, 1, 200},
                {-4, 5, 6},
                {4, -5, 6},
                {4, 5, -6},
                {-4, -3, -5},
                {1 / 2, 1 / 5, 1 / 66},
                {-1 / 2, -1 / 5, -1 / 66},
                {00000100, 00000011, 00000101},
                {4e10, 3e10, 5e10},
                {null, null, null},
                {3, null, null},
                {null, 3, null},
                {null, null, 3},
                {3, 2, null},
                {null, 3, 2},
                {2, null, 3},
                {Double.NEGATIVE_INFINITY, 4, 3},
                {Double.POSITIVE_INFINITY, 5, 6},
                {Double.NaN, 3, 10},
                {20, Double.NEGATIVE_INFINITY, 3},
                {7, Double.POSITIVE_INFINITY, 6},
                {14, Double.NaN, 10},
                {12, 4, Double.NEGATIVE_INFINITY},
                {43, 5, Double.POSITIVE_INFINITY},
                {2, 3, Double.NaN},
                {Double.MIN_VALUE, 9, 10},
                {20, 10, Double.MIN_VALUE},
                {7, Double.MIN_VALUE, 6},
                {Double.MAX_VALUE, 9, 10},
                {20, 10, Double.MAX_VALUE},
                {7, Double.MIN_VALUE, 6},
                {7, Double.MIN_VALUE, Double.MIN_VALUE},
                {Double.MIN_VALUE, 7, Double.MIN_VALUE},
                {Double.MIN_VALUE, Double.MIN_VALUE, 7},
        };
    }

    @Test(dataProvider = "Negative check triangle provider", expectedExceptions = Exception.class)
    public void negativeTestCheckExistenceTriangle(double a, double b, double c) throws Exception {
        Validator validator = new Validator();
        Triangle triangle = new Triangle(a, b, c);
        validator.checkExistenceTriangle(triangle);
    }
}
