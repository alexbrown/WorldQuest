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

    @Transient
    private String[] possibleAns;

    @NotNull
    private String answer_a;

    @NotNull
    private String answer_b;

    @NotNull
    private String answer_c;


    @NotNull
    private String answer_d;


    @NotNull
    private int correctIndex;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Question(){};

    public Question(String problem, String answer_a, String answer_b, String answer_c, String answer_d, int correctIndex) {
        this.problem = problem;
        this.answer_a = answer_a;
        this.answer_b = answer_b;
        this.answer_c = answer_c;
        this.answer_d = answer_d;
        this.correctIndex = correctIndex;
        possibleAns = new String[]{answer_a, answer_b, answer_c, answer_d};
    }

    public Question(String problem, String[] possibleAns, int correctIndex) {
        this.problem = problem;
        this.correctIndex = correctIndex;
        possibleAns = possibleAns;
    }

    public void buildAnswerArray(){
        possibleAns = new String[]{answer_a, answer_b, answer_c, answer_d};

    }

    public String getAnswer_a() {
        return answer_a;
    }

    public void setAnswer_a(String answer_a) {
        this.answer_a = answer_a;
    }

    public String getAnswer_b() {
        return answer_b;
    }

    public void setAnswer_b(String answer_b) {
        this.answer_b = answer_b;
    }

    public String getAnswer_c() {
        return answer_c;
    }

    public void setAnswer_c(String answer_c) {
        this.answer_c = answer_c;
    }

    public String getAnswer_d() {
        return answer_d;
    }

    public void setAnswer_d(String answer_d) {
        this.answer_d = answer_d;
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
