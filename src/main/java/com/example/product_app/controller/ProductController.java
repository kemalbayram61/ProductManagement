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
        if (productList.size() != 0)
            return ResponseEntity.ok(productList);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product){
        Product updatedProduct = productService.update(product);
        if(updatedProduct != null)
            return ResponseEntity.ok(updatedProduct);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Integer id){
        Product product = productService.findByID(id);
        if(product != null)
            return ResponseEntity.ok(product);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
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
        if(updatedProduct != null)
            return ResponseEntity.ok(updatedProduct);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @GetMapping(path = "/find-by-price-less-than/{price}")
    public ResponseEntity<List<Product>> findByPriceLessThan(@PathVariable("price") Double price){
        List<Product> productList = productService.findByPriceLessThan(price);
        if (productList.size() != 0)
            return ResponseEntity.ok(productList);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(path = "/find-by-price-greater-than-equal/{price}")
    public ResponseEntity<List<Product>> findByPriceGreaterThanEqual(@PathVariable("price") Double price){
        List<Product> productList = productService.findByPriceGreaterThanEqual(price);
        if (productList.size() != 0)
            return ResponseEntity.ok(productList);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
