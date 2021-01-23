package com.yam.multimarketsystem.model;

import javax.persistence.*;


@Entity
public class DiscountTicket{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne(fetch=FetchType.EAGER)
  private Customer customer;

  @ManyToOne(fetch=FetchType.EAGER)
  private DiscountPreview discountPreview;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public DiscountPreview getDiscountPreview() {
    return discountPreview;
  }

  public void setDiscountPreview(DiscountPreview discountPreview) {
    this.discountPreview = discountPreview;
  }
}
