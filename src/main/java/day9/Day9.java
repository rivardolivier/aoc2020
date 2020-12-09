package day9;

import utils.InputReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9 {

    public static void day9() {

        System.out.println("========== Running code for Day 9 ============");

        File inputFile = new File("src/main/java/day9/input.txt");


        System.out.println("Part 1 - Number invalid: " + part1(inputFile, 25));
        System.out.println("Part 2 - Encryption weakness: " + part2(inputFile, 25));

    }



    public static long part2(File inputFile, int previousNumbers) {

        List<Long> data = getData(inputFile);

        for (int i = previousNumbers; i<data.size();i++) {
            long numberToValidate = data.get(i);
            List<Long> sublist = data.subList(i-previousNumbers, i);

            if (!checkIfNumberIsValid(numberToValidate, sublist)) {

                List<Long> invalidSets = findListOfSumOfInvalidNumbers(numberToValidate, data.subList(0, i));
                if (invalidSets != null) {
                    return findSumOfInvalidNumbers(invalidSets);
                }
            }
        }
        return 0;
    }

    private static long findSumOfInvalidNumbers(List<Long> invalidSets) {

        invalidSets.sort(Collections.reverseOrder());

        return invalidSets.get(0) + invalidSets.get(invalidSets.size()-1);
    }

    private static List<Long> findListOfSumOfInvalidNumbers(long numberToValidate, List<Long> sublist) {

        for (int i = 0; i< sublist.size(); i++) {
            long sum = sublist.get(i);
            for (int j = i+1; j<sublist.size();j++) {
                sum+=sublist.get(j);
                if (sum==numberToValidate) {
                    return sublist.subList(i, j+1);
                }
            }
        }
        return null;
    }

    public static long part1(File inputFile, int previousNumbers) {
        int number = 0;

        List<Long> data = getData(inputFile);

        for (int i = previousNumbers; i<data.size();i++) {
            long numberToValidate = data.get(i);
            List<Long> sublist = data.subList(i-previousNumbers, i);

            if (!checkIfNumberIsValid(numberToValidate, sublist)) {
                return numberToValidate;
            }
        }

        return number;
    }

    private static boolean checkIfNumberIsValid(long numberToValidate, List<Long> sublist) {

        for (int i=0;i<sublist.size();i++) {
            for (int j=0;j<sublist.size();j++) {
                if (i!=j && sublist.get(i)+sublist.get(j) == numberToValidate) {
                    return true;
                }
            }
        }

        return false;
    }

    private static List<Long> getData(File inputFile) {
        List<Long>  data = new ArrayList<>();

        for (String line : InputReader.getLinesOfFile(inputFile)) {
            data.add(Long.valueOf(line));
        }

        return data;
    }
}
