package com.yam.multimarketsystem.model;

import javax.persistence.*;


@Entity
public class DiscountPreview {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String name;

  @ManyToOne(fetch=FetchType.EAGER)
  private Discount discount;

  private Integer limitToBuy;
  //how many discount tickers to sell

  private Integer price;

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Discount getDiscount() {
    return discount;
  }

  public void setDiscount(Discount discount) {
    this.discount = discount;
  }

  public Integer getLimitToBuy() {
    return limitToBuy;
  }

  public void setLimitToBuy(Integer limitToBuy) {
    this.limitToBuy = limitToBuy;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }
}
