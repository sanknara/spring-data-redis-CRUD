package com.sankar.redis.controller;

import com.sankar.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sankar.redis.repository.ProductDao;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductDao productDao;
    
    @PostMapping
    public Product save(@RequestBody Product product){
        return productDao.save(product);
    }
    
    @GetMapping
    public List<Product> getAllProducts(){
        return productDao.findAll();
    } 
    
    @GetMapping("/{id}")
    public Product findProduct(@PathVariable int id){
        return productDao.findProductById(id);
    }
    
    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id){
        return productDao.deleteProductById(id);
    }
}
