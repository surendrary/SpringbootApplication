package com.springboot_basic.SpringbootApplication.LOOSECOUPLING;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {


		//SpringApplication.run(MovieRecommenderSystemApplication.class, args);

		RecommendationImplementation implementation = new RecommendationImplementation(new CollaborativeFilter());
		String [] result = implementation.recommendMovies("Finding Dory");
		System.out.println(Arrays.toString(result));

    }
}
