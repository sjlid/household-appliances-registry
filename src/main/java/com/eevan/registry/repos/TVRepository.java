package com.eevan.registry.repos;

import com.eevan.registry.entities.TV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TVRepository extends JpaRepository<TV, Integer> {
}
