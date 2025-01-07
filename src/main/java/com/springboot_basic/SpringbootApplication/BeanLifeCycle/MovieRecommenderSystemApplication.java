package com.springboot_basic.SpringbootApplication.BeanLifeCycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {


		ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);
		RecommendationImplementation recommender = appContext.getBean(RecommendationImplementation.class);
		System.out.println(recommender);
    }
}
