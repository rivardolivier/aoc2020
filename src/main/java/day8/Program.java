package day8;

public class Program {

    private int acc;
    private int instructionNumber;
    private int lastInstructionNumber;
    private boolean operationChanged;

    public Program() {
        acc = 0;
        instructionNumber = 0;
        lastInstructionNumber = 0;
        operationChanged = false;
    }

    public int getAcc() {
        return acc;
    }

    public void increaseAcc(int acc) {
        this.acc += acc;
    }

    public int getInstructionNumber() {
        return instructionNumber;
    }

    public void increaseInstructionNumber(int instructionNumber) {
        this.instructionNumber += instructionNumber;
    }

    public int getLastInstructionNumber() {
        return lastInstructionNumber;
    }

    public void setLastInstructionNumber(int lastInstructionNumber) {
        this.lastInstructionNumber = lastInstructionNumber;
    }

    public boolean isOperationChanged() {
        return operationChanged;
    }

    public void setOperationChanged(boolean operationChanged) {
        this.operationChanged = operationChanged;
    }
}
