package Task_9;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.text.SimpleDateFormat;

/**
 * Class consists of methods that get information about directory or file.
 * @author Bogatko Irina
 * @version 1.0
 * @since 18.10.2016
 */
public class GetItem {
    private File file;

    /**
     * Constructor, which creates new GetItem.
     * @param file received file
     */
    public GetItem(File file) {
        this.file = file;
    }

    /**
     * Get information about is the directory or file.
     */
    public String getType() {
        if (file.isFile()) {
            return "FILE";
        }
        if (file.isDirectory()) {
            return "DIR";
        }
        return "";
    }

    /**
     * Get information about the date of file creation.
     */
    public String getDate() {
        Path path = file.toPath();
        try {
            BasicFileAttributes items = Files.readAttributes(path, BasicFileAttributes.class);
            FileTime date = items.creationTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            return dateFormat.format(date.toMillis());
        } catch (IOException e) {
            return "Error retrieving the date";
        }
    }

    /**
     * Get information about size of files in directory.
     */
    public long getSize() {
        long size = 0;
        if (file.isDirectory()) {
            File[] listOfFiles = file.listFiles();
            for (File files : listOfFiles) {
                size += new GetItem(files).getSize();
            }
            return size;
        }
        return file.length();
    }
}

