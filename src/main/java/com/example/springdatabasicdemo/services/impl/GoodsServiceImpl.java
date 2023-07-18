package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.GoodsDto;
import com.example.springdatabasicdemo.dtos.PlaceDto;
import com.example.springdatabasicdemo.models.Goods;
import com.example.springdatabasicdemo.repositories.AvailabilityRepository;
import com.example.springdatabasicdemo.repositories.GoodsRepository;
import com.example.springdatabasicdemo.services.GoodsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GoodsServiceImpl implements GoodsService<Integer> {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GoodsDto register(GoodsDto goods) {
        Goods g = modelMapper.map(goods, Goods.class);
        return modelMapper.map(goodsRepository.save(g), GoodsDto.class);
    }

    @Override
    public void expel(GoodsDto goods) {
        goodsRepository.deleteById(goods.getId());
    }

    @Override
    public void expel(Integer id) {
        goodsRepository.deleteById(id);
    }

    @Override
    public Optional<GoodsDto> findGoods(Integer id) {
        return Optional.ofNullable(modelMapper.map(goodsRepository.findById(id), GoodsDto.class));
    }

    @Override
    public List<GoodsDto> findBadGoods() {
        return goodsRepository.findBadGoods().stream().map((s) -> modelMapper.map(s, GoodsDto.class)).collect(Collectors.toList());
    }
    /*
    @Override
    public List<PlaceDto> findPlacesByGoodsId(int id) {
        System.out.println(findPlacesByGoodsId(id));
        return availabilityRepository.findAllPlaceByGoodsId(id).stream().map((s) -> modelMapper.map(s, PlaceDto.class)).collect(Collectors.toList());
    }
    */
    @Override
    public List<GoodsDto> getAll() {
        return goodsRepository.findAll().stream().map((s) -> modelMapper.map(s, GoodsDto.class)).collect(Collectors.toList());
    }
}
