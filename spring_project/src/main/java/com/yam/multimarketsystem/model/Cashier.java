package com.yam.multimarketsystem.model;

import javax.persistence.*;

@Entity
public class Cashier {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne(fetch=FetchType.EAGER)
  private Person person;

  @ManyToOne(fetch=FetchType.EAGER)
  private Shop shop;

  private Boolean isDeleted = false;

  public Integer getId() {
    return id;
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

  public void delete(){
    this.isDeleted = true;
  }
}
