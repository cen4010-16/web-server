package com.textgeek.webserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingCartDTO {

@JsonProperty("book_id")
    private final long book_id;
@JsonProperty("id")
    private final long shopping_cart_id;

    public ShoppingCartDTO(long book_id, long shopping_cart_id){
        this.book_id = book_id;
        this.shopping_cart_id = shopping_cart_id;
    }

    public long getBook_id() {
        return book_id;
    }

    public long getShopping_cart_id() {
        return shopping_cart_id;
    }

}