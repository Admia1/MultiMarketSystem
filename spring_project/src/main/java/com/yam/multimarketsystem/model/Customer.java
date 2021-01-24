package com.yam.multimarketsystem.model;

import javax.persistence.*;


@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne(fetch=FetchType.EAGER)
  private Person person;

  @OneToOne(fetch=FetchType.EAGER)
  private Card card;

  private Integer score=0;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Card getCard() {
    return card;
  }

  public void setCard(Card card) {
    this.card = card;
  }

  public Integer increaseScore(Integer increase){
    this.score = this.score + increase;
    return this.score;
  }

  public Integer decreaseScore(Integer decrease){
    this.score = this.score - decrease;
    return this.score;
  }

  public Integer getScore(){
    return this.score;
  }
}
