package com.textgeek.webserver.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name="genre")
  private String genre;

  public long getId(){
    return id;
  }

  public void setId(long id){
    this.id = id;
  }

  public String getGenre(){
    return genre;
  }

  public void setGenre(String genre){
    this.genre = genre;
  }

}
