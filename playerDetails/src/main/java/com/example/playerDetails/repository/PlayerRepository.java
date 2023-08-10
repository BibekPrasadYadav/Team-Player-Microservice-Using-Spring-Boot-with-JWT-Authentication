package com.example.playerDetails.repository;

import com.example.playerDetails.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,Long> {

    List<Player> findByTeamId(long teamId);
}
