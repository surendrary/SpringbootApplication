package com.springboot_basic.SpringbootApplication.BeansAndDependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecommendationImplementation {

    @Autowired
    private Filter filter;

    /*
       private Filter ContentBasedFilter;
       This is known as Autowiring by Name
     */

    /*
     @Qualifier("CBF")  : Injecting beans using Qualifier criteria
     private Filter filter;
     */
    public RecommendationImplementation(Filter filter) {
        super();
        this.filter = filter;
    }

    public String [] recommendMovies (String movie) {

        //print the name of interface implementation being used
        System.out.println("Name of the filter in use: " + filter + "\n");
        String[] results = filter.getRecommendations("Finding Dory");
        return results;
    }
}


