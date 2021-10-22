package com.kollector.app.repository;

import com.kollector.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Catalogue/Product repository

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory_Id(int id);

}
