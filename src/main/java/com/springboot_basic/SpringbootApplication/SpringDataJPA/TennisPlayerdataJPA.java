package com.springboot_basic.SpringbootApplication.SpringDataJPA;


import com.springboot_basic.SpringbootApplication.SpringDataJPA.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TennisPlayerdataJPA implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TennisPlayerJPARepository repo;
	

	@Override
	public void run(String... args) throws Exception {
		logger.info("\n\n>> Inserting Player: {}\n", repo.save(
				new Player("Djokovic", "Serbia", new Date(), 81)));

		logger.info("\n\n>> Inserting Player: {}\n", repo.save(
				new Player("Surendra", "India", new Date(), 85)));

		logger.info("Updating Player with 3: {}", repo.save(new Player(1, "Thiem", "Austria",
				new Date(), 17)));
		logger.info("Player with Id 2: {}", repo.findById(2));
		


		logger.info("All Players Data: {}", repo.findAll());

		logger.info("Find by nationality: {}", repo.findByNationality("India"));

		logger.info("Find by Id Greater than 1: {}", repo.findByIdGreaterThan(1));

	}




	public static void main(String[] args) {

		SpringApplication.run(TennisPlayerdataJPA.class, args);
		}


    }
