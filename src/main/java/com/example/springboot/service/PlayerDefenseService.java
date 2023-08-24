package com.example.springboot.service;

import com.example.springboot.DTO.PlayerDefenceDTO;
import com.example.springboot.entity.PlayerDefence;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.repository.PlayerDefenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerDefenseService {
    private final PlayerDefenceRepository playerDefenceRepository;

    @Autowired
    public PlayerDefenseService(PlayerDefenceRepository playerDefenceRepository) {
        this.playerDefenceRepository = playerDefenceRepository;
    }

    public PlayerDefenceDTO getPlayerDefenseById(Long playerId) {
        Optional<PlayerDefence> playerDefense = playerDefenceRepository.findById(playerId);
        if (playerDefense.isPresent()) {
            return convertEntityToDTO(playerDefense.get());
        } else {
            throw new ResourceNotFoundException("Player defense data not found for ID: " + playerId);
        }
    }

    public List<PlayerDefenceDTO> getPlayerDefenseWithFilter(String position, Integer tackles, Integer tacklesWon) {
        List<PlayerDefence> filteredPlayerDefense = playerDefenceRepository.findByPositionAndTacklesAndTacklesWon(position,tackles, tacklesWon);
        return filteredPlayerDefense.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<PlayerDefenceDTO> getAllPlayerDefence() {
        List<PlayerDefence> playerDefenceList = playerDefenceRepository.findAll();
        return playerDefenceList.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    private PlayerDefenceDTO convertEntityToDTO(PlayerDefence playerDefence) {
        PlayerDefenceDTO dto = new PlayerDefenceDTO();
        dto.setId(playerDefence.getId());
        dto.setPlayer(playerDefence.getPlayer());
        dto.setPosition(playerDefence.getPosition());
        dto.setTeam(playerDefence.getTeam());
        dto.setAge(playerDefence.getAge());
        dto.setBirthYear(playerDefence.getBirthYear());
        dto.setMinutes90s(playerDefence.getMinutes90s());
        dto.setTackles(playerDefence.getTackles());
        dto.setTacklesWon(playerDefence.getTacklesWon());
        // Map other fields...
        return dto;
    }
}
