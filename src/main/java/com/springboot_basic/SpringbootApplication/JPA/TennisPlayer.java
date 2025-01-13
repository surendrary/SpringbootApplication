package com.springboot_basic.SpringbootApplication.JPA;


import com.springboot_basic.SpringbootApplication.JPA.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TennisPlayer implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PlayerRepository repo;

	@Override
	public void run(String... args) throws Exception {
		logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
				new Player("Djokovic", "Serbia", new Date(), 81)));

		logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
				new Player("Monfils", "France", new Date(), 10)));

		logger.info("\n\n>> Get All Players {}\n", repo.getAllPlayers());

		logger.info("\n\n>> Query Playerby ID : {}\n", repo.getPlayerById(2));

		logger.info("\n\n>> Updating Player with Id 2: {}\n", repo.updatePlayer(new Player(2, "Surendra", "Austria", new Date(), 19)));



		logger.info("\n\n>> Deleting a Player with Id 1: {}\n");
		repo.deletePlayerById(1);


	}

	public static void main(String[] args) {
			SpringApplication.run(TennisPlayer.class, args);
		}


    }
