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
        double price = 0;
        double average = 0;
        double average_type = 0;
        double quantity_all = 0;
        double quantity = 0;
        for (Goods count : parameters) {
            quantity = count.getQuantity();
            quantity_all +=quantity;
            price = count.getPrice();
            average_type = price*quantity;
            average +=average_type;
        }
        average = average/quantity_all;
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
