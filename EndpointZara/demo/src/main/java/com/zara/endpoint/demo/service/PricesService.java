package com.zara.endpoint.demo.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zara.endpoint.demo.model.Prices;
import com.zara.endpoint.demo.model.PricesResponse;
import com.zara.endpoint.demo.repository.PricesRepository;

@Service
public class PricesService {

    @Autowired
    private PricesRepository pricesRepository;

    public PricesResponse getPriceByDateAndProducgetPriceByDateBrandAndProduct(Integer brandId, Integer productId,
            String date) {
        List<Prices> lPrices = pricesRepository
                .findPricesByBrandIdAndProductIdAndDateOrderByPriorityDesc(brandId, productId, date);
        if (lPrices != null && !lPrices.isEmpty()) {
            Prices price = lPrices.get(0);
            return new PricesResponse(price.getBrandId(), price.getProductId(), price.getPriceList(),
                    price.getPrice(), Timestamp.valueOf(date));
        } else {
            return null;
        }
    }
}