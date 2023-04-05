package com.zara.endpoint.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.zara.endpoint.demo.model.PricesResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricesControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void testGetPricesFromDifferentTimes() {
        // Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1
        // (ZARA)
        String url = "/prices";
        Integer productId = 35455;
        Integer brandId = 1;
        LocalDateTime localDateTime = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = localDateTime.format(formatter);

        ResponseEntity<PricesResponse> response = restTemplate.exchange(
                url + "?brandId={brandId}&productId={productId}&date={date}",
                HttpMethod.GET,
                null,
                PricesResponse.class,
                brandId,
                productId,
                dateTime);

        PricesResponse price = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(price);
        assertEquals(35455, price.getProductId());
        assertEquals(1, price.getBrandId());
        assertEquals(1, price.getPriceList());
        assertEquals(new BigDecimal("35.50"), price.getPrice());

        // Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1
        // (ZARA)
        url = "/prices";
        localDateTime = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
        dateTime = localDateTime.format(formatter);

        response = restTemplate.exchange(
                url + "?brandId={brandId}&productId={productId}&date={date}",
                HttpMethod.GET,
                null,
                PricesResponse.class,
                brandId,
                productId,
                dateTime);

        price = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(price);
        assertEquals(35455, price.getProductId());
        assertEquals(1, price.getBrandId());
        assertEquals(2, price.getPriceList());
        assertEquals(new BigDecimal("25.45"), price.getPrice());

        // Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1
        // (ZARA)
        url = "/prices";
        localDateTime = LocalDateTime.of(2020, 6, 14, 21, 0, 0);
        dateTime = localDateTime.format(formatter);

        response = restTemplate.exchange(
                url + "?brandId={brandId}&productId={productId}&date={date}",
                HttpMethod.GET,
                null,
                PricesResponse.class,
                brandId,
                productId,
                dateTime);

        price = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(price);
        assertEquals(35455, price.getProductId());
        assertEquals(1, price.getBrandId());
        assertEquals(1, price.getPriceList());
        assertEquals(new BigDecimal("35.50"), price.getPrice());

        // Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1
        // (ZARA)
        url = "/prices";
        localDateTime = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
        dateTime = localDateTime.format(formatter);

        response = restTemplate.exchange(
                url + "?brandId={brandId}&productId={productId}&date={date}",
                HttpMethod.GET,
                null,
                PricesResponse.class,
                brandId,
                productId,
                dateTime);

        price = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(price);
        assertEquals(35455, price.getProductId());
        assertEquals(1, price.getBrandId());
        assertEquals(3, price.getPriceList());
        assertEquals(new BigDecimal("30.50"), price.getPrice());

        // Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1
        // (ZARA)
        url = "/prices";
        localDateTime = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
        dateTime = localDateTime.format(formatter);

        response = restTemplate.exchange(
                url + "?brandId={brandId}&productId={productId}&date={date}",
                HttpMethod.GET,
                null,
                PricesResponse.class,
                brandId,
                productId,
                dateTime);

        price = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(price);
        assertEquals(35455, price.getProductId());
        assertEquals(1, price.getBrandId());
        assertEquals(4, price.getPriceList());
        assertEquals(new BigDecimal("38.95"), price.getPrice());
    }
}