package com.yam.multimarketsystem.model;

import javax.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name="card")
public class Card{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id")
  private Integer id;

  private String code;

  // @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
  // @JoinColumn(name = "cardGeneration_id)
  @ManyToOne(fetch=FetchType.EAGER)
  private CardGeneration cardGeneration;

  private Boolean isDiscarded = false;

  public void discard(){
    this.isDiscarded = true;
  }
  public Integer getId() {
    return id;
  }
  /*
  public void setId(Integer id) {
    this.id = id;
  }
  */
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
  /*
  public void setDiscarded(Boolean discarded) {
    isDiscarded = discarded;
  }
  */
}
