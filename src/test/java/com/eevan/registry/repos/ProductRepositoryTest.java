package com.eevan.registry.repos;

import com.eevan.registry.entities.Cleaner;
import com.eevan.registry.entities.Product;
import com.eevan.registry.entities.ProductFamily;
import com.eevan.registry.util.DataUtils;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductFamilyRepository productFamilyRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void addNewProductCleaner() {
        //given
        ProductFamily productFamilyToSave = DataUtils.getProductFamilyTransient();
        ProductFamily savedProductFamily = productFamilyRepository.save(productFamilyToSave);


        //when


        //then
    }

    @Test
    public void getByModelNameAllIgnoreCaseContaining() {
    }

    @Test
    public void getProductsByName() {
    }
}