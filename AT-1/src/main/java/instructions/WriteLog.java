package instructions;

import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Write results of executing commands to log-file
 *
 * @author Irina Bogatko
 * @version 1.0
 * @since 18.11.2016
 */
public class WriteLog {
    private double totalTime = 0;
    private int failedTests = 0;
    private int passedTests = 0;

    /**
     * Get results of executing commands and write them  to log-file
     *
     * @param results list of results of executing commands
     * @throws Exception if problems to write result to log-file
     */
    public void writeResultsToLog(ArrayList<Result> results) throws Exception {
        FileWriter writer = new FileWriter(".\\Result.txt", false);
        for (Result currentResult : results) {
            String testResult = currentResult.getResult();
            writer.write(testResult + " " + currentResult.getInstruction() + " " + currentResult.getExecuteTime());
            writer.write(System.lineSeparator());
            totalTime += currentResult.getExecuteTime();
            if (testResult.equals("+")) {
                passedTests++;
            }
            if (testResult.equals("!")) {
                failedTests++;
            }
        }
        double averageTime = totalTime / results.size() * 1000;
        int i = (int) Math.round(averageTime);
        averageTime = (double) i / 1000;
        writer.write("Total tests: " + results.size());
        writer.write(System.lineSeparator());
        writer.write("Passed/Failed: " + passedTests + "/" + failedTests);
        writer.write(System.lineSeparator());
        writer.write("Total time: " + totalTime);
        writer.write(System.lineSeparator());
        writer.write("Average time: " + averageTime);
        writer.flush();
    }
}
