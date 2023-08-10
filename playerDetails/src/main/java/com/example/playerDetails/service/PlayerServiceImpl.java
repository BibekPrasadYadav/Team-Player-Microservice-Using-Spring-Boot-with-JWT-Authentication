package com.example.playerDetails.service;

import com.example.playerDetails.entities.Player;
import com.example.playerDetails.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService{
    @Autowired
    private PlayerRepository playerRepository;

//    List<Player> list=List.of(new Player(1L,"Rohit Sharma",45L,"MI",1L),
//            new Player(2L,"Virat Kohli",18L,"RCB",2L),
//            new Player(3L,"Tilak Varma",9L,"MI",1L));
    @Override
    public List<Player> getAllPlayer() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> getPlayerById(long teamId) {
//        return list.stream().filter(player->player.getTeamId()==(teamId)).collect(Collectors.toList());
        return playerRepository.findByTeamId(teamId);
    }

    @Override
    public void savePlayer(Player player) {
        playerRepository.save(player);
    }
}
