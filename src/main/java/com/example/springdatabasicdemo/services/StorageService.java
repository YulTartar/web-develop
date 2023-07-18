package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.StorageDto;

import java.util.List;
import java.util.Optional;

public interface StorageService<ID> {

    StorageDto register(StorageDto storage);

    void expel(StorageDto storage);

    void expel(ID id);

    Optional<StorageDto> findStorage(ID id);

    List<String> findStorageNameByCapacity(int capacity);

    List<StorageDto> getAll();

}

