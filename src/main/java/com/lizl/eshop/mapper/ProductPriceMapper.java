package com.lizl.eshop.mapper;

import com.lizl.eshop.model.ProductPrice;
import org.apache.ibatis.annotations.*;

/**
 * Created by lizhaoliang on 18/2/23.
 */
@Mapper
public interface ProductPriceMapper {

    @Insert("INSERT INTO product_price(value,product_id) VALUES(#{value},#{productId})")
    public void add(ProductPrice productPrice);
    @Update("UPDATE product_price SET value=#{value},product_id=#{productId} WHERE id=#{id}")
    public void update(ProductPrice productPrice);
    @Delete("DELETE FROM product_price WHERE id=#{id}")
    public void delete(Integer id);
    @Select("SELECT * FROM product_price WHERE id=#{id}")
    public ProductPrice findById(Integer id);
    @Select("SELECT * FROM product_price WHERE product_id=#{productId} limit 1")
    @Results({
            @Result(column = "product_id", property = "productId"),
    })
    public ProductPrice findByProductId(Integer productId);
}
