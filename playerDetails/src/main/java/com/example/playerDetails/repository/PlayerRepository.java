package com.example.playerDetails.repository;

import com.example.playerDetails.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {
}
