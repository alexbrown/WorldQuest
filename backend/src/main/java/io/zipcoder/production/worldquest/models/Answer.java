package io.zipcoder.production.worldquest.models;

/**
 * Created by abrown on 10/26/15.
 */
public class Answer {
    private int questionID;
    private int teamID;
    private int answerIndex;
    private int timeAnswered;

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
