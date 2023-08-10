package com.example.teamDetails.repository;

import com.example.teamDetails.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {

}
