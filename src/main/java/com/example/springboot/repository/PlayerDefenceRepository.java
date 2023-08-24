package com.example.springboot.repository;

import com.example.springboot.entity.PlayerDefence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerDefenceRepository extends JpaRepository<PlayerDefence, Long> {
    List<PlayerDefence> findByPositionAndTacklesAndTacklesWon(
            String position, Integer tackles, Integer tacklesWon);
}

