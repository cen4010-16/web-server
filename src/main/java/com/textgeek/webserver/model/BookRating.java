package com.textgeek.webserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_rating")
public class BookRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(
        name = "book_id",
        referencedColumnName = "id"
    )
    private Book book;
    @ManyToOne
    @JoinColumn(
        name = "profile_id",
        referencedColumnName = "id"
    )
    private Profile profile;

    @Column(name = "rating")
    private int rating;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(final Book book) {
        this.book = book;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(final Profile profile) {
        this.profile = profile;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(final String text) {
        this.rating = rating;
    }
}
