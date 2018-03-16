package com.lizl.eshop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lizl.eshop.mapper.ProductPriceMapper;
import com.lizl.eshop.model.ProductPrice;
import com.lizl.eshop.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by lizhaoliang on 18/2/23.
 */
@Service
public class ProductPriceServiceImpl implements ProductPriceService{

    @Autowired
    ProductPriceMapper productPriceMapper;
    @Autowired
    private JedisPool jedisPool;

    public void add(ProductPrice productPrice) {
        productPriceMapper.add(productPrice);
        Jedis jedis = jedisPool.getResource();
        jedis.set("product_price_" +productPrice.getId(), JSONObject.toJSONString(productPrice));
    }

    public void update(ProductPrice productPrice) {
        productPriceMapper.update(productPrice);
        Jedis jedis = jedisPool.getResource();
        jedis.set("product_price_" +productPrice.getId(), JSONObject.toJSONString(productPrice));
    }

    public void delete(Integer id) {
        ProductPrice productPrice = findById(id);
        productPriceMapper.delete(id);
        Jedis jedis = jedisPool.getResource();
        jedis.del("product_price_" + productPrice.getId());
    }

    public ProductPrice findById(Integer id) {
        return productPriceMapper.findById(id);
    }
}
