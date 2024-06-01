package com.eevan.registry.repos;

import com.eevan.registry.entities.Cleaner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CleanerRepository extends JpaRepository<Cleaner, Integer> {
}
