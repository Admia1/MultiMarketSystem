package com.yam.multimarketsystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class DiscountPreview {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String name;

  private Integer discountId;

  private Integer limitToBuy;
  //how many discount tickers to sell

  private Integer price;


}
