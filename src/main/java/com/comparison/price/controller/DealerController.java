package com.comparison.price.controller;

import com.comparison.price.dto.DealersDTO;
import com.comparison.price.dto.ProductDTO;
import com.comparison.price.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dealer/api")
public class DealerController {

    @Autowired
    private DealerService dealerService;

    @GetMapping("/getAll")
    public DealersDTO getAll() {
        return dealerService.getAll();
    }


    @GetMapping("/getPriceByProductNameAndDealer/{productName}/{dealer}")
    public String getPriceByProductNameAndDealer(@PathVariable String productName, @PathVariable String dealer) {
        return dealerService.getPriceByProductNameAndDealer(productName, dealer);
    }

    @GetMapping("/getAllProductPrices/{productName}")
    public List<AbstractMap.SimpleEntry<String, String>> getAllProductPrices(@PathVariable String productName) {
        return dealerService.getAllProductPrices(productName);
    }
    
}
