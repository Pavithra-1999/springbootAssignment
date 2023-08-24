package com.example.springboot.repository;

import com.example.springboot.entity.PlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayerStatisticsRepository extends JpaRepository<PlayerStats, Long> {
    List<PlayerStats> findByGamesAndMinutesAndBirthYear(
            Integer games, Integer minutes, Integer birthYear);


}

