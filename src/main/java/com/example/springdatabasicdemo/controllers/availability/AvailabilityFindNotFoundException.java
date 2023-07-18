package com.example.springdatabasicdemo.controllers.availability;

class AvailabilityFindNotFoundException extends RuntimeException {
    AvailabilityFindNotFoundException() {
        super("Could not find availability :(");
    }
}