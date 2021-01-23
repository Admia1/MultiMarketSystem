package com.yam.multimarketsystem.model;

import javax.persistence.*;

@Entity
@Table(name="person")
public class Person {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;


  //@Column(unique = true)// It look hader than what i thinked it is to handel
  private String contact;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }
}
