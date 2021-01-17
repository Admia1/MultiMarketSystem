package com.yam.multimarketsystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductExistInShop{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private Integer productId;
  private Integer quantity;
  private Integer pricePerUnit;

  private Integer shopId;
}
