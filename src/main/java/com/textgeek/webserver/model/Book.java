package com.textgeek.webserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
        nullable = false
    )
    private long id;

    @Column(name = "genre")
    private String genre;

    @Column(name = "copies_sold")
    private int copiesSold;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    @Override
    public String toString() {
        return "Book{" +
            "id=" + id +
            ", genre='" + genre + '\'' +
            ", copiesSold=" + copiesSold +
            '}';
    }
}
