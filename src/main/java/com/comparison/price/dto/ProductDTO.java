package com.comparison.price.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProductDTO {
    private String product;

    @JsonProperty("Dealers")
    private List<String> dealers;

    public ProductDTO() {
        
    }

    public ProductDTO(String product, List<String> dealers) {
        this.product = product;
        this.dealers = dealers;
    }

    // Getters and Setters
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public List<String> getDealers() {
        return dealers;
    }

    public void setDealers(List<String> dealers) {
        this.dealers = dealers;
    }
}