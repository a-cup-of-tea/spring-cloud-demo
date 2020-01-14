package com.xproject.product.repository;

import com.xproject.product.dataobject.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Test
    void findByCategoryTypeIn() {
        List<ProductCategory> list = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(11,12));
        Assert.isTrue(list.size()>0);
    }
}