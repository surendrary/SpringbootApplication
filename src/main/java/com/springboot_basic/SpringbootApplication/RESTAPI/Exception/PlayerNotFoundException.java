package com.springboot_basic.SpringbootApplication.RESTAPI.Exception;

public class PlayerNotFoundException extends RuntimeException{

    public PlayerNotFoundException() {
        super();
    }

    public PlayerNotFoundException(String message) {
        super(message);
    }

    public PlayerNotFoundException(Throwable cause) {
        super(cause);
    }
}
