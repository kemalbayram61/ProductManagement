package com.example.product_app.model.service;

import com.example.product_app.model.entity.Product;
import com.example.product_app.utility.Util;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductService extends AbstractProductService{
    @Override
    public List<Product> findByPriceGreaterThanEqual(double price) {
        try{
            return productRepository.findByPriceGreaterThanEqual(price);
        }catch (IllegalArgumentException illegalArgumentException){
            Util.showGeneralException(illegalArgumentException);
        }catch (Exception exception){
            Util.showGeneralException(exception);
        }
        return null;
    }

    @Override
    public List<Product> findByPriceLessThan(double price) {
        try{
            return productRepository.findByPriceLessThan(price);
        }catch (IllegalArgumentException illegalArgumentException){
            Util.showGeneralException(illegalArgumentException);
        }catch (Exception exception){
            Util.showGeneralException(exception);
        }
        return null;
    }

    @Override
    public Product findByID(Integer id) {
        try {
            return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product Entity is not found."));
        }catch (EntityNotFoundException entityNotFoundException){
            Util.showGeneralException(entityNotFoundException);
        }catch (NullPointerException nullPointerException){
            Util.showGeneralException(nullPointerException);
        }catch (IllegalArgumentException illegalArgumentException){
            Util.showGeneralException(illegalArgumentException);
        }catch (Exception exception){
            Util.showGeneralException(exception);
        }
        return null;
    }

    @Override
    public Product update(Product object) {
        Product productFound = this.findByID(object.getProductID());
        if(productFound != null)
        {
            productFound.setName(object.getName() != null ? object.getName() : productFound.getName());
            productFound.setCategory(object.getCategory() != null ? object.getCategory() : productFound.getCategory());
            productFound.setDescription(object.getDescription() != null ? object.getDescription() : productFound.getDescription());
            productFound.setPrice(object.getPrice() != null ? object.getPrice() : productFound.getPrice());
        }
        return this.save(productFound);
    }

    @Override
    public void deleteByID(Integer id) {
        try{
            productRepository.deleteById(id);
        }catch (IllegalArgumentException illegalArgumentException){
            Util.showGeneralException(illegalArgumentException);
        }catch (Exception exception){
            Util.showGeneralException(exception);
        }
    }

    @Override
    public List<Product> getAll() {
        try{
            return productRepository.findAll();
        }catch (Exception exception){
            Util.showGeneralException(exception);
        }
        return null;
    }

    @Override
    public Product save(Product object) {
        try{
            return productRepository.save(object);
        }catch (IllegalArgumentException illegalArgumentException)
        {
            Util.showGeneralException(illegalArgumentException);
        }catch (OptimisticLockingFailureException optimisticLockingFailureException)
        {
            Util.showGeneralException(optimisticLockingFailureException);
        }catch (Exception exception)
        {
            Util.showGeneralException(exception);
        }
        return null;
    }
}
