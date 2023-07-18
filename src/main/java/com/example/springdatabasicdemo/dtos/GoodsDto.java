package com.example.springdatabasicdemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GoodsDto {
    private int id;
    private String name;
    private String description;
    private String OKPD;
    private String OKVED;
    private String typeBarcode;
    private String barcode;

    @Override
    public String toString() {
        return "Goods { id=" + id + ", name=" + name + ", description=" + description + ", OKPD=" + OKPD + ", OKVED=" + OKVED
                + ", type_barcode=" + typeBarcode + ", barcode=" + barcode + " }";
    }
}
