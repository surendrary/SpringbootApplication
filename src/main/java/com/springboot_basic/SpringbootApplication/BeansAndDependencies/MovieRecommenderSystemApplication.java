package com.springboot_basic.SpringbootApplication.BeansAndDependencies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {


		ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);


		RecommendationImplementation recommender = appContext.getBean(RecommendationImplementation.class);

		String [] result = recommender.recommendMovies("Finding Dory");
		Arrays.stream(result).forEach(System.out::println);

    }
}
