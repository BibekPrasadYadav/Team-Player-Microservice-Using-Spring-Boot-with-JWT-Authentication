package com.example.playerDetails.service;

import com.example.playerDetails.entities.Player;

import java.util.List;

public interface PlayerService {

    public List<Player> getAllPlayer();
    public List<Player> getPlayerById(long playerId);
    public void savePlayer(Player player);
}
