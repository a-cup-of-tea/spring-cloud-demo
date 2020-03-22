package com.xproject.product.service.impl;

import com.xproject.product.ProductApplicationTests;
import com.xproject.product.dto.CartDTO;
import com.xproject.product.dataobject.ProductInfo;
import com.xproject.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

@Component
class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    void findUpAll() throws Exception{
        List<ProductInfo> list = productService.findUpAll();
        Assert.isTrue(list.size()>0);
    }

    @Test
    void findList() throws Exception{
        List<ProductInfo> list = productService.findList(Arrays.asList("157875196366160022","157875227953464068"));
        Assert.isTrue(list.size()>0);
    }

    @Test
    void decreaseStock() throws Exception{
        CartDTO cartDTO = new CartDTO("157875196366160022",2);
        productService.decreaseStock(Arrays.asList(cartDTO));
    }
}