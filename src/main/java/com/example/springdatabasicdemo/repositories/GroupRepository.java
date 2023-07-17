package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
}
