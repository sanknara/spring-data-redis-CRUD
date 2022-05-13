package com.sankar.redis.repository;

import com.sankar.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    
    private static final String HASH_KEY="Product";
    
    // To access the redis server:
    @Autowired
    private RedisTemplate template;
    
    public Product save(Product product){
        template.opsForHash().put(HASH_KEY,
                product.getId(), product);
        return product;
    }
    
    public List<Product> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }
    
    public Product findProductById(int id){
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }
    
    public String deleteProductById(int id){
        template.opsForHash().delete(HASH_KEY, id);
        return "Product "+id+" removed";
    }
    
}
