package com.springboot_basic.SpringbootApplication.SpringbootJdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.springboot_basic.SpringbootApplication.SpringbootJdbc.Dao.PlayerDao;

import java.util.Date;

@SpringBootApplication
public class TennisPlayer implements CommandLineRunner {

		private Logger logger = LoggerFactory.getLogger(this.getClass());

		@Autowired
		PlayerDao dao;

		public static void main(String[] args) {
			SpringApplication.run(TennisPlayer.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			logger.info("All Players Data: {}", dao.getAllPlayers()); // Query All Players
			logger.info("Get Player by Id: {}", dao.getPlayerById(1));// Query Player by Id
			logger.info("Inserting Player 4: {}", dao.insertPlayer(
					new Player (4, "Thiem", "Austria",
							new Date(System.currentTimeMillis()),
							17 )));
			logger.info("All Players Data: {}", dao.getAllPlayers());  // Insert New Player

			logger.info("Update Player 4: {}", dao.updatePlayer(new Player(4,
					"Surendra","India",new Date(),100))); // Update Player by Id
			logger.info("All Players Data: {}", dao.getAllPlayers());
			logger.info("Delete Player 4 : {}",dao.deletePlayer(4));  // Delete Player by Id
			logger.info("All Players Data: {}", dao.getAllPlayers());
			dao.createTournamentTable(); // DDL
			logger.info("Table Created Successfully");
		}
    }
