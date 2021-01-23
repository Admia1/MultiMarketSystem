package com.yam.multimarketsystem.model;

import javax.persistence.*;


@Entity
public class Discount{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String name;

  @ManyToOne(fetch=FetchType.EAGER)
  private DiscountStrategy discountStrategy;

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

  public DiscountStrategy getDiscountStrategy() {
    return discountStrategy;
  }

  public void setDiscountStrategy(DiscountStrategy discountStrategy) {
    this.discountStrategy = discountStrategy;
  }
}
