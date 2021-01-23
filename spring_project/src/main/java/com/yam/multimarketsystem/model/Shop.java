package com.yam.multimarketsystem.model;

import javax.persistence.*;


@Entity // This tells Hibernate to make a table out of this class
public class Shop {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String name;

  @ManyToOne(fetch=FetchType.EAGER)
  private Address address;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
