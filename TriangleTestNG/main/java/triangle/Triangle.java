package triangle;

/**
 * Create new Triangle and definite kind of triangle
 * @author Irina Bogatko
 * @version 2.1
 * @since 04-10-2016
 */
public class Triangle {
    public final String EQUILATERAL = "equilateral";
    public final String ISOSCELES = "isosceles";
    public final String ORDINARY = "ordinary";
    //first side of the triangle
    private double a;
    //second side of the triangle
    private double b;
    //third side of the triangle
    private double c;
    //type of triangle
    private String type;

    /**
     * Constructor create new Triangle
     * @param a first side of the triangle
     * @param b second side of the triangle
     * @param c third side of the triangle
     */
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * @return type of the triangle
     */
    public String getType() {
        return type;
    }

    /**
     * @return first side of the triangle
     */
    public double getA() {
        return a;
    }

    /**
     * @return second side of the triangle
     */
    public double getB() {
        return b;
    }

    /**
     * @return third side of the triangle
     */
    public double getC() {
        return c;
    }

    /**
     * Determining whether the triangle equilateral, isosceles or the usual
     * @param triangle triangle with entered sides
     */
    public void kindOfTriangle(Triangle triangle) throws Exception {
        Validator validator = new Validator();
        validator.checkExistenceTriangle(triangle);
        //side comparison
        int compare_ab = Double.compare(getA(), getB());
        int compare_ac = Double.compare(getA(), getC());
        int compare_cb = Double.compare(getC(), getB());
        //definition kind of triangle
        if (compare_ab == 0 && compare_ac == 0) {
            type = EQUILATERAL;
        } else if ((compare_ab == 0 && compare_ac != 0) || (compare_ac == 0 && compare_cb != 0)
                || (compare_cb == 0 && compare_ab != 0)) {
            type = ISOSCELES;
        } else {
            type = ORDINARY;
        }
    }
}
