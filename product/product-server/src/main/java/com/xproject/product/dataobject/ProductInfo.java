package com.xproject.product.dataobject;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class ProductInfo {

  /**
   * 产品ID
   */
  @Id
  private String productId;
  /**
   * 产品名称
   */
  private String productName;
  /**
   * 产品单价
   */
  private BigDecimal productPrice;
  /**
   * 产品库存
   */
  private Integer productStock;
  /**
   * 产品描述
   */
  private String productDescription;
  /**
   * 产品略缩图
   */
  private String productIcon;
  /**
   * 产品状态，0正常，1下架
   */
  private Integer productStatus;
  /**
   * 产品编号
   */
  private Integer categoryType;
  /**
   * 创建时间
   */
  private java.sql.Timestamp createTime;
  /**
   * 更新时间
   */
  private java.sql.Timestamp updateTime;

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public BigDecimal getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(BigDecimal productPrice) {
    this.productPrice = productPrice;
  }

  public Integer getProductStock() {
    return productStock;
  }

  public void setProductStock(Integer productStock) {
    this.productStock = productStock;
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public String getProductIcon() {
    return productIcon;
  }

  public void setProductIcon(String productIcon) {
    this.productIcon = productIcon;
  }

  public Integer getProductStatus() {
    return productStatus;
  }

  public void setProductStatus(Integer productStatus) {
    this.productStatus = productStatus;
  }

  public Integer getCategoryType() {
    return categoryType;
  }

  public void setCategoryType(Integer categoryType) {
    this.categoryType = categoryType;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime = updateTime;
  }
}
