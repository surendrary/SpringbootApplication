package com.springboot_basic.SpringbootApplication.RESTAPI.Controller;


import com.springboot_basic.SpringbootApplication.RESTAPI.Player;
import com.springboot_basic.SpringbootApplication.RESTAPI.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Tennis Player REST API";
    }

    @GetMapping("/players")
    public List<Player> getPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id) {
        return playerService.getPlayerbyId(id);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        player.setId(0);
        return playerService.addPlayer(player);

    }
    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable int id, @RequestBody Player player) {
        player.setId(id);
        return playerService.updatePlayer(player);
    }

    @PatchMapping("/players/{id}")
    public Player patchPlayer(@PathVariable int id, @RequestBody Map<String, Object> playerPatch) {
        return playerService.patch(id, playerPatch);
    }

    @PatchMapping("/players/{id}/titles")
    public void updatePlayerTitle(@PathVariable int id, @RequestBody int titles) {
        playerService.updateTitles(id,titles);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);

    }



}
