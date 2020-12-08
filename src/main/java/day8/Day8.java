package day8;

import utils.InputReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Day8 {

    public static void day8() {
        System.out.println("========== Running code for Day 8 ============");

        File inputFile = new File("src/main/java/day8/input.txt");


        System.out.println("Part 1 - Number of time executed: " + part1(inputFile));
        System.out.println("Part 2 - " + part2(inputFile));
    }

    public static int part1(File inputFile) {

        Program program = new Program();
        List<Operation> operations = getData(inputFile);

        while (true) {
            Operation operation = operations.get(program.getInstructionNumber());
            int numberOfTimeExecuted = operation.getNumberOfTimeExecuted();
            if (numberOfTimeExecuted > 0) {
                return program.getAcc();
            }
            operation.setNumberOfTimeExecuted(numberOfTimeExecuted +1);
            runOperation(program, operation);
        }
    }

    private static void runOperation(Program program, Operation operation) {


        program.setLastInstructionNumber(program.getInstructionNumber());
        if (operation.getOperation().equals("acc")) {
            program.increaseAcc(operation.getValue());
            program.increaseInstructionNumber(1);
        }
        if (operation.getOperation().equals("nop")) {
            program.increaseInstructionNumber(1);
        }
        if (operation.getOperation().equals("jmp")) {
            program.increaseInstructionNumber(operation.getValue());
        }
    }
    private static boolean runProgram(Program program, List<Operation> operations, int indexToChange) {

        int indexCpt = 0;

        while (true) {
            if (operations.size()<=program.getInstructionNumber()) {
                return true;
            }
            Operation operation = operations.get(program.getInstructionNumber());

            if (operation.getOperation().equals("jmp")) {
                if (indexCpt==indexToChange && !program.isOperationChanged()) {
                    operation.setOperation("nop");
                    program.setOperationChanged(true);
                } else {
                    indexCpt++;
                }
            }

            int numberOfTimeExecuted = operation.getNumberOfTimeExecuted();

            if (numberOfTimeExecuted > 0) {
                return false;
            }
            operation.setNumberOfTimeExecuted(numberOfTimeExecuted +1);
            runOperation(program, operation);
        }
    }


    public static int part2(File inputFile) {
        Program program = new Program();
        int indexOfChangedOperation = 0;


        while (true) {
            if (runProgram(program, getData(inputFile), indexOfChangedOperation)) {
                return program.getAcc();
            }
            program = new Program();
            indexOfChangedOperation++;
        }
    }

    private static List<Operation> getData(File inputFile) {
        List<Operation>  data = new ArrayList<>();

        for (String line : InputReader.getLinesOfFile(inputFile)) {

            Operation operation = new Operation();
            String[] operationWithValue = line.split(" ");
            operation.setOperation(operationWithValue[0]);
            operation.setValue(Integer.parseInt(operationWithValue[1]));
            data.add(operation);
        }

        return data;
    }
}
