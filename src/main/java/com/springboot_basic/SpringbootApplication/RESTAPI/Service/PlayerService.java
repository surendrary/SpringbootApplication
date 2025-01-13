package com.springboot_basic.SpringbootApplication.RESTAPI.Service;

import com.springboot_basic.SpringbootApplication.RESTAPI.Exception.PlayerNotFoundException;
import com.springboot_basic.SpringbootApplication.RESTAPI.Player;
import com.springboot_basic.SpringbootApplication.RESTAPI.Repository.PlayerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return  playerRepository.findAll();
    }

    public Player getPlayerbyId(int id) {
        Optional<Player> tempPlayer = playerRepository.findById(id);
        Player p = null;
        //if the Optional has a value, assign it to p
        if(tempPlayer.isPresent())
            p = tempPlayer.get();
        else
            throw new PlayerNotFoundException("Player with id "+ id +" not found");

        return tempPlayer.get();
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player patch( int id, Map<String, Object> partialPlayer) {
        Optional<Player> player = playerRepository.findById(id);

        if(player.isPresent()) {
            partialPlayer.forEach( (key, value) -> {
                System.out.println("Key: " + key + " Value: " + value);
                Field field = ReflectionUtils.findField(Player.class, key);
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, player.get(), value);
            });
        }
        else
            throw new PlayerNotFoundException("Player with id {"+ id +"} not found");

        return playerRepository.save(player.get());
    }

    @Transactional
    public void updateTitles(int id, int titles) {
        Optional<Player> tempPlayer = playerRepository.findById(id);

        if(tempPlayer.isEmpty())
            throw new PlayerNotFoundException("Player with id "+ id +" not found");

        playerRepository.updateTitles(id, titles);
    }

    public String deletePlayer(int id) {
        Optional<Player> tempPlayer = playerRepository.findById(id);

        if(tempPlayer.isEmpty()) {
            throw new PlayerNotFoundException("Player with id "+ id + " not found.");
        }

        playerRepository.delete(tempPlayer.get());
        return "Player with id "+ id +" deleted";
    }
}
