package com.example.springdatabasicdemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AvailabilityDto {

    private int id;
    private int count;
    private GroupDto group;
    private SubGroupDto subgroup;

    @Override
    public String toString() {
        return "Availability { id=" + id + ", count=" + count + " }";
    }
}
