package com.example.teamDetails.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private long playerId;
    private String playerName;
    private long playerJersey;
    private String playerTeam;
    private long teamId;
}
