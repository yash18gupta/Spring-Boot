package com.geeksforgeeks.SpringBoot_Redis.repo;

import com.geeksforgeeks.SpringBoot_Redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAORepo {

    private static final String HASH_KEY = "JBDL60_Product";

    @Autowired
    private RedisTemplate<String, Object> template;

    public Product save(Product product) {
        template.opsForHash().put(HASH_KEY, product.getId()	, product);
        return product;
    }

    public List<Object> getAll(){
        return template.opsForHash().values(HASH_KEY);
    }
}
