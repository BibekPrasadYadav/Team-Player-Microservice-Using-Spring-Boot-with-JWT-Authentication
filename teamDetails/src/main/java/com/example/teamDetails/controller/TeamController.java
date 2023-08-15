package com.example.teamDetails.controller;

import com.example.teamDetails.entities.Player;
import com.example.teamDetails.entities.Team;
import com.example.teamDetails.repository.TeamRepository;
import com.example.teamDetails.service.TeamService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    Logger logger = LoggerFactory.getLogger(TeamController.class);
    @Autowired
    private TeamService teamService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/all")
    public List<Team> getAllTeam(){


        return teamService.getAllTeam();
    }

    int retryCount=1;
    @GetMapping("/{teamId}")
//    @CircuitBreaker(name = "PlayerServiceBreaker", fallbackMethod = "playerServiceFallback")
    @Retry(name="PlayerServiceBreaker", fallbackMethod = "playerServiceFallback")
    public Team getTeamById(@PathVariable("teamId") long teamId){
//        Team team= teamService.getTeamById(teamId);
//
//        List players=restTemplate.getForObject("http://localhost:9000/player/" + team.getTeamId(),List.class);
//
//        team.setPlayers(players);
//        return team;

        logger.info("Retry Count {}",retryCount);
        retryCount++;
        Team team=teamRepository.findById(teamId).orElse(null);
        List players=restTemplate.getForObject("http://localhost:9001/player/" + team.getTeamId(),List.class);
        team.setPlayers(players);
        return team;
    }

    //Create Fallback Method with same return type as above method
    public Team playerServiceFallback(long teamId, Exception exception){
        logger.info("Player Service is down",exception.getMessage());

        Team team=new Team(1L,"DummyTeam","Dummy Captain","Dummy Coach " + exception.getMessage()) ;
        return team;
    }

    @PostMapping("/save")
    public void saveTeam(@RequestBody Team team){
        teamService.saveTeam(team);
    }
}
