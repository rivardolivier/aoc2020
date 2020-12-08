package day8;

public class Operation {
    private String operation;
    private int value;
    private int numberOfTimeExecuted;

    public Operation() {
        numberOfTimeExecuted = 0;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNumberOfTimeExecuted() {
        return numberOfTimeExecuted;
    }

    public void setNumberOfTimeExecuted(int numberOfTimeExecuted) {
        this.numberOfTimeExecuted = numberOfTimeExecuted;
    }
}
