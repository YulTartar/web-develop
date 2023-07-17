package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.AvailabilityDto;
import com.example.springdatabasicdemo.services.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    @GetMapping("/availability")
    Iterable<AvailabilityDto> all() {
        return availabilityService.getAll();
    }

    @PostMapping("/availability")
    AvailabilityDto newStudent(@RequestBody AvailabilityDto newAvailability) {  return availabilityService.register(newAvailability); }

    @GetMapping("/availability/{id}")
    AvailabilityDto one(@PathVariable Integer id) throws Throwable {

        return (AvailabilityDto) availabilityService.findAvalability(id)
                .orElseThrow(() -> new AvailabilityNotFoundException(id));
    }

    @DeleteMapping("/availability/{id}")
    void deleteStudent(@PathVariable Integer id) {
        availabilityService.expel(id);
    }
}
