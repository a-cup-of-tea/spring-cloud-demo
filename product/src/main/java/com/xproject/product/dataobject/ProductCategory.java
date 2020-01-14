package com.xproject.product.dataobject;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class ProductCategory {

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
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

  @Id
  @GeneratedValue
  private Integer categoryId;
  private String categoryName;
  private Integer categoryType;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;



}
