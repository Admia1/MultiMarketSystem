package com.yam.multimarketsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import java.math.BigDecimal;

@Entity
public class DiscountStrategy {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String name;

  private Integer discountPrice;


  // public BigDecimal calculatePrice(BigDecimal currentPrice){
  //   BigDecimal new_price = currentPrice - this.discountPrice;
    //
    // if (new_price < 0)
    //   new_price = 0;
    //
    // return new_price;
  // }


  public Integer calculatePrice(Integer currentPrice){
    Integer new_price = currentPrice - this.discountPrice;

    if (new_price < 0)
      new_price = 0;

    return new_price;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getDiscountPrice() {
    return discountPrice;
  }

  public void setDiscountPrice(Integer discountPrice) {
    this.discountPrice = discountPrice;
  }
}
