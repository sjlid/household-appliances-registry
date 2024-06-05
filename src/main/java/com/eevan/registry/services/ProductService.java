package com.eevan.registry.services;

import com.eevan.registry.entities.Cleaner;
import com.eevan.registry.entities.Product;
import com.eevan.registry.repos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    @Transactional(readOnly = true)
    public List<Product> getAllProductsWithSorting(String field, String direction) {
        Sort sort = Sort.by(field);

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
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProductsWithSortingUp(String field) {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, field));
    }

}
