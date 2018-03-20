package com.lizl.eshop.service;

import com.lizl.eshop.model.ProductPrice;

/**
 * Created by lizhaoliang on 18/2/23.
 */
public interface ProductPriceService {

    public void add(ProductPrice productPrice);

    public void update(ProductPrice productPrice);

    public void delete(Integer id);

    public ProductPrice findById(Integer id);

    public ProductPrice findByProductId(Integer productId);
}
