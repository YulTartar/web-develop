package com.example.springdatabasicdemo.controllers;

class StudentNotFoundException extends RuntimeException {
    StudentNotFoundException(Integer id) {
        super("Could not find student " + id);
    }
}