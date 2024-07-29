package com.eevan.registry.repos;

import com.eevan.registry.entities.ProductFamily;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProductFamilyRepositoryTest {

    @Autowired
    private ProductFamilyRepository productFamilyRepository;

    @BeforeEach
    public void setUp() {
        productFamilyRepository.deleteAll();
    }

    @Test
    @DisplayName("Test save product family functionality")
    public void givenProductFamilyObject_whenSave_thenProductFamilyIsCreated() {
        //given
        ProductFamily productFamilyToSave = ProductFamily.builder()
                .familyName("UltraCool")
                .countryManufacturer("Russia")
                .companyManufacturer("ZiL")
                .isAbleToBuyOnline(true)
                .isAbleToInstallment(false)
                .availableProducts(0)
                .productType("FRIDGE")
                .build();

        //when
        ProductFamily savedProductFamily = productFamilyRepository.save(productFamilyToSave);

        //then
        assertThat(savedProductFamily).isNotNull();
        assertThat(savedProductFamily.getId()).isNotNull();
    }
}