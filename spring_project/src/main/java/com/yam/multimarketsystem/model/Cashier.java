package com.yam.multimarketsystem.model;

import javax.persistence.*;

@Entity
public class Cashier {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne(fetch=FetchType.LAZY)
  private Person person;

  @ManyToOne(fetch=FetchType.LAZY)
  private Shop shop;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Shop getShop() {
    return shop;
  }

  public void setShop(Shop shop) {
    this.shop = shop;
  }
}
