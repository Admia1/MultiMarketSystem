package com.yam.multimarketsystem.model;

import javax.persistence.*;

@Entity
public class ScoreStrategy {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private Integer minimumPurchaseUnit;
  private Integer scorePerUnit;
  private Integer fee;

  public Integer getScoreOfPurchase(Integer purchasePrice){
    return scorePerUnit * (purchasePrice / minimumPurchaseUnit);
  }

  public Integer getFeeOfPurchase(Integer purchasePrice){
    return fee * (purchasePrice / minimumPurchaseUnit);
  }

  public Integer getId() {
    return id;
  }

  public void setMinimumPurchaseUnit(Integer minimumPurchaseUnit) {
    this.minimumPurchaseUnit = minimumPurchaseUnit;
  }

  public void setScorePerUnit(Integer scorePerUnit) {
    this.scorePerUnit = scorePerUnit;
  }

  public void setFee(Integer fee){
    this.fee=fee;
  }
}
