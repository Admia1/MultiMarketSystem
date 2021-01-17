package com.yam.multimarketsystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import java.math.BigDecimal;

@Entity
public class SalesInvoice {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private Integer shopId;
  private Integer cashierId;
  private Integer userId;

}
