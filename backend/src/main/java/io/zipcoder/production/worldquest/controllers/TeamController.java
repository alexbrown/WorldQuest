package io.zipcoder.production.worldquest.controllers;

import io.zipcoder.production.worldquest.models.Team;
import io.zipcoder.production.worldquest.models.TeamDAO;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private TeamDAO teamDAO;
    private static Team unauthorizedTeam = new Team("Unauthorized", "");

    @ResponseBody
    @RequestMapping(value="/team/auth",method = RequestMethod.GET)
    public Team authenticate(String name, String password) {
        Team authorizedTeam = teamDAO.findOneByName(name);

        if(authorizedTeam == null || authorizedTeam.getHash().equals(password)) {
            return authorizedTeam;
        }
        else {
            return unauthorizedTeam;
        }
    }

    @ResponseBody
    @RequestMapping(value="/team",method = RequestMethod.PUT)
    public Object putTeam(@RequestParam(value="name") String name, @RequestParam(value="password") String password) {
        Team matchingTeam = teamDAO.findOneByName(name);
        String status = "success";
        if(matchingTeam == null) {
            matchingTeam = new Team(name, password);
            teamDAO.save(matchingTeam);
        }
        else {
            matchingTeam = null;
            status = "failed";
        }

        final Team returnTeam = matchingTeam;
        final String returnStatus = status;

        return new Object() {
            Team team = returnTeam;
            String status = returnStatus;

            public String getStatus() {
                return this.status;
            }

            public Team getTeam() {
                return this.team;
            }
        };
    }
}
