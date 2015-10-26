package io.zipcoder.production.worldquest.controllers;

import io.zipcoder.production.worldquest.models.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Team Controller for
 */
@Controller
public class TeamController {
    private static HashMap<String, Team> teams = new HashMap<>();

    static{
        String username = "user";
        teams.put(username, new Team(username, "password"));
    }

    @ResponseBody
    @RequestMapping(value="/team/auth",method = RequestMethod.GET)
    public Team authenticate(String name, String password) {
        Team authorizedTeam = null;
        System.out.println(name + " " + password);

        if(teams.containsKey(name) && teams.get(name).getHash().equals(password)) {
            authorizedTeam = teams.get(name);
        }

        //String response = team != null && team.getHash().equals(password) ? "true" : "false";
        return authorizedTeam;
    }
}
