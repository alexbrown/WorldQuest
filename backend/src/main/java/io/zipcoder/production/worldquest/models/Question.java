package io.zipcoder.production.worldquest.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by rsparks on 10/26/15.
 */
@Entity
@Table(name = "question")
public class Question {

    @NotNull
    private String problem;

    @NotNull
    private String[] possibleAns;

    @NotNull
    private int correctIndex;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Question(){};

    public Question(String problem, String[] possibleAns, int correctIndex) {
        this.problem = problem;
        this.possibleAns = possibleAns;
        this.correctIndex = correctIndex;
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

    public void setId(int id) {
        this.id = id;
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



    public int getId() {

        return id;
    }
}
