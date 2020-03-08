package com.xproject.product.service.impl;

import com.netflix.discovery.converters.Auto;
import com.xproject.product.dataobject.ProductInfo;
import com.xproject.product.enums.ProductStatusEnum;
import com.xproject.product.repository.ProductInfoRepository;
import com.xproject.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {

        return productInfoRepository.findByProductIdIn(productIdList);
    }
}
