package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "availability")
public class Availability extends BaseEntity {
    @Column(name = "count")
    private int count;

    @ManyToOne(optional = false)
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable=false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Group group;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subgroup_id", referencedColumnName = "id", nullable=false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private SubGroup subgroup;

    @Override
    public String toString() {
        return "Availability { id=" + id + ", count=" + count + " }";
    }
}
