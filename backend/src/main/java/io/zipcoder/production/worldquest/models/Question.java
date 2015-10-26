package io.zipcoder.production.worldquest.models;

/**
 * Created by abrown on 10/26/15.
 */
public class Question {
    private String problem;
    private String[] possibleAns;
    private int correctIndex;
    private static int id = 1;

    public Question(String problem, String[] possibleAns, int correctIndex) {
        this.problem = problem;
        this.possibleAns = possibleAns;
        this.correctIndex = correctIndex;
        this.id = id++;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public void setPossibleAns(String[] possibleAns) {
        this.possibleAns = possibleAns;
    }

    public void setCorrectIndex(int correctIndex) {
        this.correctIndex = correctIndex;
    }

    public static void setId(int id) {
        Question.id = id;
    }

    public String getProblem() {

        return problem;
    }

    public String[] getPossibleAns() {
        return possibleAns;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }

    public static int getId() {
        return id;
    }
}
