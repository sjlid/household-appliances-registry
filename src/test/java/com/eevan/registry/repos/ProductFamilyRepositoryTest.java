package com.eevan.registry.repos;

import com.eevan.registry.entities.ProductFamily;
import com.eevan.registry.util.DataUtils;
import com.eevan.registry.utils.ProductFamilyNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        ProductFamily productFamilyToSave = DataUtils.getProductFamilyTransient();

        //when
        ProductFamily savedProductFamily = productFamilyRepository.save(productFamilyToSave);

        //then
        assertThat(savedProductFamily).isNotNull();
        assertThat(savedProductFamily.getId()).isNotNull();
    }

    @Test
    @DisplayName("Test get product family by id functionality")
    public void givenProductFamilyCreated_whenGetById_thenProductFamilyIsReturned() {
        //given
        ProductFamily productFamilyToSave = DataUtils.getProductFamilyTransient();
        productFamilyRepository.save(productFamilyToSave);

        //when
        ProductFamily obtainedProductFamily = productFamilyRepository.getFamilyById(productFamilyToSave.getId());

        //then
        assertThat(obtainedProductFamily).isNotNull();
        assertThat(obtainedProductFamily.getFamilyName()).isEqualTo("UltraCool");
    }

    @Test
    @DisplayName("Test when family is not created")
    public void givenProductFamilyIsNotCreated_whenGetById_thenOptionalIsEmpty() {
        //given

        //when

        //then
        assertThatThrownBy(
                () -> {
                    ProductFamily obtainedProductFamily = productFamilyRepository.getFamilyById(2);
                }
        ).isInstanceOf(ProductFamilyNotFoundException.class);
    }
}