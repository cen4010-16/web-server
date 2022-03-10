package com.textgeek.webserver.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "shopping_cart")

public class ShoppingCart {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(

        nullable = false

    )

    private long id;

    @OneToOne

    @JoinColumn(

        name = "profile_id",

        referencedColumnName = "id"

    )
    private Profile profile;

    @ManyToMany

    @JoinTable(

        name = "shopping_cart_books",

        joinColumns = @JoinColumn(name = "shopping_cart_id"),

        inverseJoinColumns = @JoinColumn(name = "book_id"))

    private List<Book> book;

    public long getId() {

        return id;

    }

    public void setId(long id) {

        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }


}
