package Movement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class, which read checkpoints from file
 * @author Irina Bogatko
 * @version 1.3
 * @since 26.10.2016
 */
public class GetCheckpoints {

    /**
     * Read checkpoints from file and add them in list
     * @param path path of reading file
     * @return list of checkpoints
     */
    public ArrayList<Checkpoint> readCheckpoints(String path) {
        ArrayList<Checkpoint> list = new ArrayList<Checkpoint>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                String[] coordinates = line.split("\\s+");
                list.add(new Checkpoint(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1])));
            }
        } catch (IOException e) {
            System.out.println("Error in reading file!");
        }
        return list;
    }
}