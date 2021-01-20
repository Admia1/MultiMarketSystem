package com.yam.multimarketsystem.model;

import javax.persistence.*;

import java.math.BigDecimal;


@Entity
public class SalesInvoice {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne(fetch=FetchType.LAZY)
  private Shop shop;

  @ManyToOne(fetch=FetchType.LAZY)
  private Cashier cashier;

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

  public Boolean getFinished() {
    return finished;
  }

  public void setFinished(Boolean finished) {
    this.finished = finished;
  }

  private Boolean finished;
}
