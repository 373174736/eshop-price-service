package com.lizl.eshop.web.controller;

import com.lizl.eshop.model.ProductPrice;
import com.lizl.eshop.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhaoliang on 18/2/23.
 */
@RequestMapping("/product-price")
@RestController
public class ProductPriceController {

    @Autowired
    ProductPriceService productPriceService;

    @RequestMapping("/add")
    @ResponseBody
    public String add(ProductPrice productPrice){
        productPriceService.add(productPrice);
        return "sucess";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(ProductPrice productPrice){
        productPriceService.update(productPrice);
        return "sucess";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id){
        try {
            productPriceService.delete(id);
            return "sucess";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("findById")
    @ResponseBody
    public ProductPrice findById(Integer id){
        try {
            return  productPriceService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ProductPrice();
    }
}
