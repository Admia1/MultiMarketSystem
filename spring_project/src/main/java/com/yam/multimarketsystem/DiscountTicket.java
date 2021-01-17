package com.yam.multimarketsystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class DiscountTicket{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private Integer userId;

  private Integer discountPreviewId;


}
