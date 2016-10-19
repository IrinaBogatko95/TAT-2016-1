package Task_10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Class has a method "main", which is starting point in the program
 * @author Bogatko Irina
 * @version 1.0
 * @since 19.10.2016
 */
public class Main {

    /**
     * Calls methods, which create html-table and add in this table information about address of server
     * and time response.
     * @param args command-line params
     */
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir"));
        ArrayList<String> server = new ArrayList<>();
        IPValidator validate = new IPValidator();
        try {
            if (args.length > 0) {
                // IP from file.
                if (args[0].startsWith("--filename=")) {
                    String path = args[0].substring("--filename=".length());
                    new File(path);
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        server.add(line);
                    }
                    validate.validateIpAddress(server);
                }
                // IP from command line.
                else {
                    for (int i = 0; i < args.length; i++) {
                        server.add(args[i]);
                    }
                    validate.validateIpAddress(server);
                }
            }
            File newFile = new File("table.html");
            HtmlBuilder html = new HtmlBuilder();
            html.createHTML(newFile, server);
        } catch (Exception e) {
            System.out.println("Error in IP!");
        }
    }
}