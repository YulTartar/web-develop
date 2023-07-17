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

    @Override
    public String toString() {
        return "Place { id=" + id + ", name=" + name + " }";
    }
}
