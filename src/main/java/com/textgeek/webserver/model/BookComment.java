package com.textgeek.webserver.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "book_comment")
public class BookComment {

    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date created;
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
    @Column(name = "text")
    private String text;

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

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(final Date created) {
        this.created = created;
    }


    @Override
    public String toString() {
        return "BookComment{" +
            "id=" + id +
            ", book=" + book +
            ", profile=" + profile +
            ", text='" + text + '\'' +
            ", created=" + created +
            '}';
    }
}
