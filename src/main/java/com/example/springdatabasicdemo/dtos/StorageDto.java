package com.example.springdatabasicdemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StorageDto {
    private int id;
    private String name;
    private int car;

    @Override
    public String toString() {
        return "Shop { id=" + id + ", car=" + car + " }";
    }
}
