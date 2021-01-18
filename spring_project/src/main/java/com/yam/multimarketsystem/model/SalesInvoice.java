package com.yam.multimarketsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.math.BigDecimal;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;


@Entity
public class SalesInvoice {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne(fetch=FetchType.LAZY)
  private Shop shop;

  @ManyToOne(fetch=FetchType.LAZY)
  private Cashier cashier;

  private Boolean finished;
}
