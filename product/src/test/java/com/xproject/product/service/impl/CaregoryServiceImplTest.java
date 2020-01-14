package com.xproject.product.service.impl;

import com.xproject.product.ProductApplicationTests;
import com.xproject.product.dataobject.ProductCategory;
import com.xproject.product.service.CaregoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Component
class CaregoryServiceImplTest extends ProductApplicationTests {

    @Autowired
    private CaregoryService caregoryService;

    @Test
    void findByCategoryTypeIn() {
        List<ProductCategory> list = caregoryService.findByCategoryTypeIn(Arrays.asList(11,22));
        Assert.isTrue(list.size()>0);
    }
}