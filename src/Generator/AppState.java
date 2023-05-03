package Generator;

import Stations.Graph;
import Stations.SortByDistance;

import java.io.*;
import java.util.Collections;

public class AppState {
    public static void redirectConsoleToFile(String filePath, String string) {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            fw.write(string+"\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
