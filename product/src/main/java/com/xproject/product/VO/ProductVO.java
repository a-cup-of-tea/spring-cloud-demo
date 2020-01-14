package com.xproject.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xproject.product.dataobject.ProductInfo;

import java.util.List;

public class ProductVO {

    @JsonProperty("name")
    private String categoryname;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    List<ProductInfoVO> productInfoVoList;

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public List<ProductInfoVO> getProductInfoVoList() {
        return productInfoVoList;
    }

    public void setProductInfoVoList(List<ProductInfoVO> productInfoVoList) {
        this.productInfoVoList = productInfoVoList;
    }
}
