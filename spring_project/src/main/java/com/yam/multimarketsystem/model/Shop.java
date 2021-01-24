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

  private Integer fee = 0;




  public Integer getId() {
    return id;
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

  public Integer increaseFee(Integer increase){
    this.fee = this.fee + increase;
    return this.fee;
  }

  public Integer decreaseFee(Integer decrease){
    this.fee = this.fee - decrease;
    return this.fee;
  }

  public Integer getFee(){
    return this.fee;
  }
}
