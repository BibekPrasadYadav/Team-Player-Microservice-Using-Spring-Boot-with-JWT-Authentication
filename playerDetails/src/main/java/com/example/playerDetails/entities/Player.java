package com.example.playerDetails.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long playerId;
    private String playerName;
    private long playerJersey;
    private String playerTeam;
    private long teamId;
}

