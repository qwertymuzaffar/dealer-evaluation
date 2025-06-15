package com.comparison.price.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.comparison.price.dto.ProductDTO;
import com.comparison.price.dto.ProductsDTO;
import com.comparison.price.util.JsonReader;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ProductService {

    private static ProductsDTO productsDTO = new ProductsDTO();

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ProductsDTO getAll() {
        if (productsDTO != null && productsDTO.getProducts() != null && !productsDTO.getProducts().isEmpty()) {
            return productsDTO;
        }
        productsDTO = getData();
        return productsDTO;
    }

    public ProductDTO getByProductName(String productName) {
        ProductDTO productDTO;
        if (productsDTO != null && productsDTO.getProducts() != null && !productsDTO.getProducts().isEmpty()) {
            productDTO = productsDTO.getProducts()
                    .stream().filter(product -> product.getProduct().equals(productName))
                    .findFirst().orElseThrow(() -> new RuntimeException("Product not found"));

        } else {
            productsDTO = getData();
            productDTO = productsDTO.getProducts().stream().filter(product -> product.getProduct().equals(productName)).findFirst().orElseThrow(() -> new RuntimeException("Product not found"));
        }

        return productDTO;

    }

    private ProductsDTO getData() {
        try {
            String productsJson = JsonReader.readJsonFromClasspath("json/products.json");
            return objectMapper.readValue(productsJson, ProductsDTO.class);
        } catch (Exception e) {
            return null;
        }

    }
}
