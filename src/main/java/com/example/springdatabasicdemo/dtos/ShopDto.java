package com.example.springdatabasicdemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShopDto {
    private int id;
    private String name;
    private String level;

    @Override
    public String toString() {
        return "Shop { id=" + id + ", level=" + level + " }";
    }
}
