package com.textgeek.webserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WishListBookDTO {

    @JsonProperty("book_id")
    private final long book_id;
    @JsonProperty("wishlist_id")
    private final long wishlist_id;

    public WishListBookDTO(final long book_id, final long wishlist_id) {
        this.book_id = book_id;
        this.wishlist_id = wishlist_id;

    }

    public long getBookId() {
        return book_id;
    }

    public long getWishlistId() {
        return wishlist_id;
    }
}