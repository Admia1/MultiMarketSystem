package com.yam.multimarketsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ScoreStrategy {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private Integer minimumPurchaseUnit;
  private Integer scorePerUnit;

  public Integer getScoreOfPurchase(Integer purchasePrice){
    return 0;
  }

}
