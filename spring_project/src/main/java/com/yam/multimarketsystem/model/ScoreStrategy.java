package com.yam.multimarketsystem.model;

import javax.persistence.*;

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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getMinimumPurchaseUnit() {
    return minimumPurchaseUnit;
  }

  public void setMinimumPurchaseUnit(Integer minimumPurchaseUnit) {
    this.minimumPurchaseUnit = minimumPurchaseUnit;
  }

  public Integer getScorePerUnit() {
    return scorePerUnit;
  }

  public void setScorePerUnit(Integer scorePerUnit) {
    this.scorePerUnit = scorePerUnit;
  }
}
