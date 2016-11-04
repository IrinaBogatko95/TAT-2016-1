package triangle;

/**
 * Create new Triangle and definite kind of triangle
 * @author Irina Bogatko
 * @version 2.0
 * @since 04-10-2016
 */
public class Triangle {
    //first side of the triangle
    private double a;
    //second side of the triangle
    private double b;
    //third side of the triangle
    private double c;

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
     * @return kind of the triangle
     * result = 1, triangle is equilateral
     * result = 2, triangle is isosceles
     * result = 3, triangle is usual
     */
    public int kindOfTriangle() throws Exception {
        int result;
        //side comparison
        int compare_ab = Double.compare(getA(), getB());
        int compare_ac = Double.compare(getA(), getC());
        int compare_cb = Double.compare(getC(), getB());
        //definition kind of triangle
        if (compare_ab == 0 && compare_ac == 0) {
            result = 1;
        } else if ((compare_ab == 0 && compare_ac != 0) || (compare_ac == 0 && compare_cb != 0)
                || (compare_cb == 0 && compare_ab != 0)) {
            result = 2;
        } else {
            result = 3;
        }
        return result;
    }
}
