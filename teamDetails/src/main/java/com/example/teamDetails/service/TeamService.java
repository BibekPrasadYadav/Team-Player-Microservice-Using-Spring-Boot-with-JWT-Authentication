package com.example.teamDetails.service;

import com.example.teamDetails.entities.Team;

import java.util.List;

public interface TeamService {

    public List<Team> getAllTeam();
    public void saveTeam(Team team);
    public Team getTeamById(long teamId);
}
