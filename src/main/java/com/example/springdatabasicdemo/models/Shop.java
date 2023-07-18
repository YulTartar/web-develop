package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "shop")
public class Shop extends Place {

    @Column(name = "level", length = 50, nullable = false)
    private String level;

    @Column(name = "rating")
    private int rating;

    @Override
    public String toString() {
        return "Level { id=" + id + ", level=" + level + ", rating=" + rating + " }";
    }
}
