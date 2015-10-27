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

    @Autowired
    private QuestionDAO questionDAO;

    String[] answers = new String[]{"Tokyo","Beijing","Pyeongchang","Almaty"};
    Question question = new Question("Which city is the host of 2022 Winter Olympic Games?", answers, 1);
    @RequestMapping(value = "/question", method = RequestMethod.GET)
    @ResponseBody
    public Question getQuestion(@RequestParam (value = "id", defaultValue="0") Integer nextId){

        ArrayList<Question> questionArrayList = (ArrayList<Question>) questionDAO.findAll();
        ArrayList<Integer> keyArrayList = new ArrayList<>();
        HashMap<Integer, Question> questionHashMap = new HashMap<>();
        Integer incrementer = 0;

        for(Question question: questionArrayList){
            keyArrayList.add(question.getId());
        }

        for(Question _question: questionArrayList){
            questionHashMap.put(_question.getId(),_question);
        }

        if (nextId == 0){
            Question question = questionArrayList.get(0);
        }else {
            for(Integer integer: keyArrayList){
                if(integer==nextId){
                    incrementer = keyArrayList.indexOf(integer);
                    incrementer++;
                    nextId = keyArrayList.get(incrementer);
                }
            }
            Question question = questionArrayList.get(nextId);
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
