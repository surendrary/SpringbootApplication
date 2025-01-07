package com.springboot_basic.SpringbootApplication.TIGHTCOUPLING;

public class ContentBasedFilter {
    public String[] getRecommendations(String movie) {
        //logic of content based filter
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
    }
}
