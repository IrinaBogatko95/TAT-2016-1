package Task_8;

import java.util.ArrayList;

/**
 * Class counting all products and output on the screen
 *
 * @author Bogatko Irina
 * @version 1.0
 * @since 12.10.2016
 */
public class CountAll extends Commands {
    public final String CONST = "count all";

    /**
     * Count values according to command
     *
     * @param parameters entered information about product
     */
    public void computing(ArrayList<Goods> parameters) {
        int calc = 0;
        for (Goods count : parameters) {
            calc += count.getQuantity();
        }
        print(calc);
    }

    /**
     * Check the correctness of the entered command
     */
    public boolean checkToInput(String param) {

        return param.equals(CONST);
    }

    /**
     * Output the result on the screen
     *
     * @param calc result of counting
     */
    public void print(double calc) {

        System.out.println("The total amount of goods: " + calc);

    }

}
