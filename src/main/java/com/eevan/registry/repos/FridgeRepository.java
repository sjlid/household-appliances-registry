package com.eevan.registry.repos;

import com.eevan.registry.entities.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FridgeRepository extends JpaRepository<Fridge, Integer> {
}
