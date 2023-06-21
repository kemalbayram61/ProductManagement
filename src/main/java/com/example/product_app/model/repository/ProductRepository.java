package com.example.product_app.model.repository;

import com.example.product_app.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // SELECT * FROM PRODUCTS WHERE PRICE >= ?
    List<Product> findByPriceGreaterThanEqual(double salary);

    // SELECT * FROM PRODUCTS WHERE PRICE > ?
    List<Product> findByPriceGreaterThan(double salary);
}
