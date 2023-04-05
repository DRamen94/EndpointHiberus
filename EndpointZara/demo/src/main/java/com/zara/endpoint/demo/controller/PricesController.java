package com.zara.endpoint.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zara.endpoint.demo.model.PricesResponse;
import com.zara.endpoint.demo.service.PricesService;

@RestController
@RequestMapping("/prices")
public class PricesController {

	@Autowired
	PricesService pricesService;

	@GetMapping
	public ResponseEntity<PricesResponse> getPriceByDateBrandAndProduct(
			@RequestParam("brandId") Integer brandId, @RequestParam("productId") Integer productId,
			@RequestParam("date") String date) {
		PricesResponse pricesResponse = pricesService.getPriceByDateAndProducgetPriceByDateBrandAndProduct(brandId,productId,date);
		if(pricesResponse != null){
			return ResponseEntity.ok(pricesResponse);
		}else{
			return ResponseEntity.notFound().build();
		}
	}
}
