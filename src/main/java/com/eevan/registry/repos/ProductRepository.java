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


    @Query("SELECT DISTINCT p FROM Product p WHERE LOWER(p.modelName) LIKE ?1% OR LOWER(p.productFamily.familyName) LIKE ?1%")
    List<Product> findProductsByName(String searchValue);
}
