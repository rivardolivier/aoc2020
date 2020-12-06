package day6;

import java.util.HashMap;

public class Group {

    private HashMap<String, Integer> questions;
    private int numberOfPeople;

    public Group(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
        this.questions = new HashMap<>();
    }


    public void addQuestion(String question) {
        if (questions.containsKey(question)) {
            questions.put(question, questions.get(question)+1);
        } else {
            questions.put(question, 1);
        }
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public HashMap<String, Integer> getQuestions() {
        return questions;
    }

    public void incrementNumberOfPeople() {
        numberOfPeople+=1;
    }
}
