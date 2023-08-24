package com.example.springboot.DTO;

import lombok.Data;

@Data

public class PlayerStatisticsDTO {
    private Long id;
    private String player;
    private String position;
    private Integer birthYear;
    private Integer games;
    private Integer gamesStarts;
    private Integer minutes;
    private Double minutes90s;
}
