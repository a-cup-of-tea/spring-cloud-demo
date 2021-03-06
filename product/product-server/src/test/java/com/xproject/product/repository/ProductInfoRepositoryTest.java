package com.xproject.product.repository;

import com.xproject.product.dataobject.ProductInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    void findByProductStatus() throws Exception{
        List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
        Assert.isTrue(list.size()>0);
    }

    @Test
    public void findByProductIdIn() throws Exception{
        List<ProductInfo> list = productInfoRepository.findByProductIdIn(Arrays.asList("157875196366160022","157875227953464068"));
        Assert.isTrue(list.size()>0);
    }
}