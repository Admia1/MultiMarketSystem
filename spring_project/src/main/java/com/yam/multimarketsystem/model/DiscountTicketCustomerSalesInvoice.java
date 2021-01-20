package com.yam.multimarketsystem.model;

import javax.persistence.*;
@Entity
public class DiscountTicketCustomerSalesInvoice {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne(fetch=FetchType.LAZY)
  private DiscountTicket discountTicket;

  @ManyToOne(fetch=FetchType.LAZY)
  private SalesInvoice salesInvoice;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public DiscountTicket getDiscountTicket() {
    return discountTicket;
  }

  public void setDiscountTicket(DiscountTicket discountTicket) {
    this.discountTicket = discountTicket;
  }

  public SalesInvoice getSalesInvoice() {
    return salesInvoice;
  }

  public void setSalesInvoice(SalesInvoice salesInvoice) {
    this.salesInvoice = salesInvoice;
  }
}
