package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {
    List<Availability> findAllByPlaceName(String groupName);
}
