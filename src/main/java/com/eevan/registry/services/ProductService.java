package com.eevan.registry.services;

import com.eevan.registry.entities.Product;
import com.eevan.registry.repos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    @Transactional(readOnly = true)
    public List<Product> getAllProductsWithSortingByAlphabet(String direction) {
        Sort sort = Sort.by("modelName");

        if ("asc".equalsIgnoreCase(direction)) {
            sort = sort.ascending();
        } else if ("desc".equalsIgnoreCase(direction)) {
            sort = sort.descending();
        } else {
            sort = sort.ascending();
        }
        return productRepository.findAll(sort);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProductsWithSortingByPrice(String direction) {
        Sort sort = Sort.by("modelPrice");

        if ("asc".equalsIgnoreCase(direction)) {
            sort = sort.ascending();
        } else if ("desc".equalsIgnoreCase(direction)) {
            sort = sort.descending();
        } else {
            sort = sort.ascending();
        }
        return productRepository.findAll(sort);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts(String modelName) {
        return productRepository.findByModelNameAllIgnoreCaseContaining(modelName);
    }

    @Transactional(readOnly = true)
    public List<Product> getProductsByModelNameOrFamilyName(String searchValue) {
        return productRepository.findProductsByName(searchValue);
    }
}
