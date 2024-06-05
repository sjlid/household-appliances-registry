package com.eevan.registry.repos;

import com.eevan.registry.entities.Cleaner;
import com.eevan.registry.entities.Fridge;
import com.eevan.registry.entities.PC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FridgeRepository extends JpaRepository<Fridge, Long> {
}
