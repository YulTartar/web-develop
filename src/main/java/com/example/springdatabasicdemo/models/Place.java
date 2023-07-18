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
    protected String name;

    @Column(name = "capacity")
    protected int capacity;

    @Column(name = "type", length = 16)
    protected String type;

    @Column(name = "address", length = 255)
    protected String address;

    @Column(name = "employees", length = 255)
    protected int employees;

    @Column(name = "space", length = 255)
    protected int space;


    @Override
    public String toString() {
        return "Place { id=" + id + ", name=" + name + ", capacity=" + capacity + ", type=" + type +
                ", address=" + address + ", employees=" + employees + ", space" + space +" }";
    }
}
