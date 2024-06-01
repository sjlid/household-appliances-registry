package com.eevan.registry.repos;

import com.eevan.registry.entities.TV;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TVRepository extends JpaRepository<TV, Integer> {
}
