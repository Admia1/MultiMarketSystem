package com.yam.multimarketsystem.model;

import javax.persistence.*;

import java.math.BigDecimal;


@Entity
public class SalesInvoiceObject {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne(fetch=FetchType.EAGER)
  private SalesInvoice salesInvoice;

  @ManyToOne(fetch=FetchType.EAGER)
  private Product product;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public SalesInvoice getSalesInvoice() {
    return salesInvoice;
  }

  public void setSalesInvoice(SalesInvoice salesInvoice) {
    this.salesInvoice = salesInvoice;
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
