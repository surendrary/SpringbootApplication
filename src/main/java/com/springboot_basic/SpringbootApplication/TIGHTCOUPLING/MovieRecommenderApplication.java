package com.springboot_basic.SpringbootApplication.TIGHTCOUPLING;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderApplication {

	public static void main(String[] args) {


		//SpringApplication.run(MovieRecommenderApplication.class, args);

		RecommendationImplementation recommender = new RecommendationImplementation();
		String[] result = recommender.recommendMovies("Finding Dory");
		System.out.println(Arrays.toString(result));


	}
}
