package day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day5 {

    public static void day5() {
        System.out.println("========== Running code for Day 5 ============");
        int highestSeatId = 0;
        int mySeat = 0;

        List<String> dataList = getData();
        Set<Integer> activeSeats = new HashSet<>();

        for (String data : dataList) {
            int id = getId(data);
            if (id > highestSeatId) {
                highestSeatId = id;
            }
            activeSeats.add(id);
        }

        for (int row = 1; row < 127;row++) {
            for (int column = 0; column < 8; column++) {
                int id = row * 8 + column;
                if (!activeSeats.contains(id) && activeSeats.contains(id+1) && activeSeats.contains(id-1)) {
                    mySeat = id;
                }
            }
        }

        System.out.println("Highest seat ID :" + highestSeatId);
        System.out.println("My seat: " + mySeat);
    }

    private static int getId(String data) {

        int row = getId(data.substring(0,7), "B");
        int column = getId(data.substring(7,10), "R");
        return row * 8 + column;
    }

    public static int getId(String data, String characterForHigher) {

        int row = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == characterForHigher.charAt(0)) {
                row += Math.pow(2, data.length()-i-1);
            }
        }
        return row;
    }

    private static List<String> getData() {
        List<String> data = new ArrayList<>();
        try {
            File file = new File("src/main/java/day5/input.txt");
            FileReader fr = new FileReader(file);
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
