package com.example.product_app.controller;

import com.example.product_app.model.entity.Product;
import com.example.product_app.model.service.AbstractProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController
{
    @Autowired
    private AbstractProductService productService;
    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product){
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

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product){
        Product updatedProduct = productService.update(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Integer id){
        Product product = productService.findByID(id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
        productService.deleteByID(id);
        return ResponseEntity.ok("Silme İşlemi Başarılı");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Product> updateById(@PathVariable("id") Integer id, @RequestBody Product product){
        product.setProductID(id);
        Product updatedProduct = productService.update(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping(path = "/find-by-price-less-than/{price}")
    public ResponseEntity<List<Product>> findByPriceLessThan(@PathVariable("price") Double price){
        List<Product> productList = productService.findByPriceLessThan(price);
        return ResponseEntity.ok(productList);
    }

    @GetMapping(path = "/find-by-price-greater-than-equal/{price}")
    public ResponseEntity<List<Product>> findByPriceGreaterThanEqual(@PathVariable("price") Double price){
        List<Product> productList = productService.findByPriceGreaterThanEqual(price);
        return ResponseEntity.ok(productList);
    }
}
