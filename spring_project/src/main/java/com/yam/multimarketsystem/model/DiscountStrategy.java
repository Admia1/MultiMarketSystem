package com.yam.multimarketsystem.model;

import javax.persistence.*;

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
