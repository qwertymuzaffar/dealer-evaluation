package com.comparison.price.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class DealerDTO {

    @JsonProperty("Dealer")
    private String dealer;

    private Map<String, String> products;

    public DealerDTO() {
        
    }

    public DealerDTO(String dealer, Map<String, String> products) {
        this.dealer = dealer;
        this.products = products;
    }

    // Getters and Setters
    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public Map<String, String> getProducts() {
        return products;
    }

    public void setProducts(Map<String, String> products) {
        this.products = products;
    }
}