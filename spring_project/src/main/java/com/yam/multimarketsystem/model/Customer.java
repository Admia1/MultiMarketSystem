package com.yam.multimarketsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;


@Entity // This tells Hibernate to make a table out of this class
public class Customer {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne(fetch=FetchType.LAZY)
  private Person person;

  @OneToOne(fetch=FetchType.LAZY)
  private Card card;
}
