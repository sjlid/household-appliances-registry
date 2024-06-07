package com.eevan.registry.repos;

import com.eevan.registry.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByModelNameAllIgnoreCaseContaining(String modelName);

    @Query(value = "SELECT p FROM Product p JOIN ProductFamily f ON p.family_id = f.id WHERE p.modelName = ?1 OR f.familyName = ?1", nativeQuery = true)
    List<Product> findProductsByModelNameOrFamilyNameAllIgnoreCaseContaining(String searchValue);
}
