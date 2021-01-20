package com.yam.multimarketsystem.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="cardGeneration")
public class CardGeneration{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id")
  private Integer id;

  private String name;

  private Boolean isPublished = false;

  public void activate() {
    this.isPublished = true;
  }

  public Integer getId() {
    return id;
  }
  /*
  public void setId(Integer id) {
    this.id = id;
  }
  */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getPublished() {
    return isPublished;
  }
  /*
  public void setPublished(Boolean published) {
    isPublished = published;
  }
  */
}
