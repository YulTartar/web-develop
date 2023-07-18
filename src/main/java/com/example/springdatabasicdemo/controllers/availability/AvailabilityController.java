package com.example.springdatabasicdemo.controllers.availability;

import com.example.springdatabasicdemo.dtos.AvailabilityDto;
import com.example.springdatabasicdemo.dtos.GoodsDto;
import com.example.springdatabasicdemo.dtos.StorageDto;
import com.example.springdatabasicdemo.services.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    @GetMapping("/availability")
    Iterable<AvailabilityDto> all() {
        return availabilityService.getAll();
    }

    @PostMapping("/availability")
    AvailabilityDto newAvailability(@RequestBody AvailabilityDto newAvailability) {  return availabilityService.register(newAvailability); }

    @GetMapping("/availability/{id}")
    AvailabilityDto one(@PathVariable Integer id) throws Throwable {

        return (AvailabilityDto) availabilityService.findAvalability(id)
                .orElseThrow(() -> new AvailabilityNotFoundException(id));
    }

    @GetMapping("/availability/date/{date}")
    Iterable<StorageDto> findByDate(@PathVariable String date) throws Throwable {
        LocalDate localDate = LocalDate.parse(date);
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        List<StorageDto> storageList = availabilityService.findAllbyDate(sqlDate);
        if (storageList.isEmpty()) {
            throw new AvailabilityNotFoundException();
        }
        return storageList;
    }

    @GetMapping("/place/goods/{name}")
    Iterable<GoodsDto> placeNameByGoods(@PathVariable String name) throws Throwable {
        List<GoodsDto> goodsList = availabilityService.findGoodsByPlaceName(name);
        if (goodsList.isEmpty()) {
            throw new AvailabilityNotFoundException();
        }
        return goodsList;
    }

    @DeleteMapping("/availability/{id}")
    void deleteStudent(@PathVariable Integer id) {
        availabilityService.expel(id);
    }
}
