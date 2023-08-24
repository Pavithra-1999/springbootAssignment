package com.example.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
//@Table(name="player_defence")
public class PlayerDefence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String player;
    private String position;
    private String team;
    private String age;
    private Integer birthYear;
    private Double minutes90s;
    private Integer tackles;
    private Integer tacklesWon;
}
