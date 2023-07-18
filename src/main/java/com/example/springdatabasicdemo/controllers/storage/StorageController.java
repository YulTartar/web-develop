package com.example.springdatabasicdemo.controllers.storage;

import com.example.springdatabasicdemo.dtos.StorageDto;
import com.example.springdatabasicdemo.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping("/storage")
    Iterable<StorageDto> all() {
        return storageService.getAll();
    }

    @PostMapping("/storage")
    StorageDto newStorage(@RequestBody StorageDto newStorage) {  return storageService.register(newStorage); }

    @GetMapping("/storage/{id}")
    StorageDto one(@PathVariable Integer id) throws Throwable {

        return (StorageDto) storageService.findStorage(id)
                .orElseThrow(() -> new StorageNotFoundException(id));
    }

    @GetMapping("/storage/findByCapacity/{capacity}")
    Iterable<StorageDto> findByCapacity(@PathVariable Integer capacity) throws Throwable {
        List<StorageDto> storageList = storageService.findStorageByCapacity(capacity);
        if (storageList.isEmpty()) {
            throw new StorageNotFoundException();
        }
        return storageList;
    }

    @DeleteMapping("/storage/{id}")
    void deleteStorage(@PathVariable Integer id) {
        storageService.expel(id);
    }
}
