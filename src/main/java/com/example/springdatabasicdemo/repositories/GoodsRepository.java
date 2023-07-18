package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    @Query("SELECT g FROM Goods g WHERE g.expirationDate < CURRENT_DATE")
    List<Goods> findBadGoods();
}
