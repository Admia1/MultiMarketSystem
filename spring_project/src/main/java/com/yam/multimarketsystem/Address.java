package com.yam.multimarketsystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;

@Entity
public class Address {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String detail;

  @ManyToOne(fetch=FetchType.LAZY)
  private City city;


}
