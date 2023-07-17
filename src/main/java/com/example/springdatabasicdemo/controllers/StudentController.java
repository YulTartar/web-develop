package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.AvailabilityDto;
import com.example.springdatabasicdemo.services.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private AvailabilityService availabilityService;

    @GetMapping("/students")
    Iterable<AvailabilityDto> all() {
        return availabilityService.getAll();
    }

    @PostMapping("/students")
    AvailabilityDto newStudent(@RequestBody AvailabilityDto newStudent) {  return availabilityService.register(newStudent); }

    @GetMapping("/students/{id}")
    AvailabilityDto one(@PathVariable Integer id) throws Throwable {

        return (AvailabilityDto) availabilityService.findAvalability(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Integer id) {
        availabilityService.expel(id);
    }
}
