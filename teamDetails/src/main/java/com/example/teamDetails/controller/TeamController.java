package com.example.teamDetails.controller;

import com.example.teamDetails.entities.Player;
import com.example.teamDetails.entities.Team;
import com.example.teamDetails.repository.TeamRepository;
import com.example.teamDetails.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
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

    @GetMapping("/{teamId}")
    public Team getTeamById(@PathVariable("teamId") long teamId){
//        Team team= teamService.getTeamById(teamId);
//
//        List players=restTemplate.getForObject("http://localhost:9000/player/" + team.getTeamId(),List.class);
//
//        team.setPlayers(players);
//        return team;

        Team team=teamRepository.findById(teamId).orElse(null);
        List players=restTemplate.getForObject("http://localhost:9001/player/" + team.getTeamId(),List.class);
        team.setPlayers(players);
        return team;
    }

    @PostMapping("/save")
    public void saveTeam(@RequestBody Team team){
        teamService.saveTeam(team);
    }
}
