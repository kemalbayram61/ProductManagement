package com.example.product_app.model.service;

import com.example.product_app.model.entity.Product;

import java.util.List;

public class ProductService extends AbstractProductService{
    @Override
    public List<Product> findByPriceGreaterThanEqual(double price) {
        return null;
    }

    @Override
    public List<Product> findByPriceLessThan(double price) {
        return null;
    }

    @Override
    public Product findByID(Integer id) {
        return null;
    }

    @Override
    public Product update(Product object) {
        return null;
    }

    @Override
    public void deleteByID(Integer id) {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product save(Product object) {
        return null;
    }
}
