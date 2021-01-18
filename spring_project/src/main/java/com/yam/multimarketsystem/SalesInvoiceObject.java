package com.yam.multimarketsystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.math.BigDecimal;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;


@Entity
public class SalesInvoiceObject {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne(fetch=FetchType.LAZY)
  private SalesInvoice sealesInvoice;

  @ManyToOne(fetch=FetchType.LAZY)
  private Product product;

  private Integer quantity; //number or weight in gram
  private Integer overAllPrice;

}
