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
  private ProductExistInShop productExistInShop;

  private Integer quantity; //number or weight in gram

  private Integer overAllPrice;

  private Boolean isDeleted = false;

  public void delete(){
    this.isDeleted = true;
  }
  public Integer getId() {
    return id;
  }

  public SalesInvoice getSalesInvoice() {
    return salesInvoice;
  }

  public void setSalesInvoice(SalesInvoice salesInvoice) {
    this.salesInvoice = salesInvoice;
  }

  public ProductExistInShop getProductExistInShop() {
    return productExistInShop;
  }

  public void setProductExistInShop(ProductExistInShop productExistInShop) {
    this.productExistInShop = productExistInShop;
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

}
