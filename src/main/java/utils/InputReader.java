package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    public static List<String> getLinesOfFile(File inputFile) {
        List<String> data = new ArrayList<>();
        try {
            java.io.FileReader fr = new java.io.FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {

                data.add(line);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
