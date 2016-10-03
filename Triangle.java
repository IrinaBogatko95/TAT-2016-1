package Task_4;

import java.util.Scanner;
/**
 * Output on the screen whether the  triangle equilateral, isosceles or the usual.
 */
public class Triangle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first side of the triangle:");
        double a = sc.nextDouble();

        System.out.println("Enter the second side of the triangle:");
        double b = sc.nextDouble();

        System.out.println("Enter the third side of the triangle:");
        double c = sc.nextDouble();

        checks(a, b, c);
    }
    /**
     *  Checks for the existence of a triangle
     */
    public static void checks(double a, double b, double c){
        if (a + b < c || a + c < b || b + c < a){
            System.out.println("Triangle with such sides does not exist!");
        }
        else if(a == 0 || b == 0 || c == 0){
            System.out.println("Side of the triangle cannot be equal to zero!");
        }
        else{
            kindOfTriangle(a, b, c);
        }
    }
    /**
     * Determining whether the  triangle equilateral, isosceles or the usual.
     */
    public static void kindOfTriangle(double a, double b, double c){
        if(a == b && a == c){
            System.out.println("This triangle is equilateral");
        }
        else if((a == b && a !=c) || (a == c && a != b)|| (c == b && c != a)){
            System.out.println("This triangle is isosceles");
        }
        else{
            System.out.println("This triangle is ordinary");
        }
    }
}
