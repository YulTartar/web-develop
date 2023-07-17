package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.PlaceDto;
import com.example.springdatabasicdemo.dtos.AvailabilityDto;
import com.example.springdatabasicdemo.dtos.SubGroupDto;
import com.example.springdatabasicdemo.services.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private AvailabilityService availabilityService;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void printAllAvailabilityByPlaceName(String placeName) {
        availabilityService
                .findAvalabilitysByPlace(placeName)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        //Добавление в БД записей
        PlaceDto p1 = new PlaceDto(0,"UVP-211");
        PlaceDto p2 = new PlaceDto(0,"UVP-212");

        SubGroupDto s1 = new SubGroupDto(0,"MIIT");
        SubGroupDto s2 = new SubGroupDto(0,"Subway");

        AvailabilityDto a1 = new AvailabilityDto(0, 10, p1, s1);
        AvailabilityDto a2 = new AvailabilityDto(0, 15, p2, s2);

        a1 = availabilityService.register(a1);
        a2 = availabilityService.register(a2);

        printAllAvailabilityByPlaceName("UVP-212");

        // studentService.transfer(s1, s2.getGroup());

        printAllAvailabilityByPlaceName("UVP-212");
    }
}
