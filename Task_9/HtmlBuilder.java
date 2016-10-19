package Task_9;

/**
 * The class contains the constants that make up a table
 * and a method, that adds information about the directory or string in file.
 * @author Bogatko Irina
 * @version 1.0
 * @since 18.10.2016
 */
public class HtmlBuilder {
    private boolean odd = true;

    //Constants contains name of columns in table.
    private final String NAME = "ИМЯ";
    private final String TYPE = "ТИП";
    private final String DATE = "ДАТА СОЗДАНИЯ";
    private final String SIZE = "РАЗМЕР (в Kb)";

    //Constants contains colors in table.
    private final String HEADER_COLOR = "#CECFCE";
    private final String FIRST_BODY_COLOR = "#EFEFEF";
    private final String SECOND_BODY_COLOR = "#F7F7F7";
    private final String BORDER_COLOR = "#FFFFFF";

    //Constant contains header and body of html-table.
    private final String HEADER = "<!DOCTYPE html>\n"
            + "<HTML>"
            + "<HEAD>\n"
            + "<META CHARSET = \"utf-8\"/>\n"
            + "</HEAD>\n"
            + "<BODY>\n"
            + "<TABLE BORDER = \"0.5\" WIDTH = \"50%\" BORDERCOLOR =\"" + BORDER_COLOR + "\">\n"
            + "<TR BGCOLOR =\"" + HEADER_COLOR + "\" VALIGN =\"top\" HEIGHT = \"40\" >\n"
            + "<TH WIDTH = \"125PX\">" + NAME + "</TH>\n"
            + "<TH WIDTH = \"125PX\">" + TYPE + "</TH>\n"
            + "<TH WIDTH = \"125PX\">" + DATE + "</TH>\n"
            + "<TH WIDTH = \"125PX\">" + SIZE + "</TH>\n"
            + "</TR>\n";

    //Constant contains footer of html-table.
    private final String FOOTER = "</TABLE>\n" + "</BODY>\n" + "</HTML>";
    private String table = HEADER;

    /**
     * Adds information about the directory or string in table.
     * @param name name of file or directory
     * @param type is the directory or file
     * @param date creation-date of file
     * @param size size of files in directory
     */
    public void addString(String name, String type, String date, long size) {
        if (odd) {
            table += "<tr bgcolor=\"" + FIRST_BODY_COLOR + "\">\n";
            odd = false;
        } else {
            table += "<tr bgcolor=\"" + SECOND_BODY_COLOR + "\">\n";
            odd = true;
        }
        table  += "<td>" + name + "</td>\n"
                + "<td>" + type + "</td>\n"
                + "<td>" + date + "</td>\n"
                + "<td>" + size + "</td>\n"
                + "</tr>\n";
    }

    /**
     * Return table of files and directories.
     */
    public String getResult() {
        return table + FOOTER;
    }
}
