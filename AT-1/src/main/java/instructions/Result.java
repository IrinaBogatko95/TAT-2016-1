package instructions;

/**
 * Class contains result of one command
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public class Result {
    private String result;
    private double executeTime;
    private String instruction;

    /**
     * Constructor, which create new Result
     *
     * @param result      result of executing command
     * @param executeTime execute time of command
     * @param instruction all instruction
     */
    public Result(String result, double executeTime, String instruction) {
        this.result = result;
        this.executeTime = executeTime;
        this.instruction = instruction;
    }

    /**
     * @return result of executing command
     */
    public String getResult() {
        return result;
    }

    /**
     * @return execute time of command
     */
    public double getExecuteTime() {
        return executeTime;
    }

    /**
     * @return all instruction
     */
    public String getInstruction() {
        return instruction;
    }
}
