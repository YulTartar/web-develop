package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.GoodsDto;
import com.example.springdatabasicdemo.dtos.AvailabilityDto;
import com.example.springdatabasicdemo.models.Place;
import com.example.springdatabasicdemo.models.Availability;
import com.example.springdatabasicdemo.models.Goods;
import com.example.springdatabasicdemo.repositories.PlaceRepository;
import com.example.springdatabasicdemo.repositories.GoodsRepository;
import com.example.springdatabasicdemo.repositories.AvailabilityRepository;
import com.example.springdatabasicdemo.services.AvailabilityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AvailabilityServiceImpl implements AvailabilityService<Integer> {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private GoodsRepository GoodsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AvailabilityDto register(AvailabilityDto avalability) {
        Availability s = modelMapper.map(avalability, Availability.class);
        if (avalability.getPlace().getId() != 0) {
            Place g = placeRepository.findById(avalability.getPlace().getId()).get();
            s.setPlace(g);
        }
        if (avalability.getGoods().getId() != 0) {
            Goods g = GoodsRepository.findById(avalability.getGoods().getId()).get();
            s.setGoods(g);
        }
        return modelMapper.map(availabilityRepository.save(s), AvailabilityDto.class);
    }

    @Override
    public void expel(AvailabilityDto avalability) {
        availabilityRepository.deleteById(avalability.getId());
    }

    @Override
    public void expel(Integer id) {
        availabilityRepository.deleteById(id);
    }

    @Override
    public Optional<AvailabilityDto> findAvalability(Integer id) {
        return Optional.ofNullable(modelMapper.map(availabilityRepository.findById(id), AvailabilityDto.class));
    }

    @Override
    public List<AvailabilityDto> getAll() {
        return availabilityRepository.findAll().stream().map((s) ->
                modelMapper.map(s, AvailabilityDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<AvailabilityDto> findAllbyDate(java.sql.Date currentDate) {
        return availabilityRepository.findByDateDeliveryGreaterThan(currentDate).stream().map((s) ->
                modelMapper.map(s, AvailabilityDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<AvailabilityDto> findAvalabilitysByPlace(String place) {
        return availabilityRepository.findAllByPlaceName(place).stream().map((s) -> modelMapper.map(s, AvailabilityDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<AvailabilityDto> findAllByPlaceId(int id) {
        return availabilityRepository.findAllByPlaceId(id).stream().map((s) -> modelMapper.map(s, AvailabilityDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<GoodsDto> findGoodsByPlaceName(String placeName) {
        return availabilityRepository.findGoodsByPlaceName(placeName).stream().map((s) ->
                modelMapper.map(s, GoodsDto.class)).collect(Collectors.toList());
    }
}