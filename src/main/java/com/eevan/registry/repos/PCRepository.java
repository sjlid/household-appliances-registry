package com.eevan.registry.repos;

import com.eevan.registry.entities.PC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PCRepository extends JpaRepository<PC, Integer> {
}
