package com.example.springboot.controller;

import com.example.springboot.DTO.PlayerDefenceDTO;
import com.example.springboot.service.PlayerDefenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fifa/api/v1/defense")
public class PlayerDefenceController {
    private final PlayerDefenseService playerDefenceService;

    @Autowired
    public PlayerDefenceController(PlayerDefenseService playerDefenceService) {
        this.playerDefenceService = playerDefenceService;
    }



        @GetMapping("/get-all-details")
        public ResponseEntity<List<PlayerDefenceDTO>> getAllPlayerDefence() {
            List<PlayerDefenceDTO> playerDefenceList = playerDefenceService.getAllPlayerDefence();
            return ResponseEntity.ok(playerDefenceList);
        }
    @GetMapping("/get-by-id/{playerId}")
    public ResponseEntity<PlayerDefenceDTO> getPlayerDefenseById(@PathVariable Long playerId) {
        PlayerDefenceDTO playerDefenseDTO = playerDefenceService.getPlayerDefenseById(playerId);
        return ResponseEntity.ok(playerDefenseDTO);
    }

    @GetMapping("/apply-filter")
    public ResponseEntity<List<PlayerDefenceDTO>> getPlayerDefenseWithFilter(
            @RequestParam(required = false) String position,
           // @RequestParam(required = false) String team,
            @RequestParam(required = false) Integer tackles,
            @RequestParam(required = false) Integer tacklesWon)
    {
        List<PlayerDefenceDTO> filteredPlayerDefense = playerDefenceService.getPlayerDefenseWithFilter(
                position,tackles, tacklesWon);
        return ResponseEntity.ok(filteredPlayerDefense);
    }
        // Other controller methods...
    }
