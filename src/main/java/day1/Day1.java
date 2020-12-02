package day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static void day1() {

        System.out.println("========== Running code for Day 1 ============");


        List<Integer> expenses = getExpenses();

        System.out.println("Value part 1: " + getPart1(expenses));
        System.out.println("Value part 2: " + getPart2(expenses));
    }

    private static Integer getPart1(List<Integer> expenses) {
        for (int expenseIndexA = 0; expenseIndexA < expenses.size(); expenseIndexA++) {
            for (int expenseIndexB = 0; expenseIndexB < expenses.size(); expenseIndexB++) {


                if (expenseIndexA != expenseIndexB
                        && expenses.get(expenseIndexA) + expenses.get(expenseIndexB) == 2020) {
                    return expenses.get(expenseIndexA) * expenses.get(expenseIndexB);
                }
            }
        }
        return null;
    }


    private static Integer getPart2(List<Integer> expenses) {
        for (int expenseIndexA = 0; expenseIndexA < expenses.size(); expenseIndexA++) {
            for (int expenseIndexB = 0; expenseIndexB < expenses.size(); expenseIndexB++) {
                for (int expenseIndexC = 0; expenseIndexC < expenses.size(); expenseIndexC++) {

                    if (expenseIndexA != expenseIndexB && expenseIndexA != expenseIndexC && expenseIndexC != expenseIndexB && expenses
                            .get(expenseIndexA) + expenses.get(expenseIndexB) + expenses.get(expenseIndexC) == 2020) {
                        return expenses.get(expenseIndexA) * expenses.get(expenseIndexB) * expenses.get(expenseIndexC);
                    }
                }
            }
        }
        return null;
    }


    private static List<Integer> getExpenses() {

        List<Integer> expenses = new ArrayList<>();
        try {
            File file = new File("src/main/java/day1/input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                Integer expense = Integer.valueOf(line);
                expenses.add(expense);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expenses;
    }
}
