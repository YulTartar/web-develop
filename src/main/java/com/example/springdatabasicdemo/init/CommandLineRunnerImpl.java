package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.PlaceDto;
import com.example.springdatabasicdemo.dtos.AvailabilityDto;
import com.example.springdatabasicdemo.dtos.GoodsDto;
import com.example.springdatabasicdemo.dtos.ShopDto;
import com.example.springdatabasicdemo.services.AvailabilityService;
import com.example.springdatabasicdemo.services.PlaceService;
import com.example.springdatabasicdemo.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private PlaceService placeService;

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
        ShopDto s1 = new ShopDto(0,"UVP-211", "Постамат");
        ShopDto s2 = new ShopDto(0,"UVP-212", "Постамат");

        shopService.register(s1);
        shopService.register(s2);

        System.out.println(placeService.findPlace(1).get());
        System.out.println(placeService.findPlace(1).get());

        Optional<PlaceDto> pO1 = placeService.findPlace(1);
        Optional<PlaceDto> pO2 = placeService.findPlace(2);

        PlaceDto p1 = pO1.get();
        PlaceDto p2 = pO2.get();

        GoodsDto g1 = new GoodsDto(0,"MIIT");
        GoodsDto g2 = new GoodsDto(0,"Subway");

        AvailabilityDto a1 = new AvailabilityDto(0, 10, p1, g1);
        AvailabilityDto a2 = new AvailabilityDto(0, 15, p2, g2);

        a1 = availabilityService.register(a1);
        a2 = availabilityService.register(a2);

        printAllAvailabilityByPlaceName("UVP-212");

        // studentService.transfer(s1, s2.getGroup());

        printAllAvailabilityByPlaceName("UVP-212");

    }
}
