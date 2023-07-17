package com.example.springdatabasicdemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GoodsDto {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Goods { id=" + id + ", name=" + name + " }";
    }
}
