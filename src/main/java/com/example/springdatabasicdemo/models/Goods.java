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
@Table(name = "goods")
public class Goods extends BaseEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "goods")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Availability> availabilities;

    public Goods(String name) {
        this.name = name;
        availabilities = new HashSet<Availability>();
    }

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "OKPD")
    private String OKPD;

    @Column(name = "OKVED")
    private String OKVED;

    @Column(name = "type_barcode", length = 255)
    private String typeBarcode;

    @Column(name = "barcode", length = 20)
    private String barcode;


    @Override
    public String toString() {
        return "Goods { id=" + id + ", name=" + name + ", description=" + description + ", OKPD=" + OKPD + ", OKVED=" + OKVED
        + ", type_barcode=" + typeBarcode + ", barcode=" + barcode + " }";
    }
}

