package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.services.AvailabilityService;
import com.example.springdatabasicdemo.services.PlaceService;
import com.example.springdatabasicdemo.services.ShopService;
import com.example.springdatabasicdemo.services.StorageService;
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
    private StorageService storageService;

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
        ShopDto s1 = new ShopDto(0, "Apax", 3, "SHOP", "Одинцово", 300, 50, "Постамат", 5);
        StorageDto s2 = new StorageDto(0, "Пром", 3, "STORAGE", "Владивосток", 500, 50, 15, 5);

        shopService.register(s1);
        storageService.register(s2);

        System.out.println(placeService.findPlace(1).get());
        System.out.println(placeService.findPlace(1).get());

        Optional<PlaceDto> pO1 = placeService.findPlace(1);
        Optional<PlaceDto> pO2 = placeService.findPlace(2);

        PlaceDto p1 = pO1.get();
        PlaceDto p2 = pO2.get();

        GoodsDto g1 = new GoodsDto(0,"MIIT","хавоший", "7878", "7878", "тип", "7878");
        GoodsDto g2 = new GoodsDto(0,"Subway","чудесный", "75578", "55", "тип2", "555");

        AvailabilityDto a1 = new AvailabilityDto(0, 10, p1, g1);
        AvailabilityDto a2 = new AvailabilityDto(0, 15, p2, g2);

        a1 = availabilityService.register(a1);
        a2 = availabilityService.register(a2);

        printAllAvailabilityByPlaceName("UVP-212");

        // studentService.transfer(s1, s2.getGroup());

        printAllAvailabilityByPlaceName("UVP-212");

    }
}
