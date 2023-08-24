//package com.example.springboot.service;
//
//import com.example.springboot.entity.PlayerStats;
//import org.springframework.data.jpa.domain.Specification;
//import com.example.springboot.repository.PlayerStatisticsRepository
//
//import java.util.List;
//import java.util.Scanner;
//import java.util.stream.Collectors;
//
//public class PlayerStatisticsSpecifications {
//    Integer gamesPlayed, Integer minutesPlayed, Integer goalsScored, Integer birthYear)
//    private final Scanner playerStatisticsRepository = null;
//
//    {
//        Specification<PlayerStats> specification = Specification.where(null);
//
//        if (gamesPlayed != null) {
//            specification = specification.and(PlayerStatisticsSpecifications.hasGamesPlayed(gamesPlayed));
//        }
//        if (minutesPlayed != null) {
//            specification = specification.and(PlayerStatisticsSpecifications.hasMinutesPlayed(minutesPlayed));
//        }
//        if (goalsScored != null) {
//            specification = specification.and(PlayerStatisticsSpecifications.hasGoalsScored(goalsScored));
//        }
//        if (birthYear != null) {
//            specification = specification.and(PlayerStatisticsSpecifications.hasBirthYear(birthYear));
//        }
//
//        List<PlayerStats> filteredPlayerStatistics = playerStatisticsRepository.findAll(specification);
//        return filteredPlayerStatistics.stream()
//                .map(this::convertEntityToDTO)
//                .collect(Collectors.toList());
//}}
//
