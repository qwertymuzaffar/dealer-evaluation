package com.comparison.price.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.comparison.price.dto.DealerDTO;
import com.comparison.price.dto.DealersDTO;
import com.comparison.price.util.JsonReader;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class DealerService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static DealersDTO dealersDTO = new DealersDTO();

    public DealersDTO getAll() {
        if (dealersDTO != null && dealersDTO.getDealers() != null && !dealersDTO.getDealers().isEmpty()) {
            return dealersDTO;
        }
        dealersDTO = getData();
        return dealersDTO;
    }


    public String getPriceByProductNameAndDealer(String productName, String dealer) {
        if (dealersDTO == null || CollectionUtils.isEmpty(dealersDTO.getDealers())) {
            dealersDTO = getData();
        }

        return dealersDTO.getDealers().stream()
                .filter(dealerDTO -> dealerDTO.getDealer().equals(dealer))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Dealer not found"))
                .getProducts().getOrDefault(productName, "Product not found");
    }

    private DealersDTO getData() {
        var dealers = new DealersDTO();
        List<DealerDTO> dealersList = Arrays.asList(
            new DealerDTO("Binglee", Map.of("Headphones", "$30", "Printer", "$75")),
            new DealerDTO("DXC Electronics", Map.of("Mouse", "$20", "Printer", "$85", "Headphones", "$20")),
            new DealerDTO("Bobay", Map.of("Headphones", "$20", "Printer", "$80")),
            new DealerDTO("Tech City", Map.of("Mouse", "$20", "Laptop", "$850")),
            new DealerDTO("Ez PC", Map.of("Laptop", "$1000")),
            new DealerDTO("GH Computers", Map.of("Laptop", "$1500", "Printer", "$95"))
        );
        dealers.setDealers(dealersList);
        return dealers;
    }

    public List<AbstractMap.SimpleEntry<String, String>> getAllProductPrices(String productName) {
        if (dealersDTO == null || CollectionUtils.isEmpty(dealersDTO.getDealers())) {
            dealersDTO = getData();
        }

        return dealersDTO.getDealers().stream()
                .filter(dealerDTO -> dealerDTO.getProducts().containsKey(productName))
                .map(dealerDTO -> new AbstractMap.SimpleEntry<>(dealerDTO.getDealer(), dealerDTO.getProducts().get(productName)))
                .toList();
    }
}
