package io.zipcoder.production.worldquest.controllers;

import io.zipcoder.production.worldquest.models.Answer;
import io.zipcoder.production.worldquest.models.Question;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by abrown on 10/26/15.
 */
@Controller
public class AnswerDecisionEngineController {

    String[] answers = new String[]{"Tokyo","Beijing","Pyeongchang","Almaty"};
    Question question = new Question("Which city is the host of 2022 Winter Olympic Games?", answers, 1);

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    @ResponseBody
    public Question getQuestion(){
        return question;
    }

    @RequestMapping(value="/answer", method = RequestMethod.GET)
    @ResponseBody
    public boolean sendAnswer(Integer questionID, Integer teamID, Integer answerIndex){
        Answer answer = new Answer(questionID, teamID, answerIndex);
        if(question.getCorrectIndex()==answerIndex){
            return true;
        }
        else{
            return false;
        }
    }


}
