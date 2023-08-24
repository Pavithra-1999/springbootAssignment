package com.example.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
//@Table(name="player_stats")
public class PlayerStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String player;
    private String position;
    private String team;
    private Integer birthYear;
    private Integer games;
    private Integer gamesStarts;
    private Integer minutes;
    private Double minutes90s;
    // Add other attributes

}

