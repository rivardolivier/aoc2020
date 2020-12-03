package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public static void day3() {

        System.out.println("========== Running code for Day 3 ============");


        long numberOfTrees11 = getNumberOfTrees(1, 1);
        long numberOfTrees31 = getNumberOfTrees(3, 1);
        long numberOfTrees51 = getNumberOfTrees(5, 1);
        long numberOfTrees71 = getNumberOfTrees(7, 1);
        long numberOfTrees12 = getNumberOfTrees(1, 2);

        long part2 = numberOfTrees11 * numberOfTrees31 * numberOfTrees51 * numberOfTrees71 * numberOfTrees12;
        System.out.println("Number of trees part 1:" + numberOfTrees31);
        System.out.println("Multiplication of number of trees part 2:" + part2);
    }

    private static int getNumberOfTrees(Integer movex, Integer movey) {
        Map map = new Map();
        map.setMapData(getMapData());
        map.setPositionX(0);
        map.setPositionY(0);
        int numberOfTrees = 0;
        Boolean lastValue = false;
        while (lastValue != null) {

            lastValue = map.move(movex, movey);
            if (lastValue != null && lastValue) {
                numberOfTrees++;
            }
        }
        return numberOfTrees;
    }

    private static List<String> getMapData() {
        List<String> mapData = new ArrayList<>();
        try
        {
            File file=new File("src/main/java/day3/input.txt");
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String line;

            while((line=br.readLine())!=null)
            {
                mapData.add(line);
            }
            fr.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return mapData;
    }
}
