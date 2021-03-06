package day6;

import utils.InputReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Day6 {

    public static void day6() {
        System.out.println("========== Running code for Day 6 ============");

        File inputFile = new File("src/main/java/day6/input.txt");


        System.out.println("Part 1 - Sum of yes answers :" + part1(inputFile));
        System.out.println("Part 2 - Sum of yes answers :" + part2(inputFile));
    }

    public static int part1(File inputFile) {

        int sumOfYesAnswers = 0;

        List<Group> listOfGroup = getData(inputFile);

        for (Group group : listOfGroup) {
            sumOfYesAnswers += group.getQuestions().size();
        }

        return sumOfYesAnswers;
    }

    public static int part2(File inputFile) {

        int sumOfYesAnswers = 0;

        List<Group> listOfGroup = getData(inputFile);

        for (Group group : listOfGroup) {
            for (Integer value : group.getQuestions().values()) {
                if (value == group.getNumberOfPeople()) {
                    sumOfYesAnswers += 1;
                }
            }
        }

        return sumOfYesAnswers;
    }

    private static List<Group> getData(File inputFile) {

        List<Group> data = new ArrayList<>();
        Group group = new Group(0);

        for (String line : InputReader.getLinesOfFile(inputFile)) {
            if (line.isBlank()) {

                data.add(group);
                group = new Group(0);
                continue;
            }
            group.incrementNumberOfPeople();
            for (int i = 0; i < line.length(); i++) {
                group.addQuestion(String.valueOf(line.charAt(i)));
            }
        }
        data.add(group);
        return data;
    }
}
