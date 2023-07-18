package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Place;
import com.example.springdatabasicdemo.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
