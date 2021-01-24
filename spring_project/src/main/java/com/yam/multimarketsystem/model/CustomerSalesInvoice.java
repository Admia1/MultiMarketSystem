package com.yam.multimarketsystem.model;

import javax.persistence.*;

@Entity
public class CustomerSalesInvoice {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne(fetch=FetchType.EAGER)
  private Customer customer;

  @ManyToOne(fetch=FetchType.EAGER)
  private SalesInvoice salesInvoice;

  @ManyToOne(fetch=FetchType.EAGER)
  private ScoreStrategy scoreStrategy;

  public Integer getId() {
    return id;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public SalesInvoice getSalesInvoice() {
    return salesInvoice;
  }

  public void setSalesInvoice(SalesInvoice salesInvoice) {
    this.salesInvoice = salesInvoice;
  }

  public void setScoreStrategy(ScoreStrategy scoreStrategy){
    this.scoreStrategy = scoreStrategy;
  }

  public ScoreStrategy getScoreStrategy(){
    return scoreStrategy;
  }
}
