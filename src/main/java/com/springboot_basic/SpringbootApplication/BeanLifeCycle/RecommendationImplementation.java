package com.springboot_basic.SpringbootApplication.BeanLifeCycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class RecommendationImplementation {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    private Filter filter;

    //@Autowired

    @Inject // Part of CDI  -works like Autowired
    public void setFilter(Filter filter) {
        logger.info("In RecommendationImplementation setter method..dependency injection");
        this.filter = filter;
    }

    @PostConstruct // Method is called after bean/dependency bean  is loaded
    public void postConstruct() {
        //initialization code goes here
        logger.info("In RecommendationImplementation postConstruct method");
    }

    @PreDestroy // Method is called before the bean is removed from Spring Container
    public void preDestroy() {
        //cleanup code
        logger.info("In RecommenderImplementation preDestroy method");
    }

    public String [] recommendMovies (String movie) {

        //print the name of interface implementation being used
        System.out.println("Name of the filter in use: " + filter + "\n");
        String[] results = filter.getRecommendations("Finding Dory");
        return results;
    }
}


