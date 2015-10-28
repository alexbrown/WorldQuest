package io.zipcoder.production.worldquest.controllers;

import io.zipcoder.production.worldquest.models.Answer;
import io.zipcoder.production.worldquest.models.Question;
import io.zipcoder.production.worldquest.models.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rsparks on 10/26/15.
 */
@Controller
public class AnswerDecisionEngineController {
    private static int nextId = 0;

    @Autowired
    private QuestionDAO questionDAO;

    /**
     * Gets the next question in the database (by incrementing, this needs to change)
     * @return question object
     */
    @RequestMapping(value = "/question", method = RequestMethod.GET)
    @ResponseBody
    public Question getQuestion(){
        Question question = questionDAO.findOne(++nextId);
        if(question == null) {
            nextId = 1;
            question = questionDAO.findOne(nextId);
        }
        question.buildAnswerArray();
        return question;
    }

    /**
     * Takes in the id of the question and team, their answer and evaluates if it's correct
     * @param questionID -- id of question in database
     * @param teamID --  id of team in database
     * @param answerIndex -- what that team selected for answer
     * @return true if they were right, false if they weren't
     */
    @RequestMapping(value="/answer", method = RequestMethod.GET)
    @ResponseBody
    public boolean sendAnswer(Integer questionID, Integer teamID, Integer answerIndex){
        Answer answer = new Answer(questionID, teamID, answerIndex);
        Question question = questionDAO.findOne(questionID);

        if(question.getCorrectIndex()==answerIndex){
            return true;
        }
        else{
            return false;
        }
    }
}
