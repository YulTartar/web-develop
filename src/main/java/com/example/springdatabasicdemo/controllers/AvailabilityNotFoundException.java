package com.example.springdatabasicdemo.controllers;

class AvailabilityNotFoundException extends RuntimeException {
    AvailabilityNotFoundException(Integer id) {
        super("Could not find availability " + id);
    }
}