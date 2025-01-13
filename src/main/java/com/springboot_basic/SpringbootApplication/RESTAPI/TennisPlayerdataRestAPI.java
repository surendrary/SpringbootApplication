package com.springboot_basic.SpringbootApplication.RESTAPI;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TennisPlayerdataRestAPI {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {

		SpringApplication.run(TennisPlayerdataRestAPI.class, args);
		}
    }