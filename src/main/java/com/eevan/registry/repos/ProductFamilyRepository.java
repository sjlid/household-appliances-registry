package com.eevan.registry.repos;

import com.eevan.registry.entities.ProductFamily;
import com.eevan.registry.utils.ProductFamilyNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductFamilyRepository extends JpaRepository<ProductFamily, Long> {
    default ProductFamily getFamilyById(long familyId) {
        return findById(familyId).orElseThrow(ProductFamilyNotFoundException::new);
    }
}
