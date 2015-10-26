package io.zipcoder.production.worldquest.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by rsparks on 10/26/15.
 */
@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int answerID;

    @NotNull
    @Column(name="question")
    private int questionID;

    @NotNull
    @Column(name="team")
    private int teamID;

    @NotNull
    @Column(name="answer_index")
    private int answerIndex;

    @NotNull
    @Column(name="time_answered")
    private int timeAnswered;

    public Answer(){};

    public Answer(int questionID, int teamID, int answerIndex){
        this.questionID = questionID;
        this.teamID = teamID;
        this.answerIndex = answerIndex;
    }

    public Answer(int questionID, int teamID,int answerIndex, int timeAnswered){
        this.questionID = questionID;
        this.teamID = teamID;
        this.answerIndex = answerIndex;
        this.timeAnswered = timeAnswered;
    }

    public int getAnswerID() {
        return answerID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public int getTeamID() {
        return teamID;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }

    public int getTimeAnswered() {
        return timeAnswered;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public void setQuestionID(int questionID) {

        this.questionID = questionID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public void setAnswerIndex(int answerIndex) {
        this.answerIndex = answerIndex;
    }

    public void setTimeAnswered(int timeAnswered) {
        this.timeAnswered = timeAnswered;
    }
}
