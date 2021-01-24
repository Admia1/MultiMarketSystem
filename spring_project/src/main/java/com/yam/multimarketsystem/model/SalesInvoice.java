package com.yam.multimarketsystem.model;

import javax.persistence.*;

import java.math.BigDecimal;


@Entity
public class SalesInvoice {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne(fetch=FetchType.EAGER)
  private Shop shop;

  @ManyToOne(fetch=FetchType.EAGER)
  private Cashier cashier;

  private Boolean isFinished = false;
  private Boolean isDeleted = false;

  public Boolean finish(){
    if (this.isDeleted)
      return false;
    this.isFinished = true;
    return true;
  }

  public Boolean delete(){
    if (this.isFinished)
      return false;
    this.isDeleted = true;
    return true;
  }

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

  public Cashier getCashier() {
    return cashier;
  }

  public void setCashier(Cashier cashier) {
    this.cashier = cashier;
  }

}
