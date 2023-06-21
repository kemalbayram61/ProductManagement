package com.example.product_app.model.service;

import com.example.product_app.model.entity.Product;
import com.example.product_app.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractProductService implements EntityService<Product, Integer>{
    @Autowired
    protected ProductRepository productRepository;

    public abstract List<Product> findByPriceGreaterThanEqual(double price);

    public abstract List<Product> findByPriceLessThan(double price);
}
