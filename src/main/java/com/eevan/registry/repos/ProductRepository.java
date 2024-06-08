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

    /*
    @Query("SELECT p FROM Product p WHERE p.modelName LIKE %?1% OR p.productFamily.familyName LIKE %?2%")
    List<Product> findByModelNameOrProductFamilyFamilyNameAllIgnoreCaseContaining(String modelName, String familyName);
     */

}
