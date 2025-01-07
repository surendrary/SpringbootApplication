package com.springboot_basic.SpringbootApplication.BeanLifeCycle;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
@Named // It is part of CDI (Contexts and Dependency Injection framework)
// works like @Component
public class ContentBasedFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public ContentBasedFilter() {
        super();
        logger.info("In ContentBasedFilter constructor method");
    }

    @PostConstruct
    private void postConstruct() {
        //load movies into cache
        logger.info("In ContentBasedFilter postConstruct method");
    }
    public String[] getRecommendations(String movie) {
        //logic of content based filter
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
    }
}
