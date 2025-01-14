package com.springboot_basic.SpringbootApplication.DatabaseRelationship.onetoone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/players")
    public List<Player> getAllPlayer() {
        return playerService.getAllPlayers();
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }
    /*  Example on how to create data via POST
    {
            "name": "Djokovic",
            "playerProfile": {
                        "twitter": "@DjokerNole"
  }
}
     */


}
