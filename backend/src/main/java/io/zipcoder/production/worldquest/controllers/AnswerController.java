package io.zipcoder.production.worldquest.controllers;

import io.zipcoder.production.worldquest.models.Answer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rsparks on 10/26/15.
 */
@Controller
public class AnswerController {
    @RequestMapping(value="/answer", method = RequestMethod.PUT)
    public Answer sendAnswer(){
        Answer answer=new Answer(1,1,1,43);
        return answer;
    }
}
