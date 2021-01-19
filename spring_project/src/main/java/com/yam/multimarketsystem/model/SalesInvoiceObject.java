package com.yam.multimarketsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.math.BigDecimal;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;


@Entity
public class SalesInvoiceObject {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne(fetch=FetchType.LAZY)
  private SalesInvoice sealesInvoice;

  @ManyToOne(fetch=FetchType.LAZY)
  private Product product;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public SalesInvoice getSealesInvoice() {
    return sealesInvoice;
  }

  public void setSealesInvoice(SalesInvoice sealesInvoice) {
    this.sealesInvoice = sealesInvoice;
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

  public Integer getOverAllPrice() {
    return overAllPrice;
  }

  public void setOverAllPrice(Integer overAllPrice) {
    this.overAllPrice = overAllPrice;
  }

  private Integer quantity; //number or weight in gram
  private Integer overAllPrice;

}
