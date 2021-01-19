package com.yam.multimarketsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;


@Entity
public class Card{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String code;

  @ManyToOne(fetch=FetchType.EAGER)
  private CardGeneration cardGeneration;

  private Boolean isDiscarded = false;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public CardGeneration getCardGeneration() {
    return cardGeneration;
  }

  public void setCardGeneration(CardGeneration cardGeneration) {
    this.cardGeneration = cardGeneration;
  }

  public Boolean getDiscarded() {
    return isDiscarded;
  }

  public void setDiscarded(Boolean discarded) {
    isDiscarded = discarded;
  }
}
