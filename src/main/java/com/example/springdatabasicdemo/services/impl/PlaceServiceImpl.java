package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.PlaceDto;
import com.example.springdatabasicdemo.models.Place;
import com.example.springdatabasicdemo.repositories.PlaceRepository;
import com.example.springdatabasicdemo.services.PlaceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaceServiceImpl implements PlaceService<Integer> {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PlaceDto register(PlaceDto place) {
        Place p = modelMapper.map(place, Place.class);
        return modelMapper.map(placeRepository.save(p), PlaceDto.class);
    }

    @Override
    public void expel(PlaceDto goods) {
        placeRepository.deleteById(goods.getId());
    }

    @Override
    public void expel(Integer id) {
        placeRepository.deleteById(id);
    }
    /*
    @Override
    public PlaceDto findPlace(Integer id) {
        return modelMapper.map(placeRepository.findById(id), PlaceDto.class);
    }
    */

    @Override
    public Optional<PlaceDto> findPlace(Integer id) {
        return Optional.ofNullable(modelMapper.map(placeRepository.findById(id), PlaceDto.class));
    }

    @Override
    public List<PlaceDto> getAll() {
        return placeRepository.findAll().stream().map((p) -> modelMapper.map(p, PlaceDto.class)).collect(Collectors.toList());
    }
}