package com.eevan.registry.repos;

import com.eevan.registry.entities.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FridgeRepository extends JpaRepository<Fridge, Integer> {
}
