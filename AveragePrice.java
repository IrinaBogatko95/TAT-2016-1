package Task_8;

import java.util.ArrayList;

/**
 * Class counting average price of the products and output on the screen
 *
 * @author Bogatko Irina
 * @version 1.0
 * @since 12.10.2016
 */
public class AveragePrice extends Commands {
    public final String CONST = "average price";

    /**
     * Count values according to command
     *
     * @param parameters entered information about product
     */
    public void computing(ArrayList<Goods> parameters) {
        double calc = 0;
        double average = 0;
        double quantity = 0;
        for (Goods count : parameters) {
            calc += count.getPrice();
            quantity += count.getQuantity();
            average = calc / quantity;
        }
        print(average);
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

        System.out.println("Average price: " + calc);

    }


}
