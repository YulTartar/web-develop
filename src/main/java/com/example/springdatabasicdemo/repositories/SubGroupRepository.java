package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.SubGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubGroupRepository extends JpaRepository<SubGroup, Integer> {
}
