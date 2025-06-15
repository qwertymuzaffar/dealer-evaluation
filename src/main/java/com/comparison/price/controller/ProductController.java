package com.comparison.price.controller;

import com.comparison.price.dto.ProductDTO;
import com.comparison.price.dto.ProductsDTO;
import com.comparison.price.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public ProductsDTO getAll() {
        return productService.getAll();
    }

    @GetMapping("/getByProductName/{productName}")
    public ProductDTO getByProductName(@PathVariable String productName) {
        return productService.getByProductName(productName);
    }


}
