package com.springboot_basic.SpringbootApplication.BeanScopes;

import com.springboot_basic.SpringbootApplication.BeanScopes.ContentBasedFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.Arrays;

@SpringBootApplication

// ComponentScan is used to scan specific packages for beans
// @ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION))

public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {


		ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);


		ContentBasedFilter cft = appContext.getBean(ContentBasedFilter.class);
		System.out.println("\nContentBasedFilter bean with singleton scope");
		System.out.println(cft);

		Movie movie = cft.getMovie();
		Movie movie1 = cft.getMovie();
		Movie movie2 = cft.getMovie();

		System.out.println("\nMovie bean with prototype scope");
		System.out.println(movie);
		System.out.println(movie1);
		System.out.println(movie2);

		System.out.println("\nContentBasedFilter instances created: " + ContentBasedFilter.getInstances());
		System.out.println("Movie instances created: "+ Movie.getInstances());


    }
}
