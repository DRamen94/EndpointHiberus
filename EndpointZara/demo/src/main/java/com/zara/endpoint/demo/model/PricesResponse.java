package com.zara.endpoint.demo.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PricesResponse {

    private Integer brandId;

    private Integer priceList;

    private Integer productId;

    private BigDecimal price;

    private Timestamp date;

    public PricesResponse(Integer brandId,  Integer productId, Integer priceList, BigDecimal price, Timestamp date) {
        this.brandId = brandId;
        this.priceList = priceList;
        this.productId = productId;
        this.price = price;
        this.date = date;
    }

    public PricesResponse() {
    }

    public Integer getBrandId() {
        return brandId;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public Integer getProductId() {
        return productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
