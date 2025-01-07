package com.springboot_basic.SpringbootApplication.LOOSECOUPLING;

public class RecommendationImplementation {

    private Filter filter;

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


