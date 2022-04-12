package com.textgeek.webserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookCommentDto {

    @JsonProperty("rating_id")
    private final long ratingId;

    private final String text;

    public BookCommentDto(final long ratingId, final String text) {
        this.ratingId = ratingId;
        this.text = text;
    }

    public long getRatingId() {
        return ratingId;
    }

    public String getText() {
        return text;
    }
}
