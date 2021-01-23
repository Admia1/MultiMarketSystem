package com.yam.multimarketsystem.model;

import javax.persistence.*;

@Entity
public class ProductExistInShop{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne(fetch=FetchType.EAGER)
  private Shop shop;

  @ManyToOne(fetch=FetchType.EAGER)
  private Product product;

  private Integer quantity;
  private Integer pricePerUnit;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Shop getShop() {
    return shop;
  }

  public void setShop(Shop shop) {
    this.shop = shop;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getPricePerUnit() {
    return pricePerUnit;
  }

  public void setPricePerUnit(Integer pricePerUnit) {
    this.pricePerUnit = pricePerUnit;
  }
}
