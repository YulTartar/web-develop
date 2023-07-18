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
    private int capacity;
    private String type;
    private String address;
    private int employees;
    private int space;
    private String level;
    private int rating;

    @Override
    public String toString() {
        return "Shop { id=" + id + ", name=" + name + ", capacity=" + capacity + ", type=" + type +
                ", address=" + address + ", employees=" + employees + ", space" + space + ", level=" + level + ", rating=" + rating + " }";
    }
}
