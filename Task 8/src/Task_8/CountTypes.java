package Task_8;

import java.util.ArrayList;

/**
 * Class counting types of the products and output on the screen
 *
 * @author Bogatko Irina
 * @version 1.0
 * @since 12.10.2016
 */
public class CountTypes extends Commands {
    public final String CONST = "count types";

    /**
     * Count values according to command
     *
     * @param parameters entered information about product
     */
    public void computing(ArrayList<Goods> parameters) {
        ArrayList<String> type = new ArrayList<>();

        for (Goods count : parameters) {
            type.add(count.getType());
        }
        int calc = 0;
        for (int i = 0; i < type.size(); i++) {
            for (int j = i + 1; j < type.size(); j++) {
                if (type.get(i).equals(type.get(j))) {
                    calc++;
                }
            }
        }
        print(type.size() - calc);
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

        System.out.println("The number of types of goods: " + calc);

    }


}


