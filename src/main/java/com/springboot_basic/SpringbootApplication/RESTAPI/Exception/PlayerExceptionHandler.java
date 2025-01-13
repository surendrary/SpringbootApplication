package com.springboot_basic.SpringbootApplication.RESTAPI.Exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class PlayerExceptionHandler {

    @ExceptionHandler // This is specific of PlayerNotFoundException
    public ResponseEntity<PlayerErrorResponse> playerNotFoundHandler (
            PlayerNotFoundException exception,
            HttpServletRequest req) {

        PlayerErrorResponse error = new PlayerErrorResponse(ZonedDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                req.getRequestURI(),
                exception.getMessage()
        );
        return new ResponseEntity<> (error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler // Applies to all other Exception except PlayerNotFoundException
    public ResponseEntity<PlayerErrorResponse> genericHandler (
            Exception ex,
            HttpServletRequest req){

        PlayerErrorResponse error = new PlayerErrorResponse(
                ZonedDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                req.getRequestURI(),
                ex.getMessage());

        return new ResponseEntity<> (error, HttpStatus.BAD_REQUEST);
    }
}
