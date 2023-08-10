package com.example.playerDetails.controller;

import com.example.playerDetails.entities.Player;
import com.example.playerDetails.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    @GetMapping("/all")
    public List<Player> getAllPlayer(){
        return playerService.getAllPlayer();
    }

    @GetMapping("/{teamId}")
    public  List<Player> getPlayerById(@PathVariable("teamId") long teamId){
        return playerService.getPlayerById(teamId);
    }

    @PostMapping("/save")
    public void saveTeam(@RequestBody Player player){
        playerService.savePlayer(player);
    }
}
