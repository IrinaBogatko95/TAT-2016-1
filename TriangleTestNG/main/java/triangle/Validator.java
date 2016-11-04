package triangle;

/**
 * Class check triangle for validity
 * @author Irina Bogatko
 * @version 2.0
 * @since 04-10-2016
 */
public class Validator {

    /**
     * Check the existence of the triangle
     * @param triangle triangle with entered sides
     * @return Checked sides of the triangle
     */
    public Triangle checkExistenceTriangle(Triangle triangle) throws Exception {
        if (zero(triangle.getA()) || zero(triangle.getB()) || zero(triangle.getC())) {
            throw new Exception("Triangle doesn't exist!");
        } else if (triangle.getA() < 0 || triangle.getB() < 0 || triangle.getC() < 0) {
            throw new Exception("Side of the triangle cannot be less than zero!");
        } else if (triangle.getA() + triangle.getB() < triangle.getC() ||
                triangle.getA() + triangle.getC() < triangle.getB() ||
                triangle.getB() + triangle.getC() < triangle.getA()) {
            throw new Exception("Triangle with such sides does not exist!");
        }
        checkValues(triangle);
        return triangle;
    }

    /**
     * Check entered sides for the validity
     * @param triangle triangle with entered values
     * @return Checked sides of the triangle
     */
    public Triangle checkValues(Triangle triangle) {
        if (infinity(triangle.getA()) || infinity(triangle.getB()) ||
                infinity(triangle.getC())) {
            throw new ArithmeticException("Invalid side! ");
        }
        return triangle;
    }

    /**
     * The null check
     * @param a number to check the vanishing
     * @return true if "a" equal to zero
     */
    private boolean zero(double a) {
        return Double.isNaN(0 / a);
    }

    /**
     * The infinity check
     * @param a number to check for equality infinity
     * @return true if "a" equal to infinity
     */
    private boolean infinity(double a) {
        return Double.isInfinite(a);
    }
}
