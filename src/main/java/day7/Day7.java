package day7;

import utils.InputReader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day7 {

    public static void day7() {
        System.out.println("========== Running code for Day 7 ============");

        File inputFile = new File("src/main/java/day7/input.txt");


        System.out.println("Part 1 - Number of bags with shiny gold: " + part1(inputFile));
        System.out.println("Part 2 - Number of bags in shiny gold bag:" + part2(inputFile));
    }

    public static int part1(File inputFile) {
        int numberOfBags = 0;
        HashMap<String, List<Bag>> bags = getData(inputFile);

        for (String key : bags.keySet()) {

            if (findNumberOfShinyBags(key, bags) > 0) {
                numberOfBags++;
            }
        }


        return numberOfBags;
    }


    public static int part2(File inputFile) {
        int numberOfBags = 0;
        HashMap<String, List<Bag>> bags = getData(inputFile);

        numberOfBags = findNumberOfBags("shiny gold", bags);

        return numberOfBags;
    }

    private static int findNumberOfBags(String bagColor, HashMap<String, List<Bag>> bags) {
        int numberOfBags = 0;
        List<Bag> bagContent = bags.get(bagColor);
        if (bagContent == null) {
            return numberOfBags;
        }
        for (Bag bag : bagContent) {
            numberOfBags+=bag.getNumberOfBags();
            numberOfBags+=bag.getNumberOfBags()*findNumberOfBags(bag.getColor(), bags);
        }

        return numberOfBags;
    }


        private static int findNumberOfShinyBags(String bagColor, HashMap<String, List<Bag>> bags) {

        int numberOfBags = 0;

        List<Bag> subList = bags.get(bagColor);
        if (subList == null) {
            return numberOfBags;
        }
        for (Bag bag : subList) {

            if (bag.getColor().equals("shiny gold")) {
                numberOfBags+=bag.getNumberOfBags();
            }
            numberOfBags+=findNumberOfShinyBags(bag.getColor(), bags);
        }

        return numberOfBags;
    }



    private static HashMap<String, List<Bag>> getData(File inputFile) {
        HashMap<String, List<Bag>>  data = new HashMap<>();

        for (String line : InputReader.getLinesOfFile(inputFile)) {

            String[] bags = line.replace(".", "").replace("bags", "").replace("bag", "").split(" contain ");

            List<Bag> insideBagList = new ArrayList<>();

            String[] insideBags = bags[1].split(",");
            if (!insideBags[0].equals("no other ")) {

                for (String insideBag : insideBags) {
                    Bag insideBagInfo = new Bag();
                    String[] bagInfo = insideBag.trim().split(" ");
                    insideBagInfo.setNumberOfBags(Integer.valueOf(bagInfo[0]));
                    String color = insideBag.replace(bagInfo[0], "").trim();
                    insideBagInfo.setColor(color);
                    insideBagList.add(insideBagInfo);
                }
            }
            data.put(bags[0].trim(), insideBagList);
        }

        return data;
    }
}
