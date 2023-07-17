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
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable=false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Place place;

    @ManyToOne(optional = false)
    @JoinColumn(name = "goods_id", referencedColumnName = "id", nullable=false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Goods goods;

    @Override
    public String toString() {
        return "Availability { id=" + id + ", count=" + count + " }";
    }
}
