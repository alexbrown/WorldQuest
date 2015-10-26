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

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    @ResponseBody
    public Question getQuestion(){
        String[] answers = new String[]{"Tokyo","Beijing","Pyeongchang","Almaty"};
        Question question = new Question("Which city is the host of 2022 Winter Olympic Games?", answers, 1);
        return question;
    }

    @RequestMapping(value="/answer", method = RequestMethod.GET)
    @ResponseBody
    public boolean sendAnswer(Answer answer){
        return true;
    }


}
