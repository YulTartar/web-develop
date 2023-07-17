package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subgroups")
public class SubGroup extends BaseEntity {
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subgroup")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Availability> availabilities;

    public SubGroup(String name) {
        this.name = name;
        availabilities = new HashSet<Availability>();
    }

    // Пустой конструктор для Hibernate, обратите внимание на модификатор доступа
    protected SubGroup(){

    }

    @Column(name = "name", length = 50, nullable = false)
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Set<Availability> getStudents() {
        return availabilities;
    }

    public void setStudents(Set<Availability> availabilities) {
        this.availabilities = availabilities;
    }

    @Override
    public String toString() {
        return "Group { id=" + id + ", name=" + name + " }";
    }
}
