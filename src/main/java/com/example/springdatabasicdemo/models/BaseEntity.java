package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.dtos.BrandDTO;
import jakarta.persistence.*;

import java.util.List;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }


}
