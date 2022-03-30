package com.textgeek.webserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookRatingDto {

    @JsonProperty("book_id")
    private final long bookId;

    @JsonProperty("profile_id")
    private final long profileId;

    private final int rating;

    public BookRatingDto(final long bookId, final long profileId, final int rating) {
        this.bookId = bookId;
        this.profileId = profileId;
        this.rating = rating;
    }

    public long getBookId() {
        return bookId;
    }

    public long getProfileId() {
        return profileId;
    }

    public int getRating() {
        return rating;
    }
}
