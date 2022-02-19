package com.textgeek.webserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookCommentDto {

    @JsonProperty("book_id")
    private final long bookId;

    @JsonProperty("profile_id")
    private final long profileId;

    private final String text;

    public BookCommentDto(final long bookId, final long profileId, final String text) {
        this.bookId = bookId;
        this.profileId = profileId;
        this.text = text;
    }

    public long getBookId() {
        return bookId;
    }

    public long getProfileId() {
        return profileId;
    }

    public String getText() {
        return text;
    }
}
