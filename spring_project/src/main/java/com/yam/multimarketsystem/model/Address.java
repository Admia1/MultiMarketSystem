package com.yam.multimarketsystem.model;

import javax.persistence.*;

@Entity
public class Address {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String detail;

  @ManyToOne(fetch=FetchType.EAGER)
  private City city;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }
}
