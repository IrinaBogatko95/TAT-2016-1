package Task_4;

/**
 * Class has methods which get coefficients of equation ax2 + bx + c = 0 and output roots of it;
 * a, b, c input from the keyboard
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 04-10-2016
 */
public class Main {

    /**
     * Input point in the program
     *
     * @param args arguments of the command line
     */
    public static void main(String[] args) {
        try {
            GetInput getInput = new GetInput();
            Equation equation = getInput.inputCoefficients();
            SolveEquation solveEquation = new SolveEquation();
            solveEquation.getRoots(equation);
        } catch (Exception e) {
            if (e.getMessage() != null) {
                System.out.println("Error in program: " + e.getMessage());
            } else {
                System.out.println("Wrong coefficient!");
            }
        }
    }
}
