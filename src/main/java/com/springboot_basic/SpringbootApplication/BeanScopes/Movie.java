package com.springboot_basic.SpringbootApplication.BeanScopes;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ScopedProxyMode;

@Component
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) : This Shows that prototype bean cannot be injected in SingleTon as of Yet so Proxy needs be used as below
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Movie {

    private static int instanceCounter = 0;

    private String name;
    private int id;
    private String genre;
    private String director;

    public Movie(){
        instanceCounter++;
        System.out.println("Movie Constructor called");
    }

    public static int getInstances() {
        return Movie.instanceCounter;
    }

}
