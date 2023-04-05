package com.zara.endpoint.demo.repository;

import com.zara.endpoint.demo.model.*;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PricesRepository extends JpaRepository<Prices, Long> {

    @Query(value="SELECT * FROM Prices WHERE product_Id = :productId AND brand_Id = :brandId AND :date BETWEEN start_Date AND end_Date ORDER BY priority DESC", nativeQuery = true)
    List<Prices>findPricesByBrandIdAndProductIdAndDateOrderByPriorityDesc(@Param("brandId") Integer brandId,
                                                        @Param("productId") Integer productId,
                                                        @Param("date") String date);

}