package com.example.springboot.controller;

import com.example.springboot.DTO.PlayerStatisticsDTO;
import com.example.springboot.service.PlayerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fifa/api/v1/statistics")
public class PlayerStatisticsController {
    private final PlayerStatisticsService playerStatisticsService;

    @Autowired
    public PlayerStatisticsController(PlayerStatisticsService playerStatisticsService) {
        this.playerStatisticsService = playerStatisticsService;
    }

    @GetMapping("/get-all-details")
    public ResponseEntity<List<PlayerStatisticsDTO>> getAllPlayerStatistics() {
        List<PlayerStatisticsDTO> playerStatisticsList = playerStatisticsService.getAllPlayerStatistics();
        return ResponseEntity.ok(playerStatisticsList);
    }
    @GetMapping("/get-by-id/{playerId}")
    public ResponseEntity<PlayerStatisticsDTO> getPlayerStatisticsById(@PathVariable Long playerId) {
        PlayerStatisticsDTO playerStatisticsDTO = playerStatisticsService.getPlayerStatisticsById(playerId);
        return ResponseEntity.ok(playerStatisticsDTO);
    }
    @GetMapping("/apply-filter")
    public ResponseEntity<List<PlayerStatisticsDTO>> getPlayerStatisticsWithFilter(
            @RequestParam(required = false) Integer games,
            @RequestParam(required = false) Integer minutes,
            @RequestParam(required = false) Integer birthYear)
    {
        List<PlayerStatisticsDTO> filteredPlayerStatistics = playerStatisticsService.getPlayerStatisticsWithFilter(
                games, minutes, birthYear);
        return ResponseEntity.ok(filteredPlayerStatistics);
    }
}

