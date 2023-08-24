package com.example.springboot.DTO;

import lombok.Data;

@Data
public class PlayerDefenceDTO {
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