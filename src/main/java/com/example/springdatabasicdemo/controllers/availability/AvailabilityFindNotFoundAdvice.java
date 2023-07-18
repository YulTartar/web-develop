package com.example.springdatabasicdemo.controllers.availability;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AvailabilityFindNotFoundAdvice extends Throwable {
    @ResponseBody
    @ExceptionHandler(AvailabilityFindNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String availabilityNotFoundHandler(AvailabilityFindNotFoundException ex) {
        return ex.getMessage();
    }
}