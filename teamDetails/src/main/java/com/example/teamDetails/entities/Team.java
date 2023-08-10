package com.example.teamDetails.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long teamId;
    private String teamName;
    private String teamCaptain;
    private String teamCoach;

    @Transient
    private List<Player> players=new ArrayList<>();
    public Team(long teamId, String teamName, String teamCaptain, String teamCoach) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamCaptain = teamCaptain;
        this.teamCoach = teamCoach;
    }

}
