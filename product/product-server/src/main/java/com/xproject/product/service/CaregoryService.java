package com.xproject.product.service;

import com.xproject.product.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 */
public interface CaregoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
