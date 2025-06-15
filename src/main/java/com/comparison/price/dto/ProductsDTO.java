package com.comparison.price.dto;

import java.util.List;

public class ProductsDTO {
    private List<ProductDTO> products;

    // Getters and Setters
    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}