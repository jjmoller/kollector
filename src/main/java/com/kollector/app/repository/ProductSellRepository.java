package com.kollector.app.repository;

import com.kollector.app.model.ProductSell;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductSellRepository extends JpaRepository<ProductSell, Long> {
    List<ProductSell> findAllSellByCategory_Id(int id);

}
