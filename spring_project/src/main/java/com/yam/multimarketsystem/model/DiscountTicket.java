package com.yam.multimarketsystem.model;

import javax.persistence.*;


@Entity
public class DiscountTicket{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne(fetch=FetchType.LAZY)
  private User user;

  @ManyToOne(fetch=FetchType.LAZY)
  private DiscountPreview discountPreview;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public DiscountPreview getDiscountPreview() {
    return discountPreview;
  }

  public void setDiscountPreview(DiscountPreview discountPreview) {
    this.discountPreview = discountPreview;
  }
}
