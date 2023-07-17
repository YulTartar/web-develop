package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.GroupDto;
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

    private void printAllAvailabilityByGroupName(String groupName) {
        availabilityService
                .findAvalabilitysByGroup(groupName)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        //Добавление в БД записей
        GroupDto g1 = new GroupDto(0,"UVP-211");
        GroupDto g2 = new GroupDto(0,"UVP-212");

        SubGroupDto p1 = new SubGroupDto(0,"MIIT");
        SubGroupDto p2 = new SubGroupDto(0,"Subway");

        AvailabilityDto s1 = new AvailabilityDto(0, 10, g1, p1);
        AvailabilityDto s2 = new AvailabilityDto(0, 15, g2, p2);

        s1 = availabilityService.register(s1);
        s2 = availabilityService.register(s2);

        printAllAvailabilityByGroupName("UVP-212");

        // studentService.transfer(s1, s2.getGroup());

        printAllAvailabilityByGroupName("UVP-212");
    }
}
