package io.zipcoder.production.worldquest.controllers;

import io.zipcoder.production.worldquest.models.Question;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rsparks on 10/26/15.
 */
@Controller
public class QuestionController {
    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public Question getQuestion(){
        String[] answers = new String[]{"Tokyo","Beijing","Pyeongchang","Almaty"};
        Question question = new Question("Which city is the host of 2022 Winter Olympic Games?", answers, 1);
        return question;
    }
}
