package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.GoodsDto;

import java.util.List;
import java.util.Optional;

public interface GoodsService<ID> {

    GoodsDto register(GoodsDto goods);

    void expel(GoodsDto goods);

    void expel(ID id);
    Optional<GoodsDto> findGoods(ID id);


   // GoodsDto findAvailabilityByGoodsName(String goodsName);

    List<GoodsDto> getAll();
}

