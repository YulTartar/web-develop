package com.example.springdatabasicdemo.controllers.goods;

import com.example.springdatabasicdemo.dtos.GoodsDto;
import com.example.springdatabasicdemo.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goods")
    Iterable<GoodsDto> all() {
        return goodsService.getAll();
    }

    @PostMapping("/goods")
    GoodsDto newGoods(@RequestBody GoodsDto newGoods) {  return goodsService.register(newGoods); }

    @GetMapping("/goods/{id}")
    GoodsDto one(@PathVariable Integer id) throws Throwable {

        return null;
    }

    @DeleteMapping("/goods/{id}")
    void deleteGoods(@PathVariable Integer id) {
        goodsService.expel(id);
    }
}
