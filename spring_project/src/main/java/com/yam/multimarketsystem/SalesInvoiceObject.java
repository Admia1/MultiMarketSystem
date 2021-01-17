package com.yam.multimarketsystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.math.BigDecimal;


@Entity
public class SalesInvoiceObject {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private Integer sealesInvoiceId;
  private Integer productId;
  private Integer quantity; //number or weight in gram
  private Integer overAllPrice;

}
