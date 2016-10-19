package Task_9;
import java.io.*;

/**
 * Class has a method "main", which is starting point in the program and method "writeToFile",
 * which write information into file.
 * @author Bogatko Irina
 * @version 1.0
 * @since 18.10.2016
 */
public class Main {

    /**
     * Calls methods, which create html-table and add in this table information about name, type,
     * date of creation and size of directories or files.
     * @param args command-line params
     */
    public static void main (String[] args) {
        File file = new File(System.getProperty("user.dir"));
        HtmlBuilder html = new HtmlBuilder();
        File[] fileList = file.listFiles();

        for (File fileWithTable : fileList) {
            GetItem inform = new GetItem(fileWithTable);
            html.addString(fileWithTable.getName(), inform.getType(), inform.getDate(), inform.getSize());
        }
        File newFile = new File("table.html");
        writeToFile(newFile, html.getResult());
    }

    /**
     * Add information about name, type, date of creation
     * and size of directories or files in the table.
     * @param file received file
     * @param information name, type, date of creation
     * and size of directories or files.
     */
    private static void writeToFile(File file, String information) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(information);
            bw.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}

