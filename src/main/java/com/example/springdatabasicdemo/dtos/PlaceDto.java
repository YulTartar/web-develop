package com.example.springdatabasicdemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlaceDto {
    private int id;
    private String name;
    private int capacity;
    private String type;
    private String address;
    private int employees;
    private int space;

    @Override
    public String toString() {
        return "Place { id=" + id + ", name=" + name + " }";
    }
}
