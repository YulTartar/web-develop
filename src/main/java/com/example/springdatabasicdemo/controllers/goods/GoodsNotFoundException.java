package com.example.springdatabasicdemo.controllers.goods;

class GoodsNotFoundException extends RuntimeException {
    GoodsNotFoundException(Integer id) {
        super("Could not find goods " + id);
    }
}