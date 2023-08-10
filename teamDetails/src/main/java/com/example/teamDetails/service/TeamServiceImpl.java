package com.example.teamDetails.service;

import com.example.teamDetails.entities.Team;
import com.example.teamDetails.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{
    @Autowired
    private TeamRepository teamRepository;


//    List<Team> list=List.of(new Team(1L,"MI","Rohit Sharma","Mahela"),
//            new Team(2L,"RCB","Faf","Andy"),
//            new Team(3L,"CSK","Dhoni","Fleming"));

    @Override
    public List<Team> getAllTeam() {
        return teamRepository.findAll();
    }

    @Override
    public void saveTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public Team getTeamById(long teamId) {
//        return list.stream().filter((team) -> team.getTeamId()==teamId).findAny().orElse(null);
        return null;
    }
}
