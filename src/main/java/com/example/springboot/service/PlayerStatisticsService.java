package com.example.springboot.service;

import com.example.springboot.DTO.PlayerStatisticsDTO;
import com.example.springboot.entity.PlayerStats;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.repository.PlayerStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerStatisticsService {
    private final PlayerStatisticsRepository playerStatisticsRepository;

    @Autowired
    public PlayerStatisticsService(PlayerStatisticsRepository playerStatisticsRepository) {
        this.playerStatisticsRepository = playerStatisticsRepository;
    }

    public List<PlayerStatisticsDTO> getAllPlayerStatistics() {
        List<PlayerStats> playerStatisticsList = playerStatisticsRepository.findAll();
        return playerStatisticsList.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    private PlayerStatisticsDTO convertEntityToDTO(PlayerStats playerStatistics) {
        PlayerStatisticsDTO dto = new PlayerStatisticsDTO();
        // Map fields from entity to DTO
        dto.setId(playerStatistics.getId());
        dto.setPlayer(playerStatistics.getPlayer());
        dto.setPosition(playerStatistics.getPosition());
      //  dto.setTeam(playerStatistics.getTeam());
        //  dto.setAge(playerStatistics.getAge());
        dto.setBirthYear(playerStatistics.getBirthYear());
        dto.setGames(playerStatistics.getGames());
        dto.setGamesStarts(playerStatistics.getGamesStarts());
        dto.setMinutes(playerStatistics.getMinutes());
        dto.setMinutes90s(playerStatistics.getMinutes90s());
        return dto;
    }

    public PlayerStatisticsDTO getPlayerStatisticsById(Long playerId) {
        Optional<PlayerStats> playerStatistics = playerStatisticsRepository.findById(playerId);
        if (playerStatistics.isPresent()) {
            return convertEntityToDTO(playerStatistics.get());
        } else {
            throw new ResourceNotFoundException("Player statistics not found for ID: " + playerId);
        }
    }

    public List<PlayerStatisticsDTO> getPlayerStatisticsWithFilter(Integer games, Integer minutes, Integer birthYear) {
        List<PlayerStats> filteredPlayerStatistics = playerStatisticsRepository.findByGamesAndMinutesAndBirthYear(games, minutes, birthYear);
        return filteredPlayerStatistics.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }
}
