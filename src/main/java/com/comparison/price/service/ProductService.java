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
        ProductsDTO products = new ProductsDTO();
        products.setProducts(
            Arrays.asList(
                new ProductDTO("Headphones", Arrays.asList("Binglee", "DXC Electronics", "Bobay")),
                new ProductDTO("Laptop", Arrays.asList("GH Computers", "Tech city", "Ez PC")),
                new ProductDTO("Mouse", Arrays.asList("DXC Electronics", "Tech City")),
                new ProductDTO("Printer", Arrays.asList("Binglee", "DXC Electronics", "Bobay", "GH Computers"))
            ));

        return products;

    }
}
