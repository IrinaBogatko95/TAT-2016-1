package Task_10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * The class contains the constants that make up a table
 * and a method, that adds header, body and footer of html-file into file.
 * @author Bogatko Irina
 * @version 1.0
 * @since 19.10.2016
 */
public class HtmlBuilder {

    //Constants contains name of columns in table.
    private final String SERVER = "Server";
    private final String RESPONSE = "Response, ms";

    //Constants contains colors in table.
     private final String HEADER_COLOR = "#9C9C9C";
     private final String FIRST_BODY_COLOR = "#efefef";
     private final String SECOND_BODY_COLOR = "#f7f7f7";
     private final String MAX_VALUE_COLOR = "FF0000";

    //Constant contains header of html-table.
    private final String HEADER = "<!DOCTYPE html>\n"
            + "<HTML>\n"
            + "<HEAD>\n"
            + "<META CHARSET = \"utf-8\"/>\n"
            + "<BODY>\n"
            + "</HEAD>";

    //Constant contains footer of html-table.
    private final String FOOTER =  "</TABLE>\n"
            + "</BODY>\n"
            + "</HTML>";

    //Constant contains BODY of html-table.
    private final String BODY = "<BODY>\n"
            + "<TABLE WIDTH=\"50%\" CELLPADDING=\"5\">\n"
            + "<TR YALING = \"top\" BGCOLOR =\"" + HEADER_COLOR + "\"> \n"
            + "<TH>"+ SERVER +"</TH>\n"
            + "<TH>"+ RESPONSE +"</TH>\n"
            + "</TR>\n";

    /**
     * Method adds header, body and footer of html-file into file.
     * @param nameHTML file with html-table
     * @param ipAddress arraylist with IP of servers
     */
    public void createHTML(File nameHTML, ArrayList<String> ipAddress) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nameHTML));
            // Add header, body and footer to HTML table.
            bufferedWriter.write(HEADER);
            bufferedWriter.write(BODY);
            bufferedWriter.write(addStrings(ipAddress));
            bufferedWriter.write(FOOTER);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Adds information about Server IP and time response in table.
     * @param ipAddress arraylist with IP of servers.
     */
    private String addStrings(ArrayList<String> ipAddress) {
        GetNumbers getParams = new GetNumbers();
        int[] responses = getParams.getResponse(ipAddress.size());
        int max = getParams.maxPingOFServers(responses);

        String table = "";
        int index = 1;
        int IPIndex = 0;
        for (String server : ipAddress) {
            String color;
            if (responses[IPIndex] == max) {
                color = MAX_VALUE_COLOR;
            } else if (index % 2 == 0) {
                color = SECOND_BODY_COLOR;
                index++;
            } else {
                color = FIRST_BODY_COLOR;
                index++;
            }
            table += "<TR VALIGN = \"TOP\"BGCOLOR =\"" + color + "\"> \n"
                    + "<TH>" + server + "</TH>\n"
                    + "<TH>" + responses[IPIndex] + "</TH>\n"
                    + "</TR>\n";
            IPIndex++;
        }
        return table;
    }
}