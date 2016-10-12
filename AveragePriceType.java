package Task_8;

import java.util.ArrayList;

/**
 * Class counting average price of the type of products and output on the screen
 *
 * @author Bogatko Irina
 * @version 1.0
 * @since 12.10.2016
 */
public class AveragePriceType extends Commands {
    private final String CONST = "average price ";
    private String type;

    /**
     * Count values according to command
     *
     * @param parameters entered information about product
     */
    public void computing(ArrayList<Goods> parameters) {
        double quantity = 0;
        double average;
        double typeQuantity = 0;
        double calc;
        double calcPrice = 0;
        for (Goods count : parameters) {
            if (count.getType().equals(type)) {
                quantity += count.getQuantity();
                typeQuantity += quantity;
                calc = count.getPrice();
                calcPrice += calc;
            }
        }
        average = calcPrice / typeQuantity;
        print(average);
    }

    /**
     * Check the correctness of the entered command
     */
    public boolean checkToInput(String command) {

        if (command.startsWith(CONST)) {
            this.type = command.substring(CONST.length());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Output the result on the screen
     *
     * @param calc result of counting
     */
    public void print(double calc) {
        System.out.println("Average price of " + this.type + " product: " + calc);
    }
}