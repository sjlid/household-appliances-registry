package com.eevan.registry.repos;

import com.eevan.registry.entities.Cleaner;
import com.eevan.registry.entities.Product;
import com.eevan.registry.entities.ProductFamily;
import com.eevan.registry.util.DataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductFamilyRepository productFamilyRepository;

    @BeforeEach
    public void setUp() {
        productRepository.deleteAll();
        productFamilyRepository.deleteAll();
    }

    @Test
    public void addNewProductCleaner() {
        //given
        ProductFamily productFamilyToSave = DataUtils.getProductFamilyTransient();
        ProductFamily savedProductFamily = productFamilyRepository.save(productFamilyToSave);
        Product productToAdd = Cleaner.builder()
                .modelWorkModes("3")
                .modelVolume(4.5f)
                .productFamily(savedProductFamily)
                .productType("CLEANER")
                .modelName("AirMax")
                .modelSerialNumber("1q2w3e")
                .modelColor("Red")
                .modelSize("100x100")
                .modelPrice(BigDecimal.valueOf(15600))
                .modelAvailability(true)
                .build();

        //when
        Product savedProductCleaner = productRepository.save(productToAdd);

        //then
        assertThat(savedProductCleaner).isNotNull();
        assertThat(savedProductCleaner.getId()).isNotNull();
    }
}