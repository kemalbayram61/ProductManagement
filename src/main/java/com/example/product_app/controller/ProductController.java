package com.example.product_app.controller;

import com.example.product_app.model.entity.Product;
import com.example.product_app.model.service.AbstractProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController
{
    @Autowired
    private AbstractProductService productService;
    @PostMapping
    public ResponseEntity<Product> save(Product product){
        product.setCreatedDate(new Date());
        Product savedProduct = productService.save(product);
        if (savedProduct != null) return ResponseEntity.ok(savedProduct);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> productList = productService.getAll();
        return ResponseEntity.ok(productList);
    }
}
