package com.yam.multimarketsystem.model;

import javax.persistence.*;

@Entity
@Table(name="person")
public class Person {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;

  @Column(unique = true)
  private String contact;

  private String firstName;

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
