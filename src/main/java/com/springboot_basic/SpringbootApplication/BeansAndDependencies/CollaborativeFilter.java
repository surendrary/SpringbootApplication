package com.springboot_basic.SpringbootApplication.BeansAndDependencies;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;



/*
 @Primary : Autowired by Type when more than one bean has same type
 */

/*

@Component
@Qualifier("CBF") : Autowired based on some qualifying criteria

 */
@Component
@Primary
public class CollaborativeFilter implements Filter {
    public String[] getRecommendations(String movie) {
        //logic of collaborative filter
        return new String[] {"Finding Nemo", "Ice Age", "Toy Story"};
    }
}
