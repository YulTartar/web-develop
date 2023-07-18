package com.example.springdatabasicdemo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "storage")
public class Storage extends Place {

    @Column(name = "car")
    private int level;


    @Override
    public String toString() {
        return "Level { id=" + id + ", level=" + level + " }";
    }
}
