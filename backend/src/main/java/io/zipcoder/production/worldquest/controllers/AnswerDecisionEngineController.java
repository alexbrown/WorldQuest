package io.zipcoder.production.worldquest.controllers;

import io.zipcoder.production.worldquest.models.Answer;
import io.zipcoder.production.worldquest.models.Question;
import io.zipcoder.production.worldquest.models.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by rsparks on 10/26/15.
 */
@Controller
public class AnswerDecisionEngineController {
    private static int nextId = 0;

    @Autowired
    private QuestionDAO questionDAO;
    String[] answers = new String[]{"Tokyo","Beijing","Pyeongchang","Almaty"};
    Question question = new Question("Which city is the host of 2022 Winter Olympic Games?", answers, 1);

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
