package com.xproject.product.service.impl;

import com.xproject.product.ProductApplication;
import com.xproject.product.ProductApplicationTests;
import com.xproject.product.dataobject.ProductInfo;
import com.xproject.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Component
class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    void findUpAll() throws Exception{
        List<ProductInfo> list = productService.findUpAll();
        Assert.isTrue(list.size()>0);
    }
}