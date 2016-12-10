package Task_3.Calculate;

/**
 * Abstract class of calculation
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 02.10.2016
 */
public abstract class Calculation {

    /**
     * Do calculation
     *
     * @throws Exception if problems with calculation
     */
    public abstract void calculate() throws Exception;

    /**
     * Print result of calculation
     */
    public abstract void printResult();
}


