package com.eevan.registry.utils;

public class ProductNotCreatedException extends RuntimeException {
    public ProductNotCreatedException(String message) {
        super(message);
    }
}