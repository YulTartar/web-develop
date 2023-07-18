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
@Table(name = "place")
@Inheritance(strategy=InheritanceType.JOINED)
public class Place extends BaseEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "place")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<Availability> availabilities;

    public Place(String name) {
        this.name = name;
        availabilities = new HashSet<Availability>();
    }

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "type", length = 16)
    private String type;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "employees", length = 255)
    private int employees;

    @Column(name = "space", length = 255)
    private int space;


    @Override
    public String toString() {
        return "Place { id=" + id + ", name=" + name + ", capacity=" + capacity + ", type=" + type +
                ", address=" + address + ", employees=" + employees + ", space" + space +" }";
    }
}
