package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.PlaceDto;

import java.util.List;
import java.util.Optional;

public interface PlaceService<ID> {

    PlaceDto register(PlaceDto place);

    void expel(PlaceDto place);

    void expel(ID id);

    Optional<PlaceDto> findPlace(Integer id);

    List<PlaceDto> getAll();

}

