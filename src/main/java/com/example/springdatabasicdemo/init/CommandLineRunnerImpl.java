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

    @Autowired
    private PlaceService goodsService;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() throws IOException {
        //Добавление в БД записей
        ShopDto s1 = new ShopDto(0, "Apax", 3, "SHOP", "Одинцово", 300, 50, "Постамат", 5);
        StorageDto s2 = new StorageDto(0, "Пром", 1000, "STORAGE", "Владивосток", 500, 50, 15, 5);
        StorageDto s3 = new StorageDto(0, "Склад Фруктового райа", 500, "STORAGE", "Московская обл., г. Сергиев Посад, ул. Цветочная, дом 7", 4000, 25, 800, 7);

        shopService.register(s1);
        storageService.register(s2);
        storageService.register(s3);

        System.out.println(placeService.findPlace(1).get());
        System.out.println(placeService.findPlace(1).get());

        Optional<PlaceDto> pO1 = placeService.findPlace(1);
        Optional<PlaceDto> pO2 = placeService.findPlace(2);

        PlaceDto p1 = pO1.get();
        PlaceDto p2 = pO2.get();

        GoodsDto g1 = new GoodsDto(0,"Молоко Домик в Деревне", "Свежее пастеризованное молоко", "10.55.78.123", "10.55", "EAN-8", "01234567", new java.sql.Date(127, 12, 14));
        GoodsDto g2 = new GoodsDto(0,"Морковь", "Свежие и сочные моркови", "10.50.12.005", "10.50", "EAN-13", "3256789045172", new java.sql.Date(122, 12, 14));
        GoodsDto g3 = new GoodsDto(0, "Яблоки Голден", "Сочные и сладкие яблоки сорта Голден", "10.30.19.002", "10.30", "EAN-13", "4867529130456", new java.sql.Date(100, 12, 14));

        AvailabilityDto a1 = new AvailabilityDto(0, 10, p1, g1, new java.sql.Date(121, 12, 14));
        AvailabilityDto a2 = new AvailabilityDto(0, 15, p2, g2, new java.sql.Date(121, 3, 28));
        AvailabilityDto a3 = new AvailabilityDto(0, 10, p2, g3, new java.sql.Date(122, 9, 14));

        availabilityService.register(a1);
        availabilityService.register(a2);
        availabilityService.register(a3);

        System.out.println(availabilityService.findAvalabilitysByPlace("Пром"));
    }
}
