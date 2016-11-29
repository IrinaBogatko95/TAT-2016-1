package Task_8;

import java.util.ArrayList;

/**
 * Class which consist of abstract fields checkToInput, computing and print
 *
 * @author Bogatko Irina
 * @version 1.0
 * @since 12.10.2016
 */
public abstract class Commands {

    /**
     * Check the correctness of the entered command
     */
    public abstract boolean checkToInput(String param);

    /**
     * Count values according to command
     *
     * @param parameters entered information about product
     */
    public abstract void computing(ArrayList<Goods> parameters);

    /**
     * Output the result on the screen
     *
     * @param calc result of counting
     */
    public abstract void print(double calc);

}
