package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer> {
}
