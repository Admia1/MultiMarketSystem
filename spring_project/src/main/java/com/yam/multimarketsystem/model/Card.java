package com.yam.multimarketsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;


@Entity
public class Card{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String code;

  @ManyToOne(fetch=FetchType.EAGER)
  private CardGeneration cardGeneration;

  private Boolean isDiscarded = false;

}
