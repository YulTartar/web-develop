package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.AvailabilityDto;
import com.example.springdatabasicdemo.dtos.ShopDto;
import com.example.springdatabasicdemo.dtos.StorageDto;
import com.example.springdatabasicdemo.models.Storage;
import com.example.springdatabasicdemo.repositories.StorageRepository;
import com.example.springdatabasicdemo.services.AvailabilityService;
import com.example.springdatabasicdemo.services.StorageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StorageServiceImpl implements StorageService<Integer> {

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StorageDto register(StorageDto storage) {
        Storage p = modelMapper.map(storage, Storage.class);
        return modelMapper.map(storageRepository.save(p), StorageDto.class);
    }

    @Override
    public void expel(StorageDto storage) {
        List<AvailabilityDto> avail = availabilityService.findAllByPlaceId(storage.getId());
        for (AvailabilityDto a : avail) {
            availabilityService.expel(a);
        }
        storageRepository.deleteById(storage.getId());
    }

    @Override
    public void expel(Integer id) {
        List<AvailabilityDto> avail = availabilityService.findAllByPlaceId(id);
        for (AvailabilityDto a : avail) {
            availabilityService.expel(a);
        }
        storageRepository.deleteById(id);
    }

    @Override
    public Optional<StorageDto> findStorage(Integer id) {
        return Optional.ofNullable(modelMapper.map(storageRepository.findById(id), StorageDto.class));
    }

    @Override
    public List<StorageDto> findStorageByCapacity(int capacity) {
        return storageRepository.findByCapacityGreaterThanEqual(capacity).stream().map((p)
                -> modelMapper.map(p, StorageDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<StorageDto> getAll() {
        return storageRepository.findAll().stream().map((p) -> modelMapper.map(p, StorageDto.class)).collect(Collectors.toList());
    }
}