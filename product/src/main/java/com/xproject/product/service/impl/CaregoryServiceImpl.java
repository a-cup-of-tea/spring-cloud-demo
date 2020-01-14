package com.xproject.product.service.impl;

import com.xproject.product.dataobject.ProductCategory;
import com.xproject.product.repository.ProductCategoryRepository;
import com.xproject.product.service.CaregoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaregoryServiceImpl implements CaregoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
