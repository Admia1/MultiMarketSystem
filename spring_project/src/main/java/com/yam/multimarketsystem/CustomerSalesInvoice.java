package com.yam.multimarketsystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerSalesInvoice {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private Integer customerId;

  private Integer salesInvoiceId;

}
